package musta.belmo.cody.dao.staff;

import musta.belmo.cody.dao.AbstractRepository;
import musta.belmo.cody.data.model.staff.Team;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
@Repository
public interface TeamRepository extends AbstractRepository<Team> {
	

}
