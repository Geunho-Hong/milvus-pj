$(function () {

    $('.paginate_button a').on("click",function(e){
        e.preventDefault();

        var actionForm = $("#actionForm");

        e.preventDefault();
        actionForm.find('input[name=page]').val($(this).attr('href'));
        actionForm.submit();
    });

    $("#deleteBtn").click(function(e) {

        if($("input[name='checkArr']").is(":checked") == false){
            alert("삭제할 유저를 선택해 주세요");
            return false;
        }

        var result = confirm("체크 리스트를 삭제하시겠습니까?");

        if(result){

            var checkArr = new Array();

            $("input[name='checkArr']:checked").each(function () {
                checkArr.push($(this).attr("data"));
            });

            console.log(checkArr);

            $.ajax({
                type: 'post',
                url : "/user/checked/delete",
                data: ({'checkArr' : checkArr}),
                success : function(){
                    if(result == 1){
                        alert("삭제 성공");
                        location.href = "/user/list";
                    }else{
                        alert("삭제 실패");
                    }
                }
            })
        }
    })
})
