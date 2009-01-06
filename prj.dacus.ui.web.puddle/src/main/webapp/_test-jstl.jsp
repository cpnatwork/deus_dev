<!--
  - Author(s): Christoph P. Neumann
  - Date:
  - Copyright Notice:
  -->
<%-- 
  - @(#) $Id$
  - Description: 
  --%>

<html>
<head>
<title>DACUS</title>
<%@ include file="/WEB-INF/jspf/_frame/scriptInclude.jspf"%>
<%@ include file="/WEB-INF/jspf/_frame/head.jspf"%>
<style type="text/css">
/*<![CDATA[*/
<!--
body {
	
}
--> /*]]>*/
</style>
</head>
<body>

<%@ include file="/WEB-INF/jspf/_frame/header.jspf"%>
<%@ include file="/WEB-INF/jspf/_frame/menuBar.jspf"%>

<div id="content">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:out value="Hello JSTL! ... Hello Christoph!"/>
</div>

<%@ include file="/WEB-INF/jspf/_frame/footnote.jspf"%>
<%@ include file="/WEB-INF/jspf/_frame/footer.jspf"%>

</body>
</html>

