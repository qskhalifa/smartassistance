package com.smartassistance.Service;

import com.smartassistance.Model.Batch;
import com.smartassistance.Model.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {

    List<Student> getAllStudents(Batch batch);

    Student getStudentByNumber(int studentNumber);

    List<Student> getAllStudentEnrolledToModule(long moduleId);

}
