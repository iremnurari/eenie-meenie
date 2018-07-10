<!DOCTYPE html>
<%-- 
    Document   : login
    Created on : 27.Nis.2018, 23:22:44
    Author     : nurir
--%>

<%@page  contentType="text/html" pageEncoding="UTF-8"%>
<include page="login.css"/>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Login</title>
    </head>
     <link rel="stylesheet" type="text/css" href="css/login.css">
     <%
        String msg=(String)request.getAttribute("msg");
        if(msg==null)
        {
            msg="";
        }
        %>

<body> 
<div class="login">
    <h1> Welcome </h1>
    <p> <%=msg%></p>
    <form action="Login" method="post"  >
        <input class="in" type="text" name="uname" placeholder="Username"><br>
       <input class="in" type="password" name="pass" placeholder=" Password"><br>
            <input type="submit" class="button" value="Login"><br>
        </form>
</div>
<div class="signup">
    <form action="register.jsp" method="post" align="center">
        <input type="submit" class="button" value="Sign Up">
    </form>
</div>
    
</body>
</html>
