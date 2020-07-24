package musta.belmo.cody.service.api.user;

import musta.belmo.cody.data.model.staff.User;
import musta.belmo.cody.model.UserRegistrationDTO;

public interface UserService {
    void save(UserRegistrationDTO user);

    User findByEmail(String username);

    User findById(Long id);

    User getConnectedUser();
}
