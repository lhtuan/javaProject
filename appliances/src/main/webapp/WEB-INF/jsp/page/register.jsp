<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
${registerError}
<form id="signup" action="/appliances/register" method="post">
			<h1>Đăng ký miễn phí ngay bây giờ</h1>
			<input type="text" placeholder="Tên đăng nhập" name="username" required="">
			<input type="password" placeholder="Mật khẩu" name="password" required="">
			<input type="password" placeholder="Xác nhận mật khẩu" name="confirmpassword" required="">		
			<input type="email" placeholder="Email" name="email" required="">
			<input type="text" placeholder="Họ tên" name="fullname" required="">
			<input type="text" placeholder="Điện thoại" name="phone" required="">
			<input type="text" placeholder="Địa chỉ" name="address" required="">
			<button type="submit">Đăng ký</button>	
</form>