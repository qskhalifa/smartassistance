package com.smartassistance.ServiceImpl;

import com.smartassistance.Model.Module;
import com.smartassistance.Model.Result;
import com.smartassistance.Repo.ResultRepository;
import com.smartassistance.Service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultServiceImpl implements ResultService {

    @Override
    public List<Result> getResultsByModule(Module module) {
        return null;
    }

    @Override
    public Result getStudentResult(int studentNumber) {
        return null;
    }

    @Override
    public List<Result> createResult(List<Result> results) {
        return null;
    }
}