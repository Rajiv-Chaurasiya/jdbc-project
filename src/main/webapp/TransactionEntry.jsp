<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Transaction Entry</title>

</head>
<body>
    <h1>Transaction Entry</h1>
    
    <form action="CustomerData" method="post">
        <table>
            <tr>
                <th colspan="2">Transaction Details</th>
            </tr>
            <tr>
                <td><label for="accountNumber">Account Number:</label></td>
                <td><input type="number" name="account_no" required></td>
            </tr>
            <tr>
                <td><label for="transactionType">Transaction Type:</label></td>
                <td>
                    <select id="transactionType" name="choose" required>
                        <option value="debit">Withdraw</option>
                        <option value="credit">Deposit</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td><label for="transactionDetails">Transaction Details:</label></td>
                <td><textarea id="transactionDetails" name="transaction_detail" rows="4" cols="50"></textarea></td>
            </tr>
            <tr>
                <td><label for="amount">Amount:</label></td>
                <td><input type="number" name="amt" required></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Submit"></td>
            </tr>
        </table>
    </form>
    
</body>
</html>
