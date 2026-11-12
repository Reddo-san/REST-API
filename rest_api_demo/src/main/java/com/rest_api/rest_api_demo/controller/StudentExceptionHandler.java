/*
package com.rest_api.rest_api_demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.rest_api.rest_api_demo.entity.StudentErrorResponse;
import com.rest_api.rest_api_demo.exception.StudentNotFoundException;

@ControllerAdvice 
public class StudentExceptionHandler {

  @ExceptionHandler 
  public ResponseEntity<StudentErrorResponse> handleException(
          StudentNotFoundException ex){
    StudentErrorResponse err = new StudentErrorResponse();
    
    err.setStatus(HttpStatus.NOT_FOUND.value());
    err.setMessage(ex.getMessage());
    err.setTimeStamp(System.currentTimeMillis());

    return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler 
  public ResponseEntity<StudentErrorResponse>handleException(Exception ex){
    StudentErrorResponse err = new StudentErrorResponse();

    err.setStatus(HttpStatus.BAD_REQUEST.value());
    err.setMessage("Invalid data. Only integers are accepted.");
    err.setTimeStamp(System.currentTimeMillis());

    return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
  }

}
*/
