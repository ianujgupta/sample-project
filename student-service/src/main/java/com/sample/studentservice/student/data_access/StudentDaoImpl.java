package com.sample.studentservice.student.data_access;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.sample.studentservice.student.entities.Student;
import com.sample.studentservice.student.exceptions.StudentNotFoundException;

@Repository
public class StudentDaoImpl implements IStudentDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Student addStudent(Student student) {
		em.persist(student);
		return student;
	}

	@Override
	public Student findStudentById(int id) {
		Student student = em.find(Student.class, id);
		if (student == null) {
			throw new StudentNotFoundException("Student cannot be null for id" + id);
		}
		return student;
	}
	
	@Override
	public List<Student> listAllStudents() {
		String jpaql = "from Student";
		TypedQuery<Student> query= em.createQuery(jpaql, Student.class);
		List<Student> studentlist = query.getResultList();
		return studentlist;
	}
    
	@Override
	public Student updateStudent(Student student) {
		student = em.merge(student);
		return student;
	}

	@Override
	public Student findStudentByName(String name) {
		String jpaql = "from Student where name=:studentname";
		Query query = em.createQuery(jpaql);
		query.setParameter("studentname", name);
		List<Student> list = query.getResultList();
		Student student = null;
		if (!list.isEmpty()) {
			student = list.get(0);
		}
		return student;
	}

}
