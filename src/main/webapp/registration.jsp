<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration Page</title>
</head>
<body>
	<h1>Registration Form</h1>
	<h2>Registration Status</h2>
    
	<form action="LoginServlet" method="Get">
		<table>
            <tr>
                <td>Full Name:</td>
                <td><input type="text" name="full_name" required></td>
            </tr>
            <tr>
                <td>Address:</td>
                <td><input type="text" name="address" required></td>
            </tr>
            <tr>
                <td>Mobile Number:</td>
                <td><input type="tel" name="mobile_no" required></td>
            </tr>
            <tr>
                <td>Email:</td>
                <td><input type="email" name="email_id" required></td>
            </tr>
            <tr>
                <td>Account Type:</td>
                <td>
                    <select name="account_type" required>
                        <option value="Saving">Saving</option>
                        <option value="Current">Current</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>Initial Balance:</td>
                <td><input type="number" name="initial_balance" required></td>
            </tr>
            <tr>
                <td>Date of Birth:</td>
                <td><input type="date" name="dob" required></td>
            </tr>
            <tr>
                <td>ID Proof:</td>
                <td><input type="text" name="id_proof" required></td>
            </tr>
        
        </table>
        		<input type="submit" value="submit"/>
	</form>
	
	
	<% String msg = (String) request.getAttribute("msg"); %>
    <% if (msg != null) { %>
        <p>${msg}</p>
    <% } %>
    <% String error = (String) request.getAttribute("error"); %>
    <% if (error != null) { %>
        <p style="color: red;">${error}</p>
    <% } %>
	
</body>
</html>