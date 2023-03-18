package com.workshop.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.workshop.Entity.Student;
import com.workshop.Repository.Studentrepo;
@org.springframework.stereotype.Service
public class Serviceimpl implements Service {
	@Autowired
	Studentrepo repo;

	@Override
	public List<Student> getAllStudent() {
		return repo.findAll();
	}

	@Override
	public Student save(Student student) {
		return repo.save(student);
	}

	@Override
	public Student getStudentById(Long id) {
		return repo.findById(id).get();
	}

	@Override
	public Student updateStudent(Student student) {
		return repo.save(student);
	}

	@Override
	public void deleteStudentById(Long id) {
		repo.deleteById(id);
		
	}

}
