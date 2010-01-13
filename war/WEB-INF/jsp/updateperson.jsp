<%@ include file="/WEB-INF/jsp/include.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<title><fmt:message key="title" /></title>
</head>
<body>
<h1>Update information for <c:out value="${person.name}" /></h1>
<form:form method="post" commandName="updatePerson">
	<ul>
		<li>
		  <label>Beskrivning</label>
          <form:input path="description" />
		</li>
		<li>
		  <label>Twitternamn</label>
          <form:input path="twitter" />
		</li>
		<li>
		  <input type="submit" value="Uppdatera information">
		</li>
	</ul>
</form:form>
</body>
</html>