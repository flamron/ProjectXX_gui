<%--<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<jsp:include page="header.jsp"/>

<form action="${pageContext.request.contextPath}/add-product" method="post" enctype="multipart/form-data">
    <div class="form-group">
        <label for="exampleInputEmail1">Email address</label>
        <input type="text" name="itemName" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter product name">
        <small id="emailHelp" class="form-text text-muted">Please describe product item</small>
        <div class="invalid-feedback">
            <form:errors path="itemtName"/>
        </div>
    </div>
    <div class="form-group">
        <label for="exampleInputPassword1">Price</label>
        <input type="number" name="price" class="form-control" id="exampleInputPassword1" placeholder="Product price">
        <div class="invalid-feedback">
            <form:errors path="price"/>
        </div>
    </div>
    <div class="form-group">
        <label for="exampleFormControlFile1">Example file input</label>
        <input type="file" name="file" class="form-control-file" id="exampleFormControlFile1">
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
</form>

<jsp:include page="footer.jsp"/>