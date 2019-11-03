<%@ page contentType="text/html;charset=utf-8" %>
<jsp:include page="header.jsp"/>

<h1>Hello, ${username}!</h1>

<div>
    Текущее время: <%= new java.util.Date() %>
Имя вашего хоста: <%= request.getRemoteHost() %>
</div>
<p>
    <%! private int accessCount = 0; %>
    Количество обращений к странице с момента загрузки сервера: <%= ++accessCount %>
</p>

<jsp:include page="footer.jsp"/>