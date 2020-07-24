package musta.belmo.cody.service.impl.user;


import musta.belmo.cody.dao.user.RoleRepository;
import musta.belmo.cody.data.model.staff.Role;
import musta.belmo.cody.model.RoleDTO;
import musta.belmo.cody.service.api.user.RoleService;
import musta.belmo.cody.service.impl.AbstractCommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl extends AbstractCommonService implements RoleService {
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public RoleDTO create(RoleDTO roleDTO) {
        final Role role = domainDTOMapper.toDomain(roleDTO);
        return domainDTOMapper.toDTO(roleRepository.save(role));
    }

    @Override
    public Optional<RoleDTO> findOne(Long id) {
        return Optional.ofNullable(roleRepository.findOne(id))
                .map(domainDTOMapper::toDTO);
    }

    @Override
    public Set<RoleDTO> findAll() {
        return roleRepository.findAll()
                .stream()
                .map(domainDTOMapper::toDTO)
                .collect(Collectors.toSet());
    }

    @Override
    public RoleDTO update(RoleDTO roleDTO) {
        roleRepository.saveAndFlush(domainDTOMapper.toDomain(roleDTO));
        return roleDTO;
    }

    @Override
    public RoleDTO update(Long id, RoleDTO roleDTO) {
        findOne(id)
                .ifPresent(role -> {
                    Role roleToSave = domainDTOMapper.toDomain(roleDTO);
                    roleToSave.setId(id);
                    roleRepository.saveAndFlush(roleToSave);
                });
        return roleDTO;
    }

    @Override
    public void delete(RoleDTO roleDTO) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Optional<Role> findByName(String roleName) {
        return Optional.ofNullable(roleRepository.findByName(roleName));
    }
}