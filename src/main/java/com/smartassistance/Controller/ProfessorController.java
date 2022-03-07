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
@CrossOrigin
@RestController
@RequestMapping("/smart-assistant/api")
public class ProfessorController {

    private final ProfessorService professorService;

    private final Logger logger = LoggerFactory.getLogger(ProfessorController.class);
    @Autowired
    public ProfessorController(ProfessorService professorService) {
        this.professorService = professorService;
    }

    @PostMapping("/professor")
    public ResponseEntity addNewProfessor(@RequestBody Professor professor) {

        logger.info("Request to Add New Professor");

        Professor newProfessor = professorService.addNewProfessor(professor);

        if (newProfessor == null) {
            return new ResponseEntity<>("The Professor is already Exist in The DB", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(newProfessor, HttpStatus.CREATED);
    }

     @PutMapping("/professor/{id}")
     public ResponseEntity updateProfessor(@RequestBody Professor professor, @PathVariable("id") Long professorId) {

        logger.info("Request To Update Professor");

        Professor existProfessor = professorService.updateExistProfessor(professor, professorId);

        if (existProfessor == null) {
            return new ResponseEntity<>("This Professor Doesn't Exist in The DB", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(existProfessor, HttpStatus.OK);
    }

    @GetMapping("/professor")
    public ResponseEntity retrieveProfessorDetails(@PathVariable("id") Long professorId) {

        logger.info("Request To retrieve Professor Details");

        Professor existProfessor = professorService.retrieveProfessorDetails(professorId);

        if (existProfessor == null) {
            return new ResponseEntity<>("Couldn't Find Professor with this ID", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(existProfessor, HttpStatus.OK);
    }

    @DeleteMapping("/professor")
    public ResponseEntity retrieveAllProfessors() {

        List<Professor> professors = professorService.retrieveAllProfessor();
        return new ResponseEntity<>(professors, HttpStatus.OK);
    }

    @DeleteMapping("/professor/{id}")
    public ResponseEntity deleteProfessor(@PathVariable("id") Long professorId) {

        boolean result = professorService.deleteProfessor(professorId);

        if (!result) {
            return new ResponseEntity<>("This Professor Doesn't Exist in The DB", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>("The Professor had been deleted Successfully", HttpStatus.OK);
    }

    @GetMapping("/professor/{name}")
    public ResponseEntity getByName(@PathVariable("name") String profName) {
        logger.info("Request To retrieve Professor Details");

        Professor existProfessor = professorService.retrieveProfessorDetailsByName(profName);

        if (existProfessor == null) {
            return new ResponseEntity<>("Couldn't Find Professor with this Name", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(existProfessor, HttpStatus.OK);
    }
}
