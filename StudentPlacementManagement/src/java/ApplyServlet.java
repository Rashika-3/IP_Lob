package com.placement;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ApplyServlet")
public class ApplyServlet extends HttpServlet {

    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session =
                request.getSession();

        Integer studentId =
                (Integer) session.getAttribute("studentId");

        if (studentId == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        int placementId =
                Integer.parseInt(
                    request.getParameter("id")
                );

        try {

            Connection con =
                    DBConnection.getConnection();

            String sql =
                    "INSERT INTO applications "
                    + "(student_id, placement_id, status) "
                    + "VALUES (?, ?, 'Applied')";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setInt(1, studentId);
            ps.setInt(2, placementId);

            ps.executeUpdate();

            ps.close();
            con.close();

            response.setContentType("text/html");

            response.getWriter().println(
                "<script>"
                + "alert('Application Submitted Successfully');"
                + "window.location='status.jsp';"
                + "</script>"
            );

        } catch (Exception e) {

            response.getWriter().println(
                "Error: "
                + e.getMessage()
            );
        }
    }
}