package musta.belmo.cody.dao.user;

import musta.belmo.cody.dao.AbstractRepository;
import musta.belmo.cody.data.model.staff.Role;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends AbstractRepository<Role> {
    Role findByName(String roleName);
}