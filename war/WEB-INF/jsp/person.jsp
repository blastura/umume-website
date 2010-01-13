<%@ include file="/WEB-INF/jsp/include.jsp" %>

    <h3>Products</h3>
    <c:out value="${person.name}"/><br />
    <br />
    <c:out value="${person.description}"/>
    <br>
    <a href="<c:url value="findperson.htm"/>">Find new user</a>
    <br />
    <a href="<c:url value="https://cas.umu.se/login?service=http://localhost:8080/springapp/updateperson.htm?username=${person.username}"/>">Update person</a>
    <br>
    <div id="map_canvas" style="width: 300px; height: 300px; float:right;"></div>
    
    <c:forEach items="${person.tweets}" var="tweet">
      <c:out value="${tweet}"/><br><br>
    </c:forEach>
    
    <script type="text/javascript">
      if (GBrowserIsCompatible()) {
        
        var storeLocation = new GClientGeocoder();
        storeLocation.getLatLng("kuratorvägen 29 umeå", placeMarker);       
      }
        function placeMarker(obj) {     
            console.log(obj);
            var map = new GMap2(document.getElementById("map_canvas"));
            map.setCenter(new GLatLng(obj.lat(), obj.lng()), 13);
            //var latlng = new GLatLng(southWest.lat() + latSpan * Math.random(),
            //  southWest.lng() + lngSpan * Math.random());
            map.addOverlay(new GMarker(obj));
        }
    </script>
    
  </body>
</html>