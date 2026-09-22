package com.placement;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String name =
                request.getParameter("name");

        String email =
                request.getParameter("email");

        String password =
                request.getParameter("password");

        String department =
                request.getParameter("department");

        String cgpaText =
                request.getParameter("cgpa");


        try {

            double cgpa =
                    Double.parseDouble(cgpaText);


            Connection con =
                    DBConnection.getConnection();


            String sql =
                    "INSERT INTO students " +
                    "(name, email, password, department, cgpa) " +
                    "VALUES (?, ?, ?, ?, ?)";


            PreparedStatement ps =
                    con.prepareStatement(sql);


            ps.setString(1, name);

            ps.setString(2, email);

            ps.setString(3, password);

            ps.setString(4, department);

            ps.setDouble(5, cgpa);


            int result =
                    ps.executeUpdate();


            if (result > 0) {

                response.setContentType("text/html");

                response.getWriter().println(
                        "<script>" +
                        "alert('Registration Successful');" +
                        "window.location='login.jsp';" +
                        "</script>"
                );

            } else {

                response.setContentType("text/html");

                response.getWriter().println(
                        "<script>" +
                        "alert('Registration Failed');" +
                        "window.location='register.jsp';" +
                        "</script>"
                );
            }


            ps.close();

            con.close();


        } catch (Exception e) {

            e.printStackTrace();

            response.setContentType("text/html");

            response.getWriter().println(
                    "<script>" +
                    "alert('Registration Failed. Email may already exist.');" +
                    "window.location='register.jsp';" +
                    "</script>"
            );
        }
    }
}