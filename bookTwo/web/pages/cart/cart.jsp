<%@ taglib prefix="for" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>购物车</title>

	<%-- 静态包含 base标签、css样式、jQuery文件 --%>
	<%@ include file="/pages/common/head.jsp"%>


</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">购物车</span>

		<%--静态包含，登录 成功之后的菜单 --%>
		<%@ include file="/pages/common/login_success_menu.jsp"%>
		<script type="text/javascript">
			$(function () {
				$(".updateCount").change(function () {
					var id = $(this).attr("bookId");
					var count = this.value ;
					if (confirm("是否确定修改此商品购买数量?")){
						location.href="cartservlet?action=updateCount&count="+count+"&id="+id;
					}else {
						this.value=this.defaultValue;
					}
				});
			})
		</script>


	</div>
	
	<div id="main">
	
		<table>
			<tr>
				<td>商品名称</td>
				<td>数量</td>
				<td>单价</td>
				<td>金额</td>
				<td>操作</td>
			</tr>
			<for:if test="${not empty sessionScope.cart and sessionScope.cart.items.size()>0 }">
				<for:forEach items="${sessionScope.cart.items}" var="entry">
					<tr>
						<td>${entry.value.name}</td>
						<td>
							<input  bookId="${entry.value.id}" class="updateCount" style="width: 80px" type="text" name="" id="" value="${entry.value.count}">
						</td>
						<td>${entry.value.price}</td>
						<td>${entry.value.totalPrice}</td>
						<td><a href="cartservlet?action=deleteItem&id=${entry.value.id}">删除</a></td>
					</tr>
				</for:forEach>

			</for:if>

			<for:if test="${empty sessionScope.cart or sessionScope.cart.items.size()==0}">
				<tr>
					<td colspan="5"><a href="index.jsp">亲，当前购物车为空!</a> </td>
				</tr>
			</for:if>


			
		</table>
		<for:if test="${not empty sessionScope.cart and sessionScope.cart.items.size()>0}">
			<div class="cart_info">
				<span class="cart_span">购物车中共有<span class="b_count">${sessionScope.cart.totalCount}</span>件商品</span>
				<span class="cart_span">总金额<span class="b_price">${sessionScope.cart.totalPrice}</span>元</span>
				<span class="cart_span"><a href="cartservlet?action=clear">清空购物车</a></span>
				<span class="cart_span"><a href="orderservlet?action=createOrder">去结账</a></span>
			</div>
		</for:if>

	
	</div>


	<%--静态包含页脚内容--%>
	<%@include file="/pages/common/footer.jsp"%>


</body>
</html>