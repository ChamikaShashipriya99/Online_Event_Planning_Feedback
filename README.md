# Online Event Planning System

This project is an Online Event Planning System designed to help users manage events efficiently. Key features include event management, comprehensive planning tools, team collaboration capabilities, and a system for collecting and managing user feedback.

## Features

-   **Event Management:** Manage events of all sizes, from small gatherings to large-scale conferences.
-   **Planning Tools:** Utilize a comprehensive set of planning tools, including scheduling, budget tracking, and more.
-   **Team Collaboration:** Work together with your team members in real-time to ensure your event runs smoothly from start to finish.
-   **Feedback System:**
    -   Submit feedback including name, email, phone number, and comments.
    -   View a list of all submitted feedback.
    -   Edit existing feedback entries.
    -   Delete feedback entries.

## Technologies Used

-   **Backend:** Java (Servlets, JSP)
-   **Database:** MySQL
-   **Frontend:** HTML, CSS (Bootstrap), JavaScript

## Setup and Running the Project

### 1. Database Setup

-   Ensure you have a MySQL server installed and running.
-   Create a new database named `event_planning_system`. You can use the following SQL command:
    ```sql
    CREATE DATABASE event_planning_system;
    ```
-   Use the created database:
    ```sql
    USE event_planning_system;
    ```
-   Import the database schema and initial data by executing the `event_planning_system_Feedback.sql` file provided in the project root. You can do this via a MySQL client or tool (e.g., MySQL Workbench, phpMyAdmin, or the command line).

    Example using MySQL command line:
    ```bash
    mysql -u your_username -p event_planning_system < event_planning_system_Feedback.sql
    ```
    (Replace `your_username` with your MySQL username.)

### 2. Deployment

-   This project is a standard Java web application. You will need a servlet container like Apache Tomcat to deploy it.
-   **Build the Project:** If you have the source code, you'll typically build it into a WAR (Web Application Archive) file using a build tool like Maven or Ant. (If the project already provides a WAR file, you can skip this step).
-   **Deploy to Tomcat:**
    1.  Copy the generated WAR file (e.g., `OnlineEventPlanningSystem.war`) into the `webapps` directory of your Apache Tomcat installation.
    2.  Alternatively, if you have the project as a directory, you can copy the entire project directory into the `webapps` directory.
    3.  Start Apache Tomcat. It will automatically deploy the application.
-   **Access the Application:** Once deployed, you should be able to access the application by navigating to `http://localhost:8080/your-application-context/` in your web browser (replace `your-application-context` with the actual context path, which is often the name of the WAR file or project directory, e.g., `http://localhost:8080/OnlineEventPlanningSystem/`). The main page is `index.jsp`.

*Note: The specific steps for building and the final application context path might vary based on the project's configuration (e.g., if it uses Maven, the `pom.xml` would define the artifactId which often becomes the context path).*

## Using the Feedback System

The Online Event Planning System includes a feature to collect and manage user feedback.

### Submitting Feedback

1.  Navigate to the feedback form:
    *   You can find a link/button to "Add Feedback" on the homepage (`index.jsp`).
    *   Alternatively, you can directly access the form at `feedbackForm.jsp`.
2.  Fill in the required fields:
    *   **Name:** Your full name.
    *   **Email:** Your email address (must be a valid format).
    *   **Phone Number:** Your 10-digit phone number.
    *   **Feedback:** Your comments or suggestions.
3.  Click the "Submit" button. You should see a success message if the submission is valid.

### Viewing Feedback

1.  After submitting feedback, you can click the "View Feedback" button on the form page.
2.  Alternatively, access the feedback list directly via `feedbackList.jsp` or through a link that might be available on the navigation bar ("Feedback List" or similar).
3.  The page displays a table with all submitted feedback, showing the name, email, phone, and feedback text for each entry.

### Managing Feedback (on the Feedback List page)

-   **Edit:** Each feedback entry has an "Edit" button. Clicking this will take you to the feedback form pre-filled with the selected feedback's details, allowing you to make changes and save them.
-   **Delete:** Each feedback entry has a "Delete" button. Clicking this will prompt you for confirmation before permanently removing the feedback from the system.
