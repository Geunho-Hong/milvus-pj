<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src = "https://code.jquery.com/jquery-3.1.1.js"></script>
<script src="/js/discussion/write.js"/>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<html>
<head>
    <title>글 작성</title>
</head>
<body>
    <%@ include file="../sidebar.jsp" %>

    <div class ="container"style="margin-left:22%">
        <form action ="/discussion/register" method ="post" id="writeForm" name="writeForm">
            <!--<input type = "hidden" name ="userId" value="${login.userId}"/>-- InterCeptor-->
            <input type = "hidden" name ="userId" value="<sec:authentication property="principal.username"/>"/>

            <table class="board_view">
                <colgroup>
                    <col width="15%" >
                    <col width="*" >
                </colgroup>
                <h2>게시글 작성</h2>
                <tbody>
                <tr>
                    <th scope="row">제목</th>
                    <td><input id="title" name="title" value="" class="tbox01"/></td>
                </tr>
                <tr>
                    <th scope="row">작성자</th>
                    <td>${board.userId}</td>
                </tr>
                <tr>
                    <th scope="row">내용</th>
                    <td><textarea cols="100" rows="20" name ="content" id="content" title="내용">
                        ${board.content}
                    </textarea></td>
                </tr>
                </tbody>
            </table>
        </form>

        <div class="btn_right mt15">
            <button type="button" class="btn black mr5" onclick="javascript:history.back();">목록으로</button>
            <c:if test = "${login ne null}">
                <button type="button" class="btn black" id="writeBtn">등록하기</button>
            </c:if>
            <button type="button" class="btn black" id="writeBtn">등록하기</button>
        </div>
    </div>
</body>
</html>
