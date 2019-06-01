<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>


<%@ page contentType="text/html;charset=UTF-8" %>

    <nav class="navbar navbar-expand-sm bg-dark navbar-dark fixed-top" id="mainNavigation">
        <div class = "container-fluid">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="${pageContext.request.contextPath}/">Start <span class="sr-only">(jesteś tutaj)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/userInfo">Profil</a>
                </li>
                <c:if test="${pageContext.request.isUserInRole('ADMIN')}">
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/adminPanel">Panel admina</a>
                    </li>
                </c:if>

                <c:if test="${pageContext.request.userPrincipal.name != null}">
                    <li>
                        <a class="nav-link" href="${pageContext.request.contextPath}/recipes/recipeForm">Dodaj przepis</a>
                    </li>
                </c:if>


            </ul>
            <ul class="nav navbar-nav navbar-right">
                <c:if test="${pageContext.request.userPrincipal.name == null}">
                    <li>
                            <a class="btn btn-light" href="${pageContext.request.contextPath}/showMyLoginPage">Zaloguj</a>
                    </li>
                </c:if>
                <c:if test="${pageContext.request.userPrincipal.name == null}">
                    <li>
                        <a class="btn btn-light" href="${pageContext.request.contextPath}/register/showRegistrationForm">Zarejestruj</a>
                    </li>
                </c:if>


                <c:if test="${pageContext.request.userPrincipal.name != null}">
                    <li>
                        <form:form action="${pageContext.request.contextPath}/logout" method="POST">
                            <button class="btn btn-light navbar-btn" type="submit">Wyloguj</button>
                        </form:form>
                    </li>
                </c:if>
            </ul>
        </div>
    </nav>





