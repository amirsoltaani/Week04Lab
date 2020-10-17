
package servlets;

import models.AccountService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author AmirS
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        if (request.getParameter("logout") != null) {
            session.invalidate();
            request.setAttribute("success_logout", "Successfully logged out");
            getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
            session = request.getSession();
        }


        if (session.getAttribute("user") == null || session.getAttribute("user").equals("")) {
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        } else {
            getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        AccountService user = new AccountService();
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (user.login(username, password)) {
            session.setAttribute("user", username);
            session.setAttribute("password", password);

            response.sendRedirect("home");
        } else {
            request.setAttribute("user", username);
            request.setAttribute("pass", password);
            session.setAttribute("invalid", "Invalid login");
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }
    }
}
