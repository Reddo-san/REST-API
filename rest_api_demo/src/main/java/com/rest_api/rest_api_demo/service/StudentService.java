package com.rest_api.rest_api_demo.service;

import com.rest_api.rest_api_demo.dto.StudentDto;
import java.util.List;

public interface StudentService {

  StudentDto createStudent(StudentDto theStudentDto);
  StudentDto getStudentById(Long theId);
  List<StudentDto> getAllStudents();
  StudentDto updateStudent(Long theId, StudentDto thStudentDto);
  StudentDto patchStudent(Long theId, StudentDto theStudentDto);
  void deleteStudentById(Long theId);
}
