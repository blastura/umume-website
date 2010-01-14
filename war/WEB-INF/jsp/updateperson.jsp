<%@ include file="/WEB-INF/jsp/include.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div id="content-left">
   <div class="container">
      <h1>Uppdatera information: <c:out value="${person.uid}" /></h1>

      <form:form method="post" commandName="updatePerson">
         <ul>
            <li>
               <label>Beskrivning:
               <form:input path="description" />
               </label>
            </li>
            <li>
               <label>Twitternamn: 
               <form:input path="twitterName" />
               </label>
            </li>
            <li>
               <label>Latitude:
               <!-- <input type="text" id="inputLat" name="lat" value="" /> -->
               <form:input path="latitude"/>
               </label>
            </li>
            
            <li>
               <label>Longitude:
               <!-- <input type="text" id="inputLng" name="long" value="" /> -->
               <form:input path="longitude"/>
               </label>
            </li>

            <li>
               <input type="submit" value="Uppdatera information" />
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
