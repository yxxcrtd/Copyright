Editorial.Settlement.validate = function() {
	var flag = true;
	if (!Editorial.Settlement.UplaodtxtFile()) {
		flag = false;
	}
	return flag;
};

Editorial.Settlement.UplaodtxtFile = function() {
	if ($("#txtFile").val() == "") {
		$("#txtFileDiv").addClass("error");
		$("#txtFileSpan").html("上传文件不能为空！");
		return false;
	}else{
		$("#txtFileDiv").removeClass("error").addClass("success");
		$("#txtFileSpan").html("通过验证");
		return true;
	}
};

Editorial.Settlement.disableAllButton = function() {
	$("#save").attr('disabled', "true");
	$("#reset").attr('disabled', "true");
};

Editorial.Settlement.enableAllButton = function() {
	$("#save").attr('disabled', "false");
	$("#reset").attr('disabled', "false");
};

Editorial.Settlement.showResponse = function(response, statusText) {
	Editorial.Settlement.disableAllButton();
	if (response.isSuccess == "true") {
		ajaxAlertSuccessMsg(response.msg, true);
		refreshFrameDataTableInLayer('Editorial.Settlement.oTable1');
		autoCloseCommonModal(5);
	} else {
		ajaxAlertErrorMsg(response.msg, true);
		Editorial.Settlement.enableAllButton();
	}
};

$(function() {
	var options = {
		beforeSubmit:Editorial.Settlement.validate,
		success : Editorial.Settlement.showResponse,
		url :  $('#ctx').val()+'/pages/settlement/form/add',
		type : 'post',
		clearForm : false,
		timeout : 3000
	};
	$('#CrSettlementForm').ajaxForm(options);
});