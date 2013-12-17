function onInputChange(evt) {
	var charCode = (evt.which) ? evt.which : event.keyCode;
	if (charCode > 31 && (charCode < 48 || charCode > 57))
		return false;
	return true;
}
function isPositiveNumber(number) {
	if (number > 0)
		return true;
	makeToast('Vui lòng chọn số nguyên dương',
	'notice');
	return false;
}
/*******************************************************************************
 * Thay doi so luong san pham 1 trang
 */
function changeProductPerPage(controller) {
	var productPerPage = $("#productPerPage").val();
	if (productPerPage != null && productPerPage != "") {
		if (isPositiveNumber(productPerPage))
			location.href="/appliances/"+controller+"?isKeepProduct=true&productPerPage="+productPerPage;
	}
}