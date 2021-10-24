<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2021/9/19
  Time: 22:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="http://localhost:8080/05/uploadServlet" enctype="multipart/form-data">
    username:<input type="text" name="username" value="请输入用户名"><br>
    上传头像:<input type="file" name="image"><br>
    <input type="submit" value="submit">
</form>

</body>
</html>
