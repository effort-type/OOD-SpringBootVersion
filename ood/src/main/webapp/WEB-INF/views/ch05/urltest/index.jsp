<%-- 
    Document   : index
    Created on : 2023. 4. 9., 오후 8:58:44
    Author     : 정민수

    c:url을 통해서는 .jsp와 직접 연결하지 못하기 때문에 링크를 돌려서 controller에서 처리할 수 있게 해야함.
    import는 .jsp 파일에 직접 연결이 가능함.
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">        
        <title>URL 관련 액션 예제</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/my_style.css">
    </head>
    <body>
        <c:import url="header.jsp" /> <%-- SpringBoot를 사용해서 url에 접근할 때는 .jsp 이런식으로 직접 접근하지 못함--%>

        본문 내용입니다.
        <br/>
        <!-- 교재와 다른 부분 : SpringBoot 사용시 footer.jsp와 같이 직접 연결 못하고 반드시 controller를 통하여 연결되어야 함 -->
        <c:url value="footer.jsp" var="footerUrl1">
            <c:param name="date" value="<%=java.time.LocalDate.now().toString()%>" />
            <c:param name="user">홍길동</c:param>
        </c:url>
        <c:url value="urltest_footer" var="footerUrl2">
            <c:param name="date" value="<%=new java.util.Date().toString()%>" />
            <c:param name="user">전우치</c:param>
        </c:url>
        <br>
        
        footer URL1 : <c:out value="${footerUrl1}" /> <br>
        footer URL2 : <c:out value="${footerUrl2}" /> <br> <br>
        
        <a href="${footerUrl1}">footer1 따로 보기</a> &nbsp; &ensp; &emsp;
        <a href="${footerUrl2}">footer2 따로 보기</a>
        
        <!-- GOOD. c:import는 footer.jsp 바로 사용 가능 -->
        <c:import url="${footerUrl1}" var="urltest_footer1" />
        <!-- BAD: Eclipse IDE에서는 실행되지만, Apache Tomcat 배포 시 오류 발생하므로 코멘트 처리 필요 -->
        <c:import url="${footerUrl2}" var="urltest_footer2" />
        
        <br>
        footer1: <c:out value="${urltest_footer1}"/> <!-- GOOD --><br>
        footer2: <c:out value="${urltest_footer2}"/><!-- BAD-->
        
        <div class="box">
            &lt;c:import&gt;는 footer.jsp를 바로 사용 가능하지만,
            &lt;d:url&gt;에서는 footer.jsp 대신 controller에서 연결시켜 줄 수 있는 이름을 사용해야 함.
        </div>
        
        <c:import url="${footerUrl1}"/>
    </body>
</html>
