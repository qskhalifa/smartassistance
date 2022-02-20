package com.smartassistance.Model;

import javax.persistence.*;

@Entity
public class Result {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "Student_Number")
    private Student studentNumber;
    @OneToOne
    private Module moduleId;
    @Column(name = "Exam_Degree")
    private int examDegree;

    public Result() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Student getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(Student studentNumber) {
        this.studentNumber = studentNumber;
    }

    public Module getModuleId() {
        return moduleId;
    }

    public void setModuleId(Module moduleId) {
        this.moduleId = moduleId;
    }

    public int getExamDegree() {
        return examDegree;
    }

    public void setExamDegree(int examDegree) {
        this.examDegree = examDegree;
    }
}
