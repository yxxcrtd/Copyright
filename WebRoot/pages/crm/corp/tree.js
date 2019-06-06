var corpSpace = {};

corpSpace.action = null; // 操纵类型
corpSpace.ctx = null; // 跟路径
corpSpace.corpType_id = null; //类型ID
corpSpace.corpType_code = null; // 类型编码
corpSpace.corpType_name = null; // 类型名称

corpSpace.treeId = "treeManage";
corpSpace.tree = null; // 树菜单对象
corpSpace.rightMenu = null;
corpSpace.shadow = null;

corpSpace.codeValueIsFromAutocomplete = false; // 编号的值是否来自自动补全
corpSpace.availableCorpList = null; // 当前可用的组织数据

corpSpace.beforeCorpCode = null;
corpSpace.beforeCorpCodeValueIsFromAutocomplete = false;

/**
 * 初始化公司编码自动补全组件数据
 */
corpSpace.initCorpCodeAutocompleteData = function() {
	$.ajax({
		"dataType" : "json",
		"type" : "POST",
		"url" : corpSpace.ctx + "/pages/crmCorp/form/getAvailableCorpList",
		data : {
			"corpType.id" : corpSpace.corpType_id
		},
		"cache" : false,
		"success" : function(response) {
			corpSpace.availableCorpList = response;
		}
	});
}

/**
 * 初始化公司编码自动补全组件
 */
corpSpace.initCorpCodeAutocomplete = function() {
	corpSpace.corpCodeAutocompleteDestroy();
	$("#corp_code").autocomplete({
		source: corpSpace.availableCorpList,
		autoFocus: true,
		delay: 0,
		minLength: 0,
		select: function(event, ui) {
			$("#corp_id").val(ui.item.id);
			$("#corp_code").val(ui.item.code);
			$("#corp_shortName").val(ui.item.shortName);
			$("#corp_fullName").val(ui.item.fullName);
			$("#corp_introduction").val(ui.item.introduction);
			
			corpSpace.codeValueIsFromAutocomplete = true;
			return false;
		}
	});
}

/**
 * 销毁公司编码自动补全组件
 */
corpSpace.corpCodeAutocompleteDestroy = function() {
	try {
		$("#corp_code").autocomplete("destroy");
	} catch (e) {
	}
}

corpSpace.addNode = function() {
	corpSpace.action = "add";
	$("#corp_nameFirstChar_div").hide();
	corpSpace.rightMenuHide();
	corpSpace.clearValidatePrompt();
	corpSpace.enableAllButton();
	var selectNode = corpSpace.selectedNode();
	
	$("#corp_code").removeAttr("disabled");
	corpSpace.initCorpCodeAutocomplete();
	$.customProperty.destroy("cp1"); // 销毁自定义控件
	
	corpSpace.resetForm(); // 清空form表单值
	$("#corp_id").val("");
	
	$("#relation_id").val("");
	$("#relation_parent_id").val(selectNode.id);
	
	$("#subTitle").html("新增");
	corpSpace.showContent();
	
	
}

corpSpace.editNode = function() {
	corpSpace.action = "edit";
	$("#corp_nameFirstChar_div").show();
	corpSpace.rightMenuHide();
	corpSpace.clearValidatePrompt();
	corpSpace.enableAllButton();
	var selectNode = corpSpace.selectedNode();
	$.ajax({
		"dataType" : "json",
		"type" : "POST",
		"url" : corpSpace.ctx + "/pages/crmCorp/form/editTreeNode",
		"cache" : false,
		"data" : {
			"relation.id" : selectNode.id,
			"corpType.id" : corpSpace.corpType_id,
			"corpType.code" : corpSpace.corpType_code
		},
		"success" : function(response) {
			$("#corp_code").attr("disabled", "disabled");
			corpSpace.corpCodeAutocompleteDestroy();
			
			$("#relation_id").val(response.relation.id);
			$("#relation_parent_id").val(response.relation.parentRelationship.id);
			
			$("#corp_id").val(response.relation.corp.id);
			$("#corp_code").val(response.relation.corp.code);
			$("#corp_shortName").val(response.relation.corp.shortName);
			$("#corp_fullName").val(response.relation.corp.fullName);
			$("#corp_introduction").val(response.relation.corp.introduction);
			$("#corp_nameFirstChar").val(response.relation.corp.nameFirstChar);
			
			var cus1 = $.customProperty.create({
				renderTo: "cp1",
				add_tab_url: $("#ctx").val() + "/pages/crmCorp/form/addTab",
				main_data_param: {
					name: "relation.id",
					value: $("#relation_id").val()
				},
				type_data_param: {
					name: "corpType.id",
					value: $("#corpType_id").val()
				},
				classify_data_param: {
					name: "corpTypePropClassify.id",
					value: ""
				},
				prop_data_param: {
					id_name: "propsId",
					value_name: "propsValue"
				},
				classify_list: {
					name: "typePropClassifyList",
					field: {
						id: "id",
						code: "code",
						name: "name"
					}
				},
				prop_list: {
					name: "corpPropList",
					field: {
						id: "id",
						code: "code",
						name: "name",
						value: "value",
						display: "display",
						must: "must",
						source: "source"
					}
				}
			});
			
			$("#subTitle").html("修改");
			corpSpace.showContent();
			
		}
	});
	
}

