<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style><%@include file="/css/manage-motorcycles.css"%></style>
    <h1>Motorcycle management page for user <%= request.getSession().getAttribute("username")%></h1>
</head>
<body>
    <div class="add-motorcycle">
        <h2>Motorcycle addition form</h2>
        <form method="post" action="${pageContext.request.contextPath}/manage-motorcycles">
            <input class="form-control" name="brand" type="text">
            <input class="form-control" name="yearOfProduction" type="number">
            <button class="form-button" name="button" type="submit" value="add-motorcycle">Add motorcycle</button>
        </form>
    </div>
</body>
</html>
