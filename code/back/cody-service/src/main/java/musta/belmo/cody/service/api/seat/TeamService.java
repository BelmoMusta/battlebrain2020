package musta.belmo.cody.service.api.seat;

import musta.belmo.cody.model.TeamDTO;

import java.util.List;
import java.util.Optional;

public interface TeamService {
	
	Optional<TeamDTO> findOne(Long teamId);
	
	void create(TeamDTO teamDTO);
	
	
	List<TeamDTO> findAll();
}
