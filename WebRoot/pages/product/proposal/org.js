//jQuery.namespace('Editorial.CRM.PersonInfo');
Editorial.CRM.PersonInfo = function () {
    this.editor = null;
    this.artDialog = null;
    this.oTable1 = null;
};

Editorial.CRM.PersonInfo.checkedAll = function () {
    if ($("#checkedAll").attr("checked") == "checked") { // 全选
        $("input[name='ids']").attr("checked", true);
    } else { // 取消全选
        $("input[name='ids']").removeAttr("checked");
    }
};

Editorial.CRM.PersonInfo.saveObj = function () {
    var sData = $('input', Editorial.CRM.PersonInfo.oTable1.fnGetNodes()).serialize();
    if (sData == null || sData == "") {
        openErrorAlertModalInFrame("请至少选择一条客户记录!");
        return false;
    }
    sData = sData.replace(new RegExp('&ids=', 'g'), ',');
    var url = $('#ctx').val() + '/pages/product/proposalPersonRela/form/savePersons?id=' + $("#id").val() + '&' + sData;
    $.ajax({
        "dataType": 'json',
        "type": "POST",
        "url": url,
        "cache": false,
        "success": function (response) {
            if (response.isSuccess == "true") {
                ajaxAlertSuccessMsg(response.msg, true);
                Editorial.Proposal.roleCheck();
                autoCloseCommonModal(5);
            }
        },
        "error": function (response) {
            alert("error");
        }
    });
    //refreshFrameDataTableInLayer('Editorial.Proposal.personTable');
};

Editorial.CRM.PersonInfo.query = function () {
    refreshFrameDataTableInFrame('Editorial.CRM.PersonInfo.oTable1');
};

Editorial.CRM.PersonInfo.retrieveData = function (sSource, aoData, fnCallback) {
    $.ajax({
        "dataType": 'json',
        "type": "POST",
        "url": sSource,
        "cache": false,
        "data": aoData,
        "success": function (response) {
            fnCallback(response);
        },
        "error": function (response) {
            alert("error");
            alert(response);
            alert(response.responseText);
        }
    });
};

$(function () {
    $(".on").click(function () {
        $(".on-down").slideToggle();
    });
    Editorial.CRM.PersonInfo.oTable1 = $('#table_report').dataTable({
        "bFilter": false, // 开关，是否启用客户端过滤器
        "bProcessing": true, // 当datatable获取数据时候是否显示正在处理提示信息。
        "bAutoWidth": false, // 自适应宽度
        "sPaginationType": "full_numbers", // 分页样式
        "bServerSide": true, // 从服务器端取数据
        "sAjaxSource": $('#ctx').val() + "/pages/crm/personInfo/form/manager?code=employee&proposalId="+$('#id').val(), // mvc后台ajax调用接口。
        "fnServerParams": function (aoData) {
            aoData.push({
                    "name": "name",
                    "value": $("#query_module_name").val()
                }
            );
        },
        "fnServerData": Editorial.CRM.PersonInfo.retrieveData,
        "fnDrawCallback": function (oSettings) {
            for (var i = 0, iLen = oSettings.aiDisplay.length; i < iLen; i++) {
                $('td:eq(1)', oSettings.aoData[oSettings.aiDisplay[i]].nTr).html(i + oSettings._iDisplayStart + 1);
            }
        },
        "aoColumns": [
            {
                "sTitle": '<label><input type="checkbox" name="checked" value="1" id="checkedAll" onclick="Editorial.CRM.PersonInfo.checkedAll()"/><span class="lbl"></span></label>',
                "mData": null,
                "bSortable": false,
                "sClass": "center",
                "fnRender": function (oObj) {
                    //console.log(oObj.aData);
                    //console.log(oObj.aData.id);
                    var sReturn = "";
                    sReturn = '<label><input type="checkbox" name="ids" value="' + oObj.aData.id + '" /><span class="lbl"></span></label>';
                    return sReturn;


                }
            },
            {
                "sTitle": "ID",
                "mDataProp": "id",
        		"bSortable": false
            },
            {
                "sTitle": "联系人名称",
                "mDataProp": "person.name",
        		"bSortable": false
            },
            {
                "sTitle": "座机",
                "mDataProp": "person.telephone",
        		"bSortable": false
            },
            {
                "sTitle": "手机",
                "mDataProp": "person.phone",
        		"bSortable": false
            },
            {
                "sTitle": "联系地址",
                "mDataProp": "person.address",
        		"bSortable": false
            },
            {
                "sTitle": "邮编",
                "mDataProp": "person.postCode",
        		"bSortable": false
            },
            {
                "sTitle": "电子邮箱",
                "mDataProp": "person.email",
        		"bSortable": false
            },
            {
                "sTitle": "传真",
                "mDataProp": "person.fax",
        		"bSortable": false
            }
        ],

        // 多语言配置
        "oLanguage": {
            "sProcessing": "正在加载中......",
            "sLengthMenu": "每页显示 _MENU_ 条记录",
            "sZeroRecords": "对不起，查询不到相关数据！",
            "sEmptyTable": "表中无数据存在！",
            "sInfo": "当前显示 _START_ 到 _END_ 条，共 _TOTAL_ 条记录",
            "sInfoFiltered": "数据表中共为 _MAX_ 条记录",
            "sSearch": "搜索",
            "oPaginate": {
                "sFirst": "首页",
                "sPrevious": "上一页",
                "sNext": "下一页",
                "sLast": "末页"
            }
        }

    });
    $('[data-rel=tooltip]').tooltip();
});
