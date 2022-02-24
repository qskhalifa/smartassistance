package com.smartassistance.ServiceImpl;

import com.smartassistance.Model.Batch;
import com.smartassistance.Model.Student;
import com.smartassistance.Repo.StudentRepository;
import com.smartassistance.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;


    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAllStudentEnrolledToModule(long moduleId) {
        return studentRepository.findByBatch_ModuleList_Id(moduleId);
    }

    @Override
    public List<Student> getAllStudents(Batch batch) {
        return studentRepository.findAllStudentByBatch(batch);
    }

    @Override
    public Student getStudentByNumber(int studentNumber) {
        //Checking if the User Exist in The DB
        return studentRepository.findStudentByStudentNumber(studentNumber).orElse(null);

    }
}
