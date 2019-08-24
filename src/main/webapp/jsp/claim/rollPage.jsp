<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../common/taglib.jsp"%>
<div class="page-bar">
	<c:if test="${requestScope.currentPageNo>1}">
		<a href="javascript:page_nav(${param.formName},1);">首页</a>  
		<a href="javascript:page_nav(${param.formName},<c:out value="${requestScope.currentPageNo-1}"/>);">上一页</a>
	</c:if>
	<c:if test="${requestScope.currentPageNo<requestScope.totalPageCount}">
		<a href="javascript:page_nav(${param.formName},<c:out value="${requestScope.currentPageNo+1}" />);">下一页</a>
		<a href="javascript:page_nav(${param.formName},<c:out value="${requestScope.totalPageCount}"/>);">最后一页</a>
	</c:if>
	&nbsp;&nbsp;第 ${requestScope.currentPageNo}页/共${requestScope.totalPageCount}页&nbsp;&nbsp;共${requestScope.totalRecordCount }条记录
</div>