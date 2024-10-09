package com.example.demo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private AdminService adminService;

   
    @GetMapping("/login")
    public String showLoginPage() {
        return "login"; // Returns the login page
    }

    @PostMapping("/login")
    public String processLogin(@RequestParam("username") String username, @RequestParam("password") String password, Model model) {
        if (username.length() == 10) {
            Optional<Student> student = studentService.login(Long.parseLong(username), password);
            if (student.isPresent()) {
                return "redirect:/student-dashboard";
            }
        } else if (username.length() == 4) {
            Optional<Admin> admin = adminService.login(Integer.parseInt(username), password);
            if (admin.isPresent()) {
                return "redirect:/admin-dashboard";
            }
        }
        model.addAttribute("error", "Invalid username or password");
        return "login"; 
    }
}
