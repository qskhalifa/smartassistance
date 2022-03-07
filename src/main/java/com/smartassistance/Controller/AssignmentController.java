package com.smartassistance.Controller;

import com.smartassistance.Model.Assignment;
import com.smartassistance.Service.AssignmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/api")
public class AssignmentController {

    private final AssignmentService assignmentService;

    private final Logger logger = LoggerFactory.getLogger(AssignmentController.class);

    @Autowired
    public AssignmentController(AssignmentService assignmentService) {
        this.assignmentService = assignmentService;
    }

    @GetMapping("/assignments/{id}")
    public ResponseEntity getAllAssignmentForModule(@PathVariable("id") Long moduleId) {
        List<Assignment> assignments = assignmentService.retrieveAllModuleAssignment(moduleId);

        return new ResponseEntity<>(assignments, HttpStatus.OK);
    }

    @PostMapping("/assignments")
    public ResponseEntity createAssignment(@RequestBody Assignment assignment) {

        logger.info("Request to create New Assignment ");

        Assignment existAssignment = assignmentService.createNewAssignment(assignment);

        if (existAssignment == null) {
            return new ResponseEntity<>("Assignment Already Exist in the DB", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(existAssignment, HttpStatus.CREATED);
    }

    @PutMapping("/assignments/{id}")
    public ResponseEntity updateAssignment(@PathVariable("id") Long assignmentId, @RequestBody Assignment assignment) {
        logger.info("Request To Update Assignment");

        Assignment existAssignment = assignmentService.updateExistAssignment(assignmentId, assignment);

        if (existAssignment == null) {
            return new ResponseEntity<>("Couldn't Find any assignment with the given id ", HttpStatus.NOT_FOUND);

        }

        return new ResponseEntity<>(existAssignment, HttpStatus.OK);
    }

    @DeleteMapping("/assignments/{id}")
    public ResponseEntity deleteAssignment(@PathVariable("id") Long assignmentId) {

        logger.info("Request To Delete Assignment");
        boolean result = assignmentService.deleteExistAssignment(assignmentId);

        if ( !result) {
            return new ResponseEntity<>("Couldn't Find any assignment in the DB", HttpStatus.NOT_FOUND);

        }

        return new ResponseEntity<>("Assignment Deleted Successfully", HttpStatus.OK);
    }





}
