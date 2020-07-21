$(function(){

    var userForm = $("#userForm");

    $("#submitBtn").click(function (e) {

        var pw = $("#pw").val();
        var pwCheck = $("#pwCheck").val();

        if($("#currentPw").val() == "" || $("#currentPw").val() == null){
            alert("현재 비밀번호를 입력해 주세요");
            return false;
        }

        if($("#pw").val() == "" || $("#pw").val() == null){
            alert("비밀번호를 입력해 주세요");
            return false;
        }
        if($("#pwCheck").val() == "" || $("#pwCheck").val() == null){
            alert("비밀번호 확인을 입력해 주세요");
            return false;
        }
        if(pw.length <4 || pw.length >12){
            alert("비밀번호는 4자리 이상 12자리 이하를 입력해주세요.")
            $("#pw").focus();
            return false;
        }
        if(pwCheck.length <4 || pwCheck.length >12){
            alert("비밀번호 확인은 4자리 이상 12자리 이하를 입력해주세요.")
            $("#pw").focus();
            return false;
        }
        if(pw != pwCheck){
            alert("비밀번호와 비밀번호 확인이 같은지 확인해주세요");
            return false;
        }
        userForm.submit();
    })

})