String.prototype.stripHTML = function () {

    var b = this.match(/(?=title)\b[^\s]+=["']?[^"']*["']?(?=\s|>)/gi);
    var s = b + "";
    var a = s.slice(7, s.length - 1);
    return a;
};

corpSpace.removeNode = function() {
	corpSpace.rightMenuHide();
	var selectNode = corpSpace.selectedNode();
	if (selectNode.children == undefined || selectNode.children.length == 0) {
		openConfirmModalInFrame("确认要删除" + selectNode.name.stripHTML() + corpSpace.corpType_name + "吗？", function() {
			$.ajax({
				"dataType" : "json",
				"type" : "POST",
				"url" : corpSpace.ctx + "/pages/crmCorp/form/delete?relation.id=" + selectNode.id,
				"cache" : false,
				success : function(response) {
					if(response.isSuccess == "true") {
						corpSpace.getTree().removeNode(selectNode);
						openSuccessAlertModalInFrame(response.msg);
					} else {
						openErrorAlertModalInFrame(response.msg);
					}
					corpSpace.hideContent();
				}
			});
			
		}, null, null);
		
	} else {
		openErrorAlertModalInFrame("该节点有子节点无法删除，请先删除子节点。");
	}

}

/**
 * 获取当前选中树节点
 */
corpSpace.selectedNode = function() {
	return corpSpace.tree.getSelectedNodes()[0];
}

/**
 * 根据树节点ID获取节点
 */
corpSpace.getNodeById = function(id) {
	return corpSpace.getTree().getNodeByParam("id", id);
}

/**
 * 初始化公用参数
 */
corpSpace.initParam = function() {
	corpSpace.ctx = $("#ctx").val();
	corpSpace.corpType_id = $("#corpType_id").val();
	corpSpace.corpType_code = $("#corpType_code").val();
	corpSpace.corpType_name = $("#corpType_name").val();
}

corpSpace.shadowShow = function(width, height, x, y) {
	corpSpace.shadow.css({
		"width" : width + "px",
		"height" : height + "px",
		"left" : x + 4 + "px",
		"top" : y + 4 + "px",
		"visibility" : "visible"
	});
}

/**
 * 鼠标按下事件，隐藏右键菜单
 */
corpSpace.onBodyMouseDown = function(event) {
	if (!(event.target.id == "rMenu" || $(event.target).parents("#rMenu").length > 0)) {
		corpSpace.rightMenu.css({
			"visibility" : "hidden"
		});
		corpSpace.shadow.css({
			"visibility" : "hidden"
		});
	}
}

/**
 * 显示右键菜单
 */
corpSpace.rightMenuShow = function(node, x, y) {
	if(node != null) {
		$("#rMenu ul").show();
		$("#shadow").show();
		if (node.level == 0) {// 根节点
			$("#add").show();
			$("#edit").hide();
			$("#delete").hide();
			$("#upload").show();
		} else if(node)  { // 叶子节点
			if(node.isParent){
				$("#delete").hide();
			} else {
				$("#delete").show();
			}
			$("#add").show();
			$("#edit").show();
			$("#upload").hide();
		}
		corpSpace.shadowShow(corpSpace.rightMenu.width(), corpSpace.rightMenu.height(), x, y);
		corpSpace.rightMenu.css({
			"top" : y + "px",
			"left" : x + "px",
			"visibility" : "visible"
		});
		$("body").bind("mousedown", corpSpace.onBodyMouseDown);
	}
}

