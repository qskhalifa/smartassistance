package com.smartassistance.Service;

import com.smartassistance.Model.Role;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RoleService {
    Role createRole(Role role);
    boolean deleteRole(Long roleId);
    List<Role> getAllRole();
}
