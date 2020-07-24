package musta.belmo.cody.rest.controller.seat;

import io.swagger.annotations.Api;
import musta.belmo.cody.rest.controller.AbstractController;
import musta.belmo.cody.rest.controller.swagger.SwaggerableController;
import musta.belmo.cody.service.api.seat.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import springfox.documentation.spring.web.plugins.Docket;

@RequestMapping(value = "/seat")
@Api(tags = "Seat", value = "Seat")
@CrossOrigin("*")
public abstract class AbstractSeatController extends AbstractController implements SwaggerableController {
	@Autowired
	protected SeatService seatService;
	
	@Override
	@Bean("Seat")
	public Docket toDocket() {
		return buildDocket("Seat");
		
	}
}
