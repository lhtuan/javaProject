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
                              <input type="text" name="fullname" placeholder="Họ tên..."/>
                            </label>
                          </li>  
						   <li>
                            <label>Email
                              <input type="text" name="email" placeholder="Email..."/>
                            </label>
                          </li>
						   <li>
                            <label>Địa chỉ
                              <input type="text" name="adress" placeholder="Địa chỉ..."/>
                            </label>
                          </li>
						   <li>
                            <label>Số điện thoại
                              <input type="text" name="phone" placeholder="Số điện thoại..."/>
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
                            <label>Họ tên
                              <input type="text" name="shipfirstname" placeholder="Firstname..."/>
                            </label>
                          </li>
                          <li>
                            <label>Lastname
                              <input type="text" name="shiplastname" placeholder="Lastname..."/>
                            </label>
                          </li>
						   <li>
                            <label>Email
                              <input type="text" name="shipemail" placeholder="Email..."/>
                            </label>
                          </li>
						   <li>
                            <label>Adress
                              <input type="text" name="shipadress" placeholder="Adress..."/>
                            </label>
                          </li>
						   <li>
                            <label>Phone
                              <input type="text" name="shipphone" placeholder="Phone..."/>
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
                <h6>Shipping Price</h6>
                <div class="row">
                   <div class="span6 content-wrapper right-col">
                        <ul class="rr">
                          <li>
                            <label>Shipping Price : $5.00</label>
                          </li>
                        </ul>
                  </div>                   
                </div>
              </li>
			  <li class="current">
                 <h6>Payment information</h6>
				  <div class="row">
                   <div class="span6 content-wrapper right-col">
                        <ul class="rr">
							<li>
							  <label>Name on Card 
								  <input type="text" name="nameoncard" placeholder="Name on Card..."/>
								</label>
							</li>
							<li>
								 <label>Credit Card Type  
									  <select name="payment[cc_type]" >
										<option value="">--Please Select--</option>
										<option value="VI">Visa</option>
										<option value="MC">MasterCard</option>
										<option value="DI">Discover</option>
									</select>
								</label>
							</li>
							<li>
								 <label>Expiration Date
									   <select >
                                            <option value="" selected="selected">Month</option>
											<option value="1">01 - January</option>
											<option value="2">02 - February</option>
											<option value="3">03 - March</option>
											<option value="4">04 - April</option>
											<option value="5">05 - May</option>
											<option value="6">06 - June</option>
											<option value="7">07 - July</option>
											<option value="8">08 - August</option>
											<option value="9">09 - September</option>
											<option value="10">10 - October</option>
											<option value="11">11 - November</option>
											<option value="12">12 - December</option>
										</select>
										<select >
											<option value="" selected="selected">Year</option>
											<option value="2013">2013</option>
											<option value="2014">2014</option>
											<option value="2015">2015</option>
											<option value="2016">2016</option>
											<option value="2017">2017</option>
											<option value="2018">2018</option>
											<option value="2019">2019</option>
											<option value="2020">2020</option>
											<option value="2021">2021</option>
											<option value="2022">2022</option>
											<option value="2023">2023</option>
										</select>
								</label>
							</li>
                        </ul>
                  </div>                   
                </div>
              </li>
              <li class="current">
                <h6>Order review</h6>
                <div class="row">
                   <div class="span6 content-wrapper ">
                        <ul class="rr  cart">
						 <table>
							  <tr class="headers">
								<th class="alpha50 dark">							  
								  Product Name
								</th>
								<th class="alpha16">
								  Quantity
								</th>
								<th class="alpha16">
								  Price
								</th>
							  </tr>
							  <tr>
								<td class="article clearfix">
								 
									<h2>Men glass mode 2012</h2>
								</td>
								<td class="quantity dark">
								
								  <div class="quant-input">
									<div class="arrows">
									  <div class="arrow plus gradient"><span class="ir">Plus</span></div>
									  <div class="arrow minus gradient"><span class="ir">Minus</span></div>
									</div>
									<input type="text" value="2"/>
								  </div>
								  
								</td>
								<td class="price dark">
								
								  <span class="currency">$</span><span class="value">600</span>
								
								</td>
							  </tr>
							  
							  <tr>
								<td colspan="2" class="empty">
								</td>
								<td colspan="2" class="total-wrapper">
								
								  <div class="vat clearfix">
									<div class="half-col">
									  VAT
									</div>
									<div class="half-col">
									  <span class="value">10</span>%
									</div>
									<div class="half-col">
									  Shipping Price
									</div>
									<div class="half-col">
									  <span class="value">$5.00</span>
									</div>
								  </div>
								  
								  <div class="total clearfix">
									<div class="half-col">
									  Total
									</div>
									<div class=" value-wrapper">
									  
									  <span class="currency">$</span><span class="value">880</span>
									  
									</div>
								  </div>
								
								</td>
							  </tr>
							</table>
							<div class="row-fluid checkout">
							  <div class="span4">
								<a href="#" class="btn"><span class="gradient">Place Order</span></a>
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