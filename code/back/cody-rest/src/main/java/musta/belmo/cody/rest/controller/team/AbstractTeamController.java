package musta.belmo.cody.rest.controller.team;

import io.swagger.annotations.Api;
import musta.belmo.cody.rest.RESTConstantes;
import musta.belmo.cody.rest.controller.AbstractController;
import musta.belmo.cody.rest.controller.swagger.SwaggerableController;
import musta.belmo.cody.service.api.seat.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import springfox.documentation.spring.web.plugins.Docket;

@RequestMapping(value = RESTConstantes.ROUTE_TEAM)
@Api(tags = RESTConstantes.TEAM, value = RESTConstantes.TEAM)
@CrossOrigin("*")
public abstract class AbstractTeamController extends AbstractController implements SwaggerableController {
	@Autowired
	protected TeamService teamService;
	
	@Override
	@Bean(RESTConstantes.TEAM)
	public Docket toDocket() {
		return buildDocket(RESTConstantes.TEAM);
		
	}
}
