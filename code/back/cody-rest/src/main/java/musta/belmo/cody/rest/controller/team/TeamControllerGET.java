package musta.belmo.cody.rest.controller.team;

import io.swagger.annotations.ApiOperation;
import musta.belmo.cody.model.TeamDTO;
import musta.belmo.cody.rest.annotation.IsMember;
import musta.belmo.cody.service.api.exceptions.ContentNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeamControllerGET extends AbstractTeamController {
	
	@GetMapping("/{id}")
	@ApiOperation("gets a team by its id")
	@IsMember
	public TeamDTO findOne(@PathVariable Long id) {
		return teamService.findOne(id)
				.orElseThrow(ContentNotFoundException::new);
	}
}
