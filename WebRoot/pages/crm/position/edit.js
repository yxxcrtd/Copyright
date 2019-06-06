

/*************************************************************************************/


Editorial.Material.validate = function() {
	var flag = true;
	
	if (!Editorial.Material.validatePositionCode()) {
		flag = false;
	}
	
	if (!Editorial.Material.validatePositionName()) {
		flag = false;
	}
	
	return flag;
};

Editorial.Material.validatePositionCode = function() {
	if ($("#position_code").val().trim() == "") {
		$("#position_code_div").addClass("error");
		$("#position_code_span").html("岗位编号不能为空！");
		return false;
	}
	$("#position_code_div").removeClass("error").addClass("success");
	$("#position_code_span").html("通过验证");
	return true;
};

Editorial.Material.validatePositionName = function() {
	if ($("#position_name").val().trim() == "") {
		$("#position_name_div").addClass("error");
		$("#position_name_span").html("岗位名称不能为空！");
		return false;
	}
	$("#position_name_div").removeClass("error").addClass("success");
	$("#position_name_span").html("通过验证");
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
		url : $('#ctx').val() + "/pages/crmPosition/form/editSubmit",
		type : 'post',
		clearForm : false,
		timeout : 3000
	};
	$("#crmPositionForm").ajaxForm(options);
});

Editorial.Material.disableAllButton = function() {
	$("#save").attr('disabled', "true");
	$("#reset").attr('disabled', "true");
};

Editorial.Material.enableAllButton = function() {
    $("#save").removeAttr('disabled');
    $("#reset").removeAttr('disabled');
};