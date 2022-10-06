package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
        
        // display a login form (login.jsp) to the user that can also show messages
        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        
        /* doGet() responsible for logging out the user. If the parameter "logout" exists,
         * invalidate the session and display a message that the user has successfully logged out
        */
        
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
        
        // validate that the username and password are NOT empty
        
        /* pass the username and passsword parameters to the login() method of a
         * service class called AccountService.
         * 
         * If login() returns a non-null value, store that username in a session variable and
         * REDIRECT (not forward) the user to the home url.
        */
        HttpSession session = request.getSession();
        /*
         * If the authentication parameters are INVALID, display an appropriate error message,
         * keeping the textboxes filled in with what the user has previously entered and FORWARD the user to login.jsp
        */
        
    }
}