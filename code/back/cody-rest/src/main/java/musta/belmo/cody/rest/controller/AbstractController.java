package musta.belmo.cody.rest.controller;

import musta.belmo.cody.service.api.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public class AbstractController {
    @Autowired
    protected UserService userService;

}
