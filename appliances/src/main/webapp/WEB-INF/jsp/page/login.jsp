<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
    <div class='form'>
      <h1>Đăng nhập</h1>
      <c:if test="${not empty error}">
		<p style="color: red;">Tên đăng nhập hoặc mật khẩu không chính xác</p>
	</c:if>
      
      <div class='line'></div>
      
      <!-- If you don't want a social buttons, delete all of these code -->
        <a class='btn-facebook' href='#'>Đăng nhập qua Facebook</a>
        <a class='btn-twitter' href='#'>Connect with Twitter</a>
      <!-- Till here -->
      
      
      <!-- Span class ie-placeholder is there for IE browser. IE doesn't support placeholder attribute -->
      <form name='f' class='input-form' action="<c:url value='j_spring_security_check' />" method="post">
        <span class='ie-placeholders'>Tên đăng nhập:</span><input type='text' placeholder='Tên đăng nhập' name="j_username" />
        <span class='ie-placeholders'>Mật khẩu:</span><input type='password' placeholder='Mật khẩu' name="j_password" />
        <a class='forgotten-password-link' href='#'>Đăng ký</a>
        <input type='submit' class='btn-sign-in btn-orange' value='Đăng nhập' />
      </form>
     
    </div>