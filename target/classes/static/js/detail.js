
$(document).ready(function(){
    if(sessionStorage.getItem("isLogin")!="true"){
        sessionStorage.setItem("isLogin","false");
    }
    sessionStorage.setItem("score","1000");
    $(".empty").text(sessionStorage.getItem("isLogin"));
    $(".team_a_button").click(function(){
        $(".item1").text($(this).find("i").text());
        $(".item2").text($(this).find("b").text());
        $(".window_head span").text($(this).parent().prev().find(".title_name").text());
        if($(".none_gameResult").text()=="away:home"){
            $(".predict_window").show();
        }else {
            alert("the prediction is over");
        }
    });
    $(".team_b_button").click(function(){
        $(".item1").text($(this).find("i").text());
        $(".item2").text($(this).find("b").text());
        $(".window_head span").text($(this).parent().prev().find(".title_name").text());
        if($(".none_gameResult").text()=="away:home"){
            $(".predict_window").show();
        }else {
            alert("the prediction is over");
        }
    });
    $(".window_button_1").click(function(){
        $(".predict_window").hide();
    });
    $("#predict_number").bind('input propertychange',function(){
        var prize = $(this).val()*$(".item2").text();
        $(".item3_win").text("you can win : "+prize);
    });
    $(".window_button_2").click(function(){
        if(sessionStorage.getItem("isLogin")=="true"){
            var getGameId = $('.none_gameid').text();
            var GameId = parseFloat(getGameId);
            var paidScore = $('#predict_number').val();
            paidScore = parseFloat(paidScore);
            var sendData = {
                paidScore: paidScore,
                userName: sessionStorage.getItem("userName"),
                userId: parseFloat(sessionStorage.getItem("userId")),
                gameId: GameId,
                comment: "200",
                victoryOrDefeat: "VICTORY",
            }
            if(parseInt(sessionStorage.getItem("score"))>=paidScore){
                $.ajax({
                    url:'http://localhost:8080/game/gameSession/saveUserOperation',
                    data: JSON.stringify(sendData),
                    type: 'POST',
                    dataType: "json",
                    contentType: 'application/json;charset=UTF-8',
                    crossDomain: true,
                    success : function(data){
                        alert("success");
                        console.log('success info =>',data)
                    },
                    fail : function(){
                        alert("fail");
                    },
                    error : function(){
                        alert("error");
                    }
                });
            }else{
                alert("Your score are not enough");
            }
        }else{
            alert("please login first");
        }

    })
});