/* ***************************************** 验证开始
 * *************************************************************
 */
var orderFlag = false;
Editorial.CRM.CorpTypePropClassify.validate = function() {
	var flag = true;
	if (!Editorial.CRM.CorpTypePropClassify.order()) {
		flag = false;
	}
	if (!Editorial.CRM.CorpTypePropClassify.code()) {
		flag = false;
	}
//	if (!Editorial.CRM.CorpTypePropClassify.name()) {
//		flag = false;
//	}
	
	return flag;
};
/**  
 * ***************************************** 验证Code开始
 * *************************************************************
 */
Editorial.CRM.CorpTypePropClassify.code = function() {
    if ($("#code").val().trim() == "") {
        $("#codeDiv").addClass("error");
        $("#codeSpan").html("编号不能为空！");
        return false;
    }
	if ($("#code").val() == "") {
		$("#codeDiv").addClass("error");
		$("#codeSpan").html("编号不能为空！");
		return false;
	}
    if($("#code").val().match(/[\x01-\xFF]*/)==false){
        $("#codeDiv").addClass("error");
        $("#codeSpan").html("编号不能为中文！");
        return false;
    }else {
		$("#codeDiv").removeClass("error").addClass("success");
		$("#codeSpan").html("通过验证");	}
		return true;
};
/**
 * ***************************************** 验证Code结束
 * *************************************************************
 */
///**
// * ***************************************** 验证name开始
// * *************************************************************
// */
//Editorial.CRM.CorpTypePropClassify.name = function() {
//	if ($("#name").val() == "") {
//		$("#nameDiv").addClass("error");
//		$("#nameSpan").html("name不能为空！");
//		return false;
//	} else {
//		$("#nameDiv").removeClass("error").addClass("success");
//		$("#nameSpan").html("通过验证");
//		return true;
//	}
//};
///**
// * ***************************************** 验证name结束
// * *************************************************************
// */
/**
 * ***************************************** 验证order开始
 * *************************************************************
 */
Editorial.CRM.CorpTypePropClassify.order = function() {
	if ($("#order").val().trim() == "") {
		$("#orderDiv").addClass("error");
		$("#orderSpan").html("排序不能为空！");
		return false;
	}
//	else {
//		$("#orderDiv").removeClass("error").addClass("success");
//		$("#orderSpan").html("通过验证");	}
//		return true;
    if ($("#order").val() == "") {
        $("#orderDiv").addClass("error");
        $("#orderSpan").html("排序不能为空！");
        return false;
    }
    if($("#order").val().match(/^[0-9]*$/)){
        Editorial.CRM.CorpTypePropClassify.orderUnique();
        if (orderFlag == true) {
            return true;
        } else {
            return false;
        }
    }else {
        $("#orderDiv").addClass("error");
        $("#orderSpan").html("排序只能是数字！");
        return false;
    }
};
/**
 * ***************************************** 验证order结束
 * *************************************************************
 */

Editorial.CRM.CorpTypePropClassify.orderUnique = function() {
	$.ajax({
		type : "POST",
		async : false,
		"dataType" : 'json',
		url : $('#ctx').val() + "/pages/crm/corpTypePropClassify/form/orderUnique?id="+$("#classifyId").val()+"&tid="+$("#tid").val(),
		data : {
			order : $("#order").val()
		},
		success : function(response) {
			if (response.isSuccess == "true") {
				$("#orderDiv").removeClass("error").addClass("success");
				$("#orderSpan").html(response.msg);
				orderFlag = true;
			} else {
				$("#orderDiv").removeClass("success").addClass("error");
				$("#orderSpan").html(response.msg);
				orderFlag = false;
			}
		},
		error : function(response) {
			alert("error");
		}
	});
};


Editorial.CRM.CorpTypePropClassify.disableAllButton = function() {
	$("#save").attr('disabled', "true");
	$("#reset").attr('disabled', "true");
};

Editorial.CRM.CorpTypePropClassify.enableAllButton = function() {
    $("#save").removeAttr('disabled');
    $("#reset").removeAttr('disabled');
};

Editorial.CRM.CorpTypePropClassify.showResponse = function(response, statusText) {
	if (response.isSuccess == "true") {
		ajaxAlertSuccessMsg(response.msg, true);
		refreshFrameDataTableInLayer('Editorial.CRM.CorpTypePropClassify.oTable1');
		autoCloseCommonModal(5);
	} else {
		ajaxAlertErrorMsg(response.msg, true);
		Editorial.CRM.CorpTypePropClassify.enableAllButton();
	}
};

$(function() {
	var options = {
		beforeSubmit:Editorial.CRM.CorpTypePropClassify.validate,
		success : Editorial.CRM.CorpTypePropClassify.showResponse,
		url :  $('#ctx').val()+'/pages/crm/corpTypePropClassify/form/editSubmit',
		type : 'post',
		clearForm : false,
		timeout : 3000,
	};
	$('#cTypePropClassifyForm').ajaxForm(options);
});