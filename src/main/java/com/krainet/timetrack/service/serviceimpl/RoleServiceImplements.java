package com.krainet.timetrack.service.serviceimpl;

import com.krainet.timetrack.model.Role;
import com.krainet.timetrack.repository.RoleRepository;
import com.krainet.timetrack.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleServiceImplements implements RoleService {

    final RoleRepository roleRepository;

    @Override
    public Role getUserRole() {
        return roleRepository.findById(1L).orElseThrow();
    }

    @Override
    public Role getAdminRole() {
        return roleRepository.findById(2L).orElseThrow();
    }
}
