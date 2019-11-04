<%@ page contentType="text/html;charset=utf-8" %>
<jsp:include page="header.jsp"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="row justify-content-center">
    <div class="col-5">
        <div  class="bg-light rounded">
            <table class="table table-borderless">
                <tbody>
                <tr>
                    <th scope="row">Прибор</th>
                    <td></td>
                </tr>
                <tr>
                    <th scope="row">Сериный номер</th>
                    <td>${device.serialNumber}</td>
                </tr>
                <tr>
                    <th scope="row">Тип</th>
                    <td>${device.deviceType.name}</td>
                </tr>
                <tr>
                    <th scope="row">Модель</th>
                    <td>${device.deviceModel.name}</td>
                </tr>
                <tr>
                    <th scope="row">Установлен в пункте</th>
                    <td>
                        <a href="../point/${device.observationPoint.shortName}">
                        ${device.observationPoint.fullName}</a>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>

    <div class="col-5">
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
                    <td>
                        <a href="../sensor/${device.id}/${sensorDto.number}">
                            ${sensorDto.number}
                        </a>
                    </td>
                    <td>${sensorDto.name}</td>
                    <td>${sensorDto.unitOfMeasure.fullName}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

</div>

<jsp:include page="footer.jsp"/>