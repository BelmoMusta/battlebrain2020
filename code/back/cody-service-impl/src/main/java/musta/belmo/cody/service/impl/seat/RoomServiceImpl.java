package musta.belmo.cody.service.impl.seat;

import musta.belmo.cody.dao.places.RoomRepository;
import musta.belmo.cody.dao.places.qdsl.RoomQDSLRepository;
import musta.belmo.cody.model.FloorDTO;
import musta.belmo.cody.model.RoomDTO;
import musta.belmo.cody.service.api.exceptions.ContentNotFoundException;
import musta.belmo.cody.service.api.seat.FloorService;
import musta.belmo.cody.service.api.seat.RoomService;
import musta.belmo.cody.service.impl.AbstractCommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RoomServiceImpl extends AbstractCommonService implements RoomService {
	
	@Autowired
	private RoomRepository roomRepository;
	@Autowired
	private RoomQDSLRepository roomQDSLRepository;
	
	@Autowired
	private FloorService floorService;
	
	@Override
	public Optional<RoomDTO> findOne(Long roomId) {
		return Optional.ofNullable(domainDTOMapper.toDTO(roomRepository.findOne(roomId)));
	}
	
	@Override
	public List<RoomDTO> getAllRoomsAtFloor(Long floorId) {
		return roomQDSLRepository.getAllRoomsAtFloor(floorId).stream().map(domainDTOMapper::toDTO)
				.collect(Collectors.toList());
	}
	
	@Override
	public void create(RoomDTO room) {
		roomRepository.save(domainDTOMapper.toDomain(room));
	}
	
	@Override
	public void createAtFloor(RoomDTO room, Long floorId) {
		final FloorDTO floorDTO = floorService.findOne(floorId)
				.orElseThrow(ContentNotFoundException::new);
		room.setFloor(floorDTO);
		create(room);
	}
}
