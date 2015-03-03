<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
 <meta charset="utf-8">
 <meta name="viewport"
       content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scalable=0"/>
 <title>Foosball</title>
 <script src="${pageContext.request.contextPath}/scripts/lib/jquery-1.10.2.min.js"></script>
 <script src="${pageContext.request.contextPath}/scripts/script.js"></script>


<script language="JavaScript">
var websocket = null;

function connect(){
 websocket = new WebSocket("ws://"+ location.host+"/foosball/socket");
 console.log("connected" + websocket);
 websocket.onmessage = function(evt) { onMessage(evt) };
 websocket.onerror = function(evt) { onError(evt) };
}

 function sendText(json) {
  websocket.send(json);
 }

 function sendBinary(bytes) {
     websocket.send(bytes);
 }

 function onMessage(evt) {
     console.log("received: " + evt.data);
  $("#blaat").append(evt.data).append("<br/>");
 }

 function onError(evt) {
  console.log("Error: ???" );
  console.log("Error: " + evt.data);
 }

function test() {
//  var json = JSON.stringify({
//          "shape": "test"
//          "color": color.value,
//          "coords": {
//              "x": currentPos.x,
//              "y": currentPos.y
//          }
//      });
//  sendText(json);
  sendText($('#test').val());
}

 $(document).ready(function(){
  connect();
 });

</script>
</head>

<body>
<input type="text" id="test">
<input type="submit" value="Sent" onclick="test();"/>
<div id="blaat"><p>Output:</p></div>
</body>
</html>