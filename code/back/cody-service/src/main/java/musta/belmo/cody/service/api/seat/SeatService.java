package musta.belmo.cody.service.api.seat;

import musta.belmo.cody.data.model.staff.User;
import musta.belmo.cody.model.SeatDTO;
import musta.belmo.cody.service.api.AbstractCrudService;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface SeatService extends AbstractCrudService<SeatDTO> {

    Set<SeatDTO> findAllForUser();

    Optional<SeatDTO> findOne(Long id, User user);
    
    List<SeatDTO> getAllSeatsAtFloor(Long floorId);
    
    List<SeatDTO> getAllSeatsAtRoom(Long roomId);
    
    void createAtRoom(SeatDTO seat, Long roomId);
    
    List<SeatDTO> getAllSeatsForATeam(Long teamId);
    
    List<SeatDTO> getReservationsInAGivenRoom(Long roomId);
}
