package com.shopping.controller;

import com.shopping.dao.ProductDAO;
import com.shopping.model.Product;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
    name = "AddProductServlet",
    urlPatterns = {"/AddProductServlet"}
)
public class AddProductServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String name = request.getParameter("name");
        String category = request.getParameter("category");
        String product = request.getParameter("product");
        String unitPrice = request.getParameter("unitPrice");
        String district = request.getParameter("district");
        String phoneNo = request.getParameter("phoneNo");
        String emailId = request.getParameter("emailId");

        try {

            BigDecimal price = new BigDecimal(unitPrice);

            Product productObj = new Product(
                    name,
                    category,
                    product,
                    price,
                    district,
                    phoneNo,
                    emailId
            );

            ProductDAO dao = new ProductDAO();

            boolean success = dao.addProduct(productObj);

            if (success) {
                response.sendRedirect("viewProducts.jsp");
            } else {
                response.sendRedirect("productForm.jsp");
            }

        } catch (Exception e) {

            e.printStackTrace();

            response.sendRedirect("productForm.jsp");
        }
    }
}