package musta.belmo.cody.service.api.exceptions;

public class RoomIsFullException extends ApplicationException {
	public RoomIsFullException() {
		super(701, "This room is full!");
	}
}
