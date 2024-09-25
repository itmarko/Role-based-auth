package com.login.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.login.Exception.StudentNotFoundException;
import com.login.Model.Student;
import com.login.Repositry.StudentRepositry;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentService implements IstudentService {

	private final StudentRepositry studentRepositry;

	public StudentService(StudentRepositry studentRepositry) {
		this.studentRepositry = studentRepositry;
	}

	@Override
	public List<Student> getStudents() {
		return studentRepositry.findAll();
	}

	@Override
	public Student addStudent(Student student) {
		return studentRepositry.save(student);
	}

	@Override
	public Student updateStudent(Student student, Long id) {

		return studentRepositry.findById(id).map(st -> {
			st.setUsername(student.getUsername());
			st.setName(student.getName());
			st.setEmail(student.getEmail());
//			st.setPassword(student.getPassword());
//			st.setRole(student.getRole());
			return studentRepositry.save(st);
		}).orElseThrow(() -> new StudentNotFoundException("Sorry, this student could not be found"));
	}

	@Override
	public Student getStudentById(Long id) {

		return studentRepositry.findById(id)
				.orElseThrow(() -> new StudentNotFoundException("Sorry, no student found with the Id :" + id));
	}

	@Override
	public void deleteStudent(Long id) {
		if (!studentRepositry.existsById(id)) {
			throw new StudentNotFoundException("Sorry, student not found");
		}
		studentRepositry.deleteById(id);
	}

}
