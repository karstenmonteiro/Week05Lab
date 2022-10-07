package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.AccountService;

/**
 *
 * @author Karsten Monteiro
 */
public class LoginServlet extends HttpServlet {

    /**
     * 
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException 
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        String username = (String)session.getAttribute("username");
        
        // if the param "logout" exists, invalidate session and display logout message
        if (request.getParameterMap().containsKey("logout")) {
            session.invalidate();
            request.setAttribute("loginMsg", "You have successfully logged out.");
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            
            return;
        }
        
        // redirect any previously authenticated users to the 'home'
        if (username != null) {
            response.sendRedirect("home");
            
            return;
        }
        
        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }

    /**
     * 
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException 
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        // validate that the username & password are not empty
        if (username.equals("") || password.equals("")) {
            request.setAttribute("loginMsg", "Invalid login. One or more fields are empty.");
            request.setAttribute("username", username);
            request.setAttribute("password", password);
            
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            return;
        }      
        
        // no empty fields, pass the username & password params to login()
        AccountService validLogin = new AccountService();
        // validate the credentials
        if (validLogin.login(username, password) == null) {
            request.setAttribute("loginMsg", "Invalid credentials. Please try again.");
            request.setAttribute("username", username);
            request.setAttribute("password", password);
            
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            return;
        }
        
        // valid login, store the username and redirect the user to '/home'
        session.setAttribute("username", username);
        response.sendRedirect("home");
        
    }
}