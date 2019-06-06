Editorial.CRM.PersonInfo.validate = function() {
	var flag = true;
	if (!Editorial.CRM.PersonInfo.validatePersonEmailDefaultFlg()) {
		flag = false;
	}
	if (!Editorial.CRM.PersonInfo.validatePersonEmailAddress()) {
		flag = false;
	}
	return flag;
};

function validateEmail(email){
	var reg = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/;
	if(reg.test(email)){
		return true;
	} 
	return false;
}

Editorial.CRM.PersonInfo.validatePersonEmailDefaultFlg = function() {
	if ($("#personEmailDefaultFlg").val() == "") {
		$("#defaultFlgDiv").addClass("error");
		$("#defaultFlgSpan").html("请选择该邮箱是否为主邮箱！");
		return false;
	}
	$("#defaultFlgDiv").removeClass("error").addClass("success");
	$("#defaultFlgSpan").html("通过验证");
	return true;
};


Editorial.CRM.PersonInfo.validatePersonEmailAddress = function() {
	if ($("#personEmailAddress").val().trim() == "") {
		$("#addressDiv").addClass("error");
		$("#addressSpan").html("邮箱地址不能为空！");
		return false;
	} else if(!validateEmail($("#personEmailAddress").val())) {
		$("#addressDiv").addClass("error");
		$("#addressSpan").html("邮箱格式不正确，请正确填写！");
		return false;
	}
	$("#addressDiv").removeClass("error").addClass("success");
	$("#addressSpan").html("通过验证");
	return true;
};




Editorial.CRM.PersonInfo.showResponse = function(response, statusText) {
	if (response.isSuccess == "true") {
		ajaxAlertSuccessMsg(response.msg, true);
		refreshCustomPropertyDataTable("cp1");
		autoCloseCommonModal(5);
	} else {
		ajaxAlertErrorMsg(response.msg, true);
		Editorial.CRM.PersonInfo.enableAllButton();
	}
};

Editorial.CRM.PersonInfo.disableAllButton = function() {
	$("#save").attr('disabled', "true");
	$("#reset").attr('disabled', "true");
};

Editorial.CRM.PersonInfo.enableAllButton = function() {
    $("#save").removeAttr('disabled');
    $("#reset").removeAttr('disabled');
};

$(function() {

	var options = {
	 beforeSubmit : Editorial.CRM.PersonInfo.validate,
		success : Editorial.CRM.PersonInfo.showResponse,
		url : $('#ctx').val() + '/pages/crmPersonEmail/form/editSubmit',
		type : 'post',
		clearForm : false,
		timeout : 3000
	};
	$('#personEmailform').ajaxForm(options);
});























