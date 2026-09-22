package sessiontracking;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/SessionTrackingServlet")
public class SessionTrackingServlet extends HttpServlet {

    private static int visitorCount = 0;

    /*
     * ONE VALID USERNAME
     */
    private static final String VALID_USERNAME = "Student";

    /*
     * ONE VALID STRONG PASSWORD
     */
    private static final String VALID_PASSWORD = "Student@123";


    // =====================================================
    // doGet()
    // =====================================================

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        String action = request.getParameter("action");


        // =================================================
        // LOGOUT
        // =================================================

        if ("logout".equals(action)) {

            HttpSession session =
                    request.getSession(false);

            if (session != null) {
                session.invalidate();
            }

            out.println("<html>");
            out.println("<head>");
            out.println("<title>Logout</title>");
            out.println("</head>");

            out.println("<body style='font-family:Arial;"
                    + "text-align:center;"
                    + "padding-top:100px;"
                    + "background:#e8f5e9;'>");

            out.println("<h1>Logout Successful</h1>");

            out.println("<p>Your session has been destroyed.</p>");

            out.println("<br>");

            out.println("<a href='index.html'>"
                    + "Login Again"
                    + "</a>");

            out.println("</body>");
            out.println("</html>");

            return;
        }


        // =================================================
        // URL REWRITING
        // =================================================

        if ("url".equals(action)) {

            String user =
                    request.getParameter("user");

            out.println("<html>");
            out.println("<head>");
            out.println("<title>URL Rewriting</title>");
            out.println("</head>");

            out.println("<body style='font-family:Arial;"
                    + "text-align:center;"
                    + "padding-top:100px;"
                    + "background:#e3f2fd;'>");

            out.println("<h1>URL Rewriting</h1>");

            out.println("<h2>Hello "
                    + user
                    + "</h2>");

            out.println("<p>");
            out.println("Username was transferred through "
                    + "the URL.");
            out.println("</p>");

            out.println("<p><b>URL Rewriting Example:</b></p>");

            out.println("<p>"
                    + request.getRequestURL()
                    + "?action=url&user="
                    + user
                    + "</p>");

            out.println("<br>");

            out.println("<a href='SessionTrackingServlet'>"
                    + "Back to Dashboard"
                    + "</a>");

            out.println("</body>");
            out.println("</html>");

            return;
        }


        // =================================================
        // COOKIE TRACKING
        // =================================================

        if ("cookie".equals(action)) {

            String username =
                    "Cookie not found";

            Cookie[] cookies =
                    request.getCookies();

            if (cookies != null) {

                for (Cookie cookie : cookies) {

                    if ("username".equals(
                            cookie.getName())) {

                        username =
                                cookie.getValue();

                        break;
                    }
                }
            }

            out.println("<html>");

            out.println("<head>");
            out.println("<title>Cookie Tracking</title>");
            out.println("</head>");

            out.println("<body style='font-family:Arial;"
                    + "text-align:center;"
                    + "padding-top:100px;"
                    + "background:#fff3e0;'>");

            out.println("<h1>Cookie Tracking</h1>");

            out.println("<h2>Username: "
                    + username
                    + "</h2>");

            out.println("<p>");
            out.println("Username was retrieved from "
                    + "the browser cookie.");
            out.println("</p>");

            out.println("<br>");

            out.println("<a href='SessionTrackingServlet'>"
                    + "Back to Dashboard"
                    + "</a>");

            out.println("</body>");
            out.println("</html>");

            return;
        }


        // =================================================
        // GET EXISTING SESSION
        // =================================================

        HttpSession session =
                request.getSession(false);


        // =================================================
        // SESSION NOT FOUND
        // =================================================

        if (session == null
                || session.getAttribute("username") == null) {

            response.sendRedirect("index.html");

            return;
        }


        // =================================================
        // GET USERNAME FROM SESSION
        // =================================================

        String username =
                (String) session.getAttribute("username");


        // =================================================
        // DASHBOARD
        // =================================================

        out.println("<html>");

        out.println("<head>");

        out.println("<title>Session Dashboard</title>");

        out.println("<style>");

        out.println("body{"
                + "font-family:Arial;"
                + "background:linear-gradient(135deg,"
                + "#667eea,#764ba2);"
                + "text-align:center;"
                + "padding-top:40px;"
                + "}");

        out.println(".box{"
                + "background:white;"
                + "width:650px;"
                + "margin:auto;"
                + "padding:35px;"
                + "border-radius:20px;"
                + "box-shadow:0 5px 20px gray;"
                + "}");

        out.println(".button{"
                + "display:block;"
                + "background:#2c3e50;"
                + "color:white;"
                + "padding:12px;"
                + "margin:10px;"
                + "text-decoration:none;"
                + "border-radius:7px;"
                + "}");

        out.println(".info{"
                + "background:#f4f6f8;"
                + "padding:15px;"
                + "border-radius:10px;"
                + "}");

        out.println("</style>");

        out.println("</head>");

        out.println("<body>");

        out.println("<div class='box'>");


