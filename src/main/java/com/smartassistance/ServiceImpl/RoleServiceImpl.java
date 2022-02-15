package com.smartassistance.ServiceImpl;

import com.smartassistance.Model.Role;
import com.smartassistance.Repo.RoleRepository;
import com.smartassistance.Service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role createRole(Role role) {
        // Checking if there is already Exist Role with this name in the DB
        Role existRole = roleRepository.findRoleByName(role.getName()).orElse(null);

        if (existRole == null) {
            return roleRepository.save(role);
        }
        return null;
    }

    @Override
    public boolean deleteRole(Long roleId) {
        // Checking if there associated Role with given ID
       return roleRepository.findById(roleId).isPresent();
    }

    @Override
    public List<Role> getAllRole() {
        return roleRepository.findAll();
    }
}
