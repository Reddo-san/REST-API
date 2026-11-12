package com.rest_api.rest_api_demo.mapper;

import com.rest_api.rest_api_demo.dto.StudentDto;
import com.rest_api.rest_api_demo.entity.Student;

public class StudentMapper {

  public static StudentDto mapToStudentDto(Student theStudent){
    return new StudentDto(theStudent.getId(),
                          theStudent.getFirstName(),
                          theStudent.getLastName(),
                          theStudent.getEmail());

  }

  public static Student mapToStudent(StudentDto theStudentDto){
    return new Student(theStudentDto.getId(),
                        theStudentDto.getFirstName(),
                        theStudentDto.getLastName(),
                        theStudentDto.getEmail());

  }

}
