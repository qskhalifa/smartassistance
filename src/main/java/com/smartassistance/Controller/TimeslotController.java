package com.smartassistance.Controller;

import com.smartassistance.Model.Timeslot;
import com.smartassistance.Service.TimeslotService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/smart-assistance/api")
public class TimeslotController {

    private final TimeslotService timeslotService;

    private final Logger logger = LoggerFactory.getLogger(TimeslotController.class);

    @Autowired
    public TimeslotController(TimeslotService timeslotService) {
        this.timeslotService = timeslotService;
    }

    @PostMapping("/add-timeslot")
    public ResponseEntity addNewTimeslot(@RequestBody Timeslot timeslot) {

        logger.info("Request To Add a New Timeslot");

        Timeslot newTimeslot = timeslotService.createTimeslot(timeslot);

        if (newTimeslot != null) {
            return new ResponseEntity<>(newTimeslot, HttpStatus.CREATED);
        }

        return new ResponseEntity<>("already Exist in the DB", HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/timeslot-details/{id}")
    public ResponseEntity retrieveTimeslot(@PathVariable("id") Long timeslotId) {
        logger.info("Request To Retrieve Timeslot");

        Timeslot timeslot = timeslotService.getTimeslotById(timeslotId);

        if (timeslot == null) {
            return new ResponseEntity<>("Couldn't Find any Timeslot with this ID",HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(timeslot, HttpStatus.OK);
    }

    @GetMapping("/all-timeslot")
    public ResponseEntity retrieveAllTimeslot() {

        List<Timeslot> timeslots = timeslotService.getAllSlots();
        return new ResponseEntity<>(timeslots, HttpStatus.OK);
    }

    @PutMapping("/update-timeslot/{id}")
    public ResponseEntity updateTimeslot(@RequestBody Timeslot timeslot, @PathVariable("id") Long timeslotId) {

        logger.info("Request to Update a Timeslot");

        Timeslot existTimeslot = timeslotService.updateTimeslot(timeslotId, timeslot);

        if (existTimeslot == null) {
            return new ResponseEntity<>("Couldn't Find any Timeslot with this ID", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(existTimeslot, HttpStatus.OK);

    }

    @DeleteMapping("/delete-timeslot/{id}")
    public ResponseEntity deleteExistingTimeslot(@PathVariable("id") Long timeslotId) {
        // Check if there is room with the given id in the DB
        boolean existTimeslot = timeslotService.deleteTimeslot(timeslotId);

        if (!existTimeslot) {
            return new ResponseEntity<>("Couldn't Find any Timeslot with this ID", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>("The Timeslot Had been Deleted Successfully", HttpStatus.OK);
    }

}









