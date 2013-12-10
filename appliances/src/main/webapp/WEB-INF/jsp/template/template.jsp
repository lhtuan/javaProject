<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">

<title>Men Style Shop</title>
<meta name="description" content="">

<meta name="viewport" content="width=device-width">

<link rel="stylesheet"
	href="<c:url value='/resources/css/normalize.min.css'/>">
<link rel="stylesheet" href="<c:url value='/resources/css/main.css'/>">
<link rel="stylesheet"
	href="<c:url value='/resources/css/media-queries.css'/>">
<link rel="stylesheet"
	href="<c:url value='/resources/css/bootstrap.css'/>">
<link rel="stylesheet" href="<c:url value='/resources/css/style.css'/>">
<link rel="stylesheet" href="<c:url value='/resources/css/jquery.confirm.css'/>">
<script
	src="<c:url value='/resources/js/vendor/modernizr-2.6.1.min.js'/>"></script>
<script src="<c:url value='/resources/js/ajax.js'/>"></script>
<script src="<c:url value='/resources/js/jquery-1.9.1.js'/>"></script>
<script src="<c:url value='/resources/js/bootstrap.js'/>"></script>
</head>
<body>
	<div class="top-bar">
		<tiles:insertAttribute name="topbar" />
	</div>
	<header class="container">
		<tiles:insertAttribute name="header" />
	</header>
	<hr>
	<tiles:insertAttribute name="content" />

	<footer>
		<tiles:insertAttribute name="footer" />
	</footer>
	<div id="dialog-confirm" title="Bạn có chắc muốn xóa?">
		<p>
			<span class="ui-icon ui-icon-alert"
				style="float: left; margin: 0 7px 20px 0;"></span>Sản phẩm sẽ bị xóa khỏi giỏ hàng
		</p>
	</div>
	<!-- 	<script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
	<script>
		window.jQuery
				|| document
						.write("src=''<c:url value='/resources/js/vendor/jquery-1.8.2.min.js'/>'><\/script>")
	</script> -->
	<script src="<c:url value='/resources/js/plugins.js'/>"></script>
	<script src="<c:url value='/resources/js/main.js'/>"></script>
	<script src="<c:url value='/resources/js/jquery.confirm.js'/>"></script>
</body>
</html>