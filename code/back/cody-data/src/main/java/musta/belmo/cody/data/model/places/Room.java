package musta.belmo.cody.data.model.places;

import lombok.Getter;
import lombok.Setter;
import musta.belmo.cody.data.model.common.AbstractDataModel;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import java.util.Optional;

@Getter
@Setter
@Entity
public class Room extends AbstractDataModel {
	
	private String name;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(columnDefinition = "floor_id")
	private Floor floor;
	
	private Integer maxLines;
	
	private Integer maxRows;
	
	@Transient
	public Integer getMaxCapacity() {
		Integer lines = Optional.ofNullable(maxLines)
				.orElse(0);
		
		Integer rows = Optional.ofNullable(maxRows)
				.orElse(0);
		return (int) Math.ceil((rows * lines) /2.0);
	}
}
