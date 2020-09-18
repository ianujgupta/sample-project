package com.sample.studentservice.student.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.studentservice.student.data_access.IStudentDao;
import com.sample.studentservice.student.entities.Student;
import com.sample.studentservice.student.exceptions.InvalidArgumentException;

@Transactional
@Service
public class StudentServiceImpl implements IStudentService {

	@Autowired
	private IStudentDao dao;

	private void validate(Object obj) {
		if (obj == null) {
			throw new InvalidArgumentException("given argument is null");
		}
	}

	@Override
	public Student addStudent(Student student) {
		validate(student);
		student = dao.addStudent(student);
		return student;
	}

	@Override
	public Student findStudentById(int id) {
		Student student = dao.findStudentById(id);
		return student;
	}

	@Override
	public List<Student> listAllStudents() {
		List<Student> list = dao.listAllStudents();
		System.out.print("inside service list");
		return list;
	}

	@Override
	public Student updateStudent(Student student) {
		validate(student);
		student = dao.updateStudent(student);
		return student;
	}

	@Override
	public Student findStudentByName(String name) {
		validate(name);
		Student student = dao.findStudentByName(name);
		return student;
	}



}
