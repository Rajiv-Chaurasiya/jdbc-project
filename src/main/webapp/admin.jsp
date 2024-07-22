<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Welcome Admin</title>
</head>
<body>
    <h2>Welcome Admin</h2>
    <% String welcomeMessage = (String) request.getAttribute("Welcome"); %>
    <% if (welcomeMessage != null) { %>
        <p>${welcomeMessage}</p>
    <% } %>
    <% String error = (String) request.getAttribute("error"); %>
    <% if (error != null) { %>
        <p style="color: red;">${error}</p>
    <% } %>
    <a href="registration.jsp">Customer Registration</a></br> 
    <a href="customerDetailForAdmin.jsp">View list of customer</a></br>
    <a href="TransactionEntry.jsp">Entry Transaction</a></br>
</body>
</html>
