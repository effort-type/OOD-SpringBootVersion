<%-- 
    Document   : index
    Created on : 2023. 3. 28., 오후 1:36:34
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">        
        <title>EL 표현식 묵시적 객체 사용 예제</title>
    </head>
    <body>
        <ol>
            <li>웹 브라우저 : ${header["user-agent"]}</li>
            <li>사용자 컴퓨터 : ${header.host}</li>
            <li>HTTP 메소드 : ${pageContext.request.method}</li>
            <li>웹 브라우저 : ${header["user-agent"]}</li>
            <li>웹 브라우저 : ${header["user-agent"]}</li>
        </ol>
        <h1>Hello World!</h1>
    </body>
</html>
