<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>
<div class="main-slideshow hidden-phone">
		<div class="container">
	<div class="row">
		<div class="span12">

			<ul class="rr slider" id="main-slider">
				<li class="slide-1 current">
					<div class="slide">
						<figure>
							<img
								src="<c:url  value='/resources/img/banner.png'/> "
								alt="" style="width: 300px;height: 300px;"/>
						</figure>
						<div class="content-wrapper">
							<div class="content">
								<h1>ĐỒ GIA DỤNG</h1>
								<p>Website chuyên cung cấp các sản phẩm gia dụng với chất lượng cao
								. Với đội ngũ nhân viên chuyên nghiệp, chúng tôi sẽ đảm bảo sự hài lòng tối đa cho khách hàng</p>
								<a href="product" class="btn"><span
									class="gradient">Show now</span></a>
							</div>
						</div>
					</div>
				</li>
			</ul>

		</div>
	</div>
</div>

<div class="slideshow-bottom">
	<div class="menu-gradient gradient">Gradient</div>
</div>
	</div>
