<%-- 
    Document   : bem-vindo
    Created on : 16/01/2017, 18:12:38
    Author     : marcella
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            
            String message = "Hello World!";
            
         %>
         <h1>
             <% 
                 //JSP Writer
                 out.println(message); 
             %>
             
             <%
                String desenvolvido = "Desenvolvido por Marcella)";
            %>
            <%= desenvolvido %>
             <%-- comentário em jsp --%>
         </h1>
    </body>
</html>
