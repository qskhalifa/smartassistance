package com.smartassistance.Service;

import com.smartassistance.DTOs.ExamDTO;
import com.smartassistance.Model.Exam;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ExamService {
    Exam createNewExam (Exam exam);
    Exam updateExam(Long examId, Exam exam);
    boolean deleteExam(Long examId);

}
