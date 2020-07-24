package musta.belmo.cody.data.model.places;

import lombok.Getter;
import lombok.Setter;
import musta.belmo.cody.data.model.common.AbstractDataModel;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.Set;

@Getter
@Setter
@Entity
public class Room extends AbstractDataModel {
	
	private String name;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(columnDefinition = "floor_id")
	private Floor floor;
	
	@OneToMany(mappedBy = "room")
	private Set<Seat> seats;
}
