package musta.belmo.cody.data.model.staff;

import lombok.Getter;
import lombok.Setter;
import musta.belmo.cody.data.model.common.AbstractDataModel;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.Set;

@Entity
@Getter
@Setter
public class Role extends AbstractDataModel {
    private String name;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users;


}
