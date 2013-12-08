<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>
<div role="main" class="container products grid">
	<div class="row">

		<aside class="span3 left-nav">

			<div class="row">
				<div class="span3">
					<h5>Category</h5>

					<hr>

					<ul class="category">
						<li><a href="#">About us</a></li>
						<li><a href="#">Delivery information</a></li>
						<li><a href="#">Privacy policy</a></li>
						<li><a href="#">Terms &amp; conditions</a></li>
						<li><a href="#">Contact us</a></li>
					</ul>
				</div>

				<div class="span3">
					<h5>Colour</h5>

					<hr>

					<ul class="colour-list">
						<li><a href="#">Black</a></li>
						<li><a href="#">Blue</a></li>
						<li><a href="#">Brown</a></li>
						<li><a href="#">Green</a></li>
						<li><a href="#">Gray</a></li>
						<li><a href="#">Metallic</a></li>
						<li><a href="#">Multicolour</a></li>
						<li><a href="#">Nude &amp; neutrals</a></li>
						<li><a href="#">Pink &amp; purple</a></li>
						<li><a href="#">Red</a></li>
						<li><a href="#">White</a></li>
						<li><a href="#">Yellow &amp; orange</a></li>
					</ul>
				</div>

				<div class="span3">
					<h5>Price</h5>

					<hr>

					<ul class="price">
						<li><a href="#"> <span class="currency">$</span> <span
								class="min-val">50</span> <span class="dash">-</span> <span
								class="currency">$</span> <span class="min-val">100</span>
						</a></li>
						<li><a href="#"> <span class="currency">$</span> <span
								class="min-val">100</span> <span class="dash">-</span> <span
								class="currency">$</span> <span class="min-val">200</span>
						</a></li>
						<li><a href="#"> <span class="currency">$</span> <span
								class="min-val">200</span> <span class="dash">-</span> <span
								class="currency">$</span> <span class="min-val">500</span>
						</a></li>
						<li><a href="#"> <span class="currency">$</span> <span
								class="min-val">500</span> <span class="dash">-</span> <span
								class="currency">$</span> <span class="min-val">1000</span>
						</a></li>
						<li><a href="#"> <span class="currency">$</span> <span
								class="min-val">1000</span> <span class="dash">-</span> <span
								class="currency">$</span> <span class="min-val">2000</span>
						</a></li>
						<li><a href="#"> <span class="currency">$</span> <span
								class="min-val">2000</span> <span class="dash">-</span> <span
								class="currency">$</span> <span class="min-val">5000</span>
						</a></li>
						<li><a href="#"> <span class="currency">$</span> <span
								class="min-val">5000</span> <span class="dash">+</span>
						</a></li>
					</ul>
				</div>
			</div>

		</aside>
		<div class="span9">
			<div class="products-view-nav row">
				<div class="span9">
					<div class="span6">
						<ul class="navigation rr">
							<li><a href="#" class="arrow prev ir">Previous</a></li>
							<li><a href="#">1</a></li>
							<li class="current"><a href="#">2</a></li>
							<li><a href="#">3</a></li>
							<li><a href="#">4</a></li>
							<li><a href="#">5</a></li>
							<li><a href="#" class="arrow next ir">Next</a></li>
						</ul>
					</div>

				</div>
			</div>
			<ul class="row-fluid clearfix rr grid-display">
				<li class="span4 alpha33 desat">
					<div class="prod-wrapper">
						<span class="badge corner-badge off-35 ir">Hot</span> <span
							class="badge price-badge"> <span class="value"> <span>$</span>
								<span>150</span>
						</span>
						</span> <a href="5-product-details.html"> <img
							src="<c:url value='/resources/img/ph/ph-home-big-2.png'/>"
							class="desat-ie" alt="" />
						</a> <span class="info gradient"> <span class="title">Men
								glass mode 2012</span> <span class="add-to-cart clearfix"> <span
								class="icon ir">Cart</span> <a href="7-cart.html" class="text">Add
									To Cart</a>
						</span>
						</span>
					</div>
				</li>
				<li class="span4 alpha33 desat">
					<div class="prod-wrapper">
						<span class="badge corner-badge hot ir">Hot</span> <span
							class="badge price-badge"> <span class="value"> <span>$</span>
								<span>150</span>
						</span>
						</span> <a href="5-product-details.html"> <img
							src="<c:url value='/resources/img/ph/ph-home-big-1.png'/>"
							class="desat-ie" alt="" />
						</a> <span class="info gradient"> <span class="title">Men
								glass mode 2012</span> <span class="add-to-cart clearfix"> <span
								class="icon ir">Cart</span> <a href="7-cart.html" class="text">Add
									To Cart</a>
						</span>
						</span>
					</div>
				</li>
				<li class="span4 alpha33 desat">
					<div class="prod-wrapper">
						<span class="badge corner-badge hot ir hidden">Hot</span> <span
							class="badge price-badge"> <span class="value"> <span>$</span>
								<span>150</span>
						</span>
						</span> <a href="5-product-details.html"> <img
							src="<c:url value='/resources/img/ph/ph-home-big-3.png'/>"
							class="desat-ie" alt="" />
						</a> <span class="info gradient"> <span class="title">Men
								glass mode 2012</span> <span class="add-to-cart clearfix"> <span
								class="icon ir">Cart</span> <a href="7-cart.html" class="text">Add
									To Cart</a>
						</span>
						</span>
					</div>
				</li>
				<li class="span4 alpha33 desat">
					<div class="prod-wrapper">
						<span class="badge corner-badge hot ir">Hot</span> <span
							class="badge price-badge"> <span class="value"> <span>$</span>
								<span>150</span>
						</span>
						</span> <a href="5-product-details.html"> <img
							src="<c:url value='/resources/img/ph/ph-home-big-4.png'/>"
							class="desat-ie" alt="" />
						</a> <span class="info gradient"> <span class="title">Men
								glass mode 2012</span> <span class="add-to-cart clearfix"> <span
								class="icon ir">Cart</span> <a href="7-cart.html" class="text">Add
									To Cart</a>
						</span>
						</span>
					</div>
				</li>
				<li class="span4 alpha33 desat">
					<div class="prod-wrapper">
						<span class="badge corner-badge hot ir">Hot</span> <span
							class="badge price-badge"> <span class="value"> <span>$</span>
								<span>150</span>
						</span>
						</span> <a href="5-product-details.html"> <img
							src="<c:url value='/resources/img/ph/ph-home-big-5.png'/>"
							class="desat-ie" alt="" />
						</a> <span class="info gradient"> <span class="title">Men
								glass mode 2012</span> <span class="add-to-cart clearfix"> <span
								class="icon ir">Cart</span> <a href="7-cart.html" class="text">Add
									To Cart</a>
						</span>
						</span>
					</div>
				</li>
				<li class="span3 alpha33 desat">
					<div class="prod-wrapper">
						<span class="badge corner-badge hot ir hidden">Hot</span> <span
							class="badge price-badge"> <span class="value"> <span>$</span>
								<span>150</span>
						</span>
						</span> <a href="5-product-details.html"> <img
							src="<c:url value='/resources/img/ph/ph-home-big-6.png'/>"
							class="desat-ie" alt="" />
						</a> <span class="info gradient"> <span class="title">Men
								glass mode 2012</span> <span class="add-to-cart clearfix"> <span
								class="icon ir">Cart</span> <a href="7-cart.html" class="text">Add
									To Cart</a>
						</span>
						</span>
					</div>
				</li>
				<li class="span3 alpha33 desat">
					<div class="prod-wrapper">
						<span class="badge corner-badge hot ir hidden">Hot</span> <span
							class="badge price-badge"> <span class="value"> <span>$</span>
								<span>150</span>
						</span>
						</span> <a href="5-product-details.html"> <img
							src="<c:url value='/resources/img/ph/ph-home-big-7.png'/>"
							class="desat-ie" alt="" />
						</a> <span class="info gradient"> <span class="title">Men
								glass mode 2012</span> <span class="add-to-cart clearfix"> <span
								class="icon ir">Cart</span> <a href="7-cart.html" class="text">Add
									To Cart</a>
						</span>
						</span>
					</div>
				</li>
				<li class="span3 alpha33 desat">
					<div class="prod-wrapper">
						<span class="badge corner-badge hot ir hidden">Hot</span> <span
							class="badge price-badge"> <span class="value"> <span>$</span>
								<span>150</span>
						</span>
						</span> <a href="5-product-details.html"> <img
							src="<c:url value='/resources/img/ph/ph-home-big-8.png'/>"
							class="desat-ie" alt="" />
						</a> <span class="info gradient"> <span class="title">Men
								glass mode 2012</span> <span class="add-to-cart clearfix"> <span
								class="icon ir">Cart</span> <a href="7-cart.html" class="text">Add
									To Cart</a>
						</span>
						</span>
					</div>
				</li>
				<li class="span4 alpha33 desat">
					<div class="prod-wrapper">
						<span class="badge corner-badge hot ir hidden">Hot</span> <span
							class="badge price-badge"> <span class="value"> <span>$</span>
								<span>150</span>
						</span>
						</span> <a href="5-product-details.html"> <img
							src="<c:url value='/resources/img/ph/ph-home-big-2.png'/>"
							class="desat-ie" alt="" />
						</a> <span class="info gradient"> <span class="title">Men
								glass mode 2012</span> <span class="add-to-cart clearfix"> <span
								class="icon ir">Cart</span> <a href="7-cart.html" class="text">Add
									To Cart</a>
						</span>
						</span>
					</div>
				</li>
			</ul>
			<div class="products-view-nav row bottom">
				<div class="span6">
					<ul class="navigation rr">
						<li><a href="#" class="arrow prev ir">Previous</a></li>
						<li><a href="#">1</a></li>
						<li class="current"><a href="#">2</a></li>
						<li><a href="#">3</a></li>
						<li><a href="#">4</a></li>
						<li><a href="#">5</a></li>
						<li><a href="#" class="arrow next ir">Next</a></li>
					</ul>
				</div>

			</div>

		</div>

	</div>
</div>