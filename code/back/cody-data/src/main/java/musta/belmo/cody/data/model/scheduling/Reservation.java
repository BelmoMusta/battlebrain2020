package musta.belmo.cody.data.model.scheduling;

import lombok.Getter;
import lombok.Setter;
import musta.belmo.cody.data.model.common.AbstractDataModel;
import musta.belmo.cody.data.model.places.Seat;
import musta.belmo.cody.data.model.staff.User;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Reservation extends AbstractDataModel {
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@Column
	private LocalDateTime startsAt;
	
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@Column
	private LocalDateTime endsAt;
	
	@ManyToOne()
	@JoinColumn(name = "seat_id")
	private Seat seat;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;
}
