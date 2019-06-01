
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <title>Profil użytkownika</title>
</head>
<body>

<!-- display user name and role -->
<security:authorize access="hasRole('USER')">
    <p>
        User: <security:authentication property="principal.username" />
        <br><br>
        Role(s): <security:authentication property="principal.authorities" />
        <br><br>
        Email: ${user.email}
        <br><br>
        Recipes: <c:forEach items="${}"

    </p>

</security:authorize>


<security:authorize access="hasRole('ADMIN')">

    <!-- Add a link to point to /systems ... this is for the admins -->

    <p>
        <a href="${pageContext.request.contextPath}/adminPanel">IT Systems Meeting</a>
        (Only for Admin peeps)
    </p>

</security:authorize>
</body>
</html>
