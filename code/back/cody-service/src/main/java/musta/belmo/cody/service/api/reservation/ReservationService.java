package musta.belmo.cody.service.api.reservation;

import musta.belmo.cody.model.ReservationDTO;
import musta.belmo.cody.service.api.AbstractCrudService;

import java.time.LocalDateTime;

public interface ReservationService extends AbstractCrudService<ReservationDTO>{
	boolean checkAvailability(Long seatId, LocalDateTime startsAt, LocalDateTime from);
	void reserve(ReservationDTO reservationDTO);
}
