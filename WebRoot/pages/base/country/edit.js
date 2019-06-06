/**
 * ***************************************** 验证开始
 * *************************************************************
 */
var digitalExpression = /^(([0-9]+[\.]?[0-9]+)|[1-9])$/;
var cnNameValidateFlag = false;
var enNameValidateFlag = false;

BMEP.Base.Country.validate = function() {
	var flag = true;
	if (!BMEP.Base.Country.validateCnName()) {
		flag = false;
	}
	if (!BMEP.Base.Country.validateEnName()) {
		flag = false;
	}
	return flag;
};
/**
 * ***************** 验证CnName开始 ************************
 */
BMEP.Base.Country.validateCnName = function() {
	if ($("#cnName").val().trim() == "") {
		$("#cnNameDiv").addClass("error");
		$("#cnNameSpan").html("国别中文名不能为空！");
		return false;
	}
	if(!(/^[\u4e00-\u9fa5]+$/).test($("#cnName").val())){
		$("#cnNameDiv").addClass("error");
		$("#cnNameSpan").html("仅能输入中文！");
		return false;
	}else {
		BMEP.Base.Country.validateCnNameUnique();
		if (cnNameValidateFlag == true) {
			return true;
		} else {
			return false;
		}
	}
};
 
BMEP.Base.Country.validateCnNameUnique = function() {
	$.ajax({
		type : "POST",
		async : false,
		"dataType" : 'json',
		url : $('#ctx').val() + "/pages/base/country/form/cnNameUnique",
		data : {
			cnName : $("#cnName").val()
		},
		success : function(response) {
			if (response.isSuccess == "true") {
				$("#cnNameDiv").removeClass("error").addClass("success");
				$("#cnNameSpan").html(response.msg);
				cnNameValidateFlag = true;
			} else {
				$("#cnNameDiv").removeClass("success").addClass("error");
				$("#cnNameSpan").html(response.msg);
				cnNameValidateFlag = false;
			}
		},
		error : function(response) {
			alert("error");
		}
	});
};

/**
 * ***************** 验证CnName结束 ************************
 */
/**
 * ***************** 验证EnName开始 *************************
 */
BMEP.Base.Country.validateEnName = function() {
	if ($("#enName").val().trim() == "") {
		$("#enNameDiv").addClass("error");
		$("#enNameSpan").html("国别英文名不能为空！");
		return false;
	}
	if(!(/^[A-Za-z]+$/).test($("#enName").val())){
		$("#enNameDiv").addClass("error");
		$("#enNameSpan").html("仅能输入英文！");
		return false;
	}else {
		BMEP.Base.Country.validateEnNameUnique();
		if (enNameValidateFlag == true) {
			return true;
		} else {
			return false;
		}
	}
	$("#enNameDiv").removeClass("error");
	$("#enNameSpan").html("");
	return true;
};

BMEP.Base.Country.validateEnNameUnique = function() {
	$.ajax({
		type : "POST",
		async : false,
		"dataType" : 'json',
		url : $('#ctx').val() + "/pages/base/country/form/enNameUnique",
		data : {
			enName : $("#enName").val()
		},
		success : function(response) {
			if (response.isSuccess == "true") {
				$("#enNameDiv").removeClass("error").addClass("success");
				$("#enNameSpan").html(response.msg);
				enNameValidateFlag = true;
			} else {
				$("#enNameDiv").removeClass("success").addClass("error");
				$("#enNameSpan").html(response.msg);
				enNameValidateFlag = false;
			}
		},
		error : function(response) {
			alert("error");
		}
	});
};

/**
 * ***************** 验证EnName结束 *************************
 */
/**
 * ***************** 验证结束 *************************
 */
BMEP.Base.Country.disableAllButton = function() {
	$("#save").attr('disabled', "true");
	$("#reset").attr('disabled', "true");
};

BMEP.Base.Country.enableAllButton = function() {
    $("#save").removeAttr('disabled');
    $("#reset").removeAttr('disabled');
};

BMEP.Base.Country.showResponse = function(response, statusText) {
	BMEP.Base.Country.disableAllButton();
	if (response.isSuccess == "true") {
		ajaxAlertSuccessMsg(response.msg, true);
		if (response.flag != "tree") {
			refreshFrameDataTableInLayer('BMEP.Base.Country.oTable1');
			autoCloseCommonModal(5);
		} else {
			autoCloseCommonModal(5);
			updateTree("BMEP.Base.Country.Show.zTree", response.node);
		}
	} else {
		ajaxAlertErrorMsg(response.msg, true);
		BMEP.Base.Country.enableAllButton();
	}
};

$(function() {
	$('input:text:first').focus();
    var $inp = $('input:text');
    var length = $inp.length;
    $inp.bind('keydown', function (e) {
        var key = e.which;
        if (key == 13) {
            e.preventDefault();
            var nxtIdx = $inp.index(this) + 1; 
            if(nxtIdx == length){
           	 $("#save").focus();
            }
            $(":input:text:eq(" + nxtIdx + ")").focus();

        }

    });
	
	var options = {
		beforeSubmit : BMEP.Base.Country.validate,
		success : BMEP.Base.Country.showResponse,
		url : $('#ctx').val() + '/pages/base/country/form/editCountrySubmit',
		type : 'post',
		clearForm : false,
		timeout : 3000
	};
	$('#editCountryForm').ajaxForm(options);
	
});
