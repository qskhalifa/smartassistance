package com.smartassistance.Service;

import com.smartassistance.Model.Module;
import com.smartassistance.Model.Result;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ResultService {
    List<Result> getResultsByModule(Module module);
    Result getStudentResult(int studentNumber);
    List<Result> createResult(List<Result> results);
}
