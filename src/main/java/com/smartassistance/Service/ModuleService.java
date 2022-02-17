package com.smartassistance.Service;

import com.smartassistance.Model.Module;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ModuleService {
    Module addNewModule(Module newModule);
    Module updateExistModule(Long id, Module module);
    Module retrieveModuleById(Long id);
    List<Module> retrieveAllModule();
    boolean deleteModule(Long id);
}
