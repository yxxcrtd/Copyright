<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<%@ include file="/pages/common/alert.jsp" %>
<%@ include file="/pages/common/context.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <title>后台管理</title>
    <meta name="description" content=""/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <!--[if IE 7]>
    <link rel="stylesheet" href="css/font-awesome-ie7.min.css"/>
    <![endif]-->
    <!--[if lte IE 8]>
    <link rel="stylesheet" href="css/ace-ie.min.css"/>
    <![endif]-->
    <!--inline styles if any-->
    <script src="${ctx}/js/common.js"></script>
    <script src="${ctx}/pages/product/proposal/org.js"></script>
</head>

<body>
<%@ include file="/pages/common/ajaxMsg.jsp" %>
<form:form id="proposalForm" commandName="form" class="form-horizontal">
    <form:hidden path="id" id="id"/>
</form:form>
<div class="clearfix">
    <div id="page-content" class="clearfix">
        <div class="row-fluid">
            <!-- ------------------导航页面部分开始----------------------------- -->
            <div class="page-header position-relative">
                <h1>
                    员工信息列表
                    </small>
                </h1>
            </div>
            <!-- ------------------导航页面部分结束----------------------------- -->


            <div class="row-fluid">

                <div class="ace-thumbnails">
                    <button class="btn btn-small btn-primary" onclick="Editorial.CRM.PersonInfo.saveObj();">
                        <i class="icon-plus-sign bigger-125"></i> 保存
                    </button>
                </div>
                <div class="table-header"><i class="icon-flag"></i>&nbsp;&nbsp;员工信息列表</div>
                <table id="table_report" class="table table-striped table-bordered table-hover">
                    <thead>
                    <tr>
                        <th width='10%' align='center'></th>
                        <th width='10%' align='center'></th>
                        <th width='10%' align='center'></th>
                        <th width='10%' align='center'></th>
                        <th width='10%' align='center'></th>
                        <th width='10%' align='center'></th>
                        <th width='10%' align='center'></th>
                        <th width='10%' align='center'></th>
                        <th width='10%' align='center'></th>
                    </tr>
                    </thead>
                    <tbody align='center' style="line-height: 18px; border: 1px solid #97bbdc;">

                    </tbody>
                    <tfoot>
                    <tr>
                        <th width='10%' align='center'></th>
                        <th width='10%' align='center'></th>
                        <th width='10%' align='center'></th>
                        <th width='10%' align='center'></th>
                        <th width='10%' align='center'></th>
                        <th width='10%' align='center'></th>
                        <th width='10%' align='center'></th>
                        <th width='10%' align='center'></th>
                        <th width='10%' align='center'></th>

                    </tr>
                    </tfoot>
                </table>
            </div>
        </div>
    </div>
</div>
</body>
</html>
