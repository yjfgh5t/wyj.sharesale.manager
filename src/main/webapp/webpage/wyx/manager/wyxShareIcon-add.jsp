<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>分享的图标</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="wyxShareIconController.do?doAdd" >
					<input id="id" name="id" type="hidden" value="${wyxShareIconPage.id }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							图标路径:
						</label>
					</td>
					<td class="value">
					     	 <input id="siSrc" name="siSrc" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">图标路径</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							排序:
						</label>
					</td>
					<td class="value">
					     	 <input id="siOrder" name="siOrder" type="text" style="width: 150px" class="inputxt"  datatype="n"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">排序</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							所在分类:
						</label>
					</td>
					<td class="value">
							  <t:dictSelect field="siType" type="list"  datatype="*"  dictTable="wyx_share_type" dictField="id" dictText="st_name"  defaultVal="${wyxShareIconPage.siType}" hasLabel="false"  title="所在分类" ></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">所在分类</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							是否删除:
						</label>
					</td>
					<td class="value">
							  <t:dictSelect field="siDelete" type="radio"  datatype="*"  typeGroupCode="yesorno"  defaultVal="${wyxShareIconPage.siDelete}" hasLabel="false"  title="是否删除" ></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">是否删除</label>
						</td>
				</tr>
				
				
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/wyx/manager/wyxShareIcon.js"></script>		
