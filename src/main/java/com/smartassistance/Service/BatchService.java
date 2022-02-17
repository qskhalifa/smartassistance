package com.smartassistance.Service;

import com.smartassistance.Model.Batch;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BatchService {

    Batch addNewBatch (Batch batch);

    Batch updateExistBatch (Batch batch, long batchId);

    Batch retrieveBatchDetails(long batch);

    List<Batch> retrieveAllBatches();

    boolean deleteBatch(long batchId);
}
