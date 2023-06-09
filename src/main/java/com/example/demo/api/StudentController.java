package com.example.demo.api;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@PostMapping
	public ResponseEntity<Student> insertStudent(@RequestBody Student student){
		return new ResponseEntity<Student>(studentService.insertStudent(student), HttpStatus.CREATED);
	}
	
	@GetMapping(path="{id}")
	public ResponseEntity<Student> findStudentById(@PathVariable("id") Integer Id){
		return new ResponseEntity<Student>(studentService.findStudentById(Id), HttpStatus.OK);
		
	}
	
	@GetMapping
	public List<Student> findStudents(){
		return studentService.findStudents();
	}
	
	@PatchMapping(path="{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable("id") Integer Id,@RequestBody Student student){
		return new ResponseEntity<Student>(studentService.updateStudent(Id, student), HttpStatus.OK);
		
	}
	
	@DeleteMapping(path="{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable("id") Integer Id){
		studentService.deleteStudent(Id);
		return new ResponseEntity<String>("deleted successfully!.",HttpStatus.OK);
		
	}

}
