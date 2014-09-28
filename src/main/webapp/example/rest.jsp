<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport"
          content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scalable=0"/>
    <title>Home automation</title>
 <script src="${pageContext.request.contextPath}/scripts/lib/jquery-1.10.2.min.js"></script>
 <script src="${pageContext.request.contextPath}/scripts/script.js"></script>
</head>

<body>
    <h2>REST</h2>
    <p><a href="/rest/myresource">String result</a></p>

    <script language="JavaScript">
     function test(){
      getRest("/rest/json", function(data){
       $("#blaat").append("Json: ").append(JSON.stringify(data)).append('<br/>');
       $.each(data, function(index, item){
        $("#blaat").append(' ' + item.name + ' ' + item.gender + ' ' + item.age).append("<br/>");
       });//each
      });//getRest(success callback)
     }
    </script>

    <div id="blaat"/>

    <a href="#" onclick="test();">Json result</a>

    <p>Visit <a href="http://jersey.java.net">Project Jersey website</a>
    for more information on Jersey!</p>
</body>
</html>