package com.smartassistance.Repo;

import com.smartassistance.Model.Module;
import com.smartassistance.Model.Result;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ResultRepository extends JpaRepository<Result, Long> {

    List<Result> findAllByModuleId(Module module);
    Optional<Result> findResultByStudentNumber(int studentNumber);
}