package musta.belmo.cody.rest.controller.floor;

import io.swagger.annotations.Api;
import musta.belmo.cody.rest.RESTConstantes;
import musta.belmo.cody.rest.controller.AbstractController;
import musta.belmo.cody.rest.controller.swagger.SwaggerableController;
import musta.belmo.cody.service.api.seat.FloorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import springfox.documentation.spring.web.plugins.Docket;

@RequestMapping(value = RESTConstantes.ROUTE_FLOOR)
@Api(tags = RESTConstantes.FLOOR, value = RESTConstantes.FLOOR)
@CrossOrigin("*")
public abstract class AbstractFloorController extends AbstractController implements SwaggerableController {
	@Autowired
	protected FloorService floorService;
	
	@Override
	@Bean(RESTConstantes.FLOOR)
	public Docket toDocket() {
		return buildDocket(RESTConstantes.FLOOR);
		
	}
}
