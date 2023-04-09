<%@page pageEncoding="UTF-8"%>

<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%-- request.setCharacterEncoding("UTF-8"); --%>
<fmt:requestEncoding value="UTF-8" />

<hr/>
페이지 하단에 들어갈 내용입니다. <br/>
날짜: ${param.date}
사용자: ${param.user}