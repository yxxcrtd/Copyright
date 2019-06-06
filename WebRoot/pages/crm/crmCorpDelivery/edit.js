

/*************************************************************************************/


Editorial.Material.validate = function() {
	var flag = true;
	
	if (!Editorial.Material.validateDeliveryCorpName()) {
		flag = false;
	}
	
	if (!Editorial.Material.validateDeliveryCorpAddress()) {
		flag = false;
	}
	
	if (!Editorial.Material.validateDeliveryReceiverName()) {
		flag = false;
	}
	
	if (!Editorial.Material.validateDeliveryTel()) {
		flag = false;
	}
	
	if (!Editorial.Material.validateDeliveryFax()) {
		flag = false;
	}
	
	return flag;
};

Editorial.Material.validateDeliveryCorpName = function() {
	if ($("#delivery_corpName").val().trim() == "") {
		$("#delivery_corpName_div").addClass("error");
		$("#delivery_corpName_span").html("收货单位不能为空！");
		return false;
	}
	$("#delivery_corpName_div").removeClass("error").addClass("success");
	$("#delivery_corpName_span").html("通过验证");
	return true;
};

Editorial.Material.validateDeliveryCorpAddress = function() {
	if ($("#delivery_corpAddress").val().trim() == "") {
		$("#delivery_corpAddress_div").addClass("error");
		$("#delivery_corpAddress_span").html("收货地址不能为空！");
		return false;
	}
	$("#delivery_corpAddress_div").removeClass("error").addClass("success");
	$("#delivery_corpAddress_span").html("通过验证");
	return true;
};

Editorial.Material.validateDeliveryReceiverName = function() {
	if ($("#delivery_receiverName").val().trim() == "") {
		$("#delivery_receiverName_div").addClass("error");
		$("#delivery_receiverName_span").html("收货联系人不能为空！");
		return false;
	}
	$("#delivery_receiverName_div").removeClass("error").addClass("success");
	$("#delivery_receiverName_span").html("通过验证");
	return true;
};

Editorial.Material.validateDeliveryTel = function() {
	if ($("#delivery_tel").val().trim() == "") {
		$("#delivery_tel_div").addClass("error");
		$("#delivery_tel_span").html("收货联系电话不能为空！");
		return false;
	}
	$("#delivery_tel_div").removeClass("error").addClass("success");
	$("#delivery_tel_span").html("通过验证");
	return true;
};

Editorial.Material.validateDeliveryFax = function() {
	if ($("#delivery_fax").val().trim() == "") {
		$("#delivery_fax_div").addClass("error");
		$("#delivery_fax_span").html("收货联系传真不能为空！");
		return false;
	}
	$("#delivery_fax_div").removeClass("error").addClass("success");
	$("#delivery_fax_span").html("通过验证");
	return true;
};

Editorial.Material.showResponse = function(response, statusText) {
	Editorial.Material.disableAllButton();
	if (response.isSuccess == "true") {
		ajaxAlertSuccessMsg(response.msg, true);
		refreshCustomPropertyDataTable("cp1");
		autoCloseCommonModal(5);
	} else {
		ajaxAlertErrorMsg(response.msg, true);
		Editorial.Material.enableAllButton();
	}
};

$(function() {
	var options = {
		beforeSubmit : Editorial.Material.validate,
		success : Editorial.Material.showResponse,
		url : $('#ctx').val() + "/pages/crmCorpDelivery/form/editSubmit",
		type : 'post',
		clearForm : false,
		timeout : 3000
	};
	$("#crmCorpDeliveryForm").ajaxForm(options);
});

Editorial.Material.disableAllButton = function() {
	$("#save").attr('disabled', "true");
	$("#reset").attr('disabled', "true");
};

Editorial.Material.enableAllButton = function() {
    $("#save").removeAttr('disabled');
    $("#reset").removeAttr('disabled');
};