/**
 * 隐藏右键菜单
 */
corpSpace.rightMenuHide = function() {
	if (corpSpace.rightMenu) {
		corpSpace.rightMenu.css({
			"visibility" : "hidden"
		});
	}
	if (corpSpace.shadow) {
		corpSpace.shadow.css({
			"visibility" : "hidden"
		});
	}
	$("body").unbind("mousedown", BMEP.Client.ClientInfo.Tree.onBodyMouseDown);
}

corpSpace.onNodeCreatedFn = function(event, treeId, treeNode) {
	corpSpace.getTree().selectNode(treeNode);
	corpSpace.editNode();
}

corpSpace.onRightClickFn = function(event, treeId, treeNode) {
	corpSpace.tree.selectNode(treeNode); // 选中右键点击的节点
	var pos = getFrameTreeRightMenuPosition(event);
	corpSpace.rightMenuShow(treeNode, pos.x, pos.y);
}

/**
 * 初始化树菜单
 */
corpSpace.initTree = function() {
	if (corpSpace.tree != null) {
		$.fn.zTree.destroy(corpSpace.treeId);
	}
	var setting = {
		view: {
			expandSpeed: 0,
			nameIsHTML: true,
			selectedMulti: false
		},
		data: {
			simpleData: {
				enable: true,
				idKey: "id",
				pIdKey: "pid",
				rootPId: "root"
			}
		},
		callback : {
			onRightClick: corpSpace.onRightClickFn
		}
	};
	
	var rootNode = {
		id : "root",
		name : corpSpace.corpType_name,
		isRoot : "true",
		isParent : true,
		icon : corpSpace.ctx + "/img/configration1.gif",
		open : false
	};
	
	$.ajax({
		"dataType" : "json",
		"type" : "POST",
		"url" : corpSpace.ctx + "/pages/crmCorp/form/getAllTreeNodes",
		data : {
			"corpType.code" : corpSpace.corpType_code
		},
		"cache" : false,
		"success" : function(response) {
            response = addCssForNodeSmall(response);
			response.push(rootNode);
			corpSpace.tree = $.fn.zTree.init($("#" + corpSpace.treeId), setting, response);
			corpSpace.tree.expandAll(true);
			
			corpSpace.rightMenu = $("#rMenu");
			corpSpace.shadow = $("#shadow");
		}
	});
};

corpSpace.getTree = function() {
	if (corpSpace.tree == null) {
		corpSpace.tree = $.fn.zTree.getZTreeObj(corpSpace.treeId);
	}
	return corpSpace.tree;
}

corpSpace.treeCallbackBind = function() {
	corpSpace.getTree().setting.callback.onNodeCreated = corpSpace.onNodeCreatedFn;
}

corpSpace.treeCallbackUnbind = function() {
	corpSpace.getTree().setting.callback.onNodeCreated = null;
}

corpSpace.hideTree = function() {
	$("#" + corpSpace.treeId).toggleClass("hide");
}

corpSpace.showContent = function() {
	corpSpace.scrollToTop();
	$("#content").removeClass("hide");
}

corpSpace.hideContent = function() {
	$("#content").addClass("hide");
}

corpSpace.disableAllButton = function() {
	$("#save").attr("disabled", "true");
	$("#reset").attr("disabled", "true");
}

corpSpace.enableAllButton = function() {
	$("#save").removeAttr("disabled");
	$("#reset").removeAttr("disabled");
}

corpSpace.resetForm = function() {
	$("#crmCorpForm").clearForm();
}

corpSpace.scrollToTop = function() {
	$([document.body, document.documentElement]).animate({scrollTop: 0}, "normal");
}

corpSpace.codeFocusFn = function() {
	corpSpace.beforeCorpCode = $("#corp_code").val();
	corpSpace.beforeCorpCodeValueIsFromAutocomplete = corpSpace.codeValueIsFromAutocomplete;
	
	corpSpace.codeValueIsFromAutocomplete = false;
}

