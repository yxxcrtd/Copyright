/*var setting = {
	async: {
		enable: true,
		url:$('#ctx').val()+"/pages/base/country/form/getMenuZTree",
		autoParam:["id", "otherId"],
		dataFilter: filter,
		type: "get"
	},edit: {
		enable: true,
		showRemoveBtn: false,
		showRenameBtn: false
	},callback: {
		onRightClick: OnRightClick,
	}
};
*/
$(document).ready(function(){
	/*setting.async.url=$('#ctx').val()+"/pages/base/country/form/getMenuZTree?countryId="+ $('#id').val(); 
	$.fn.zTree.init($("#treeDemo"), setting);
	BMEP.Base.Country.Show.zTree = $.fn.zTree.getZTreeObj("treeDemo");
	BMEP.Base.Country.Show.rMenu = $("#rMenu");
	BMEP.Base.Country.Show.shadow = $("#shadow");
	*/
	  $.ajax({
			"dataType" : "json",
			"type" : "POST",
			"url" : $("#ctx").val() + "/pages/base/country/form/getAllMenuZTree?countryId="+ $('#id').val(),
			data : {
			//	"corpType.code" : $("#corpType_code").val()
			},
			"cache" : false,
			"success" : function(response) {
				//root[0].open = false;
				//response.push(root[0]);
				
				var setting2 = {
						view: {
							expandSpeed: 0
						},
						data: {
							simpleData: {
								enable: true,
								idKey: "id",
								pIdKey: "pid",
								rootPId: "root",
							}
						},callback: {
							onRightClick: OnRightClick,
						}
					};
					
					$.fn.zTree.init($("#treeDemo"), setting2, response);
					$.fn.zTree.getZTreeObj("treeDemo").expandAll(true);
					BMEP.Base.Country.Show.zTree = $.fn.zTree.getZTreeObj("treeDemo");
					BMEP.Base.Country.Show.rMenu = $("#rMenu");
					BMEP.Base.Country.Show.shadow = $("#shadow");
			}
		});
});