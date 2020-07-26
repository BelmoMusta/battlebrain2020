package musta.belmo.cody.dao.places.qdsl;

import musta.belmo.cody.data.model.places.Seat;

import java.util.List;

public interface SeatQDSLRepository {
	List<Seat> getAllSeatsAtFloor(Long floorId);
	
	List<Seat> getAllSeatsAtRoom(Long roomId);
}
	

