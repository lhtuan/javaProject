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
				<form id="searchForm" action="/appliances/search" method="get">
					<div class="span3">
						<h4>Tìm kiếm nâng cao</h4>
						<hr>
					</div>

					<div class="span3">
						<h5>Tên Sản Phẩm</h5>
						<input class="textboxsech" type="text" name="name" style="width:220px;" value="${searchCondition.name != null? searchCondition.name: null}" />
						<hr>
					</div>
					<div class="span3">
						<h5>Danh Mục</h5>
						<hr>
						<div class="dropdown">
							<select name="catalog" class="dropdown-select">
								<option value="-1">Chọn danh mục...</option>
								<c:forEach var="catalog" items="${catalogs}">
									<option value="${catalog.id}" ${catalog.id==searchCondition.catalog ? 'selected="selected"':'' }>${catalog.catalogName}</option>
								</c:forEach>

							</select>
						</div>
					</div>
					<div class="span3">
						<h5>Giá Từ</h5>
						<hr>
						<div class="dropdown">
							<select name="minPrice" class="dropdown-select">
								<option value="-1">Chọn giá...</option>
								<option value="100000" ${searchCondition.minPrice==100000?'selected="selected"':''} >100.000</option>
								<option value="500000"${searchCondition.minPrice==500000?'selected="selected"':''} >500.000</option>
								<option value="1000000"${searchCondition.minPrice==1000000?'selected="selected"':''} >1.000.000</option>
								<option value="5000000"${searchCondition.minPrice==5000000?'selected="selected"':''} >5.000.000</option>
							</select>
						</div>
					</div>
					<div class="span3">
						<h5>Giá Đến</h5>
						<hr>
						<div class="dropdown">
							<select name="maxPrice" class="dropdown-select">
								<option value="-1">Chọn giá...</option>
								<option value="500000" ${searchCondition.maxPrice==500000?'selected="selected"':''} >500.000</option>
								<option value="1000000" ${searchCondition.maxPrice==1000000?'selected="selected"':''}>1.000.000</option>
								<option value="5000000" ${searchCondition.maxPrice==5000000?'selected="selected"':''}>5.000.000</option>
								<option value="10000000" ${searchCondition.maxPrice==10000000?'selected="selected"':''}>10.000.000</option>
							</select>
						</div>
					</div>
					<div class="span3">
						<h5>Sắp xếp theo</h5>
						<hr>
						<div class="dropdown">
							<select name="order" class="dropdown-select">
								<option value="-1">...</option>
								<option value="productName asc">Tên tăng dần</option>
								<option value="productName desc">Tên giảm dần</option>
								<option value="price asc">Giá tăng dần</option>
								<option value="price desc">Giá giảm dần</option>
								<option value="rate asc">Đánh giá tăng dần</option>
								<option value="rate desc">Đánh giá giảm dần</option>
							</select>
						</div>
					</div>
					<div class="span3">
						<a href="javaScript:doSearch()" class="btn"><span
							class="gradient"><input type="image" value="Tìm" /></span></a>
					</div>
				</form>
			</div>

		</aside>
		<div class="span9">
			<div class="products-view-nav row">
				<div class="span9">
					<div class="span5">
						<ul class="navigation rr">
							<fmt:parseNumber var="page" integerOnly="true" type="number"
								value="${searchCondition.page}" />
							<c:if test="${page>1 && totalPage !=0}">
								<li><a href="/appliances/search?isKeepProduct=true&page=${page-1}"
									class="arrow prev ir">Previous</a></li>
							</c:if>
							<c:forEach var="i" begin="1" end="${totalPage}">
								<c:if test="${i == page}">
									<li class="current"><a href="">${i}</a></li>
								</c:if>
								<c:if test="${i != page}">
									<li><a href="/appliances/search?isKeepProduct=true&page=${i}">${i}</a></li>
								</c:if>
							</c:forEach>
							<c:if test="${page<totalPage}">
								<li><a href="/appliances/search?isKeepProduct=true&page=${page+1}"
									class="arrow next ir">Next</a></li>
							</c:if>

						</ul>
					</div>
					<div class="span3" style="float:right;">Xem <input id="productPerPage" value="${productPerPage}" type="number" class="textboxsech" style="width: 50px;" onchange="return changeProductPerPage('search');"> sản phẩm/trang</div>
				</div>
			</div>
			<ul class="row clearfix rr list-display product">
				<c:forEach var="product" items="${products}">
					<c:set var="link"
						value="/resources/img/products/${product.productName}.png" />
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
									<li><a class="clearfix"><span class="text">Đánh giá ${product.rate}</span></a></li>
								</ul>
							</div>
						</div>
					</li>
				</c:forEach>



			</ul>
			<div class="products-view-nav row bottom">
				<div class="span5">
											<ul class="navigation rr">
							<fmt:parseNumber var="page" integerOnly="true" type="number"
								value="${searchCondition.page}" />
							<c:if test="${page>1 && totalPage !=0}">
								<li><a href="/appliances/search?isKeepProduct=true&page=${page-1}"
									class="arrow prev ir">Previous</a></li>
							</c:if>
							<c:forEach var="i" begin="1" end="${totalPage}">
								<c:if test="${i == page}">
									<li class="current"><a href="">${i}</a></li>
								</c:if>
								<c:if test="${i != page}">
									<li><a href="/appliances/search?isKeepProduct=true&page=${i}">${i}</a></li>
								</c:if>
							</c:forEach>
							<c:if test="${page<totalPage}">
								<li><a href="/appliances/search?isKeepProduct=true&page=${page+1}"
									class="arrow next ir">Next</a></li>
							</c:if>

						</ul>
				</div>

			</div>

		</div>

	</div>
</div>