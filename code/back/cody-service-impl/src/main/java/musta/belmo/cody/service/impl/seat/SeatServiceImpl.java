package musta.belmo.cody.service.impl.seat;

import com.querydsl.core.types.Predicate;
import musta.belmo.cody.dao.places.SeatRepository;
import musta.belmo.cody.dao.places.qdsl.SeatQDSLRepository;
import musta.belmo.cody.data.model.places.Seat;
import musta.belmo.cody.data.model.staff.User;
import musta.belmo.cody.model.RoomDTO;
import musta.belmo.cody.model.SeatDTO;
import musta.belmo.cody.service.api.exceptions.ApplicationException;
import musta.belmo.cody.service.api.exceptions.ContentNotFoundException;
import musta.belmo.cody.service.api.seat.RoomService;
import musta.belmo.cody.service.api.seat.SeatService;
import musta.belmo.cody.service.impl.AbstractCommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class SeatServiceImpl extends AbstractCommonService implements SeatService {
	@Autowired
	private SeatRepository seatRepository;
	@Autowired
	private SeatQDSLRepository seatQDSLRepository;
	
	@Autowired
	private RoomService roomService;
	
	
	@Override
	public SeatDTO create(SeatDTO seatDTO) {
		seatRepository.save(domainDTOMapper.toDomain(seatDTO));
		return seatDTO;
	}
	
	public Seat create(Seat seat) {
		return seatRepository.save(seat);
	}
	
	@Override
	public Optional<SeatDTO> findOne(final Long id) {
		return Optional.ofNullable(seatRepository.findOne(id))
				.map(domainDTOMapper::toDTO);
	}
	
	@Override
	public Set<SeatDTO> findAll() {
		return seatRepository.findAll().stream()
				.map(domainDTOMapper::toDTO)
				.collect(Collectors.toSet());
		
	}
	
	@Override
	public Set<SeatDTO> findAllForUser() {
		final User user = userService.getConnectedUser();
		return seatRepository.findAllForUser(user).stream()
				.map(domainDTOMapper::toDTO)
				.collect(Collectors.toSet());
	}
	
	@Override
	public Optional<SeatDTO> findOne(Long id, User user) {
		return Optional.ofNullable(seatRepository.findOne(id, user))
				.map(domainDTOMapper::toDTO);
	}
	
	
	
	@Override
	public List<SeatDTO> getAllSeatsAtFloor(Long floorId) {
		return seatQDSLRepository.getAllSeatsAtFloor(floorId)
				.stream()
				.map(domainDTOMapper::toDTO)
				.collect(Collectors.toList());
	}
	
	@Override
	public List<SeatDTO> getAllSeatsAtRoom(Long roomId) {
		return seatQDSLRepository.getAllSeatsAtRoom(roomId)
				.stream()
				.map(domainDTOMapper::toDTO)
				.collect(Collectors.toList());
	}
	
	@Override
	public void createAtRoom(SeatDTO seat, Long roomId) {
		final RoomDTO roomDTO = roomService.findOne(roomId)
				.orElseThrow(ContentNotFoundException::new);
		seat.setRoom(roomDTO);
		final Seat seatDomain = domainDTOMapper.toDomain(seat);
		create(seatDomain);
	}
	
	@Override
	public List<SeatDTO> getAllSeatsForATeam(Long teamId) {
		return seatQDSLRepository.getAllSeatsForATeam(teamId)
				.stream()
				.map(domainDTOMapper::toDTO)
				.collect(Collectors.toList());
	}
	
	@Override
	public SeatDTO update(SeatDTO seat) {
		return Optional.ofNullable(seat)
				.map(domainDTOMapper::toDomain)
				.map(seatRepository::saveAndFlush)
				.map(domainDTOMapper::toDTO)
				.orElseThrow(ApplicationException::new);
	}
	
	
	@Override
	public SeatDTO update(Long id, SeatDTO seat) {
		seat.setId(id);
		return update(seat);
	}
	
	@Override
	public void delete(final SeatDTO seat) {
		Optional.ofNullable(seat)
				.map(domainDTOMapper::toDomain)
				.ifPresent(seatRepository::delete);
	}
	
	@Override
	public void delete(Long id) {
		findOne(id).ifPresent(this::delete);
	}
}