        // Welcome
        out.println("<h1>Welcome "
                + username
                + " 👋</h1>");

        out.println("<hr>");


        // =================================================
        // HTTP SESSION
        // =================================================

        out.println("<h2>HttpSession</h2>");

        out.println("<div class='info'>");

        out.println("<p><b>Username:</b> "
                + username
                + "</p>");

        out.println("<p><b>Session ID:</b> "
                + session.getId()
                + "</p>");

        out.println("<p><b>Session Timeout:</b> "
                + session.getMaxInactiveInterval()
                + " seconds</p>");

        out.println("<p><b>Visitor Count:</b> "
                + visitorCount
                + "</p>");

        out.println("</div>");


        out.println("<hr>");

        out.println("<h2>Session Tracking Methods</h2>");


        // =================================================
        // HIDDEN FORM FIELD
        // =================================================

        out.println("<form "
                + "action='SessionTrackingServlet'"
                + " method='post'>");

        out.println("<input type='hidden'"
                + " name='hiddenUser'"
                + " value='" + username + "'>");

        out.println("<input type='submit'"
                + " value='Hidden Form Field'>");

        out.println("</form>");


        // =================================================
        // URL REWRITING
        // =================================================

        out.println("<a class='button'"
                + " href='SessionTrackingServlet"
                + "?action=url&user="
                + username
                + "'>");

        out.println("URL Rewriting");

        out.println("</a>");


        // =================================================
        // COOKIE
        // =================================================

        out.println("<a class='button'"
                + " href='SessionTrackingServlet"
                + "?action=cookie'>");

        out.println("Cookie Tracking");

        out.println("</a>");


        // =================================================
        // LOGOUT
        // =================================================

        out.println("<a class='button'"
                + " href='SessionTrackingServlet"
                + "?action=logout'>");

        out.println("Logout");

        out.println("</a>");


        out.println("</div>");

        out.println("</body>");

        out.println("</html>");
    }


    // =====================================================
    // doPost()
    // =====================================================

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out =
                response.getWriter();


        // =================================================
        // HIDDEN FORM FIELD
        // =================================================

        String hiddenUser =
                request.getParameter("hiddenUser");

        if (hiddenUser != null) {

            out.println("<html>");

            out.println("<head>");
            out.println("<title>Hidden Form Field</title>");
            out.println("</head>");

            out.println("<body style='font-family:Arial;"
                    + "text-align:center;"
                    + "padding-top:100px;"
                    + "background:#fffde7;'>");

            out.println("<h1>Hidden Form Field</h1>");

            out.println("<h2>Hello "
                    + hiddenUser
                    + "</h2>");

            out.println("<p>");
            out.println("Username was transferred using "
                    + "a hidden HTML form field.");
            out.println("</p>");

            out.println("<br>");

            out.println("<a href='SessionTrackingServlet'>"
                    + "Back to Dashboard"
                    + "</a>");

            out.println("</body>");

            out.println("</html>");

            return;
        }


        // =================================================
        // LOGIN DETAILS
        // =================================================

        String username =
                request.getParameter("username");

        String password =
                request.getParameter("password");


        // =================================================
        // ONLY ONE USERNAME + PASSWORD
        // =================================================

        if (VALID_USERNAME.equals(username)
                && VALID_PASSWORD.equals(password)) {


            // =============================================
            // CREATE SESSION
            // =============================================

            HttpSession session =
                    request.getSession();


            // =============================================
            // STORE USERNAME
            // =============================================

            session.setAttribute(
                    "username",
                    username);


            // =============================================
            // SESSION TIMEOUT
            // 5 MINUTES
            // =============================================

            session.setMaxInactiveInterval(300);


            // =============================================
            // VISITOR COUNT
            // =============================================

            if (session.getAttribute("visited")
                    == null) {

                visitorCount++;

                session.setAttribute(
                        "visited",
                        true);
            }


            // =============================================
            // CREATE COOKIE
            // =============================================

            Cookie cookie =
                    new Cookie(
                            "username",
                            username);

            cookie.setMaxAge(
                    60 * 60 * 24 * 7);

            response.addCookie(cookie);


            // =============================================
            // OPEN DASHBOARD
            // =============================================

            response.sendRedirect(
                    "SessionTrackingServlet");

        } else {


            // =============================================
            // INVALID LOGIN
            // =============================================

            out.println("<html>");

            out.println("<head>");
            out.println("<title>Login Failed</title>");
            out.println("</head>");

            out.println("<body style='font-family:Arial;"
                    + "text-align:center;"
                    + "padding-top:100px;"
                    + "background:#ffebee;'>");

            out.println("<h1>❌ Login Failed</h1>");

            out.println("<h2>Invalid Username or Password</h2>");

            out.println("<p>");
            out.println("Please enter the correct login details.");
            out.println("</p>");

            out.println("<br>");

            out.println("<a href='index.html'>"
                    + "Try Again"
                    + "</a>");

            out.println("</body>");

            out.println("</html>");
        }
    }
}