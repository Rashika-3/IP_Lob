<?php

include "db_connect.php";

$customer_name = $_POST['customer_name'];
$product_name = $_POST['product_name'];
$quantity = $_POST['quantity'];
$price = $_POST['price'];

$sql = "INSERT INTO orders (customer_name, product_name, quantity, price)
        VALUES (?, ?, ?, ?)";

$stmt = $conn->prepare($sql);

$stmt->bind_param(
    "ssid",
    $customer_name,
    $product_name,
    $quantity,
    $price
);

if ($stmt->execute()) {
?>

<!DOCTYPE html>

<html>
<head>


<title>Order Success</title>

<style>

    * {
        box-sizing: border-box;
    }

    body {
        margin: 0;
        font-family: Arial, sans-serif;

        background: linear-gradient(135deg, #667eea, #764ba2);

        min-height: 100vh;

        display: flex;
        justify-content: center;
        align-items: center;
    }

    .success-box {
        width: 450px;

        background: white;

        padding: 40px;

        text-align: center;

        border-radius: 20px;

        box-shadow: 0 10px 30px rgba(0,0,0,0.25);
    }

    .icon {
        width: 70px;
        height: 70px;

        background: #22c55e;

        color: white;

        border-radius: 50%;

        display: flex;
        justify-content: center;
        align-items: center;

        margin: 0 auto 20px;

        font-size: 38px;
        font-weight: bold;
    }

    h2 {
        color: #16a34a;

        margin-bottom: 10px;
    }

    p {
        color: #666;

        font-size: 16px;

        margin-bottom: 25px;
    }

    .button {
        display: inline-block;

        padding: 12px 20px;

        background: #4f46e5;

        color: white;

        text-decoration: none;

        border-radius: 8px;

        font-weight: bold;
    }

    .button:hover {
        background: #3730a3;
    }

</style>


</head>

<body>


<div class="success-box">

    <div class="icon">✓</div>

    <h2>Order Placed Successfully!</h2>

    <p>Your order has been saved successfully.</p>

    <a href="view_orders.php" class="button">
        View All Orders
    </a>

</div>


</body>
</html>

<?php
} else {
?>

<!DOCTYPE html>

<html>
<head>


<title>Order Error</title>

<style>

    body {
        margin: 0;

        font-family: Arial, sans-serif;

        background: #fee2e2;

        min-height: 100vh;

        display: flex;
        justify-content: center;
        align-items: center;
    }

    .error-box {
        width: 450px;

        background: white;

        padding: 40px;

        text-align: center;

        border-radius: 20px;

        box-shadow: 0 10px 30px rgba(0,0,0,0.2);
    }

    h2 {
        color: #dc2626;
    }

    .button {
        display: inline-block;

        padding: 12px 20px;

        background: #4f46e5;

        color: white;

        text-decoration: none;

        border-radius: 8px;
    }

</style>


</head>

<body>


<div class="error-box">

    <h2>Order Failed</h2>

    <p>
        <?php echo $stmt->error; ?>
    </p>

</div>


</body>
</html>

<?php
}

$stmt->close();
$conn->close();

?>
