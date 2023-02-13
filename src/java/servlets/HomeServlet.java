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
public class HomeServlet extends HttpServlet {
   
    /**
     * doGet() Method
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
        
        // redirect any unauthenticated users to '/login'
        if (username == null) {
            response.sendRedirect("login");
            
            return;
        }
        
        // forward the user to 'home.jsp'
        getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
    }
}