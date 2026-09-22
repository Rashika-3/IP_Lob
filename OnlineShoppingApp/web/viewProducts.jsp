<%@ page import="java.util.List" %>
<%@ page import="com.shopping.model.Product" %>
<%@ page import="com.shopping.dao.ProductDAO" %>

<!DOCTYPE html>
<html>
<head>
    <title>View Products</title>

    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f7fb;
        }

        h2 {
            text-align: center;
            color: #2d6cdf;
        }

        table {
            width: 95%;
            margin: 30px auto;
            border-collapse: collapse;
            background-color: white;
        }

        th, td {
            border: 1px solid #ccc;
            padding: 10px;
            text-align: center;
        }

        th {
            background-color: #2d6cdf;
            color: white;
        }

        tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        .back {
            display: block;
            width: 100px;
            margin: 20px auto;
            text-align: center;
            background-color: #2d6cdf;
            color: white;
            padding: 10px;
            text-decoration: none;
            border-radius: 5px;
        }
    </style>
</head>

<body>

<h2>Product Details</h2>

<table>

    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Category</th>
        <th>Product</th>
        <th>Unit Price</th>
        <th>District</th>
        <th>Phone Number</th>
        <th>Email ID</th>
    </tr>

<%
    ProductDAO dao = new ProductDAO();
    List<Product> products = dao.getAllProducts();

    for (Product p : products) {
%>

    <tr>
        <td><%= p.getId() %></td>
        <td><%= p.getName() %></td>
        <td><%= p.getCategory() %></td>
        <td><%= p.getProduct() %></td>
        <td><%= p.getUnitPrice() %></td>
        <td><%= p.getDistrict() %></td>
        <td><%= p.getPhoneNo() %></td>
        <td><%= p.getEmailId() %></td>
    </tr>

<%
    }
%>

</table>

<a class="back" href="index.html">Home</a>

</body>
</html>