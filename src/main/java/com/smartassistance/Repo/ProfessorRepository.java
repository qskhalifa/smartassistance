package com.smartassistance.Repo;

import com.smartassistance.Model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {
   Optional<Professor> findProfessorByName(String name);

}
