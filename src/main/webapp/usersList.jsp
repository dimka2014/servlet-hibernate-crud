<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <title>Bootstrap Example</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
</head>
<body>

<div class="container">
    <h2>Users</h2>
    <table class="table">
        <thead>
        <tr>
            <th>Id</th>
            <th>First name</th>
            <th>Last name</th>
            <th>Birth Date</th>
            <th>Phone</th>
            <th>Organization</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="user" items="${users}">
            <tr>
                <td><c:out value="${user.getId()}"/></td>
                <td><c:out value="${user.getFirstName()}"/></td>
                <td><c:out value="${user.getLastName()}"/></td>
                <td><c:out value="${user.getBirthDate()}"/></td>
                <td><c:out value="${user.getPhone()}"/></td>
                <td><c:out value="${user.getOrganization()}"/></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>
