<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src = "https://code.jquery.com/jquery-3.1.1.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link href="/css/modify.css" rel="stylesheet">
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@ include file="../sidebar.jsp"%>

<div class ="container" id ="container">

    <div class ="row" id ="title">
        비밀번호 수정
    </div>

    <div>
        <form action ="/user/modify" method="post" id="userForm">
            <input type ="hidden" value ="${login.userId}" name ="userId"/>
            <div id ="registerForm">
                <div>
                    <input type = "password"  name = "pw" id ="pw" placeholder="패스워드">
                </div>
                <div>
                    <input type = "password" name = "name" id ="pwCheck" placeholder="패스워드 확인">
                </div>
                <button type ="button" value ="회원 가입" id ="submitBtn">
                    비밀번호 수정
                </button>
            </div>
        </form>
    </div>

</body>
<script type ="text/javascript">

    var userForm = $("#userForm");

    $("#submitBtn").click(function (e) {

        var pw = $("#pw").val();
        var pwCheck = $("#pwCheck").val();

        if($("#pw").val() == "" || $("#pw").val() == null){
            alert("비밀번호를 입력해 주세요");
            return false;
        }
        if($("#pwCheck").val() == "" || $("#pwCheck").val() == null){
            alert("비밀번호 확인을 입력해 주세요");
            return false;
        }
        if(pw.length <4 || pw.length >12){
            alert("비밀번호는 4자리 이상 12자리 이하를 입력해주세요.")
            $("#pw").focus();
            return false;
        }
        if(pwCheck.length <4 || pwCheck.length >12){
            alert("비밀번호 확인은 4자리 이상 12자리 이하를 입력해주세요.")
            $("#pw").focus();
            return false;
        }
        if(pw != pwCheck){
            alert("비밀번호와 비밀번호 확인이 같은지 확인해주세요");
            return false;
        }
        userForm.submit();
        alert("비밀번호 수정 완료");
    })

</script>
</html>
