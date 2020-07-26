package musta.belmo.cody.service.api.exceptions;

public class AdjacentSeatOccupiedException extends ApplicationException {
	public AdjacentSeatOccupiedException() {
		super(702, "There is an adjacent occupied seat ");
	}
}
