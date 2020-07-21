$(document).ready(function(){

    var loginForm = $("#loginForm");

    $("#find-pwBtn").click(function(e){
        alert("find -pw btn click");
    });

    $("#login-btn").click(function(e){

        var userId = $("#userId").val();
        var pw = $("#pw").val();

        console.log("userId" + userId);
        console.log("pw" + pw);

        if($("#userId").val() == "" || $("#userId").val() == null){
            alert("아이디를 입력해 주세요");
            return false;
        }
        if($("#pw").val() == "" || $("#pw").val() == null){
            alert("비밀번호를 입력해 주세요");
            return false;
        }
        if(checkId(userId)){
            alert("아이디는 한글과 공백을 허가하지 않습니다");
            $("#userId").focus();
            return false;
        }
        if(userId.length <5 || userId.length >12){
            alert("아이디는 6자리 이상 12자리 이하를 입력해주세요 ");
            $("#userId").focus();
            return false;
        }
        if(pw.length <4 || pw.length >12){
            alert("비밀번호는 4자리 이상 12자리 이하를 입력해주세요.")
            $("#pw").focus();
            return false;
        }

        loginForm.submit();
        console.log("Login Success");
    });

    function checkId(userId) {
        var pattern1 = /[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/; // 한글 여부
        var pattern2 = /\s/; // 공백 여부

        if(pattern1.test(userId) || pattern2.test(userId)){
            return true;
        }else{
            return false;
        }
    };

});