corpSpace.validate_code = function() {
	var flag = true;
	var corp_code = $("#corp_code");
	corp_code.val(corp_code.val().trim());
	if (corp_code.val() == "") {
		$("#corp_id").val("");
		if (corpSpace.beforeCorpCodeValueIsFromAutocomplete) {
			$("#corp_shortName").val("");
			$("#corp_fullName").val("");
			$("#corp_introduction").val("");
		}
		$("#corp_code_div").removeClass("success").addClass("error");
		$("#corp_code_span").html("编码不能为空！");
		flag = false;
	} else {
		if (corpSpace.beforeCorpCode != corp_code.val()) {
			if (!corpSpace.codeValueIsFromAutocomplete) {
				if (corpSpace.beforeCorpCodeValueIsFromAutocomplete) {
					$("#corp_id").val("");
					$("#corp_shortName").val("");
					$("#corp_fullName").val("");
					$("#corp_introduction").val("");
				}
				
				$.ajax({
					"dataType": "json",
					"type": "POST",
					"url": corpSpace.ctx + "/pages/crmCorp/form/checkCodeIsAvailable",
					data: {
						"corp.code": corp_code.val()
					},
					"cache": false,
					async: false,
					"success": function(response) {
						if(!response.corpCodeIsAvailable) {
							flag = false;
							$("#corp_code_div").removeClass("success").addClass("error");
							$("#corp_code_span").html("编码已存在！");
						}
					}
				});
				
			}
		} else {
			corpSpace.codeValueIsFromAutocomplete = corpSpace.beforeCorpCodeValueIsFromAutocomplete;
		}
	}
	
	if(flag) {
		$("#corp_code_div").removeClass("error").addClass("success");
		$("#corp_code_span").html("可以使用");
	}
	
	corpSpace.validate_shortName();
	return flag;
}

corpSpace.validate_shortName = function() {
	$("#corp_shortName").val($("#corp_shortName").val().trim());
	if($("#corp_shortName").val() == "") {
		$("#corp_shortName_div").removeClass("success").addClass("error");
		$("#corp_shortName_span").html("简称不能为空！");
		return false;
	} else {
		$("#corp_shortName_div").removeClass("error").addClass("success");
		$("#corp_shortName_span").html("可以使用");
		return true;
	}
}


corpSpace.validate = function() {
	var flag = true;
	if(corpSpace.action == "add") {
		if(!corpSpace.validate_code()) {
			flag = false;
		}
	}
	
	if(!corpSpace.validate_shortName()) {
		flag = false;
	}
	
	if(flag) {
		corpSpace.disableAllButton();
	}
	
	return flag;
}

/**
 * 清空验证提示信息
 */
corpSpace.clearValidatePrompt = function() {
	$("#corp_code_div").removeClass("success").removeClass("error");
	$("#corp_code_span").html("");
	
	$("#corp_shortName_div").removeClass("success").removeClass("error");
	$("#corp_shortName_span").html("");
}

corpSpace.submitSuccess = function(response) {
	openSuccessAlertModalInFrame(response.msg);
	if (corpSpace.action == "add") {
		corpSpace.treeCallbackBind();
		corpSpace.getTree().addNodes(corpSpace.getNodeById(response.node.pid), response.node);
		corpSpace.treeCallbackUnbind();
	}
	if (corpSpace.action == "edit") {
		var selectNode = corpSpace.getNodeById(response.relation.id);
		selectNode.name = response.relation.corp.shortName;
		corpSpace.getTree().updateNode(selectNode);
		corpSpace.getTree().selectNode(selectNode);
		corpSpace.editNode();
	}
}

corpSpace.upload = function() {
	var selectNode = corpSpace.selectedNode();
	corpSpace.rightMenuHide();
	if (selectNode) {
		var url = $("#ctx").val() + "/pages/crmCorp/form/upload";
		url += "?corpType.id=" + corpSpace.corpType_id;
		
		var commonModalCss = {
			"width": "500px",
			"height" : "260px"
		};
		var commonModalBodyCss = {
			"max-height" : "800px"
		};
		openCommonModalInFrame(url, commonModalCss, commonModalBodyCss);
	} else {
		alert("请先选择节点!");
	}
	
}

corpSpace.onload = function() {
	corpSpace.initParam();
	corpSpace.initTree();
	corpSpace.initCorpCodeAutocompleteData();
	
	var options = {
		beforeSubmit : corpSpace.validate,
		success : corpSpace.submitSuccess,
		url : corpSpace.ctx + "/pages/crmCorp/form/editTreeNodeSubmit",
		type : "post",
		clearForm : false,
		timeout : 10000
	};
	$("#crmCorpForm").ajaxForm(options);
};

$(function() {
	corpSpace.onload();
});