Editorial.Person.Author.retrieveData = function(sSource, aoData, fnCallback) {
    $.ajax( {
        "dataType": 'json',
        "type": "POST",
        "url": sSource,
        "cache": false,
        "data": aoData,
        "success": function(response) {
     	   fnCallback(response);
        },
        "error": function(response) {
     	   alert("error");
        }
    } );
};
Editorial.Person.Author.query = function() {
	initPagingParamsInFrame('Editorial.Person.Author.oTable1');
	// 重新刷新页面Table
	refreshFrameDataTableInFrame('Editorial.Person.Author.oTable1');
};

$(function() {
	Editorial.Person.Author.oTable1 = $('#table_report').dataTable({
		"bFilter" : false, // 开关，是否启用客户端过滤器
		"bProcessing" : true, // 当datatable获取数据时候是否显示正在处理提示信息。
		"bAutoWidth" : false, // 自适应宽度
		"sPaginationType" : "full_numbers", // 分页样式
		"bServerSide" : true, // 从服务器端取数据
		"sAjaxSource" : $('#ctx').val() + "/pages/crm/personInfo/form/manager?code=writer&proposalAuthorId="+$('#proposalId').val(), // mvc后台ajax调用接口。
		"fnServerParams" : function(aoData) {
			aoData.push({
				"name" : "name",
				"value" : $("#query_module_name").val()
			});
		},
		"fnServerData": Editorial.Person.Author.retrieveData,
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
			"mDataProp" : "id",
    		"bSortable": false
		}, {
			"sTitle" : "作者姓名",
			"mDataProp" : "person.name",
    		"bSortable": false
		}, {
			"sTitle" : "座机",
			"mDataProp" : "person.telephone",
    		"bSortable": false
		}, {
			"sTitle" : "手机",
			"mDataProp" : "person.phone",
    		"bSortable": false
		}, {
			"sTitle" : "联系地址",
			"mDataProp" : "person.address",
    		"bSortable": false
		}, {
			"sTitle" : "邮编",
			"mDataProp" : "person.postCode",
    		"bSortable": false
		},{
			"sTitle" : "电子邮箱",
			"mDataProp" : "person.email",
    		"bSortable": false
		},{
			"sTitle" : "传真",
			"mDataProp" : "person.fax",
    		"bSortable": false
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
	$('table th input:checkbox').on('click', function() {
		var that = this;
		$(this).closest('table').find('tr > td:first-child input:checkbox').each(function() {
			this.checked = that.checked;
			$(this).closest('tr').toggleClass('selected');
		});
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
	
	var url = $('#ctx').val() + "/pages/proposalAuthorRelationship/form/batchSave?proposalId=" + $('#proposalId').val()+"&"+sData;
    $.ajax({
		"dataType" : 'json',
		"type" : "POST",
		"cache" : false,
        "url" : url,
		"success" : function(response) {
			if (response.isSuccess == "true") {
				ajaxAlertSuccessMsg(response.msg, true);
				refreshFrameDataTableInFrame('Editorial.Proposal.AuthorTable');
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

