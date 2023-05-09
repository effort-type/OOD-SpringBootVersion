<%-- 
    Document   : addrbook
    Created on : 2023. 4. 17., 오전 12:40:57
    Author     : 정민수
--%>

<%@tag description="put the tag description here" pageEncoding="UTF-8"%>

<%-- taglib 지시어 사용하여 라이브러리 사용할 수 있게 하는 부분 --%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<%-- 변수 선언 --%>
<%@attribute name="user" required="true" %>
<%@attribute name="password" required="true"%>
<%@attribute name="schema" required="true"%>
<%@attribute name="table" required="true"%>

<%-- DB와 연결하기 위한 부분 --%>
<sql:setDataSource var="dataSrc"
                   url="jdbc:mysql://${mysql_server_ip}:${mysql_server_port}/${schema}?serverTimezone=Asia/Seoul"
                   driver="com.mysql.cj.jdbc.Driver"
                   user="${user}" password="${password}" />

<sql:query var="rs" dataSource="${dataSrc}">
    SELECT * FROM ${table}
</sql:query>

<table border="1">
    <thead>
        <tr>
            <th>이름</th>
            <th>이메일</th>
            <th>전화번호</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="row" items="${rs.rows}">
            <tr>
                <td>${row.name}</td>
                <td>${row.email}</td>
                <td>${row.phone}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>