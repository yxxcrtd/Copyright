Editorial.SubsidaryRight.StructureDialog = function() {
	this.editor = null;
	this.artDialog = null;
	this.oTable1 = null;
};

Editorial.SubsidaryRight.StructureDialog.selectStructure = function() {
	var checked = $("input[name=ids]:checked").val();
	if (checked != undefined) {
		var structureArray = checked.split(",");
		var jsonObj = {
			"id" : structureArray[0],
			"name" : structureArray[1]
		};
		updateFormInLayer("Editorial.SubsidaryRight.selectStructureSubmit", jsonObj);
		ajaxAlertSuccessMsg("保存成功！", true);
		autoCloseCommonModal(1);
	} else {
		ajaxAlertErrorMsg("请选择素材！", true);
	}
};

Editorial.SubsidaryRight.StructureDialog.query = function() {
	refreshFrameDataTableInFrame("Editorial.SubsidaryRight.StructureDialog.oTable1");
};

Editorial.SubsidaryRight.StructureDialog.retrieveData = function(sSource, aoData, fnCallback) {
	$.ajax({
		"dataType" : 'json',
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
};

$(function() {
	$(".on").click(function() {
		$(".on-down").slideToggle();
	});
	Editorial.SubsidaryRight.StructureDialog.oTable1 = $("#select_element_report").dataTable({
		"bFilter" : false, // 开关，是否启用客户端过滤器
		"bProcessing" : true, // 当datatable获取数据时候是否显示正在处理提示信息。
		"bAutoWidth" : false, // 自适应宽度
		"sPaginationType" : "full_numbers", // 分页样式
		"bServerSide" : true, // 从服务器端取数据
		"sAjaxSource" : $("#ctx").val() + "/pages/rightLicense/subsidaryRight/form/structureManager", // mvc后台ajax调用接口。
		"fnServerParams" : function(aoData) {
			aoData.push({
				"name" : "elementType.id",
				"value" : $("#query_select_elementType_id").val()
			});
			aoData.push({
				"name" : "element.keyword",
				"value" : $("#query_select_element_keyword").val()
			});
		},
		"fnServerData" : Editorial.SubsidaryRight.StructureDialog.retrieveData,
		"fnDrawCallback" : function(oSettings) {
			for (var i = 0, iLen = oSettings.aiDisplay.length; i < iLen; i++) {
				$('td:eq(1)', oSettings.aoData[oSettings.aiDisplay[i]].nTr).html(i + oSettings._iDisplayStart + 1);
			}
		},
		"aoColumns" : [{
			"sTitle" : "选择",
			"mData" : null,
			"bSortable" : false,
			"sClass" : "center",
			"fnRender" : function(oObj) {
				var sReturn = "";
				var title = oObj.aData.name;
				sReturn = '<label><input type="checkbox" name="ids" style="display: none;" value="' + oObj.aData.structure.id + ',' + title + '" /><span class="lbl"></span></label>';
				return sReturn;
			}
		}, {
			"sTitle" : "序号",
			"mDataProp" : "id",
			"bSortable" : false
		}, {
			"sTitle" : "内容",
			"mData" : null,
			"bSortable" : false,
			"bSortable" : false,
			"sClass" : "left",
			"fnRender" : function(oObj) {
				var url_uuu = $("#ctx").val() + "/pages/productStructure/form/xmlView";
				url_uuu += "?action=" + oObj.aData.path;
				
				var title = oObj.aData.name;
				var sReturn = "<a href='"+ url_uuu +"' class='achide' target='_blank' title='"+ title +"'>"+ title +"</a>";
				return sReturn;
			}
		}],
		// 多语言配置
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

	$('[data-rel=tooltip]').tooltip();
});