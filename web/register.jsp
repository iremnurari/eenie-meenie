<%-- 
    Document   : register
    Created on : 28.Nis.2018, 01:40:19
    Author     : nurir
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<include page="register.css"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/register.css">
    <title>Register</title>
</head>
<body>
    <%String msg=(String)request.getAttribute("msg");
        if(msg==null)
        {
            msg="";
        }
        %>
    
<div class="reg" align="center">
    <h1>Register Now</h1>
    <p><%=msg%></p>
    <form action="Register" method="post" >
        <input class="in" type="text" name="username" placeholder="Username" ><br>
            <input class="in" type="password" name="password" placeholder="Password"><br>
                <input class="button" type="submit" value="Register"><br>
            </form>
</div>
<form action="login.jsp" method="post">
    <center> <input class="button" type="submit" value="Login" ><br></center>
    </form>
</body>
</html>
