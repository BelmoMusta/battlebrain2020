package musta.belmo.cody.rest.controller.reservation;

import io.swagger.annotations.ApiOperation;
import musta.belmo.cody.model.ReservationDTO;
import musta.belmo.cody.rest.annotation.IsMember;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReservationControllerPOST extends AbstractReservationController {
	@PostMapping(value = "/reserve", consumes = "application/json")
	@ApiOperation("Reserves a new seat for a given intervalle")
	@IsMember
	public ResponseEntity<Void> reserve(@RequestBody ReservationDTO reservationDTO) {
		reservationService.reserve(reservationDTO);
		return ResponseEntity.ok().build();
		
	}
}
