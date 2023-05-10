package edu.rtkr.websystem.mockserver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {
	private static final Logger log = LoggerFactory.getLogger(BeanConfiguration.class);

	@Bean 
	DeviceEntityRepository getDeviceEntityRepository() {
		return new DeviceEntityRepository();
	}
	  @Bean
	  CommandLineRunner initDatabase(DeviceEntityRepository repository) {

	    return args -> {
	      log.info("Preloading " + repository.save("A Linkoln"));
	      log.info("Preloading " + repository.save("G Washington"));
	      log.info("Preloading " + repository.save("L Nelson"));
	    };
	  }
}
