<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE HTML>
<!--
Identity by HTML5 UP
html5up.net | @ajlkn
Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
-->
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
		<h2>Join Manito Room</h2>
		<header>
			<span class="avatar"><img src=${account.profileUrl}/></span>
			<h1>${account.nickName}</h1>
			<%--<input>Input room name</p>--%>
		</header>
		<hr />
		<form action="/rooms/${room.title}/join" method="post">
			<div class="field">
				<a>${room.title} </a>
			</div>
			<ul class="actions">
				<li><input value="참가하기" type="submit"/></li>
			</ul>
		</form>
		<hr />
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

</body>
</html>