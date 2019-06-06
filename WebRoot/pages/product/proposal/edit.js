/**
 * ***************************************** 验证开始
 * *************************************************************
 */
var nameUnique = false;
Editorial.Proposal = function () {
    Editorial.Proposal.objId = null;
};
Editorial.Proposal.validate = function () {
    var flag = true;
    if (!Editorial.Proposal.desc()) {
        flag = false;
    }
    if (!Editorial.Proposal.namea()) {
        flag = false;
    }
    if (!Editorial.Proposal.roleType()) {
        flag = false;
    }
    return flag;
};
Editorial.Proposal.delPerson = function (id) {
    $.ajax({
        "dataType": 'json',
        "type": "POST",
        "url": $('#ctx').val() + "/pages/product/proposalPersonRela/form/delPerson",
        "cache": false,
        "data": {
            "id": id
        },
        "success": function (response) {
//            fnCallback(response);
            ajaxAlertSuccessMsg(response.msg, true);
            refreshFrameDataTableInFrame('Editorial.Proposal.personTable');
        },
        "error": function (response) {
            alert("error");
        }
    });
};
Editorial.Proposal.refreshTable = function () {
    refreshFrameDataTableInLayer('Editorial.Proposal.personTable');
};
Editorial.Proposal.retrievePersonData = function (sSource, aoData, fnCallback) {
    $.ajax({
        "dataType": 'json',
        "type": "POST",
        "url": sSource,
        "cache": false,
        "data": aoData,
        "success": function (response) {
            fnCallback(response);
        },
        "error": function (response) {
            alert("error");
        }
    });
};
Editorial.Proposal.roleCheck = function () {
    if ($('#roleType').val() == $('#teamWork').val()) {
        $('#listDiv').show();
        refreshFrameDataTableInFrame('Editorial.Proposal.personTable');
    } else {
        $('#listDiv').hide();
    }
};
/**
 * ***************************************** 验证desc开始
 * *************************************************************
 */
Editorial.Proposal.desc = function () {
    if ($("#desc").val().trim() == "") {
        $("#descDiv").addClass("error");
        $("#descSpan").html("策划创意描述不能为空！");
        return false;
    } else {
        $("#descDiv").removeClass("error").addClass("success");
        $("#descSpan").html("");
        return true;
    }
};
Editorial.Proposal.nameUnique = function () {
    $.ajax({
        type: "POST",
        async: false,
        "dataType": 'json',
        url: $('#ctx').val() + "/pages/product/proposal/form/nameUnique?id=" + $("#id").val(),
        data: {
            name: $("#name").val()
        },
        success: function (response) {
            if (response.isSuccess == "true") {
                $("#nameDiv").removeClass("error").addClass("success");
                $("#nameSpan").html(response.msg);
                nameUnique = true;
            } else {
                $("#nameDiv").removeClass("success").addClass("error");
                $("#nameSpan").html(response.msg);
                nameUnique = false;
            }
        },
        error: function (response) {
            alert("error");
        }
    });
};

/**
 * ***************************************** 验证Code结束
 * *************************************************************
 */
/**
 * ***************************************** 验证name开始
 * *************************************************************
 */
Editorial.Proposal.namea = function () {
    if ($("#name").val().trim() == "") {
        $("#nameDiv").addClass("error");
        $("#nameSpan").html("策划创意名称不能为空！");
        return false;
    } else {
        Editorial.Proposal.nameUnique();
        if (nameUnique == true) {
            return true;
        } else {
            return false;
        }
    }
};

/**
 * ***************************************** 验证name结束**************************************************************
 */
Editorial.Proposal.roleType = function () {
    if ($("#roleType").val().trim() == "") {
        $("#roleTypeDiv").addClass("error");
        $("#roleTypeSpan").html("可见范围不能为空！");
        return false;
    } else {
        $("#roleTypeDiv").removeClass("error").addClass("success");
        $("#roleTypeSpan").html("");
        return true;
    }
}
Editorial.Proposal.disableAllButton = function () {
    $("#save").attr('disabled', "true");
    $("#reset").attr('disabled', "true");
};

Editorial.Proposal.enableAllButton = function () {
    $("#save").removeAttr('disabled');
    $("#reset").removeAttr('disabled');
};
Editorial.Proposal.openSelectPerson = function () {
    var url = $('#ctx').val() + "/pages/product/proposalPersonRela/form/selectPerson?id=" + $('#id').val();
    var commonModalCss = {
        "width": "1000px",
        "height": "560px"
    };
    var commonModalBodyCss = {
        "max-height": "800px"
    };
    openCommonModalInFrame(url, commonModalCss, commonModalBodyCss);
};
Editorial.Proposal.openSelectAuthor = function () {
    if ("" == $('#id').val().trim()) {
        ajaxAlertErrorMsg("请先保存策划创意!", true);
    } else {
        var url = $('#ctx').val() + "/pages/proposalAuthorRelationship/form/authorIndex?proposalId=" + $('#id').val();
        var commonModalCss = {
            "width": "1200px",
            "height": "650px"
        };
        var commonModalBodyCss = {
            "max-height": "600px"
        };
        openCommonModalInFrame(url, commonModalCss, commonModalBodyCss);
    }
};
Editorial.Proposal.showResponse = function (response, statusText) {
    if (response.isSuccess == "true") {
        ajaxAlertSuccessMsg(response.msg, true);
//        alert(response.obj.id)
        $('#id').val(response.obj.id);
//        alert("id=" + $('#id').val());
        refreshFrameDataTableInLayer('Editorial.Proposal.oTable1');
        autoCloseCommonModal(5);
    } else {
        ajaxAlertErrorMsg(response.msg, true);
        Editorial.Proposal.enableAllButton();
    }
    Editorial.Proposal.enableAllButton();
    Editorial.Proposal.roleCheck();
};
Editorial.Proposal.authorDelObj = function (id) {
    //openConfirmModalInFrame("您确定执行删除作者信息操作吗？", function () {
    var url = $('#ctx').val() + "/pages/proposalAuthorRelationship/form/delete?id=" + id;
    $.ajax({
        "dataType": 'json',
        "type": "POST",
        "url": url,
        "cache": false,
        "success": function (response) {
            if (response.isSuccess == "true") {
                ajaxAlertSuccessMsg(response.msg, true);
                //  window.parent.alertMsg('successModal', 'successMsg', response.msg);
                refreshFrameDataTableInFrame('Editorial.Proposal.AuthorTable');
            } else {
                //  window.parent.alertMsg('errorModal', 'errorMsg', response.msg);
            }
        },
        "error": function (response) {
            alert("error");
        }
    });
    //}, null, null);
};