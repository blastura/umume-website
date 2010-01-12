<%@ include file="/WEB-INF/jsp/include.jsp" %>

<html>
    <head>
        <title>asda</title>
        <script src="http://maps.google.com/maps?file=api&amp;v=2&amp;key=ABQIAAAAgjvqnjJXMXDQHpN0ipkEUxQ5Xso4OvBTYOdbhMOxX_XafeJl_xSnGXaw18qDYgpRHk7b37JuQfNoXA" type="text/javascript"></script>
    </head>
  <body>
    <h3>Products</h3>
    <c:out value="${person.name}"/><br />
    <br />
    <c:out value="${person.description}"/>
    <br>
    <a href="<c:url value="findperson.htm"/>">Find new user</a>
    <br />
    <a href="<c:url value="updateperson.htm"/>">Update person</a>
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