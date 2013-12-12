<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<div role="main" class="container">
			<div id="content_holder" >
				<div class="inner">
				  <div id="content">
					<table class="compare-info">
					  <thead>
						<tr>
						  <td colspan="5">Product Details</td>
						</tr>
					  </thead>
					  <tbody>
						<tr>
						  <td>Sản phẩm</td>
						  <c:forEach var="product" items="${products}">
						  	<td class="name"><a href="/appliances/productDetail?id=${product.id}">${product.productName}</a></td>
						  </c:forEach>
						</tr>
						<tr class="even">
						  <td>Ảnh</td>
						  <c:forEach var="product" items="${products}">
						  <c:set var="link"
						value="/resources/img/products/${product.productName}.jpg" />
						  	<td class="image"><img src="<c:url value='${link}'/>" alt="${product.productName}" /></td>
						  </c:forEach>
						</tr>
						<tr>
						  <td>Giá</td>
						  <c:forEach var="product" items="${products}">
						  <td>${product.price}</td>
						  </c:forEach>
						</tr>
						<tr class="even">
						  <td>Đánh giá</td>
						  <td><img alt="Based on 0 reviews." src="image/stars-2.png"/><br/>
							Based on 3 reviews.</td>
						  <td><img alt="Based on 0 reviews." src="image/stars-5.png"/><br/>
							Based on 12 reviews.</td>
						  <td><img alt="Based on 0 reviews." src="image/stars-3.png"/><br/>
							Based on 7 reviews.</td>
						</tr>
						<tr >
						  <td>Mô tả</td>
						  <c:forEach var="product" items="${products}">
						  	<td class="description">${fn:substring(product.description,0,150)}...</td>
						  </c:forEach>
						</tr>
					  
					  </tbody>
					  <tbody>
						<tr class="even">
						  <td></td>
						  <c:forEach var="product" items="${products}">
						  	<td><a class="button" href="javaScript: callAjaxAddCart(${product.id},1)"><span>Thêm vào giỏ</span></a></td>
						  </c:forEach>
						</tr>
						<tr>
						  <td></td>
						  <c:forEach var="product" items="${products}">
						  <td><input type="hidden" value="43" name="remove"/>
							<a href="#"><span>Xóa</span></a></td>
						  </c:forEach>
						</tr>
					  </tbody>
					</table>
				  </div>
				</div>
			  </div>
		</div>