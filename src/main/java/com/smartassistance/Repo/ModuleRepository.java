package com.smartassistance.Repo;

import com.smartassistance.Model.Module;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModuleRepository extends JpaRepository<Module, Long> {
    Module findModuleByName(String name);
}
