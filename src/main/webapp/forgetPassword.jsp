<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Forget Password</title>
</head>
<body>
    <h1>Forget Password</h1>
    
    <form action="pwdUtil" method="Post">
        <table>
            <tr>
                <td>ID Proof :</td>
                <td><input type="text" name="id_proof" required></td>
            </tr>
            <tr>
                <td>Mobile No. :</td>
                <td><input type="tel" name="mobile_no" required></td>
            </tr>
            <tr>
                <td>Email Id :</td>
                <td><input type="email" name="email" required></td>
            </tr>
            <tr>
                <td>New Password :</td>
                <td><input type="password" name="new_pwd" required></td>
            </tr>
            <tr>
                <td>Confirm Password :</td>
                <td><input type="password" name="cnf_pwd" required></td>
            </tr>
        </table></br>
        <input type="submit" value="Submit">
    </form>
    
    <%-- Display error message if any --%>
    <% String msg = (String) request.getAttribute("msg"); %>
    <% if (msg != null) { %>
        <p><%= msg %></p>
    <% } %>
</body>
</html>
