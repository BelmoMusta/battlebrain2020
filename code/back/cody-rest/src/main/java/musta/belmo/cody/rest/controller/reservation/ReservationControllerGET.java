package musta.belmo.cody.rest.controller.reservation;

import io.swagger.annotations.ApiOperation;
import musta.belmo.cody.model.ReservationDTO;
import musta.belmo.cody.model.ReservationDetailsDTO;
import musta.belmo.cody.rest.annotation.IsAdmin;
import musta.belmo.cody.rest.annotation.IsMember;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class ReservationControllerGET extends AbstractReservationController {
	@GetMapping(value = "/" )
	@ApiOperation("Gets all the details for the current reservations")
	@IsMember
	public ResponseEntity<Set<ReservationDetailsDTO>> getAll() {
		return ResponseEntity.ok()
				.body(reservationService.getAll());
		
	}
}
