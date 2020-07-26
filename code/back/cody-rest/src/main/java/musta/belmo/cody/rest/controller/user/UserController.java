package musta.belmo.cody.rest.controller.user;


import musta.belmo.cody.model.UserRegistrationDTO;
import musta.belmo.cody.rest.annotation.IsMember;
import musta.belmo.cody.rest.controller.AbstractController;
import musta.belmo.cody.service.api.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.spring.web.plugins.Docket;

@RestController
@RequestMapping(value = "/user")

public class UserController extends AbstractController {

    public static final String USER = "User";

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/registration")
    public ResponseEntity<String> registration(@RequestBody UserRegistrationDTO user) {
        userService.save(user);
        return ResponseEntity.ok().body(user.getEmail());
    }
    
    @PostMapping("/team/{teamId}/assign")
    @IsMember
    public ResponseEntity<String> assingUserToATeam(@PathVariable Long teamId,  String userMail) {
        userService.assingUserToATeam(teamId, userMail);
        return ResponseEntity.ok().build();
    }

    @Override
    @Bean(USER)
    public Docket toDocket() {
        return buildDocket(USER);
    }
}