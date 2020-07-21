<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="https://code.jquery.com/jquery-3.1.1.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link href="/css/modify.css" rel="stylesheet">
<html>
<head>
    <title>Title</title>
</head>
<script type="text/javascript">
    var message = "${msg}";
    if (message != "") {
        alert(message);
    }
</script>

<body>
    <%@ include file="../sidebar.jsp" %>

    <div class="container" id="container">

        <div class="row" id="title">
            비밀번호 수정
        </div>

        <div>
            <form action="/user/changePw" method="post" id="userForm">
                <input type="hidden" value="${login.userId}" name="userId"/>
                <div id="registerForm">
                    <div>
                        <input type="password" name="currentPw" id="currentPw" placeholder="현재 비밀번호">
                    </div>
                    <div>
                        <input type="password" name="pw" id="pw" placeholder="패스워드">
                    </div>
                    <div>
                        <input type="password" name="name" id="pwCheck" placeholder="패스워드 확인">
                    </div>
                    <button type="button" value="비밀번호 수정" id="submitBtn">
                        비밀번호 수정
                    </button>
                </div>
            </form>
        </div>
</body>
<script src="/js/user/modify.js"></script>
</html>
