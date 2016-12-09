<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>Identity by HTML5 UP</title>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <!--[if lte IE 8]><script src="assets/js/html5shiv.js"></script><![endif]-->
    <link rel="stylesheet" href="assets/css/main.css" />
    <!--[if lte IE 9]><link rel="stylesheet" href="assets/css/ie9.css" /><![endif]-->
    <!--[if lte IE 8]><link rel="stylesheet" href="assets/css/ie8.css" /><![endif]-->
    <noscript><link rel="stylesheet" href="assets/css/noscript.css" /></noscript>
    <script src="/lib/kakao.min.js"></script>
    <script src="/lib/jquery.min.js"></script>
</head>
<body class="is-loading">

<!-- Wrapper -->
<div id="wrapper">

    <!-- Main -->
    <section id="main">

        <input class="redirectUrl" type="hidden" value="${param.redirectUrl}"/>
        <a id="custom-login-btn" href="javascript:loginWithKakao()">
            <img src="//mud-kage.kakao.com/14/dn/btqbjxsO6vP/KPiGpdnsubSq3a0PHEGUK1/o.jpg" width="100%"/>
        </a>
    </section>

    <!-- Footer -->
    <footer id="footer">
        <ul class="copyright">
            <li>&copy; Jane Doe</li><li>Design: <a href="http://html5up.net">HTML5 UP</a></li>
        </ul>
    </footer>
</div>

<!-- Scripts -->
<!--[if lte IE 8]><script src="assets/js/respond.min.js"></script><![endif]-->
<script>
    if ('addEventListener' in window) {
        window.addEventListener('load', function() { document.body.className = document.body.className.replace(/\bis-loading\b/, ''); });
        document.body.className += (navigator.userAgent.match(/(MSIE|rv:11\.0)/) ? ' is-ie' : '');
    }
</script>

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