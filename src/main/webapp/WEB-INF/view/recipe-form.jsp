<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html lang="en">

<head>
    <title>Dodaj przepis</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/main.css">
</head>

<body>

    <jsp:include page="_menu.jsp" />

    <div id="loginbox" style="margin-top: 50px;"
         class="container col-md-8 col-md-offset-2 col-sm-12 col-sm-offset-2">

        <div class="card bg-light">
        <form:form action="${pageContext.request.contextPath}/recipes/processRecipeForm" method="POST" modelAttribute="recipeModel">
            <form:hidden path="id" />
            <div style="padding-top: 30px" class="card-body">

                <div class="input-group my-2">
                    <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                    <form:input type="text" path="title" placeholder="Tytuł" class="form-control"></form:input>
                </div>

                <div class="input-group my-2">
                    <div class="input-group-prepend">
                        <span class="input-group-text">Streszczenie</span>
                    </div>
                    <form:textarea path="headerText" class="form-control" aria-label="With textarea"></form:textarea>
                </div>

                <div class="input-group my-2">
                    <div class="input-group-prepend">
                        <span class="input-group-text">Opis</span>
                    </div>
                    <form:textarea path="text" class="form-control" aria-label="With textarea"></form:textarea>
                </div>

                     <form:errors path="title" cssClass="text-danger" >
                        <div class="alert alert-danger my-2" role="alert">
                            Podaj tytuł!
                        </div>
                    </form:errors>
                    <form:errors path="headerText" cssClass="text-danger">
                        <div class="alert alert-danger my-2" role="alert">
                            Podaj streszczenie przepisu!
                        </div>
                    </form:errors>
                    <form:errors path="text" cssClass="text-danger">
                        <div class="alert alert-danger my-2" role="alert">
                            Podaj opis przepisu!
                        </div>
                    </form:errors>


            </div>

            <div class="card-header">
                <div class="btn-group">
                    <input type="submit" value=${buttonText} class="btn btn-secondary"\>
                    <a class="btn btn-secondary" href="${pageContext.request.contextPath}/">Anuluj</a>
                </div>
            </div>
        </form:form>
        </div>
    </div>


</body>
</html>
