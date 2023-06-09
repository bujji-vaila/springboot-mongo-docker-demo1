package com.example.demo.service;

import java.util.List;


import com.example.demo.model.Student;

public interface StudentService {
	public Student insertStudent(Student student);
	public Student findStudentById(Integer Id);
	public List<Student> findStudents();
	public Student updateStudent(Integer Id, Student student);
	public void deleteStudent(Integer Id);

}
