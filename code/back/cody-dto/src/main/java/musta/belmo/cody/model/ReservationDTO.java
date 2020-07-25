package musta.belmo.cody.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
public class ReservationDTO extends AbstractDTO {
	
	private Long seatId;
	@ApplicationTimeFormat
	private LocalDateTime startsAt;
	@ApplicationTimeFormat
	private LocalDateTime endsAt;
	
}
