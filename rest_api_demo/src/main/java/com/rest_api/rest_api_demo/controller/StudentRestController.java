package com.rest_api.rest_api_demo.controller;

import com.rest_api.rest_api_demo.dto.StudentDto;
import com.rest_api.rest_api_demo.service.StudentService;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController 
@RequestMapping ("/api/students")
public class StudentRestController {

  private StudentService studentService;

  public StudentRestController(StudentService studentService){
    this.studentService = studentService;
  }

  @PostMapping
  public ResponseEntity<StudentDto> createStudents(@Valid 
                                                    @RequestBody StudentDto theStudentDto) {
      StudentDto saved = studentService.createStudent(theStudentDto);
      return new ResponseEntity<>(saved, HttpStatus.CREATED);
  }
  
  @GetMapping ("{id}")
  public ResponseEntity<StudentDto> getStudentById(@PathVariable Long id){
    StudentDto studentDto = studentService.getStudentById(id);
    return ResponseEntity.ok(studentDto);
  }

}
