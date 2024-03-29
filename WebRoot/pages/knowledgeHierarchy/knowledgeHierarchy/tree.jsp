<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<%@ include file="/pages/common/common.jsp" %>
<%@ include file="/pages/common/alert.jsp" %>
<%@ include file="/pages/common/context.jsp" %>
<%@ include file="/pages/common/ajaxMsg.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title><ingenta-tag:LanguageTag sessionKey="lang" key="Global.Label.Title"/></title>
    <link rel="stylesheet" href="${ctx }/ztree/css/zTreeStyle/zTreeStyle.css" type="text/css"></link>
    <script type="text/javascript" src="${ctx }/ztree/js/jquery.ztree.core-3.4.js"></script>
    <script src="${ctx}/js/common.js"></script>
    <script src="${ctx}/pages/knowledgeHierarchy/knowledgeHierarchy/tree.js"></script>

    <script src="${ctx}/pages/knowledgeHierarchy/knowledgeHierarchy/tree_init.js"></script>
    <style type="text/css">
        #sidebar {
            width: 30%;
        }

        #sidebar:before {
            width: 30%;
        }

        #main-content {
            margin-left: 30%;
        }

        #sidebar-shortcuts {
            line-height: 0px;
            max-height: 0px;
        }

        div#rMenu {
            visibility: hidden;
            position: absolute;
            top: 0;
            text-align: left;
            padding: 2px;
            backgroundColor: #FFFFFF;
        }

        div#rMenu ul {
            listStyle: none;
            margin: 0px;
            background-color: #FFFFFF;
            border: 1px solid #999;
            width: 140px;
            padding: 1px;
        }

        div#rMenu ul li {
            margin: 0px;
            color: #000;
            display: block;
            cursor: default;
            padding: 1px;
            border: 1px solid #fff;
            background-color: transparent;
            font: normal 12px arial, tahoma, helvetica, sans-serif;
        }

        div#rMenu ul li img {
            vertical-align: middle;
        }

        div#shadow {
            background-color: #b6bdd2;
            position: absolute;
            opacity: 0.2;
            zIndex: 499;
        }
    </style>
</head>
<body>
<div id="sidebar">
    <div id="sidebar-collapse" onclick="Editorial.knowledgeHierarchy.Tree.hideTree();">
        <i class="icon-double-angle-left"></i>
    </div>
    <div id="sidebar-shortcuts">
        <div class="zTreeDemoBackground left">
            <ul id="treeDemo" class="ztree"></ul>
        </div>
        <div id="shadow"></div>
        <div id="rMenu">
            <ul>
                <li id="add1" onclick='Editorial.knowledgeHierarchy.Tree.addObj();'
                    onmouseover="this.style.backgroundColor='#b6bdd2';" onmouseout="this.style.backgroundColor='';">创建知识体系
                </li>
                <li id="edit" onclick='Editorial.knowledgeHierarchy.Tree.editObj();'
                    onmouseover="this.style.backgroundColor='#b6bdd2';" onmouseout="this.style.backgroundColor='';">修改知识体系
                </li>
                <li id="delete" onclick='Editorial.knowledgeHierarchy.Tree.delObj();'
                    onmouseover="this.style.backgroundColor='#b6bdd2';" onmouseout="this.style.backgroundColor='';">删除知识体系
                </li>

                <li id="upload" onclick='Editorial.knowledgeHierarchy.Tree.uploadObj();'
                    onmouseover="this.style.backgroundColor='#b6bdd2';" onmouseout="this.style.backgroundColor='';">上传
                </li>
            </ul>
        </div>
    </div>
</div>
<div id="main-content" class="clearfix">
    <div id="classifyContent" class="hide">
        <div class="clearfix">
            <div id="page-content" class="clearfix">

            </div>
        </div>
    </div>


</div>
</body>
</html>