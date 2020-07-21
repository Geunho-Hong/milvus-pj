<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src = "https://code.jquery.com/jquery-3.1.1.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link href="/css/register.css" rel="stylesheet">
<script src="/js/user/register.js"/>
<html>
<head>
    <title>회원 가입</title>
</head>
<body>
<%@ include file="../sidebar.jsp"%>

    <div class ="container" id ="container">

        <div class ="row" id ="title">
            회원 가입
        </div>

        <div>
            <form action ="/user/register" method="post" id="userForm">
                <div id ="registerForm">
                    <div id ="idDiv">
                       <input type = "text" name = "userId" id ="userId" placeholder="아이디">
                        <button type="button" id="checkBtn">Id check</button>
                    </div>
                    <div>
                       <input type = "password"  name = "pw" id ="pw" placeholder="패스워드">
                    </div>
                    <div>
                       <input type = "text" name = "name" id ="name" placeholder="이름">
                    </div>
                    <button type ="button" value ="회원 가입" id ="submitBtn">
                        회원 가입
                    </button>
                </div>
            </form>
        </div>
</body>
</html>
