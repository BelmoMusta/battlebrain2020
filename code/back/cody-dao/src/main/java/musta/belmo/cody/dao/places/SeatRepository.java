package musta.belmo.cody.dao.places;

import musta.belmo.cody.dao.AbstractRepository;
import musta.belmo.cody.dao.specifications.EqualsSpecification;
import musta.belmo.cody.dao.specifications.NeutralSpecification;
import musta.belmo.cody.dao.specifications.SpecificationUtils;
import musta.belmo.cody.data.model.places.Seat;
import musta.belmo.cody.data.model.places.Seat_;
import musta.belmo.cody.data.model.staff.User;
import musta.belmo.cody.data.model.staff.User_;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.HashSet;

@Component
@Repository
public interface SeatRepository extends AbstractRepository<Seat>, QueryDslPredicateExecutor<Seat> {
	
	
	default Seat findOne(Long id, User user) {
		final Specification<Seat> seattSpecification = new EqualsSpecification<>(Seat_.ID, id);
		final Specification<Seat> userSpecification;
		if (user.isAdmin()) {
			userSpecification = new NeutralSpecification<>();
		} else {
			userSpecification = new EqualsSpecification<>(User_.ID, user.getId());
		}
		
		final Specification<Seat> specification = SpecificationUtils.and(userSpecification, seattSpecification);
		return findOne(specification);
	}
	
	default HashSet<Seat> findAllForUser(User user) {
		final Specification<Seat> seatSpecification;
		if (user.isAdmin()) {
			seatSpecification = new NeutralSpecification<>();
		} else {
			seatSpecification = new EqualsSpecification<>(User_.ID, user.getId());
		}
		return new HashSet<>(findAll(seatSpecification));
	}
}
