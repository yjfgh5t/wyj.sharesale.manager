<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>分享类型</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
		<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="wyxShareTypeController.do?doUpdate" >
					<input id="id" name="id" type="hidden" value="${wyxShareTypePage.id }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
					<tr>
						<td align="right">
							<label class="Validform_label">
								名称:
							</label>
						</td>
						<td class="value">
						     	 <input id="stName" name="stName" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${wyxShareTypePage.stName}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">名称</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								是否删除:
							</label>
						</td>
						<td class="value">
									<t:dictSelect field="stDelete" type="radio"  datatype="n"  typeGroupCode=""   defaultVal="${wyxShareTypePage.stDelete}" hasLabel="false"  title="是否删除" ></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">是否删除</label>
						</td>
					</tr>
				
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/wyx/manager/wyxShareType.js"></script>		
