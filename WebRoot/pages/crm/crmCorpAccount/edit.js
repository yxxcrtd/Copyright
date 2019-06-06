

/*************************************************************************************/


Editorial.Material.validate = function() {
	var flag = true;
	
	if (!Editorial.Material.validateAccountTerm()) {
		flag = false;
	}
	
	if (!Editorial.Material.validateAccountType()) {
		flag = false;
	}
	
	if (!Editorial.Material.validateAccountLevel()) {
		flag = false;
	}
	
	if (!Editorial.Material.validateAccountCurrency()) {
		flag = false;
	}
	
	if (!Editorial.Material.validateAccountAdvanceAmount()) {
		flag = false;
	}
	
	return flag;
};

Editorial.Material.validateAccountTerm = function() {
	if ($("#account_term").val().trim() == "") {
		$("#account_term_div").addClass("error");
		$("#account_term_span").html("账期不能为空！");
		return false;
	}
	$("#account_term_div").removeClass("error").addClass("success");
	$("#account_term_span").html("通过验证");
	return true;
};

Editorial.Material.validateAccountType = function() {
	if ($("#account_type").val().trim() == "") {
		$("#account_type_div").addClass("error");
		$("#account_type_span").html("账户类型不能为空！");
		return false;
	}
	$("#account_type_div").removeClass("error").addClass("success");
	$("#account_type_span").html("通过验证");
	return true;
};

Editorial.Material.validateAccountLevel = function() {
	if ($("#account_level").val().trim() == "") {
		$("#account_level_div").addClass("error");
		$("#account_level_span").html("重要程度不能为空！");
		return false;
	}
	$("#account_level_div").removeClass("error").addClass("success");
	$("#account_level_span").html("通过验证");
	return true;
};

Editorial.Material.validateAccountCurrency = function() {
	if ($("#account_currency").val().trim() == "") {
		$("#account_currency_div").addClass("error");
		$("#account_currency_span").html("默认币种不能为空！");
		return false;
	}
	$("#account_currency_div").removeClass("error").addClass("success");
	$("#account_currency_span").html("通过验证");
	return true;
};

Editorial.Material.validateAccountAdvanceAmount = function() {
	if ($("#account_advanceAmount").val().trim() == "") {
		$("#account_advanceAmount_div").addClass("error");
		$("#account_advanceAmount_span").html("账户余额不能为空！");
		return false;
	}
	$("#account_advanceAmount_div").removeClass("error").addClass("success");
	$("#account_advanceAmount_span").html("通过验证");
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
		url : $('#ctx').val() + "/pages/crmCorpAccount/form/editSubmit",
		type : 'post',
		clearForm : false,
		timeout : 3000
	};
	$("#crmCorpAccountForm").ajaxForm(options);
});

Editorial.Material.disableAllButton = function() {
	$("#save").attr('disabled', "true");
	$("#reset").attr('disabled', "true");
};

Editorial.Material.enableAllButton = function() {
    $("#save").removeAttr('disabled');
    $("#reset").removeAttr('disabled');
};