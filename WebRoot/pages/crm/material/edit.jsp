<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<%@ include file="/pages/common/context.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>后台管理</title>
<meta name="description" content="" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<script src="${ctx}/js/common.js"></script>
<script src="${ctx}/pages/crm/material/edit.js"></script>
</head>
<body>
	<div class="clearfix">
		<%@ include file="/pages/common/ajaxMsg.jsp"%>
		<div id="page-content" class="clearfix">
			<div class="row-fluid">
				<!-- ------------------导航页面部分开始----------------------------- -->
				<div class="page-header position-relative">
					<h1>材料信息
						<small><i class="icon-double-angle-right"></i>
							<c:choose>
								<c:when test="${form.material.materialId == null}">新建</c:when>
								<c:otherwise>修改</c:otherwise>
							</c:choose>
						</small>
					</h1>
				</div>
				<!-- ------------------导航页面部分结束----------------------------- -->
				<div class="row-fluid">

					<div class="table-header">基本信息</div>
					<div class="on-down">
					
					<form:form id="materialForm" commandName="form" class="form-horizontal">
						<form:hidden path="material.materialId" id="material_materialId" />
						<form:hidden path="material.crmCorpTypeRelationship.id" />
						
						<!-- ------------------表单部分开始----------------------------- -->
						
						
						
						<div class="control-group" id="material_materialName_div">
							<label class="control-label" for="form-field-1"><span class="red">*</span>材料名称：</label>
							<div class="controls">
								<form:input path="material.materialName" id="material_materialName" placeholder="材料名称" class="span6" onblur="Editorial.Material.validateMaterialName();" />
								<span id="material_materialName_span" class="help-inline"></span>
							</div>
						</div>

						<div class="control-group" id="material_materialCode_div">
							<label class="control-label" for="form-field-1"><span class="red">*</span>材料编号：</label>
							<div class="controls">
								<form:input path="material.materialCode" id="material_materialCode" placeholder="材料编号" class="span6" onblur="Editorial.Material.validateMaterialCode();" />
								<span id="material_materialCode_span" class="help-inline"></span>
							</div>
						</div>

						<div class="control-group" id="material_materialSpec_div">
							<label class="control-label" for="form-field-1"><span class="red">*</span>材料规格：</label>
							<div class="controls">
								<form:input path="material.materialSpec" id="material_materialSpec" placeholder="材料规格" class="span6" onblur="Editorial.Material.validateMaterialSpec();" />
								<span id="material_materialSpec_span" class="help-inline"></span>
							</div>
						</div>

						<div class="control-group" id="material_materialGrams_div">
							<label class="control-label" for="form-field-1"><span class="red">*</span>材料克重：</label>
							<div class="controls">
								<form:input path="material.materialGrams" id="material_materialGrams" placeholder="材料克重" class="span6" onblur="Editorial.Material.validateMaterialGrams();" />
								<span id="material_materialGrams_span" class="help-inline"></span>
							</div>
						</div>

						<div class="control-group" id="material_materialUnit_div">
							<label class="control-label" for="form-field-1"><span class="red">*</span>材料单位：</label>
							<div class="controls">
								<form:input path="material.materialUnit" id="material_materialUnit" placeholder="材料单位" class="span6" onblur="Editorial.Material.validateMaterialUnit();" />
								<span id="material_materialUnit_span" class="help-inline"></span>
							</div>
						</div>

						<div class="control-group" id="material_materialPrice_div">
							<label class="control-label" for="form-field-1"><span class="red">*</span>材料单价：</label>
							<div class="controls">
								<form:input path="material.materialPrice" id="material_materialPrice" placeholder="材料单价" class="span6" onblur="Editorial.Material.validateMaterialPrice();" />
								<span id="material_materialPrice_span" class="help-inline"></span>
							</div>
						</div>

						<div class="control-group" id="material_materialStock_div">
							<label class="control-label" for="form-field-1"><span class="red">*</span>材料库区：</label>
							<div class="controls">
								<form:input path="material.materialStock" id="material_materialStock" placeholder="材料库区" class="span6" onblur="Editorial.Material.validateMaterialStock();" />
								<span id="material_materialStock_span" class="help-inline"></span>
							</div>
						</div>

						<div class="control-group" id="material_materialStockCount_div">
							<label class="control-label" for="form-field-1"><span class="red">*</span>材料库存：</label>
							<div class="controls">
								<form:input path="material.materialStockCount" id="material_materialStockCount" placeholder="材料库存" class="span6" onblur="Editorial.Material.validateMaterialStockCount();" />
								<span id="material_materialStockCount_span" class="help-inline"></span>
							</div>
						</div>
						
						
						<!-- ------------------表单部分开始----------------------------- -->
						<!-- ------------------表单按钮部分开始----------------------------- -->
						<div class="form-actions" style="text-align: center; padding-left:0px;">
							<button class="btn btn-success" id="save">
								<i class="icon-save bigger-110"></i> 保存
							</button>
							&nbsp; &nbsp; &nbsp;
							<button class="btn btn-inverse" type="reset">
								<i class="icon-undo bigger-110"></i> 清空
							</button>
						</div>
						<!-- ------------------表单按钮部分结束----------------------------- -->
					</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>