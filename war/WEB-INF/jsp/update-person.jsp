<%@ include file="/WEB-INF/jsp/include.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
    <title><fmt:message key="title" /></title>
</head>
<body>
    <h1>Update information for <c:out value="${user.name}" /></h1>
    <form:form method="post" commandName="findUser">
	   <form:textarea path="description" />
       <form:input path="twitter" />
       <form:password path="password" />
	   <input type="submit" value="Execute">
    </form:form>
</body>
</html>