package musta.belmo.cody.service.api.user;

import musta.belmo.cody.data.model.staff.Role;
import musta.belmo.cody.model.RoleDTO;
import musta.belmo.cody.service.api.AbstractCrudService;

import java.util.Optional;

public interface RoleService extends AbstractCrudService<RoleDTO> {

    Optional<Role> findByName(String roleName);
}
