package com.sample.studentservice.student.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sample.studentservice.student.data_transfer.CreateStudentRequest;
import com.sample.studentservice.student.data_transfer.UpdateStudentRequest;
import com.sample.studentservice.student.entities.Student;
import com.sample.studentservice.student.services.IStudentService;

@RestController
@RequestMapping("/students")
public class StudentController {

	@Autowired
	private IStudentService service;
	
	@PostMapping("/add")
	@ResponseStatus(HttpStatus.CREATED)
	public Student addEmployee(@RequestBody CreateStudentRequest requestData) {
		String name = requestData.getName();
		String address = requestData.getAddress();
		int phoneNo = requestData.getPhoneNo();
		Student student = new Student(name,address,phoneNo);
		student = service.addStudent(student);
		return student;
}	
	
	@GetMapping("/get/{id}")
	public Student findStudentById(@PathVariable("id") int id) {
		Student student = service.findStudentById(id);
		return student;
	}
	
	@GetMapping("by/{name}")
	public Student findStudentByName(@PathVariable("name") String name) {
		Student student = service.findStudentByName(name);
		return student;
	}
	

		
	@GetMapping("/fetchall")
	public List <Student> fetchAll(){
		List <Student> list = service.listAllStudents();
			return list;
	}	
	
	@PutMapping("/update")
	public Student updateStudentDetails(@RequestBody UpdateStudentRequest requestData) {
		String name = requestData.getName();
		String address =  requestData.getAddress();
		int phnumber = requestData.getPhoneNo();
		int id = requestData.getId();
		Student student = new Student(name,address,phnumber);
		student.setId(id);
		student = service.updateStudent(student);
		return student;	
	}
}
