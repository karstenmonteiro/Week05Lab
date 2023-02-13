package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.AccountService;

/**
 
 * @author Karsten Monteiro
 */
public class LoginServlet extends HttpServlet {
   
    /**
     * doGet() METHOD -- Responsible for logging the user in & out.
     * 
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException 
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        // create session
        HttpSession session = request.getSession();
        // store the value of the param, "username"
        String username = (String)session.getAttribute("username");
        
        /** LOGOUT USER **/
        if (request.getParameterMap().containsKey("logout")) {
            // invalidate session, display logout msg & return user to 'login.jsp'
            session.invalidate();
            request.setAttribute("logoutMsg", "You have succesfully logged out.<br>");
        
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            return;
        }
        
        // redirect any previously authenticated users to 'home.jsp'
        if (username != null) {
            response.sendRedirect("home");
            
            return;
        }
        
        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    } 

    /**
     * doPost() METHOD -- Responsible for processing the submission of the login form from 'login.jsp' and verifying that the login is valid.
     *                    Login is VALID if: (1) the values of "username" & "password" are not empty & (2) the user entered valid login credentials.
     * 
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException 
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        // create session
        HttpSession session = request.getSession();
        // store the values of the params, "username" & "password"
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        /** LOGIN USER & VERIFY that the login is VALID */
        if (username.equals("") || password.equals("")) {
            /** INVALID LOGIN (fields cannot be empty) */
            request.setAttribute("errorMsg", "Invalid login. One or more fields are empty. Please try again.<br>");
            request.setAttribute("username", username);
            request.setAttribute("password", password);

            // return the user to 'login.jsp'
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            return;
        }
        
        /** VALID LOGIN (no empty fields) */
        AccountService login = new AccountService();
        // validate the user's login credentials
        if (login.login(username, password) == null) {
            /** INVALID CREDENTIALS */
            request.setAttribute("errorMsg", "Invalid credentials. Please try again.<br>");
            request.setAttribute("username", username);
            request.setAttribute("password", password);
            
            // return the user to 'login.jsp'
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            return;
        }
        
        /** VALID LOGIN/CREDENTIALS. Store the value of "username" & redirect the user to 'home.jsp' */
        session.setAttribute("username", username);
        response.sendRedirect("home");
    }
}