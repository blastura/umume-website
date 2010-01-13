<%@ include file="/WEB-INF/jsp/include.jsp" %>

<div id="content-left">
   <div class="container">
      <h2><c:out value="${person.givenName} ${person.familyName}"/></h2>
      <c:if test="${not empty person.photoURI}">
         <img src="<c:out value="${person.photoURI}"/>" />
      </c:if>
      <p>
         <c:out value="${person.description}"/><br />
         <c:out value="${person.street}"/><br />
      </p>
      
      <ul>
         <c:forEach items="${person.emails}" var="mail">
            <li><a href="mailto:<c:out value="${mail}"/>"><c:out value="${mail}"/></a></li>
         </c:forEach>
      </ul>

      <c:if test="${not empty person.tweets}">
         <div id="tweets">
         <h3><c:out value="${person.twitterName}"/></h3>
         <c:forEach items="${person.tweets}" var="tweet">
            <p><c:out value="${tweet}"/></p>
         </c:forEach>
         </div>
      </c:if>

      <p>
         <a href="<c:out value="https://cas.umu.se/login?service=http://localhost:8080/springapp/updateperson.htm?username=${person.uid}"/>">Uppdatera person</a>
      </p>

   </div>
</div>
<div id="content-right">
   <div class="container">
      <div id="map-canvas" style="width: 390px; height: 300px; float:right;"></div>
   </div>
</div>

<script type="text/javascript" src="js/umumap.js"></script>
<%@ include file="/WEB-INF/jsp/bottom.jsp" %>