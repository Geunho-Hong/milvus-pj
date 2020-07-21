<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="https://code.jquery.com/jquery-3.1.1.js"></script>
<script src="/js/discussion/read.js"/>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<html>
<head>
    <title>Title</title>
</head>
<body>

<%@ include file="../sidebar.jsp" %>

    <div class ="container"style="margin-left:22%">
        <table class="board_view">
            <colgroup>
                <col width="15%" >
                <col width="*" >
            </colgroup>
            <caption>게시글</caption>
            <tbody>
            <input type = "hidden" name ="bno" value="${board.bno}"/>
            <input type = "hidden" name ="userId" value="${login.userId}"/>
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
                <td><textarea cols="100" rows="20" id="CONTENTS" title="내용" readonly>
                    ${board.content}
                </textarea></td>
            </tr>
            </tbody>
        </table>
        <a href="javascript:history.back()" id="list" class="btn">목록으로</a>

       <c:if test = "${login.userId eq board.userId || login.auth eq 1}">
            <button type = "button" id ="deleteBtn"
                    onclick="location.href='/discussion/board/update/${board.bno}'">수정</button>
            <button type = "button" id ="deleteBtn"
                    onclick="location.href='/discussion/board/delete/${board.bno}'">삭제</button>
        </c:if>

        <table>
            <c:if test="${login eq null }">
                <tr>
                    <td>회원에게만 댓글 작성 권한이 있습니다.</td>
                </tr>
            </c:if>
            <c:if test="${login ne null }">
                <tr>
                    <td id="replyTitle">댓글 달기</td>
                </tr>
                <tr>
                    <td id="replyContent"><textarea id="reply_content"
                                                    class="form-control" name="reply_content" autocomplete="off"></textarea>

                        <button type="button" id="writeReply"
                                class="btn btn-default btn-sm reg_reply">등록</button>
                    </td>
                </tr>
            </c:if>
        </table>

        <div id ="getReply">


        </div>
    </div>

</body>
</html>
