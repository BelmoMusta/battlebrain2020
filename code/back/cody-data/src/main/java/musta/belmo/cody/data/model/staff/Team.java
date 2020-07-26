package musta.belmo.cody.data.model.staff;

import lombok.Getter;
import lombok.Setter;
import musta.belmo.cody.data.model.common.AbstractDataModel;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
@Getter
@Setter
public class Team extends AbstractDataModel {

    private String name;
    
    @OneToMany(mappedBy = "team")
    private Set<User> members;
    
}
