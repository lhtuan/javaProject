function callAjaxEditCart(id) {
	var number = $("#number_" + id).val();
	var price = $("#price_" + id).text();
	$.ajax({
		type : "GET",
		url : "/appliances/cart/edit",
		data : "id=" + id + "&number=" + number,
		success : function(data) {
			var totalPrice = data[0];
			var carNumber = data[1];
			$(".totalPrice").text(totalPrice);
			$("#cartNumber").text(carNumber);
			$("#realprice_" + id).text(parseInt(price) * parseInt(number));
		},
	});
}
function callAjaxDelete(id) {
	$.confirm({
        'title'		: 'Thông báo',
        'message'	: 'Bạn có chắc muốn xóa sản phẩm ra khỏi giỏ hàng?',
        'buttons'	: {
            'Yes'	: {
                'class'	: 'blue',
                'action': function(){
                    $.ajax({
                    	type:"GET",
                    	url:"/appliances/cart/delete?id="+id,
                    	success : function(data)
                    	{
                    		var totalPrice = data[0];
                			var carNumber = data[1];
                			$(".totalPrice").text(totalPrice);
                			$("#cartNumber").text(carNumber);
                    		$("#detail_"+id).remove();
                    	}
                    });
                    
                }
            },
            'No'	: {
                'class'	: 'gray',
                'action': function(){
                	
                }	
            }
        }
    });

}
