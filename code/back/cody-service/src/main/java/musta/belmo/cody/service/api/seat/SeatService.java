package musta.belmo.cody.service.api.seat;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.StringExpression;
import com.querydsl.core.types.dsl.StringPath;
import lombok.NonNull;
import musta.belmo.cody.data.model.places.QSeat;
import musta.belmo.cody.data.model.staff.User;
import musta.belmo.cody.model.SeatDTO;
import musta.belmo.cody.service.api.AbstractCrudService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.querydsl.binding.SingleValueBinding;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface SeatService extends AbstractCrudService<SeatDTO>, QuerydslBinderCustomizer<QSeat> {

    Set<SeatDTO> findAllForUser();

    Optional<SeatDTO> findOne(Long id, User user);
    
    Page<SeatDTO> getAllByQueryDsl(Predicate predicate, Pageable pageable);

    @Override
    default void customize(@NonNull QuerydslBindings bindings, @NonNull QSeat entity) {
        bindings.excluding(entity.id);
        // Make case-insensitive 'like' filter for all string properties
        bindings.bind(String.class).first((SingleValueBinding<StringPath, String>)
                StringExpression::containsIgnoreCase);
        bindings.bind(entity.content).all((path, values) -> {
            BooleanBuilder predicate = new BooleanBuilder();
            // with a for loop
            for (String value : values) {
                predicate.or(path.containsIgnoreCase(value));
            }
            return predicate;
        });

        bindings.bind(entity.createdAt).all((path, value) -> {
            Iterator<? extends Date> it = value.iterator();
            Date from = it.next();
            if (value.size() >= 2) {
                Date to = it.next();
                return path.between(from, to); // between
            } else {
                return path.goe(from); // greater than or equal
            }
        });

        // Add 'between' and 'greater or equal' filter date property
    }

    Set<SeatDTO> findSaved();

    SeatDTO share(Long id, String additionalContent);
    
    List<SeatDTO> getAllSeatsAtFloor(Long floorId);
    
    List<SeatDTO> getAllSeatsAtRoom(Long roomId);
    
    void createAtRoom(SeatDTO seat, Long roomId);
}
