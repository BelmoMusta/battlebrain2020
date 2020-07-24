package musta.belmo.cody.data.model.staff;

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
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter

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

    @Override
    public boolean equals(Object o) {
        final boolean equals;
        if (this == o) {
            equals = true;
        } else if (!(o instanceof User) || !super.equals(o)) {
            equals = false;
        } else {
            User user = (User) o;
            equals = Objects.equals(email, user.email);
        }
        return equals;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), email);
    }
}