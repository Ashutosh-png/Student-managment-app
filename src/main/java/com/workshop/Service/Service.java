package com.workshop.Service;

import java.util.List;

import com.workshop.Entity.Student;

public interface Service {
	List<Student> getAllStudent();

	Student save(Student student);
	Student getStudentById(Long id);
	Student updateStudent(Student student);
	void deleteStudentById(Long id);
	

}
