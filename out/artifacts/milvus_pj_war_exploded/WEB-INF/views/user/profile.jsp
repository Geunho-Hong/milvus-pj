<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@ include file="../sidebar.jsp"%>

<div class ="container" id ="container">

    <div class ="row" id ="title">
        프로필 수정하기
    </div>

    <form role ="form" method ="post" enctype="multipart/form-data">
    <div class="inputArea">
        <label for="gdsImg">이미지</label>
        <input type="file" id="gdsImg" name="file" />
        <div class="select_img"><img src="" /></div>

        <script>
            $("#gdsImg").change(function(){
                if(this.files && this.files[0]) {
                    var reader = new FileReader;
                    reader.onload = function(data) {
                        $(".select_img img").attr("src", data.target.result).width(500);
                    }
                    reader.readAsDataURL(this.files[0]);
                }
            });
        </script>

        <%=request.getRealPath("/") %>
        <!-- 현재 프로젝트의 실제 경로, 이 경로를 기준으로 파일을 저장하고 불러온다 -->

        <%-- <div>
            contextPath
            ${pageContext.request.contextPath}
        </div>--%>

        </div>
    </form>
</body>
<script type ="text/javascript">

</script>
</html>
