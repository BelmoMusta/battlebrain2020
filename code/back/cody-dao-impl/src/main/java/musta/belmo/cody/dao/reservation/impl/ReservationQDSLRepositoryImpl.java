package musta.belmo.cody.dao.reservation.impl;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.EntityPathBase;
import com.querydsl.jpa.impl.JPADeleteClause;
import com.querydsl.jpa.impl.JPAQuery;
import musta.belmo.cody.dao.impl.AbstractQDSLRepositoryImpl;
import musta.belmo.cody.dao.reservation.ReservationQDSLRepository;
import musta.belmo.cody.data.model.scheduling.QReservation;
import musta.belmo.cody.data.model.scheduling.Reservation;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Repository
public class ReservationQDSLRepositoryImpl extends AbstractQDSLRepositoryImpl<Reservation> implements ReservationQDSLRepository {
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public boolean checkAvailabilityInAGivenIntervalle(Long seatId, LocalDateTime startsAt, LocalDateTime endsAt) {
		final JPAQuery<Reservation> jpaQuery = getJpaQuery();
		
		final BooleanExpression seatPredicate = QReservation.reservation.seat.id.eq(seatId);
		final BooleanExpression endsAtPredicate = QReservation.reservation.endsAt.gt(startsAt);
		final BooleanExpression startsAtPredicate = QReservation.reservation.startsAt.lt(endsAt);
		jpaQuery.select(QReservation.reservation)
				.from(QReservation.reservation)
				.where(seatPredicate
						.and(startsAtPredicate)
						.and(endsAtPredicate));
		return jpaQuery.fetchCount() == 0L;
		
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void freeReservationsInThePast() {
		JPADeleteClause jpaDeleteQuery = getJpaDeleteQuery();
		jpaDeleteQuery.where(QReservation.reservation.endsAt.lt(LocalDateTime.now())).execute();
	}
	
	
	@Override
	protected EntityPathBase<Reservation> getEntityPathBase() {
		return QReservation.reservation;
	}
}
