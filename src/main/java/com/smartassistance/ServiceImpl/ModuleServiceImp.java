package com.smartassistance.ServiceImpl;

import com.smartassistance.Model.Module;
import com.smartassistance.Repo.ModuleRepository;
import com.smartassistance.Service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ModuleServiceImp implements ModuleService {

    private final ModuleRepository moduleRepository;

    @Autowired
    public ModuleServiceImp(ModuleRepository moduleRepository) {
        this.moduleRepository = moduleRepository;
    }

    @Override
    public Module addNewModule(Module newModule) {
        //Check if there already subject with that name
        Module existModule = moduleRepository.findModuleByName(newModule.getName());

        if (existModule == null) {
            return moduleRepository.save(newModule);
        }
        return null;
    }

    @Override
    public Module updateExistModule(Long id, Module module) {
        // Check if there is module with this id in the DB
        Module existModule = moduleRepository.findById(id).orElse(null);
        if (existModule != null) {

            existModule.setName(module.getName());
            existModule.setCode(module.getCode());
            existModule.setProfessors(module.getProfessors());
            moduleRepository.save(existModule);
            return existModule;
        }
        return null;
    }

    @Override
    public Module retrieveModuleById(Long id) {
        return moduleRepository.findById(id).orElse(null);
    }

    @Override
    public List<Module> retrieveAllModule() {
        return moduleRepository.findAll();
    }

    @Override
    public boolean deleteModule(Long id) {

        //check if there is module with that id in the DB
        Module existModule = moduleRepository.findById(id).orElse(null);

        if (existModule != null) {
            moduleRepository.delete(existModule);
            return true;
        }
        return false;
    }
}
