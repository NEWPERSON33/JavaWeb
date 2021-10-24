<%@ taglib prefix="for" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>图书管理</title>

	<%-- 静态包含 base标签、css样式、jQuery文件 --%>
	<%@ include file="/pages/common/head.jsp"%>

	<script type="text/javascript">
		$(function () {
			$("a.deleteClass").click(function (){
				return confirm("是否确定删除《"+$(this).parent().parent().find("td:first").text()+"》");
			})
		})
	</script>

</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="../../static/img/logo.gif" >
			<span class="wel_word">图书管理系统</span>

		<%-- 静态包含 manager管理模块的菜单  --%>
		<%@include file="/pages/common/manager_menu.jsp"%>


	</div>
	
	<div id="main">
		<table>
			<for:forEach items="${requestScope.page.items}" var="book"><%--//此时list请求功能处于瘫痪状态--%>
				<tr>
					<td>${book.name}</td>
					<td>${book.price}</td>
					<td>${book.author}</td>
					<td>${book.sales}</td>
					<td>${book.stock}</td>
					<td> <a href="manager/bookServlet?action=getBook&id=${book.id}&pageNo=${requestScope.page.pageNo}">修改</a> </td>
					<td><a class="deleteClass" href="manager/bookServlet?action=delete&id=${book.id}&pageNo=${requestScope.page.pageNo}">删除</a> </td>
				</tr>

			</for:forEach>

			


			
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td><a href="pages/manager/book_edit.jsp?method=add&pageNo=${requestScope.page.pageTotal}">添加图书</a></td>
			</tr>	
		</table>

		<%@include file="/pages/common/page_nav.jsp"%>

	</div>


	<%--静态包含页脚内容--%>
	<%@include file="/pages/common/footer.jsp"%>


</body>
</html>