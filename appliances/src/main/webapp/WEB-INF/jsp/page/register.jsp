<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<form id="signup" action="/appliances/register" method="post">
	<c:if test="${registerError != null }">
		<h1 style="color: red;">${registerError}</h1>
	</c:if>
	<c:if test="${registerError == null }">
		<h1>Đăng ký miễn phí ngay bây giờ</h1>
	</c:if>
	<input type="text" placeholder="Tên đăng nhập" name="username">
	<input type="password" placeholder="Mật khẩu" name="password">
	<input type="password" placeholder="Xác nhận mật khẩu" name="confirmpassword"> 
	<input type="email" placeholder="Email" name="email"> 
	<input type="text" placeholder="Họ tên" name="fullname"> 
	<input type="text" placeholder="Điện thoại" name="phone"> 
	<input type="text"placeholder="Địa chỉ" name="address">
	<button type="button" onclick="javaScript: checkSubmitRegister()">Đăngký</button>
</form>