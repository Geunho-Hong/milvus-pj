<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src = "https://code.jquery.com/jquery-3.1.1.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link href="/css/login.css" rel="stylesheet">
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@ include file="../sidebar.jsp"%>
<div class ="container" id="container">

    <div class ="row" id ="title">
        관리자 계정 로그인
        <h3><c:out value = "${error}"/></h3>
        <h3><c:out value = "${logout}"/></h3>
    </div>

    <div>
        <form action = "/login" method ="post" id="loginForm">
            <div id="login-box">
                <div>
                    <input type="text" id="userId" name="username"  value="admin" placeholder="아이디">
                </div>
                <div>
                    <input type="password" id="pw" name="password" value ="admin" placeholder="password">
                </div>
                <div>
                    <button type="button" id="login-btn">로그인</button>
                </div>
            </div>
            <input type ="hidden" name = "${_csrf.parameterName}" value ="${_csrf.token}"/>
        </form>
    </div>

</div>

</body>
<script src="/js/user/login.js"></script>
<script type ="text/javascript"/>
</html>
