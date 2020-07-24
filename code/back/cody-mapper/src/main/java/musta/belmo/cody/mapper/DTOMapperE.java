package musta.belmo.cody.mapper;

import musta.belmo.cody.data.model.places.Seat;
import musta.belmo.cody.data.model.staff.Role;
import musta.belmo.cody.data.model.staff.User;
import musta.belmo.cody.model.RoleDTO;
import musta.belmo.cody.model.SeatDTO;
import musta.belmo.cody.model.UserDTO;

public interface DTOMapperE {

    SeatDTO toDTO(Seat in);

    UserDTO toDTO(User in);
    
    RoleDTO toDTO(Role in);
    
}