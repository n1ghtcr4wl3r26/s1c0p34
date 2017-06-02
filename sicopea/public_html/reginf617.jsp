<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/sqltaglib.tld" prefix="database" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ page import="sicopea.*"%>
<%@ page import="java.sql.*, oracle.jdbc.driver.*, java.util.*, java.text.*"%>
<%@ page import="oracle.jdbc.OracleTypes"%>

<%@ page contentType="text/html;charset=iso-8859-1"%>

<script language="JavaScript" type="text/JavaScript" src="jscript/valida.js?v=2"></script>
<script language="JavaScript" type="text/JavaScript" src="jscript/vregistroent3.js?v=2"></script>

<link href="fisubice.css" type=text/css rel=stylesheet />
<%
reginf617Form rinf = (reginf617Form)request.getAttribute("reginf617Form");

String usuario = request.getSession().getAttribute("user.nick").toString();
String perfil = request.getSession().getAttribute("user.perfil").toString(); 
String ssentidad = util.devuelve_entidad(usuario,perfil);
String snentidad = util.devuelve_nombre_entidad(usuario,perfil);
%>
<html:errors />    

<html:form action="/reginf617" styleId="frmreginf" styleClass="form" >
<html:hidden property="v_docidentidad" styleId="v_docidentidad"/>
<html:hidden property="v_tipodoc" styleId="v_tipodoc"/>
<html:hidden property="valores" styleId="valores"/>
<html:hidden property="vcategoria" styleId="vcategoria" value="Cooperante"/>
<html:hidden property="vtipodiplomatico" styleId="vtipodiplomatico"/>


<h2><span class="maintitle">REGISTRO</span></h2>
<html:hidden property="vcodigo" value="100" />


 <fieldset>
	<legend class="maintitle2">Formulario de Registro de Acreditaciones</legend>
  
  <table width="700px" class=forumline cellSpacing=1 cellPadding=2 border=0  >
  <tr>
    <td class=row2 >Documento de Identificación:</td>
    <td class=row1 ><html:text property="vdocidentidad" size="20" maxlength="30" styleId="vdocidentidad" /></td>
    <td class=row1 >
        <html:select property="vtipodoc" styleId="vtipodoc" >
            <html:option value="">-- Seleccione una Clase de Pasaporte --</html:option>
            <html:option value="Diplomatico">Diplom&aacute;tico</html:option>
            <html:option value="Oficial">Oficial</html:option>
            <html:option value="Servicio">Servicio</html:option>
            <html:option value="Corriente">Corriente</html:option>
            <html:option value="Especial">Especial</html:option>
        </html:select>
    </td>
    
    <td class=row1 ><html:submit property="boton" value="Recuperar" onclick="return fEvalua2( );"/></td>    
  </tr>
  </table>
 <br>
  
  
<%reginf617Form rif = (reginf617Form)request.getAttribute("reginf617Form");
try
{
if (!(rif.getResp()==null))
{
%><div style="margin-bottom:4px; background-color: #9DD5EE; border-width: 12px; width: 90%; font-family: Verdana, Geneva, sans-serif; color: #003; text-align: left; height: 30px; vertical-align: middle;">
<%=rif.getResp()%>
</div><br>
<%}}catch(Exception er){}%>


	<table width="450" class=forumline cellSpacing=1 cellPadding=2 border=0  >
  <tr>
    <td class=row2 colspan="3">Nombre de la Institución (misión Diplomática u otro)</td>
  </tr>
  <tr>
    <% if (perfil.equals("ADMINISTRADOR"))
{
  %><td class=cat colspan="3"  >      
            Institución: <html:select property="ventidad" styleId="centidad" >
            <% 
            reginf617Form con = (reginf617Form)request.getAttribute("reginf617Form");
            
            if(con.getVentidad() == null)
            {
            %>
            <%=util.devuelve_entidades("0")%>
            <%}
            else
            {
            %>
            <%=util.devuelve_entidades(con.getVentidad())%>
            <%
            }
            %>
            </html:select> 
        <%
}       %>
    </td>
  </tr>
  <tr>
    <td class=row2 colspan="2">CITE Solicitud de Acreditación</td>
    <td class=row2 ALIGN="center" >Fecha de CITE</td>
  </tr>
  <tr>
    <td class=row1 colspan="2">
        <html:text property="vcite" size="70" maxlength="150" styleId="vcite" /></td>
    <td class=row1 ><html:text property="vfeccite" size="10"  maxlength="10" styleId="vfeccite" /></td>
  </tr>
 
  <tr>
    <td class=row2 colspan="3">Nombre de la Persona Acreditada</td>
  </tr>
  <tr>
    <td colspan="3" ><html:text property="vnombre" size="120" maxlength="400" styleId="vnombre" onblur="this.value = this.value.toUpperCase()"/></td>
  </tr>
  
  <tr>
    <td class=row2 colspan="3">Cargo de la Persona Acreditada</td>
  </tr>
   <tr>
     <td colspan="3" ><html:textarea property="vcargo" style="width:400px; height:40px; font-family: Arial, Helvetica, sans-serif; font-size: 10px;" styleId="vcargo" onblur="this.value = this.value.toUpperCase()" />
    </td>
  </tr>
  <tr>
    <td class="row2" colspan="3">Nombre del Proyecto y/o Programa al que pertenece</td>
  </tr>
  <tr>
    <td colspan="3">
        <html:textarea property="vproyecto" style="width:400px; height:40px; font-family: Arial, Helvetica, sans-serif; font-size:10px" styleId="vproyecto" onblur="this.value=this.value.toUpperCase()"/>
    </td>
  </tr>  
  <tr>
    <td class=row2 ALIGN="center" >Fecha de llegada al País</td>
    <td class=row2 ALIGN="center" colspan="2" >Fecha de cese de funciones</td>
  
  </tr>
  <tr>
    <td class=row1  ALIGN="center" ><html:text property="vfecllegada" size="10"  maxlength="10" styleId="vfecllegada"/></td>
    <td class=row1  ALIGN="center" colspan="2"  ><html:text property="vfeccese" size="10" maxlength="10" styleId="vfeccese"/></td>
    
  </tr>
  <tr>
    <td class=row1  colspan="3">&nbsp;</td>
    
  </tr>
  <tr>
  <td class=row2 ALIGN="center" colspan="3"   >
      <div class="buttonlist">
       <html:submit property="boton" value="Grabar" onclick="return fEvalua( );"/>
        
      </div></td>
  </tr>
</table>


	</fieldset>

</html:form>