package musta.belmo.cody.service.api.reservation;

import musta.belmo.cody.model.ReservationDTO;
import musta.belmo.cody.service.api.AbstractCrudService;

import java.time.LocalDateTime;

public interface ReservationService extends AbstractCrudService<ReservationDTO>{
	boolean checkAvailability(ReservationDTO reservationDTO);
	void reserve(ReservationDTO reservationDTO);
}
