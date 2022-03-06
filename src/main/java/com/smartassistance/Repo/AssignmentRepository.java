package com.smartassistance.Repo;

import com.smartassistance.Model.Assignment;
import com.smartassistance.Model.Module;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssignmentRepository extends JpaRepository<Assignment, Long> {
    List<Assignment> findByModule_Id(long id);

    // TODO : GET all Created assignment Name For specific Module

}