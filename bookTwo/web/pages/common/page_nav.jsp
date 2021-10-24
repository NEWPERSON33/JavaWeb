<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2021/10/9
  Time: 20:08
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="for" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="page_nav">

    <a href="${requestScope.page.url}&pageNo=1">首页</a>
    <c:if test="${requestScope.page.pageNo>1}">

        <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageNo - 1  }">上一页</a>
    </c:if>

    <%--			<a href="#">3</a>--%>
    <%--			【${requestScope.page.pageNo}】--%>
    <%--			<a href="#">5</a>--%>
    <c:choose>
        <c:when  test="${requestScope.page.pageTotal<=5}" >
            <for:forEach begin="1" end="${requestScope.page.pageTotal}" var="i">
                <c:if test="${i==requestScope.page.pageNo}">
                    &lt${i}&gt
                </c:if>
                <c:if test="${i!=requestScope.page.pageNo}">
                    <a href="${requestScope.page.url}&pageNo=${i}">${i}</a>
                </c:if>
            </for:forEach>
        </c:when>
        <c:when test="${requestScope.page.pageTotal > 5}">
            <c:choose>
                <c:when test="${requestScope.page.pageNo <=2}">
                    <for:forEach begin="1" end="5" var="i">
                        <c:if test="${i==requestScope.page.pageNo}">
                            &lt${i}&gt
                        </c:if>
                        <c:if test="${i!=requestScope.page.pageNo}">
                            <a href="${requestScope.page.url}&pageNo=${i}">${i}</a>
                        </c:if>
                    </for:forEach>
                </c:when>
                <c:when test="${requestScope.page.pageNo > 2 && requestScope.page.pageNo <= requestScope.page.pageTotal-2}">
                    <for:forEach begin="${requestScope.page.pageNo -2}" end="${requestScope.page.pageNo+2}" var="i">
                        <c:if test="${i==requestScope.page.pageNo}">
                            &lt${i}&gt
                        </c:if>
                        <c:if test="${i!=requestScope.page.pageNo}">
                            <a href="${requestScope.page.url}&pageNo=${i}">${i}</a>
                        </c:if>
                    </for:forEach>
                </c:when>
                <c:when test="${requestScope.page.pageNo >requestScope.page.pageTotal-2}">
                    <for:forEach begin="${requestScope.page.pageTotal-4}" end="${requestScope.page.pageTotal}" var="i">
                        <c:if test="${i==requestScope.page.pageNo}">
                            &lt${i}&gt
                        </c:if>
                        <c:if test="${i!=requestScope.page.pageNo}">
                            <a href="${requestScope.page.url}&pageNo=${i}">${i}</a>
                        </c:if>
                    </for:forEach>
                </c:when>
            </c:choose>
        </c:when>
    </c:choose>
    <c:if test="${requestScope.page.pageNo<requestScope.page.pageTotal}">
        <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageNo + 1 }">下一页</a>

    </c:if>
    <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageTotal}">末页</a>


    共${requestScope.page.pageTotal}页，${requestScope.page.pageCount}条记录 到第<input value="4" name="pn" id="pn_input"/>页
    <input id="searchPageBtn" type="button" value="确定">
    <script type="text/javascript">
        $(function () {
            $("#searchPageBtn").click(function () {
                var pageNo = $("#pn_input").val();

                location.href = "${requestScope.basePath}${requestScope.page.url}&pageNo="+pageNo ;
            })
        })
    </script>
</div>
