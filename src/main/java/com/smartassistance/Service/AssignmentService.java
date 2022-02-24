package com.smartassistance.Service;

import com.smartassistance.Model.Assignment;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface AssignmentService {

    Assignment createNewAssignment(Assignment assignment);
    Assignment updateExistAssignment(Long assignmentId, Assignment assignment);
    boolean deleteExistAssignment(Long assignmentId);
    List<Assignment> retrieveAllModuleAssignment (Long moduleId);

}
