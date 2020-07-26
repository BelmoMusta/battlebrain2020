package musta.belmo.cody.dao.reservation;

import java.time.LocalDateTime;

public interface ReservationQDSLRepository  {
	
	 boolean checkAvailabilityInAGivenIntervalle(Long seatId, LocalDateTime startsAt, LocalDateTime endsAt);
}
