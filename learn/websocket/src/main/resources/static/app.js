var stompClient = null;

function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
    if (connected) {
        $("#conversation").show();
    }
    else {
        $("#conversation").hide();
    }
    $("#greetings").html("");
}

function connect1() {
    var socket = new WebSocket('ws://localhost:8080/ws');
    var myid = $("#my").val();
    stompClient = Stomp.over(socket);
    stompClient.connect({name:'lixin'}, function (frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        stompClient.subscribe('/user/1/queue/getResponse', function (greeting) {
            showGreeting(greeting.body);
        });
    });
}

function connect2() {
    var socket = new WebSocket('ws://localhost:8080/ws');
    var myid = $("#my").val();
    stompClient = Stomp.over(socket);
    stompClient.connect({name:'ligen'}, function (frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        stompClient.subscribe('/user/queue/getResponse', function (greeting) {
            showGreeting(greeting.body);
        });
    });
}


function connect3() {
    var socket = new WebSocket('ws://10.106.8.125:8050/websocket/ws');
    var myid = $("#my").val();
    stompClient = Stomp.over(socket);
    stompClient.connect({name:'ligen'}, function (frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        stompClient.subscribe('/public_trade_info/get_kline/EOS_ETH', function (greeting) {
            showGreeting(greeting.body);
        });
    });
}

function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}

function sendName() {
    stompClient.send("/app/callback", {}, JSON.stringify({'message': $("#message").val(),'to':$("#to").val()}));
}

function showGreeting(message) {
    $("#greetings").append("<tr><td>" + message + "</td></tr>");
}

$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $( "#connect1" ).click(function() { connect1(); });
    $( "#connect2" ).click(function() { connect2(); });
    $( "#connect3" ).click(function() { connect3(); });
    $( "#disconnect" ).click(function() { disconnect(); });
    $( "#send" ).click(function() { sendName(); });
});

