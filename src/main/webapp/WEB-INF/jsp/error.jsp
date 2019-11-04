<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<jsp:include page="header.jsp"/>

<div class="row justify-content-center">
    <h3>ERROR !!!</h3>
    <p class="error">${errorMessage}</p>
</div>

<jsp:include page="footer.jsp"/>