<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src = "https://code.jquery.com/jquery-3.1.1.js"></script>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action ="/discussion/board/update" method="post" id="modifyForm">
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
            <td><textarea cols="100" rows="20" id="content" name="content" title="내용">
                ${board.content}
            </textarea></td>
        </tr>
        </tbody>
    </table>

    <a href="javascript:history.back()" id="list" class="btn">목록으로</a>
    <button type ="button" id ="modifyBtn">수정하기</button>
</form>

</body>
<script type="text/javascript">
    $(document).ready(function(){
        var modifyForm = $("#modifyForm");

        $("#modifyBtn").click(function (e) {

            var title = $("#title").val();
            var content = $("#content").val();

            console.log("title " + title);
            console.log("content " + content);

            if(title == '' || title == null){
                alert("제목을 입력해 주세요");
                return false;
            }
            if(content == '' || content == null){
                alert("내용을 입력해 주세요");
                return false;
            }
            modifyForm.submit();
            alert("글이 수정 되었습니다");
        })
    })

</script>
</html>
