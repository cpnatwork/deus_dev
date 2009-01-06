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
<table>
<tr><td>EL - tag text</td><td></td></tr>
<tr><td>\${application.contextPath}</td><td>${application.contextPath}</td><td>NOK</td></tr>
<tr><td>\${application.getContextPath}</td><td>${application.getContextPath}</td><td>NOK</td></tr>
<tr><td>\${request.contextPath}</td><td>${request.contextPath}</td><td>NOK</td></tr>
<tr><td>\${pageContext.request.contextPath}</td><td>${pageContext.request.contextPath}</td><td>OK</td></tr>
<tr><td>EL - attribute text</td><td></td></tr>
<tr><td>\${application.contextPath}</td><td><a href="${application.contextPath}">link</a></td><td>OK+/subpath+page</td></tr>
<tr><td>\${application.getContextPath}</td><td><a href="${application.getContextPath}">link</a></td><td>OK+/subpath+page</td></tr>
<tr><td>\${request.contextPath}</td><td><a href="${request.contextPath}">link</a></td><td>OK+/subpath+page</td></tr>
<tr><td>\${pageContext.request.contextPath}</td><td><a href="${pageContext.request.contextPath}">link</a></td><td>OK, but non-relevant Exception Error in Eclipse</td></tr>
<tr><td>Old School</td><td></td></tr>
<tr><td>= application.getContextPath()</td><td><%= application.getContextPath() %></td><td>OK</td></tr>
<tr><td>= request.getContextPath()</td><td><%= request.getContextPath() %></td><td>OK</td></tr>
</table>
</div>

<%@ include file="/WEB-INF/jspf/_frame/footnote.jspf"%>
<%@ include file="/WEB-INF/jspf/_frame/footer.jspf"%>

</body>
</html>

