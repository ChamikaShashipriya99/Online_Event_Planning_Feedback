package com.eventplanning.dao;

import com.eventplanning.model.Feedback;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FeedbackDAO {
	
	static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
	
	
	private static final String JDBC_URL = "jdbc:mysql://localhost:3306/event_planning_system?useSSL=false&serverTimezone=UTC";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "Chamika1999";

    public void addFeedback(Feedback feedback) throws SQLException {
        String sql = "INSERT INTO feedback (name, email, phone, feedback_text) VALUES (?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, feedback.getName());
            pstmt.setString(2, feedback.getEmail());
            pstmt.setString(3, feedback.getPhone());
            pstmt.setString(4, feedback.getFeedbackText());
            pstmt.executeUpdate();
        }
    }

    public List<Feedback> getAllFeedback() throws SQLException {
        List<Feedback> feedbackList = new ArrayList<>();
        String sql = "SELECT * FROM feedback ORDER BY created_at DESC";
        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Feedback feedback = new Feedback();
                feedback.setId(rs.getInt("id"));
                feedback.setName(rs.getString("name"));
                feedback.setEmail(rs.getString("email"));
                feedback.setPhone(rs.getString("phone"));
                feedback.setFeedbackText(rs.getString("feedback_text"));
                feedback.setCreatedAt(rs.getTimestamp("created_at"));
                feedbackList.add(feedback);
            }
        }
        return feedbackList;
    }

    public Feedback getFeedbackById(int id) throws SQLException {
        String sql = "SELECT * FROM feedback WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    Feedback feedback = new Feedback();
                    feedback.setId(rs.getInt("id"));
                    feedback.setName(rs.getString("name"));
                    feedback.setEmail(rs.getString("email"));
                    feedback.setPhone(rs.getString("phone"));
                    feedback.setFeedbackText(rs.getString("feedback_text"));
                    feedback.setCreatedAt(rs.getTimestamp("created_at"));
                    return feedback;
                }
            }
        }
        return null;
    }

    public void updateFeedback(Feedback feedback) throws SQLException {
        String sql = "UPDATE feedback SET name = ?, email = ?, phone = ?, feedback_text = ? WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, feedback.getName());
            pstmt.setString(2, feedback.getEmail());
            pstmt.setString(3, feedback.getPhone());
            pstmt.setString(4, feedback.getFeedbackText());
            pstmt.setInt(5, feedback.getId());
            pstmt.executeUpdate();
        }
    }

    public boolean deleteFeedback(int id) throws SQLException {
        String sql = "DELETE FROM feedback WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        }
    }
}