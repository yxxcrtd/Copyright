$(function() {
	Editorial.Person.Author.oTable1 = $('#tables_report').dataTable({
		"bFilter" : false, // 开关，是否启用客户端过滤器
		"bProcessing" : true, // 当datatable获取数据时候是否显示正在处理提示信息。
		"bAutoWidth" : false, // 自适应宽度
		"sPaginationType" : "full_numbers", // 分页样式
		"bServerSide" : true, // 从服务器端取数据
		"sAjaxSource" : $('#ctx').val() + "/pages/crm/personInfo/form/manager?code=writer&id="+$('#productId').val(), // mvc后台ajax调用接口。
		"fnServerParams" : function(aoData) {
			aoData.push({
				"name" : "shortName",
				"value" : $("#query_module_shortName").val()
			});
		},
		"fnDrawCallback" : function(oSettings) {
			for (var i = 0, iLen = oSettings.aiDisplay.length; i < iLen; i++) {
				$('td:eq(1)', oSettings.aoData[oSettings.aiDisplay[i]].nTr).html(i + oSettings._iDisplayStart + 1);
			}
		},
		"aoColumns" : [ {
			"mData" : null,
			"bSortable" : false,
			"sClass" : "center",
			"fnRender" : function(oObj) {
				var sReturn = "";
				sReturn = '<label><input type="checkbox" name="ids" value="' + oObj.aData.id + '" /><span class="lbl"></span></label>';
				return sReturn;
			}
		} ,{
			"sTitle" : "ID",
			"mDataProp" : "id"
		}, {
			"sTitle" : "作者姓名",
			"mDataProp" : "person.name"
		}, {
			"sTitle" : "座机",
			"mDataProp" : "person.telephone"
		}, {
			"sTitle" : "手机",
			"mDataProp" : "person.phone"
		}, {
			"sTitle" : "联系地址",
			"mDataProp" : "person.address"
		}, {
			"sTitle" : "邮编",
			"mDataProp" : "person.postCode"
		},{
			"sTitle" : "电子邮箱",
			"mDataProp" : "person.email"
		},{
			"sTitle" : "传真",
			"mDataProp" : "person.fax"
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

Editorial.Person.Author.saveRoleList = function() {
	var sData = $('input', Editorial.Person.Author.oTable1.fnGetNodes()).serialize();
	if (sData == null || sData == "") {
		openErrorAlertModalInFrame("请至少选择一条客户记录！");
		return false;
	}
	sData = sData.replace(new RegExp('&ids=', 'g'), ','); 
	var url = $('#ctx').val() + "/pages/productPersonRelationship/form/batchSave?productId=" + $('#productId').val()+"&"+sData;
    $.ajax({
		"dataType" : 'json',
		"type" : "POST",
		"cache" : false,
        "url" : url,
		"success" : function(response) {
			if (response.isSuccess == "true") {
				ajaxAlertSuccessMsg(response.msg, true);
				refreshFrameDataTableInLayer('Editorial.Product.ProductInfo.oTable1');
				autoCloseCommonModal(5);
			} else {
				ajaxAlertErrorMsg(response.msg, true);
			}
		},
		"error" : function(response) {
			alert("error");
		}
	});
};