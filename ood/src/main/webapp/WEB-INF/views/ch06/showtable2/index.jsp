<%-- 
    Document   : index
    Created on : 2023. 4. 17., 오전 1:01:53
    Author     : 정민수
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib tagdir="/WEB-INF/tags/ch06" prefix="mytags" %>

<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<spring:eval expression="@environment.getProperty('spring.datasource.username')" var="db_username"/>
<spring:eval expression="@environment.getProperty('spring.datasource.password')" var="db_password"/>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">        
        <title>주소록 보기2</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/my_style.css">
    </head>
    <body>
        <h1>주소록</h1>
        <hr/>
        
        <c:catch var="errorReason">
            <mytags:addrbook user="${db_username}" password="${db_password}" schema="webmail" table="addrbook" />
        </c:catch>
        ${empty errorReason ? "<noerror/>" : errorReason} <!-- 오류 원인 출력 -->
        
        <%@include file="/WEB-INF/jspf/main_footer.jspf" %>
    </body>
</html>
