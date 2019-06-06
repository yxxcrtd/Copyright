var orderFlag = false;
Editorial.CRM.CorpTypeProp.validate = function() {
	var flag = true;
	if (!Editorial.CRM.CorpTypeProp.order()) {
		flag = false;
	}
	if(!Editorial.CRM.CorpTypeProp.classify()){
		flag = false;
	}
	return flag;
};
//

/* ***************************************** 验证类型属性分类开始**********************************************/
Editorial.CRM.CorpTypeProp.classify = function(){
	if ($("#typePropClassify").val().trim() == "") {
		$("#typePropClassifyDiv").addClass("error");
		$("#typePropClassifySpan").html("分类不能为空！");
		return false;
	} else {
		$("#typePropClassifyDiv").removeClass("error").addClass("success");
		$("#typePropClassifySpan").html("");
		return true;
	}
};
/* ***************************************** 验证类型属性分类结束**********************************************/


/**  
 * ***************************************** 验证Code开始
 * *************************************************************
 */
Editorial.CRM.CorpTypeProp.order = function() {
	if ($("#order").val() == "") {
		$("#orderDiv").addClass("error");
		$("#orderSpan").html("排序不能为空！");
		return false;
	} 
	if($("#order").val().match(/^[0-9]*$/)){
		Editorial.CRM.CorpTypeProp.orderUnique();
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

Editorial.CRM.CorpTypeProp.orderUnique = function() {
	$.ajax({
		type : "POST",
		async : false,
		"dataType" : 'json',
		url : $('#ctx').val() + "/pages/crm/corpTypeProp/form/orderUnique?id="+$("#id").val()+"&tid="+$("#tid").val(),
		data : {
			order : $("#order").val()
		},
		success : function(response) {
			if (response.isSuccess == "true") {
				$("#orderDiv").removeClass("error").addClass("success");
				$("#orderSpan").html("");
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
/*********************************************************************************
 **/
Editorial.CRM.CorpTypeProp.names = function() {
	if ($("#names").val() == "") {
		$("#namesDiv").addClass("error");
		$("#namesSpan").html("名称不能为空！");
		return false;
	} else {
		$("#namesDiv").removeClass("error").addClass("success");
		$("#namesSpan").html("");
		return true;
	}
};

Editorial.CRM.CorpTypeProp.code = function() {
	if ($("#code").val() == "") {
		$("#codeDiv").addClass("error");
		$("#codeSpan").html("编号不能为空！");
		return false;
	} else {
		$("#codeDiv").removeClass("error").addClass("success");
		$("#codeSpan").html("");
		return true;
	}
};

Editorial.CRM.CorpTypeProp.musts = function() {
	if ($("#musts").val() == "") {
		$("#mustsDiv").addClass("error");
		$("#mustsSpan").html("是否必填不能为空！");
		return false;
	} else {
		$("#mustsDiv").removeClass("error").addClass("success");
		$("#mustsSpan").html("");
		return true;
	}
};

Editorial.CRM.CorpTypeProp.display = function() {
	if ($("#display").val() == "") {
		$("#displayDiv").addClass("error");
		$("#displaySpan").html("显示方式不能为空！");
		return false;
	} else {
		$("#displayDiv").removeClass("error").addClass("success");
		$("#displaySpan").html("");
		return true;
	}
};
/**
 * *********************************************************************************
 */

Editorial.CRM.CorpTypeProp.disableAllButton = function() {
	$("#save").attr('disabled', "true");
	$("#reset").attr('disabled', "true");
};

Editorial.CRM.CorpTypeProp.enableAllButton = function() {
    $("#save").removeAttr('disabled');
    $("#reset").removeAttr('disabled');
};

Editorial.CRM.CorpTypeProp.showResponse = function(response, statusText) {
	if (response.isSuccess == "true") {
		ajaxAlertSuccessMsg(response.msg, true);
		refreshFrameDataTableInLayer('Editorial.CRM.CorpTypeProp.oTable1');
		autoCloseCommonModal(5);
	} else {
		ajaxAlertErrorMsg(response.msg, true);
	}
	Editorial.CRM.CorpTypeProp.enableAllButton();
};

$(function() {
	var options = {
		beforeSubmit:Editorial.CRM.CorpTypeProp.validate,
		success : Editorial.CRM.CorpTypeProp.showResponse,
		url :  $('#ctx').val()+'/pages/crm/corpTypeProp/form/editSubmit',
		type : 'post',
		clearForm : false,
		timeout : 3000
	};
	$('#corpTypePropForm').ajaxForm(options);
	
	hider();
	$("#display").change(function(){
		hider();
	});
	function hider() {
		var at = $("#display").find("option:selected").text();
		if (at == "下拉框") {
			$("#diveffective").show();
		} else {
			$("#diveffective").hide();
		}
	}
});