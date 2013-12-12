<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>
        <div class="row">
        
          <div class="span8 logo-wrapper">
            <a href="/appliances" class="logo">
              <span class="icon ir">Men Style Shop</span>
            </a>
          </div>
          <div class="span4">
          
            <div class="row">
              
              <div class="span2 offset1 flags-wrapper">
                <ul class="flags clearfix rr">
                  <li><a href="#" class="ir flag usa">USA</a></li>
                  <li><a href="#" class="ir flag ger">GER</a></li>
                </ul>
              </div>
              
              <div class="span1 f-select-wrapper">
              
                <div id="current-currency" class="current clearfix">
                  <div class="value">$</div>
                  <div class="button gradient">
                    <span class="arrow ir">Open</span>
                  </div>
                </div>
              
                <select id="main-currency" class="main">
                  <option>$</option>
                  <option>EUR</option>
                </select>
                
              </div>
              
            </div>
            
            
            <div class="shopping-cart">
              <span class="icon ir">Cart</span>
              <span class="text"><a href="/appliances/cart"><span class="title">Giỏ hàng</span></a> (<span id="cartNumber">${cartNumber}</span> Sản phẩm) - </span>
              <span class="price"><span>VND</span><span class="totalPrice">${totalPrice}</span></span>
            </div>
            
          </div>
          
        </div>  

        <div class="row main-menu-wrapper">
          
          <div class="span9">
            <ul class="main-menu clearfix rr" id="main-menu">
              <li><a href="/appliances/" class="current">Trang chủ</a></li>
              <li id="shop-submenu-area">
                <a href="/appliances/product" id="shop-submenu-trigger">Cửa hàng</a>
                <ul class="row shop-submenu rr">
                  <li class="arrow ir">Arrow</li>
                  <li class="span2 beta">
                    <ul class="rr">
                      <li>
                        <span class="ir icon">Icon</span>
                        <span class="category">Danh mục</span>
                      </li>
                    <c:forEach var="catalog" items="${catalogs}">
						<li><a href="product?catalog=${catalog.id}">${catalog.catalogName}</a></li>
					</c:forEach>
                    </ul>
                  </li>
                </ul>
              </li>
              <li><a href="/appliances/checkout">Thanh toán</a></li>
              <li><a href="/appliances/cart">Giỏ hàng</a></li>
              <li><a href="/appliances/contact">Liên hệ</a></li>
            </ul>
          </div>          
          
          <div class="span3">
            <input type="text" class="search-box" placeholder="Tìm..." value=""/>
          </div>
          
        </div>