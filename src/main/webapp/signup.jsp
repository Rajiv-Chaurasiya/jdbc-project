<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration Form</title>
</head>
<body>
    <form action="pwdUtil" method="Get">
        <table>
            <tr>
                <td>Name :</td>
                <td><input type="text" name="full_name" required/></td>
            </tr>
            <tr>
                <td>Phone Number :</td>
                <td><input type="text" name="mobile_no" required/></td>
            </tr>
            <tr>
                <td>Email Id :</td>
                <td><input type="email" name="email" required/></td>
            </tr>
            <tr>
                <td>Username :</td>
                <td><input type="text" name="username" required/></td>
            </tr>
            <tr>
                <td>Create Password :</td>
                <td><input type="password" name="pwd" required/></td>
            </tr>
            <tr>
                <td>Confirm Password :</td>
                <td><input type="password" name="cnf_pwd" required/></td>
            </tr>
        </table>
        <input type="submit" value="submit" />
    </form>
     <% String msg = (String) request.getAttribute("msg"); %>
    <% if (msg != null) { %>
        <p><%= msg %></p>
    <% } %>
    
    <a href="index.jsp">login page</a>
</body>
</html>
