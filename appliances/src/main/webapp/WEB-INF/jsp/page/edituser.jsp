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
			<article class="module2 width_3_quarter">

				<div id="adm_right">
					<header>
						<h3 class="tabs_involved">Cập Nhật Thông Tin Khách Hàng</h3>
					</header>
					<c:if test="${editError != null }">
						<h1 style="color: red;">${editError}</h1>
					</c:if>
					<form action="/appliances/admin/complateupdate" method="get">
						<fieldset>
							<label>Username</label> <input type="text"
								value="${account.username}" name="username"  readonly="readonly">
							<label>Password</label> <input type="text"
								value="${account.password}" name="password"> <label>FullName</label>
							<input type="text" value="${account.fullName}" name="fullname">
							<label>Email</label> <input type="text" value="${account.email}"
								name="email"> <label>Phone</label> <input type="text"
								value="${account.phone}" name="phone"> <label>Adress</label>
							<input type="text" value="${account.address}" name="adress">
						</fieldset>
						<input type="submit" value="Save">
					</form>
				</div>
			</article>
			<!-- end of content manager article -->

		</div>
	</div>

</div>