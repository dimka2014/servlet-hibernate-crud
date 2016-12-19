<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <title>Users</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <form action="/traffic-sources" method="post" role="form" data-toggle="validator">
        <input type="hidden" id="userId" name="userId" value="${user == null ? "" : user.getId()}">
        <input type="hidden" id="tsId" name="tsId" value="${ts == null ? "" : ts.getId()}">
        <h2 class="col-xs-offset-3">${ts == null ? "Create traffic source" : "Edit traffic source"}</h2>
        <div class="form-horizontal col-xs-7">
            <c:if test="${error != null}">
                <div class="alert alert-danger">
                        ${error}
                </div>
            </c:if>
            <div class="form-group">
                <label for="title" class="control-label col-xs-3">Title:</label>
                <div class="col-xs-9">
                    <input type="text" name="title" id="title" class="form-control"
                           value="${ts.getTitle()}" required="true"/>
                </div>
            </div>
            <div class="form-group">
                <label for="url" class="control-label col-xs-3">Url:</label>
                <div class="col-xs-9">
                    <input type="text" name="url" id="url" class="form-control" value="${ts.getUrl()}"
                           required="true"/>
                </div>
            </div>
            <div class="form-group">
                <label for="cost" class="control-label col-xs-3">Cost:</label>
                <div class="col-xs-9">
                    <input type="text" name="cost" id="cost" class="form-control"
                           value="${ts.getCost()}" maxlength="10" placeholder="0.01" required="true"/>
                </div>
            </div>
            <div class="form-group">
                <label for="type" class="control-label col-xs-3">Type:</label>
                <div class="col-xs-9">
                    <select class="form-control" name="tstype" id="type">
                        <option>WEB</option>
                        <option>MOBILE</option>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <div class="col-xs-offset-3 col-sm-10">
                    <button type="submit" class="btn btn-default">Submit</button>
                </div>
            </div>
        </div>
    </form>
</div>
</body>
</html>
