<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>
<div class="main-slideshow hidden-phone">
		<div class="container">
	<div class="row">
		<div class="span12">

			<ul class="rr slider" id="main-slider">
				<li class="slide-1">
					<div class="slide">
						<figure>
							<img
								src="<c:url value='/resources/img/ph/ph-home-banner-1.png'/>"
								alt="" />
						</figure>
						<div class="content-wrapper">
							<div class="content">
								<h1>SHOES FOR MEN 2012</h1>
								<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
									Pellentesque at nunc a magna tincidunt placerat. In hac
									habitasse platea dictumst. Donec in tellus libero. Lorem ipsum
									dolor sit amet, consectetur adipis.</p>
								<a href="3-product-grid.html" class="btn"><span
									class="gradient">Show now</span></a>
							</div>
						</div>
					</div>
				</li>
				<li class="slide-2 current">
					<div class="slide">
						<figure>
							<img
								src="<c:url value='/resources/img/ph/ph-home-banner-2.png'/>"
								alt="" />
						</figure>
						<div class="content-wrapper">
							<div class="content">
								<h1>back to office men style</h1>
								<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
									Pellentesque at nunc a magna tincidunt placerat. In hac
									habitasse platea dictumst. Donec in tellus libero. Lorem ipsum
									dolor sit amet, consectetur adipis.</p>
								<a href="3-product-grid.html" class="btn"><span
									class="gradient">Show now</span></a>
							</div>
						</div>
					</div>
				</li>
				<li class="slide-3">
					<div class="slide">
						<figure>
							<img
								src="<c:url value='/resources/img/ph/ph-home-banner-1.png'/>"
								alt="" />
						</figure>
						<div class="content-wrapper">
							<div class="content">
								<h1>SHOES FOR MEN 2012</h1>
								<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
									Pellentesque at nunc a magna tincidunt placerat. In hac
									habitasse platea dictumst. Donec in tellus libero. Lorem ipsum
									dolor sit amet, consectetur adipis.</p>
								<a href="3-product-grid.html" class="btn"><span
									class="gradient">Show now</span></a>
							</div>
						</div>
					</div>
				</li>
				<li class="slide-4">
					<div class="slide">
						<figure>
							<img
								src="<c:url value='/resources/img/ph/ph-home-banner-2.png'/>"
								alt="" />
						</figure>
						<div class="content-wrapper">
							<div class="content">
								<h1>back to office men style</h1>
								<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
									Pellentesque at nunc a magna tincidunt placerat. In hac
									habitasse platea dictumst. Donec in tellus libero. Lorem ipsum
									dolor sit amet, consectetur adipis.</p>
								<a href="3-product-grid.html" class="btn"><span
									class="gradient">Show now</span></a>
							</div>
						</div>
					</div>
				</li>
			</ul>

		</div>
	</div>
</div>

<div class="slideshow-bottom">
	<div class="menu-gradient gradient">Gradient</div>

	<div class="menu-wrapper">
		<div class="container">
			<div class="row-fluid">
				<div class="span12">

					<ul class="rr slider-menu" id="main-slider-menu">
						<li class="span3 alpha25">
							<div class="triangle ir">Triangle</div>
							<div class="button" id="open-slide-1">
								<span class="splitter">Splitter</span> Fashion Collection 2012
							</div>
						</li>
						<li class="span3 alpha25 current">
							<div class="triangle ir">Triangle</div>
							<div class="button" id="open-slide-2">
								<span class="splitter">Splitter</span> Top Sellers
							</div>
						</li>
						<li class="span3 alpha25">
							<div class="triangle ir">Triangle</div>
							<div class="button" id="open-slide-3">
								<span class="splitter">Splitter</span> New Trend 2013
							</div>
						</li>
						<li class="span3 alpha25">
							<div class="triangle ir">Triangle</div>
							<div class="button" id="open-slide-4">
								<span class="splitter">Splitter</span> Hot of Today <span
									class="splitter secondary">Splitter</span>
							</div>
						</li>
					</ul>

				</div>
			</div>
		</div>
	</div>
</div>

	</div>
<div role="main" class="homepage container">
		<div class="row">
	<div class="span12 main-heading">
		<div class="heading-line"></div>
		<div class="heading-wrapper">
			<h1>Popular products</h1>
		</div>
	</div>
