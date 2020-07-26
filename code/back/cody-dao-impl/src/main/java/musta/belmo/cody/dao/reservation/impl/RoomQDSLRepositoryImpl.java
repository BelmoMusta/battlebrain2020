package musta.belmo.cody.dao.reservation.impl;

import musta.belmo.cody.dao.impl.AbstractQDSLRepositoryImpl;
import musta.belmo.cody.dao.places.qdsl.RoomQDSLRepository;
import musta.belmo.cody.data.model.places.QRoom;
import musta.belmo.cody.data.model.places.Room;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RoomQDSLRepositoryImpl extends AbstractQDSLRepositoryImpl<Room> implements RoomQDSLRepository {
	
	
	@Override
	public List<Room> getAllRoomsAtFloor(Long floorId) {
		QRoom.room.floor.id.eq(floorId);
		return getJpaQuery()
				.where(QRoom.room.floor.id.eq(floorId))
				.fetch();
	}
}
