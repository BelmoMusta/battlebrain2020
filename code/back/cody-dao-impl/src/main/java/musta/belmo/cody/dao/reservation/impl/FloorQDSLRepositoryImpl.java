package musta.belmo.cody.dao.reservation.impl;

import musta.belmo.cody.dao.impl.AbstractQDSLRepositoryImpl;
import musta.belmo.cody.dao.places.qdsl.FloorQDSLRepository;
import musta.belmo.cody.data.model.places.Floor;
import org.springframework.stereotype.Repository;

@Repository
public class FloorQDSLRepositoryImpl extends AbstractQDSLRepositoryImpl<Floor> implements FloorQDSLRepository {
	// gonna be needed to perform some complexe querie
}
