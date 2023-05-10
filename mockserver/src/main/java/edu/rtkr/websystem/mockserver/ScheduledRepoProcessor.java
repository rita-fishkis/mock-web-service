package edu.rtkr.websystem.mockserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledRepoProcessor {
	private static final double ADD_WERT = 0.42;

	@Autowired
	DeviceEntityRepository repository; 
	
	@Scheduled(fixedRate = 5000)
	void updateWerte() {
		repository.updateValue(ADD_WERT);
	}

}
