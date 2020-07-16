<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <table class="board_view">
        <colgroup>
            <col width="15%" >
            <col width="*" >
        </colgroup>
        <caption>게시글</caption>
        <tbody>
        <input type = "hidden" name ="bno" value="${board.bno}"/>
        <tr>
            <th scope="row">번호</th>
            <td>${board.bno}</td>
        </tr>
        <tr>
            <th scope="row">제목</th>
            <td>${board.title}</td>
        </tr>
        <tr>
            <th scope="row">작성자</th>
            <td>${board.userId}</td>
        </tr>
        <tr>
            <th scope="row">내용</th>
            <td><textarea cols="100" rows="20" id="CONTENTS" name="content" title="내용">
                ${board.content}
            </textarea></td>
        </tr>
        </tbody>
    </table>

    <a href="javascript:history.back()" id="list" class="btn">목록으로</a>

    <c:if test = "${login.userId eq board.userId}">
        <button type = "button" id ="deleteBtn"
                onclick="location.href='/discussion/board/update/${board.bno}'">수정</button>
        <button type = "button" id ="deleteBtn"
                onclick="location.href='/discussion/board/delete/${board.bno}'">삭제</button>
    </c:if>

</body>
</html>
