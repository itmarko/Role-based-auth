package com.login.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.login.Model.Student;
import com.login.Services.IstudentService;
import com.login.Services.StudentService;

@RestController // Change @Controller to @RestController for REST APIs
@RequestMapping("/api/students") // Define the base URL for this controller
public class StudentController {

	private final IstudentService studentService;

	@Autowired
	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}

	// Get all students
	@GetMapping
	public ResponseEntity<List<Student>> getAllStudents() {
		List<Student> students = studentService.getStudents();
		return ResponseEntity.ok(students);
	}

	// Get a student by ID
	@GetMapping("/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
		Student student = studentService.getStudentById(id);
		return student != null ? ResponseEntity.ok(student) : ResponseEntity.notFound().build();
	}

	// Add a new student
	@PostMapping("/addstudent")
	public Student addStudent(@RequestBody Student student) {

		return studentService.addStudent(student);
	}

	// Update an existing student
	@PutMapping("/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student student) {
		Student updatedStudent = studentService.updateStudent(student, id);
		return ResponseEntity.ok(updatedStudent);
	}

	// Delete a student
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
		studentService.deleteStudent(id);
		return ResponseEntity.noContent().build();
	}
}
