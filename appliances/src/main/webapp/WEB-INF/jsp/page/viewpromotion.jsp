<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<div role="main" class="container products list">
	<div class="row">

		<aside class="span3 left-nav">

			<div class="row">
				<div class="span3">
					<aside id="sidebar" class="column">
						<h3>Chương trình khuyến mãi</h3>
						<ul class="toggle">
							<li class="icn_new_article"><a
								href="/appliances/admin/addpromotion">New</a></li>
							<li class="icn_categories"><a
								href="/appliances/admin/viewpromotion">View</a></li>
						</ul>
						<h3>Đơn Đặt Hàng</h3>
						<ul class="toggle">
							<li class="icn_new_article"><a
								href="/appliances/admin/addorders">New</a></li>
							<li class="icn_categories"><a
								href="/appliances/admin/vieworders">View</a></li>
						</ul>
						<h3>Sản phẩm</h3>
						<ul class="toggle">
							<li class="icn_new_article"><a
								href="/appliances/admin/addproduct">New</a></li>
							<li class="icn_categories"><a
								href="/appliances/admin/viewproducts">View</a></li>
						</ul>
						<h3>Khách Hàng</h3>
						<ul class="toggle">
							<li class="icn_add_user"><a href="/appliances/admin/adduser">Add
									New User</a></li>
							<li class="icn_view_users"><a
								href="/appliances/admin/viewuser">View Users</a></li>
						</ul>

						<h3>Admin</h3>
						<ul class="toggle">
							<li class="icn_jump_back"><a href="j_spring_security_logout">Logout</a></li>
						</ul>

						<hr />
					</aside>
					<!-- end of sidebar -->

				</div>
			</div>
		</aside>

		<div class="span9">

			<article class="module width_3_quarter">
				<header>
					<h3 class="tabs_involved">Quản Lý Chương Trình Khuyến Mãi</h3>
				</header>

				<div class="tab_container">
					<div id="tab1" class="tab_content">
						<table class="tablesorter" cellspacing="0">
							<thead>
								<tr>
									<th>Tên Chương Trình</th>
									<th>Thời Gian Bắt Đầu</th>
									<th>Thời Gian Kết Thúc</th>
									<th>SaleOff</th>
									<th>Actions</th>
								</tr>
							</thead>

							<tbody>
								<c:forEach var="promotion" items="${Promotions}">
									<tr>
										<td>${promotion.promotionName}</td>
										<td>${promotion.dateStart}</td>
										<td>${promotion.dateEnd}</td>
										<td>${promotion.valueSaleOff}</td>
										<td><a
											href="/appliances/admin/editpromotion?id=${promotion.id}"><input
												type="image"
												src="<c:url value ='/resources/img/images/icn_edit.png'/>"
												title="Edit"></a> <a
											href="/appliances/admin/deletepromotion?id=${promotion.id}"><input
												type="image"
												src="<c:url value ='/resources/img/images/icn_trash.png'/>"
												title="Trash" /></a></td>
									</tr>
								</c:forEach>
							</tbody>

						</table>
					</div>
					<!-- end of #tab1 -->
				</div>
				<!-- end of .tab_container -->

			</article>
			<!-- end of content manager article -->

			<div class="products-view-nav row bottom">

				<div class="span3"></div>

				<div class="span6">
					<ul class="navigation rr">
						<fmt:parseNumber var="page" integerOnly="true" type="number"
							value="${ipage}" />
						<c:if test="${page>1 && totalPage !=0}">
							<li><a
								href="/appliances/admin/viewpromotion?isKeepProduct=true&page=${page-1}"
								class="arrow prev ir">Previous</a></li>
						</c:if>
						<c:forEach var="i" begin="1" end="${totalPage}">
							<c:if test="${i == page}">
								<li class="current"><a href="">${i}</a></li>
							</c:if>
							<c:if test="${i != page}">
								<li><a href="/appliances/admin/viewpromotion?page=${i}">${i}</a></li>
							</c:if>
						</c:forEach>
						<c:if test="${page<totalPage}">
							<li><a href="/appliances/admin/viewpromotion?page=${page+1}"
								class="arrow next ir">Next</a></li>
						</c:if>

					</ul>
				</div>

			</div>
		</div>
	</div>

</div>