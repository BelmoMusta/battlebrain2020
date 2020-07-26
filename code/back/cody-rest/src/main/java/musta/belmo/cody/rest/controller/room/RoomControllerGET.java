package musta.belmo.cody.rest.controller.room;

import io.swagger.annotations.ApiOperation;
import musta.belmo.cody.model.RoomDTO;
import musta.belmo.cody.rest.annotation.IsMember;
import musta.belmo.cody.service.api.exceptions.ContentNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RoomControllerGET extends AbstractRoomController {
	
	@GetMapping("/{id}")
	@ApiOperation("gets a room by its id")
	@IsMember
	public RoomDTO findOne(@PathVariable Long id) {
		return roomService.findOne(id)
				.orElseThrow(ContentNotFoundException::new);
	}
	
	@GetMapping("/floor/{floorId}")
	@ApiOperation("gets the rooms at a given floor")
	@IsMember
	public List<RoomDTO> getAllRoomsAtFloor(@PathVariable Long floorId) {
		return roomService.getAllRoomsAtFloor(floorId);
	}
	
	
}
