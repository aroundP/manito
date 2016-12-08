<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta title="viewport" content="user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, width=device-width"/>
    <title>Join Room</title>
    <script src="//developers.kakao.com/sdk/js/kakao.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
</head>
<body>


<div>
    <a style="font-size: 50px">방제목:${room.title}</a>
</div>
<br/>
<br/>
<br/>
<div>
    <a style="font-size: 30px">참가한사람</a>
    <c:forEach items="${room.relationList}" var="relation" varStatus="status">
        <div><a style="font-size: 20px">- ${relation.user.nickName}</a></div>
    </c:forEach>
</div>

<br/>
<br/>
<br/>


<div>
    <a style="font-size: 20px" id="kakao-link-btn" href="javascript:sendLink()">
        초대하기
        <img src="//dev.kakao.com/assets/img/about/logos/kakaolink/kakaolink_btn_medium.png"/>
    </a>
</div>
<input type="hidden" class="roomId" value="${room.id}"/>

<script type='text/javascript'>
    // 사용할 앱의 JavaScript 키를 설정해 주세요.
    Kakao.init('228e8a0260b7d7fab36ce4bc809491b7');

    function sendLink() {
        Kakao.Link.sendTalkLink({
            label: 'test',
            image: {
                src: 'https://cloud.githubusercontent.com/assets/4353846/20915318/7e36cd48-bbc8-11e6-8687-4f16338df4cf.jpeg',
                width: 155,
                height: 136
            },
            webButton: {
                text: 'testtest',
                url: '10.64.83.51:8080/rooms/' + $(".roomId").val()
            }
        });
    }
</script>
</body>
</html>