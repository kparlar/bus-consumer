package com.kparlar.iett;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kparlar.iett.dto.LineDTO;
import com.kparlar.iett.entity.MessageLineEntity;
import com.kparlar.iett.entity.enums.MesssageLineStatus;
import com.kparlar.iett.repository.LineRepository;
import com.kparlar.iett.repository.MessageLineRepository;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.function.Consumer;

@Slf4j
@SpringBootApplication
@ComponentScan(basePackages = "com.kparlar.iett")
public class BusConsumer {
	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private MessageLineRepository messageLineRepository;
	@Autowired
	private LineRepository lineRepository;

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
	@Transactional(rollbackFor = RuntimeException.class) //TODO This is not working will check
	public Consumer<MessageDTO> lineConsumer(){
		return messageDTO -> {
			messageDTO.id();
			Date date = new Date();
			try{
				JsonNode jsonNode = objectMapper.readTree(messageDTO.message());
				var messageLineEntity =  MessageLineEntity.builder()
						.messageLineId(messageDTO.id())
						.message(jsonNode)
						.update(date)
						.status(MesssageLineStatus.CONSUMED.getValue())
						.build();
				messageLineRepository.upsert(messageLineEntity);
				var lineDTOs = objectMapper.readValue(messageDTO.message(),new TypeReference<List<LineDTO>>(){});
				var lineEntities = lineDTOs.stream()
						.map(LineDTO::toEntity)
						.map(lineEntity -> lineEntity.toBuilder().messageLineId(messageDTO.id()).createDate(date).update(date).build())
						.toList();
				lineRepository.upsertAll(lineEntities);
				log.info("Consumed: {}",messageDTO.id());
			}catch (Exception ex){
				log.error("Exception: ", ex);
				throw new RuntimeException(ex);
			}

		};

	}

	@Builder(toBuilder = true)
	public record MessageDTO(String id, String message){}

}
