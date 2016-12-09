<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta title="viewport" content="user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, width=device-width"/>
    <title>Create Room</title>
    <script src="/lib/kakao.min.js"></script>
    <script src="/lib/jquery.min.js"></script>
    <style type="text/css">
        .top {
            height: 100px;
            background-color: #391d1d;
        }

        .top a {
            color: white;
            margin:125px 0;
        }

        a {
            font-size: 50px;
        }
    </style>
</head>
<body>
<div class="top">
    <a>마니또방 만들기</a>
</div>
<div>
    <image width="20%" src=${account.profileUrl}/>
    <a style="font-size: 50px">${account.nickName}</a>
</div>

<form action="/rooms" method="post" name="addRoom">
        <a style="font-size: 50px">방제목 : </a>
        <input style="font-size:50px" type="text" name="title"/>
        <input value="방 만들기" type="submit"/>
</form>

</div>
</body>
</html>