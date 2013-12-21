<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>
      <div role="main" class="container contact">        
        <div class="row">
        
          <div class="span5">
            <h1>Liên hệ với chúng tôi</h1>
            
            <form action="" method="post" class="clearfix">
              <label style="padding-left: 0px;">
                <input class="text-input" type="text" name="name" placeholder="Họ tên..."/>
              </label>
              <label style="padding-left: 0px;">
                <input class="text-input" type="text" name="email" placeholder="Email..."/>
              </label>
              <textarea  style="margin-top: 30px;" class="text-input" name="comment" placeholder="Lời nhắn của bạn...">Lời nhắn của bạn...</textarea>
              <!-- <input type="button" value="Gửi"> -->
              <div class="span3">
						<a href="javaScript:sendContact()" class="btn"><span class="gradient">Gửi</span></a>
					</div>
            </form>
          </div>
          
          <div class="span6 offset1">
            <h1>Bản đồ</h1>
            
            <figure class="map">
              <div class="wrapper">
                <div id="map-canvas">
                </div>
                
              </div>
            </figure>
          </div>
        
        </div> 
        
        <div class="row top-spacing">
          <div class="span5">
          
            <h1>Địa chỉ chi nhánh</h1>
            
            <p>
              Trường ĐH Khoa học Tự nhiên, Nguyễn Văn Cừ, phường 4, Quận 5, Hồ Chí Minh, Việt Nam 
            </p>
          
          </div>
          
          <div class="span6 offset1">
            
            <h1>Thông tin liên hệ</h1>
            
            <p>
              Trường ĐH Khoa học Tự nhiên, Nguyễn Văn Cừ, phường 4, Quận 5, Hồ Chí Minh, Việt Nam
            </p>
            
            <ul class="rr info clearfix">
              <li>
                Phone: <span class="val">888.588.688</span>
              </li>
               <li>
                Email: <span class="val">contact@companyname.com</span>
              </li>
              <li>
                Fax: <span class="val">0123.456.789</span>
              </li>             
              <li>
                Web: <span class="val">www.companyname.com</span>
              </li>
            </ul>
            
          </div>
        </div>
      </div>    