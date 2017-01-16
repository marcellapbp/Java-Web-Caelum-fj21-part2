<%-- 
    Document   : listar-contatos
    Created on : 16/01/2017, 18:24:05
    Author     : marce
--%>

<%@page 
    contentType="text/html" pageEncoding="UTF-8"
%>

<%@page 
    import = 
    "dao.ContactDAO,
     beans.Contact"
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Contact List</title>
    </head>
    <body>
        <h1>Contact List</h1>
        
        <% 
            ContactDAO dao = new ContactDAO();
            
            List<Contact> list = dao.contactList();
            
            for(Contact contact : list)
            {
                
        %>
            <tr>
                <td><%=contact.getName()%></td>
                <td><%=contact.getEmail() %></td>
                <td><%=contact.getAddress()%></td>
                <td><%=contact.getBirthDate().getTime() %></td>
            </tr>
            <%
            }
            %>
    </body>
</html>
