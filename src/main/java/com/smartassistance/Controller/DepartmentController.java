package com.smartassistance.Controller;

import com.smartassistance.Model.Department;
import com.smartassistance.Service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@CrossOrigin
@RestController
@RequestMapping("/smart-assistance/api")
public class DepartmentController {

    private final DepartmentService departmentService;

    private final Logger logger = LoggerFactory.getLogger(DepartmentController.class);

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping("/add-department")
    public ResponseEntity addNewDepartment(@RequestBody Department department) {

        logger.info("Request To Add New Department");

        Department newDepartment = departmentService.createDepartment(department);

        if (newDepartment == null) {
            return new ResponseEntity<>("The Department is already exist in the DB", HttpStatus.ACCEPTED);
        }

        return new ResponseEntity<>(newDepartment, HttpStatus.CREATED);
    }

    @GetMapping("/department-details/{id}")
    public ResponseEntity retrieveDepartmentDetails(@PathVariable("id") Long departmentId) {

        logger.info("Request to Retrieve Department Details");
        // Check if there is department with this ID in the DB
        Department existDepartment = departmentService.getDepartmentById(departmentId);

        if (existDepartment == null) {
            return new ResponseEntity<>("Couldn't Find Department with the given ID", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(existDepartment, HttpStatus.BAD_REQUEST);

    }

    @GetMapping("/department-details/code/{code}")
    public ResponseEntity retrieveDeptByCode(@PathVariable("code") Integer departmentCode) {

        logger.info("Request to Retrieve Department Details by Code");

        // Check if there is department with this Code in the DB
        Department existDepartment = departmentService.getDepartmentByCode(departmentCode);

        if (existDepartment == null) {
            return new ResponseEntity<>("Couldn't Find Department with this Code", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(existDepartment, HttpStatus.OK);

    }

    @PutMapping("update-department/{id}")
    public ResponseEntity updateDepartment(@RequestBody Department department, @PathVariable("id") Long departmentId) {
        logger.info("Request to Update Department Details");

        Department existDepartment = departmentService.updateDepartment(department, departmentId);

        if (existDepartment == null) {
            return new ResponseEntity<>("Couldn't Find Department with this ID", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(existDepartment, HttpStatus.OK);

    }

    @DeleteMapping("delete-department/{id}")
    public ResponseEntity deleteDepartment(@PathVariable("id") Long departmentId) {
        boolean result = departmentService.deleteDepartment(departmentId);
        if (!result) {
            return new ResponseEntity<>("Couldn't Find Department with this ID", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("The Department Had been Deleted Successfully", HttpStatus.OK);
    }

}








