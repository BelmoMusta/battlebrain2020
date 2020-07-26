package musta.belmo.cody.mapper;

import musta.belmo.cody.data.model.places.Floor;
import musta.belmo.cody.data.model.places.Room;
import musta.belmo.cody.data.model.places.Seat;
import musta.belmo.cody.data.model.scheduling.Reservation;
import musta.belmo.cody.data.model.staff.Role;
import musta.belmo.cody.data.model.staff.Team;
import musta.belmo.cody.data.model.staff.User;
import musta.belmo.cody.model.FloorDTO;
import musta.belmo.cody.model.ReservationDTO;
import musta.belmo.cody.model.RoleDTO;
import musta.belmo.cody.model.RoomDTO;
import musta.belmo.cody.model.SeatDTO;
import musta.belmo.cody.model.TeamDTO;
import musta.belmo.cody.model.UserDTO;

public interface DTOMapperE {
	
	SeatDTO toDTO(Seat in);
	
	UserDTO toDTO(User in);
	
	RoleDTO toDTO(Role in);
	
	ReservationDTO toDTO(Reservation in);
	
	RoomDTO toDTO(Room in);
	
	FloorDTO toDTO(Floor in);
	
	TeamDTO toDTO(Team in);
}