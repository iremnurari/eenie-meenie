/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pack;

import java.io.IOException;
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
public class Logout extends HttpServlet {

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
  
       HttpSession session=request.getSession();
       session.removeAttribute("username");
       session.invalidate();
       String url="/login.jsp";
       String msg="You have succesfully logged out";
       RequestDispatcher rd=getServletContext().getRequestDispatcher(url);
       request.setAttribute("msg", msg);
       rd.forward(request, response);
   }
}
