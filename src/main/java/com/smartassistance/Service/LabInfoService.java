package com.smartassistance.Service;

import com.smartassistance.Model.LabInfo;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface LabInfoService {

    LabInfo createNewLab (LabInfo labInfo);

    LabInfo updateExistLab (Long labId, LabInfo labInfo);

    LabInfo retrieveModuleLab (Long moduleId);

    List<LabInfo> retrieveAllLabs ();

    boolean deleteExistLab (Long labId);
}
