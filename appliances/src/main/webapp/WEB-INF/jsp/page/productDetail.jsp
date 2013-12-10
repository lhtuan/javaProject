<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<div role="main" class="container product-details">
        <div class="row">
        
          <div class="span10">
            <div class="row">              
              <div class="span4 gallery">
                <div class="gallery-sub-wrap clearfix">
                  <ul class="rr images">
                    <li class="current gal-1">
                    <c:set var="link"
						value="/resources/img/products/${product.productName}.jpg" />
                      <img src="<c:url value='${link}'/>" alt=""/>
                    </li>
                  </ul>
                </div>
              </div>
              
              <div class="span6 product">
                <h1>${product.productName}</h1>
                <p class="description">
                  ${product.description}
                </p>
                
                <hr/>
                
                <ul class="rr prefs clearfix">
                  <li class="avail clearfix">
                    <span class="info-title">Trạng thái:</span>
                    <ul class="rr clearfix">
                      <li class="value">Còn hàng</li>
                    </ul>
                  </li>
                  
                </ul>
                
                <hr/>
                
                <ul class="rr clearfix buy-wrapper">
                  <li class="clearfix quantity">
                  
                    <div class="info-title">Số lượng:</div>
                    <div class="f-select-wrapper fl">                  
                      <input type="number" name="number" value="1" style="width: 50px;"/>                   
                    </div>
                    
                  </li>                  
                  <li>
                    <a href="/appliances/cart/add?id=${product.id}&number=${number}" class="add-to-cart clearfix">
                      <span class="icon ir">Cart</span>
                      <span class="text">Thêm vào giỏ</span>
                    </a>
                  </li>                  
                  <li class="price-wrapper"> 
                    <span class="price">
                      <span class="value">${product.price }</span>
                    </span>    
                  </li>
                </ul>                
                
                <hr/>
                
                <ul class="rr options clearfix">
                  <li>
                    <a href="#" class="clearfix">
                      <span class="icon wishlist ir">Wishlist</span>
                      <span class="text">Add to wishlist</span>
                    </a>
                  </li>
                  <li>
                    <a href="#" class="clearfix">
                      <span class="icon compare ir">Compare</span>
                      <span class="text">So sánh</span>
                    </a>
                  </li>
                  <li class="last">
                    <a href="#" class="clearfix">
                      <span class="icon email ir">Email</span>
                      <span class="text">Email to a friend</span>
                    </a>
                  </li>
                </ul>                
                
                <hr/>
                
                <div class="share-product">
                    <!-- AddThis Button BEGIN -->
                    <div class="addthis_toolbox addthis_default_style ">
                    <a class="addthis_button_facebook_like" fb:like:layout="button_count"></a>
                    <a class="addthis_button_tweet"></a>
                    <a class="addthis_button_pinterest_pinit"></a>
                    <a class="addthis_counter addthis_pill_style"></a>
                    </div>
                    <script type="text/javascript" src="../../../s7.addthis.com/js/300/addthis_widget.js#pubid=xa-508f0d4568c64922"></script>
                    <!-- AddThis Button END -->
                </div>
                
              </div>
              
            </div>
            
            <hr/>
            
          </div>
        </div>
      </div>   