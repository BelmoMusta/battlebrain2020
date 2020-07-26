package musta.belmo.cody.dao.places.qdsl;

import musta.belmo.cody.data.model.places.Room;

import java.util.List;

public interface RoomQDSLRepository {
	List<Room> getAllRoomsAtFloor(Long floorId);
}
	

