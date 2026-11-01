
var websocket;

function connect() {

    var username = document.getElementById("username").value;

    websocket = new WebSocket(
        "ws://" + document.location.host +
        document.location.pathname +
        "chat/" + username
    );

    websocket.onmessage = function(event) {

        var message = JSON.parse(event.data);

        document.getElementById("log").value +=
            message.from + ": " + message.content + "\n";
    };
}

function sendMessage() {

    var content = document.getElementById("msg").value;

    var message = {
        content: content
    };

    websocket.send(JSON.stringify(message));

    document.getElementById("msg").value = "";
}
