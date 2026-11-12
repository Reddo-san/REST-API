package com.rest_api.rest_api_demo.controller;

import com.rest_api.rest_api_demo.entity.Student;
import com.rest_api.rest_api_demo.exception.StudentNotFoundException;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.*;

import jakarta.annotation.PostConstruct;


@RestController 
@RequestMapping ("/api")
public class StudentRestController {

  private List<Student> theStudents;

  @PostConstruct 
  public void initialize(){
    theStudents = new ArrayList<>();

    theStudents.add(new Student("Douzo", "Yoroshiku"));
    theStudents.add(new Student("Arigatou", "Gozaimashita"));
    theStudents.add(new Student("Ohayou", "Gozaimasu"));

  }

  @GetMapping("/students")
  public List<Student> getStudents() {
      return theStudents;
  }

  @GetMapping("/students/{studentId}")
  public Student getStudent(@PathVariable  int studentId) {
    if (studentId >= theStudents.size() || (studentId < 0)){
      throw new StudentNotFoundException(
                "Student id " + studentId + " not found!");
    }
      return theStudents.get(studentId);
  }
  
  

}
