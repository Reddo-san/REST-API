package com.rest_api.rest_api_demo.service;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.rest_api.rest_api_demo.dto.StudentDto;
import com.rest_api.rest_api_demo.entity.Student;
import com.rest_api.rest_api_demo.mapper.StudentMapper;
import com.rest_api.rest_api_demo.repository.StudentRepository;
import com.rest_api.rest_api_demo.exception.StudentNotFoundException;

@Service 
public class StudentServiceImplement implements StudentService{

  private StudentRepository studentRepo;

  public StudentServiceImplement(StudentRepository studentRepo){
    this.studentRepo = studentRepo;
  }


  @Override 
  public StudentDto createStudent(StudentDto theStudentDto){
    Student theStudent = StudentMapper.mapToStudent(theStudentDto);
    Student saved = studentRepo.save(theStudent);
    return StudentMapper.mapToStudentDto(saved);
  }

  @Override 
  public StudentDto getStudentById(Long theId){
    Student student = studentRepo.findById(theId).orElseThrow(()->
              new StudentNotFoundException("Student id" + theId + " not found!")
              );
    return StudentMapper.mapToStudentDto(student);


  }
  

}
