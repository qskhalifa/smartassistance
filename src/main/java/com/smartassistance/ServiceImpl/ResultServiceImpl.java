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

    private final ResultRepository resultRepository;

    @Autowired
    public ResultServiceImpl(ResultRepository resultRepository) {
        this.resultRepository = resultRepository;
    }

    @Override
    public List<Result> getResultsByModule(Module module) {
        return resultRepository.findAllByModuleId(module);
    }

    @Override
    public Result getStudentResult(int studentNumber) {
        return resultRepository.findResultByStudentNumber(studentNumber).orElse(null);
    }

    @Override
    public List<Result> createResult(List<Result> results) {
        // TODO check if any result already Exist in the DB
        return resultRepository.saveAll(results);
    }
}
