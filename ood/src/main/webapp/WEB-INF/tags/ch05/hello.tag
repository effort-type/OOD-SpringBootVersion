<%-- 
    Document   : hello
    Created on : 2023. 4. 9., 오후 6:24:24
    Author     : 정민수
--%>

<%@tag description="사용자 이름과 반복 횟수를 속성으로 받아서 처리" pageEncoding="UTF-8"%>

<%@attribute name="user" required="true"%>
<%@attribute name="count" %>

<%
    int myCount;
    if (count == null) {
        myCount = 1;
    } else {
        myCount = Integer.parseInt(count);
    }
    for (int i = 0; i < myCount; i++) {
%>

${user}님, 안녕하십니까? <br/>

<%
    }
%>

<jsp:doBody/>
