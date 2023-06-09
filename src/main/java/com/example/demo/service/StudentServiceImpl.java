package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.StudentRepository;
import com.example.demo.error.StudentException;
import com.example.demo.model.Student;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public Student insertStudent(Student student) {
		// TODO Auto-generated method stub
		return studentRepository.insert(student);
	}

	@Override
	public Student findStudentById(Integer id) {
		return studentRepository.findById(id).orElseThrow(() -> new StudentException("Student", "Id", id));
	}

	@Override
	public List<Student> findStudents() {
		// TODO Auto-generated method stub
		return studentRepository.findAll();
	}

	@Override
	public Student updateStudent(Integer id, Student student) {
		Student exStudent = studentRepository.findById(id).orElseThrow(() -> new StudentException("Student", "Id", id));
		exStudent.setName(student.getName());
		studentRepository.insert(exStudent);
		return exStudent;
	}

	@Override
	public void deleteStudent(Integer id) {
		studentRepository.findById(id).orElseThrow(() -> new StudentException("Student", "Id", id));
		studentRepository.deleteById(id);

	}

}
