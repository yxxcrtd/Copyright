

/*************************************************************************************/


Editorial.Material.validate = function() {
	var flag = true;
	
	if (!Editorial.Material.validateAddressType()) {
		flag = false;
	}
	
	if (!Editorial.Material.validateAddressCountry()) {
		flag = false;
	}
	
	if (!Editorial.Material.validateAddressCity()) {
		flag = false;
	}
	
	if (!Editorial.Material.validateAddressTown()) {
		flag = false;
	}
	
	if (!Editorial.Material.validateAddressBlock()) {
		flag = false;
	}
	
	if (!Editorial.Material.validateAddressStreet()) {
		flag = false;
	}
	
	if (!Editorial.Material.validateAddressBuilding()) {
		flag = false;
	}
	
	if (!Editorial.Material.validateAddressFloor()) {
		flag = false;
	}
	
	if (!Editorial.Material.validateAddressRoomNo()) {
		flag = false;
	}
	
	if (!Editorial.Material.validateAddressPost()) {
		flag = false;
	}
	
	return flag;
};

Editorial.Material.validateAddressType = function() {
	if ($("#address_type").val().trim() == "") {
		$("#address_type_div").addClass("error");
		$("#address_type_span").html("地址分类不能为空！");
		return false;
	}
	$("#address_type_div").removeClass("error").addClass("success");
	$("#address_type_span").html("通过验证");
	return true;
};

Editorial.Material.validateAddressCountry = function() {
	if ($("#address_country").val().trim() == "") {
		$("#address_country_div").addClass("error");
		$("#address_country_span").html("国家不能为空！");
		return false;
	}
	$("#address_country_div").removeClass("error").addClass("success");
	$("#address_country_span").html("通过验证");
	return true;
};

Editorial.Material.validateAddressCity = function() {
	if ($("#address_city").val().trim() == "") {
		$("#address_city_div").addClass("error");
		$("#address_city_span").html("城市不能为空！");
		return false;
	}
	$("#address_city_div").removeClass("error").addClass("success");
	$("#address_city_span").html("通过验证");
	return true;
};

Editorial.Material.validateAddressTown = function() {
	if ($("#address_town").val().trim() == "") {
		$("#address_town_div").addClass("error");
		$("#address_town_span").html("镇不能为空！");
		return false;
	}
	$("#address_town_div").removeClass("error").addClass("success");
	$("#address_town_span").html("通过验证");
	return true;
};

Editorial.Material.validateAddressBlock = function() {
	if ($("#address_block").val().trim() == "") {
		$("#address_block_div").addClass("error");
		$("#address_block_span").html("区不能为空！");
		return false;
	}
	$("#address_block_div").removeClass("error").addClass("success");
	$("#address_block_span").html("通过验证");
	return true;
};

Editorial.Material.validateAddressStreet = function() {
	if ($("#address_street").val().trim() == "") {
		$("#address_street_div").addClass("error");
		$("#address_street_span").html("街道名不能为空！");
		return false;
	}
	$("#address_street_div").removeClass("error").addClass("success");
	$("#address_street_span").html("通过验证");
	return true;
};

Editorial.Material.validateAddressBuilding = function() {
	if ($("#address_building").val().trim() == "") {
		$("#address_building_div").addClass("error");
		$("#address_building_span").html("建筑名不能为空！");
		return false;
	}
	$("#address_building_div").removeClass("error").addClass("success");
	$("#address_building_span").html("通过验证");
	return true;
};

Editorial.Material.validateAddressFloor = function() {
	if ($("#address_floor").val().trim() == "") {
		$("#address_floor_div").addClass("error");
		$("#address_floor_span").html("楼层不能为空！");
		return false;
	}
	$("#address_floor_div").removeClass("error").addClass("success");
	$("#address_floor_span").html("通过验证");
	return true;
};

Editorial.Material.validateAddressRoomNo = function() {
	if ($("#address_roomNo").val().trim() == "") {
		$("#address_roomNo_div").addClass("error");
		$("#address_roomNo_span").html("房间不能为空！");
		return false;
	}
	$("#address_roomNo_div").removeClass("error").addClass("success");
	$("#address_roomNo_span").html("通过验证");
	return true;
};

Editorial.Material.validateAddressPost = function() {
	if ($("#address_post").val().trim() == "") {
		$("#address_post_div").addClass("error");
		$("#address_post_span").html("邮编不能为空！");
		return false;
	}
	$("#address_post_div").removeClass("error").addClass("success");
	$("#address_post_span").html("通过验证");
	return true;
};

Editorial.Material.showResponse = function(response, statusText) {
	Editorial.Material.disableAllButton();
	if (response.isSuccess == "true") {
		ajaxAlertSuccessMsg(response.msg, true);
		refreshCustomPropertyDataTable("cp1");
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
		url : $('#ctx').val() + "/pages/crmCorpAddress/form/editSubmit",
		type : 'post',
		clearForm : false,
		timeout : 3000
	};
	$("#crmCorpAddressForm").ajaxForm(options);
});

Editorial.Material.disableAllButton = function() {
	$("#save").attr('disabled', "true");
	$("#reset").attr('disabled', "true");
};

Editorial.Material.enableAllButton = function() {
    $("#save").removeAttr('disabled');
    $("#reset").removeAttr('disabled');
};