<%-- 
    Document   : index
    Created on : 2023. 3. 16., 오전 11:03:25
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.time.LocalDateTime" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <%-- 반응형 웹으로 만들기 위해 사용하는 meta --%>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"> 
        
        <title>page 지시어 사용 방법</title>
    </head>
    <body>
        
        지금 시각은 <%= LocalDateTime.now().toString()%>입니다.
        
        <%@include file="/WEB-INF/jspf/main_footer.jspf" %>
    </body>
</html>
