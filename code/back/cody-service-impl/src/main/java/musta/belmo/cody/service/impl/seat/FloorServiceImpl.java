package musta.belmo.cody.service.impl.seat;

import musta.belmo.cody.dao.places.FloorRepository;
import musta.belmo.cody.dao.places.qdsl.FloorQDSLRepository;
import musta.belmo.cody.data.model.places.Floor;
import musta.belmo.cody.model.FloorDTO;
import musta.belmo.cody.service.api.seat.FloorService;
import musta.belmo.cody.service.impl.AbstractCommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FloorServiceImpl extends AbstractCommonService implements FloorService {
	
	@Autowired
	private FloorRepository floorRepository;
	@Autowired
	private FloorQDSLRepository floorQDSLRepository;
	
	@Override
	public Optional<FloorDTO> findOne(Long floorId) {
		return Optional.ofNullable(floorRepository.findOne(floorId))
				.map(domainDTOMapper::toDTO);
	}
	
	@Override
	public void create(FloorDTO floorDTO) {
		Floor floor = domainDTOMapper.toDomain(floorDTO);
		floorRepository.save(floor);
	}
}
