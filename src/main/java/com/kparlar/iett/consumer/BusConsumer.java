package com.kparlar.iett.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BusConsumer {

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
}
