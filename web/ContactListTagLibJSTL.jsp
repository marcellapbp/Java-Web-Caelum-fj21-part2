<%-- 
    Document   : ContactListTagLibJSTL
    Created on : 19/01/2017, 18:08:28
    Author     : marce
--%>
<%--add taglib reference--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Using JSTL</title>
    </head>
    <body>
        <jsp:useBean id="dao" class="dao.ContactDAO"/>

            <table>
                <c:forEach var="contact" items="${dao.contactList}">
                    <tr>
                        <td>${contact.name}<td/>
                        <td>${contact.email}<td/>
                        <td>${contact.address}<td/>
                        <td>${contact.birthDate.time}<td/>
                        <%--it formats the date--%>
                        <td><fmt:formatDate value="${contact.birthDate.time}" pattern="dd/MM/yyyy" /></td>
                    
                    <tr/>
                </c:forEach>
            </table>
    </body>
</html>
