<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="https://code.jquery.com/jquery-3.1.1.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<script src="/js/user/adminPage.js"/>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@ include file="../sidebar.jsp" %>

<div class="container" style="margin-left:22%">
    운영자 : ${login.userId}

    <table class="table">
        <colgroup>
            <col width ="30%"/>
            <col width="30%"/>
            <col width="20%"/>
            <col width="20%"/>
        </colgroup>
        <thead>
        <tr>
            <th scope="col">유저 아이디</th>
            <th scope="col">유저 이름</th>
            <th scope="col">가입일</th>
            <th scope="col">비번</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list }" var="user">
            <tr>
                <td>
                    <c:if test = "${login.auth eq 1}">
                        <input type="checkbox" name="checkArr" class="checkArr" data = "${user.userId}"/>
                    </c:if>
                        ${user.userId }</td>
                <td>${user.name }</td>
                <td>${user.join_date}</td>
                <td>${user.pw}</td>
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

    <c:if test = "${login.auth eq 1}">
        <button type="button" id="deleteBtn">체크 삭제</button>
    </c:if>

    <form id="actionForm" action="/user/list" method="get">
        <input type="hidden" name="page" value="${pageMaker.cri.page }">
        <input type="hidden" name="perPageNum"
               value="${pageMaker.cri.perPageNum }">
    </form>
</div>

</body>
</html>
