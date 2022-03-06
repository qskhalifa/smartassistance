package com.smartassistance.Service;

import com.smartassistance.DTOs.AssignmentDTO;
import com.smartassistance.Model.AssignmentResult;

import java.util.List;

public interface AssignmentResultService {

    List<AssignmentDTO> insertAssignmentResult(List<AssignmentDTO> assignmentDTOS);

    boolean deleteAssignmentResult(Long assignmentResultId);

    AssignmentResult updateAssignmentResult (Long assignmentResultId, AssignmentResult assignmentResult);
        //TODO Make assignment Result created automatic when assignment created


}
