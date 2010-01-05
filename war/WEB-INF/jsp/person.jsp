<%@ include file="/WEB-INF/jsp/include.jsp" %>

<html>
    <head><title>asda</head>
  <body>
    <h3>Products</h3>
    <c:out value="${user.name}" />
    <br>
    <a href="<c:url value="findperson.htm"/>">Find new user</a>
    <br />
    <a href="<c:url value="update-person.htm"/>">Find new user</a>
    <br>
    
  </body>
</html>