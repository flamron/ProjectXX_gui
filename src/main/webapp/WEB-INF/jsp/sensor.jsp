<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <jsp:include page="gChart.jsp"/>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <title>Hello, world!</title>
</head>
<body>
<ul class="nav">
    <li class="nav-item">
        <a class="nav-link active" href="${pageContext.request.contextPath}/">Home</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="${pageContext.request.contextPath}/points">Points</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="${pageContext.request.contextPath}/devices">Devices</a>
    </li>
    <sec:authorize access="!isAuthenticated()">
        <li class="nav-item">
            <a class="nav-link" href="${pageContext.request.contextPath}/registration">Register</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="${pageContext.request.contextPath}/login">Login</a>
        </li>
    </sec:authorize>
    <sec:authorize access="isAuthenticated()">
        <li class="nav-item">
            <a class="nav-link" href="${pageContext.request.contextPath}/logout">Logout</a>
        </li>
    </sec:authorize>
</ul>
<form class="form-inline my-2 my-lg-0" action="${pageContext.request.contextPath}/search">
    <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search" name="search-str">
    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
</form>

<h5>Сенсор</h5>
<a href="../../device/${sensor.deviceId}">Вернуться к прибору</a>
<p>Номер: ${sensor.number}</p>
<p>Имя: ${sensor.name}</p>
<p>Единицы измерения: ${sensor.unitOfMeasure.shortName} (${sensor.unitOfMeasure.fullName})</p>

<div id="curve_chart" style="width: 900px; height: 500px"></div>

<table class="table">
    <caption>Данные</caption>
    <thead>
    <tr>
        <th scope="col">Дата</th>
        <th scope="col">Value</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="entry" items="${sensor.values}">
        <tr>
            <td>${entry.key}</td>
            <td>${entry.value.value}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<jsp:include page="footer.jsp"/>