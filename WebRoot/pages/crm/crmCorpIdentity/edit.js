

/*************************************************************************************/


Editorial.Material.validate = function() {
	var flag = true;
	
	if (!Editorial.Material.validateIdentityType()) {
		flag = false;
	}
	
	if (!Editorial.Material.validateIdentityDefaultFlg()) {
		flag = false;
	}
	
	return flag;
};

Editorial.Material.validateIdentityType = function() {
	if ($("#identity_type").val().trim() == "") {
		$("#identity_type_div").addClass("error");
		$("#identity_type_span").html("标识分类不能为空！");
		return false;
	}
	$("#identity_type_div").removeClass("error").addClass("success");
	$("#identity_type_span").html("通过验证");
	return true;
};

Editorial.Material.validateIdentityDefaultFlg = function() {
	if ($("#identity_defaultFlg").val().trim() == "") {
		$("#identity_defaultFlg_div").addClass("error");
		$("#identity_defaultFlg_span").html("请选择是否主标识！");
		return false;
	}
	$("#identity_defaultFlg_div").removeClass("error").addClass("success");
	$("#identity_defaultFlg_span").html("通过验证");
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
		url : $('#ctx').val() + "/pages/crmCorpIdentity/form/editSubmit",
		type : 'post',
		clearForm : false,
		timeout : 3000
	};
	$("#crmCorpIdentityForm").ajaxForm(options);
});

Editorial.Material.disableAllButton = function() {
	$("#save").attr('disabled', "true");
	$("#reset").attr('disabled', "true");
};

Editorial.Material.enableAllButton = function() {
    $("#save").removeAttr('disabled');
    $("#reset").removeAttr('disabled');
};