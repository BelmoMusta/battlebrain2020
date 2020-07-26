package musta.belmo.cody.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ReservationDTO extends AbstractDTO {
	
	private SeatDTO seat;
	@ApplicationTimeFormat
	private LocalDateTime startsAt;
	@ApplicationTimeFormat
	private LocalDateTime endsAt;
	
}
