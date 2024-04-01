package com.emirhanuzun.restapidemo.rest;

import com.emirhanuzun.restapidemo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> theStudents;

    // define @PostConstruct to load the student data
    @PostConstruct
    public void loadData(){

        theStudents = new ArrayList<>();

        theStudents.add(new Student("Emirhan","Uzun"));
        theStudents.add(new Student("Clarice","Uzun"));
        theStudents.add(new Student("Mary","Smith"));
    }

    @GetMapping("/students")
    public List<Student> getStudents(){
        return theStudents;
    }

    // define endpoint for "/students/{studentId}" - return student at index
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){

        if( (studentId >= theStudents.size()) || (studentId <0)){
            throw new StudentNotFoundException("Student id not found - " + studentId);
        }


        // just index into the list
        return theStudents.get(studentId);
    }


}
