package com.login.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.login.Model.Student;
import com.login.Services.IstudentService;

@Controller
@RequestMapping("/api/user")
public class AdminController {

    private final IstudentService studentService;

    @Autowired
    public AdminController(IstudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/admin")
    @ResponseBody
    public String method() {
        return "Admin user";
    }

    @GetMapping("/normal")
    @ResponseBody
    public String normal() {
        return "Normal user!";
    }

    // Get all students
    @GetMapping("/view-students")
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = studentService.getStudents();
        return ResponseEntity.ok(students);
    }

    @PostMapping("/add-students")
    @ResponseBody
    public Student addStudent(@RequestBody Student student) {
    	return studentService.addStudent(student);
    }

}
