package com.smartassistance.ServiceImpl;

import com.smartassistance.DTOs.LabDTO;
import com.smartassistance.Model.LabResult;
import com.smartassistance.Repo.LabResultRepository;
import com.smartassistance.Service.LabResultService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class LabResultServiceImpl implements LabResultService {

    private final LabResultRepository labResultRepository;

    @Autowired
    public LabResultServiceImpl(LabResultRepository labResultRepository) {
        this.labResultRepository = labResultRepository;
    }



    @Override
    public List<LabResult> retrieveLabResult(Long labInfoId) {
        return labResultRepository.findAllByLabInfo_Id(labInfoId);
    }

    @Override
    public List<LabResult> createLabResult(List<LabDTO> labDTOS) {
        //TODO
        return null;
    }

    @Override
    public LabResult updateLabResult(Long labResultId, LabResult labResult) {
        //Check if there is Lab in the db with the given id
        LabResult existLab = labResultRepository.findById(labResultId).orElse(null);

        if (existLab != null) {

            existLab.setStudent(labResult.getStudent());
            existLab.setResult(labResult.getResult());
            return existLab;
        }

        return null;
    }

    @Override
    public boolean deleteLabResult(Long labResultId) {
        // check if there is Lab Result in the db
        LabResult existLab = labResultRepository.findById(labResultId).orElse(null);

        if (existLab != null) {
            labResultRepository.delete(existLab);
            return true;
        }

        return false;
    }
}
