package edu.rtkr.websystem.mockserver;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;

public class DeviceEntityRepository {
	Map<Long, DeviceEntity> repository = new HashMap<>();
	private long currentId = 0;
	
	DeviceEntity saveOrUpdate(DeviceEntity entity) {
		if (entity == null ) {
			return null;
		}
		if (entity.getId() == null) {
			Long id = currentId ++;
			entity.setId(id);
		}
		repository.put(entity.getId(), entity);
		return entity;
	}
	
	DeviceEntity saveOrUpdate(Long id, String name, double wert, DeviceState state) {
		return saveOrUpdate(new DeviceEntity(id, name, wert, state));
	}
	
	DeviceEntity save(String name) {
		return saveOrUpdate(new DeviceEntity(null, name, 0.0, DeviceState.NOT_AKTIV));
	}
	
	DeviceEntity find(Long id) {
		if (repository.containsKey(id)) {
			return repository.get(id);
		}
		return null;
	}
	
	DeviceEntity setState(Long id, String state) {
		if (!repository.containsKey(id) ) {
			throw new HttpClientErrorException(HttpStatus.I_AM_A_TEAPOT);
		}
		try {
			DeviceEntity entity = repository.get(id);
			entity.setState(DeviceState.from(state));
			return entity;
		}
		catch (IllegalArgumentException iae) {
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST);
		}
	}
	
	void updateValue(Long id, double addWert) {
		if (repository.containsKey(id)) {
			repository.get(id).updateWert(addWert);
		}
	}
	
	void updateValue(double addWert) {
		for (DeviceEntity entity : repository.values()) {
			entity.updateWert(addWert);
		}
	}
	
	
}
