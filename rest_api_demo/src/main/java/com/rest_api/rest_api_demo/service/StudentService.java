package com.rest_api.rest_api_demo.service;

import com.rest_api.rest_api_demo.dto.StudentDto;

public interface StudentService {

  StudentDto createStudent(StudentDto theStudentDto);
  StudentDto getStudentById(Long theId);

}
