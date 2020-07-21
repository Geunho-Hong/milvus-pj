<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Security LogOut</title>
</head>
<body>
    <form action ="/user/log-out" method="post">
        <input type ="hidden" name ="${csrf_parameterName}" value ="${csrf_token}"/>
        <button>로그 아웃</button>
    </form>
</body>
</html>
