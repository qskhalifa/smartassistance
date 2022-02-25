package com.smartassistance.Repo;

import com.smartassistance.Model.LabInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LabInfoRepository extends JpaRepository<LabInfo, Long> {

    LabInfo findLabInfoByName(String name);

    Optional<LabInfo> findByModule_Id(long id);

    Optional<LabInfo> findByModule_Code(String code);

}
