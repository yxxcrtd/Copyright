<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<%@ include file="/pages/common/context.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>公司类型属性维护</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<script src="${ctx}/js/common.js"></script>
<script src="${ctx}/pages/crm/corpTypeProp/list.js"></script>
<script src="${ctx}/pages/crm/corpTypeProp/edit.js"></script>
</head>

<body>
	<%@ include file="/pages/common/ajaxMsg.jsp"%>
	<div class="clearfix">
		<div id="page-content" class="clearfix">
			<div class="row-fluid">
				<!-- ------------------导航页面部分开始----------------------------- -->
				<div class="page-header position-relative">
					<h1>
						公司类型属性管理<small> <i class="icon-double-angle-right"></i> <c:if test="${form.id==null||form.id=='0'||form.id==''}">
			    	新增
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
					<form:form id="corpTypePropForm" commandName="form" class="form-horizontal">
						<div class="on-down">
					 	<div class="row-fluid ">
						<div class="row-fluid">
							<div class="control-group span6"  id="typePropClassifyDiv">
								<label class="control-label" for="form-field-2"><font class="red">*</font>分类：</label>
								<div class="controls">
									<form:select path="crmCtypeProp.corpTypePropClassify.id" id="typePropClassify" class="span8" onblur="Editorial.CRM.CorpTypeProp.classify();">
										<form:option value="">--选择--</form:option>
										<c:forEach items="${form.crmCtpClassifyList}" var="t">
											<form:option value="${t.id}">${t.name}</form:option>
										</c:forEach>
									</form:select>
									<span class="help-inline" id="typePropClassifySpan"></span>
								</div>
							</div>
							
							<div class="control-group span6" id="namesDiv" >
								<label class="control-label" for="form-field-1"><font class="red">*</font>名称：</label>
								<div class="controls">
									<form:input path="crmCtypeProp.name" id="names" class="span8" onblur="Editorial.CRM.CorpTypeProp.names();"/>
									<span class="help-inline" id="namesSpan"></span>
								</div>
							</div>
						</div>
						<div class="row-fluid">
							<div class="control-group span6" id="codeDiv">
								<label class="control-label" for="form-field-1"><font class="red">*</font>编号：</label>
								<div class="controls">
									<form:input path="crmCtypeProp.code" id="code" class="span8" onblur="Editorial.CRM.CorpTypeProp.code();"/>
									<span class="help-inline" id="codeSpan"></span>
								</div>
							</div>
							<div class="control-group span6" id="orderDiv">
								<label class="control-label" for="form-field-1"><font class="red">*</font>排序：</label>
								<div class="controls">
									<form:input path="crmCtypeProp.order" id="order"  onblur="Editorial.CRM.CorpTypeProp.order();" class="span8"/>
									<span class="help-inline" id="orderSpan"></span>
								</div>
							</div>
						</div>
						<div class="row-fluid">
							<div class="control-group span6" id="mustsDiv">
								<label class="control-label" for="form-field-1"><font class="red">*</font>是否必填：</label>
								<div class="controls">
									<form:select path="crmCtypeProp.must" id="musts" class="span8" onblur="Editorial.CRM.CorpTypeProp.musts();">
										<form:option value="">--选择--</form:option>
										<c:forEach items="${form.must}" var="t">
											<form:option value="${t.key}">${t.value}</form:option>
										</c:forEach>
									</form:select>
									<span class="help-inline" id="mustsSpan"></span>
								</div>
							</div>
							<div class="control-group span6" style="float: left;" id="displayDiv">
								<label class="control-label" for="form-field-1"><font class="red">*</font>显示方式：</label>
								<div class="controls">
									<form:select path="crmCtypeProp.display" id="display" class="span8" onblur="Editorial.CRM.CorpTypeProp.display();">
										<form:option value="">--选择--</form:option>
										<c:forEach items="${form.display}" var="t">
											<form:option value="${t.key}">${t.value}</form:option>
										</c:forEach>
									</form:select>
									<span class="help-inline" id="displaySpan"></span>
								</div>
							</div>
						</div>
						<div class="row-fluid">
							<div class="control-group span6">
								<label class="control-label" for="form-field-1">国际化编码：</label>
								<div class="controls">
									<form:input path="crmCtypeProp.internationCode" id="internationCode" class="span8" />
								</div>
							</div>
							<div class="control-group span6" id="diveffective">
								<label class="control-label" for="form-field-1">数据来源：</label>
								<div class="controls">
									<form:input path="crmCtypeProp.source" id="source" class="span8" />
								</div>
							</div>
						</div>
						<form:hidden path="id" />
						<form:hidden path="tid" />
						</div>
						</div>
						<!-- ------------------表单部分结束----------------------------- -->
						<!-- ------------------表单按钮部分开始----------------------------- -->
						<div class="form-actions" style="text-align: center; padding-left: 0px;">
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
