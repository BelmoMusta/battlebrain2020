package musta.belmo.cody.dao.places.qdsl;

import musta.belmo.cody.data.model.places.Seat;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface SeatQDSLRepository {
	List<Seat> getAllSeatsAtFloor(Long floorId);
	
	List<Seat> getAllSeatsAtRoom(Long roomId);
	
	List<Seat> getAllSeatsForATeam(Long teamId);
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	List<Seat> getReservationsInAGivenRoom(Long roomId);
}
	

