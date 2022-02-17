package com.smartassistance.Repo;

import com.smartassistance.Model.College;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CollegeRepository extends JpaRepository<College, Long> {
    College findCollegeByCode(Integer collegeCode);
}
