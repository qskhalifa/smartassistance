package com.smartassistance.Controller;

import com.smartassistance.Model.LabInfo;
import com.smartassistance.Service.LabInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LabInfoController {

    private final Logger logger = LoggerFactory.getLogger(LabInfoController.class);

    private final LabInfoService labInfoService;

    @Autowired
    public LabInfoController(LabInfoService labInfoService) {
        this.labInfoService = labInfoService;
    }

    @PostMapping("/labs")
    public ResponseEntity createLab(@RequestBody LabInfo labInfo) {

        logger.info("Request To Create New Lab");

        LabInfo existLab = labInfoService.createNewLab(labInfo);

        if (existLab == null) {

            return new ResponseEntity<>("There is Lab in the db with this name", HttpStatus.BAD_REQUEST);

        }
        return new ResponseEntity<>(existLab, HttpStatus.CREATED);
    }

    @GetMapping("/labs")
    public ResponseEntity getAllLabs() {
        List<LabInfo> labInfos = labInfoService.retrieveAllLabs();

        return new ResponseEntity<>(labInfos, HttpStatus.OK);
    }

    @GetMapping("/labs/{id}")
    public ResponseEntity getLabDetails(@PathVariable("id") Long moduleId) {

        logger.info("Request To retrieve Lab details");

        LabInfo existLab = labInfoService.retrieveModuleLab(moduleId);

        if (existLab == null) {

            return new ResponseEntity<>("this module has no register Lab", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(existLab, HttpStatus.OK);
    }

    @PutMapping("/labs/{id}")
    public ResponseEntity updateLabInfo(@PathVariable("id") Long labId, @RequestBody LabInfo labInfo) {

        logger.info("Request To update Lab info");

        LabInfo existLab = labInfoService.updateExistLab(labId, labInfo);

        if (existLab == null) {
            return new ResponseEntity<>("Couldn't find Lab with this id", HttpStatus.NOT_FOUND);

        }

        return new ResponseEntity<>(existLab, HttpStatus.OK);
    }

    @DeleteMapping("/labs/{id}")
    public ResponseEntity deleteExistLab(@PathVariable("id") Long labId) {
        boolean result = labInfoService.deleteExistLab(labId);

        if (!result) {

            return new ResponseEntity<>("Couldn't find Lab with this id", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
    }



}
