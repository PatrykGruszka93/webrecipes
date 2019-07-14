<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
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
        <div id="title" class="font-weight-bold">
            <h1>${recipe.title}</h1>
        </div>
        <div id="headerText" class="font-weight-bold text-justify">
            ${recipe.headerText}<br/>
        </div>
        <div id="text" class="text-justify">
            ${recipe.text}<br/>
        </div>
    </div>
    <div class="col-md-12 my-5">
        <div class="font-weight-bold">
            Komentarze:
        </div>
        <c:forEach items="${comments}" var="comment">
            <div class="row">
                <div class="col-md-10 my-2 font-italic">
                    od: ${comment.user.userName}
                </div>
                <div class="col-md-2 my-2">
                    ${comment.formatedDate}
                </div>
            </div>
            <div class="col-md-12 my-2">
                ${comment.text}
            </div>

        </c:forEach>

    </div>
    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <form:form action="${pageContext.request.contextPath}/recipes/processCommentForm" method="POST" modelAttribute="commentModel">
            <input type="hidden" name="recipeId" value="${recipe.id}"/>
            <div class="row">
                <div class="col-md-10 d-flex align-items-center">
                    <form:errors path="text" cssClass="text-danger">
                        <div class="alert alert-danger my-2" role="alert">
                            Nie można zapisać pustego komentarza!
                        </div>
                    </form:errors>
                    <div class="input-group my-2">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                        <form:input type="text" path="text" placeholder="Wpisz komentarz" class="form-control"></form:input>
                    </div>
                </div>
                <div class="col-md-2 d-flex justify-content-center">
                    <form:button class="btn btn-light my-2"  type="submit">Dodaj komentarz</form:button>
                </div>
            </div>

        </form:form>
    </c:if>

    </div>





    </div>

</div>

</body>
</html>




