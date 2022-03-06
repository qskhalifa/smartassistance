package com.smartassistance.Repo;

import com.smartassistance.Model.Exam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ExamRepository extends JpaRepository<Exam,Long> {
    Optional<Exam> findByNameIgnoreCase(String name);

}
