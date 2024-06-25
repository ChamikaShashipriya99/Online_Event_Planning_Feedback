<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Feedback Form</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body { padding-top: 56px; }
        .content { padding: 20px 0; }
        .error { color: red; }
        .success { color: green; }
    </style>
</head>
<body>
    <!-- Include the navigation bar -->
    <jsp:include page="navbar.jsp" />

    <div class="container content">
        <h2>${feedback != null ? "Edit Feedback" : "Add Feedback"}</h2>

        <!-- Display success message -->
        <c:if test="${not empty sessionScope.message}">
            <div class="alert alert-success">
                ${sessionScope.message}
            </div>
            <!-- Clear the message after displaying -->
            <c:remove var="message" scope="session"/>
        </c:if>

        <form name="feedbackForm" onsubmit="return validateForm()" method="post" action="feedback">
            <input type="hidden" name="action" value="${feedback != null ? 'update' : 'add'}">
            <c:if test="${feedback != null}">
                <input type="hidden" name="id" value="${feedback.id}">
            </c:if>

            <!-- Name -->
            <div class="form-group">
                <label for="name">Name:</label>
                <input type="text" class="form-control" id="name" name="name" value="${feedback.name}" required>
                <small id="nameError" class="error"></small>
            </div>

            <!-- Email -->
            <div class="form-group">
                <label for="email">Email:</label>
                <input type="email" class="form-control" id="email" name="email" value="${feedback.email}" required>
                <small id="emailError" class="error"></small>
            </div>

            <!-- Phone Number -->
            <div class="form-group">
                <label for="phone">Phone Number:</label>
                <input type="tel" class="form-control" id="phone" name="phone" value="${feedback.phone}" required>
                <small id="phoneError" class="error"></small>
            </div>

            <!-- Feedback Text -->
            <div class="form-group">
                <label for="feedbackText">Feedback:</label>
                <textarea class="form-control" id="feedbackText" name="feedbackText" rows="5" required>${feedback.feedbackText}</textarea>
                <small id="feedbackError" class="error"></small>
            </div>

            <button type="submit" class="btn btn-primary">Submit</button>
            <a href="feedback?action=list" class="btn btn-secondary">View Feedback</a>
        </form>
    </div>

    <!-- Include the footer -->
    <jsp:include page="footer.jsp" />

    <!-- JavaScript validation -->
    <script>
        function validateForm() {
            // Validation logic...
            return isValid;
        }
    </script>
    
    
    <!-- JavaScript validation -->
    <script>
        function validateForm() {
            // Clear any previous error messages
            document.getElementById('nameError').innerText = "";
            document.getElementById('emailError').innerText = "";
            document.getElementById('phoneError').innerText = "";
            document.getElementById('feedbackError').innerText = "";

            let isValid = true;

            // Email validation
            let email = document.forms["feedbackForm"]["email"].value;
            let emailRegex = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,6}$/;
            if (!emailRegex.test(email)) {
                document.getElementById('emailError').innerText = "Please enter a valid email address.";
                isValid = false;
            }

            // Phone number validation: Must be exactly 10 digits
            let phone = document.forms["feedbackForm"]["phone"].value;
            let phoneRegex = /^[0-9]{10}$/;
            if (!phoneRegex.test(phone)) {
                document.getElementById('phoneError').innerText = "Please enter a valid 10-digit phone number.";
                isValid = false;
            }

            // Feedback text validation: Cannot be empty
            let feedbackText = document.forms["feedbackForm"]["feedbackText"].value;
            if (feedbackText.trim() === "") {
                document.getElementById('feedbackError').innerText = "Please enter your feedback.";
                isValid = false;
            }

            return isValid;
        }
    </script>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.2/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
