<%-- 
    Document   : show_sum2
    Created on : 2023. 4. 9., 오후 7:32:46
    Author     : 정민수
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%-- 차이점 jstl의 core 라이브러리 사용하는 부분 --%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%-- jsp userBean actions 사용 --%>
<jsp:useBean id="sum" scope="page" class="deu.se.ood.beans.ch04.SumBean" />

<!--proterty 이름이 param 이름과 동일하므로 ${param.n}은 없어도 됨  -->
<c:set target="${sum}" property="n" value="${param.n}"/>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">        
        <title>Beans 사용 예제</title>
    </head>
    <body>
        
        <% sum.caculate();%>
        
        계산 결과 1: <jsp:getProperty name="sum" property="result"/> <br>
        계산 결과 2: <c:out value="${sum.result}" /> <br>
        계산 결과 3: ${sum.result}
        
        <%@include file="/WEB-INF/jspf/main_footer.jspf" %>
    </body>
</html>
