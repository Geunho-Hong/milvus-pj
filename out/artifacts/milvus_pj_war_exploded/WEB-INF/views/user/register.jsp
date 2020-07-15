<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src = "https://code.jquery.com/jquery-3.1.1.js"></script>
<script type ="text/javascript">
       $(document).ready(function(){
           var userForm = $("#userForm");
           $("#submitBtn").click(function(e){
               if($("#userId").val() == "" || $("#userId").val() == null){
                   alert("please ID input");
                   return false;
               }
               userForm.submit();
               console.log("submitBtn Click");
           });
       });
</script>

<html>
<head>
    <title>회원 가입</title>

    <div>
        회원가입 페이지 입니다.
    </div>

    <form action ="/user/register" method = "post" id="userForm">
        <div>
            <div>
                아이디 입력 : <input type = "text" name = "userId" id ="user">
            </div>
            <div>
                비밀번호 입력 : <input type = "text" name = "pw">
            </div>
            <div>
                이름입력 : <input type = "text" name = "name">
            </div>
            <input type ="submit" value ="submit" id ="submitBtn">등록</input>
        </div>
    </form>
</head>
<body>

</body>
</html>
