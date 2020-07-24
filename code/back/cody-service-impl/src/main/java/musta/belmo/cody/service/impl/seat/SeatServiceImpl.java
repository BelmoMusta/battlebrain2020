package musta.belmo.cody.service.impl.seat;

import com.querydsl.core.types.Predicate;
import musta.belmo.cody.dao.seat.SeatRepository;
import musta.belmo.cody.data.model.staff.User;
import musta.belmo.cody.model.SeatDTO;
import musta.belmo.cody.service.api.exceptions.ApplicationException;
import musta.belmo.cody.service.api.seat.SeatService;
import musta.belmo.cody.service.impl.AbstractCommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class SeatServiceImpl extends AbstractCommonService implements SeatService {
	@Autowired
	private SeatRepository seatRepository;
    
    
    @Override
    public SeatDTO create(SeatDTO seatDTO) {
        return null;
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
	public Page<SeatDTO> getAllByQueryDsl(Predicate predicate, Pageable pageable) {
		return seatRepository.findAll(predicate, pageable)
				.map(domainDTOMapper::toDTO);
		
	}
    
    @Override
    public Set<SeatDTO> findSaved() {
        return null;
    }
    
    @Override
    public SeatDTO share(Long id, String additionalContent) {
        return null;
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
