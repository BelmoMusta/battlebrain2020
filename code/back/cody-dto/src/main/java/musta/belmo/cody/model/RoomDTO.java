package musta.belmo.cody.model;

import lombok.Data;

import java.util.Set;

@Data
public class RoomDTO extends AbstractDTO {
	private String name;
	
	private FloorDTO floor;
	
	private Integer maxCapacity;
	
	private Set<SeatDTO> seats;
	
}
