<%@page import="java.sql.*"%>

<%
    if (session.getAttribute("studentId") == null) {
        response.sendRedirect("login.jsp");
        return;
    }

    int studentId =
        (Integer) session.getAttribute("studentId");
%>

<!DOCTYPE html>

<html>

<head>

    <title>Application Status</title>

    <link rel="stylesheet"
          href="css/style.css">

</head>

<body>

<nav>

    <div class="logo">SPMS</div>

    <div>

        <a href="dashboard.jsp">
            Dashboard
        </a>

        <a href="placements.jsp">
            Placements
        </a>

        <a href="LogoutServlet">
            Logout
        </a>

    </div>

</nav>

<h1 style="text-align:center">
    My Application Status
</h1>

<table>

<tr>
    <th>Company</th>
    <th>Job Role</th>
    <th>Package</th>
    <th>Status</th>
</tr>

<%

try {

    Connection con =
        com.placement.DBConnection.getConnection();

    String sql =
        "SELECT p.company, p.job_role, "
        + "p.package_lpa, a.status "
        + "FROM applications a "
        + "JOIN placements p "
        + "ON a.placement_id = p.id "
        + "WHERE a.student_id = ?";

    PreparedStatement ps =
        con.prepareStatement(sql);

    ps.setInt(1, studentId);

    ResultSet rs =
        ps.executeQuery();

    while (rs.next()) {

%>

<tr>

<td>
    <%= rs.getString("company") %>
</td>

<td>
    <%= rs.getString("job_role") %>
</td>

<td>
    <%= rs.getDouble("package_lpa") %> LPA
</td>

<td>
    <%= rs.getString("status") %>
</td>

</tr>

<%

    }

    rs.close();
    ps.close();
    con.close();

} catch (Exception e) {

    out.println(
        "<tr><td colspan='4'>"
        + e.getMessage()
        + "</td></tr>"
    );
}

%>

</table>

</body>

</html>