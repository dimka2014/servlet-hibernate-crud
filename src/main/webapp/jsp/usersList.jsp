<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>
    <title>Bootstrap Example</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="/static/bootstrap.min.css">
</head>
<body>

<div class="container">
    <h2>Basic Table</h2>
    <p>The .table class adds basic styling (light padding and only horizontal dividers) to a table:</p>
    <table class="table">
        <thead>
        <tr>
            <th>Firstname</th>
            <th>Lastname</th>
            <th>Phone</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>John</td>
            <td>Doe</td>
            <td>john@example.com</td>
        </tr>
        <tr>
            <td>Mary</td>
            <td>Moe</td>
            <td>mary@example.com</td>
        </tr>
        <tr>
            <td>July</td>
            <td>Dooley</td>
            <td>july@example.com</td>
        </tr>
        <c:forEach var="user" items="${users}" >
            <tr>
                <td><c:out value="${user.getFirstName()}" /></td>
                <td><c:out value="${user.getLastName()}" /></td>
                <td><c:out value="${user.getPhone()}" /></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    ${users.toString()}
</div>

</body>
</html>
