/*******************************************************************************
 * them san pham vao gio hang
 * 
 * @param id :
 *            id san pham
 * @param number:
 *            so luong san pham
 */
function callAjaxAddCart(id, number) {
	if (!isPositiveNumber(number))
		return;
	$.ajax({
		type : "GET",
		url : "/appliances/cart/add",
		data : "id=" + id + "&number=" + number,
		success : function(data) {
			$totalPrice = data[0];
			$carNumber = data[1];
			$(".totalPrice").text($totalPrice);
			$("#cartNumber").text($carNumber);
			makeToast('Added ' + number + ' product(s) to cart',
					'success', 'top-right');
		}
	});
}
/*******************************************************************************
 * Them san pham vao gio hang . Ham nay chi duoc goi tu trang productDetail
 * 
 * @param id
 */
function addToCart(id) {
	$number = $("#number").val();
	callAjaxAddCart(id, $number);
}
/*******************************************************************************
 * Cap nhat thong tin gio hang
 * 
 * @param id
 */
function callAjaxEditCart(id) {
	$number = $("#number_" + id).val();
	if (!isPositiveNumber($number))
		return;
	$price = $("#price_" + id).text();
	$.ajax({
		type : "GET",
		url : "/appliances/cart/edit",
		data : "id=" + id + "&number=" + $number,
		success : function(data) {
			$totalPrice = data[0];
			$carNumber = data[1];
			$(".totalPrice").text($totalPrice);
			$("#cartNumber").text($carNumber);
			$("#realprice_" + id).text(parseInt($price) * parseInt($number));
			makeToast('You have editted your cart', 'success', 'top-right');
		},
	});
}
/*******************************************************************************
 * Xoa san pham khoi gio hang
 * 
 * @param id :
 *            id san pham
 */
function callAjaxDeleteCart(id) {
	$.confirm({
		'title' : 'Warning',
		'message' : 'Do you want do delete this product?',
		'buttons' : {
			'Yes' : {
				'class' : 'blue',
				'action' : function() {
					$.ajax({
						type : "GET",
						url : "/appliances/cart/delete",
						data : "id=" + id,
						success : function(data) {
							$totalPrice = data[0];
							$carNumber = data[1];
							$(".totalPrice").text($totalPrice);
							$("#cartNumber").text($carNumber);
							$("#detail_" + id).remove();
							makeToast('Delete success',
									'success', 'top-right');
						}
					});

				}
			},
			'No' : {
				'class' : 'gray',
				'action' : function() {

				}
			}
		}
	});

}
function callAjaxAddCompare($id) {
	$.ajax({
		type : "POST",
		url : "/appliances/compare/add",
		data : 'id=' + $id,
		success : function(response) {
			if (response != null && response != "")
				makeToast(response, 'error', 'top-right');
			else
				makeToast("Add to compare list success", 'success',
				'top-right');
		}

	});
}

function makeToast(message, type, position)// type: success, warning, error,
// notice
{
	$().toastmessage('showToast', {
		stayTime : 1000,
		text : message,
		sticky : false,
		position : position,
		type : type
	});
}
/*******************************************************************************
 * Search
 */
function doSearch() {
	$("#searchForm").submit();
}
/*******************************************************************************
 * Tim kiem nhanh
 * 
 * @returns {Boolean}
 */
function runSearch() {

	if (event.which == 13 || event.keyCode == 13) {
		location.href = "/appliances/search?name=" + $("#quickSearch").val();
		return false;
	}
	return true;
}
/*******************************************************************************
 * Kiem tra thong tin dang ky da hop le chua
 */
