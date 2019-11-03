<%@ page contentType="text/html;charset=utf-8" %>
<jsp:include page="header.jsp"/>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<h1>Приборы:</h1>

<table class="table">
    <thead>
    <tr>
        <th scope="col">Серийный номер</th>
        <th scope="col">Тип</th>
        <th scope="col">Модель</th>
        <th scope="col">Пункт наблюдения</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="device" items="${devices}">
        <tr>
            <th>
                <a href="device/${device.id}">
                    ${device.serialNumber}
                </a>
            </th>
            <td>${device.deviceType.name}</td>
            <td>${device.deviceModel.name}</td>
            <td>
                <a href="point/${device.observationPoint.shortName}">
                    ${device.observationPoint.shortName}
                </a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<jsp:include page="footer.jsp"/>