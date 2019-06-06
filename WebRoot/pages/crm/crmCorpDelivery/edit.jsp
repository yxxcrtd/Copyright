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
<script src="${ctx}/pages/crm/crmCorpDelivery/edit.js"></script>
</head>
<body>
	<div class="clearfix">
		<%@ include file="/pages/common/ajaxMsg.jsp"%>
		<div id="page-content" class="clearfix">
			<div class="row-fluid">
				<!-- ------------------导航页面部分开始----------------------------- -->
				<div class="page-header position-relative">
					<h1>收货信息
						<small><i class="icon-double-angle-right"></i>
							<c:choose>
								<c:when test="${form.delivery.id == null}">新建</c:when>
								<c:otherwise>修改</c:otherwise>
							</c:choose>
						</small>
					</h1>
				</div>
				<!-- ------------------导航页面部分结束----------------------------- -->
				<div class="row-fluid">
					
					<div class="table-header">基本信息</div>
					<div class="on-down">
					
					<form:form id="crmCorpDeliveryForm" commandName="form" class="form-horizontal">
						<form:hidden path="delivery.id" id="delivery_id" />
						<form:hidden path="delivery.crmCorpTypeRelationship.id" />
						
						<!-- ------------------表单部分开始----------------------------- -->

						<div class="control-group" id="delivery_corpName_div">
							<label class="control-label" for="form-field-1"><span class="red">*</span>收货单位：</label>
							<div class="controls">
								<form:input path="delivery.corpName" id="delivery_corpName" placeholder="收货单位" class="span6" onblur="Editorial.Material.validateDeliveryCorpName();" />
								<span id="delivery_corpName_span" class="help-inline"></span>
							</div>
						</div>
						<div class="control-group" id="delivery_corpAddress_div">
							<label class="control-label" for="form-field-1"><span class="red">*</span>收货地址：</label>
							<div class="controls">
								<form:input path="delivery.corpAddress" id="delivery_corpAddress" placeholder="收货地址" class="span6" onblur="Editorial.Material.validateDeliveryCorpAddress();" />
								<span id="delivery_corpAddress_span" class="help-inline"></span>
							</div>
						</div>
						<div class="control-group" id="delivery_receiverName_div">
							<label class="control-label" for="form-field-1"><span class="red">*</span>收货联系人：</label>
							<div class="controls">
								<form:input path="delivery.receiverName" id="delivery_receiverName" placeholder="收货联系人" class="span6" onblur="Editorial.Material.validateDeliveryReceiverName();" />
								<span id="delivery_receiverName_span" class="help-inline"></span>
							</div>
						</div>
						<div class="control-group" id="delivery_tel_div">
							<label class="control-label" for="form-field-1"><span class="red">*</span>收货联系电话：</label>
							<div class="controls">
								<form:input path="delivery.tel" id="delivery_tel" placeholder="收货联系电话" class="span6" onblur="Editorial.Material.validateDeliveryTel();" />
								<span id="delivery_tel_span" class="help-inline"></span>
							</div>
						</div>
						<div class="control-group" id="delivery_fax_div">
							<label class="control-label" for="form-field-1"><span class="red">*</span>收货联系传真：</label>
							<div class="controls">
								<form:input path="delivery.fax" id="delivery_fax" placeholder="收货联系传真" class="span6" onblur="Editorial.Material.validateDeliveryFax();" />
								<span id="delivery_fax_span" class="help-inline"></span>
							</div>
						</div>

						<div class="control-group" id="delivery_postcode_div">
							<label class="control-label" for="form-field-1">收货邮编：</label>
							<div class="controls">
								<form:input path="delivery.postcode" id="delivery_postcode" placeholder="收货邮编" class="span6" />
								<span id="delivery_postcode_span" class="help-inline"></span>
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