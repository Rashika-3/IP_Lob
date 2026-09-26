<?php

include "db_connect.php";

$sql = "SELECT * FROM orders ORDER BY order_date DESC";
$result = $conn->query($sql);

?>

<!DOCTYPE html>

<html>
<head>


<title>All Orders</title>

<style>

    * {
        box-sizing: border-box;
    }

    body {
        margin: 0;
        font-family: Arial, sans-serif;
        background: #f3f4f6;
    }

    .container {
        width: 90%;
        max-width: 1000px;
        margin: 50px auto;
        background: white;
        padding: 30px;
        border-radius: 15px;
        box-shadow: 0 5px 20px rgba(0,0,0,0.15);
    }

    h2 {
        text-align: center;
        color: #4f46e5;
        margin-bottom: 25px;
    }

    table {
        width: 100%;
        border-collapse: collapse;
        overflow: hidden;
        border-radius: 8px;
    }

    th {
        background: #4f46e5;
        color: white;
        padding: 14px;
    }

    td {
        padding: 13px;
        text-align: center;
        border-bottom: 1px solid #ddd;
    }

    tr:hover {
        background: #f1f5ff;
    }

    .empty {
        text-align: center;
        color: #777;
    }

    .back {
        text-align: center;
        margin-top: 25px;
    }

    .back a {
        display: inline-block;
        padding: 12px 20px;
        background: #4f46e5;
        color: white;
        text-decoration: none;
        border-radius: 8px;
    }

    .back a:hover {
        background: #3730a3;
    }

</style>


</head>

<body>

<div class="container">


<h2>All Orders</h2>

<table>

    <tr>
        <th>Order ID</th>
        <th>Customer</th>
        <th>Product</th>
        <th>Quantity</th>
        <th>Price</th>
        <th>Order Date</th>
    </tr>

    <?php if ($result->num_rows > 0) { ?>

        <?php while ($row = $result->fetch_assoc()) { ?>

            <tr>

                <td><?php echo $row['order_id']; ?></td>

                <td><?php echo $row['customer_name']; ?></td>

                <td><?php echo $row['product_name']; ?></td>

                <td><?php echo $row['quantity']; ?></td>

                <td>₹<?php echo $row['price']; ?></td>

                <td><?php echo $row['order_date']; ?></td>

            </tr>

        <?php } ?>

    <?php } else { ?>

        <tr>
            <td colspan="6" class="empty">
                No orders found.
            </td>
        </tr>

    <?php } ?>

</table>

<div class="back">

    <a href="index.html">← Place Another Order</a>

</div>

</div>

</body>
</html>

<?php
$conn->close();
?>
