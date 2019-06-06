/**
 * ***************************************** 验证开始
 * *************************************************************
 */
var digitalExpression = /^(([0-9]+[\.]?[0-9]+)|[1-9])$/;
var nameValidateFlag = false;
var codeFlag = false;
BMEP.Base.Country.Show.validate = function() {
	var flag = true;
	if (!BMEP.Base.Country.Show.validateName()) {
		flag = false;
	}
	if (!BMEP.Base.Country.Show.validateCode()) {
		flag = false;
	}
	return flag;
};
/**
 * ***************** 验证Name开始 ************************
 */
BMEP.Base.Country.Show.validateName = function() {
	if ($("#name").val().trim() == "") {
		$("#nameDiv").addClass("error");
		$("#nameSpan").html("区域名称不能为空！");
		return false;
	}
	$("#nameDiv").removeClass("error");
	$("#nameSpan").html("");
	return true;
};

/**
 * ***************** 验证Name结束 ************************
 */
/**
 * ***************** 验证code开始 *************************
 */
BMEP.Base.Country.Show.validateCode = function() {
	if ($("#code").val().trim() == "") {
		$("#codeDiv").addClass("error");
		$("#codeSpan").html("区域代码不能为空！");
		return false;
	}else {
		BMEP.Base.Country.Show.codeUnique();
		if (codeFlag == true) {
			return true;
		} else {
			return false;
		}
	}
};


BMEP.Base.Country.Show.codeUnique = function() {
	$.ajax({
		type : "POST",
		async : false,
		"dataType" : 'json',
		url : $('#ctx').val() + "/pages/base/country/form/codeUnique?countryId="+$("#id").val(),
		data : {
			id:$("#id").val(),
			code : $("#code").val()
		},
		success : function(response) {
			if (response.isSuccess == "true") {
				$("#codeDiv").removeClass("error").addClass("success");
				$("#codeSpan").html(response.msg);
				codeFlag = true;
			} else {
				$("#codeDiv").removeClass("success").addClass("error");
				$("#codeSpan").html(response.msg);
				codeFlag = false;
			}
		},
		error : function(response) {
			alert("error");
		}
	});
};
/**
 * ***************** 验证Link结束 *************************
 */
/**
 * ***************** 验证结束 *************************
 */
BMEP.Base.Country.Show.disableAllButton = function() {
	$("#save").attr('disabled', "true");
	$("#reset").attr('disabled', "true");
};

BMEP.Base.Country.Show.enableAllButton = function() {
    $("#save").removeAttr('disabled');
    $("#reset").removeAttr('disabled');
};

BMEP.Base.Country.Show.showResponse = function(response, statusText) {
	BMEP.Base.Country.Show.disableAllButton();
	if (response.isSuccess == "true") {
		ajaxAlertSuccessMsg(response.msg, true);
		
			autoCloseCommonModal(5);
			updateTree("BMEP.Base.Country.Show.zTree", response.node);
	} else {
		ajaxAlertErrorMsg(response.msg, true);
		BMEP.Base.Country.Show.enableAllButton();
	}
};

$(function() {
	var options = {
		beforeSubmit : BMEP.Base.Country.Show.validate,
		success : BMEP.Base.Country.Show.showResponse,
		url : $('#ctx').val() + '/pages/base/country/form/editRegionSubmit',
		type : 'post',
		clearForm : false,
		timeout : 3000
	};
	$('#editRegionForm').ajaxForm(options);
	
});