<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src = "https://code.jquery.com/jquery-3.1.1.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<html>
<head>
    <title>글 작성</title>
</head>
<body>

<div id="wrap">
    <div id="container">
        <div class="inner">
            <h2>게시글 작성</h2>
            <form action ="/discussion/register" method ="post" id="writeForm" name="writeForm">
                <table width="100%" class="table02">
                    <colgroup>
                        <col width="20%">
                        <col width="*">
                    </colgroup>
                    <tbody id="tbody">
                    <tr>
                        <th>제목<span class="t_red">*</span></th>
                        <td><input id="title" name="title" value="" class="tbox01"/></td>
                    </tr>
                    <tr>
                        <th>작성자<span class="t_red">*</span></th>
                        <td><div>안녕하세요 ${login.userId} 님 환영합니다 !</div></td>
                        <td><input id="userId" name="userId" value="${login.userId}" class="tbox01"/></td>
                    </tr>
                    <tr>
                        <th>내용<span class="t_red">*</span></th>
                        <td><textarea id="content" name="content" cols="10" rows="5" class="textarea01"></textarea></td>
                    </tr>
                    </tbody>
                </table>
            </form>
            <div class="btn_right mt15">
                <button type="button" class="btn black mr5" onclick="javascript:history.back();">목록으로</button>
                <button type="button" class="btn black" id="writeBtn">등록하기</button>
            </div>
        </div>
    </div>
</div>
    <div>
        현재 유저 :  ${login.userId}
    </div>

</body>

<script type ="text/javascript">

    $(document).ready(function(){
        var writeForm = $("#writeForm");

        $("#writeBtn").click(function (e) {

            var userId = $("#userId").val();
            var title = $("#title").val();
            var content = $("#content").val();

            if(title == '' || title == null){
                alert("제목을 입력해 주세요");
                return false;
            }
            if(content == '' || content == null){
                alert("내용을 입력해 주세요");
                return false;
            }

            console.log(userId);
            console.log(title);
            console.log(content);

            writeForm.submit();
        });
    })
</script>
</html>
