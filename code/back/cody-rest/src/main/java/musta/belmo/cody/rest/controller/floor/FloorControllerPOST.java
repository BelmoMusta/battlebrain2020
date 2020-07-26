package musta.belmo.cody.rest.controller.floor;

import io.swagger.annotations.ApiOperation;
import musta.belmo.cody.model.FloorDTO;
import musta.belmo.cody.rest.annotation.IsMember;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FloorControllerPOST extends AbstractFloorController {
	
	@PostMapping(value = "/", consumes = "application/json")
	@ApiOperation("Create a new floor")
	@IsMember
	public ResponseEntity<FloorDTO> create(final @RequestBody FloorDTO room) {
		floorService.create(room);
		return ResponseEntity.ok(room);
		
	}
}
