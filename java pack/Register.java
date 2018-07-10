
package Pack;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author nurir
 */
public class Register extends HttpServlet {

 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        dataBase db = new dataBase();
        String msg=db.msg;
        String url="";
        db.register(username,password);
        if(db.bool){
            msg="Registration successful";
            url="/login.jsp";
        }
        else{
            msg="username taken";
            url="/register.jsp";
        }
        RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
        request.setAttribute("msg", msg);
        rd.forward(request,response);
      

    }

}
