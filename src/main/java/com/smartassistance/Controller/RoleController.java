package com.smartassistance.Controller;

import com.smartassistance.Model.Role;
import com.smartassistance.Service.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/smart-assistance/api")
public class RoleController {

    private final RoleService roleService;

    private final Logger logger = LoggerFactory.getLogger(RoleController.class);

    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping("/add-role")
    public ResponseEntity addNewRole(@RequestBody Role role) {

        logger.info("Request To Add a New Role");

        Role existRole = roleService.createRole(role);

        if (existRole == null) {
            return new ResponseEntity<>("already Exist in The DB", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(existRole, HttpStatus.CREATED);
    }

    @GetMapping("/all-roles")
    public ResponseEntity retrieveAllRoles() {

        List<Role> roles = roleService.getAllRole();
        return new ResponseEntity<>(roles, HttpStatus.OK);
    }

    @DeleteMapping("/delete-role/{id}")
    public ResponseEntity deleteExistRole(@PathVariable("id") Long roleId) {

        logger.info("Request To Delete a Role");

        if (!roleService.deleteRole(roleId)) {
            return new ResponseEntity<>("Couldn't Find any Role associated with this ID", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Role Has Been Deleted Successfully", HttpStatus.OK);
    }

}




