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