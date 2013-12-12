<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<div role="main" class="container products grid">
	<div class="row">

		<aside class="span3 left-nav">

			<div class="row">
				<div class="span3">
					<h5>Danh mục</h5>
					<hr>
					<ul class="category">
						<c:forEach var="catalog" items="${catalogs}">
							<li><a href="#">${catalog.catalogName}</a></li>
						</c:forEach>
					</ul>
				</div>
			</div>

		</aside>
		<div class="span9">
			<div class="products-view-nav row">
				<div class="span9">
					<div class="span6">
						<ul class="navigation rr">
							<fmt:parseNumber var="page" integerOnly="true" type="number"
								value="${searchCondition.page}" />
							<c:if test="${page>1 && totalPage !=0}">
								<li><a href="/appliances/product?isKeepProduct=true&page=${page-1}"
									class="arrow prev ir">Previous</a></li>
							</c:if>
							<c:forEach var="i" begin="1" end="${totalPage}">
								<c:if test="${i == page}">
									<li class="current"><a href="">${i}</a></li>
								</c:if>
								<c:if test="${i != page}">
									<li><a href="/appliances/product?isKeepProduct=true&page=${i}">${i}</a></li>
								</c:if>
							</c:forEach>
							<c:if test="${page<totalPage}">
								<li><a href="/appliances/product?isKeepProduct=true&page=${page+1}"
									class="arrow next ir">Next</a></li>
							</c:if>

						</ul>
					</div>

				</div>
			</div>
			<ul class="row clearfix rr list-display product">
				<c:forEach var="product" items="${products}">
					<c:set var="link"
						value="/resources/img/products/${product.productName}.jpg" />
					<li class="span9">
						<div class="row">
							<div class="span3 desat photo-wrapper">
								<a href="/appliances/productDetail?id=${product.id}"> <img
									src="<c:url value='${link}'/>" alt="" />
								</a>
							</div>
							<div class="span6 info clearfix">
								<h1>${product.productName}</h1>
								<hr />
								<div class="row price-wrapper">
									<div class="span2 clearfix">
										<a href="javaScript:callAjaxAddCart(${product.id},1);"  class="add-to-cart"> <span
											class="icon ir">Cart</span> <span class="text">Thêm
												vào giỏ</span>
										</a>
									</div>
									<div class="span3">
										<span class="price"> <span class="value">${product.price}</span>
										</span>
									</div>
								</div>
								<hr />
								<ul class="rr options clearfix">
									<li><a href="/appliances/compare/add?id=${product.id}" class="clearfix"> <span
											class="icon compare ir">So sánh</span> <span class="text">So
												sánh</span>
									</a></li>
								</ul>
							</div>
						</div>
					</li>
				</c:forEach>



			</ul>
			<div class="products-view-nav row bottom">
				<div class="span6">
											<ul class="navigation rr">
							<fmt:parseNumber var="page" integerOnly="true" type="number"
								value="${searchCondition.page}" />
							<c:if test="${page>1 && totalPage !=0}">
								<li><a href="/appliances/product?isKeepProduct=true&page=${page-1}"
									class="arrow prev ir">Previous</a></li>
							</c:if>
							<c:forEach var="i" begin="1" end="${totalPage}">
								<c:if test="${i == page}">
									<li class="current"><a href="">${i}</a></li>
								</c:if>
								<c:if test="${i != page}">
									<li><a href="/appliances/product?isKeepProduct=true&page=${i}">${i}</a></li>
								</c:if>
							</c:forEach>
							<c:if test="${page<totalPage}">
								<li><a href="/appliances/product?isKeepProduct=true&page=${page+1}"
									class="arrow next ir">Next</a></li>
							</c:if>

						</ul>
				</div>

			</div>

		</div>

	</div>
</div>