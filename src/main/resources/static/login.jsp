%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Login</title>
</head>
<body>
<h1>欢迎登录！</h1>
<form action="/user/login" method="post">
    <input type="text" name="userName"><br>
    <input type="password" name="password"><br>
    <input type="submit" value="提交">
</form>

</body>
</html>