<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>北大青鸟办公自动化管理系统</title>
		<link href="<%=request.getContextPath() %>/css/style.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.0.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/My97DatePicker/WdatePicker.js"></script>
		<script type="text/javascript">
			$(function(){
				 //日期选择控件
			 	$("#startDate").click(function(){
					WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'#F{$dp.$D(\'endDate\')}',isShowClear:true, readOnly:true });
				});
				$("#endDate").click(function(){
					WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',minDate:'#F{$dp.$D(\'startDate\')}',isShowClear:true, readOnly:true });
				});
			});
			function submitLeave(){
		   		if(!confirm('确定提交请假申请吗')) return;
		   		document.leaveForm.submit();
		   		
		   	}
		</script>
	</head>
	<body>
	<div class="action divaction">
		<div class="t">请假申请</div>
		<div class="pages">
	<!--请假申请 区域 开始-->
	<s:form action="leave_saveLeave.action" name="leaveForm">
     <table class="leave">
       <tr>
         <td class="width1"><label for="name">姓名：</label></td>
         <td class="width2"><s:textfield name="name" value="%{#session.employee.name}" cssClass="nwinput" /></td>
         <s:hidden name="leave.creator.sn" value="%{#session.employee.sn}"></s:hidden>
         <td class="width1"><label>部门：</label></td>
         <td class="width2">
            <select name="" class="nwselect">
             <option value="<s:property value="#session.employee.sysDepartment.id"/>"><s:property value="#session.employee.sysDepartment.name"/></option>
           </select>
         </td>
       </tr>
        <tr>
         <td class="width1"><label for="time">开始时间：</label></td>
         <td class="width2"><s:textfield name="leave.startTime" id="startDate" cssClass="nwinput"/></td>
         <td class="width1"><label for="end-time">结束时间：</label></td>
         <td class="width2"><s:textfield name="leave.endTime" id="endDate" cssClass="nwinput"/></td>
       </tr>
        <tr>
         <td class="width1"><label for="size">请假天数：</label></td>
         <td class="width2"><s:textfield name="leave.leaveDay"  cssClass="nwinput"/>(天)</td>
         <td class="width1"><label>休假类型：</label></td>
         <td class="width2">
            <s:select name="leave.leaveType" list="leaveTypeMap" 
	  			listKey="key" listValue="value" theme="simple" cssClass="nwselect"></s:select>
         </td>
       </tr>
       <tr>
         <td class="width1"><label>请假事由：</label></td>
         <td colspan="3">
          <s:textarea name="leave.reason" cssClass="textarea"></s:textarea>
          </td>
       </tr>
     </table>
      	<div class="forms ">
          <p class="leave">
           <label>下一审批人：</label>
           <select name="leave.nextDeal.Sn" class="nwselect" >
             <option value="<s:property value="#session.manager.sn"/>"><s:property value="#session.manager.name"/></option>
           </select>
          </p>
          <p class="marg">
           <input name="button" type="button"  value="提交流程" class="submit_01" onClick="submitLeave()"/>
           <input name="" type="button"  value="取消"  class="submit_01"/>
          </p>
     	</div>
     	</s:form>
     <!--请假申请 区域 结束-->
     </div>
     </div>
	</body>
</html>
