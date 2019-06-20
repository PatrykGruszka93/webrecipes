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

                <c:if test="${pageContext.request.userPrincipal.name != null}">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Profil
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                        <a class="dropdown-item" href="${pageContext.request.contextPath}/userInfo/1">Wyświetl profil</a>
                        <a class="dropdown-item" href="${pageContext.request.contextPath}/recipes/addRecipeForm">Dodaj przepis</a>
                        <c:if test="${pageContext.request.isUserInRole('ADMIN')}">
                            <a class="dropdown-item" href="${pageContext.request.contextPath}/adminPanel/">Panel admina</a>
                        </c:if>
                    </div>
                </li>
                </c:if>

            </ul>
            <ul class="nav navbar-nav navbar-right">

                <form method="get" action="${pageContext.request.contextPath}/search" class="form-inline">
                    <input class="form-control mr-sm-2" name="query" type="text" placeholder="Szukaj" aria-label="Szukaj">
                    <input type="hidden" name="pageNumber" value="1">
                    <button class="btn btn-light mr-2 mr-sm-2" type="submit">Szukaj</button>
                </form>
                <c:if test="${pageContext.request.userPrincipal.name == null}">
                    <li>
                            <a class="btn btn-light mr-sm-2" href="${pageContext.request.contextPath}/showMyLoginPage">Zaloguj</a>
                    </li>
                </c:if>
                <c:if test="${pageContext.request.userPrincipal.name == null}">
                    <li>
                        <a class="btn btn-light mr-sm-2" href="${pageContext.request.contextPath}/register/showRegistrationForm">Zarejestruj</a>
                    </li>
                </c:if>


                <c:if test="${pageContext.request.userPrincipal.name != null}">
                    <li>
                        <form:form action="${pageContext.request.contextPath}/logout" method="POST">
                            <button class="btn btn-light navbar-btn mr-sm-2" type="submit">Wyloguj</button>
                        </form:form>
                    </li>
                </c:if>
            </ul>
        </div>
    </nav>





