package musta.belmo.cody.dao.reservation;

import musta.belmo.cody.dao.AbstractRepository;
import musta.belmo.cody.data.model.scheduling.Reservation;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
@Repository
public interface ReservationRepository extends AbstractRepository<Reservation> {

}
