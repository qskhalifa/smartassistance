package com.smartassistance.ServiceImpl;

import com.smartassistance.Model.Assignment;
import com.smartassistance.Repo.AssignmentRepository;
import com.smartassistance.Service.AssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssignmentServiceImp implements AssignmentService {

    private final AssignmentRepository assignmentRepository;

    @Autowired
    public AssignmentServiceImp(AssignmentRepository assignmentRepository) {
        this.assignmentRepository = assignmentRepository;
    }

    @Override
    public Assignment createNewAssignment(Assignment assignment) {
        return assignmentRepository.save(assignment);
    }

    @Override
    public Assignment updateExistAssignment(Long assignmentId, Assignment assignment) {
        //Check if the assignment already exist in the db
        Assignment existAssignment = assignmentRepository.findById(assignmentId).orElse(null);

        if (existAssignment != null) {

            existAssignment.setBatch(assignment.getBatch());
            existAssignment.setDescription(assignment.getDescription());
            existAssignment.setModule(assignment.getModule());
            existAssignment.setName(assignment.getName());
            return existAssignment;

        }
        return null;
    }

    @Override
    public boolean deleteExistAssignment(Long assignmentId) {
        //Check if the assignment exist in the db
        Assignment existAssignment = assignmentRepository.findById(assignmentId).orElse(null);

        if (existAssignment != null) {
            assignmentRepository.delete(existAssignment);
            return true;
        }
        return false;
    }

    @Override
    public List<Assignment> retrieveAllModuleAssignment(Long moduleId) {
        return assignmentRepository.findByModule_Id(moduleId);
    }
}
