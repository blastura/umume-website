var oB = {
  addEvent: function(elm, evType, fn, useCapture) {
    // cross-browser event handling for IE5+, NS6 and Mozilla
    // By Scott Andrew
    if (elm.addEventListener) {
      elm.addEventListener(evType, fn, useCapture);
      return true;
    } else if (elm.attachEvent) {
      var r = elm.attachEvent('on' + evType, fn);
      return r;
    } else {
      elm['on' + evType] = fn;
    }
  },

  init: function() {
    if (GBrowserIsCompatible()) {
      var map = new GMap2(document.getElementById("map-canvas"));
      map.setCenter(new GLatLng(63.82045852982942, 20.307787656784058), 18);

      var boundaries = new GLatLngBounds(
        new GLatLng(63.82012764313529, 20.30680791466784),
        new GLatLng(63.82070236978285, 20.30879572927132));
      var oldmap = new GGroundOverlay("/umume/images/mit4.png", boundaries);
      map.setUIToDefault();
      map.addOverlay(oldmap);
      var myLayer = new GLayer("com.panoramio.all");
      map.addOverlay(myLayer);

      // Add marker
      var lat = document.getElementById("latitude").innerHTML;
      var lng = document.getElementById("longitude").innerHTML;
      if (!isNaN(lat) && !isNaN(lng)) {
        var point = new GLatLng(lat, lng);
        map.addOverlay(new GMarker(point));
      }


      GEvent.addListener(map,"click", function(overlay,latlng) {
                           if (overlay) {
                             // ignore if we click on the info window
                             return;
                           }
                           var tileCoordinate = new GPoint();
                           var tilePoint = new GPoint();
                           var currentProjection = G_NORMAL_MAP.getProjection();
                           tilePoint = currentProjection.fromLatLngToPixel(latlng, map.getZoom());
                           tileCoordinate.x = Math.floor(tilePoint.x / 256);
                           tileCoordinate.y = Math.floor(tilePoint.y / 256);
                           var myHtml = "Latitude: " + latlng.lat() + "<br/>Longitude: " + latlng.lng();
                           map.openInfoWindow(latlng, myHtml);
                           document.getElementById("latitude").value = latlng.lat();
                           document.getElementById("longitude").value = latlng.lng();
                         });
    } else {
      alert("map not supported");
    }
  }
};
oB.addEvent(window, 'load', oB.init, false);
