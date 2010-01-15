<%@ include file="/WEB-INF/jsp/include.jsp" %>

<div id="content-left">
   <div class="container">
      <c:if test="${not empty person.photoURI}">
         <img src="<c:out value="${person.photoURI}"/>" id="profile-pic"/>
      </c:if>
      <h2><c:out value="${person.givenName} ${person.familyName}"/></h2>
      <span id="employeeType">
         <c:choose>
            <c:when test="${not empty person.employeeType}">
               <c:out value="${person.employeeType}"/>
            </c:when>
            <c:otherwise>
               Student
            </c:otherwise>
         </c:choose>
      </span>
      <p>
         <c:out value="${person.description}"/><br />
         <c:out value="${person.street}"/><br />
      </p>
      <c:if test="${not empty person.employeeType}">
         <p>
            <c:out value="${person.buildingName}, ${person.physicalDeliveryOffice}, ${person.roomNumber}"/><br />
         </p>
      </c:if>

      <ul>
         <c:forEach items="${person.emails}" var="mail">
            <li><a href="mailto:<c:out value="${mail}"/>"><c:out value="${mail}"/></a></li>
         </c:forEach>
      </ul>
      <br />
      <c:if test="${not empty person.tweets}">
         <ul id="tweets">
            <h3><c:out value="${person.twitterName}"/>s Twitterfeed</h3>
            <c:forEach items="${person.tweets}" var="tweet">
               <li><p><c:out value="${tweet}"/></p></li>
            </c:forEach>
         </ul>
      </c:if>

      <p>
         <a href="<c:out value="https://cas.umu.se/login?service=http://${pageContext.request.serverName}:${pageContext.request.serverPort}/umume/updateperson.htm?username=${person.uid}"/>">Uppdatera person</a>
      </p>

   </div>
</div>
<div id="content-right">
   <div class="container">
      <div id="map-canvas" style="width: 390px; height: 500px; float:right;"></div>
      <c:if test="${not (person.latitude == 0 || person.longitude == 0)}">
         <span id="latitude"><c:out value="${person.latitude}" /></span>, <span id="longitude"><c:out value="${person.longitude}"/></span>
      </c:if>
   </div>
</div>

<script type="text/javascript" src="/umume/js/umumap.js"></script>
<%@ include file="/WEB-INF/jsp/bottom.jsp" %>
