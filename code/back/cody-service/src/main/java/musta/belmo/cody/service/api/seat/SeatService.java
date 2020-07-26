package musta.belmo.cody.service.api.seat;

import com.querydsl.core.types.Predicate;
import lombok.NonNull;
import musta.belmo.cody.data.model.places.QSeat;
import musta.belmo.cody.data.model.staff.User;
import musta.belmo.cody.model.SeatDTO;
import musta.belmo.cody.service.api.AbstractCrudService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface SeatService extends AbstractCrudService<SeatDTO>, QuerydslBinderCustomizer<QSeat> {
	
	Set<SeatDTO> findAllForUser();
	
	Optional<SeatDTO> findOne(Long id, User user);
	
	Page<SeatDTO> getAllByQueryDsl(Predicate predicate, Pageable pageable);
	
	@Override
	default void customize(@NonNull QuerydslBindings bindings, @NonNull QSeat entity) {
	
	}
	
	Set<SeatDTO> findSaved();
	
	SeatDTO share(Long id, String additionalContent);
	
	List<SeatDTO> getAllSeatsAtFloor(Long floorId);
	
	List<SeatDTO> getAllSeatsAtRoom(Long roomId);
	
	void createAtRoom(SeatDTO seat, Long roomId);
	
	List<SeatDTO> getAllSeatsForATeam(Long teamId);
}
