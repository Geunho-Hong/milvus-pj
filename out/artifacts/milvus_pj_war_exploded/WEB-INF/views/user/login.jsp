<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src = "https://code.jquery.com/jquery-3.1.1.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link href="/css/login.css" rel="stylesheet">
<html>
<head>
    <title>Title</title>
</head>
<script type ="text/javascript">
    var message = "${msg}";
    if (message != "") {
        alert(message);
    }
</script>

<body>
<%@ include file="../sidebar.jsp"%>
    <div class ="container" id="container">

        <div class ="row" id ="title">
            로그인
        </div>

        <div>
            <form action = "/user/login-post" method ="post" id="loginForm">
                <div id="login-box">
                    <div>
                        <input type="text" id="userId" name="userId"  placeholder="아이디">
                    </div>
                    <div>
                        <input type="password" id="pw" name="pw" placeholder="password">
                    </div>
                    <div>
                        <button type="button" id="login-btn">로그인</button>
                    </div>
                </div>
            </form>
         </div>

    </div>

</body>
<script src="/js/user/login.js"></script>
<script type ="text/javascript"/>
</html>
