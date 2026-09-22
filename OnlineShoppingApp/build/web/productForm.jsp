<!DOCTYPE html>
<html>
<head>
    <title>Add Product</title>

    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f7fb;
        }

        .container {
            width: 500px;
            margin: 40px auto;
            background: white;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 0 10px #ccc;
        }

        h2 {
            text-align: center;
            color: #2d6cdf;
        }

        label {
            display: block;
            margin-top: 12px;
            font-weight: bold;
        }

        input {
            width: 100%;
            padding: 10px;
            margin-top: 5px;
            box-sizing: border-box;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        input::placeholder {
            color: #999;
        }

        input[type="submit"] {
            background-color: #2d6cdf;
            color: white;
            border: none;
            margin-top: 20px;
            cursor: pointer;
            font-size: 16px;
        }

        input[type="submit"]:hover {
            background-color: #1f55b5;
        }
    </style>
</head>

<body>

<div class="container">

    <h2>Add Product Details</h2>

    <form action="AddProductServlet" method="post">

        <label>Name</label>
        <input type="text"
               name="name"
               placeholder="Enter your name"
               required>

        <label>Category</label>
        <input type="text"
               name="category"
               placeholder="Enter product category"
               required>

        <label>Product</label>
        <input type="text"
               name="product"
               placeholder="Enter product name"
               required>

        <label>Unit Price</label>
        <input type="number"
               name="unitPrice"
               placeholder="Enter unit price"
               step="0.01"
               required>

        <label>District</label>
        <input type="text"
               name="district"
               placeholder="Enter your district"
               required>

        <label>Phone No</label>
        <input type="text"
               name="phoneNo"
               placeholder="Enter your phone number"
               required>

        <label>Email ID</label>
        <input type="email"
               name="emailId"
               placeholder="Enter your email ID"
               required>

        <input type="submit" value="Add Product">

    </form>

</div>

</body>
</html>