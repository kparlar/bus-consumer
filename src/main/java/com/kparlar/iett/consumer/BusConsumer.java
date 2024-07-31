package com.kparlar.iett.consumer;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kparlar.iett.consumer.entity.MessageLineEntity;
import com.kparlar.iett.consumer.repository.MessageLineRepository;
import lombok.Builder;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.List;
import java.util.function.Consumer;

@Slf4j
@SpringBootApplication
public class BusConsumer {
	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private MessageLineRepository messageLineRepository;

	public static void main(String[] args) {
		SpringApplication.run(BusConsumer.class, args);
	}



	/*// Processor will fetch data from one topic perfom its logic and then send new topic
	@Bean
	public Function<String, String> processorBinding(){
		return s -> s +" :: "+ System.currentTimeMillis();
	}

	@Bean
	public Consumer<String> consumerBinding(){
		return s -> System.out.println("Data consumed :: " + s.toUpperCase());
	}*/
	//@SneakyThrows
	@Bean
	public Consumer<MessageDTO> lineConsumer(){
		return messageDTO -> {
			messageDTO.id();
			Date date = new Date();
			var messageLineEntity =  MessageLineEntity.builder().messageLineId(messageDTO.id).message(messageDTO.message).update(date).status("PROCESSED").build();
			try{
				messageLineRepository.upsert(messageLineEntity);
			}catch (Exception ex){
				log.error("Exception: ", ex);
			}

		};

	}

	@Builder(toBuilder = true)
	public record MessageDTO(String id, String message){}

}
