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
			makeToast('Ä�Ã£ thÃªm ' + number + ' sáº£n pháº©m vÃ o giá»� hÃ ng',
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
			makeToast('Báº¡n Ä‘Ã£ cáº­p nháº­t giá»� hÃ ng', 'success', 'top-right');
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
		'title' : 'ThÃ´ng bÃ¡o',
		'message' : 'Báº¡n cÃ³ cháº¯c muá»‘n xÃ³a sáº£n pháº©m khá»�i giá»� hÃ ng?',
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
							makeToast('Ä�Ã£ xÃ³a sáº£n pháº©m khá»�i giá»� hÃ ng',
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
				makeToast("Đã thêm vào danh sách so sánh", 'success',
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
		makeToast("Báº¡n chÆ°a Ä‘iá»�n tÃªn Ä‘Äƒng nháº­p", "error", 'middle-center');
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
		makeToast("Báº¡n chÆ°a Ä‘iá»�n máº­t kháº©u", "error", 'middle-center');
		return false;
	}
	if ($confirmpassword == null || $confirmpassword == "") {
		makeToast("Báº¡n chÆ°a xÃ¡c máº­t kháº©u", "error", 'middle-center');
		return false;
	}
	if ($password != $confirmpassword) {
		makeToast("xÃ¡c nháº­n máº­t kháº©u khÃ´ng chÃ­nh xÃ¡c", "error", 'middle-center');
		return false;
	}
	return true;
}
function checkEmail($email) {
	if ($email == null || $email == "") {
		makeToast("Báº¡n chÆ°a nháº­p email", "error", 'middle-center');
		return false;
	}
	return true;
}
function checkFullname($fullname) {
	if ($fullname == null || $fullname == "") {
		makeToast("Báº¡n chÆ°a nháº­p há»� tÃªn", "error", 'middle-center');
		return false;
	}
	return true;
}
function checkPhone($phone) {
	if ($phone == null || $phone == "") {
		makeToast("Báº¡n chÆ°a nháº­p sá»‘ Ä‘iá»‡n thoáº¡i", "error", 'middle-center');
		return false;
	}
	$Regx = /^[0-9]*$/;
	if (!$Regx.test($phone)) {
		makeToast("Sá»‘ Ä‘iá»‡n thoáº¡i khÃ´ng há»£p lá»‡", "error", 'middle-center');
		return false;
	}
	return true;
}
function checkAddress($address) {
	if ($address == null || $address == "") {
		makeToast("Báº¡n chÆ°a Ä‘iá»�n Ä‘á»‹a chá»‰", "error", 'middle-center');
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
			$("#rateValue").text($curRate + " / " + $rateCount + " Ä‘Ã¡nh giÃ¡");
			makeToast("Ä�Ã¡nh giÃ¡ cá»§a báº¡n Ä‘Ã£ Ä‘Æ°á»£c ghi nháº­n", 'success',
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
		makeToast("Vui lÃ²ng Ä‘iá»�n Ä‘á»§ thÃ´ng tin giao hÃ ng", 'warning',
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
