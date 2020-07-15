<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src = "https://code.jquery.com/jquery-3.1.1.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link href="/css/register.css" rel="stylesheet">
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
                    <div>
                       <input type = "text" name = "userId" id ="userId" placeholder="아이디">
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
<script type ="text/javascript">
    $(document).ready(function(){

        var userForm = $("#userForm");
        $("#submitBtn").click(function(e){
            if($("#userId").val() == "" || $("#userId").val() == null){
                alert("아이디를 입력해 주세요");
                return false;
            }
            if($("#pw").val() == "" || $("#pw").val() == null){
                alert("비밀번호를 입력해 주세요");
                return false;
            }
            if($("#name").val() == "" || $("#name").val() == null){
                alert("이름을 입력해 주세요");
                return false;
            }
            userForm.submit();
            alert("회원가입에 성공하셨습니다!");
            console.log("submitBtn Click");
        });

    });
</script>

</html>
