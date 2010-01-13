<%@ page session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
   <head>
      <title>UmuMe</title>
      <meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
      <script src="http://maps.google.com/maps?file=api&amp;v=2&amp;key=ABQIAAAAgjvqnjJXMXDQHpN0ipkEUxQ5Xso4OvBTYOdbhMOxX_XafeJl_xSnGXaw18qDYgpRHk7b37JuQfNoXA" type="text/javascript"></script>
      <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.2/jquery.js"></script>
      <link rel="stylesheet" type="text/css" href="/umume/css/style.css" />
      <script type="text/javascript" src="/umume/js/search.js"></script>
   </head>
   <body>
      <div id="wrap">
         <div id="header">
            <div id="searcher">
               <label>Search: <input type="text" id="search-field" name="search" value="" /></label>
               <span id="search-status"></span>
               <div id="search-output"></div>
            </div>
         </div>