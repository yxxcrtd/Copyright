<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<%@ include file="/pages/common/context.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />

<title>公司类型维护</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta name="description" content="" />
<script src="${ctx}/js/common.js"></script>
<script src="${ctx}/pages/crm/corpType/list.js"></script>
<script src="${ctx}/pages/crm/corpType/edit.js"></script>
</head>
<body>
	<%@ include file="/pages/common/ajaxMsg.jsp"%>
	<div class="clearfix">
		<div id="page-content" class="clearfix">
			<div class="row-fluid">
				<!-- ------------------导航页面部分开始----------------------------- -->
				<div class="page-header position-relative">
					<h1>
						公司类型信息管理<small> <i class="icon-double-angle-right"></i> <c:if
								test="${form.id==null||form.id=='0'||form.id==''}">
			    	新建
			    </c:if> <c:if test="${form.id!=null&&form.id!='0'&&form.id!=''}">
			    	修改
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
					<form:form id="corpTypeForm" commandName="form"
						class="form-horizontal">
						<div class="on-down">
					 	<div class="row-fluid ">
						<div class="control-group" id="nameDiv">
							<label class="control-label" for="form-field-1"><font class="red">*</font>名称：</label>
							<div class="controls">
								<form:input path="crmCorpType.name" id="name"  onblur="Editorial.CRM.CorpType.typeName();" class="span6"/>
								<span id="nameSpan" class="help-inline"></span>
							</div>
						</div>
						<div class="control-group" id="codeDiv">
							<label class="control-label" for="form-field-1"><font class="red">*</font>编号：</label>
							<div class="controls">
								<form:input path="crmCorpType.code" id="code"  onblur="Editorial.CRM.CorpType.code();" class="span6"/>
								<span id="codeSpan" class="help-inline"></span>
							</div>
						</div>
						<div class="control-group">
							<label class="control-label" for="form-field-1">国际化编码：</label>
							<div class="controls">
								<form:input path="crmCorpType.internationCode" id="internationCode" class="span6" />
							</div>
						</div>
						<form:hidden path="id" id="typeId"/>
						<%-- <form:hidden path="fatherId"/> --%>
					</div>
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