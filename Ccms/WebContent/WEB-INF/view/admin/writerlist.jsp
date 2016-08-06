<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ include file="../static/header.jsp" %>
<body>
<%@ include file="message.jsp" %>
<div class="container-fluid">
	<div class="row">
		<%@ include file="navi.jsp" %>
		<div class="col-xs-10">
			<div class="container-fluid">
				<div class="row">
					<div class="col-xs-6">
						<div class="btn-group" role="group">
							<c:choose>
								<c:when test="${act eq 'wait'}">
								<button type="button" class="btn btn-default active">待审批编辑</button>
								</c:when>
								<c:otherwise>
								<a type="button" class="btn btn-default" href="${config.rootPath}/admin/editorlist?act=wait&page=1">待审批编辑</a>
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${act eq 'passed'}">
								<button type="button" class="btn btn-default active">已审批编辑</button>
								</c:when>
								<c:otherwise>
								<a type="button" class="btn btn-default" href="${config.rootPath}/admin/editorlist?act=passed&page=1">已审批编辑</a>
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${act eq 'banned'}">
								<button type="button" class="btn btn-default active">禁止的编辑</button>
								</c:when>
								<c:otherwise>
								<a type="button" class="btn btn-default" href="${config.rootPath}/admin/editorlist?act=banned&page=1">禁止的编辑</a>
								</c:otherwise>
							</c:choose>
						</div>
					</div>
					<div class="col-xs-6">
						<form class="form-inline">
						  <div class="form-group">
						    <label>搜索</label>
						    <input type="text" class="form-control" name="name">
						  </div>
						  <button type="submit" class="btn btn-default">GO</button>
						</form>
					</div>
				</div>
				<div class="row" style="margin-top:0.2em">
					<div class="col-xs-12">
					<table class="table table-bordered">
						<tr> 
					        <th>账户</th>
					        <th>头像</th>
					        <th>昵称</th>
					        <th>操作</th>
					    </tr>
					</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<%@ include file="footer.jsp" %>
</body>
<body>
</body>
</html>