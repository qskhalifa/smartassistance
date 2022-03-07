package com.smartassistance.Controller;

import com.smartassistance.Model.College;
import com.smartassistance.Service.CollegeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/smart-assistance/api")
public class CollegeController {

    private final CollegeService collegeService;

    private final Logger logger = LoggerFactory.getLogger(CollegeController.class);

    @Autowired
    public CollegeController(CollegeService collegeService) {
        this.collegeService = collegeService;
    }

    @PostMapping("/add-college")
    public ResponseEntity addNewCollege(@RequestBody College college) {

        logger.info("Request To Add New College");

        College newCollege = collegeService.createCollege(college);

        if (newCollege == null) {
            return new ResponseEntity<>("College already Exist in The DB", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(newCollege, HttpStatus.CREATED);
    }

    @GetMapping("/college-details/{id}")
    public ResponseEntity retrieveCollegeDetails(@PathVariable("id") Long collegeId) {

        logger.info("Request To Retrieve College Details");

        College existCollege = collegeService.getCollegeById(collegeId);

        if (existCollege == null) {
            return new ResponseEntity<>("Couldn't Find College with the given ID", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(existCollege, HttpStatus.OK);
    }

    @GetMapping("/college-code/{code}")
    public ResponseEntity retrieveCollegeByCode(@PathVariable("code") Integer collegeCode) {

        logger.info("Request To Retrieve College Details");

        College existCollege = collegeService.getCollegeByCode(collegeCode);

        if (existCollege == null) {
            return new ResponseEntity<>("Couldn't Find College with the given Code", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(existCollege, HttpStatus.OK);

    }

    @PutMapping("/update-college/{id}")
    public ResponseEntity updateCollegeDetails(@RequestBody College college, @PathVariable("id") Long collegeID) {

        logger.info("Request To update Existing College Details");

        College existCollege = collegeService.updateCollege(collegeID, college);

        if (existCollege == null) {
            return new ResponseEntity<>("Couldn't Find College with the given ID", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(existCollege, HttpStatus.OK);

    }

    @GetMapping("/all-college")
    public ResponseEntity retrieveAllCollege() {
        List<College> colleges = collegeService.getAllCollege();
        return new ResponseEntity<>(colleges, HttpStatus.OK);
    }

    @DeleteMapping("delete-college/{id}")
    public ResponseEntity deleteExistCollege(@PathVariable("id") Long collegeId) {
        //Checking if there is college with the given ID
        boolean result = collegeService.deleteCollegeById(collegeId);

        if (!result) {
            return new ResponseEntity<>("There is No College with This ID", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>("College Had Been Deleted Successfully", HttpStatus.OK);
    }






}




