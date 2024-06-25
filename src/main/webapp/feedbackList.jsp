<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Feedback List</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body { padding-top: 56px; }
        .content { padding: 20px 0; }
    </style>
</head>
<body>
    <!-- Include the navigation bar -->
    <jsp:include page="navbar.jsp" />

    <div class="container content">
        <h2>Feedback List</h2>
        <a href="feedbackForm.jsp" class="btn btn-success mb-3">Add New Feedback</a>
        <table class="table table-bordered">
            <thead>
                <tr>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Phone</th>
                    <th>Feedback</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="feedback" items="${feedbackList}">
                    <tr>
                        <td><c:out value="${feedback.name}" /></td>
                        <td><c:out value="${feedback.email}" /></td>
                        <td><c:out value="${feedback.phone}" /></td>
                        <td><c:out value="${feedback.feedbackText}" /></td>
                        <td>
                            <a href="feedback?action=edit&id=<c:out value='${feedback.id}' />" class="btn btn-primary btn-sm">Edit</a>
                            <a href="feedback?action=delete&id=<c:out value='${feedback.id}' />" class="btn btn-danger btn-sm" onclick="return confirm('Are you sure you want to delete this feedback?')">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>

    <!-- Include the footer -->
    <jsp:include page="footer.jsp" />

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.2/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>