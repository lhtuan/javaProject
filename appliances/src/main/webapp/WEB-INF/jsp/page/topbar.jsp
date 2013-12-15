<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>
<div class="container">
	<div class="row">
		<div class="span12 menu clearfix">
			<ul class="clearfix rr">
				<c:if test="${username != null}">
					<li><a href="#"> <span class="ir icon my-account"></span>
							<span>${username}</span>
					</a></li>
				</c:if>
				<li><a href="#"> <span class="ir icon checkout"></span> <span>Thanh
							toán</span>
				</a></li>
				<c:if test="${username !=null}">
					<li><a href="<c:url value='j_spring_security_logout'/>"> <span class="ir icon log-in"></span> <span>Đăng
								xuất</span>
					</a></li>
				</c:if>
				<c:if test="${username ==null}">
					<li><a href="#"> <span class="ir icon log-in"></span> <span>Đăng
								nhập</span>
					</a></li>
				</c:if>
			</ul>
		</div>

	</div>
</div>