<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<%@ include file="../static/header.jsp" %>
<body>
<%@ include file="../static/titleline.jsp" %>
<div class="container">
<div class="row">
<div class="col-xs-2">
<%@ include file="nav.jsp" %>
</div>
<div class="col-xs-10">
	<ul class="list-group">
		<li class="list-group-item list-group-item-success">登录账户: ${mem.username} 申请成为</li>
		<li class="list-group-item list-group-item-info"><a type="button" class="btn btn-link" href="${config.rootPath}/personal/apply-submit-admin">管理员</a></li>
		<c:if test="${empty mem.writer}">
		<li class="list-group-item list-group-item-info"><a type="button" class="btn btn-link" href="${config.rootPath}/personal/apply-submit-writer">编辑</a></li>
		</c:if>
		<c:if test="${mem.writer.state eq 0}">
		<li class="list-group-item list-group-item-info"><a type="button" class="btn btn-link" href="#">编辑 审批中</a></li>
		</c:if>
	</ul>
</div>
</div>
</div>
<script>
$(document).ready(function(){
});
</script>
<%@ include file="../static/footer.jsp" %>
</body>
</html>