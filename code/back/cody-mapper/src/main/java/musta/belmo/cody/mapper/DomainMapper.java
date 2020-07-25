package musta.belmo.cody.mapper;

import musta.belmo.cody.data.model.places.Seat;
import musta.belmo.cody.data.model.scheduling.Reservation;
import musta.belmo.cody.data.model.staff.Role;
import musta.belmo.cody.data.model.staff.User;
import musta.belmo.cody.model.ReservationDTO;
import musta.belmo.cody.model.RoleDTO;
import musta.belmo.cody.model.SeatDTO;
import musta.belmo.cody.model.UserDTO;
import musta.belmo.cody.model.UserRegistrationDTO;

public interface DomainMapper {
	Seat toDomain(SeatDTO in);
	
	User toDomain(UserDTO in);
	
	User toDomain(UserRegistrationDTO in);
	
	Role toDomain(RoleDTO in);
	
	Reservation toDomain(ReservationDTO in);
	
}