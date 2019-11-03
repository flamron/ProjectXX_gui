<%@ page contentType="text/html;charset=utf-8" %>
<jsp:include page="header.jsp"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<h5>Пункт наблюдения ${point.shortName}</h5>
<div>
    <p>${point.fullName}</p>
    <p>Широта: ${point.latitude}&deg;</p>
    <p>Долгота: ${point.longitude}&deg;</p>
    <p>Высота: ${point.high} м;</p>
</div>
<table class="table" >
    <caption>Установленные приборы</caption>
    <thead>
    <tr>
        <th scope="col">Серийный номер</th>
        <th scope="col">Тип</th>
        <th scope="col">Модель</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="device" items="${point.devices}">
        <tr>
            <th><a href="../device/${device.id}">
                    ${device.serialNumber}</a>
            </th>
            <td>${device.deviceType.name}</td>
            <td>${device.deviceModel.name}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<jsp:include page="footer.jsp"/>