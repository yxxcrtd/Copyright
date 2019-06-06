

/*************************************************************************************/


Editorial.Material.validate = function() {
	var flag = true;
	
	if (!Editorial.Material.validatePhoneType()) {
		flag = false;
	}
	
	if (!Editorial.Material.validatePhoneDefaultFlg()) {
		flag = false;
	}
	
	if (!Editorial.Material.validatePhoneCountry()) {
		flag = false;
	}
	
	if (!Editorial.Material.validatePhoneNo()) {
		flag = false;
	}
	
	return flag;
};

Editorial.Material.validatePhoneType = function() {
	if ($("#phone_type").val().trim() == "") {
		$("#phone_type_div").addClass("error");
		$("#phone_type_span").html("电话分类不能为空！");
		return false;
	}
	$("#phone_type_div").removeClass("error").addClass("success");
	$("#phone_type_span").html("通过验证");
	return true;
};

Editorial.Material.validatePhoneDefaultFlg = function() {
	if ($("#phone_defaultFlg").val().trim() == "") {
		$("#phone_defaultFlg_div").addClass("error");
		$("#phone_defaultFlg_span").html("请选择是否主要电话！");
		return false;
	}
	$("#phone_defaultFlg_div").removeClass("error").addClass("success");
	$("#phone_defaultFlg_span").html("通过验证");
	return true;
};

Editorial.Material.validatePhoneCountry = function() {
	if ($("#phone_country").val().trim() == "") {
		$("#phone_country_div").addClass("error");
		$("#phone_country_span").html("国家不能为空！");
		return false;
	}
	$("#phone_country_div").removeClass("error").addClass("success");
	$("#phone_country_span").html("通过验证");
	return true;
};

Editorial.Material.validatePhoneNo = function() {
	if ($("#phone_no").val().trim() == "") {
		$("#phone_no_div").addClass("error");
		$("#phone_no_span").html("号码不能为空！");
		return false;
	}
	$("#phone_no_div").removeClass("error").addClass("success");
	$("#phone_no_span").html("通过验证");
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
		url : $('#ctx').val() + "/pages/crmCorpPhone/form/editSubmit",
		type : 'post',
		clearForm : false,
		timeout : 3000
	};
	$("#crmCorpPhoneForm").ajaxForm(options);
});

Editorial.Material.disableAllButton = function() {
	$("#save").attr('disabled', "true");
	$("#reset").attr('disabled', "true");
};

Editorial.Material.enableAllButton = function() {
    $("#save").removeAttr('disabled');
    $("#reset").removeAttr('disabled');
};