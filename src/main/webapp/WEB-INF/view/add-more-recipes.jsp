<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" %>

<c:forEach items="${recipes}" var="recipe">
    <div class="row border bg-light my-sm-2 py-sm-2">
        <div class="col-md-8">
            <div id="title" class="font-weight-bold">
                <h2>${recipe.title}</h2>
            </div>
            <div id="header" class="font-italic">
                    ${recipe.headerText}
            </div>
            <div id="author">
                Autor: ${recipe.user.userName}
            </div>
        </div>
        <div class="col-md-4 d-flex justify-content-center justify-content-md-end">
            <img src="<c:url value="/resources/images/placeholder.png" />" alt="Placeholder" class="img-thumbnail">
        </div>
    </div>
</c:forEach>