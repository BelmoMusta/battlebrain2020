package musta.belmo.cody.rest.controller.seat;

import io.swagger.annotations.ApiOperation;
import musta.belmo.cody.model.SeatDTO;
import musta.belmo.cody.rest.annotation.IsMember;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SeatControllerPOST extends AbstractSeatController {
	
	@PostMapping(value = "/", consumes = "application/json")
	@ApiOperation("Create a new seat")
	@IsMember
	public ResponseEntity<SeatDTO> create(final @RequestBody SeatDTO seat) {
		seatService.create(seat);
		return ResponseEntity.ok(seat);
		
	}
	
	public SeatDTO update(final SeatDTO seat) {
		return seatService.update(seat);
	}
	
	@DeleteMapping("/{id}")
	@ApiOperation("deletes a seat")
	@IsMember
	public void delete(Long id) {
		seatService.delete(id);
		
	}
}
