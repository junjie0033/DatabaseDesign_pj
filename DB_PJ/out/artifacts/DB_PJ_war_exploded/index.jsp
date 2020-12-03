<%--
  Created by IntelliJ IDEA.
  User: duocai wu
  Date: 2017/7/4
  Time: 12:26
  --%>
<%@ page contentType="text/html;charset=utf-8" language="java" %>
<html>
<head>
  <title>$Title$</title>
</head>
<body>
Hello, World
<%--
    ./login 对应于刚刚servlet的value值，用./这种相对路径是一种很好的习惯。
  可避免项目迁移，部署时一些路径引用的错误。
--%>
<form action="./login" method="post">
  Username: <input type="text" name="username" placeholder="enter username">
  <br>
  Password: <input type="password" name="password" placeholder="enter password">
  <br>
  <button type="submit">Submit</button>
</form>
</body>
</html>
