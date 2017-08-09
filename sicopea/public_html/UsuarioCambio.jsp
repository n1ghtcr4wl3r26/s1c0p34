<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ page import="sicopea.*"%>

<%
String usuario = request.getSession().getAttribute("user.nick").toString();
 // String usuario = (String) ( (ClaseSession) request.getSession().getAttribute("ClaseSession") ).getCodusu();
 
 CambioForm cb = (CambioForm)request.getAttribute("CambioForm");
%>

<script language="JavaScript" type="text/JavaScript" src="js/valida.js?${sessionScope.VERSION_ASSETS}"></script>
<script language="JavaScript" type="text/JavaScript" src="js/UsuarioCambio.js?${sessionScope.VERSION_ASSETS}"></script>

<html:form action="/CambioAction" onsubmit="return fEvalua ( );" focus="clave">
  <html:hidden property="usuario" value="<%=usuario%>"/>
  <table cellspacing="0" cellpadding="3" border="0" width="35%">
    <tr>
      <td class="t14">Ingrese Usuario y Contrase&ntilde;a</td>
    </tr>
  </table>
  <table cellspacing="2" cellpadding="3" border="0" width="35%" id="a" class="marco">
    <tr>
      <th>Usuario:</th>
      <td><%= usuario %></td>
    </tr>
    <tr>
      <th>(*) Anterior Contrase&ntilde;a:</th>
      <td><html:password property="clave" maxlength="15" size="20" redisplay="false"/></td>
    </tr>
    <tr>
      <th>(*) Nueva Contrase&ntilde;a:</th>
      <td><html:password property="confnuevo" maxlength="15" size="20" redisplay="false"/></td>
    </tr>
    <tr>
      <th>(*) Confirmaci&oacute;n Contrase&ntilde;a:</th>
      <td><html:password property="nuevo" maxlength="15" size="20" redisplay="false"/></td>
    </tr>
    <tr>
      <td colspan="2" class="C">
        <html:hidden property="opcion" />
        <html:submit value="Aceptar" onclick="opcion.value=1;bCancel=false"/>
        <html:submit value="Cancelar" onclick="opcion.value=2;bCancel=true"/>
      </td>
    </tr>
    <tr>
      <td colspan="2" class="s9">(*) Hay diferencias entre May&uacute;sculas y Min&uacute;sculas</td>
    </tr>
  </table>
  <%
  try{
  if(cb.getMsg() != null)
  {
  %><%=cb.getMsg()%><%
  }
  }
  catch(Exception ex)
  {
  }
  
  %>
  
</html:form>