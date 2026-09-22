<?php

if ($_SERVER["REQUEST_METHOD"] != "POST") {

    header("Location: register.html");
    exit;

}

$errors = array();


/* Get Form Values */

$firstName = trim($_POST["firstName"] ?? "");

$lastName = trim($_POST["lastName"] ?? "");

$email = trim($_POST["email"] ?? "");

$phone = trim($_POST["phone"] ?? "");

$gender = trim($_POST["gender"] ?? "");

$jobCategory = trim($_POST["jobCategory"] ?? "");

$skills = trim($_POST["skills"] ?? "");

$creditCard = trim($_POST["creditCard"] ?? "");

$password = $_POST["password"] ?? "";


/* First Name */

if ($firstName == "") {

    $errors[] = "First name is required.";

}


/* Last Name */

if ($lastName == "") {

    $errors[] = "Last name is required.";

}


/* Email */

if ($email == "") {

    $errors[] = "Email is required.";

}
elseif (!filter_var($email, FILTER_VALIDATE_EMAIL)) {

    $errors[] = "Enter a valid email address.";

}


/* Phone Number */

if ($phone == "") {

    $errors[] = "Phone number is required.";

}
elseif (!preg_match("/^(91|21)[0-9]{8}$/", $phone)) {

    $errors[] =
    "Phone number must contain 10 digits and start with 91 or 21.";

}


/* Gender */

if ($gender == "") {

    $errors[] = "Please select your gender.";

}


/* Job Category */

if ($jobCategory == "") {

    $errors[] = "Please select a job category.";

}


/* Skills */

if ($skills == "") {

    $errors[] = "Please select your skill.";

}


/* Credit Card */

if ($creditCard == "") {

    $errors[] = "Credit card number is required.";

}
elseif (!preg_match("/^[0-9]{16}$/", $creditCard)) {

    $errors[] =
    "Credit card number must contain exactly 16 digits.";

}


/* Password */

if ($password == "") {

    $errors[] = "Password is required.";

}
elseif (strlen($password) < 6) {

    $errors[] =
    "Password must contain at least 6 characters.";

}

?>

<!DOCTYPE html>

<html lang="en">

<head>

<meta charset="UTF-8">

<meta name="viewport"
      content="width=device-width, initial-scale=1.0">

<title>Job Portal - Validation</title>

<style>

body {

    margin: 0;

    font-family: Arial, sans-serif;

    background-color: #f4f4f4;

}

header {

    background-color: #2d6cdf;

    color: white;

    padding: 15px 50px;

}

header h2 {

    margin: 0;

}

.container {

    width: 650px;

    margin: 40px auto;

    background-color: white;

    padding: 30px;

    border-radius: 8px;

    box-shadow: 0 3px 10px rgba(0,0,0,0.1);

}

h1 {

    text-align: center;

    color: #2d6cdf;

}

.success {

    text-align: center;

    color: green;

    font-size: 18px;

    font-weight: bold;

}

.error {

    color: red;

    font-size: 16px;

    line-height: 1.8;

}

.details {

    line-height: 2;

    margin-top: 20px;

}

button {

    width: 100%;

    padding: 12px;

    margin-top: 20px;

    background-color: #2d6cdf;

    color: white;

    border: none;

    border-radius: 5px;

    font-size: 16px;

    cursor: pointer;

}

button:hover {

    background-color: #173b7a;

}

a {

    text-decoration: none;

}

</style>

</head>

<body>


<header>

<h2>Job Portal</h2>

</header>


<div class="container">

<?php

if (empty($errors)) {

?>

<h1>Validation Successful</h1>

<p class="success">

Registration details are valid!

</p>


<div class="details">

<b>First Name:</b>

<?php echo htmlspecialchars($firstName); ?>

<br>


<b>Last Name:</b>

<?php echo htmlspecialchars($lastName); ?>

<br>


<b>Email:</b>

<?php echo htmlspecialchars($email); ?>

<br>


<b>Phone Number:</b>

<?php echo htmlspecialchars($phone); ?>

<br>


<b>Gender:</b>

<?php echo htmlspecialchars($gender); ?>

<br>


<b>Job Category:</b>

<?php echo htmlspecialchars($jobCategory); ?>

<br>


<b>Skills:</b>

<?php echo htmlspecialchars($skills); ?>

<br>


<b>Credit Card Number:</b>

<?php echo htmlspecialchars($creditCard); ?>

<br>

</div>


<a href="register.html">

<button type="button">

Back to Registration

</button>

</a>


<?php

}

else {

?>

<h1>Validation Failed</h1>


<ul class="error">

<?php

foreach ($errors as $error) {

    echo "<li>" .
         htmlspecialchars($error) .
         "</li>";

}

?>

</ul>


<a href="register.html">

<button type="button">

Go Back and Correct

</button>

</a>


<?php

}

?>

</div>

</body>

</html>

