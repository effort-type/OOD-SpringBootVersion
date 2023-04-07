<%-- 
    Document   : show_error
    Created on : 2023. 3. 16., 오전 11:24:41
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page isErrorPage="true"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%-- 반응형 웹으로 만들기 위해 사용하는 meta --%>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"> 
        <title>오류 원인</title>
    </head>
    <body>
        오류 원인은 &quot;<span style="color: red;"><%=exception.getMessage()%></span>&quot;입니다.
        
        <%@include file="/WEB-INF/jspf/main_footer.jspf" %>
    </body>
</html>
