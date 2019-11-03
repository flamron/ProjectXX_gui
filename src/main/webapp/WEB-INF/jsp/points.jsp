<%@ page contentType="text/html;charset=utf-8" %>
<jsp:include page="header.jsp"/>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<h1>Приборы:</h1>

<table class="table">
    <thead>
    <tr>
        <th scope="col">Имя</th>
        <th scope="col">Название</th>
        <th scope="col">Широта, &deg;</th>
        <th scope="col">Долгота, &deg;</th>
        <th scope="col">Высота, м</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="point" items="${points}">
        <tr>
            <th><a href="point/${point.shortName}">
                    ${point.shortName}</a>
            </th>
            <td>${point.fullName}</td>
            <td>${point.latitude}</td>
            <td>${point.longitude}</td>
            <td>${point.high}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<jsp:include page="footer.jsp"/>