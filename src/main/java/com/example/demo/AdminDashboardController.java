package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;


//Existing code...

@Controller
@RequestMapping("/admin-dashboard")
public class AdminDashboardController {

 @GetMapping
 public String showAdminDashboard() {
     return "admin-dashboard";
 }

 @GetMapping("/admin/add-course")
 public String showAddCourseForm(Model model) {
     model.addAttribute("course", new Course());
     return "admin/add-course";
 }

 @Autowired
 private CourseService courseService; // Ensure this service is defined and annotated with @Service

 @PostMapping("/admin/add-course")
 public String addCourse(@ModelAttribute Course course) {
     // Logic to save the course to the database
     courseService.saveCourse(course);
     return "redirect:/admin-dashboard"; // Redirect to the dashboard or a success page
 }
}
