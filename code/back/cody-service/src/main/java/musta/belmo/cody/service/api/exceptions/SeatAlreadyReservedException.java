package musta.belmo.cody.service.api.exceptions;

public class SeatAlreadyReservedException extends ApplicationException {
	public SeatAlreadyReservedException() {
		super(700, "This seat is already reserved!");
	}
}
