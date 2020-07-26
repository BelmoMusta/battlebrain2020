package musta.belmo.cody.service.impl.seat;

import musta.belmo.cody.dao.staff.TeamRepository;
import musta.belmo.cody.data.model.staff.Team;
import musta.belmo.cody.model.TeamDTO;
import musta.belmo.cody.service.api.seat.TeamService;
import musta.belmo.cody.service.impl.AbstractCommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TeamServiceImpl extends AbstractCommonService implements TeamService {
	@Autowired
	private TeamRepository teamRepository;
	
	@Override
	public Optional<TeamDTO> findOne(Long teamId) {
		final Team one = teamRepository.findOne(teamId);
		return Optional.ofNullable(one).map(domainDTOMapper::toDTO);
	}
	
	@Override
	public void create(TeamDTO teamDTO) {
		teamRepository.save(domainDTOMapper.toDomain(teamDTO));
	}
}
