package com.rest_api.rest_api_demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.rest_api.rest_api_demo.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

  

}
