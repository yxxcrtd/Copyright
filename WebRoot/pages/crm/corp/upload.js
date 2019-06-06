var corpSpace = {};

corpSpace.enableAllButton = function() {
	$("#save").removeAttr("disabled");
	$("#reset").removeAttr("disabled");
}

corpSpace.disableAllButton = function() {
	$("#save").attr("disabled", "true");
	$("#reset").attr("disabled", "true");
}

corpSpace.validate_excelFile = function() {
	if ($("#excelFile").val() == "") {
		$("#excelFile_div").removeClass("success").addClass("error");
		$("#excelFile_span").html("请选择文件！");
		return false;
	} else {
		$("#excelFile_div").removeClass("error").addClass("success");
		$("#excelFile_span").html("可以使用");
		return true;
	}
}

$(function() {
	$("#headerSpan").text(invokeFrameVariables("corpSpace.corpType_name"));

	var options = {
		beforeSubmit : function() {
			var flag = true;
			if (!corpSpace.validate_excelFile()) {
				flag = false;
			}
			if (flag) {
				corpSpace.disableAllButton();
			}
			return flag;
		},
		success : function(response) {
			if (response.isSuccess == "true") {
				invokeFrameMethod("corpSpace.initTree");
				ajaxAlertSuccessMsg(response.msg, true);
				autoCloseCommonModal(5);
			} else {
				corpSpace.enableAllButton();
				ajaxAlertErrorMsg(response.msg, true);
			}

		},
		url : $("#ctx").val() + "/pages/crmCorp/form/uploadSubmit",
		type : "post",
		clearForm : false,
		timeout : 30000
	};
	$("#uploadCrmCorpForm").ajaxForm(options);
});