package com.smartassistance.Repo;

import com.smartassistance.Model.LabResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LabResultRepository extends JpaRepository<LabResult, Long> {
    List<LabResult> findAllByLabInfo_Id(Long labId);
}
