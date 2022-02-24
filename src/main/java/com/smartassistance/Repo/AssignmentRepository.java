package com.smartassistance.Repo;

import com.smartassistance.Model.Assignment;
import com.smartassistance.Model.Module;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssignmentRepository extends JpaRepository<Assignment, Long> {

    // TODO : GET all Created assignment Name For specific Module

    List<Assignment> findAllByModule_Id(Module module);

    List<Assignment> findByModule_CodeIgnoreCase(String code);


}