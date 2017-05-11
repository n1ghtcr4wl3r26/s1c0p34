<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/sqltaglib.tld" prefix="database" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ page import="sicopea.*"%>
<%@ page import="java.sql.*, oracle.jdbc.driver.*, java.util.*, java.text.*"%>
<%@ page import="oracle.jdbc.OracleTypes"%>

<%@ page contentType="text/html;charset=iso-8859-1"%>

<%
 String usuario = request.getSession().getAttribute("user.nick").toString();
String perfil = request.getSession().getAttribute("user.perfil").toString(); 
String ssentidad = util.devuelve_entidad(usuario,perfil);
String snentidad = util.devuelve_nombre_entidad(usuario,perfil);
%>
<script language="JavaScript" type="text/JavaScript" src="jscript/valida.js?v=2"></script>
<script language="JavaScript" type="text/JavaScript" src="jscript/vregent.js?v=2"></script>
<html:errors />    
<html:form action="/regent" styleId="frmreginf" styleClass="form" onsubmit="return fEvalua( );">
<h2><span class="maintitle">REGISTRO DE ENTIDADES</span></h2>
<html:hidden property="vcodigo" value="100" />

<%regentForm rif = (regentForm)request.getAttribute("regentForm");
try
{
if (!(rif.getResp()==null))
{
%><div style="margin-bottom:4px; background-color: #9DD5EE; border-width: 12; width: 300px; font-family: Verdana, Geneva, sans-serif; color: #003; text-align: center; height: 30px; vertical-align: middle;">
<%=rif.getResp()%>
</div>
<%}}catch(Exception er){}%>

 <fieldset>
	<legend class="maintitle2">Formulario de Registro de Entidades</legend>
	<table width="450" class=forumline cellSpacing=1 cellPadding=2 border=0  >
 
  <tr>
    <td class=row2 colspan="2">Nombre de la Institución (misión Diplomática u otro)</td>
  </tr>
  <tr>
    <td class=row1 colspan="2"><html:text property="vnombre" size="50" styleId="vnombre" /></td>
    </tr>
  <tr>
    <td class=row2 colspan="2">Dirección</td>
  </tr>
  <tr>
    <td class=row1 colspan="2">
        <html:text property="vdireccion" size="50" styleId="vdireccion" /></td>
  </tr>
    <tr>
    <td class=row2 >Telefono</td>
    <td class=row2 >Fax</td>
  </tr>
  <tr>
    <td class=row1 ><html:text property="vtel" size="10" styleId="vtel"/></td>
    <td class=row1 ><html:text property="vfax" size="10" styleId="vfax"/></td>
  </tr>
  <tr>
    <td class=row2 colspan="2">Pagina web o correo electronico</td>
  </tr>
  <tr>
    <td class=row1 colspan="2" ><html:text property="vmail" size="50" styleId="vmail"/></td>
  </tr>
  
  <tr>
    <td class=row1  colspan="2">&nbsp;</td>
    
  </tr>
  <tr>
  <td class=row2 ALIGN="center" colspan="2"   >
      <div class="buttonlist">
       <html:submit property="boton" value="Grabar"/>      
      </div></td>
  </tr>
</table>
	</fieldset>

</html:form>