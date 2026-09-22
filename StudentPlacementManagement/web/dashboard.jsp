<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    if (session.getAttribute("studentId") == null) {
        response.sendRedirect("login.jsp");
        return;
    }

    String name =
        (String) session.getAttribute("studentName");
%>

<!DOCTYPE html>

<html>

<head>

    <title>Student Dashboard</title>

    <link rel="stylesheet"
          href="css/style.css">

</head>

<body>

<nav>

    <div class="logo">SPMS</div>

    <div>

        <a href="dashboard.jsp">Dashboard</a>

        <a href="placements.jsp">
            Placements
        </a>

        <a href="status.jsp">
            My Status
        </a>

        <a href="LogoutServlet">
            Logout
        </a>

    </div>

</nav>

<div class="dashboard">

    <h1>Welcome, <%= name %>!</h1>

    <p>
        Student Placement Management Dashboard
    </p>

    <div class="dashboard-card">

        <h3>Placement Drives</h3>

        <p>
            View available companies
        </p>

        <a href="placements.jsp">
            View
        </a>

    </div>

    <div class="dashboard-card">

        <h3>Apply</h3>

        <p>
            Apply for placement drives
        </p>

        <a href="placements.jsp">
            Apply Now
        </a>

    </div>

    <div class="dashboard-card">

        <h3>Application Status</h3>

        <p>
            Track your applications
        </p>

        <a href="status.jsp">
            Check Status
        </a>

    </div>

</div>

</body>
</html>