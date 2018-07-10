/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pack;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author nurir
 */

public class Login extends HttpServlet {

    /**
     *
     * @param request
     * @param response
     * @throws IOException
     * @throws ServletException
     */
    @Override
 protected void doPost(HttpServletRequest request, HttpServletResponse response) 
         throws IOException, ServletException
 {
     String url="";
     String msg="";
     String uname=request.getParameter("uname");
     String pass=request.getParameter("pass");
     dataBase db = new dataBase();
     if(db.valid(uname,pass))
     {
         HttpSession session = request.getSession();
         session.setAttribute("username", uname);//username JSTL to use in welcome page
 
         url="/welcome.jsp";
         msg="Successfully logged in";
         
     }
    
     else
     {
         url="/login.jsp";
         msg="Wrong username or password";
     }
    RequestDispatcher rd=getServletContext().getRequestDispatcher(url);
    request.setAttribute("msg", msg);
    rd.forward(request, response);
      
 }
   
}