</div>
<ul class="row-fluid clearfix rr popular-products grid-display">
	<li class="span3 alpha25 desat">
		<div class="prod-wrapper">
			<span class="badge corner-badge hot ir hidden">Hot</span> <span
				class="badge price-badge"> <span class="value"> <span>$</span>
					<span>150</span>
			</span>
			</span> <a href="5-product-details.html"> <img
				src="<c:url value='/resources/img/ph/ph-home-big-2.png'/>" class="desat-ie" alt="" />
			</a> <span class="info gradient"> <span class="title">Men
					glass mode 2012</span> <span class="add-to-cart clearfix"> <span
					class="icon ir">Cart</span> <a href="7-cart.html" class="text">Add
						To Cart</a>
			</span>
			</span>
		</div>
	</li>
	<li class="span3 alpha25 desat">
		<div class="prod-wrapper">
			<span class="badge corner-badge hot ir">Hot</span> <span
				class="badge price-badge"> <span class="value"> <span>$</span>
					<span>150</span>
			</span>
			</span> <a href="5-product-details.html"> <img
				src="<c:url value='/resources/img/ph/ph-home-big-1.png'/>" class="desat-ie" alt="" />
			</a> <span class="info gradient"> <span class="title">Men
					glass mode 2012</span> <span class="add-to-cart clearfix"> <span
					class="icon ir">Cart</span> <a href="7-cart.html" class="text">Add
						To Cart</a>
			</span>
			</span>
		</div>
	</li>
	<li class="span3 alpha25 desat">
		<div class="prod-wrapper">
			<span class="badge corner-badge hot ir hidden">Hot</span> <span
				class="badge price-badge"> <span class="value"> <span>$</span>
					<span>150</span>
			</span>
			</span> <a href="5-product-details.html"> <img
				src="<c:url value='/resources/img/ph/ph-home-big-3.png'/>" class="desat-ie" alt="" />
			</a> <span class="info gradient"> <span class="title">Men
					glass mode 2012</span> <span class="add-to-cart clearfix"> <span
					class="icon ir">Cart</span> <a href="7-cart.html" class="text">Add
						To Cart</a>
			</span>
			</span>
		</div>
	</li>
	<li class="span3 alpha25 desat">
		<div class="prod-wrapper">
			<span class="badge corner-badge hot ir">Hot</span> <span
				class="badge price-badge"> <span class="value"> <span>$</span>
					<span>150</span>
			</span>
			</span> <a href="5-product-details.html"> <img
				src="<c:url value='/resources/img/ph/ph-home-big-4.png'/>" class="desat-ie" alt="" />
			</a> <span class="info gradient"> <span class="title">Men
					glass mode 2012</span> <span class="add-to-cart clearfix"> <span
					class="icon ir">Cart</span> <a href="7-cart.html" class="text">Add
						To Cart</a>
			</span>
			</span>
		</div>
	</li>
	<li class="span3 alpha25 desat">
		<div class="prod-wrapper">
			<span class="badge corner-badge hot ir">Hot</span> <span
				class="badge price-badge"> <span class="value"> <span>$</span>
					<span>150</span>
			</span>
			</span> <a href="5-product-details.html"> <img
				src="<c:url value='/resources/img/ph/ph-home-big-5.png'/>" class="desat-ie" alt="" />
			</a> <span class="info gradient"> <span class="title">Men
					glass mode 2012</span> <span class="add-to-cart clearfix"> <span
					class="icon ir">Cart</span> <a href="7-cart.html" class="text">Add
						To Cart</a>
			</span>
			</span>
		</div>
	</li>
	<li class="span3 alpha25 desat">
		<div class="prod-wrapper">
			<span class="badge corner-badge hot ir hidden">Hot</span> <span
				class="badge price-badge"> <span class="value"> <span>$</span>
					<span>150</span>
			</span>
			</span> <a href="5-product-details.html"> <img
				src="<c:url value='/resources/img/ph/ph-home-big-6.png'/>" class="desat-ie" alt="" />
			</a> <span class="info gradient"> <span class="title">Men
					glass mode 2012</span> <span class="add-to-cart clearfix"> <span
					class="icon ir">Cart</span> <a href="7-cart.html" class="text">Add
						To Cart</a>
			</span>
			</span>
		</div>
	</li>
	<li class="span3 alpha25 desat">
		<div class="prod-wrapper">
			<span class="badge corner-badge hot ir hidden">Hot</span> <span
				class="badge price-badge"> <span class="value"> <span>$</span>
					<span>150</span>
			</span>
			</span> <a href="5-product-details.html"> <img
				src="<c:url value='/resources/img/ph/ph-home-big-7.png'/>" class="desat-ie" alt="" />
			</a> <span class="info gradient"> <span class="title">Men
					glass mode 2012</span> <span class="add-to-cart clearfix"> <span
					class="icon ir">Cart</span> <a href="7-cart.html" class="text">Add
						To Cart</a>
			</span>
			</span>
		</div>
	</li>
	<li class="span3 alpha25 desat">
		<div class="prod-wrapper">
			<span class="badge corner-badge hot ir hidden">Hot</span> <span
				class="badge price-badge"> <span class="value"> <span>$</span>
					<span>150</span>
			</span>
			</span> <a href="5-product-details.html"> <img
				src="<c:url value='/resources/img/ph/ph-home-big-8.png'/>" class="desat-ie" alt="" />
			</a> <span class="info gradient"> <span class="title">Men
					glass mode 2012</span> <span class="add-to-cart clearfix"> <span
					class="icon ir">Cart</span> <a href="7-cart.html" class="text">Add
						To Cart</a>
			</span>
			</span>
		</div>
	</li>
