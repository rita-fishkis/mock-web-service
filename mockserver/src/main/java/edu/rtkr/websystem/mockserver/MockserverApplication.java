package edu.rtkr.websystem.mockserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MockserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(MockserverApplication.class, args);
	}

}
