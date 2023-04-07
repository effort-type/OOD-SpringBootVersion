<%-- 
    Document   : show_sum1
    Created on : 2023. 4. 7., 오후 4:40:16
    Author     : 정민수
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%-- 일반 bean을 사용하기 위해서 추가해야하는 액션 --%>
<jsp:useBean id="sumBean" scope="page" class="deu.se.ood.beans.ch04.SumBean"/>
<jsp:setProperty name="SumBean" property="n" /> <%-- index.jsp에서 form을 통해서 input으로 전달해주는 것, n에 해당하는 값이 존재하면 property에 넣음 --%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">        
        <title>Java Bean 사용한 계산 결과</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPate}/css/my_style.css">
    </head>
    <body>
        <div class="padding_bottom_30px box center" style="width: 80%;">
            Request Parameter n : <%=request.getParameter("n")%> <%-- 스크립틀릿 표현식 --%>
        </div>

        <% sumBean.caculate();%>
        <ul>
            <li>계산 결과 1: <jsp:getProperty name="sumBean" property="result" /></li>
            <li>계산 결과 2: <%= sumBean.getResult() %></li>
            <li>계산 결과 3: ${sumBean.result}</li> <%-- EL표현식 --%>
        </ul>

        <%@include file="/WEB-INF/jspf/main_footer.jspf" %>
    </body>
</html>
