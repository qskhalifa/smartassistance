package com.smartassistance.Controller;

import com.smartassistance.Model.Batch;
import com.smartassistance.Service.BatchService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 *  Created By Qusay Sami on 1/10/22
 */

@RestController
public class BatchController {

    @Autowired
    private BatchService batchService ;

    private final Logger logger = LoggerFactory.getLogger(BatchController.class);

    @RequestMapping(value = "/smart-assistance/api/add-batch", method = RequestMethod.POST)
    public ResponseEntity addNewBatch(@RequestBody Batch batch){

        logger.info("New request to add batch");

        Batch newBatch = batchService.addNewBatch(batch);

        if (newBatch == null){
            return new ResponseEntity<>("The batch is already exist on db.", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(newBatch,HttpStatus.OK);
    }

    @RequestMapping(value = "/smart-assistance/api/update-batch/{batchId}", method = RequestMethod.PUT)
    public ResponseEntity updateExistBatch(@RequestBody Batch batch, @PathVariable long batchId){

        logger.info("Request to update exist batch.");

        Batch existBatch = batchService.updateExistBatch(batch,batchId);

        if (existBatch == null){
            return new ResponseEntity<>("The batch doesn't exist on db !",HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(existBatch,HttpStatus.OK);
    }

    @RequestMapping(value = "/smart-assistance/api/batch-details/{batchId}", method = RequestMethod.GET)
    public ResponseEntity retrieveBatchDetails(@PathVariable long batchId){

        logger.info("Request to retrieve batch details");

        Batch group = batchService.retrieveBatchDetails(batchId);

        if (group == null){
            return new ResponseEntity<>("The batch doesn't exist on db !",HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(group,HttpStatus.OK);
    }

    @RequestMapping(value = "/smart-assistance/api/all-batches", method = RequestMethod.GET)
    public ResponseEntity retrieveAllBatches(){

        List<Batch> batches = batchService.retrieveAllBatches();
        return new ResponseEntity<>(batches,HttpStatus.OK);
    }

    @RequestMapping(value = "/smart-assistance/api/delete-batch/{batchId}", method = RequestMethod.GET)
    public ResponseEntity deleteGroup(@PathVariable long batchId){

        boolean result = batchService.deleteBatch(batchId);

        if (!result){
            return new ResponseEntity<>("The batch doesn't exist on db !",HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>("The batch has been deleted successfully",HttpStatus.OK);
    }

}
