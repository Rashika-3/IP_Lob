<!DOCTYPE html>
<html>

<head>
    <title>Student Login</title>
    <link rel="stylesheet" href="css/style.css">
</head>

<body>

<nav>

    <div class="logo">SPMS</div>

    <div>
        <a href="index.html">Home</a>
        <a href="register.jsp">Register</a>
    </div>

</nav>

<div class="form-container">

    <h2>Student Login</h2>

    <form action="LoginServlet" method="post">

        <label>Email</label>

        <input type="email"
               name="email"
               placeholder="Enter email"
               required>

        <label>Password</label>

        <input type="password"
               name="password"
               placeholder="Enter password"
               required>

        <button type="submit">
            Login
        </button>

    </form>

</div>

</body>
</html>