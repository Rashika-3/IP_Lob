package com.placement;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/PlacementServlet")
public class PlacementServlet extends HttpServlet {

    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Placement Drives</title>");
        out.println("<link rel='stylesheet' href='css/style.css'>");
        out.println("</head>");
        out.println("<body>");

        out.println("<nav>");
        out.println("<div class='logo'>SPMS</div>");
        out.println("<div>");
        out.println("<a href='dashboard.jsp'>Dashboard</a>");
        out.println("<a href='status.jsp'>Status</a>");
        out.println("<a href='LogoutServlet'>Logout</a>");
        out.println("</div>");
        out.println("</nav>");

        out.println("<h1 style='text-align:center'>");
        out.println("Available Placement Drives");
        out.println("</h1>");

        out.println("<table>");

        out.println("<tr>");
        out.println("<th>Company</th>");
        out.println("<th>Job Role</th>");
        out.println("<th>Package</th>");
        out.println("<th>Eligibility</th>");
        out.println("<th>Drive Date</th>");
        out.println("<th>Action</th>");
        out.println("</tr>");

        try {

            Connection con =
                    DBConnection.getConnection();

            String sql =
                    "SELECT * FROM placements";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ResultSet rs =
                    ps.executeQuery();

            while (rs.next()) {

                int id =
                    rs.getInt("id");

                out.println("<tr>");

                out.println("<td>"
                        + rs.getString("company")
                        + "</td>");

                out.println("<td>"
                        + rs.getString("job_role")
                        + "</td>");

                out.println("<td>"
                        + rs.getDouble("package_lpa")
                        + " LPA</td>");

                out.println("<td>"
                        + rs.getDouble("eligibility_cgpa")
                        + "</td>");

                out.println("<td>"
                        + rs.getDate("drive_date")
                        + "</td>");

                out.println("<td>");

                out.println(
                    "<a href='ApplyServlet?id="
                    + id
                    + "'>Apply</a>"
                );

                out.println("</td>");

                out.println("</tr>");
            }

            out.println("</table>");

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {

            out.println(
                "<h3>Error: "
                + e.getMessage()
                + "</h3>"
            );
        }

        out.println("</body>");
        out.println("</html>");
    }
}