<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<%@ include file="/pages/common/context.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>联系人管理</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<script src="${ctx}/js/common.js"></script>
<script src="${ctx}/pages/rightLicense/crRight/select_person_list.js"></script>
</head>
<body>
	<%@ include file="/pages/common/ajaxMsg.jsp"%>
	<div class="clearfix">
		<div id="page-content" class="clearfix">
			<div class="row-fluid">
				<div class="row-fluid">
					<!-- 功能按钮开始 -->
					<div class="ace-thumbnails">
						<button class="btn btn-small btn-primary" onclick="Editorial.SelectPerson.selectSubmit()" type="button">
							<i class="icon-plus-sign bigger-125"></i> 选中
						</button>
					</div>
					<!-- 功能按钮结束 -->
					<form:form id="selectCorpForm" commandName="form" action="manager" class="form-horizontal">
					<div class="table-header on" id="on">
						<i class="icon-caret-down"></i>&nbsp;&nbsp;查询条件
					</div>
					<div class="on-down" id="on_down">
						<div class="row-fluid">
							<!-- 查询条件开始 -->
							<div class="row-fluid">
								
								<div class="control-group span6">
									<label class="control-label" for="form-field-1">人员名称：</label>
									<div class="controls">
										<form:input path="obj.name" id="person_name" cssClass="span10" placeholder="人员名称" />
									</div>
								</div>
								
								<div class="control-group span6">
									<label class="control-label" for="form-field-1">人员类型：</label>
									<div class="controls">
										<form:select path="personType.code" id="personType_code">
											<form:option value="">--选择--</form:option>
											<form:options items="${personTypeList}" itemValue="code" itemLabel="name" />
										</form:select>
									</div>
								</div>
								
							</div>
							<!-- 查询条件结束 -->
							
							<!-- 查询按钮开始 -->
							<div style="text-align: center;">
								<button class="btn btn-small btn-success" type="button" onclick="Editorial.SelectPerson.query()">
									<i class="icon-zoom-in bigger-110"></i>查询
								</button>
								&nbsp;&nbsp;
								<button type="reset" class="btn btn-small btn-inverse">
									<i class="icon-repeat bigger-110"></i>重置
								</button>
							</div>
							<!-- 查询按钮结束 -->
						</div>
					</div>
					<!-- 列表部分开始 -->
					<div class="table-header">
						<i class="icon-flag"></i>&nbsp;&nbsp;联系人信息列表
					</div>
					<table id="selectPersonDataTable" class="table table-striped table-bordered table-hover">
						<thead>
							<tr>
								<th width="10%" align="center"></th>
								<th width="10%" align="center"></th>
								<th width="10%" align="center"></th>
								<th width="10%" align="center"></th>
							</tr>
						</thead>
						<tbody align="center" style="line-height: 18px; border: 1px solid #97bbdc;"></tbody>
						<tfoot>
							<tr>
								<th width="10%" align="center"></th>
								<th width="10%" align="center"></th>
								<th width="10%" align="center"></th>
								<th width="10%" align="center"></th>
							</tr>
						</tfoot>
					</table>
					</form:form>
					<!-- 列表部分结束 -->
				</div>
			</div>
		</div>
	</div>
</body>
</html>