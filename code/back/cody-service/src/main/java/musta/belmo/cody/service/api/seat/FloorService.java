package musta.belmo.cody.service.api.seat;

import musta.belmo.cody.model.FloorDTO;

import java.util.Optional;

public interface FloorService {
	
	Optional<FloorDTO> findOne(Long floorId);
	
	void create(FloorDTO floorDTO);
	
	
}
