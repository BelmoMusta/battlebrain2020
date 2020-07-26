package musta.belmo.cody.service.impl.reservation;

import musta.belmo.cody.dao.reservation.ReservationQDSLRepository;
import musta.belmo.cody.dao.reservation.ReservationRepository;
import musta.belmo.cody.data.model.scheduling.Reservation;
import musta.belmo.cody.model.AbstractDTO;
import musta.belmo.cody.model.ReservationDTO;
import musta.belmo.cody.model.RoomDTO;
import musta.belmo.cody.model.SeatDTO;
import musta.belmo.cody.service.api.exceptions.AdjacentSeatOccupiedException;
import musta.belmo.cody.service.api.exceptions.RoomIsFullException;
import musta.belmo.cody.service.api.exceptions.SeatAlreadyReservedException;
import musta.belmo.cody.service.api.reservation.ReservationService;
import musta.belmo.cody.service.api.seat.RoomService;
import musta.belmo.cody.service.api.seat.SeatService;
import musta.belmo.cody.service.impl.AbstractCommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ReservationServiceImpl extends AbstractCommonService implements ReservationService {
	
	@Autowired
	private ReservationRepository reservationRepository;
	@Autowired
	private ReservationQDSLRepository reservationQDSLRepository;
	
	@Autowired
	private RoomService roomService;
	
	@Autowired
	private SeatService seatService;
	
	@Override
	public boolean checkAvailability(ReservationDTO reservationDTO) {
		final Long seatId = Optional.ofNullable(reservationDTO.getSeat())
				.map(AbstractDTO::getId)
				.orElse(-1L);
		
		
		final boolean availableOnDateIntervalle = reservationQDSLRepository
				.checkAvailabilityInAGivenIntervalle(seatId,
						reservationDTO.getStartsAt(),
						reservationDTO.getEndsAt());
		return availableOnDateIntervalle
				&& !isRoomFull(seatId)
				&& !isNextSeatInTheMatrixeOccpied(seatId);
	}
	
	private boolean isRoomFull(Long seatId) {
		final Optional<SeatDTO> optionalSeat = seatService.findOne(seatId);
		
		boolean roomIsFull = false;
		if (optionalSeat.isPresent()) {
			final Long roomId = optionalSeat.map(SeatDTO::getRoom)
					.map(AbstractDTO::getId)
					.orElse(-1L);
			final Optional<RoomDTO> optionalRoom = roomService.findOne(roomId);
			if (optionalRoom.isPresent()) {
				final List<SeatDTO> allSeatsAtRoom = seatService.getAllSeatsAtRoom(roomId);
				final RoomDTO roomDTO = optionalRoom.get();
				final int size = allSeatsAtRoom.size();
				roomIsFull = (size - 1 == roomDTO.getMaxCapacity());
				
			}
		}
		
		if (roomIsFull) {
			throw new RoomIsFullException();
		}
		return roomIsFull;
	}
	
	private boolean isNextSeatInTheMatrixeOccpied(Long seatId) {
		final Optional<SeatDTO> optionalSeat = seatService.findOne(seatId);
		
		boolean nextSeatOccupied = false;
		
		if (optionalSeat.isPresent()) {
			final Long roomId = optionalSeat.map(SeatDTO::getRoom)
					.map(AbstractDTO::getId)
					.orElse(-1L);
			final SeatDTO seatA = optionalSeat.get();
			final List<SeatDTO> reservationsInAGivenRoom = seatService.getReservationsInAGivenRoom(roomId);
			for (SeatDTO seatB : reservationsInAGivenRoom) {
				if (areTwoSeatsAdjacent(seatA, seatB)) {
					nextSeatOccupied = true;
					break;
				}
			}
			
		}
		
		if (nextSeatOccupied) {
			throw new AdjacentSeatOccupiedException();
		}
		return nextSeatOccupied;
	}
	
	private boolean areTwoSeatsAdjacent(SeatDTO seatA, SeatDTO seatB) {
		
		boolean atTheSameLine = seatB.getLineNumber().equals(seatA.getLineNumber());
		boolean atTheSameColumn = seatB.getColumnNumber().equals(seatA.getColumnNumber());
		
		return atTheSameLine && Math.abs(seatB.getColumnNumber() - seatA.getColumnNumber()) <= 1
				|| atTheSameColumn && Math.abs(seatB.getLineNumber() - seatA.getLineNumber()) <= 1;
		
		
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void reserve(ReservationDTO reservationDTO) {
		
		final boolean isAvailable = checkAvailability(reservationDTO);
		if (isAvailable) {
			final Reservation reservation = domainDTOMapper.toDomain(reservationDTO);
			reservation.setUser(getConnectedUser());
			reservationRepository.save(reservation);
		} else {
			throw new SeatAlreadyReservedException();
		}
		
	}
	
	@Override
	public void freeReservationsInThePast() {
		reservationQDSLRepository.freeReservationsInThePast();
		
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
