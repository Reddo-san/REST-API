package com.rest_api.rest_api_demo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import com.rest_api.rest_api_demo.entity.Student;
import com.rest_api.rest_api_demo.repository.StudentRepository;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
class RestApiDemoApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@MockitoBean
	private StudentRepository studentRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void createStudentWithoutEmailReturnsBadRequest() throws Exception {
		mockMvc.perform(post("/api/students")
				.contentType(MediaType.APPLICATION_JSON)
				.content("""
						{"firstName":"Ada","lastName":"Lovelace"}
						"""))
				.andExpect(status().isBadRequest());
	}

	@Test
	void createStudentReturnsPopulatedFields() throws Exception {
		when(studentRepository.save(any(Student.class))).thenAnswer(invocation -> {
			Student student = invocation.getArgument(0);
			student.setId(1L);
			return student;
		});

		mockMvc.perform(post("/api/students")
				.contentType(MediaType.APPLICATION_JSON)
				.content("""
						{"firstName":"Ada","lastName":"Lovelace","email":"ada@example.com"}
						"""))
				.andExpect(status().isCreated())
				.andExpect(jsonPath("$.id").value(1))
				.andExpect(jsonPath("$.firstName").value("Ada"))
				.andExpect(jsonPath("$.lastName").value("Lovelace"))
				.andExpect(jsonPath("$.email").value("ada@example.com"));
	}
}
