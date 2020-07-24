package musta.belmo.cody.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class UserRegistrationDTO  {
    private String email;
    private String password;
    private String passwordConfirmation;

}
