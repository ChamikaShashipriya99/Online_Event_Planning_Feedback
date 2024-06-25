package com.eventplanning.model;

import java.sql.Timestamp;

public class Feedback {
    private int id;
    private String name;
    private String email;
    private String phone;
    private String feedbackText;
    private Timestamp createdAt;

    // Constructors
    public Feedback() {}

    public Feedback(String name, String email, String phone, String feedbackText) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.feedbackText = feedbackText;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFeedbackText() {
        return feedbackText;
    }

    public void setFeedbackText(String feedbackText) {
        this.feedbackText = feedbackText;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}