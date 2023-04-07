<%-- 
    Document   : index3
    Created on : 2023. 4. 7., 오후 8:48:33
    Author     : 정민수
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/tlds/mytags3" prefix="mytags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">        
        <title>Simple Tag Handler 사용 예제</title>
    </head>
    <body>
        <mytags:hello user="홍길동" count="5" />
        <mytags:hello user="정민수">
            오늘은 날씨가 아주 좋습니다.
        </mytags:hello>

        <%@include file="/WEB-INF/jspf/main_footer.jspf" %>
    </body>
</html>
