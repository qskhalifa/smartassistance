package com.smartassistance.Repo;

import com.smartassistance.Model.AssignmentResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssignmentResultRepository extends JpaRepository<AssignmentResult, Long> {
}