
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../common/taglib.jsp"%>
<link href="<%=request.getContextPath()%>/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/common.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/My97DatePicker/WdatePicker.js"></script>
<script>
	$(function(){
			 //日期选择控件
		 	$("#startDate").click(function(){
				WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'endDate\')}',isShowClear:true, readOnly:true });
			});
			$("#endDate").click(function(){
				WdatePicker({dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'startDate\')}',isShowClear:true, readOnly:true });
			});
		});
   	function delVoucher(id){
   		if(!confirm('确定删除报单吗')) return;
   		
   		document.claimVoucherForm.action = "claimVoucher_deleteClaimVoucherById.action?claimVoucher.id="+id;
   		document.claimVoucherForm.submit();
   		
   	}
   	
</script>
<div class="action  divaction">
	<div class="t">报销单列表</div>
	<div class="pages">
		<div class="forms">
			 <s:form action="claimVoucher_searchClaimVoucher.action" name="queryForm">
	       		<label>报销单状态</label>
	  			<%--<s:select name="claimVoucher.status" list="statusMap"--%>
	  			<%--listKey="key" listValue="value" headerKey="" headerValue="全部" theme="simple"></s:select>--%>
		       <label id="time">开始时间</label>
		       <s:textfield name="startDate" id="startDate" cssClass="nwinput"></s:textfield>
		       <label id="end-time">结束时间</label>
		       <s:textfield name="endDate" id="endDate" cssClass="nwinput"></s:textfield>
		       <input type="hidden" name="pageNo" value="1"/>
		 	   <input type="hidden" name="pageSize" value="5"/>
		       <s:submit cssClass="submit_01" value="查询"/>
	       </s:form>
	     </div>
	<!--增加报销单 区域 开始-->
	<s:form action="claimVoucher_searchClaimVoucher.action" name="claimVoucherForm">
		<table width="90%" border="0" cellspacing="0" cellpadding="0" class="list items">
	      <tr class="even">
	        <td>编号</td>
	        <td>填报日期</td>
	        <td>填报人</td>
	        <td>总金额</td>
	        <td>状态</td>
	        <td>待处理人</td>
	        <td>操作</td>
	      </tr>
	      <s:iterator value="items" id="claimVoucher" begin="0" status="s">
	      <tr>
	        <td><a href="claimVoucher_getClaimVoucherById.action?claimVoucher.id=<s:property value="#claimVoucher.id"/>"><s:property value="#claimVoucher.id"/></a></td>
	        <td><s:date name="#claimVoucher.createTime"/></td>
	        <td><s:property value="#claimVoucher.creator.name"/></td>
	        <td><s:property value="#claimVoucher.totalAccount"/></td>
	        <td><s:property value="#claimVoucher.status"/></td>
	        <td><s:property value="#claimVoucher.nextDeal.name"/></td>
	        <td>
	        	<s:if test="#claimVoucher.status == '新创建' || #claimVoucher.status == '已打回'">
	        		<a href="claimVoucher_toUpdate.action?claimVoucher.id=<s:property value="#claimVoucher.id"/>">
			        	<img src="${images}/edit.gif" width="16" height="16" /> 
			        </a>
			        <a onClick="delVoucher(<s:property value="#claimVoucher.id"/>)" href="#">
			        	<img src="${images}/delete.gif" width="16" height="16" />
			        </a>
		        </s:if>
		        <img src="${images}/save.gif" width="16" height="16" /> 
		        <a href="claimVoucher_getClaimVoucherById.action?claimVoucher.id=<s:property value="#claimVoucher.id"/>">
		        	<img src="${images}/search.gif" width="16" height="15" />
		        </a>
		        <s:if test="#claimVoucher.nextDeal.name == #session.employee.name">
		        	<s:if test="#claimVoucher.status == '已提交' || #claimVoucher.status == '待审批' || #claimVoucher.status == '已审批'">
				        <a href="claimVoucher_toCheck.action?claimVoucher.id=<s:property value="#claimVoucher.id"/>">
				         <img src="${images}/sub.gif" width="16" height="16" />
				        </a>
			        </s:if>
		        </s:if>
	        </td>
	      </tr>
	      </s:iterator>
	      <tr>
	        <td colspan="6" align="center">
		      	<c:import url="rollPage.jsp" charEncoding="UTF-8">
				<c:param name="formName" value="document.forms[0]"/>
				<c:param name="totalRecordCount" value="${pageSupport.totalCount}"/>
				<c:param name="totalPageCount" value="${pageSupport.totalPageCount}"/>
				<c:param name="currentPageNo" value="${pageSupport.currPageNo}"/>
  			</c:import>
  		  	</td>
  		  </tr>
	    </table>      
	   </s:form>  
	          <!--增加报销单 区域 结束-->
       </div>
      </div>