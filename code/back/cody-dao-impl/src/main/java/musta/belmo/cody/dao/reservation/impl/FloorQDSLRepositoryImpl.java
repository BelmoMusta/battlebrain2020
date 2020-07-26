package musta.belmo.cody.dao.reservation.impl;

import com.querydsl.core.types.dsl.EntityPathBase;
import musta.belmo.cody.dao.impl.AbstractQDSLRepositoryImpl;
import musta.belmo.cody.dao.places.qdsl.FloorQDSLRepository;
import musta.belmo.cody.data.model.places.Floor;
import musta.belmo.cody.data.model.places.QFloor;
import org.springframework.stereotype.Repository;

@Repository
public class FloorQDSLRepositoryImpl extends AbstractQDSLRepositoryImpl<Floor> implements FloorQDSLRepository {
	@Override
	protected EntityPathBase<Floor> getEntityPathBase() {
		return QFloor.floor;
	}
	// gonna be needed to perform some complexe querie
}
