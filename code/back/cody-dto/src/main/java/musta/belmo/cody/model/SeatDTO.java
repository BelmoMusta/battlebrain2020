package musta.belmo.cody.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;

@Getter
@Setter
public class SeatDTO extends AbstractDTO {

    @Max(100)
    private String content;
    @JsonIgnore
    private UserDTO user;
    private boolean isShared;


}
