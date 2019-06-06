

/*************************************************************************************/


Editorial.Material.validate = function() {
	var flag = true;
	
	if (!Editorial.Material.validateMaterialName()) {
		flag = false;
	}
	
	if (!Editorial.Material.validateMaterialCode()) {
		flag = false;
	}
	
	if (!Editorial.Material.validateMaterialSpec()) {
		flag = false;
	}
	
	if (!Editorial.Material.validateMaterialGrams()) {
		flag = false;
	}
	
	if (!Editorial.Material.validateMaterialUnit()) {
		flag = false;
	}
	
	if (!Editorial.Material.validateMaterialPrice()) {
		flag = false;
	}
	
	if (!Editorial.Material.validateMaterialStock()) {
		flag = false;
	}
	
	if (!Editorial.Material.validateMaterialStockCount()) {
		flag = false;
	}
	
	return flag;
};

Editorial.Material.validateMaterialName = function() {
	if ($("#material_materialName").val().trim() == "") {
		$("#material_materialName_div").addClass("error");
		$("#material_materialName_span").html("材料名称不能为空！");
		return false;
	}
	$("#material_materialName_div").removeClass("error").addClass("success");
	$("#material_materialName_span").html("通过验证");
	return true;
};

Editorial.Material.validateMaterialCode = function() {
	if ($("#material_materialCode").val().trim() == "") {
		$("#material_materialCode_div").addClass("error");
		$("#material_materialCode_span").html("材料编号不能为空！");
		return false;
	}
	$("#material_materialCode_div").removeClass("error").addClass("success");
	$("#material_materialCode_span").html("通过验证");
	return true;
};

Editorial.Material.validateMaterialSpec = function() {
	if ($("#material_materialSpec").val().trim() == "") {
		$("#material_materialSpec_div").addClass("error");
		$("#material_materialSpec_span").html("材料规格不能为空！");
		return false;
	}
	$("#material_materialSpec_div").removeClass("error").addClass("success");
	$("#material_materialSpec_span").html("通过验证");
	return true;
};

Editorial.Material.validateMaterialGrams = function() {
	if ($("#material_materialGrams").val().trim() == "") {
		$("#material_materialGrams_div").addClass("error");
		$("#material_materialGrams_span").html("材料克重不能为空！");
		return false;
	}
	$("#material_materialGrams_div").removeClass("error").addClass("success");
	$("#material_materialGrams_span").html("通过验证");
	return true;
};

Editorial.Material.validateMaterialUnit = function() {
	if ($("#material_materialUnit").val().trim() == "") {
		$("#material_materialUnit_div").addClass("error");
		$("#material_materialUnit_span").html("材料单位不能为空！");
		return false;
	}
	$("#material_materialUnit_div").removeClass("error").addClass("success");
	$("#material_materialUnit_span").html("通过验证");
	return true;
};

Editorial.Material.validateMaterialPrice = function() {
	if ($("#material_materialPrice").val().trim() == "") {
		$("#material_materialPrice_div").addClass("error");
		$("#material_materialPrice_span").html("材料单价不能为空！");
		return false;
	}
	$("#material_materialPrice_div").removeClass("error").addClass("success");
	$("#material_materialPrice_span").html("通过验证");
	return true;
};

Editorial.Material.validateMaterialStock = function() {
	if ($("#material_materialStock").val().trim() == "") {
		$("#material_materialStock_div").addClass("error");
		$("#material_materialStock_span").html("材料库区不能为空！");
		return false;
	}
	$("#material_materialStock_div").removeClass("error").addClass("success");
	$("#material_materialStock_span").html("通过验证");
	return true;
};

Editorial.Material.validateMaterialStockCount = function() {
	if ($("#material_materialStockCount").val().trim() == "") {
		$("#material_materialStockCount_div").addClass("error");
		$("#material_materialStockCount_span").html("材料库存不能为空！");
		return false;
	}
	$("#material_materialStockCount_div").removeClass("error").addClass("success");
	$("#material_materialStockCount_span").html("通过验证");
	return true;
};

Editorial.Material.showResponse = function(response, statusText) {
	Editorial.Material.disableAllButton();
	if (response.isSuccess == "true") {
		ajaxAlertSuccessMsg(response.msg, true);
		refreshCustomPropertyDataTable("cp1", "T011F002");
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
		url : $('#ctx').val() + "/pages/material/form/editSubmit",
		type : 'post',
		clearForm : false,
		timeout : 3000
	};
	$("#materialForm").ajaxForm(options);
});

Editorial.Material.disableAllButton = function() {
	$("#save").attr('disabled', "true");
	$("#reset").attr('disabled', "true");
};

Editorial.Material.enableAllButton = function() {
	$("#save").attr('disabled', "false");
	$("#reset").attr('disabled', "false");
};