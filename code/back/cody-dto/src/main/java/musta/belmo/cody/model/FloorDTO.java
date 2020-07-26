package musta.belmo.cody.model;

import lombok.Data;

@Data
public class FloorDTO extends AbstractDTO{
	private Integer number;
	private String name; // a floor may have a name ?
}
