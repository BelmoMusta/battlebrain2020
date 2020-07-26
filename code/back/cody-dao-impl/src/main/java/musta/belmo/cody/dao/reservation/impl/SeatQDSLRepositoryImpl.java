package musta.belmo.cody.dao.reservation.impl;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.EntityPathBase;
import com.querydsl.jpa.impl.JPAQuery;
import musta.belmo.cody.dao.impl.AbstractQDSLRepositoryImpl;
import musta.belmo.cody.dao.places.qdsl.SeatQDSLRepository;
import musta.belmo.cody.data.model.places.QSeat;
import musta.belmo.cody.data.model.places.Seat;
import musta.belmo.cody.data.model.scheduling.QReservation;
import musta.belmo.cody.data.model.scheduling.Reservation;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class SeatQDSLRepositoryImpl extends AbstractQDSLRepositoryImpl<Seat> implements SeatQDSLRepository {
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<Seat> getAllSeatsAtFloor(final Long floorId) {
		return selectAllWhere(QSeat.seat.room.floor.id.eq(floorId));
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<Seat> getAllSeatsAtRoom(Long roomId) {
		return selectAllWhere(QSeat.seat.room.id.eq(roomId));
		
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<Seat> getAllSeatsForATeam(Long teamId) {
		final JPAQuery<Seat> jpaQuery = getJpaQuery();
		
		return jpaQuery.select(QReservation.reservation.seat)
				.where(QReservation.reservation.user.team.id.eq(teamId))
				.fetch();
	}
	
	private List<Seat> selectAllWhere(BooleanExpression booleanExpressionFloorId) {
		final JPAQuery<Seat> jpaQuery = getJpaQuery();
		return jpaQuery.select(QSeat.seat)
				.from(QSeat.seat)
				.where(booleanExpressionFloorId)
				.fetch();
	}
	
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<Seat> getReservationsInAGivenRoom(Long roomId) {
		final JPAQuery<Seat> jpaQuery = getJpaQuery();
		return jpaQuery.from(QReservation.reservation)
				.select(QReservation.reservation.seat)
				.where(QReservation.reservation.seat.room.id.eq(roomId))
				.fetch();
		
	}
	
	@Override
	protected EntityPathBase<Seat> getEntityPathBase() {
		return QSeat.seat;
	}
}
