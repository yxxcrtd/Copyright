Editorial.CrSubsidaryRightCountry = function() {
	
};

Editorial.CrSubsidaryRightCountry.dataTable = null;

Editorial.CrSubsidaryRightCountry.query = function() {
	refreshFrameDataTableInFrame("Editorial.CrSubsidaryRightCountry.dataTable");
};

Editorial.CrSubsidaryRightCountry.onload = function() {
	/*$("#country_subsidaryRight_srlicenseId").val($("#id").val());*/
	var subsidaryRight_srlicenseId = $("#id").val(); // 授权ID
	$("#country_subsidaryRight_srlicenseId").val(subsidaryRight_srlicenseId);
	
	$("#on").click(function() {
		$("#on_down").slideToggle();
	});
	Editorial.CrSubsidaryRightCountry.dataTable = $("#countryDataTable").dataTable({
		"bFilter" : false,
		"bProcessing" : true,
		"bAutoWidth" : false,
		"sPaginationType" : "full_numbers",
		"bServerSide" : true,
		"sAjaxSource" : $("#ctx").val() + "/pages/base/country/form/manager?now=" + new Date().getTime(),
		"fnServerParams" : function(aoData) {
			
			aoData.push({
				name : "cnIdSubsidaryRight",
				value : subsidaryRight_srlicenseId
			});
		
			aoData.push({
				"name" : "cnName",
				"value" : $("#authorizedArea_country_cnName").val()
			});
		
			aoData.push({
				"name" : "enName",
				"value" : $("#authorizedArea_country_enName").val()
			});
		
		},
		"fnServerData" : function(sSource, aoData, fnCallback) {
			$.ajax({
				"dataType" : "json",
				"type" : "POST",
				"url" : sSource,
				"cache" : false,
				"data" : aoData,
				"success" : function(response) {
					fnCallback(response);
				},
				"error" : function(response) {
					alert("error");
				}
			});
		},
		"fnDrawCallback" : function(oSettings) {
			for (var i = 0, iLen = oSettings.aiDisplay.length; i < iLen; i++) {
				$("td:eq(0)", oSettings.aoData[oSettings.aiDisplay[i]].nTr).html(i + oSettings._iDisplayStart + 1);
			}
		},
		"aoColumns" : [{
			"sTitle" : "序号",
			"mDataProp" : "id",
			"bSortable" : false
		}, {
			"sTitle" : "<label><input type='checkbox' onclick='Editorial.CrSubsidaryRightCountry.selectAll(this)' style='display: none;' /><span class='lbl'></span></label>",
			"mData" : null,
			"bSortable" : false,
			"fnRender" : function(oObj) {
				return "<label><input type='checkbox' name='countryList["+ oObj.iDataRow +"].id' value='"+ oObj.aData.id +"' style='display: none;' /><span class='lbl'></span></label>";
			}
		}, {
			"sTitle" : "编码",
			"mDataProp" : "enName",
			"bSortable" : false
		}, {
			"sTitle" : "名称",
			"mDataProp" : "cnName",
			"bSortable" : false
		}],
		"oLanguage" : {
			"sProcessing" : "正在加载中......",
			"sLengthMenu" : "每页显示 _MENU_ 条记录",
			"sZeroRecords" : "对不起，查询不到相关数据！",
			"sEmptyTable" : "表中无数据存在！",
			"sInfo" : "当前显示 _START_ 到 _END_ 条，共 _TOTAL_ 条记录",
			"sInfoFiltered" : "数据表中共为 _MAX_ 条记录",
			"sSearch" : "搜索",
			"oPaginate" : {
				"sFirst" : "首页",
				"sPrevious" : "上一页",
				"sNext" : "下一页",
				"sLast" : "末页"
			}
		}
	});
	$("[data-rel=tooltip]").tooltip();
};

Editorial.CrSubsidaryRightCountry.selectAll = function(obj) {
	$("input[name^=countryList][name$=id]").attr("checked", obj.checked);
};

Editorial.CrSubsidaryRightCountry.selectSubmit = function() {
	var selected = $("input[name^=countryList][name$=id]:checked");
	if (selected.length == 0) {
		ajaxAlertErrorMsg("请选择地域！");
	} else {
		var options = {
			success : function(response) {
				if (response.isSuccess == "true") {
					refreshFrameDataTableInFrame("Editorial.SubsidaryRight.authorizedAreaDataTable");
					ajaxAlertSuccessMsg(response.msg, true);
					autoCloseCommonModal(5);
				} else {
					ajaxAlertErrorMsg(response.msg)
				}
			},
			url : $("#ctx").val() + "/pages/rightLicense/csrRelationship/form/selectCountrySubmit",
			type : "post",
			clearForm : false,
			timeout : 3000
		};
		$("#selectCountryForm").ajaxSubmit(options);
		
	}
};

$(function() {
	Editorial.CrSubsidaryRightCountry.onload();
});