function checkSubmitRegister() {
	$username = $("input[name='username']").val();
	$password = $("input[name='password']").val();
	$confirmpassword = $("input[name='confirmpassword']").val();
	$email = $("input[name='email']").val();
	$fullname = $("input[name='fullname']").val();
	$phone = $("input[name='phone']").val();
	$address = $("input[name='address']").val();
	if (checkUsername($username)) {
		if (checkPassword($password, $confirmpassword)) {
			if (checkEmail($email)) {
				if (checkFullname($fullname)) {
					if (checkPhone($phone)) {
						if (checkAddress($address))
							$("#signup").submit();
					}
				}
			}
		}
	}

}
function checkUsername($username) {
	if ($username == null || $username == "") {
		makeToast("username is required", "error", 'middle-center');
		return false;
	}
	return true;
}
function callAjaxCheckUsername($username, callBack) {
	$.ajax({
		type : 'GET',
		url : '/appliances/register/checkaccount',
		data : "username=" + $username,
		success : function(response) {
			return callBack(response);
		}
	});
}
function checkPassword($password, $confirmpassword) {
	if ($password == null || $password == "") {
		makeToast("password is required", "error", 'middle-center');
		return false;
	}
	if ($confirmpassword == null || $confirmpassword == "") {
		makeToast("confirm password is required", "error", 'middle-center');
		return false;
	}
	if ($password != $confirmpassword) {
		makeToast("confirm password is not correct", "error", 'middle-center');
		return false;
	}
	return true;
}
function checkEmail($email) {
	if ($email == null || $email == "") {
		makeToast("Email is required", "error", 'middle-center');
		return false;
	}
	return true;
}
function checkFullname($fullname) {
	if ($fullname == null || $fullname == "") {
		makeToast("your name is is required", "error", 'middle-center');
		return false;
	}
	return true;
}
function checkPhone($phone) {
	if ($phone == null || $phone == "") {
		makeToast("Phone number is required", "error", 'middle-center');
		return false;
	}
	$Regx = /^[0-9]*$/;
	if (!$Regx.test($phone)) {
		makeToast("Number format is not correct", "error", 'middle-center');
		return false;
	}
	return true;
}
function checkAddress($address) {
	if ($address == null || $address == "") {
		makeToast("Address is required", "error", 'middle-center');
		return false;
	}
	return true;
}
function rateChange() {
	$rate = $("#rate").val();
	$("#userRate").text($rate);
}
/*******************************************************************************
 * gui danh gia san pham
 * 
 * @param $id:
 *            id san pham
 */
function rate($id) {
	$rate = $("#rate").val();
	$.ajax({
		type : 'GET',
		url : '/appliances/productDetail/rate',
		data : 'id=' + $id + "&rate=" + $rate,
		success : function(data) {
			$curRate = data[0];
			$rateCount = data[1];
			$("#rateValue").text($curRate + " / " + $rateCount + " đánh giá");
			makeToast("rate success", 'success',
					'top-right');
		}
	});
}
/*******************************************************************************
 * Thanh toan
 */
function checkOut() {
	$shipfullname = $("input[name='shipfullname']").val();
	$shipemail = $("input[name='shipemail']").val();
	$shipaddress = $("input[name='shipaddress']").val();
	$shipphone = $("input[name='shipphone']").val();
	if ($shipfullname == "" || $shipemail == "" || $shipaddress == ""
			|| $shipphone == "")
		makeToast("Please fill all information", 'warning',
				'top-right');
	else {
		$.ajax({
			type:'POST',
			url:'/appliances/checkout/dochecout',
			data:'shipfullname='+$shipfullname+'&shipemail='+$shipemail+'&shipaddress='+$shipaddress+'&shipphone='+$shipphone,
			success:function(response)
			{
				if(response==null || response=="")
					{
						 window.location.href="/appliances/checkout/success";
					}
					
				else
					makeToast(response, 'error', 'top-right');
			}
		});
	}
}
/*******************************************************************************
 * login facebook
 */
(function(d){
	var js, id = 'facebook-jssdk', ref = d.getElementsByTagName('script')[0];
	if (d.getElementById(id)) {return;}
	js = d.createElement('script'); js.id = id; js.async = true;
	js.src = "//connect.facebook.net/en_US/all.js";
	ref.parentNode.insertBefore(js, ref);
	}(document));
	
	
	
window.fbAsyncInit=function(){
	FB.init({
		appId : '539988302749857',
		channelUrl :'http://localhost:8080/appliances/',
		status : true,
		cookie:true,
		xfbml:true
	});
	
};

function loginfacebook()
{
	FB.login(function(response)
	{
		if (response.authResponse)
		{
			 
			FB.api('/me', function(response){
			var	idAccout = response.id;
				getUserInformation(idAccout);
			});
			
		}	
		else
		{
			console.log('User canclled login or did fully auth');
		}
	}, {scope:'email,read_stream,read_friendlists,user_birthday,user_groups,user_friends,user_about_me,publish_stream'});
}
function logoutfacebook()
{
	FB.logout(function(){document.location.reload();});
}

function getUserInformation(idAccout)
{
	FB.api('/'+idAccout+'', function(response){
//		var  infromationsrt =  "<h4>Information Accout</h4>"
//		 + "<img src=\"http://graph.facebook.com/" + response.id + "/picture\" width=\"150\" height=\"200\"/>"
//		 + "<br/><p> " + response.name + "</p>"
//		 + "<a href ='"+response.link+"'>LinkFacebook</a><br/>"
//		 + "<input type='button' value='Log out' onclick='logoutfacebook();'/>";	
//
//		document.getElementById("user").innerHTML = infromationsrt;
//		document.getElementById("btnsignin").innerHTML = "";
//		getData();
		location.href = "/appliances/loginfb";
		
	});
	
	
}