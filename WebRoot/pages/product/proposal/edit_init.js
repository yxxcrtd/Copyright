/**
 * Created by huangchenxi on 14-7-16.
 */

$(function () {
    if ($('#edit').val() == "1" && $('#id').val() != "") {
        $('#addPersonButton').hide();
        $('#save').hide();
        $('#reset').hide();
        $('#name').attr("disabled", "disabled");
        $('#desc').attr("disabled", "disabled");
        $('#roleType').attr("disabled", "disabled");
        $('#addAuthorButton').hide()

    }
    var options = {
        beforeSubmit: Editorial.Proposal.validate,
        success: Editorial.Proposal.showResponse,
        url: $('#ctx').val() + '/pages/product/proposal/form/editSubmit',
        type: 'post',
        clearForm: false,
        timeout: 30000
    };

    $('#proposalForm').ajaxForm(options);
    Editorial.Proposal.personTable = $('#person_table_report').dataTable({
        "bFilter": false, //开关，是否启用客户端过滤器
        "bProcessing": true, //当datatable获取数据时候是否显示正在处理提示信息。
        "bAutoWidth": false, //自适应宽度
        "sPaginationType": "full_numbers", //分页样式
        "bServerSide": true, //从服务器端取数据
        "sAjaxSource": $('#ctx').val() + "/pages/product/proposalPersonRela/form/manager", //mvc后台ajax调用接口。
        "fnServerParams": function (aoData) {
            aoData.push({"name": "proposalId", "value": $('#id').val()});
        },
        "fnServerData": Editorial.Proposal.retrievePersonData,
        "fnDrawCallback": function (oSettings) {
            for (var i = 0, iLen = oSettings.aiDisplay.length; i < iLen; i++) {
                $('td:eq(0)', oSettings.aoData[ oSettings.aiDisplay[i] ].nTr).html(i + oSettings._iDisplayStart + 1);
            }
        },
        "aoColumns": [
            {
                "sTitle": "序号",
                "mDataProp": "id",
                "bSortable": false
            },
            {
                "sTitle": "姓名",
                "mDataProp": "person.name",
                "bSortable": false
            },
            {
                "sTitle": "手机",
                "mDataProp": "person.phone",
                "bSortable": false
            },
            {
                "sTitle": "操作",
                "mData": null,
                "bSortable": false,
                "aTargets": [ -1 ],
                //自定义列的样式
                "fnRender": function (oObj) {
                    var start = '<div class="hidden-phone visible-desktop btn-group">';
                    var trash = '<button class="btn btn-mini btn-danger" title="删除" onclick="Editorial.Proposal.delPerson(\'' + oObj.aData.id + '\')"><i class="icon-trash bigger-120"></i></button>';

                    var end = '</div>';
                    return start + trash + end;
                }
            }
        ],
        //多语言配置
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
    Editorial.Proposal.roleCheck();

    Editorial.Proposal.AuthorTable = $('#author_table_report').dataTable({
        "bFilter": false, //开关，是否启用客户端过滤器
        "bProcessing": true, //当datatable获取数据时候是否显示正在处理提示信息。
        "bAutoWidth": false, //自适应宽度
        "sPaginationType": "full_numbers", //分页样式
        "bServerSide": true, //从服务器端取数据
        "sAjaxSource": $('#ctx').val() + "/pages/proposalAuthorRelationship/form/manager", //mvc后台ajax调用接口。
        "fnServerParams": function (aoData) {
            aoData.push({"name": "proposalId", "value": $('#id').val()});
        },
        "fnServerData": Editorial.Proposal.retrievePersonData,
        "fnDrawCallback": function (oSettings) {
            for (var i = 0, iLen = oSettings.aiDisplay.length; i < iLen; i++) {
                $('td:eq(0)', oSettings.aoData[ oSettings.aiDisplay[i] ].nTr).html(i + oSettings._iDisplayStart + 1);
            }
        },
        "aoColumns": [
            {
                "sTitle": "ID",
                "mDataProp": "id",
                "bSortable": false
            },
            {
                "sTitle": "贡献者姓名",
                "mDataProp": "personTypeRelationship.person.name",
                "bSortable": false
            },
            {
                "sTitle": "手机",
                "mDataProp": "personTypeRelationship.person.phone",
                "bSortable": false
            },
            {
                "sTitle": "操作",
                "mData": null,
                "bSortable": false,
                "aTargets": [ -1 ],
                "fnRender": function (oObj) {
                    var start = '<div class="hidden-phone visible-desktop btn-group">';
                    var trash = '<button class="btn btn-mini btn-danger" title="删除" type="button" onclick="Editorial.Proposal.authorDelObj(\'' + oObj.aData.id + '\')"><i class="icon-trash bigger-120"></i></button>';
                    var end = '</div>';
                    return start + trash + end;
                }
            }
        ],
        //多语言配置
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

});