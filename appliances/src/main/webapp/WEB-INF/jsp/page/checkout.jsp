<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
      <div role="main" class="container checkout">
        <div class="row">
        
          <div class="span6 progress checkout-list">
              <ol class="rr">
              <li class="current">
                 <h6>Thông tin hóa đơn</h6>
                <div class="row">
                   <div class="span6 content-wrapper right-col">
                        <ul class="rr">
                          <li>
                            <label> Họ tên
                              <input type="text" name="fullname" value="${account.fullName}" readonly="readonly"/>
                            </label>
                          </li>  
						   <li>
                            <label>Email
                              <input type="text" name="email" value="${account.email}" readonly="readonly"/>
                            </label>
                          </li>
						   <li>
                            <label>Địa chỉ
                              <input type="text" name="adress" value="${account.address}" readonly="readonly"/>
                            </label>
                          </li>
						   <li>
                            <label>Số điện thoại
                              <input type="text" name="phone" value="${account.phone}" readonly="readonly"/>
                            </label>
                          </li>
                        </ul>
                  </div>                   
                </div>
              </li>
			  <li class="current">
                 <h6>Thông tin giao hàng</h6>
				  <div class="row">
                   <div class="span6 content-wrapper right-col">
                        <ul class="rr">
                          <li>
                            <label>Họ tên người nhận hàng
                              <input type="text" name="shipfullname" placeholder="Họ tên..."/>
                            </label>
                          </li>
						   <li>
                            <label>Email
                              <input type="text" name="shipemail" placeholder="Email..."/>
                            </label>
                          </li>
						   <li>
                            <label>Địa chỉ nhận hàng
                              <input type="text" name="shipaddress" placeholder="Địa chỉ..."/>
                            </label>
                          </li>
						   <li>
                            <label>Số điện thoại
                              <input type="text" name="shipphone" placeholder="Số điện thoại..."/>
                            </label>
                          </li>
                        </ul>
                  </div>                   
                </div>
              </li>
            </ol>
             
          </div>
          
          <div class="span6 checkout-list right-col">
            <ol class="rr">
              <li class="current">
                <h6>Thông tin</h6>
                <div class="row">
                   <div class="span6 content-wrapper ">
                        <ul class="rr  cart">
						 <table>
							  <tr class="headers">
								<th class="alpha50 dark">							  
								  Tên sản phẩm
								</th>
								<th class="alpha16">
								  Số lượng
								</th>
								<th class="span2" style="margin-left: 0px;">
								  giá
								</th>
							  </tr>
							  <c:forEach var="cartDetail" items="${cartDetails}">
							  <tr>
								<td class="article clearfix">
								 
									<h2>${cartDetail.product.productName}</h2>
								</td>
								<td class="quantity dark">
								
								  <div class="quant-input">
									<input type="text" value="${cartDetail.number}" readonly="readonly" style="width: 70px;"/>
								  </div>
								  
								</td>
								<td class="price dark">
								
								  <span class="value"><fmt:formatNumber value="${cartDetail.product.price}"  pattern="###,###,###.# đ" /></span>
								
								</td>
							  </tr>
							  </c:forEach>
							  
							  
							  <tr>
								<td colspan="2" class="empty">
								</td>
								<td colspan="2" class="total-wrapper">
							
									
								  <div class="total clearfix">
									<div class="half-col">
									  Tổng cộng
									</div>
									<div class=" value-wrapper">
									  
									<span class="value" id="totalPrice"><fmt:formatNumber value="${totalPrice}"  pattern="###,###,###.#" /></span>
									  
									</div>
								  </div>
								
								</td>
							  </tr>
							</table>
							<div class="row-fluid checkout">
							  <div class="span4">
								<a href="javaScript: checkOut()" class="btn"><span class="gradient">Hoàn tất</span></a>
							  </div>
							</div>
                        </ul>
                  </div>                   
                </div>
              </li>
            </ol>
          </div>
        
        </div>
      </div>    
      