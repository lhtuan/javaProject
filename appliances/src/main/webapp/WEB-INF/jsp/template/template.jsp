<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">

<title><tiles:insertAttribute name="title" /></title>
<meta name="description" content="">

<meta name="viewport" content="width=device-width">
<link rel="stylesheet"
	href="<c:url value='/resources/css/include.css'/>">
<script
	src="<c:url value='/resources/js/vendor/modernizr-2.6.1.min.js'/>"></script>
<script src="<c:url value='/resources/js/ajax.js'/>"></script>
<script src="<c:url value='/resources/js/jquery-1.9.1.js'/>"></script>
<script src="<c:url value='/resources/js/bootstrap.js'/>"></script>
<script src="<c:url value='/resources/js/validate.js'/>"></script>
<script
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDOds6eBD0HOZns3VUDJrx-O8I-udRQUso&sensor=true">
	
</script>
<script>
	function initialize() {
		var node = document.getElementById("map-canvas");
		if (node != null) {
			var myLatlng = new google.maps.LatLng(10.763244, 106.682218);
			var mapOptions = {
				center : myLatlng,
				zoom : 15
			};

			var map = new google.maps.Map(node, mapOptions);
			var marker = new google.maps.Marker({
				position : myLatlng,
				map : map,
				title : "Đại học khoa học tự nhiên!"
			});
		}
	}
	google.maps.event.addDomListener(window, 'load', initialize);
</script>
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


	<script src="<c:url value='/resources/js/plugins.js'/>"></script>
	<script src="<c:url value='/resources/js/main.js'/>"></script>
	<script src="<c:url value='/resources/js/jquery.confirm.js'/>"></script>
	<script src="<c:url value='/resources/js/jquery.toastmessage.js'/>"></script>
</body>
</html>