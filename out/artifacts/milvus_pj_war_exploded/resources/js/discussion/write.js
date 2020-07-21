$(function(){

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
});