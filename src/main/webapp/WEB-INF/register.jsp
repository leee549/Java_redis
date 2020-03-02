<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/register" method="post">

    username:<input type="text" name="name"><br>
    password:<input type="password" name="password"><br>
    deptId:<input type="text" name="deptId"><br>
    date:<input type="text" name="date"><br>
    admin:<input type="text" name="admin"><br>
    <input type="submit" value="注册">

</form>

<form action="/update" method="post">
    date:<input type="text" name="date"><br>
    <input type="submit" value="修改">

</form>



</body>
</html>
