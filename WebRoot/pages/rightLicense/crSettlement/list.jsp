<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<%@ include file="/pages/common/common.jsp"%>
<%@ include file="/pages/common/context.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>版税结算管理</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<script src="${ctx}/js/common.js"></script>
<script src="${ctx}/pages/rightLicense/crSettlement/list.js"></script>
</head>
<body>
	<div class="clearfix">
		<div id="page-content" class="clearfix">
			<div class="row-fluid">
				<!-- ------------------导航页面部分开始----------------------------- -->
				<!--  <div class="page-header position-relative" >
					<h1 id="productTitle">
						资源管理 <small> <i class="icon-double-angle-right"></i>
							资源管理列表
						</small>
					</h1>
            </div>-->
            <!-- ------------------导航页面部分结束----------------------------- -->
            <div class="row-fluid">
                <!-- ------------------功能页面部分开始----------------------------- -->
                <!-- ------------------功能按钮开始----------------------------- -->
                <div class="ace-thumbnails">
                  	  产品订单号&nbsp;&nbsp;:&nbsp;&nbsp;<input name="productCode" id="productCode"/>&nbsp;&nbsp;
                    <button class="btn btn-small btn-primary" id="productAddButton"
                            onclick="Editorial.Settlement.addObj();">
                        <i class="icon-plus-sign bigger-125"></i> 开始版税结算
                    </button>
                </div>
                <!-- ------------------功能按钮结束----------------------------- -->

					<!-- ------------------查询开始----------------------------- -->
					<div class="table-header on">
						<i class="icon-caret-down"></i>&nbsp;&nbsp;查询条件
					</div>
					<div class="on-down">
						<form:form id="form" commandName="form" action="manager" class="form-horizontal">
							<div class="row-fluid">
								<div class="row-fluid">
									<div class="control-group span3">
										<label class="control-label" for="form-field-1">订单号：</label>
										<div class="controls">
											<form:input path="code" id="query_settlement_code" cssClass="span10" />
										</div>
									</div>
									<div class="control-group span3">
										<label class="control-label" for="form-field-1">贡献者：</label>
										<div class="controls">
											<form:input path="name" id="query_settlement_name" cssClass="span10" />
										</div>
									</div>
									<div class="control-group span3">
										<label class="control-label" for="form-field-1">版税结算状态：</label>
										<div class="controls">
											<form:select path="setStatus" id="query_settlement_status" cssClass="span10">
												<form:option value="">--选择--</form:option>
												<form:options items="${form.dic.CrSettlementType}" />
											</form:select>
										</div>
									</div>
								</div>
								<div style="text-align: center;">
									<button class="btn btn-small btn-success" type="button" onclick="Editorial.Settlement.query();">
										<i class="icon-save bigger-110"></i>查询
									</button>
									&nbsp;&nbsp;
									<button type="reset" class="btn btn-small btn-inverse">
										<i class="icon-print bigger-110"></i>重置
									</button>
								</div>
							</div>
						</form:form>
					</div>
					<!-- ------------------查询结束---------------------------------- -->
					<!-- ------------------功能页面部分结束----------------------------- -->
					<!-- ------------------列表页面部分开始----------------------------- -->

                    <div id="productListTitle" class="table-header">
                        <i class="icon-flag"></i>&nbsp;&nbsp;版税结算管理列表
                    </div>
					<table id="table_report"
						class="table table-striped table-bordered table-hover">
						<thead>
							<tr>
								<th width='5%' align='center'></th>
                                <th width='10%' align='center'></th>
								<th width='10%' align='center'></th>
								<th width='10%' align='center'></th>
								<th width='10%' align='center'></th>
								<th width='10%' align='center'></th>
								<th width='10%' align='center'></th>
								<th width='5%' align='center'></th>
							</tr>
						</thead>
						<tbody align='center'
							style="line-height: 18px; border: 1px solid #97bbdc;">

						</tbody>
						<tfoot>
							<tr>
                                <th width='5%' align='center'></th>
                                <th width='10%' align='center'></th>
                                <th width='10%' align='center'></th>
                                <th width='10%' align='center'></th>
                                <th width='10%' align='center'></th>
                                <th width='10%' align='center'></th>
                                <th width='10%' align='center'></th>
                                <th width='5%' align='center'></th>
							</tr>
						</tfoot>
					</table>
					<!-- ------------------列表页面部分结束----------------------------- -->
				</div>
			</div>
		</div>
	</div>
</body>
</html>