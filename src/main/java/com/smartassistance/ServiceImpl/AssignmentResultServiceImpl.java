package com.smartassistance.ServiceImpl;

import com.smartassistance.DTOs.AssignmentDTO;
import com.smartassistance.Model.AssignmentResult;
import com.smartassistance.Repo.AssignmentResultRepository;
import com.smartassistance.Service.AssignmentResultService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AssignmentResultServiceImpl implements AssignmentResultService {

    private final AssignmentResultRepository assignmentResultRepository;

    @Autowired
    public AssignmentResultServiceImpl(AssignmentResultRepository assignmentResultRepository) {
        this.assignmentResultRepository = assignmentResultRepository;
    }

    @Override
    public boolean deleteAssignmentResult(Long assignmentResultId) {
        //Check if the assignment exist in the db
        AssignmentResult existAssignment = assignmentResultRepository.findById(assignmentResultId).orElse(null);

        if (existAssignment != null) {
           assignmentResultRepository.delete(existAssignment);
            return true;
        }
        return false;
    }

    @Override
    public List<AssignmentDTO> insertAssignmentResult(List<AssignmentDTO> assignmentDTOS) {
        //TODO
        return null;
    }

    @Override
    public AssignmentResult updateAssignmentResult(Long assignmentResultId, AssignmentResult assignmentResult) {
        AssignmentResult existAssignmentResult = assignmentResultRepository.findById(assignmentResultId).orElse(null);

        if (existAssignmentResult != null) {
            existAssignmentResult.setMark(assignmentResult.getMark());
            return existAssignmentResult;
        }
        return null;
    }
}
