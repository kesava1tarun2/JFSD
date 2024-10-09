package com.example.demo;

import jakarta.persistence.*;

@Entity
public class Feedback {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long feedbackId;

    private String username;  // This is the username of the student giving feedback
    
    private String feedback;  // The feedback text

    private String courseName;    // Field to associate the feedback with a specific course name

    // Constructors
    public Feedback() {}

    public Feedback(String username, String feedback, String courseName) {
        this.username = username;
        this.feedback = feedback;
        this.courseName = courseName;
    }

    // Getters and Setters
    public Long getFeedbackId() {
        return feedbackId;
    }

    public void setFeedbackId(Long feedbackId) {
        this.feedbackId = feedbackId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

}
