package musta.belmo.cody.service.impl;

import musta.belmo.cody.data.model.staff.User;
import musta.belmo.cody.mapper.CopyMapper;
import musta.belmo.cody.mapper.DomainDTOMapper;
import musta.belmo.cody.service.api.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public abstract class AbstractCommonService {

    @Autowired
    protected DomainDTOMapper domainDTOMapper;
    @Autowired
    protected CopyMapper copyMapper;
    @Autowired
    protected UserService userService;

    protected User getConnectedUser() {
        return userService.getConnectedUser();
    }


}
