<%@ page contentType="text/html;charset=utf-8" %>
<jsp:include page="header.jsp"/>

<div class="row justify-content-center">
    <div>
        <h1>Hello, ${username}!</h1>

        <p>Текущее время: <%= new java.util.Date() %></p>
    </div>

</div>

<jsp:include page="footer.jsp"/>