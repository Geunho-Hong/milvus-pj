<%--
  Created by IntelliJ IDEA.
  User: milvus_omnilab_2
  Date: 2020-07-14
  Time: 오후 2:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>회원 가입</title>

    <div>
        회원가입 페이지 입니다.
    </div>

    <form action ="/user/register" method = "post">
        <div>
            <div>
                아이디 입력 : <input type = "text" name = "userId">
            </div>
            <div>
                비밀번호 입력 : <input type = "text" name = "pw">
            </div>
            <div>
                이름입력 : <input type = "text" name = "name">
            </div>
            <input type ="submit" value ="submit" name ="submit">등록</input>
        </div>
    </form>
</head>
<body>

</body>
</html>
