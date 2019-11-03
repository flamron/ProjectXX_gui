<%@ page contentType="text/html;charset=utf-8" %>
<jsp:include page="header.jsp"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h5>Прибор</h5>
<p>Сериный номер: ${device.serialNumber}</p>
<p>Тип: ${device.deviceType.name}</p>
<p>Модель: ${device.deviceModel.name}</p>
<p>
    Установлен в пункте: <a href="../point/${device.observationPoint.shortName}">
    ${device.observationPoint.fullName}</a>
</p>
<p></p>

<table class="table">
    <caption>Сенсоры</caption>
    <thead>
    <tr>
        <th scope="col">Номер</th>
        <th scope="col">Название</th>
        <th scope="col">Единицы измерения</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="sensorDto" items="${device.sensors}">
        <tr>
            <td>${sensorDto.number}</td>
            <td>${sensorDto.name}</td>
            <td>${sensorDto.unitOfMeasure.fullName}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<jsp:include page="footer.jsp"/>