package com.login.Services;

import java.util.List;

import com.login.Model.Student;

public interface IstudentService {
	Student addStudent(Student student);

	List<Student> getStudents();

	Student updateStudent(Student student, Long id);

	Student getStudentById(Long id);

	void deleteStudent(Long id);
}
