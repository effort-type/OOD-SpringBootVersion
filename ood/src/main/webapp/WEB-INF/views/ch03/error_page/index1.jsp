<%-- 
    Document   : index1
    Created on : 2023. 3. 16., 오전 11:13:06
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%-- 반응형 웹으로 만들기 위해 사용하는 meta --%>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"> 
        <title>page 지시어의 오류 관련 속성 미사용 예제</title>
    </head>
    <body>
        <%= 5 / 0 %>
    </body>
</html>
