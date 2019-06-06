Editorial.ProductOrder = function() {
	this.editor = null;
	this.artDialog = null;
	this.oTable1 = null;
};

Editorial.ProductOrder.validate = function() {
	var flag = true;
	if (!Editorial.ProductOrder.UplaodtxtFile()) {
		flag = false;
	}
	return flag;
};

Editorial.ProductOrder.UplaodtxtFile = function() {
	var val = $("#txtFile").val().substring($("#txtFile").val().lastIndexOf(".") + 1);
	if ($("#txtFile").val() == "") {
		$("#txtFileDiv").addClass("error");
		$("#txtFileSpan").html("上传文件不能为空！");
		return false;
	}else if(!(val=="xls"||val=="xlsx"||val=="XLS"||val=="XLSX")){
		$("#txtFileDiv").addClass("error");
		$("#txtFileSpan").html("请上传xls或xlsx格式的文件！");
		return false;
	}else{
		$("#txtFileDiv").removeClass("error").addClass("success");
		$("#txtFileSpan").html("通过验证");
		return true;
	}
};

Editorial.ProductOrder.showResponse = function(response, statusText) {
	Editorial.ProductOrder.disableAllButton();
	if (response.isSuccess == "true") {
		ajaxAlertSuccessMsg(response.msg, true);
		refreshFrameDataTableInLayer('Editorial.ProductOrder.oTable1');
		autoCloseCommonModal(5);
	} else {
		ajaxAlertErrorMsg(response.msg, true);
		Editorial.ProductOrder.enableAllButton();
	}
};

Editorial.ProductOrder.disableAllButton = function() {
	$("#save").attr('disabled', "true");
	$("#reset").attr('disabled', "true");
};

Editorial.CRM.CorpType.enableAllButton = function() {
    $("#save").removeAttr('disabled');
    $("#reset").removeAttr('disabled');
};

$(function() {
	var options = {
		beforeSubmit : Editorial.ProductOrder.validate,
		success : Editorial.ProductOrder.showResponse,
		url : $('#ctx').val() + '/pages/productOrder/form/add',
		type : 'post',
		clearForm : false,
		timeout : 30000
	};
	$('#ProductOrderForm').ajaxForm(options);
});