package musta.belmo.cody.service.impl.user;


import musta.belmo.cody.dao.user.UserRepository;
import musta.belmo.cody.data.model.staff.User;
import musta.belmo.cody.mapper.DomainDTOMapper;
import musta.belmo.cody.model.TeamDTO;
import musta.belmo.cody.model.UserRegistrationDTO;
import musta.belmo.cody.service.api.seat.TeamService;
import musta.belmo.cody.service.api.user.RoleService;
import musta.belmo.cody.service.api.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    protected DomainDTOMapper DomainDTOMapper;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private RoleService roleService;
    
    @Autowired
    private TeamService teamService;

    @Override
    public void save(UserRegistrationDTO user) {
        if (user != null) {
            String password = bCryptPasswordEncoder
                    .encode(String.valueOf(user.getPassword()));
            user.setPassword(password);
            User userToSave = DomainDTOMapper.toDomain(user);
            assignRoleToUser("MEMBER", userToSave);
            userRepository.save(userToSave);
        }
    }

    @Override
    public User findByEmail(final String username) {
        return userRepository.findByEmail(username);
    }

    @Override
    public User findById(Long id) {
        return userRepository.findOne(id);
    }

    @Override
    public User getConnectedUser() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = null;
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            userName = authentication.getName();
        }
        return findByEmail(userName);
    }
	
	@Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void assingUserToATeam(Long teamId, String userMail) {
        User user = userRepository.findByEmail(userMail);
        Optional<TeamDTO> optionalTeamDTO = teamService.findOne(teamId);
        if (optionalTeamDTO.isPresent()) {
            user.setTeam(optionalTeamDTO
                    .map(DomainDTOMapper::toDomain)
                    .orElse(null));
            userRepository.save(user);
        }
        
        
    }
	
	private void assignRoleToUser(String roleName, User user) {
        roleService.findByName(roleName)
                .ifPresent(role -> {
                    user.getRoles().add(role);
                });
    }
}