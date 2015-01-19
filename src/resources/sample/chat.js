function chatOut(uP, mP) {
    var user = $('<span />').addClass("chat-user").html(uP + ": ");
    var message = $('<span />').addClass("chat-message").html(mP);
    var chatLine = $('<div />').addClass("chat-line").append(user).append(message);
    $("#chat-box").append(chatLine);
    $("#chat-box").scrollTop($("#chat-box")[0].scrollHeight);
}

$(function () {
    var host = "localhost";
    var port = "1234";
    var path = "chat";
    var sock = new WebSocket("ws://" + host + ":" + port + "/" + path);

    sock.onerror = function () {
        chatOut("System", "Connection to chat server failed.");
    };

    sock.onmessage = function (event) {
        chatOut("User", event.data);
    };

    $("#type-box").submit(function () {
        if (sock.readyState === 1) {
            sock.send($("#type-here").val());
        }
        else {
            chatOut("System", "Chat server not available.");
        }
        $("#type-here").val("");
        return false;
    });
});