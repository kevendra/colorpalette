<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title><fmt:message key="site.title"/></title>
<link rel="stylesheet" type="text/css" href="<c:url value="/css/main.css"/>" />

    <link type="text/css" rel="stylesheet" href="<c:url value="/JSCal2-1.8/css/jscal2.css"/>" /> 
    <link type="text/css" rel="stylesheet" href="<c:url value="/JSCal2-1.8/css/border-radius.css"/>" /> 
    

    <link id="skin-win2k" title="Win 2K" type="text/css" rel="alternate stylesheet" href="<c:url value="/JSCal2-1.8/css/win2k/win2k.css"/>" />
    <link id="skin-steel" title="Steel" type="text/css" rel="alternate stylesheet" href="<c:url value="/JSCal2-1.8/css/steel/steel.css"/>" />
    <link id="skin-gold" title="Gold" type="text/css" rel="alternate stylesheet" href="<c:url value="/JSCal2-1.8/css/gold/gold.css"/>" />
    <link id="skin-matrix" title="Matrix" type="text/css" rel="alternate stylesheet" href="<c:url value="/JSCal2-1.8/css/matrix/matrix.css"/>" />

    <link id="skinhelper-compact" type="text/css" rel="alternate stylesheet" href="<c:url value="/JSCal2-1.8/css/reduce-spacing.css"/>" />

    <script src="<c:url value="/JSCal2-1.8/js/jscal2.js"/>" ></script>
   	<script src="<c:url value="/JSCal2-1.8/js/lang/en.js"/>" ></script>
   	
	<script type="text/javascript" src="<c:url value="/js/jscolor/jscolor.js"/>" ></script>   	
   
</head>
<body>
<div id="header">
	<div id="headerTitle"><tiles:insertAttribute name="header" /></div>
</div>
<div id="menu">
	<tiles:insertAttribute name="menu" />
</div>
<div id="content">
	<tiles:insertAttribute name="content" />
</div>
<div id="footer">
	<tiles:insertAttribute name="footer" />
</div>
</body>
</html>
