<%-- 
    Document   : welcome
    Created on : 27.Nis.2018, 23:22:54
    Author     : nurir
--%>

<%@page import="Pack.dataBase"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<include page="welcome.css"/>
<!DOCTYPE html>
<html> 
    
    <head>
   
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/welcome.css">
    <title>Home</title>
</head>
<body>
    <%
        
        String msg=(String)request.getAttribute("msg");
        String nonotes="";
        dataBase db=new dataBase();
        ArrayList m=db.display();
        if(m.isEmpty()){
            nonotes="You don't have any notes";
        }
        if(msg==null){
            msg="";
        }
        //To prevent viewing welcome page after logout
        response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
        //to prevent accessing welcome page directly
        //"username" label comes from session in servlet
        if(session.getAttribute("username")==null){
            response.sendRedirect("login.jsp");
        }
        %>
        

        <p class="msg"> <%=msg%></p>
      
<div class="post">
     <h1> Welcome ${username} </h1>
           
        <p1>CONFESSIONS</p1>
         <%=nonotes%>
            <%
                for(int i=0;i<m.size();i++){
             %>  
             <div class="box">
                
                <p><%=(String)m.get(i)%></p>
            </div>
      
        <%}%>
        
    <form action="Welcome" method="post">
        <input class="in" type="text" name="message" placeholder="Confess here" >
            <input class="button" type="submit" class="button" value="post">
    </form>
</div>
<div class="logout">
        <form action="Logout" method="post">
            <center>  <input class="button" type="submit" value="log out" ></center>
       
        </form>
</div>
</body>
</html>
