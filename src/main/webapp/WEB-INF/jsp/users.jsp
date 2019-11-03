<%@ page contentType="text/html;charset=utf-8" %>
<jsp:include page="header.jsp"/>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<h1>Пользователи:</h1>

<table class="table">
    <thead>
    <tr>
        <th scope="col">Email</th>
        <th scope="col">Имя</th>
        <th scope="col">Фамилия</th>
        <th scope="col">Роли</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="user" items="${users}">
        <tr>
            <th>${user.email}</th>
            <td>${user.firstName}</td>
            <td>${user.lastName}</td>
            <td>${user.appRoles}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>1

<jsp:include page="footer.jsp"/>