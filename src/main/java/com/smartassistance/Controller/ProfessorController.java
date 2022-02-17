package com.smartassistance.Controller;

import com.smartassistance.Model.Professor;
import com.smartassistance.Service.ProfessorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProfessorController {

    private final ProfessorService professorService;

    private final Logger logger = LoggerFactory.getLogger(ProfessorController.class);
    @Autowired
    public ProfessorController(ProfessorService professorService) {
        this.professorService = professorService;
    }

    @RequestMapping(value = "/smart-assistance/api/add-professor", method = RequestMethod.POST)
    public ResponseEntity addNewProfessor(@RequestBody Professor professor) {

        logger.info("Request to Add New Professor");

        Professor newProfessor = professorService.addNewProfessor(professor);

        if (newProfessor == null) {
            return new ResponseEntity<>("The Professor is already Exist in The DB", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(newProfessor, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/smart-assistance/api/update-professor/{id}", method = RequestMethod.PUT)
    public ResponseEntity updateProfessor(@RequestBody Professor professor, @PathVariable("id") Long professorId) {

        logger.info("Request To Update Professor");

        Professor existProfessor = professorService.updateExistProfessor(professor, professorId);

        if (existProfessor == null) {
            return new ResponseEntity<>("This Professor Doesn't Exist in The DB", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(existProfessor, HttpStatus.OK);
    }

    @RequestMapping(value = "/smart-assistance/api/professor-details/{id}", method = RequestMethod.GET)
    public ResponseEntity retrieveProfessorDetails(@PathVariable("id") Long professorId) {

        logger.info("Request To retrieve Professor Details");

        Professor existProfessor = professorService.retrieveProfessorDetails(professorId);

        if (existProfessor == null) {
            return new ResponseEntity<>("Couldn't Find Professor with this ID", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(existProfessor, HttpStatus.OK);
    }

    @RequestMapping(value = "/smart-assistance/api/all-professors", method = RequestMethod.GET)
    public ResponseEntity retrieveAllProfessors() {

        List<Professor> professors = professorService.retrieveAllProfessor();
        return new ResponseEntity<>(professors, HttpStatus.OK);
    }

    @RequestMapping(value = "/smart-assistance/api/delete-professor/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteProfessor(@PathVariable("id") Long professorId) {

        boolean result = professorService.deleteProfessor(professorId);

        if (!result) {
            return new ResponseEntity<>("This Professor Doesn't Exist in The DB", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>("The Professor had been deleted Successfully", HttpStatus.OK);
    }
}
