package musta.belmo.cody.rest.controller.floor;

import io.swagger.annotations.ApiOperation;
import musta.belmo.cody.model.FloorDTO;
import musta.belmo.cody.rest.annotation.IsMember;
import musta.belmo.cody.service.api.exceptions.ContentNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FloorControllerGET extends AbstractFloorController {
	
	@GetMapping("/{id}")
	@ApiOperation("gets a floor by its id")
	@IsMember
	public FloorDTO findOne(@PathVariable Long id) {
		return floorService.findOne(id)
				.orElseThrow(ContentNotFoundException::new);
	}
}
