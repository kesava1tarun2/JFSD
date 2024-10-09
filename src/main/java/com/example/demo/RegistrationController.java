package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
@Controller
public class RegistrationController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private AdminService adminService;

    @GetMapping("/student/register")
    public String showStudentRegistrationPage() {
        return "student-register";
    }

    @PostMapping("/student/register")
    public String registerStudent(@ModelAttribute Student student) {
        studentService.registerStudent(student);
        return "redirect:/login";
    }

    @GetMapping("/admin/register")
    public String showAdminRegistrationPage() {
        return "admin-register";
    }

    @PostMapping("/admin/register")
    public String registerAdmin(@ModelAttribute Admin admin) {
        adminService.registerAdmin(admin);
        return "redirect:/login";
    }
}
