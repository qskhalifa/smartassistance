package com.smartassistance.Controller;

import com.smartassistance.Model.Module;
import com.smartassistance.Service.ModuleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ModuleController {

    private final ModuleService moduleService;

    private final Logger logger = LoggerFactory.getLogger(ModuleController.class);

    @Autowired
    public ModuleController(ModuleService moduleService) {
        this.moduleService = moduleService;
    }

    @RequestMapping(value = "/smart-assistance/api/add-module", method = RequestMethod.POST)
    public ResponseEntity addNewModule(@RequestBody Module module) {

        logger.info("New Request to Add Module");

        Module newModule = moduleService.addNewModule(module);

        if (newModule == null) {
            return new ResponseEntity<>("The Module is already exist in DB", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(newModule, HttpStatus.CREATED);

    }

    @RequestMapping(value = "/smart-assistance/api/update-module/{id}", method = RequestMethod.PUT)
    public ResponseEntity updateExistModule(@RequestBody Module module, @PathVariable("id") Long id) {

        logger.info("Request to update Module");

        Module existModule = moduleService.updateExistModule(id, module);

        if (existModule == null) {
            return new ResponseEntity<>("This Module Doesn't Exist in The DB", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(existModule, HttpStatus.OK);
    }

    @RequestMapping(value = "/smart-assistance/api/module-details/{id}", method = RequestMethod.GET)
    public ResponseEntity retrieveModuleDetails(@PathVariable("id") Long moduleId) {

        logger.info("Request To retrieve Module Details");

        Module existModule = moduleService.retrieveModuleById(moduleId);

        if (existModule == null) {
            return new ResponseEntity<>("Couldn't Find Module with this ID in the DB", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(existModule, HttpStatus.OK);
    }

    @RequestMapping(value = "/smart-assistance/api/all-module", method = RequestMethod.GET)
    public ResponseEntity retrieveAllModules() {
        List<Module> modules = moduleService.retrieveAllModule();
        return new ResponseEntity<>(modules, HttpStatus.OK);
    }

    @RequestMapping(value = "/smart-assistance/api/delete-module/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteModule(@PathVariable("id") Long moduleId) {
        boolean result = moduleService.deleteModule(moduleId);

        if (!result) {
            return  new ResponseEntity<>("This Module doesn't Exist in The DB", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("The Module has been Deleted Successfully", HttpStatus.OK);
    }
}

