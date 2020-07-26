package musta.belmo.cody.service.api.seat;

import musta.belmo.cody.model.RoomDTO;

import java.util.List;
import java.util.Optional;

public interface RoomService {
    
    
    Optional<RoomDTO> findOne(Long roomId);
    
    List<RoomDTO> getAllRoomsAtFloor(Long floorId);
    
    void create(RoomDTO room);
	
	void createAtFloor(RoomDTO room, Long floorId);
}
