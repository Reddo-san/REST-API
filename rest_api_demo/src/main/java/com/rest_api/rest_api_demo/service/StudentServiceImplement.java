package com.rest_api.rest_api_demo.service;


import org.springframework.stereotype.Service;

import com.rest_api.rest_api_demo.dto.StudentDto;
import com.rest_api.rest_api_demo.entity.Student;
import com.rest_api.rest_api_demo.mapper.StudentMapper;
import com.rest_api.rest_api_demo.repository.StudentRepository;

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

}
