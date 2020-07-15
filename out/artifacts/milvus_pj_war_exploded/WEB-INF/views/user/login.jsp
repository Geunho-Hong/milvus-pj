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
            <form action = "/user/login" method ="post" id="loginForm">
                <div id="login-box">
                    <div> <!--required pattern="a-zA-Z].+[0-9]" -->
                        <input type="text" id="userId" name="userId"  placeholder="아이디">
                    </div>
                    <div>
                        <input type="password" id="pw" name="pw" placeholder="password">
                    </div>
                    <div>
                        <button type="button" id="login-btn">로그인</button>
                    </div>
                    <div>
                        <button type="button" id="find-pwBtn">패스워드 찾기</button>
                    </div>
                </div>
            </form>
         </div>

    </div>

</body>
<script type ="text/javascript">
    $(document).ready(function(){

        var loginForm = $("#loginForm");

        $("#find-pwBtn").click(function(e){
            alert("find -pw btn click");
        });

        $("#login-btn").click(function(e){
            if($("#userId").val() == "" || $("#userId").val() == null){
                alert("아이디를 입력해 주세요");
                return false;
            }
            if($("#pw").val() == "" || $("#pw").val() == null){
                alert("비밀번호를 입력해 주세요");
                return false;
            }
            loginForm.submit();
            console.log("Login Success");
        });

    });

</script>
</html>
