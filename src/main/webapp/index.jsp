<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Online Event Planning System</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body { padding-top: 56px; }
        .hero-section {
            background-color: #f8f9fa;
            padding: 50px 0;
            text-align: center;
        }
        .hero-section h1 { font-size: 3rem; margin-bottom: 20px; }
        .hero-section p { font-size: 1.25rem; }
    </style>
</head>
<body>
    <!-- Include the navigation bar -->
    <jsp:include page="navbar.jsp" />

    <!-- Hero Section -->
    <section class="hero-section">
        <div class="container">
            <h1>Welcome to Our Online Event Planning System</h1>
            <p>Plan your events with ease and flexibility</p>
            <a href="feedbackForm.jsp" class="btn btn-primary">Add Feedback</a>
        </div>
    </section>

    <!-- Main Content Section -->
    <section class="container my-5">
        <div class="row">
            <div class="col-md-4">
                <h2>Event Management</h2>
                <p>Our system allows you to manage events of all sizes, from small gatherings to large-scale conferences.</p>
            </div>
            <div class="col-md-4">
                <h2>Planning Tools</h2>
                <p>Utilize our comprehensive set of planning tools, including scheduling, budget tracking, and more.</p>
            </div>
            <div class="col-md-4">
                <h2>Team Collaboration</h2>
                <p>Work together with your team members in real-time to ensure your event runs smoothly from start to finish.</p>
            </div>
        </div>
    </section>

    <!-- Include the footer -->
    <jsp:include page="footer.jsp" />

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.2/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>