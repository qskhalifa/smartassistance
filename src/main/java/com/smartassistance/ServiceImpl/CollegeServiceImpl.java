package com.smartassistance.ServiceImpl;

import com.smartassistance.Model.College;
import com.smartassistance.Repo.CollegeRepository;
import com.smartassistance.Service.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CollegeServiceImpl implements CollegeService {

    private final CollegeRepository collegeRepository;

    @Autowired
    public CollegeServiceImpl(CollegeRepository collegeRepository) {
        this.collegeRepository = collegeRepository;
    }

    @Override
    public College createCollege(College college) {
        // Checking if the college already Exist in the DB
        College existCollege = collegeRepository.findCollegeByCode(college.getCode());

        if (existCollege == null) {
            collegeRepository.save(college);
            return college;
        }
        return null;
    }

    @Override
    public College getCollegeById(Long collegeId) {
        return collegeRepository.findById(collegeId).orElse(null);
    }

    @Override
    public College getCollegeByCode(Integer collegeCode) {
        return collegeRepository.findCollegeByCode(collegeCode);
    }

    @Override
    public College updateCollege(Long collegeId, College college) {
        // Checking if there is College with the given ID
        College existCollege = collegeRepository.findById(collegeId).orElse(null);

        if (existCollege != null) {

            existCollege.setCollegeName(college.getCollegeName());
            existCollege.setCode(college.getCode());
            return existCollege;
        }
        return null;
    }

    @Override
    public boolean deleteCollegeById(Long collegeId) {
        // Checking if there is College with the given ID
        College existCollege = collegeRepository.findById(collegeId).orElse(null);

        if (existCollege != null) {
            collegeRepository.delete(existCollege);
            return true;
        }
        return false;
    }

    @Override
    public List<College> getAllCollege() {
        return collegeRepository.findAll();
    }
}
