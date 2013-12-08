<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<div role="main" class="container product-details">
        <div class="row">
        
          <div class="span10">
            <div class="row">              
              <div class="span5 gallery">
                <div class="gallery-sub-wrap clearfix">
                 
                  <ul class="rr images">
                    <li class="current gal-1">
                      <img src="<c:url value='/resources/img/ph/ph-details-big-1.png'/>" alt=""/>
                    </li>
                    <li class="gal-2">
                      <img src="<c:url value='/resources/img/ph/ph-details-small-2.png'/>" width="286" alt=""/>
                    </li>
                    <li class="gal-3">
                      <img src="<c:url value='/resources/img/ph/ph-details-big-1.png'/>" alt=""/>
                    </li>
                    <li class="gal-4">
                      <img src="<c:url value='/resources/img/ph/ph-details-small-2.png'/>" width="286" alt=""/>
                    </li>
                  </ul>
                </div>
              </div>
              
              <div class="span5 product">
                <h1>Green camouflage utility</h1>
                <p class="description">
                  Vestibulum ante ipsum primis in faucibus orci luctus et 
                  ultrrd rices posuere cubilia Curae; Aenean eleifend laoreet.
                </p>
                
                <hr/>
                
                <ul class="rr prefs clearfix">
                  <li class="size clearfix">
                    <span class="info-title">Size:</span>
                    <ul class="rr clearfix">
                      <li>10</li>
                      <li class="current">12</li>
                      <li>13</li>
                      <li>14</li>
                      <li>15</li>
                    </ul>
                  </li>
                  <li class="avail clearfix">
                    <span class="info-title">Availability:</span>
                    <ul class="rr clearfix">
                      <li class="value">In stock</li>
                    </ul>
                  </li>
                  <li class="colour-wrapper clearfix last">
                    <span class="info-title">Colour:</span>
                    <ul class="rr clearfix">
                      <li class="colour orange">Orange</li>
                      <li class="colour teal">Teal</li>
                      <li class="colour pink">Pink</li>
                      <li class="colour black">Black</li>
                    </ul>
                  </li>
                </ul>
                
                <hr/>
                
                <ul class="rr clearfix buy-wrapper">
                  <li class="clearfix quantity">
                  
                    <div class="info-title">Quantity:</div>
                    <div class="f-select-wrapper fl">                  
                      <div id="current-quantity" class="current" class="clearfix">
                        <div class="value">2</div>
                        <div class="button gradient">
                          <span class="arrow ir">Open</span>
                        </div>
                      </div>
                    
                      <select id="main-quantity" class="main">
                        <option>1</option>
                        <option selected="selected">2</option>
                        <option>3</option>
                        <option>4</option>
                      </select>                    
                    </div>
                    
                  </li>                  
                  <li>
                  
                    <a href="#" class="add-to-cart clearfix">
                      <span class="icon ir">Cart</span>
                      <span class="text">Add to cart</span>
                    </a>
                  
                  </li>                  
                  <li class="price-wrapper">
                  
                    <span class="price">
                      <span class="currency">$</span><span class="value">320</span>
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
                      <span class="text">Add to compare</span>
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
          
          <div class="span2 also-like">
            <h5>You may also like</h5>
            <ul class="rr clearfix">
              <li>
                <a href="#">
                  <img src="<c:url value='/resources/img/ph/ph-also-1.png'/>" alt=""/>
                </a>
              </li>
              <li>
                <a href="#">
                  <img src="<c:url value='/resources/img/ph/ph-also-2.png'/>" alt=""/>
                </a>
              </li>
              <li>
                <a href="#">
                  <img src="<c:url value='/resources/img/ph/ph-also-3.png'/>" alt=""/>
                </a>
              </li>
              <li>
                <a href="#">
                  <img src="<c:url value='/resources/img/ph/ph-also-4.png'/>" alt=""/>
                </a>
              </li>
            </ul>
          </div>
        
        </div>
      </div>   