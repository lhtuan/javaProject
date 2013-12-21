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
				<c:if test="${deletedordererror != null }">
					<h1 style="color: red;">${deletedordererror}</h1>
				</c:if>
				<header>
					<h3 class="tabs_involved">Quản Lý Đơn Đặt Hàng</h3>
				</header>

				<div class="tab_container">
					<div id="tab1" class="tab_content">
						<table class="tablesorter" cellspacing="0">
							<thead>
								<tr>
									<th>Người Nhận</th>
									<th>Địa Chỉ</th>
									<th>Email</th>
									<th>Ngày Nhận</th>
									<th>Actions</th>
								</tr>
							</thead>
							<tbody>

								<c:forEach var="order" items="${orders}">
									<tr>
										<td>${order.shipfullname}</td>
										<td>${order.shipaddress}</td>
										<td>${order.shipemail}</td>
										<td>${order.orderDate}</td>
										<td><a href="/appliances/admin/detailorder?id=${order.id}">Detail</a> <a
											href="/appliances/admin/editorders?id=${order.id}"><input
												type="image"
												src="<c:url value ='/resources/img/images/icn_edit.png'/>"
												title="Edit"></a> <a
											href="/appliances/admin/deletedorders?id=${order.id}"> <input
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
							<li><a href="/appliances/admin/vieworders?page=${page-1}"
								class="arrow prev ir">Previous</a></li>
						</c:if>
						<c:forEach var="i" begin="1" end="${totalPage}">
							<c:if test="${i == page}">
								<li class="current"><a href="">${i}</a></li>
							</c:if>
							<c:if test="${i != page}">
								<li><a href="/appliances/admin/vieworders?page=${i}">${i}</a></li>
							</c:if>
						</c:forEach>
						<c:if test="${page<totalPage}">
							<li><a href="/appliances/admin/vieworders?page=${page+1}"
								class="arrow next ir">Next</a></li>
						</c:if>

					</ul>
				</div>

			</div>
		</div>
	</div>

</div>