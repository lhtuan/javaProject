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
			makeToast('Đã thêm ' + number + ' sản phẩm vào giỏ hàng',
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
			makeToast('Bạn đã cập nhật giỏ hàng', 'success', 'top-right');
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
		'title' : 'Thông báo',
		'message' : 'Bạn có chắc muốn xóa sản phẩm khỏi giỏ hàng?',
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
							makeToast('Đã xóa sản phẩm khỏi giỏ hàng',
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
function callAjaxAddCompare(id) {
	$.ajax({
		type : "POST",
		url : "/appliances/compare/add",
		date : "id=" + id,
		success : function(response) {
			if(response)
				makeToast("Đã thêm vào danh sách so sánh", 'success', 'top-right');
			else
				makeToast("Danh sách đầy", 'error', 'top-right');
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
		makeToast("Bạn chưa điền tên đăng nhập", "error", 'middle-center');
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
		makeToast("Bạn chưa điền mật khẩu", "error", 'middle-center');
		return false;
	}
	if ($confirmpassword == null || $confirmpassword == "") {
		makeToast("Bạn chưa xác mật khẩu", "error", 'middle-center');
		return false;
	}
	if ($password != $confirmpassword) {
		makeToast("xác nhận mật khẩu không chính xác", "error", 'middle-center');
		return false;
	}
	return true;
}
function checkEmail($email) {
	if ($email == null || $email == "") {
		makeToast("Bạn chưa nhập email", "error", 'middle-center');
		return false;
	}
	return true;
}
function checkFullname($fullname) {
	if ($fullname == null || $fullname == "") {
		makeToast("Bạn chưa nhập họ tên", "error", 'middle-center');
		return false;
	}
	return true;
}
function checkPhone($phone) {
	if ($phone == null || $phone == "") {
		makeToast("Bạn chưa nhập số điện thoại", "error", 'middle-center');
		return false;
	}
	$Regx = /^[0-9]*$/;
	if (!$Regx.test($phone)) {
		makeToast("Số điện thoại không hợp lệ", "error", 'middle-center');
		return false;
	}
	return true;
}
function checkAddress($address) {
	if ($address == null || $address == "") {
		makeToast("Bạn chưa điền địa chỉ", "error", 'middle-center');
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
			makeToast("Đánh giá của bạn đã được ghi nhận", 'success',
					'top-right');
		}
	});
}

