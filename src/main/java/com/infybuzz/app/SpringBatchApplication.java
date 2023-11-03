package com.infybuzz.app;

import com.infybuzz.config.BatchConfig;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@EnableBatchProcessing
@Import(BatchConfig.class)
@ComponentScan({"com.infybuzz.config", "com.infybuzz.service",
	"com.infybuzz.listener", "com.infybuzz.reader", "com.infybuzz.processor", 
	"com.infybuzz.writer"})
public class SpringBatchApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBatchApplication.class, args);
	}

}