</ul>

<div class="row top-spacing">
	<div class="span12 main-heading">
		<div class="heading-line"></div>
		<div class="heading-wrapper">
			<h1>Other products</h1>
		</div>
	</div>
</div>

<div id="other-prod-slider">
	<div class="navigation"></div>
	<ul class="row-fluid clearfix rr other-products">
		<li class="span3 alpha25 desat"><a href="5-product-details.html">
				<span class="badge off ir hidden">Off</span> <img
				src="<c:url value='/resources/img/ph/ph-home-small-1.png'/>" alt="" />
		</a> <span class="info"> <span class="title">Men glass mode
					2012</span> <span class="price"> <span class="old hidden"><span>$</span><span>100</span>
						- </span> <span class="actual"><span>$</span><span>100</span></span>
			</span>
		</span></li>
		<li class="span3 alpha25 desat"><a href="5-product-details.html">
				<span class="badge off ir hidden">Off</span> <img
				src="<c:url value='/resources/img/ph/ph-home-small-2.png'/>" alt="" />
		</a> <span class="info"> <span class="title">Men glass mode
					2012</span> <span class="price"> <span class="old hidden"><span>$</span><span>100</span>
						- </span> <span class="actual"><span>$</span><span>100</span></span>
			</span>
		</span></li>
		<li class="span3 alpha25 desat"><a href="5-product-details.html">
				<span class="badge off ir hidden">Off</span> <img
				src="<c:url value='/resources/img/ph/ph-home-small-3.png'/>" alt="" />
		</a> <span class="info"> <span class="title">Men glass mode
					2012</span> <span class="price"> <span class="old"><span>$</span><span>100</span>
						- </span> <span class="actual"><span>$</span><span>100</span></span>
			</span>
		</span></li>
		<li class="span3 alpha25 desat"><a href="5-product-details.html">
				<span class="badge off ir">Off</span> <img
				src="<c:url value='/resources/img/ph/ph-home-small-4.png'/>" alt="" />
		</a> <span class="info"> <span class="title">Men glass mode
					2012</span> <span class="price"> <span class="old hidden"><span>$</span><span>100</span>
						- </span> <span class="actual"><span>$</span><span>100</span></span>
			</span>
		</span></li>
		<li class="span3 alpha25 desat"><a href="5-product-details.html">
				<span class="badge off ir">Off</span> <img
				src="<c:url value='/resources/img/ph/ph-home-small-3.png'/>" alt="" />
		</a> <span class="info"> <span class="title">Men glass mode
					2012</span> <span class="price"> <span class="old hidden"><span>$</span><span>100</span>
						- </span> <span class="actual"><span>$</span><span>100</span></span>
			</span>
		</span></li>
	</ul>
</div>
	</div>
