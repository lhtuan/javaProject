<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<div role="main" class="container products list">
	<div class="row">
<div class="span9">
			<article class="module width_3_quarter">
				
				<header>
					<h3 class="tabs_involved">History</h3>
				</header>

				<div class="tab_container">
					<div id="tab1" class="tab_content">
						<table class="tablesorter" cellspacing="0">
							<thead>
								<tr>
									<th>ShipFullname</th>
									<th>ShipAddress</th>
									<th>ShipEmail</th>
									<th>OderDate</th>
									
								</tr>
							</thead>
							<tbody>

								<c:forEach var="order" items="${orders}">
									<tr>
										<td>${order.shipfullname}</td>
										<td>${order.shipaddress}</td>
										<td>${order.shipemail}</td>
										<td>${order.orderDate}</td>
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