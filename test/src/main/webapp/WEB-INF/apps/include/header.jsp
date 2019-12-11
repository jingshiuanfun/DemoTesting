<%@include file="/WEB-INF/apps/init.jsp" %>

<html lang="en">
<head>

	<title>Capture</title>

	<c:url value="/css/style.css" var="mainStyleCss"/>
	<link href="${mainStyleCss}" rel="stylesheet" />

	<link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/bootstrap-datepicker.css">
    <link rel="stylesheet" href="css/jquery.fancybox.min.css">
    <link rel="stylesheet" href="css/owl.carousel.min.css">
    <link rel="stylesheet" href="css/owl.theme.default.min.css">
    <link rel="stylesheet" href="fonts/flaticon/font/flaticon.css">
    <link rel="stylesheet" href="css/aos.css">
	
</head>
<body>

<header class="site-navbar site-navbar-target" role="banner">

	<div class="container">
		<div class="row align-items-center position-relative">

			<div class="col-3 ">
				<div class="site-logo">
					<a href="<%=RenderUrlConstant.INDEX %>" class="font-weight-bold">Capture</a>
				</div>
			</div>

			<div class="col-9  text-right">

				<nav class="site-navigation text-right ml-auto d-none d-lg-block" role="navigation">
					<ul class="site-menu main-menu js-clone-nav ml-auto ">
						<li class="active">
							<a href="<%=RenderUrlConstant.INDEX %>" class="nav-link">Home</a>
						</li>
					</ul>
				</nav>
				
			</div>

		</div>
	</div>

</header>