<%@ page contentType="text/html" pageEncoding="UTF-8" %>

<!DOCTYPE html>

<html>

<head>

    <title>Student Registration</title>

    <link rel="stylesheet" href="css/style.css">

    <script>

        function validateForm() {

            var name =
                    document.forms["registerForm"]["name"].value;

            var email =
                    document.forms["registerForm"]["email"].value;

            var password =
                    document.forms["registerForm"]["password"].value;

            var cgpa =
                    document.forms["registerForm"]["cgpa"].value;


            if (name === "" ||
                email === "" ||
                password === "" ||
                cgpa === "") {

                alert("Please fill all required fields");

                return false;
            }


            if (password.length < 4) {

                alert("Password must contain at least 4 characters");

                return false;
            }


            if (cgpa < 0 || cgpa > 10) {

                alert("CGPA must be between 0 and 10");

                return false;
            }


            return true;
        }

    </script>

</head>


<body>

<nav>

    <div class="logo">
        SPMS
    </div>

    <div class="nav-links">

        <a href="index.html">Home</a>

        <a href="login.jsp">Login</a>

        <a href="register.jsp">Register</a>

    </div>

</nav>


<div class="form-container">

    <h2>Student Registration</h2>


    <form name="registerForm"
          action="RegisterServlet"
          method="post"
          onsubmit="return validateForm()">


        <label>Full Name</label>

        <input type="text"
               name="name"
               placeholder="Enter your name">


        <label>Email</label>

        <input type="email"
               name="email"
               placeholder="Enter your email">


        <label>Password</label>

        <input type="password"
               name="password"
               placeholder="Enter password">


        <label>Department</label>

        <select name="department">

            <option value="">Select Department</option>

            <option value="CSE">CSE</option>

            <option value="IT">IT</option>

            <option value="ECE">ECE</option>

            <option value="EEE">EEE</option>

            <option value="MECH">MECH</option>

        </select>


        <label>CGPA</label>

        <input type="number"
               name="cgpa"
               step="0.01"
               min="0"
               max="10"
               placeholder="Enter CGPA">


        <button type="submit">
            Register
        </button>

    </form>

</div>


<footer>

    <p>
        © 2026 Student Placement Management System
    </p>

</footer>


</body>

</html>