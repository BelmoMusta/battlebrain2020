package musta.belmo.cody.data.model.places;

import lombok.Getter;
import lombok.Setter;
import musta.belmo.cody.data.model.common.AbstractDataModel;

import javax.persistence.Entity;

@Getter
@Setter
@Entity
public class Floor extends AbstractDataModel {
	private Integer number;
	private String name; // a floor may have a name ?
}
