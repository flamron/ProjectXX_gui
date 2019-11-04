<%@ page contentType="text/html;charset=utf-8" %>
<jsp:include page="header.jsp"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="row justify-content-center">
    <div class="col-5">
        <table class="table table-borderless">
            <tbody>
            <tr>
                <th scope="row">Пункт наблюдения</th>
                <td></td>
            </tr>
            <tr>
                <th scope="row">Пункт наблюдения</th>
                <td>${point.shortName}</td>
            </tr>
            <tr>
                <th scope="row">Широта</th>
                <td>${point.latitude}&deg;</td>
            </tr>
            <tr>
                <th scope="row">Долгота</th>
                <td>${point.longitude}&deg;</td>
            </tr>
            <tr>
                <th scope="row">Высота</th>
                <td>${point.high} м;</td>
            </tr>
            </tbody>
        </table>
    </div>
    <div class="col-5">
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
    </div>
</div>

<jsp:include page="footer.jsp"/>