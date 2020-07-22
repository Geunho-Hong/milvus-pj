<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src = "https://code.jquery.com/jquery-3.1.1.js"></script>
<script src="/js/discussion/modify.js"/>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@ include file="../sidebar.jsp"%>

<form action ="/discussion/board/update" method="post" id="modifyForm">
    <div class ="container"style="margin-left:22%">
        <table class="board_view">
            <colgroup>
                <col width="15%" >
                <col width="*" >
            </colgroup>
            <caption>게시글 수정</caption>
            <tbody>
            <tr>
                <th scope="row">번호</th>
                <td>${board.bno}</td>
                <input type="hidden" name ="bno" value = "${board.bno}"/>
                <input type="hidden" name ="userId" value = "${board.userId}"/>
            </tr>
            <tr>
                <th scope="row">제목</th>
                <td><input type ="text" id="title" name ="title" value ="${board.title}"/></td>
            </tr>
            <tr>
                <th scope="row">작성자</th>
                <td>${board.userId}</td>
            </tr>
            <tr>
                <th scope="row">내용</th>
                <td><textarea cols="100" rows="20" id="content" name="content" title="내용">${board.content}</textarea></td>
            </tr>
            </tbody>
        </table>

        <a href="javascript:history.back()" id="list" class="btn">목록으로</a>
        <button type ="button" id ="modifyBtn">수정하기</button>
    </div>
</form>

</body>
</html>
