<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="https://code.jquery.com/jquery-3.1.1.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<html>
<head>
    <title>Title</title>
</head>
<body>

<%@ include file="../sidebar.jsp" %>

<div class="container" style="margin-left:22%">
    토론을 나누는 공간에 오신것을 환영합니다.
    현재유저 : ${login.userId}

    <table style="border:1px solid #ccc">
        <colgroup>
            <col width ="10%"/>
            <col width="20%"/>
            <col width="*"/>
            <col width="15%"/>
            <col width="20%"/>
        </colgroup>
        <thead>
        <tr>
            <th scope="col">글번호</th>
            <th scope="col">작성자</th>
            <th scope="col">제목</th>
            <th scope="col">작성일</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list }" var="board">
            <tr>
                <td>${board.bno}
                    <c:if test = "${login.auth eq 1}">
                        <input type="checkbox" name="checkArr" class="checkArr" data = "${board.bno}"/>
                     </c:if>
                </td>
                <td>${board.userId }</td>
                <td>
                    <a href="/discussion/board/${board.bno}">
                        <c:out value="${board.title}"></c:out>
                    </a>
                </td>
                <td>${board.regdate }</td>
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
<script type ="text/javascript">

    $(document).ready(function () {

        $('.paginate_button a').on("click",function(e){
            e.preventDefault();

            //var targetPage = $(this).attr("href");

            var actionForm = $("#actionForm");

            e.preventDefault();
            actionForm.find('input[name=page]').val($(this).attr('href'));
            actionForm.submit();
        });

        $("#deleteBtn").click(function(e) {

            var result = confirm("체크 리스트를 삭제하시겠습니까?");

            if($("input[name='checkArr']").is(":checked") == false){
                alert("삭제할 게시글을 선택해 주세요");
                return false;
            }

            if(result){

                var checkArr = new Array();

                $("input[name='checkArr']:checked").each(function () {
                    checkArr.push($(this).attr("data"));
                });

                console.log(checkArr);

               $.ajax({
                    type: 'post',
                    url : "/discussion/board/checked/delete",
                    data: ({'checkArr' : checkArr}),
                    success : function(){
                        if(result == 1){
                            alert("삭제 성공");
                            location.href = "/discussion/list";
                        }else{
                            alert("삭제 실패");
                        }
                    }
                })
            }
        });
    });
</script>

</html>
