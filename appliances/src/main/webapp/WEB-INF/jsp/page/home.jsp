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
								src="<c:url value='/resources/img/banner.png'/>"
								alt="" />
						</figure>
						<div class="content-wrapper">
							<div class="content">
								<h1>SHOES FOR MEN 2012</h1>
								<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
									Pellentesque at nunc a magna tincidunt placerat. In hac
									habitasse platea dictumst. Donec in tellus libero. Lorem ipsum
									dolor sit amet, consectetur adipis.</p>
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
