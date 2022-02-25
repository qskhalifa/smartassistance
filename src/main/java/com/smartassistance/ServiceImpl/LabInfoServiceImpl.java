package com.smartassistance.ServiceImpl;

import com.smartassistance.Model.LabInfo;
import com.smartassistance.Repo.LabInfoRepository;
import com.smartassistance.Service.LabInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LabInfoServiceImpl implements LabInfoService {

    private final LabInfoRepository labInfoRepository;

    @Autowired
    public LabInfoServiceImpl(LabInfoRepository labInfoRepository) {
        this.labInfoRepository = labInfoRepository;
    }

    @Override
    public LabInfo createNewLab(LabInfo labInfo) {
        // Check if there is already lab with this name in the db
        LabInfo existLab = labInfoRepository.findLabInfoByName(labInfo.getName());

        if (existLab == null) {
            return labInfoRepository.save(labInfo);
        }
        return null;
    }

    @Override
    public LabInfo updateExistLab(Long labId, LabInfo labInfo) {
        //check if Lab Exist in the db
        LabInfo existLab = labInfoRepository.findById(labId).orElse(null);

        if (existLab != null) {
            existLab.setModule(labInfo.getModule());
            existLab.setName(labInfo.getName());
            existLab.setProfessor(labInfo.getProfessor());
            return labInfoRepository.save(existLab);
        }
        return null;
    }

    @Override
    public LabInfo retrieveModuleLab(Long moduleId) {
        return labInfoRepository.findByModule_Id(moduleId).orElse(null);
    }

    @Override
    public LabInfo retrieveModuleLabByCode(String moduleCode) {
        return labInfoRepository.findByModule_Code(moduleCode).orElse(null);
    }

    @Override
    public List<LabInfo> retrieveAllLabs() {
        return null;
    }

    @Override
    public boolean deleteExistLab(Long labId) {
        // check if the lab exist in the db
        LabInfo existLab = labInfoRepository.findById(labId).orElse(null);

        if (existLab != null) {
            labInfoRepository.delete(existLab);
            return true;

        }
        return false;
    }
}
