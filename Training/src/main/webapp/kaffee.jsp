<%@page contentType="text/html; charset=UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <body>
        <h2>Gerds Kaffee-Tipp</h2>
        <br>
        <c:forEach var="type" items="${types}">
            <c:out value="${type}"/>
            <br />
        </c:forEach>
        <br><br><a href='kaffee.html'>Zurück</a>
    </body>
</html>