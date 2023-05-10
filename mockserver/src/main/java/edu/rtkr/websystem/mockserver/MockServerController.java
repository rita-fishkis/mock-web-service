package edu.rtkr.websystem.mockserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MockServerController {
	@Autowired
	DeviceEntityRepository repository;

	@GetMapping("/device/{id}")
	DeviceEntity read (@PathVariable Long id) {	    
	    return repository.find(id);
	}
	
	@PostMapping("/device/new")
	DeviceEntity read (@RequestBody String name) {	    
	    return repository.saveOrUpdate(null, name, 0, DeviceState.NOT_AKTIV);
	}
	
	@PostMapping("/device/{id}/state/{state}")
	DeviceEntity setState (@PathVariable Long id, @PathVariable String state) {	    
	    return repository.setState(id, state);
	}
	
}
