<jsp:include page="header.jsp"/>
<h1>Product catalog!</h1>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<table class="table">
    <thead>
    <tr>
        <th scope="col">#</th>
        <th scope="col">Name</th>
        <th scope="col">Price</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="item" items="${catalog}">
        <tr>
            <th scope="row">${item.id}</th>
            <td><a href="product-catalog/item/${item.id}" class="badge badge-light">${item.itemName}</a></td>
            <td>${item.price}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>


<jsp:include page="footer.jsp"/>