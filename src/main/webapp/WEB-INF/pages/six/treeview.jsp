<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<%@ include file="/resources/common/taglib.jsp"%>
<head>
<%@ include file="/resources/common/meta.jsp"%>
<title>Bootstrap-Treeview——一款非常酷的分层树结构插件</title>
<%@ include file="/resources/common/csslib.jsp"%>
</head>
<body>
	<div class="container">
		<button id="getData" data-url="${ctx}/six/treeview/submit">提交</button>
		<div id="treeview1"></div>
		<div id="treeview_procity" data-url="${ctx}/six/treeview/procity"></div>
	</div>

	<%@ include file="/resources/common/jslib.jsp"%>
</body>
</html>
