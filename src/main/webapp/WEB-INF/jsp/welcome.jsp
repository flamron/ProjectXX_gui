<%@ page contentType="text/html;charset=utf-8" %>
<jsp:include page="header.jsp"/>

<h1>Hello, ${username}!</h1>

<div>
    <p>Текущее время: <%= new java.util.Date() %></p>
</div>

<jsp:include page="footer.jsp"/>