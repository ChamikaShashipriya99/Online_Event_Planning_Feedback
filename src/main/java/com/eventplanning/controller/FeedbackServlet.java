package com.eventplanning.controller;

import com.eventplanning.dao.FeedbackDAO;
import com.eventplanning.model.Feedback;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@SuppressWarnings("serial")
@WebServlet("/feedback")
public class FeedbackServlet extends HttpServlet {
    private FeedbackDAO feedbackDAO;

    public void init() {
        feedbackDAO = new FeedbackDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        try {
            switch (action) {
                case "add":
                    addFeedback(request, response);
                    break;
                case "update":
                    updateFeedback(request, response);
                    break;
                case "delete":
                    deleteFeedback(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        try {
            switch (action) {
                case "list":
                    listFeedback(request, response);
                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
                case "delete":
                    deleteFeedback(request, response);
                    break;
                default:
                    listFeedback(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void addFeedback(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String feedbackText = request.getParameter("feedbackText");
        Feedback newFeedback = new Feedback(name, email, phone, feedbackText);
        feedbackDAO.addFeedback(newFeedback);

        // Set a success message
        request.getSession().setAttribute("message", "Feedback submitted successfully!");
        response.sendRedirect("feedbackForm.jsp");
    }


    private void updateFeedback(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String feedbackText = request.getParameter("feedbackText");
        Feedback feedback = new Feedback(name, email, phone, feedbackText);
        feedback.setId(id);
        feedbackDAO.updateFeedback(feedback);
        response.sendRedirect("feedback?action=list");
    }

    private void deleteFeedback(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        System.out.println("Delete feedback method called");
        int id = Integer.parseInt(request.getParameter("id"));
        System.out.println("Attempting to delete feedback with id: " + id);
        boolean deleted = feedbackDAO.deleteFeedback(id);
        if (deleted) {
            System.out.println("Feedback deleted successfully");
        } else {
            System.out.println("Failed to delete feedback");
        }
        response.sendRedirect("feedback?action=list");
    }

    private void listFeedback(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        List<Feedback> feedbackList = feedbackDAO.getAllFeedback();
        request.setAttribute("feedbackList", feedbackList);
        request.getRequestDispatcher("feedbackList.jsp").forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Feedback existingFeedback = feedbackDAO.getFeedbackById(id);
        request.setAttribute("feedback", existingFeedback);
        request.getRequestDispatcher("feedbackForm.jsp").forward(request, response);
    }
}