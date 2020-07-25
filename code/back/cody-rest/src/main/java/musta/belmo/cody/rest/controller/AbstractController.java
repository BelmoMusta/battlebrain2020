package musta.belmo.cody.rest.controller;

import musta.belmo.cody.rest.controller.swagger.SwaggerableController;
import musta.belmo.cody.service.api.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractController implements SwaggerableController {
    @Autowired
    protected UserService userService;

}
