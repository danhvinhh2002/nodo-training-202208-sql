<%--
  Created by IntelliJ IDEA.
  User: DanhVinh
  Date: 8/29/2022
  Time: 5:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<tiles:putAttribute name="body">
    <h1>Login to Application</h1>
    <c:if test="${not empty error}">
        <div class="error">${error}</div>
    </c:if>
    <form method="post" action="/login">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <p><input type="text" name="j_username" placeholder="Username"></p>
        <p><input type="password" name="j_password" placeholder="Password"></p>

        <p><input type="submit" name="commit" value="login"></p>
    </form>
</tiles:putAttribute>