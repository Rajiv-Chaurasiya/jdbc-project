<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
<script>
function toggleLinks() {
    var selectBox = document.getElementById("choose");
    var customerSignupLink = document.getElementById("customerSignup");
    var forgetPasswordLink = document.getElementById("forgetPassword");

    if (selectBox.value === "customer") {
        customerSignupLink.style.display = "inline";
        forgetPasswordLink.style.display = "inline";
    } else if (selectBox.value === "admin") {
        customerSignupLink.style.display = "none";
        forgetPasswordLink.style.display = "inline";
    }
}
</script>
</head>
<body>
    <h1>Login Page</h1>
    <form action="LoginServlet" method="post">
        <table>
            <tr>
                <td><label for="choose">Choose your designation:</label></td>
                <td>
                    <select name="Choose" id="choose" onchange="toggleLinks()">
                        <option value="admin">Admin</option>
                        <option value="customer">Customer</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>Username:</td>
                <td><input type="text" name="username" required/></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><input type="password" name="password" required/></td>
            </tr>
        </table></br>
        <input type="submit" value="Submit"/>
    </form>
    
    <%-- JSP code for displaying error message --%>
    <% 
        String error = (String) request.getAttribute("error");
        if (error != null) { 
    %>
        <p><%= error %></p>
    <% } %>
    
    <a id="customerSignup" href="signup.jsp" style="display:none;">Customer Signup</a><br/>
    <a id="forgetPassword" href="forgetPassword.jsp">Forget Password</a>
</body>
</html>
