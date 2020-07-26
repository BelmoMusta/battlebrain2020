package musta.belmo.cody.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SeatDTO extends AbstractDTO {
	
	private Integer lineNumber;
	
	private Integer columnNumber;
	
	private RoomDTO room;
	
	private boolean available;
	
}
