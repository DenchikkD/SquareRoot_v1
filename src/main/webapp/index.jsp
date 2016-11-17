<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
     <link href="css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="mainWindow">
    <h1>Enter your coefficients</h1>
    <form method="post" action="/calculate">
        <p><input type="text" name="coefA" value="" placeholder="Coefficient 'a'" required pattern="^-?[0-9]{1,3}$" title="Enter value 123 or -123. The maximum 999 and minimum value -999" /><label >*</label></p>
        <p><input type="text" name="coefB" value="" placeholder="Coefficient 'b'" required pattern="^-?[0-9]{1,3}$" title="Enter value 123 or -123. The maximum 999 and minimum value -999"/><label >*</label></p>
        <p><input type="text" name="coefC" value="" placeholder="Coefficient 'c'" required pattern="^-?[0-9]{1,3}$" title="Enter value 123 or -123. The maximum 999 and minimum value -999"/><label >*</label></p>
        <p class="submit"><input type="submit" name="calculate" value="Сalculate"/></p>
        <p> <h3><c:out value="${response_message}"/></h3></p>
    </form>
</div>
</body>
</html>
