<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<div role="main" class="container product-details">
	<div class="row">

		<div class="span10">
			<div class="row">
				<div class="span4 gallery">
					<div class="gallery-sub-wrap clearfix">
						<ul class="rr images">
							<li class="current gal-1"><c:set var="link"
									value="/resources/img/products/${product.productName}.png" />
								<img src="<c:url value='${link}'/>" alt="" /></li>
						</ul>
					</div>
				</div>

				<div class="span6 product">
					<h1>${product.productName}</h1>
					<p class="description">${product.description}</p>

					<hr />

					<ul class="rr prefs clearfix">
						<li class="avail clearfix"><span class="info-title">Trạng
								thái:</span>
							<ul class="rr clearfix">
								<li class="value">Còn hàng</li>
							</ul></li>

					</ul>

					<hr />

					<ul class="rr clearfix buy-wrapper">
						<li class="clearfix quantity">

							<div class="info-title">Số lượng:</div>
							<div class="f-select-wrapper fl">
								<input type="number" id="number" value="1" style="width: 50px;"
									onkeypress="return onInputChange(event)" />
							</div>

						</li>
						<li><a href="javaScript:addToCart(${product.id});"
							class="add-to-cart clearfix"> <span class="icon ir">Cart</span>
								<span class="text">Thêm vào giỏ</span>
						</a></li>
						<li class="price-wrapper"><span class="price"> <span
								class="value"><fmt:formatNumber value="${product.price}"  pattern="###,###,###.# đ" /></span>
						</span></li>
					</ul>

					<hr />

					<ul class="rr options clearfix">						
						<li><a href="javaScript: callAjaxAddCompare(${product.id})"
							class="clearfix"> <span class="icon compare ir">Compare</span>
								<span class="text">So sánh</span>
						</a></li>
						<li class="last"><a href="#" class="clearfix"> <span
								class="icon email ir">Email</span> <span class="text">Email
									to a friend</span>
						</a></li>
					</ul>

					<hr />

					<div class="share-product">
						<div class="span1">
							<p style="margin: 0;">Đánh giá:</p>
						</div>
						<div class="span3">
							0<input id="rate" value="${product.rate}" type="range" min="0" max="5" step="0.5" onchange="return rateChange();">5
						</div>
						<div>
							<p id="rateValue" style="color: rgb(0, 61, 255); margin: 0; padding: 0;">${product.rate} / ${product.rateCount} đánh giá</p>
						</div>
						<div class="span5" id="ratelink">
							<a href="javaScript: rate(${product.id})"><img src="<c:url value='/resources/img/rate.png'/>"/>Gửi đánh giá</a>
							<a id="userRate">${product.rate}</a>
						</div>
					</div>

				</div>

			</div>

			<hr />

		</div>
		<div class="span2 also-like">
			<h5>Sản Phẩm Tương Tự</h5>
			<ul class="rr clearfix">
				<c:forEach var="sameProduct" items="${FourSameProducts}">
					<c:set var="link"
						value="/resources/img/products/${sameProduct.productName}.png" />
					<li><a href="/appliances/productDetail?id=${sameProduct.id}">
							<img src="<c:url value="${link}"/>" alt="" />
					</a></li>
				</c:forEach>
			</ul>
		</div>
	</div>
</div>
