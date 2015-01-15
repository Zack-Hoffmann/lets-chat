$(function () {
    var host = "localhost";
    var port = "1234";
    var path = "chat";
    var sock = new WebSocket("ws://" + host + ":" + port + "/" + path);
    sock.onmessage = function (event) {
        var box = $("#chat-box");
        box.append("<div>" + event.data + "</div>");
        box.scrollTop(box[0].scrollHeight);
    };

    $("#type-box").submit(function () {
        sock.send($("#type-here").val());
        $("#type-here").val("");
        return false;
    });
});