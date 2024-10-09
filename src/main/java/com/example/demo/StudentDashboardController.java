package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/student-dashboard")
public class StudentDashboardController {

    @Autowired
    private CourseRepository courseRepository;
    
    @Autowired
    private FeedbackRepository feedbackRepository;

    @GetMapping
    public String showStudentDashboard() {
        return "student-dashboard";
    }

    @GetMapping("/student/give-feedback")
    public String showGiveFeedbackForm(Model model) {
        // Retrieve the list of courses from the database
        List<Course> courses = courseRepository.findAll();
        model.addAttribute("courses", courses);
        model.addAttribute("feedback", new Feedback());
        return "student/give-feedback"; // Refers to the name of your JSP file
    }

    @PostMapping("/student/give-feedback")
    public String submitFeedback(@RequestParam("course") String courseName, 
                                 @RequestParam("feedback") String feedbackText,
                                 @RequestParam("username") String username) {
        // Create a new Feedback object
        Feedback feedback = new Feedback();
        feedback.setCourseName(courseName); // Set the selected course name
        feedback.setFeedback(feedbackText); // Set the provided feedback
        feedback.setUsername(username); // Set the student's username

        // Save feedback to the database
        feedbackRepository.save(feedback);

        // Redirect to the same form after submission
        return "redirect:/student-dashboard/student/give-feedback";
    }
}
