package musta.belmo.cody.rest.controller.team;

import io.swagger.annotations.ApiOperation;
import musta.belmo.cody.model.TeamDTO;
import musta.belmo.cody.rest.annotation.IsAdmin;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeamControllerPOST extends AbstractTeamController {
	
	@PostMapping(value = "/", consumes = "application/json")
	@ApiOperation("Create a new team")
	@IsAdmin
	public ResponseEntity<TeamDTO> create(final @RequestBody TeamDTO room) {
		teamService.create(room);
		return ResponseEntity.ok(room);
		
	}
}
