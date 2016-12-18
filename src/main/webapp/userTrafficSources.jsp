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
    <h2>${user.getFirstName()} ${user.getLastName()} traffic sources:</h2>
    <table class="table">
        <thead>
        <tr>
            <th>Id</th>
            <th>Title</th>
            <th>Type</th>
            <th>Cost</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="ts" items="${user.getTrafficSources()}">
            <tr>
                <td><c:out value="${ts.getId()}"/></td>
                <td><a href="<c:out value="${ts.getUrl()}"/>"><c:out value="${ts.getTitle()}"/></a></td>
                <td><c:out value="${ts.getType()}"/></td>
                <td><c:out value="${ts.getCost()}"/></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>
