package com.smartassistance.Service;

import com.smartassistance.Model.College;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface CollegeService {

    College createCollege(College college);
    College getCollegeById(Long collegeId);
    College getCollegeByCode(Integer collegeCode);
    College updateCollege(Long collegeId, College college);
    boolean deleteCollegeById(Long collegeId);
    List<College> getAllCollege();
}
