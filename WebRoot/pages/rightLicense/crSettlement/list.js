Editorial.Settlement = function() {
	this.editor = null;
	this.artDialog = null;
	this.oTable1 = null;
};

Editorial.Settlement.addObj = function() {
	    var code = $("#productCode").val();
		var url = $('#ctx').val() + "/pages/settlement/form/add?code="+code;
		$.ajax({
			"dataType" : 'json',
			"type" : "POST",
			"url" : url,
			"cache" : false,
			"success" : function(response) {
				if (response.isSuccess == "true") {
					window.parent.alertMsg('successModal', 'successMsg', response.msg);
					refreshFrameDataTableInFrame('Editorial.Settlement.oTable1');
				} else {
					window.parent.alertMsg('errorModal', 'errorMsg', response.msg);
				}
			},
			"error" : function(response) {
				alert("error");
			}
		});
};

Editorial.Settlement.setObj = function(id) {
	openConfirmModalInFrame("您确定将该信息修改为“已结算”状态吗？", function() {
		var url = $('#ctx').val() + "/pages/settlement/form/settle?id=" + id;
		$.ajax({
			"dataType" : 'json',
			"type" : "POST",
			"url" : url,
			"cache" : false,
			"success" : function(response) {
				if (response.isSuccess == "true") {
					window.parent.alertMsg('successModal', 'successMsg', response.msg);
					refreshFrameDataTableInFrame('Editorial.Settlement.oTable1');
				} else {
					window.parent.alertMsg('errorModal', 'errorMsg', response.msg);
				}
			},
			"error" : function(response) {
				alert("error");
			}
		});
	}, null, null);
};

Editorial.Settlement.delObj = function(id) {
	openConfirmModalInFrame("您确定执行删除该订单信息操作吗？", function() {
		var url = $('#ctx').val() + "/pages/settlement/form/delete?id=" + id;
		$.ajax({
			"dataType" : 'json',
			"type" : "POST",
			"url" : url,
			"cache" : false,
			"success" : function(response) {
				if (response.isSuccess == "true") {
					window.parent.alertMsg('successModal', 'successMsg', response.msg);
					refreshFrameDataTableInFrame('Editorial.Settlement.oTable1');
				} else {
					window.parent.alertMsg('errorModal', 'errorMsg', response.msg);
				}
			},
			"error" : function(response) {
				alert("error");
			}
		});
	}, null, null);
};

Editorial.Settlement.query = function() {
	// 重新刷新页面Table
	refreshFrameDataTableInFrame('Editorial.Settlement.oTable1');
};

Editorial.Settlement.retrieveData = function(sSource, aoData, fnCallback) {
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
			alert(response);
			alert("error%%%");
		}
	});
};

$(function() {
	Editorial.Settlement.oTable1 = $('#table_report').dataTable({
		"bFilter" : false, // 开关，是否启用客户端过滤器
		"bProcessing" : true, // 当datatable获取数据时候是否显示正在处理提示信息。
		"bAutoWidth" : false, // 自适应宽度
		"sPaginationType" : "full_numbers", // 分页样式
		"bServerSide" : true, // 从服务器端取数据
		"sAjaxSource" : $('#ctx').val() + "/pages/settlement/form/manager", // mvc后台ajax调用接口。
		"fnServerParams" : function(aoData) {
			aoData.push({
				"name" : "code",
				"value" : $("#query_settlement_code").val()
			});
			aoData.push({
				"name" : "name",
				"value" : $("#query_settlement_name").val()
			});
			aoData.push({
				"name" : "setStatus",
				"value" : $("#query_settlement_status").val()
			});
		},
		"fnServerData" : Editorial.Settlement.retrieveData,
		"fnDrawCallback" : function(oSettings) {
			for ( var i = 0, iLen = oSettings.aiDisplay.length; i < iLen; i++) {
				$('td:eq(0)', oSettings.aoData[oSettings.aiDisplay[i]].nTr).html(i + oSettings._iDisplayStart + 1);
			}
		},
		"aoColumns" : [ {
			"sTitle" : "序号",
			"mDataProp" : "id"
		}, {
            "sTitle" : "结算类型",
            "mDataProp" : "setType"
		}, {
			"sTitle" : "订单号",
			"mDataProp" : "code"
        }, {
			"sTitle" : "贡献者名称",
			"mDataProp" : "name"
        }, {
			"sTitle" : "结算金额",
			"mDataProp" : "amount"
		}, {
			"sTitle" : "结算状态",
			"mDataProp" : "setStatus"
		}, {
            "sTitle" : "结算日期",
            "mDataProp" : "endDate",
			"sType" : 'date',
    		"fnRender" : function(oObj) {
    			if(null!=oObj.aData.endDate){
    				var javascriptDate = new Date(oObj.aData.endDate).toLocaleDateString();
        			return "<div class= date>" + javascriptDate + "<div>";
    			}else{
    				return "";
    			}
    		}
        }, {
			"sTitle" : "操作",
			"mData" : null,
			"aTargets" : [ -1 ],
			// 自定义列的样式
			"fnRender" : function(oObj) {
				var start = '<div class="hidden-phone visible-desktop btn-group">';
				if(oObj.aData.setStatus=="未结算"){
					var edit = '<button class="btn btn-mini btn-success" title="结算完成" onclick="Editorial.Settlement.setObj(\'' + oObj.aData.id + '\')"><i class="icon-check bigger-120"></i></button>';
				}
				var trash = '<button class="btn btn-mini btn-danger" title="删除" onclick="Editorial.Settlement.delObj(\'' + oObj.aData.id + '\')"><i class="icon-trash bigger-120"></i></button>';
				var end = '</div>';
				return start + edit + trash + end; 
			}
		} ],

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