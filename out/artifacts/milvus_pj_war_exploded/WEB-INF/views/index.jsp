<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src = "https://code.jquery.com/jquery-3.1.1.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link href="/css/register.css" rel="stylesheet">
<html>
<head>
    <title>Title</title>

</head>
<body>
    <%@ include file="sidebar.jsp"%>

    <div class ="container">
        <div class ="row">
            <c:if test = "${login ne null}">
                안녕하세요 ${login.userId} 님 환영합니다 !
            </c:if>
       </div>
    </div>

</body>
</html>
