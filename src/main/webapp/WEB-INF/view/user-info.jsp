

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html lang="en">

<head>
    <title>Przepisy kulinarne</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.3.1.min.js" ></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/functions.js"></script>

    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/main.css">
</head>

<body>

<jsp:include page="_menu.jsp" />



<div class="container">
    <div class="col-md-12">
        <security:authorize access="hasRole('USER')">
            Użytkownik: <security:authentication property="principal.username" />
            <br><br>

            Przepisy:
            <table class="table">
                <thead>
                <tr >
                    <th class="text-center" scope="col">Tytuł</th>
                    <th class="text-center" scope="col">Edytuj</th>
                    <th class="text-center" scope="col">Usuń</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${recipes}" var="recipe" varStatus="loopCounter">
                    <c:url var="openRecipeLink" value="recipes/openRecipe">
                        <c:param name="recipeId" value="${recipe.id}"></c:param>
                    </c:url>
                    <c:url var="updateRecipeLink" value="/recipes/updateRecipeForm">
                        <c:param name="recipeId" value="${recipe.id}"></c:param>
                    </c:url>
                    <c:url var="deleteRecipeLink" value="/recipes/delete">
                        <c:param name="recipeId" value="${recipe.id}"></c:param>
                    </c:url>
                    <tr>
                        <td class="text-center"><a href="${openRecipeLink}"> ${recipe.title}</a></td>
                        <td class="text-center"><a href="${updateRecipeLink}" class="btn btn-light">Edytuj</a> </td>
                        <td class="text-center"><a class="btn btn-light" onclick="confirmLink('${deleteRecipeLink}','Czy na pewno chcesz usunąć przepis?')">Usuń</a></td>
                    </tr>
                </c:forEach>
                </tbody>

            </table>
            <nav aria-label="Page navigation example">
                <ul class="pagination">
                    <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/userInfo/1">Pierwszy</a></li>
                    <c:forEach begin="1" end="${maxPage}" var="i" varStatus="loop">
                        <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/userInfo/${i}">${i}</a></li>
                    </c:forEach>
                    <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/userInfo/${maxPage}">Ostatni</a></li>
                </ul>
            </nav>

        </security:authorize>
    </div>


    <security:authorize access="hasRole('ADMIN')">

        <p>
            <a href="${pageContext.request.contextPath}/adminPanel/">Panel admina</a>
        </p>

    </security:authorize>

</div>

</body>
</html>



