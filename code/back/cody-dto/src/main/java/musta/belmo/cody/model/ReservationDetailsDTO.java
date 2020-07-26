package musta.belmo.cody.model;

import lombok.Data;

@Data
public class ReservationDetailsDTO {
	
	private String team;
	private String user;
	private String room;
	private String floor;
	private String position;
	private String from;
	private String to;
}
