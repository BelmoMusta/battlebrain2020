package musta.belmo.cody.model;

import lombok.Data;

@Data
public class RoomDTO extends AbstractDTO {
	private String name;
	
	private FloorDTO floor;
}
