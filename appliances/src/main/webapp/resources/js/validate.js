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