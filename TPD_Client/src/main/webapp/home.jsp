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
    <div class="table">

        <div class="row header blue">
            <div class="cell">
                #
            </div>
            <div class="cell">
                Brand
            </div>
            <div class="cell">
                Year of production
            </div>
        </div>
        <%
            if(request.getSession().getAttribute("errorMessage") == null){
            int i = 1;
            int userId = (int) request.getSession().getAttribute("userId");
            List<Motorcycle> motorcycles = UserMotorcycleDAO.getMotorcyclesForUser(userId);
            for(Motorcycle motorcycle : motorcycles) {
        %>
        <div class="row">
            <div class="cell" data-title="#"><%= motorcycle.getId()%></div>
            <div class="cell" data-title="Brand"><%= motorcycle.getBrand()%></div>
            <div class="cell" data-title="Year of production"><%= motorcycle.getYearOfProduction()%></div>
        </div>
        <%
            }
            }
            else{
        %>
        <div>
            <h1> <%=request.getSession().getAttribute("errorMessage") %> </h1>
        </div>

        <%
            }
          %>


    </div>
</div>
<div class="buttons">
    <button role="button" class="blue-button"> <a href="login.jsp">Log out</a></button>
    <button role="button" class="button-orange"> <a href="manage-motorcycles.jsp">Manage motorcycle list</a></button>
</div>
</body>
</html>
