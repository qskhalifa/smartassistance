package com.smartassistance.Repo;

import com.smartassistance.Model.Batch;
import com.smartassistance.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findStudentByStudentNumber(int studentNumber);

    //TODO I think there is some thing wrong !!
    @Query("select * from Student where batch.name = ?1")
    List<Student> findAllStudentByBatch(Batch batch);

    // get all students IDs for specific Course ID
    List<Student> findByBatch_ModuleList_Id(long id);



}
