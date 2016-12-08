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
room join
<div>
    <div>${account.nickName}</div>
    <image src=${account.profileUrl}/>
</div>

<div>room title: ${room.title}</div>

<form action="/rooms/${room.title}/join" method="post">
    <input type="submit"/>
</form>

</body>
</html>