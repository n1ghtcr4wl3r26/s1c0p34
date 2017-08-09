<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>

<html:html>
<head>
	<meta name="description" content="Sistema de Control de Acreditaciones" />
  <meta name="Author" content="EJAG" lang="es"/> 
  <title>Sistema de Control de Acreditaciones</title>
 
	<tiles:useAttribute name="jscript" scope="request" ignore="true" />
  <logic:notEmpty name="jscript">
    <script language="JavaScript" src="jscript/jquery.js"></script>
    <script language="JavaScript" src="jscript/valida.js?${sessionScope.VERSION_ASSETS}"></script>
    <script language="JavaScript" src="<tiles:getAsString name='jscript' />" charset="utf-8"></script>
  </logic:notEmpty>
  <link href="css/layout.css" rel="stylesheet" type="text/css" />
  <link href="css/content.css" rel="stylesheet" type="text/css" />
  <link href="css/fisubice.css" type=text/css rel=stylesheet />
</head>
<body OnLoad="NoAtras();">
<div id="container">
	<div id="header">
		<tiles:insert attribute="header" />
	</div>

  <div id="sidebar">
		<tiles:insert attribute="sidebar" />
	</div>
	<div id="wrapper">
		<div id="content">
			<tiles:insert attribute="content" />
		</div>
	</div>
	
	<tiles:insert attribute="footer" />
</div>
</body>
</html:html>