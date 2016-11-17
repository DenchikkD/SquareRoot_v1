<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <link href="../../css/style.css" rel="stylesheet" type="text/css">
    <meta charset="UTF-8">
    <title>Page of roots</title>
</head>
<body>
<div class="mainWindowResult">
    <div>
        <p class="submit"><a href="index.jsp"><input type="submit" value="New calculate"/></a></p>
    </div>
    <div><b>
        <label class="labelResult">Coefficient A</label>
        <label class="labelResult">Coefficient B</label>
        <label class="labelResult">Coefficient C</label>
        <label class="labelResult">Root One</label>
        <label class="labelResult">Root Two</label>
    </b></div>
    <div><b>
        <label class="labelResult"><c:out value="${result_root.coefA}"/></label>
        <label class="labelResult"><c:out value="${result_root.coefB}"/></label>
        <label class="labelResult"><c:out value="${result_root.coefC}"/></label>
        <label class="labelResult"><c:out value="${result_root.rootOne}"/></label>
        <label class="labelResult"><c:out value="${result_root.rootTwo}"/></label>
    </b></div>
    <h1 style="width: 100%; text-align: center; color: red"><c:out value="${no_roots}"/></h1>
    <c:forEach var="roots" items="${all_root}">
        <div>
            <label class="labelResult">${roots.coefA}</label>
            <label class="labelResult">${roots.coefB}</label>
            <label class="labelResult">${roots.coefC}</label>
            <label class="labelResult">${roots.rootOne}</label>
            <label class="labelResult">${roots.rootTwo}</label>
        </div>


    </c:forEach>

</div>
</body>
</html>