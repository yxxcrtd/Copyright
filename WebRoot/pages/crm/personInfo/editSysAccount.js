/**
 * ***************** 验证开始 ************************
 */
Editorial.CRM.PersonInfo.SysAccount.validate = function() {
	var flag = true;
	if (!Editorial.CRM.PersonInfo.SysAccount.validateName()) {
		flag = false;
	}
    if(!Editorial.CRM.PersonInfo.SysAccount.validatePass()) {
        flag = false;
    }
    if(!Editorial.CRM.PersonInfo.SysAccount.validateStatus()) {
        flag = false;
    }
    if(!Editorial.CRM.PersonInfo.SysAccount.validateEncryption()) {
        flag = false;
    }
	
	return flag;
};
/**
 * ***************** 验证name开始 ************************
 */
Editorial.CRM.PersonInfo.SysAccount.validateName = function() {
	if ($("#name").val().trim() == "") {
		$("#nameDiv").addClass("error");
		$("#nameSpan").html("名称不能为空！");
		return false;
	}
	$("#nameDiv").removeClass("error");
	$("#nameSpan").html("");
	return true;
};

/**
 * ***************** 验证name结束 ************************
 */

/**
 * ***************** 验证pass开始 ************************
 */
Editorial.CRM.PersonInfo.SysAccount.validatePass = function() {
	if ($("#pass").val() == "") {
		$("#passDiv").addClass("error");
		$("#passSpan").html("密码不能为空！");
		return false;
	}
	$("#passDiv").removeClass("error");
	$("#passSpan").html("");
	return true;
};

/**
 * ***************** 验证pass结束 ************************
 */

/**
 * ***************** 验证status开始 ************************
 */
Editorial.CRM.PersonInfo.SysAccount.validateStatus = function() {
    if ($("#status").val() == "") {
        $("#statusDiv").addClass("error");
        $("#statusSpan").html("状态不能为空！");
        return false;
    }
    $("#statusDiv").removeClass("error");
    $("#statusSpan").html("");
    return true;
};
/**
 * ***************** 验证status结束 ************************
 */

/**
 * ***************** 验证encryption开始 ************************
 */
Editorial.CRM.PersonInfo.SysAccount.validateEncryption = function() {
    if ($("#encryption").val() == "") {
        $("#encryptionDiv").addClass("error");
        $("#encryptionSpan").html("加密不能为空！");
        return false;
    }
    $("#encryptionDiv").removeClass("error");
    $("#encryptionSpan").html("");
    return true;
};
/**
 * ***************** 验证encryption结束 ************************
 */

/**
 * ***************** 提交开始 *************************
 */
Editorial.CRM.PersonInfo.SysAccount.showResponse = function(response, statusText) {
	if (response.isSuccess == "true") {
		ajaxAlertSuccessMsg(response.msg, true);
		autoCloseCommonModal(5);
	} else {
		ajaxAlertErrorMsg(response.msg, true);
	}
};
$(function() {

	var options = {
		beforeSubmit : Editorial.CRM.PersonInfo.SysAccount.validate,
		success : Editorial.CRM.PersonInfo.SysAccount.showResponse,
		url : $('#ctx').val() + '/pages/crm/personInfo/form/editSysAccountSubmit',
		type : 'POST',
		clearForm : false,
		timeout : 3000
	};

	$('#editSysAccontForm').ajaxForm(options);
});
/**
 * ***************** 提交结束 *************************
 */
