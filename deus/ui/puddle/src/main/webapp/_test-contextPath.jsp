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
<ol>
<li>\${request.contextPath}&nbsp;${request.contextPath}</li>
<li>\${pageContext.request.contextPath}&nbsp;${pageContext.request.contextPath} [OK]</li>
<li>\${application.contextPath}&nbsp;${application.contextPath}</li>
<li>\${application.getContextPath}&nbsp;${application.getContextPath}</li>
<li>\${request.contextPath}&nbsp;<a href="${request.contextPath}">link</a></li>
<li>\${pageContext.request.contextPath}&nbsp;<a href="${pageContext.request.contextPath}">link</a> [OK]</li>
<li>\${application.contextPath}&nbsp;<a href="${application.contextPath}">link</a></li>
<li>\${application.getContextPath}&nbsp;<a href="${application.getContextPath}">link</a></li>
<li>= request.getContextPath()&nbsp;<%= request.getContextPath() %> [OK]</li>
<li>= request.getContextPath()&nbsp;<%= application.getContextPath() %> [OK]</li>
</ol>
</div>

<%@ include file="/WEB-INF/jspf/_frame/footnote.jspf"%>
<%@ include file="/WEB-INF/jspf/_frame/footer.jspf"%>

</body>
</html>

