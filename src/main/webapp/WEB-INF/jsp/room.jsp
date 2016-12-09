<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
		<!--[if lte IE 8]><script src="../assets/js/html5shiv.js"></script><![endif]-->
		<link rel="stylesheet" href="../assets/css/main.css" />
		<!--[if lte IE 9]><link rel="stylesheet" href="assets/css/ie9.css" /><![endif]-->
		<!--[if lte IE 8]><link rel="stylesheet" href="assets/css/ie8.css" /><![endif]-->
		<noscript><link rel="stylesheet" href="assets/css/noscript.css" /></noscript>
		<script src="/lib/kakao.min.js"></script>
		<script src="/lib/jquery.min.js"></script>
	</head>
	<body class="is-loading">
	<input type="hidden" class="roomId" value="${room.id}"/>
	<input type="hidden" class="roomTitle" value="${room.title}"/>
		<!-- Wrapper -->
			<div id="wrapper">

				<!-- Main -->
					<section id="main">
						<h2>${room.title}</h2>
						<hr />
						<div>
							<ul>
								<c:forEach items="${room.relationList}" var="relation" varStatus="status">
									<li>
										<div>
											<img src=${relation.user.profileUrl}/>
											<a>${relation.user.nickName}</a>
										</div>
									</li>
								</c:forEach>
							</ul>
						</div>
						<hr />
						<div>
							<a id="kakao-link-btn" href="javascript:sendLink()">
								<div>초대하기</div>
								<img src="//dev.kakao.com/assets/img/about/logos/kakaolink/kakaolink_btn_medium.png"/>
							</a>
						</div>
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
				// 사용할 앱의 JavaScript 키를 설정해 주세요.
				Kakao.init('228e8a0260b7d7fab36ce4bc809491b7');

				function sendLink() {
					Kakao.Link.sendTalkLink({
						label: '마니또 초대!',
						image: {
							src: 'https://cloud.githubusercontent.com/assets/4353846/20915318/7e36cd48-bbc8-11e6-8687-4f16338df4cf.jpeg',
							width: 155,
							height: 136
						},
						webButton: {
							text: $(".roomId").val() + '방에서 초대합니다.',
							url: 'http://52.39.239.71:8080/rooms/' + $(".roomId").val()
						}
					});
				}
			</script>

	</body>
</html>