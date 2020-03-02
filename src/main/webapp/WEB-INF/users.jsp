<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <c:forEach items="${users}" var="user">
        ${user.id}--${user.name}--${user.deptId}--${user.date}--<c:if test="${user.admin==true}">是</c:if><c:if test="${user.admin==false}">否</c:if><br>

    </c:forEach>
</body>
</html>
