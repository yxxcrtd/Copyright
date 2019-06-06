<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<%@ include file="/pages/common/context.jsp" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <title>策划创意管理</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <script src="${ctx}/js/common.js"></script>
    <script src="${ctx}/pages/product/proposal/list.js"></script>
    <script src="${ctx}/pages/product/proposal/edit.js"></script>
    <script src="${ctx}/pages/product/proposal/edit_init.js"></script>
</head>
<body>
<%@ include file="/pages/common/ajaxMsg.jsp" %>
<div class="clearfix">
    <div id="page-content" class="clearfix">
        <div class="row-fluid">
            <!-- ------------------导航页面部分开始----------------------------- -->
            <div class="page-header position-relative">
                <h1>
                    策划创意管理
                    <small><i class="icon-double-angle-right"></i> <c:if
                            test="${form.id==null||form.id=='0'||form.id==''}">
                        新增策划创意
                    </c:if> <c:if test="${form.id!=null&&form.id!='0'&&form.id!=''}">
                        修改策划创意
                    </c:if>
                    </small>
                </h1>
            </div>
            <!-- ------------------导航页面部分结束----------------------------- -->
            <div class="row-fluid">
                <!-- ------------------表单部分开始----------------------------- -->
                <div class="table-header on">
                    基本信息
                </div>
                <form:form id="proposalForm" commandName="form" class="form-horizontal">
                    <div class="on-down">
                        <div class="control-group" id="nameDiv">
                            <label class="control-label" for="form-field-1"><span class="red">*</span>策划创意名称：</label>
                            <div class="controls">
                                <form:input path="obj.name" id="name" onblur="Editorial.Proposal.namea();"
                                            class="span8"/>
                                <span id="nameSpan" class="help-inline"></span>
                            </div>
                        </div>
                        <div class="control-group" id="descDiv">
                            <label class="control-label" for="form-field-1"><span class="red">*</span>策划创意描述：</label>
                            <div class="controls">
                                <form:textarea path="obj.desc" id="desc" onblur="Editorial.Proposal.desc();"
                                               class="span8 h100"/>
                                <span id="descSpan" class="help-inline"></span>
                            </div>
                        </div>
                        <div class="control-group" id="descDiv">
                            <label class="control-label" for="form-field-1"><span class="red">*</span>策划人：</label>
                            <div class="controls">
                                <form:textarea path="obj.createBy" id="createBy" class="span8 h100"/>
                                <span id="descSpan" class="help-inline"></span>
                            </div>
                        </div>
                        <div class="control-group " id = "roleTypeDiv">
                            <label class="control-label" for="form-field-2"><span class="red">*</span>可见范围：</label>
                            <div class="controls">
                                <form:select path="obj.roleType" id="roleType" class="span8" onblur="Editorial.Proposal.roleType()">
                                    <form:option value="">--选择--</form:option>
                                    <c:forEach items="${form.roleTypeMap}" var="t">
                                        <form:option value="${t.key}">${t.value}</form:option>
                                    </c:forEach>
                                </form:select>
                                <span id="roleTypeSpan" class="help-inline"></span>

                            </div>
                        </div>
                        <form:hidden path="isEdit" id = "edit" />
                        <form:hidden path="teamWork" id="teamWork"/>
                        <form:hidden path="obj.id" id="id"/>
                    </div>
                    <!-- ------------------表单部分结束----------------------------- -->
                    <!-- ------------------表单按钮部分开始----------------------------- -->
                    <div class="form-actions" style="text-align: center; padding-left:0px;">
                        <button class="btn btn-success" id="save" type="submit">
                            <i class="icon-save bigger-110"></i> 保存
                        </button>
                        &nbsp; &nbsp; &nbsp;
                        <button class="btn btn-inverse" type="reset" id="reset">
                            <i class="icon-undo bigger-110"></i> 清空
                        </button>
                    </div>
                    <!-- ------------------表单按钮部分结束----------------------------- -->
                </form:form>
            </div>
        </div>
    </div>
</div>
</body>
</html>