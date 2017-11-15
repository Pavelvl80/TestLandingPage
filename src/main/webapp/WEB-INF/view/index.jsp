<%--
  Created by IntelliJ IDEA.
  User: Edvard Piri
  Date: 09.11.2017
  Time: 13:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
WELCOME
<form name="inputform" action="somewhere" method="post">
    <input type="hidden" value="person" name="user">
    <input type="hidden" value="password" name="pwd">
    <input type="hidden" value="place" name="organization">
    <input type="hidden" value="key" name="requiredkey">
</form>

<script>
    var data = new FormData();
    data.append('user', 'person');
    data.append('pwd', 'password');
    data.append('organization', 'place');
    data.append('requiredkey', 'key');

    var xhr = new XMLHttpRequest();
    xhr.open('POST', 'somewhere', true);
    xhr.onload = function () {
        // do something to response
        console.log(this.responseText);
    };
    xhr.send(data);
</script>
</body>
</html>
