package musta.belmo.cody.dao.reservation.impl;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import musta.belmo.cody.dao.impl.AbstractQDSLRepositoryImpl;
import musta.belmo.cody.dao.places.qdsl.SeatQDSLRepository;
import musta.belmo.cody.data.model.places.QSeat;
import musta.belmo.cody.data.model.places.Seat;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SeatQDSLRepositoryImpl extends AbstractQDSLRepositoryImpl<Seat> implements SeatQDSLRepository {
	
	@Override
	public List<Seat> getAllSeatsAtFloor(final Long floorId) {
		return selectAllWhere(QSeat.seat.room.floor.id.eq(floorId));
	}
	
	@Override
	public List<Seat> getAllSeatsAtRoom(Long roomId) {
		return selectAllWhere(QSeat.seat.room.id.eq(roomId));
		
	}
	
	private List<Seat> selectAllWhere(BooleanExpression booleanExpressionFloorId) {
		final JPAQuery<Seat> jpaQuery = getJpaQuery();
		return jpaQuery.select(QSeat.seat)
				.from(QSeat.seat)
				.where(booleanExpressionFloorId)
				.fetch();
	}
}
