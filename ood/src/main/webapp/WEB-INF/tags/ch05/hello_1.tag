<%-- 
    Document   : hello.tag의 스크립틀릿으로 표현된 부분을 JSTL로 제거한 tag 파일
    Created on : 2023. 4. 9., 오후 6:24:24
    Author     : 정민수
--%>

<%@tag description="사용자 이름과 반복 횟수를 속성으로 받아서 처리" pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@attribute name="user" required="true"%>
<%@attribute name="count" %>

<c:if test="${empty count}">
    <c:set var="count" value="1" />
</c:if>
<c:set var="myCount" value="${count}" scope="session" />

<%-- for문은 JSTL로 수정이 안되기 때문에 그냥 둠 --%>
<%
    for (int i = 0; i < Integer.parseInt((String)session.getAttribute("myCount")); i++) {
%>

${user}님, 안녕하십니까? <br/>

<%
    }
%>

<%-- session으로 사용했기 때문에 사용 후에는 remove 해줘야함. --%>
<c:remove var="myCount" scope="session"/>

<jsp:doBody/>
