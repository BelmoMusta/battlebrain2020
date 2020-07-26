package musta.belmo.cody.rest.controller.reservation;

import io.swagger.annotations.Api;
import musta.belmo.cody.rest.RESTConstantes;
import musta.belmo.cody.rest.controller.AbstractController;
import musta.belmo.cody.rest.controller.swagger.SwaggerableController;
import musta.belmo.cody.service.api.reservation.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import springfox.documentation.spring.web.plugins.Docket;

import static musta.belmo.cody.rest.RESTConstantes.RESERVATION;

@RequestMapping(value = RESTConstantes.ROUTE_RESERVATION)
@Api(tags = RESERVATION, value = RESERVATION)
@CrossOrigin("*")
public abstract class AbstractReservationController extends AbstractController implements SwaggerableController {
	@Autowired
	protected ReservationService reservationService;
	
	@Override
	@Bean(RESTConstantes.RESERVATION)
	public Docket toDocket() {
		return buildDocket(RESTConstantes.RESERVATION);
		
	}
}
