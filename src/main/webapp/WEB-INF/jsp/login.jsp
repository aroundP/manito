<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta title="viewport" content="user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, width=device-width"/>
    <title>Login Demo - Kakao JavaScript SDK</title>
    <script src="/lib/kakao.min.js"></script>
    <script src="/lib/jquery.min.js"></script>
</head>

<body>
<input class="redirectUrl" type="hidden" value="${param.redirectUrl}"/>
<a id="custom-login-btn" href="javascript:loginWithKakao()">
    로그인
    <img src="//mud-kage.kakao.com/14/dn/btqbjxsO6vP/KPiGpdnsubSq3a0PHEGUK1/o.jpg" width="300"/>
</a>

<script type='text/javascript'>
    Kakao.init('228e8a0260b7d7fab36ce4bc809491b7');
    function loginWithKakao() {
        // 로그인 창을 띄웁니다.
        Kakao.Auth.login({
            success: function(authObj) {
                $.ajax({
                    url: "/login",
                    type: "post",
                    contentType : "application/json; charset=UTF-8",
                    data: JSON.stringify(authObj),
                    success: function () {
                        location.replace($(".redirectUrl").val());
                    }
                });
            },
            fail: function(err) {
                alert(JSON.stringify(err));
            }
        });
    };
</script>
</body>
</html>