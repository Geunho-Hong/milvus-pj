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
<script type ="text/javascript">
    $(document).ready(function(){

        var userForm = $("#userForm");

        var idCheck = 0;

        $("#submitBtn").click(function(e){

            var userId = $("#userId").val();
            var pw = $("#pw").val();
            var name = $("#name").val();

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
            if(checkId(userId)){
                alert("아이디는 한글과 공백을 허가하지 않습니다");
                $("#userId").focus();
                return false;
            }
            if(userId.length <5 || userId.length >12){
                alert("아이디는 6자리 이상 12자리 이하를 입력해주세요 ");
                $("#userId").focus();
                return false;
            }
            if(checkName(name)){
                alert("이름은 공백,영어,숫자를 허용하지 않습니다");
                $("#name").focus();
                return false;
            }
            if(pw.length <4 || pw.length >12){
                alert("비밀번호는 4자리 이상 12자리 이하를 입력해주세요.")
                $("#pw").focus();
                return false;
            }
            if(name.length <1 && pw.length >5){
                alert("이름은 2자 이상 4자 이하를 입력해주세요.")
                $("#name").focus();
                return false;
            }
            if(idCheck == 0){
                alert("아이디 중복 체크가 필요합니다");
                return false;
            }
            userForm.submit();
            alert("회원가입에 성공하셨습니다!");

            console.log("submitBtn Click");
        });

        function checkId(userId) {
            var pattern1 = /[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/; // 한글 여부
            var pattern2 = /\s/; // 공백 여부

            if(pattern1.test(userId) || pattern2.test(userId)){
                return true;
            }else{
                return false;
            }
        };

        function checkName(name){
            var pattern1 = /\s/; // 공백 여부
            var pattern2 = /[a-zA-Z0-9]/;   // 영어와 숫자 여부

            if(pattern1.test(name) || pattern2.test(name)){
                return true;
            }else{
                return false;
            }
        };

        $("#checkBtn").click(function (e) {

            var userId = $("#userId").val();
            console.log(userId);

            if(userId == ''  || userId == null){
                alert("아이디를 입력해 주세요");
                return false;
            }

            var userDTO = {
                userId : userId
            };

            $.ajax({
                type : 'post',
                url : '/user/checkId',
                data : JSON.stringify(userDTO),
                dataType:"json",
                contentType : 'application/json; charset=utf-8',
                success : function(data){
                    console.log("Data" + data);
                    if(data == 1){
                        alert("이미 있는 아이디 입니다");
                        idCheck = 0;
                        return false;
                    }else {
                        alert("사용 가능한 아이디 입니다");
                        idCheck = 1;
                        return true;
                    }
                }
            })
        })
    });
</script>

</html>
