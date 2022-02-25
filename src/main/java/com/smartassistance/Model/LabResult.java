package com.smartassistance.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class LabResult {

    @Id
    private Long id;
    @OneToOne
    private LabInfo labInfo;
    @OneToMany
    private Student student;
    private int labResult;

    public LabResult() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LabInfo getLabInfo() {
        return labInfo;
    }

    public void setLabInfo(LabInfo labInfo) {
        this.labInfo = labInfo;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public int getLabResult() {
        return labResult;
    }

    public void setLabResult(int labResult) {
        this.labResult = labResult;
    }
}
