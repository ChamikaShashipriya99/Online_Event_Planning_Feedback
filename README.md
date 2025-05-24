# Online Event Planning System

A web application for planning and managing events. It includes features for event creation, attendee management, and feedback collection.

## Features

*   Event Management
*   Planning Tools (scheduling, budget tracking)
*   Team Collaboration
*   Feedback Submission and Management

## Technologies Used

*   **Frontend:** HTML, CSS, Bootstrap, JSP
*   **Backend:** Java, Servlets
*   **Database:** MySQL

## Setup and Installation

### Prerequisites

*   Java Development Kit (JDK) 8 or higher
*   Apache Maven (Optional, but recommended for managing dependencies)
*   MySQL Server

### Database Setup

1.  Ensure your MySQL server is running.
2.  Create a database named `event_planning_system`. You can use the provided `event_planning_system_Feedback.sql` file to set up the schema and initial data. Execute this script using a MySQL client:
    ```bash
    mysql -u your_username -p event_planning_system < event_planning_system_Feedback.sql
    ```
    (Replace `your_username` with your MySQL username).
3.  **Important:** You might need to configure the database connection details (username, password, URL) within the application. This is typically done in a properties file or a configuration class within the Java source code (e.g., in `FeedbackDAO.java` or a dedicated database utility class). *(Note: The exact location for this configuration was not identified during the initial code scan, so developers should look for it.)*

### Deployment

1.  Build the project to produce a `.war` (Web Application Archive) file. If using Maven, you would typically run `mvn clean package`.
2.  Deploy the generated `.war` file to a servlet container like Apache Tomcat, Jetty, or WildFly.
    *   For Tomcat, you can copy the `.war` file to the `webapps` directory of your Tomcat installation.

## Usage

1.  Once the application is deployed and the database is set up, open your web browser.
2.  Navigate to the application's entry point. This is typically `http://localhost:8080/your-application-context/` (replace `your-application-context` with the actual context path of your deployed application, which is often the name of the `.war` file without the extension, e.g., `http://localhost:8080/event-planning-system/`).
3.  The homepage (`index.jsp`) will be displayed.
4.  To use the feedback feature:
    *   Click on the "Add Feedback" button or link (usually found on the homepage or in the navigation bar).
    *   Fill out the feedback form and submit it.
    *   You can view the list of submitted feedback by navigating to the feedback list page (e.g., through a link like "View Feedback" or directly via a URL like `feedback?action=list`).

## Contributing

Contributions are welcome! If you'd like to improve the system or add new features:

1.  Fork the repository.
2.  Create a new branch for your feature or bug fix (`git checkout -b feature/your-feature-name`).
3.  Make your changes and commit them (`git commit -am 'Add some feature'`).
4.  Push to the branch (`git push origin feature/your-feature-name`).
5.  Create a new Pull Request.
