
$(document).ready(function(){
    if(sessionStorage.getItem("isLogin")!="true"){
        sessionStorage.setItem("isLogin","false")
    }
    $(".release_button").click(function(){
        if(sessionStorage.getItem("isLogin")=="true"){
            var getTitle = $("#title_area").val();
            var getContent = $("#reply_textarea").val();
            var getType = $("#gameType").val();
            var sendData = {
                userName: sessionStorage.getItem("userId"),
                gameType: getType,
                title: getTitle,
                content: getContent,
                comment: 'let me out',
            }
            $.ajax({
                url:'http://localhost:8080/save/post/savePost',
                data: JSON.stringify(sendData),
                type: 'POST',
                dataType: "json",
                contentType: 'application/json;charset=UTF-8',
                crossDomain: true,
                success : function(data){
                    alert("success");
                },
                fail : function(){
                    alert("fail");
                },
                error : function(){
                    alert("error"+getType+getTitle+getContent+sessionStorage.getItem("userName"));
                }
            });
        }else{
            alert("please login first");
        }

    });
})
