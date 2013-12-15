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
			makeToast(
					'Đã thêm ' + number + ' sản phẩm vào giỏ hàng',
					'success');
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
			makeToast('Bạn đã cập nhật giỏ hàng', 'success');
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
							$
									.ajax({
										type : "GET",
										url : "/appliances/cart/delete",
										data : "id=" + id,
										success : function(data) {
											$totalPrice = data[0];
											$carNumber = data[1];
											$(".totalPrice").text($totalPrice);
											$("#cartNumber").text($carNumber);
											$("#detail_" + id).remove();
											makeToast(
													'Đã xóa sản phẩm khỏi giỏ hàng',
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
function callAjaxAddCompare(id) {
	$.ajax({
		type : "POST",
		url : "/appliances/compare/add",
		date : "id=" + id,
		success : function(response) {

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
/*******************************************************************************
 * Search
 */
function doSearch() {
	$("#searchForm").submit();
}

function runSearch() {
	
	if (event.which == 13 || event.keyCode == 13) {
		location.href ="/appliances/search?name="+$("#quickSearch").val();
		return false;
	}
	return true;
}
