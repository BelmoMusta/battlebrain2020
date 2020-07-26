package musta.belmo.cody.data.model.places;

import lombok.Getter;
import lombok.Setter;
import musta.belmo.cody.data.model.common.AbstractDataModel;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
public class Seat extends AbstractDataModel {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "room_id")
	private Room room;
	
	private Integer lineNumber; // admin can define them
	
	private Integer columnNumber; // admin can define this
	
}
