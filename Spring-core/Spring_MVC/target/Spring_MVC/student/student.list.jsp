<%--
  Created by IntelliJ IDEA.
  User: DanhVinh
  Date: 8/26/2022
  Time: 10:12 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<tiles:insertDefinition name="studentTemplate">
    <tiles:putAttribute name="body">
    <script>
        function view(id){
            var xmlHttp = new XMLHttpRequest();
            xmlHttp.open("GET","json/"+id,true);
            xmlHttp.onload = function (){
                if(this.status != 200){
                    return;
                }
                var student = JSON.parse(this.responseText);
                document.getElementById('content').innerHTML = 'Name: '+student.name;
                var dialog = document.getElementById('viewStudent');
                dialog.show();
                console.log(this.responseText);
            };
            xmlHttp.send();
        }
    </script>
    <form method="get" action="list">
    <table border="1">
        <tr>
            <td colspan="4"><input type="text" name="q" size="30"></td>
            <td><input type="submit" value="Submit"></td>
        </tr>
        <tr>
            <td>ID</td>
            <td>Name</td>
            <td>Age</td>
        </tr>
        <c:forEach items="${students}" var="student">
            <tr>
                <td>${student.id}</td>
                <td><a href="javascript:view(${student.id})">${student.name}</a></td>
                <td>${student.age}</td>
                <td><a href="/student/delete/${student.id}">Delete</a></td>
                <td><a href="/student/edit/${student.id}">Edit</a></td>
            </tr>

        </c:forEach>
    </table>
    </form>
    <dialog id="viewStudent" style="width:50%; border: 1px dotted black;">
            <div id="content"></div>
            <button id="hide">Close</button>
    </dialog>
    <script>
        (function (){
            var dialog = document.getElementById('viewStudent');
            document.getElementById('hide').onclick = function (){
                dialog.close();
            };
        })();
    </script>
    </tiles:putAttribute>
</tiles:insertDefinition>