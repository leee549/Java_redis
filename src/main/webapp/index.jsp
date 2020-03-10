<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="get" action="/login">
    username:<input type="text" name="name"><br>
    password:<input type="password" name="password"><br>
    <input type="submit" name="登录">
</form>
--------------------
<br>
<form method="post" action="${pageContext.request.contextPath}/upload/test2"
        enctype="multipart/form-data">
    <input type="text" name="username"><br>
    <input type="file" name="file"><br>
    <input type="submit" value="上传">


</form>

</body>
</html>
