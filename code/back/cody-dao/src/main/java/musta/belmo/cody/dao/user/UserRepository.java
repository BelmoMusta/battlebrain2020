package musta.belmo.cody.dao.user;

import musta.belmo.cody.dao.AbstractRepository;
import musta.belmo.cody.data.model.staff.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends AbstractRepository<User> {
    User findByEmail(String email);
}
