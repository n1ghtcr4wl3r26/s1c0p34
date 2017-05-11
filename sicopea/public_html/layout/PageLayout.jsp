<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<?xml version="1.0" encoding="utf-8"?> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html:html>
<head>
	<meta name="description" content="Sistema de Control de Acreditaciones" />
  <meta name="Author" content="EJAG" lang="es"/> 
  <meta name="copyright" content="&copy; 2010, Aduana Nacional de Bolivia" lang="es" />     
  <title>Sistema de Control de Acreditaciones</title>
  <link href="css/layout.css" rel="stylesheet" type="text/css" />
  <link href="css/content.css" rel="stylesheet" type="text/css" />
  <link href="css/fisubice.css" type=text/css rel=stylesheet />
	<tiles:useAttribute name="jscript" scope="request" ignore="true" />
  <logic:notEmpty name="jscript">
    <script language="JavaScript" src="jscript/jquery.js"></script>
    <script language="JavaScript" src="<tiles:getAsString name='jscript' />"></script>
  </logic:notEmpty>
</head>
<body>
<div id="container">
  <div id="header">
    <tiles:insert attribute="header" />
  </div>
  <div id="contentp">
    <tiles:insert attribute="content" />
  </div>
  <tiles:insert attribute="footer" />
</div>
</body>
</html:html>