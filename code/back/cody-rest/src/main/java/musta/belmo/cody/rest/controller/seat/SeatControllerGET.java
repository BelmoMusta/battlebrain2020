package musta.belmo.cody.rest.controller.seat;

import com.querydsl.core.types.Predicate;
import io.swagger.annotations.ApiOperation;
import musta.belmo.cody.data.model.places.Seat;
import musta.belmo.cody.model.SearchSeatDTO;
import musta.belmo.cody.model.SeatDTO;
import musta.belmo.cody.rest.annotation.IsMember;
import musta.belmo.cody.service.api.exceptions.ContentNotFoundException;
import musta.belmo.cody.service.api.seat.SeatService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class SeatControllerGET extends AbstractSeatController {
	
	@GetMapping("/{id}")
	@ApiOperation("gets a seat by its id")
	@IsMember
	public SeatDTO findOne(@PathVariable Long id) {
		return seatService.findOne(id, userService.getConnectedUser())
				.orElseThrow(ContentNotFoundException::new);
	}
	
	@GetMapping("/test/{id}")
	@ApiOperation("gets a seat by its id")
	@IsMember
	public SeatDTO findOnewhenNull(@PathVariable Long id) {
		return seatService.findOne(null)
				.orElseThrow(ContentNotFoundException::new);
	}
	
	@GetMapping("/")
	@ApiOperation("gets the list of all the seats for the current user")
	@IsMember
	public Set<SeatDTO> findAll() {
		return seatService.findAllForUser();
	}
	
	@GetMapping("/search")
	public Page<SeatDTO> getAllByQueryDsl(
			@QuerydslPredicate(root = Seat.class, bindings = SeatService.class) Predicate predicate,
			@PageableDefault(sort = {"createdAt"}, direction = Sort.Direction.DESC) SearchSeatDTO
					
					example, Pageable pageable) {
		return seatService.getAllByQueryDsl(predicate, pageable);
	}
}
