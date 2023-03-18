package com.workshop.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.workshop.Entity.Student;

public interface Studentrepo extends JpaRepository<Student, Long>{


}
