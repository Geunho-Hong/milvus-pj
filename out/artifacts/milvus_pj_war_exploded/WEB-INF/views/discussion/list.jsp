<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="https://code.jquery.com/jquery-3.1.1.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<script src="/js/discussion/list.js"/>
<head>
    <title>Title</title>
</head>
<html>
<body>

<%@ include file="../sidebar.jsp" %>

<div class="container" style="margin-left:22%">

    <table class="table">
        <colgroup>
            <col width=10%;>
            <col width=20%;>
            <col width=40%;>
            <col width=20%;>
            <col width=10%;>
        </colgroup>
        <thead>
        <tr id="title">
            <td>번호</td>
            <td>작성자</td>
            <td>제목</td>
            <td>작성일</td>
            <td>조회수</td>
        </tr>
        </thead>

        <tbody>
        <c:forEach items="${list}" var="board">
            <tr>
                <td>
                    <c:if test = "${login.auth eq 1}">
                        <input type="checkbox" name="checkArr" class="checkArr" data = "${board.bno}"/>
                    </c:if>
                    <c:out value="${board.bno }"></c:out></td>
                <td>
                    <c:out value="${board.userId }"></c:out></td>
                </td>
                <td><a href="/discussion/board/${board.bno}">
                     <c:out value="${board.title}"></c:out>
                    </a>
                </td>
                <td><c:out value="${board.regdate }"></c:out></td>
                <td><c:out value="${board.hit }"></c:out></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <div class="text-center" id="pageDiv">
        <ul class="pagination">
            <c:if test="${pageMaker.prev }">
                <li class="paginate_button previous"><a id="prevBtn"
                                                        href="${pageMaker.startPage-1 }">◀</a></li>
            </c:if>
            <c:forEach var="num" begin="${pageMaker.startPage}"
                       end="${pageMaker.endPage}">
                <li
                        class="paginate_button ${pageMaker.cri.page == num ? 'active' : '' }">
                    <a id="pageNum" href="${num }">${num }</a>
                </li>
            </c:forEach>
            <c:if test="${pageMaker.next}">
                <li class="paginate_button next"><a id="nextBtn"
                                                    href="${pageMaker.endPage+1 }">▶</a></li>
            </c:if>
        </ul>
    </div>

    <c:if test="${login ne null}">
        <button type="button" onclick="location.href='/discussion/register'">글 작성</button>
    </c:if>

    <c:if test = "${login.auth eq 1}">
        <button type="button" id="deleteBtn">체크 삭제</button>
    </c:if>

    <form id="actionForm" action="/discussion/list" method="get">
        <input type="hidden" name="page" value="${pageMaker.cri.page }">
        <input type="hidden" name="perPageNum"
               value="${pageMaker.cri.perPageNum }">
    </form>
</div>
</body>
</html>
