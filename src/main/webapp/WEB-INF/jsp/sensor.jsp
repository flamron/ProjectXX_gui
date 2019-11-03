<%@ page contentType="text/html;charset=utf-8" %>
<jsp:include page="header.jsp"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h5>Сенсор</h5>
<a href="../../device/${sensor.deviceId}">Вернуться к прибору</a>
<p>Номер: ${sensor.number}</p>
<p>Имя: ${sensor.name}</p>
<p>Единицы измерения: ${sensor.unitOfMeasure.shortName} (${sensor.unitOfMeasure.fullName})</p>

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