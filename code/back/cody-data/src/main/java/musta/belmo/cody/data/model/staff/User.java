package musta.belmo.cody.data.model.staff;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import musta.belmo.cody.data.model.common.AbstractDataModel;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@EqualsAndHashCode(of = "email", callSuper = false)
@Table(uniqueConstraints = @UniqueConstraint(name="userMailShouldBeUnique", columnNames = "email"))

public class User extends AbstractDataModel {
    
    private String email;
    
    private char[] password;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private Team team;

    @Transient
    private char[] passwordConfirmation;
    
    @ManyToMany()
    private Set<Role> roles = new HashSet<>();
    

    public boolean isAdmin() {
        return false;
    }

}
