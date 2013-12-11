function callAjaxAddCart(id, number) {
	if (!isPositiveNumber(number))
		return;
	$
			.ajax({
				type : "GET",
				url : "/appliances/cart/add",
				data : "id=" + id + "&number=" + number,
				success : function(data) {
					$totalPrice = data[0];
					$carNumber = data[1];
					$(".totalPrice").text($totalPrice);
					$("#cartNumber").text($carNumber);
					makeToast('Đã thêm ' + number + ' sản phẩm vào giỏ hàng',
							'success');
				}
			});
}
function addToCart(id) {
	$number = $("#number").val();
	callAjaxAddCart(id, $number);
}

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
			makeToast('Bạn đã cập nhật giỏ hàng', 'success');
		},
	});
}
function callAjaxDeleteCart(id) {
	$.confirm({
		'title' : 'Thông báo',
		'message' : 'Bạn có chắc muốn xóa sản phẩm ra khỏi giỏ hàng?',
		'buttons' : {
			'Yes' : {
				'class' : 'blue',
				'action' : function() {
					$.ajax({
						type : "GET",
						url : "/appliances/cart/delete?id=" + id,
						success : function(data) {
							$totalPrice = data[0];
							$carNumber = data[1];
							$(".totalPrice").text($totalPrice);
							$("#cartNumber").text($carNumber);
							$("#detail_" + id).remove();
							makeToast('Đã xóa sản phẩm khỏi giỏ hàng',
									'success');
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
function makeToast(message, type)// type: success, warning, error, notice
{
	$().toastmessage('showToast', {
		stayTime : 1000,
		text : message,
		sticky : false,
		position : 'top-right',
		type : type
	});
}
