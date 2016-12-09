<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta title="viewport" content="user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, width=device-width"/>
    <title>Create Room</title>
</head>
<body>

<div>
    <image width="20%" src=${account.profileUrl}/>
    <a style="font-size: 50px">${account.nickName}</a>
</div>

<div>
    <a style="font-size: 50px">방제목 : ${room.title}</a>
</div>

<form action="/rooms/${room.title}/join" method="post">
    <input style="font-size:50px" value="참가하기" type="submit"/>
</form>

</body>
</html>