<%-- 
    Document   : process
    Created on : 2023. 4. 7., 오후 7:13:40
    Author     : 정민수
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">        
        <title>process</title>
    </head>
    <body>
        반갑습니다.
        
        <%-- index.jsp에서 제어가 넘어올 때 request 객체 값도 같이 넘어온다.--%>
        <%=request.getParameter("user")%> 님!
        
        <%@include file="/WEB-INF/jspf/main_footer.jspf" %>
    </body>
</html>
