<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.tpd_client.controllers.HomeServlet"%>
<%@ page import="com.example.tpd_client.models.Motorcycle" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.tpd_client.data_access.UserMotorcycleDAO" %>
<html>
<style><%@include file="/css/home.css"%></style>
<head>
    <title>Title</title>
</head>
<body>

<div class="center">
    <h1>

    Hello,
    <%= request.getSession().getAttribute("username")%>
    </h1>
</div>

<div class="motorcycle-list">
    <h2>You own the following motorcycles:</h2>
    <table>
        <thead>
        <th>#</th>
        <th>Brand name</th>
        <th>Year of production</th>
        </thead>
        <tbody>
        <%
            int i = 1;
            int userId = (int) request.getSession().getAttribute("userId");
            List<Motorcycle> motorcycles = UserMotorcycleDAO.getMotorcyclesForUser(userId);
        %>

        <%
            for(Motorcycle motorcycle : motorcycles) {
        %>
        <tr>
            <td><%= motorcycle.getId()%></td>
            <td><%= motorcycle.getBrand()%></td>
            <td><%= motorcycle.getYearOfProduction()%></td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>

</div>
</body>
</html>
