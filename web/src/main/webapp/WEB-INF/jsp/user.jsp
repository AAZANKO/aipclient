<%--
  Created by IntelliJ IDEA.
  User: Doomsday
  Date: 28.10.2018
  Time: 19:25
  To change this template use File | Settings | File Templates.
--%>
<%--найти jstl на диске и скопировать его в папку  lib  --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"
         import="by.aip.dao.model.Officer"
         import="java.util.ArrayList"%>

<html>
    <head>
        <title>Officer.jsp</title>
    </head>
    <body>
<%
    ArrayList<Officer> arrZakaz = (ArrayList<Officer>) request.getAttribute("officer");
%>
        <H1>Hello</H1>
        <c:if test="${officer != null}">
            <table
                    style="border-style: solid; border-width: 1px; width: 1400px; border-collapse: collapse;">
                <thead>
                <tr style="background-color: gray;">
                    <td style="width: 40px;">ID</td>
                    <td style="width: 120px;">firstName</td>
                    <td style="width: 120px;">lastName</td>
                    <td style="width: 120px;">middleName</td>
                    <td style="width: 120px;">officerType</td>
                    <td style="width: 120px;">officerCode</td>
                    <td style="width: 120px;">datePrinyat</td>
                    <td style="width: 120px;">dateUvolen</td>
                    <td style="width: 120px;">status</td>
                </tr>
                </thead>
                <tr>
                    <c:forEach var="officers" items="${officer}">
                        <tr>
                            <td><c:out value="${officers.id}"/></td>
                            <td><c:out value="${officers.firstName}"/></td>
                            <td><c:out value="${officers.lastName}"/></td>
                            <td><c:out value="${officers.middleName}"/></td>
                            <td><c:out value="${officers.officerType}"/></td>
                            <td><c:out value="${officers.officerCode}"/></td>
                            <td><c:out value="${officers.datePrinyat}"/></td>
                            <td><c:out value="${officers.dateUvolen}"/></td>
                            <td><c:out value="${officers.status}"/></td>
                        </tr>
                    </c:forEach>
                </tr>
            </table>
        </c:if>
    </body>
</html>