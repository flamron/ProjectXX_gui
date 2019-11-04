<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp"/>
<jsp:include page="gChart.jsp"/>

<div class="row justify-content-center">

    <div class="row">
        <div class="col">
            <div  class="bg-light rounded">
                <table class="table table-borderless">
                    <tbody>
                        <tr>
                            <th scope="row">Сенсор</th>
                            <td></td>
                        </tr>
                        <tr>
                            <th scope="row">Номер</th>
                            <td>${sensor.number}</td>
                        </tr>
                        <tr>
                            <th scope="row">Имя</th>
                            <td>${sensor.name}</td>
                        </tr>
                        <tr>
                            <th scope="row">Единицы измерения:</th>
                            <td>${sensor.unitOfMeasure.shortName} (${sensor.unitOfMeasure.fullName})</td>
                        </tr>
                        <tr>
                            <th scope="row">
                                <a href="../../device/${sensor.deviceId}">Вернуться к прибору</a>
                            </th>
                            <td></td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>

    <div class="row">

        <div class="col">
            <div id="curve_chart" style="width: 900px; height: 500px"></div>
        </div>



    <div class="col-2">
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
    </div>
</div>
</div>

<jsp:include page="footer.jsp"/>