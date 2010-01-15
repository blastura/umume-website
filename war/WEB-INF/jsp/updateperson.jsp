<%@ include file="/WEB-INF/jsp/include.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div id="content-left">
   <div class="container">
      <h1>Uppdatera information: <c:out value="${person.uid}" /></h1>

      <form:form method="post" commandName="updatePerson">
         <ul>
            <li>
               <label>Beskrivning: </label>
               <form:textarea path="description" />
            </li>
            <li>
               <label>Twitternamn: </label>
               <form:input path="twitterName" />
            </li>
            <li>
               <label>Latitude:</label>
               <!-- <input type="text" id="inputLat" name="lat" value="" /> -->
               <form:input path="latitude"/>
            </li>
            
            <li>
               <label>Longitude:</label>
               <!-- <input type="text" id="inputLng" name="long" value="" /> -->
               <form:input path="longitude"/>
            </li>

            <li><br />
               <button type="submit">Uppdatera information</button>
            </li>
         </ul>
      </form:form>
   </div>
</div>
<div id="content-right">
   <div class="container">
      <h3>Var befinner du dig?</h3>
      <div id="map-canvas" style="width: 390px; height: 500px; float:right;"></div>
   </div>
</div>

<script type="text/javascript" src="/umume/js/umumap.js"></script>
<%@ include file="/WEB-INF/jsp/bottom.jsp" %>
