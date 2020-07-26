package musta.belmo.cody.rest.controller.room;

import io.swagger.annotations.Api;
import musta.belmo.cody.rest.RESTConstantes;
import musta.belmo.cody.rest.controller.AbstractController;
import musta.belmo.cody.rest.controller.swagger.SwaggerableController;
import musta.belmo.cody.service.api.seat.RoomService;
import musta.belmo.cody.service.api.seat.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import springfox.documentation.spring.web.plugins.Docket;

@RequestMapping(value = RESTConstantes.ROUTE_ROOM)
@Api(tags = RESTConstantes.ROOM, value = RESTConstantes.ROOM)
@CrossOrigin("*")
public abstract class AbstractRoomController extends AbstractController implements SwaggerableController {
	@Autowired
	protected RoomService roomService;
	
	@Override
	@Bean(RESTConstantes.ROOM)
	public Docket toDocket() {
		return buildDocket(RESTConstantes.ROOM);
		
	}
}
