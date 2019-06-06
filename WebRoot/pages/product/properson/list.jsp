<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<%@ include file="/pages/common/common.jsp"%>
<%@ include file="/pages/common/alert.jsp"%>
<%@ include file="/pages/common/context.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>贡献者管理</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<script src="${ctx}/js/common.js"></script>
<script src="${ctx}/pages/product/properson/list.js"></script>
</head>
<body>
	<div class="clearfix">
		<div id="page-content" class="clearfix">
			<div class="row-fluid">
			<!-- ------------------导航页面部分开始----------------------------- -->
				<div class="page-header position-relative" >
					<h1 id="productTitle">
						贡献者管理 <small> <i class="icon-double-angle-right"></i>
							贡献者信息
						</small>
					</h1>
            </div>
            <!-- ------------------导航页面部分结束----------------------------- -->
            <div class="row-fluid">
               <div class="ace-thumbnails">
                    <button class="btn btn-small btn-primary" id="productAddButton"
                            onclick="Editorial.Product.ProductInfo.resetObj();">
                        <i class="icon-circle-arrow-left bigger-125"></i> 返回产品列表
                    </button>
                    <button class="btn btn-small btn-primary" id="productAddButton"
                            onclick="Editorial.Product.ProductInfo.addObj();">
                        <i class="icon-plus-sign bigger-125"></i> 添加贡献者
                    </button>
                </div>
                    <div id="productListTitle" class="table-header">
                        <i class="icon-flag"></i>&nbsp;&nbsp;贡献者信息列表
                    </div>
					<table id="table_report"
						class="table table-striped table-bordered table-hover">
						<thead>
							<tr>
								<th width='10%' align='center'></th>
                                <th width='10%' align='center'></th>
								<th width='10%' align='center'></th>
							</tr>
						</thead>
						<tbody align='center'
							style="line-height: 18px; border: 1px solid #97bbdc;">

						</tbody>
						<tfoot>
							<tr>
                                <th width='10%' align='center'></th>
                                <th width='10%' align='center'></th>
                                <th width='10%' align='center'></th>
							</tr>
						</tfoot>
					</table>
					<input type="hidden" name="productId" id="productId" value="${form.productId}" />
					<!-- ------------------列表页面部分结束----------------------------- -->
				</div>
			</div>
		</div>
	</div>
</body>
</html>