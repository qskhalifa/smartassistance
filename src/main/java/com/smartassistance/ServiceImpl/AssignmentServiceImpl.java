package com.smartassistance.ServiceImpl;

import com.smartassistance.Model.Assignment;
import com.smartassistance.Repo.AssignmentRepository;
import com.smartassistance.Service.AssignmentService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AssignmentServiceImpl implements AssignmentService {

    private final AssignmentRepository assignmentRepository;

    @Autowired
    public AssignmentServiceImpl(AssignmentRepository assignmentRepository) {
        this.assignmentRepository = assignmentRepository;
    }

    @Override
    public Assignment createNewAssignment(Assignment assignment) {

        return assignmentRepository.save(assignment);
    }

    @Override
    public Assignment updateExistAssignment(Long assignmentId, Assignment assignment) {
        return null;
    }

    @Override
    public boolean deleteExistAssignment(Long assignmentId) {
        return false;
    }

    @Override
    public List<Assignment> retrieveAllModuleAssignment(Long moduleId) {
        return null;
    }
}
