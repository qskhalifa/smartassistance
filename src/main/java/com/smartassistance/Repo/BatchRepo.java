package com.smartassistance.Repo;

import com.smartassistance.Model.Batch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BatchRepo extends JpaRepository<Batch,Long> {

    Batch findBatchByName(String name);
}
