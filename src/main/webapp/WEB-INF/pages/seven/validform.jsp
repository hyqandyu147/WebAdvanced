<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<%@ include file="/resources/common/taglib.jsp"%>
<head>
<%@ include file="/resources/common/meta.jsp"%>
<title>Validform的基本应用</title>
<%@ include file="/resources/common/csslib.jsp"%>
</head>
<body class="hold-transition login-page">
	<div class="login-box">
		<div class="login-logo">
			<a href="#">
				<b>Web</b>全栈开发进阶之路
			</a>
		</div>
		<div class="login-box-body">
			<p class="login-box-msg">登录系统，开启崭新旅程</p>

			<form id="validForm" action="${ctx}/seven/checkLogin" method="post">
				<div class="form-group has-feedback">
					<input type="text" class="form-control" name="username" datatype="*" nullmsg="请输入账号！" placeholder="账号">
					<span class="glyphicon glyphicon-envelope form-control-feedback"></span>
				</div>
				<div class="form-group has-feedback">
					<input type="password" class="form-control" name="password" datatype="*" nullmsg="请输入密码！" placeholder="密码">
					<span class="glyphicon glyphicon-lock form-control-feedback"></span>
				</div>
				<div class="row">
					<div class="col-xs-8">
						<div class="checkbox icheck" data-skin="square">
							<label>
								<input type="checkbox">
								记住我
							</label>
						</div>
					</div>
					<div class="col-xs-4">
						<button type="submit" class="btn btn-primary btn-block btn-flat">登录</button>
					</div>
				</div>
			</form>
		</div>
	</div>

	<%@ include file="/resources/common/jslib.jsp"%>
</body>
</html>
