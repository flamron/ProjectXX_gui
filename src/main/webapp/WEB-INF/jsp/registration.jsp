<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp"/>

<div class="row justify-content-center">
<h1>Register new user</h1>

<form action="${pageContext.request.contextPath}/registration" method="POST">
    <div class="form-group">
        <label for="firstName">First name</label>
        <input type="text" name="firstName" class="form-control" id="firstName" placeholder="Enter first name">
        <small class="form-text text-muted">Please enter your first name</small>
    </div>
    <div class="form-group">
        <label for="lastName">Last name</label>
        <input type="text" name="lastName" class="form-control" id="lastName" placeholder="Enter last name">
        <small class="form-text text-muted">Please enter your last name</small>
    </div>
    <div class="form-group">
        <label for="email">Email</label>
        <input type="email" name="email" class="form-control" id="email" placeholder="Enter your email">
        <small class="form-text text-muted">Your email will be used for logic</small>
    </div>
    <div class="form-group">
        <label for="password">Password</label>
        <input type="password" name="password" class="form-control" id="password" placeholder="Enter your password">
        <small class="form-text text-muted">Please enter your last password</small>
    </div>

    <button type="submit" class="btn btn-primary">Submit</button>
</form>
</div>

<jsp:include page="footer.jsp"/>