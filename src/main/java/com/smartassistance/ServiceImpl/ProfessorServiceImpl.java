package com.smartassistance.ServiceImpl;

import com.smartassistance.Model.Professor;
import com.smartassistance.Repo.ProfessorRepository;
import com.smartassistance.Service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProfessorServiceImpl implements ProfessorService {

    private final ProfessorRepository professorRepository;

    @Autowired
    public ProfessorServiceImpl(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    @Override
    public Professor addNewProfessor(Professor professor) {
        //check if the professor already exist in the DB
        Professor existProfessor = professorRepository.findProfessorByName(professor.getName());

        if (existProfessor == null) {
            return professorRepository.save(professor);
        }
        return null;
    }

    @Override
    public Professor updateExistProfessor(Professor professor, Long id) {
        //check if the professor exist in the DB
        Professor existProfessor = professorRepository.findById(id).orElse(null);

        if (existProfessor != null) {

            existProfessor.setName(professor.getName());
            existProfessor.setAddress(professor.getAddress());
            existProfessor.setModules(professor.getModules());
            existProfessor.setPhone(professor.getPhone());
            professorRepository.save(existProfessor);
            return existProfessor;
        }
        return null;
    }

    @Override
    public Professor retrieveProfessorDetails(Long professorId) {
        return professorRepository.findById(professorId).orElse(null);
    }

    @Override
    public List<Professor> retrieveAllProfessor() {
        return professorRepository.findAll();
    }

    @Override
    public boolean deleteProfessor(Long professorId) {
        //Check if Professor Existed in The DB
        Professor professor = professorRepository.findById(professorId).orElse(null);
        if (professor != null) {
            professorRepository.delete(professor);
            return true;
        }
        return false;
    }
}
