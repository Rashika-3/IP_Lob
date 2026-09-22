<%
    if (session.getAttribute("studentId") == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>

<!DOCTYPE html>

<html>

<head>

    <title>Placement Drives</title>

    <meta http-equiv="refresh"
          content="0;URL=PlacementServlet">

</head>

<body>

</body>

</html>