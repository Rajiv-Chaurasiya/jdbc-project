<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Details </title>
</head>
<body>
   



<form method="get" action="CustomerData">
    <table>
        <tr>
            <td>Date :</td>
            <td><input type="date" name="date" value="${param.date}"></td>
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
                <th>Date of Birth</th>
                <th>ID Proof</th>
                <th>Account Number</th>
                <th>Balance</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="customer" items="${customers}" varStatus="loop">
                <tr>
                    <td>${loop.index + 1}</td>
                    <td>${customer.full_name}</td>
                    <td>${customer.address}</td>
                    <td>${customer.mobile_no}</td>
                    <td>${customer.email_id}</td>
                    <td>${customer.account_type}</td>
                    <td>${customer.initial_balance}</td>
                    <td>${customer.date_of_birth}</td>
                    <td>${customer.id_proof}</td>
                    <td>${customer.account_number}</td>
                    
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
