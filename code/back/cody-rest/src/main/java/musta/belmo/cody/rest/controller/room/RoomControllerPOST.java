package musta.belmo.cody.rest.controller.room;

import io.swagger.annotations.ApiOperation;
import musta.belmo.cody.model.RoomDTO;
import musta.belmo.cody.rest.annotation.IsMember;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoomControllerPOST extends AbstractRoomController {
	
	@PostMapping(value = "/", consumes = "application/json")
	@ApiOperation("Create a new room")
	@IsMember
	public ResponseEntity<RoomDTO> create(final @RequestBody RoomDTO room) {
		roomService.create(room);
		return ResponseEntity.ok(room);
		
	}
	
	@PostMapping(value = "/{floorId}", consumes = "application/json")
	@ApiOperation("Create a new room at a given floor")
	@IsMember
	public ResponseEntity<RoomDTO> createAtFloor(final @RequestBody RoomDTO room, Long floorId) {
		roomService.createAtFloor(room, floorId);
		return ResponseEntity.ok(room);
		
	}
}
