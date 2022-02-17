package com.smartassistance.ServiceImpl;

import com.smartassistance.Model.Batch;
import com.smartassistance.Repo.BatchRepo;
import com.smartassistance.Service.BatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BatchServiceImp implements BatchService {

    @Autowired
    private BatchRepo batchRepo ;

    @Override
    public Batch addNewBatch(Batch batch) {

        // Check the group name is exist on db
        Batch existBatch = batchRepo.findBatchByName(batch.getName());

        if (existBatch == null){
            return batchRepo.save(batch);
        }

        return null;
    }

    @Override
    public Batch updateExistBatch(Batch batch, long batchId) {

        // Check the group is existed on db.
        Batch existBatch = batchRepo.findById(batchId).orElse(null);

        if (existBatch != null){

            existBatch.setName(batch.getName());
            existBatch.setSize(batch.getSize());
            batchRepo.save(existBatch);
            return existBatch;
        }
        return null ;
    }

    @Override
    public Batch retrieveBatchDetails(long batchId) {
        return batchRepo.findById(batchId).orElse(null);
    }

    @Override
    public List<Batch> retrieveAllBatches() {
        return batchRepo.findAll();
    }


    @Override
    public boolean deleteBatch(long batchId) {

        // Check if the group is existed on db.
        Batch batch = batchRepo.findById(batchId).orElse(null);

        if (batch != null){
            batchRepo.delete(batch);
            return true;
        }
        return false ;
    }
}
