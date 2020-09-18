package com.sample.studentservice.student.services;

import java.util.List;

import com.sample.studentservice.student.entities.Student;

public interface IStudentService {

	Student addStudent(Student student);

	Student findStudentById(int id);

	List<Student> listAllStudents();

	Student updateStudent(Student student);

	Student findStudentByName(String name);
	

}
