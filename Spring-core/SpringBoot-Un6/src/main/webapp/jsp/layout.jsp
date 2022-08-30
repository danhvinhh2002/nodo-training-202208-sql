<%--
  Created by IntelliJ IDEA.
  User: DanhVinh
  Date: 8/29/2022
  Time: 3:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
    <title>Title</title>
</head>
<body>

        <tr>
            <td height="30">Welcome to java Spring</td>
        </tr>
        <tr>
            <td><a href="/">Trang chu</a>
            <sec:authorize access="!hasAnyRole('ROLE_USER')">
                <a href="/login" style="margin-left: 30px">Dang nhap</a>
            </sec:authorize>
            <sec:authorize access="hasAnyRole('ROLE_USER')">
                <a href="/nguoi-dung" style="margin-left: 30px">Ca nhan</a>
                <a href="/logout" style="margin-left: 30px">Logout</a>
            </sec:authorize>
            </td>
        </tr>
        <tr>
            <td> <tiles:insertAttribute name="body" /> </td>

        </tr>
    </table>
</body>
</html>
