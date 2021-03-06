package com.smartassistance.Service;

import com.smartassistance.DTOs.LabDTO;
import com.smartassistance.Model.LabResult;

import java.util.List;

public interface LabResultService {

    List<LabResult> retrieveLabResult (Long labInfoId);

    List<LabResult> createLabResult (List<LabDTO> labDTOS);

    LabResult updateLabResult (Long labResultId, LabResult labResult);

    boolean deleteLabResult (Long labResultId);
    // TODO : Make Stored Procedure to initialize the Created lab the students
}
