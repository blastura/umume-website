<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<div id="content-wide"><div class="container">
    <form:form method="post" commandName="findPerson">
        <form:input path="userName" />
        <input type="submit" align="center" value="Execute">
    </form:form>
</div></div>
    
<%@ include file="/WEB-INF/jsp/bottom.jsp" %>