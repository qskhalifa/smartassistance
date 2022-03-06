package com.smartassistance.ServiceImpl;

import com.smartassistance.Model.Exam;
import com.smartassistance.Repo.ExamRepository;
import com.smartassistance.Service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ExamServiceImpl implements ExamService {


    private final ExamRepository examRepository;

    @Autowired
    public ExamServiceImpl(ExamRepository examRepository) {
        this.examRepository = examRepository;
    }

    @Override
    public Exam createNewExam(Exam exam) {
        //  Check if the Exam is already Exist in the db
        Exam existExam = examRepository.findByNameIgnoreCase(exam.getName()).orElse(null);
        if (existExam == null) {

            examRepository.save(exam);
            return exam;

        }
        return null;
    }

    @Override
    public Exam updateExam(Long examId, Exam exam) {
        //Check if the Exam exist in the db
        Exam existExam = examRepository.findById(examId).orElse(null);

        if (existExam != null) {
            existExam.setBatch(exam.getBatch());
            existExam.setModule(exam.getModule());
            existExam.setName(exam.getName());
            existExam.setMark(exam.getMark());
            examRepository.save(existExam);
        }
        return null;
    }

    @Override
    public boolean deleteExam(Long examId) {
        Exam existExam = examRepository.findById(examId).orElse(null);

        if (existExam != null) {

            examRepository.delete(existExam);
            return true;
        }

        return false;
    }
}
