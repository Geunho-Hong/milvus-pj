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
<script type ="text/javascript">

    $(function(){

        var bno =  $('input[name="bno"]').val();
        var userId = $('input[name="userId"]').val();

        getAllReplies();

        $("#writeReply").click(function(){

            bno = $('input[name="bno"]').val();
            var content = $("#reply_content").val();

            console.log("replyContent" + content);
            console.log("userId : " + userId);
            console.log("bno " + bno);

            var replyData = {
                bno : bno,
                userId : userId,
                content : content
            };

            if(!content){
                alert("내용을 입력하세요");
                $('#reply_content').focus();
                return false;
            }

            var c = confirm('댓글을 등록하시겠습니까?');

            if(c){
                $.ajax({
                    type : 'post',
                    url :"/discussion/reply/register",
                    data: JSON.stringify(replyData),
                    contentType : 'application/json; charset=utf-8',
                    success: function(){
                        console.log("댓글 입력 성공");
                        $("#reply_content").val("");
                        getAllReplies();    // 글 작성후 댓글 리스트를 Refresh 한다.
                    }
                })
            }else{
                return false;
            }
        });

        function getAllReplies(){

            bno = $('input[name="bno"]').val();
            var url = "/discussion/reply/"+bno;

            $.getJSON(
                url,
                function(jsonData){
                    console.log(jsonData);
                    console.log(jsonData.bno);
                    var list = '';
                    $(jsonData).each(
                        // JSON 데이터를 사용하여 반복한다.
                        function(){
                            console.log("댓글 번호 : " + this.rno);
                            console.log("댓글 작성자 : " + this.userId);
                            console.log(userId);

                            list += '<div class="reply_item">'
                                + '<pre class ="pre">'
                                + '<input type="hidden" id="rno" value="' + this.rno + '" />'
                                + '<input type="hidden" id="userId" value="' + this.userId + '" />'
                                + '<div id ="thisUserId">'+this.userId+'</div>'
                                + '&nbsp;&nbsp;'
                                + '<textarea id="textContent">' + this.content + '</textarea>'
                                + '&nbsp;&nbsp;'
                            if(userId == this.userId){
                                list+=  '<button class="btn_delete" id="btn_delete type="button">삭제</button>'
                            }
                            list+='</pre>' + '</div>';
                        });
                    $('#getReply').html(list);
                }
            );
        };

        $("#getReply").on("click", '.reply_item .btn_delete',function(){
            var c = confirm("댓글을 삭제하시겠습니까?");
            var rno = $(this).prevAll("#rno").val();

            console.log("삭제 댓글: " + rno);
            if(c){
                $.ajax({
                    type : 'post',
                    url :"/discussion/delete/reply/" + rno,
                    data: JSON.stringify({'rno':rno}),
                    contentType : 'application/json;',
                    success: function(result){
                        console.log("Result " + result);
                        if(result == "Success"){
                            console.log("댓글 삭제 성공");
                            getAllReplies();
                        }
                    }
                })
            }else{
                return false;
            }
        });
    });

</script>
</html>
