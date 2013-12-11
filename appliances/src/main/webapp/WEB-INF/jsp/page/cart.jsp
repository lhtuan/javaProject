<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<div role="main" class="container cart">

	<table>
		<tr class="headers">
			<th class="alpha50 dark">Sản phẩm</th>
			<th class="alpha16">Số lượng</th>
			<th class="alpha16 dark">Giá</th>
			<th class="alpha16">Thành tiền</th>
		</tr>
		<c:forEach var="cartDetail" items="${cart.shoppingcartdetails}">
			<tr id="detail_${cartDetail.product.id}">
				<td class="article clearfix"><c:set var="link"
						value="/resources/img/products/${cartDetail.product.productName}.jpg" />
					<figure>
						<img src="<c:url value='${link}'/>" alt="" />
					</figure>

					<div class="info-wrapper">
						<h2>${cartDetail.product.productName}</h2>
						<div>
							<img id="buttonDelete_${cartDetail.product.id}" class="button_delete" onclick="return callAjaxDeleteCart(${cartDetail.product.id})"
								src="<c:url value='/resources/img/delete.png'/>"
								style="width: 25px;" />
						</div>
					</div></td>
				<td class="quantity dark">

					<div class="quant-input">
						<input type="number" id="number_${cartDetail.product.id}"
							value="${cartDetail.number}"
							onchange="return callAjaxEditCart(${cartDetail.product.id})" />
					</div>

				</td>
				<td class="price"><span id="price_${cartDetail.product.id}">${cartDetail.product.price}</span>

				</td>
				<td class="price dark"><span
					id="realprice_${cartDetail.product.id}">${cartDetail.product.price*cartDetail.number}</span>

				</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="2" class="empty"></td>
			<td colspan="2" class="total-wrapper">
				<div class="total clearfix">
					<div class="half-col">Tổng cộng</div>
					<div class="half-col value-wrapper">

						<span class="currency">$</span><span class="totalPrice">${total}</span>

					</div>
				</div>

			</td>
		</tr>
	</table>

	<div class="row-fluid checkout">
		<div class="span4">
			<a href="#" class="btn"><span class="gradient">Checkout</span></a>
		</div>
	</div>

</div>
