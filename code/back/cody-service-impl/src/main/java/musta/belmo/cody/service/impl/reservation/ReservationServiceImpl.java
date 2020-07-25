package musta.belmo.cody.service.impl.reservation;

import musta.belmo.cody.dao.reservation.ReservationQDSLRepository;
import musta.belmo.cody.dao.reservation.ReservationRepository;
import musta.belmo.cody.data.model.places.Seat;
import musta.belmo.cody.data.model.scheduling.Reservation;
import musta.belmo.cody.model.ReservationDTO;
import musta.belmo.cody.service.api.exceptions.SeatAlreadyReservedException;
import musta.belmo.cody.service.api.reservation.ReservationService;
import musta.belmo.cody.service.impl.AbstractCommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Set;

@Service
public class ReservationServiceImpl extends AbstractCommonService implements ReservationService {
	
	@Autowired
	private ReservationRepository reservationRepository;
	@Autowired
	private ReservationQDSLRepository reservationQDSLRepository;
	
	@Override
	public boolean checkAvailability(Long seatId, LocalDateTime startsAt, LocalDateTime endsAt) {
		return reservationQDSLRepository.checkAvailability(seatId, startsAt, endsAt);
	}
	
	@Override
	public void reserve(ReservationDTO reservationDTO) {
		final Long seatId = reservationDTO.getSeatId();
		final boolean isAvailable = checkAvailability(seatId, reservationDTO.getStartsAt(),
				reservationDTO.getEndsAt());
		if (isAvailable) {
			final Seat seat = new Seat();
			seat.setId(seatId);
			
			final Reservation reservation = domainDTOMapper.toDomain(reservationDTO);
			reservation.setUser(getConnectedUser());
			reservation.setSeat(seat);
			reservationRepository.save(reservation);
		} else {
			throw new SeatAlreadyReservedException();
		}
		
		
	}
	
	@Override
	public ReservationDTO create(ReservationDTO reservationDTO) {
		return null;
	}
	
	@Override
	public Optional<ReservationDTO> findOne(Long id) {
		return Optional.empty();
	}
	
	@Override
	public Set<ReservationDTO> findAll() {
		return null;
	}
	
	@Override
	public ReservationDTO update(ReservationDTO reservationDTO) {
		return null;
	}
	
	@Override
	public ReservationDTO update(Long id, ReservationDTO reservationDTO) {
		return null;
	}
	
	@Override
	public void delete(ReservationDTO reservationDTO) {
	
	}
	
	@Override
	public void delete(Long id) {
	
	}
}
