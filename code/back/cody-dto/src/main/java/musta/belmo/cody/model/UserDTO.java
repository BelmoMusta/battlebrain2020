package musta.belmo.cody.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class UserDTO extends AbstractDTO {
    private String email;
    private char[] password;
    @JsonIgnore
    private char[] passwordConfirmation;

    @JsonIgnore
    public char[] getPassword() {
        return password;
    }

    @JsonIgnore
    public char[] getPasswordConfirmation() {
        return passwordConfirmation;
    }
}
