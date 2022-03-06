package com.smartassistance.Controller;

import com.smartassistance.Model.Exam;
import com.smartassistance.Service.ExamService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ExamController {

    private final Logger logger = LoggerFactory.getLogger(ExamController.class);

    private final ExamService examService;

    @Autowired
    public ExamController(ExamService examService) {
        this.examService = examService;
    }

    @PostMapping("/exam")
    public ResponseEntity createExam(@RequestBody Exam exam) {

        logger.info("Request to Create New Exam");

        Exam newExam = examService.createNewExam(exam);

        return new ResponseEntity<>(newExam, HttpStatus.CREATED);

    }

    @PutMapping("/exam/{id}")
    public ResponseEntity updateExistExam(@PathVariable("id") Long examId, @RequestBody Exam exam) {

        logger.info("Request to update Exist Exam");

        Exam existExam = examService.updateExam(examId, exam);

        if (existExam == null) {

            return new ResponseEntity<>("Couldn't find Exam in the db with this id", HttpStatus.NOT_FOUND);

        }

        return new ResponseEntity<>(existExam, HttpStatus.OK);

    }

    @DeleteMapping("/exam/{id}")
    public ResponseEntity deleteExistExam (@PathVariable("id") Long examId) {
        boolean result = examService.deleteExam(examId);

        if (!result) {

            return new ResponseEntity<>("Couldn't find Exam", HttpStatus.NOT_FOUND);

        }
        return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
    }

}
