package musta.belmo.cody.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class SearchSeatDTO {

    private String content;
    private Date createdAt;
    private Date updatedAt;

}
