<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Customer List</title>
</head>
<body>
    <h2>Customer List</h2>

    <h2>Search Customer Details</h2>


<form method="get" action="CustomerData">
    <table>
        <tr>
            <td>Account Number:</td>
            <td><input type="text" name="account_number" value="${param.account_number}"></td>
        </tr>
        <tr>
            <td>Full Name:</td>
            <td><input type="text" name="full_name" value="${param.full_name}"></td>
        </tr>
        <tr>
            <td>ID Proof:</td>
            <td><input type="text" name="id_proof" value="${param.id_proof}"></td>
        </tr>
        <tr>
            <td colspan="2" style="text-align: center;"><input type="submit" value="Search"></td>
        </tr>
    </table>
</form>

    <table border="1">
        <thead>
            <tr>
                <th>S.No.</th>
                <th>Full Name</th>
                <th>Address</th>
                <th>Mobile No</th>
                <th>Email ID</th>
                <th>Account Type</th>
                <th>Initial Balance</th>
                <th>Date of Birth</th>
                <th>ID Proof</th>
                <th>Account Number</th>
                <th>Balance</th>
            </tr>
        </thead>
            <% 
        String error = (String) request.getAttribute("error");
        if (error != null) { 
    %>
        <p><%= error %></p>
    <% } %>
        <tbody>
            <c:forEach var="customer" items="${customers}" varStatus="loop">
                <tr>
                    <td>${loop.index + 1}</td>
                    <td>${customer.full_name}</td>
                    <td>${customer.address}</td>
                    <td>${customer.mobile_no}</td>
                    <td>${customer.email}</td>
                    <td>${customer.account_type}</td>
                    <td>${customer.initial_balance}</td>
                    <td>${customer.date_of_birth}</td>
                    <td>${customer.id_proof}</td>
                    <td>${customer.account_number}</td>
                    <td>${customer.balance}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
