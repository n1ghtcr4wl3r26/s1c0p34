
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<%@ page contentType="text/html;charset=iso-8859-1"%>
<html:html>
<head>
  <meta name="description" content="Sistema de Control de Acreditaciones" />
  <meta name="Author" content="EJAG" lang="es"/> 
  <meta name="copyright" content="&copy; 2013, Aduana Nacional de Bolivia" lang="es" /> 
  <title>Sistema de Control de Acreditaciones</title>
 
 <script type="text/javascript">
  function NoAtras(){
    history.go(1);
  }  
</script>
</head>

<body onLoad="NoAtras();">
    <tiles:insert attribute="content" />
 
</body>
</html:html>