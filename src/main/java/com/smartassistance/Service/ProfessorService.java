package com.smartassistance.Service;

import com.smartassistance.Model.Professor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProfessorService {
    Professor addNewProfessor(Professor professor);
    Professor updateExistProfessor(Professor professor, Long id);
    Professor retrieveProfessorDetails(Long professorId);
    Professor retrieveProfessorDetailsByName(String name);
    List<Professor> retrieveAllProfessor();
    boolean deleteProfessor(Long professorId);

}
