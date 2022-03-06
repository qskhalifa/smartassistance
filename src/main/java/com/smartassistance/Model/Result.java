package com.smartassistance.Model;

import javax.persistence.*;

@Entity
public class Result {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Student student;

    @OneToOne
    private AssignmentResult assignmentResult;

    @OneToOne
    private LabResult labResult ;

    @OneToOne
    private ExamResult examResult;

    private int finalResult;

    public Result() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public AssignmentResult getAssignmentResult() {
        return assignmentResult;
    }

    public void setAssignmentResult(AssignmentResult assignmentResult) {
        this.assignmentResult = assignmentResult;
    }

    public LabResult getLabResult() {
        return labResult;
    }

    public void setLabResult(LabResult labResult) {
        this.labResult = labResult;
    }

    public ExamResult getExamResult() {
        return examResult;
    }

    public void setExamResult(ExamResult examResult) {
        this.examResult = examResult;
    }

    public int getFinalResult() {
        return finalResult;
    }

    public void setFinalResult(int finalResult) {
        this.finalResult = finalResult;
    }
}
