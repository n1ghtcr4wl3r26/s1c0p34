<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/sqltaglib.tld" prefix="database" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ page import="sicopea.*"%>
<%@ page import="java.sql.*, oracle.jdbc.driver.*, java.util.*, java.text.*"%>
<%@ page import="oracle.jdbc.OracleTypes"%>

<%@ page contentType="text/html;charset=iso-8859-1"%>
<html:errors />
<script language="JavaScript" type="text/javascript">
<!--
function pasadatos(num)
{ 
f = document.modacrForm;
f.ccodigo.value = num;
}
-->
</script>
<h2><span class="maintitle">MODIFICACIÓN DE ACREDITADOS</span></h2>

<html:form action="/modacr" styleId="frmreginf" styleClass="form">
  <fieldset>
<legend class="maintitle2">Formulario de Modificación de Acreditaciones</legend>
		<table width="100%" class=forumline cellSpacing=1 cellPadding=2 border=0  >
 <tr>
      <td class=cat colspan="3">Nombre de la Institución (misión Diplomática u otro)</td>
  </tr>
  <tr>
        
          <%
String usuario = request.getSession().getAttribute("user.nick").toString();
String perfil = request.getSession().getAttribute("user.perfil").toString(); 
String entidad = "";

if (perfil.equals("ADMINISTRADOR"))
{
  %>
        <td class=cat colspan="3"  >      
            Institución: <html:select property="centidad" styleId="centidad" onchange="this.form.submit()" >
            <% 
            modacrForm con = (modacrForm)request.getAttribute("modacrForm");
            
            if(con.getCentidad() == null)
            {
            %>
            <%=util.devuelve_entidades("0")%>
            <%}
            else
            {
            %>
            <%=util.devuelve_entidades(con.getCentidad())%>
            <%
            }
            %>
        </html:select> 

        <%
}
        
        %>
    </td>
  </tr>
  

<%
  conexion dc = new conexion();
  Connection con = null;
  CallableStatement call = null;

  //String prm_encargado = "EARTEAGA";
  modacrForm moform =(modacrForm)request.getAttribute("modacrForm");
  
if (!(moform.getCentidad()==null))
   {
  
  try
  {
    con = dc.abrirConexion();
    call = con.prepareCall( "{? = call pkg_acreditacion.lista_acreditados_por_entidad ( ? ) }" );
    call.registerOutParameter( 1, OracleTypes.CURSOR );
    call.setString( 2, moform.getCentidad());
    call.execute();
%>
</table>
 </fieldset>

 
  <%
  int c=0;
  ResultSet rs = ( ResultSet ) call.getObject( 1 );
  if( ! ( rs == null || !rs.next() ) )
  {

  %>
<fieldset>
		<legend class="maintitle2">Listado de personas Acreditadas</legend>

  
<table width="100%" class=forumline cellSpacing=1 cellPadding=2 border=0  >
<tr>
    <td class=cat align="center" valign="middle" width="49">&nbsp;</td>
    <td class=cat align="center" valign="middle" width="201">Nombre</td>
    <td class=cat align="center" valign="middle" width="185">Cargo</td>
    <td class=cat align="center" valign="middle" width="75">Fecha llegada</td>
    <td class=cat align="center" valign="middle" width="75">Fecha cese</td>
</tr>
  
<% 
    do
    {     
%><tr>
<TD class=row2 ALIGN="Left" valign="TOP" ><FONT STYLE = "font-family:Tahoma; font-size:7pt; ">
<input name="botonimg" type="image" src="Select.jpg" onclick="return pasadatos(<%=rs.getString( 1 ) %>)" /></FONT></TD>
<TD class=row1 ALIGN="Left" valign="TOP" ><FONT STYLE = "font-family:Tahoma; font-size:7pt; "><%=rs.getString( 2 ) %></FONT></TD>
<TD class=row1 ALIGN="Left" valign="TOP" ><FONT STYLE = "font-family:Tahoma; font-size:7pt; "><%=rs.getString( 3 ) %></FONT></TD>
<TD class=row1 ALIGN="Left" valign="TOP" ><FONT STYLE = "font-family:Tahoma; font-size:7pt; "><%=rs.getString( 4 ) %></FONT></TD>
<TD class=row1 ALIGN="Left" valign="TOP" ><FONT STYLE = "font-family:Tahoma; font-size:7pt; "><%=rs.getString( 5 ) %></FONT></TD>
</TR>
<%
    }while(rs.next());   
     %>
</table>
	</fieldset>
     <%
  }
%>
  </table>

<%   
  }
  catch (Exception er) 
  {
    er.printStackTrace();
  } 
  finally 
  {
    try 
    {  
      if (con != null) con.close();
          
    }
    catch (SQLException er) 
    {
      ;
    }
  }
  }
%>

<html:hidden property="ccodigo" styleId="ccodigo" styleClass="ccodigo" />
</html:form>


<%
 reginfForm rform = (reginfForm) request.getAttribute("reginfForm");

if (!(rform==null))
   {
%>


<html:form action="/reginf" styleId="frmreginf" styleClass="form">
<h2><span class="maintitle">MODIFICAR DATOS</span></h2>
<html:hidden property="vcodigo" />
 <fieldset>
	<legend class="maintitle2">Formulario de Modificaciones</legend>
	<table width="450" class=forumline cellSpacing=1 cellPadding=2 border=0  >
  <tr>
    <td class=row2 colspan="2">CITE Solicitud de Acreditación</td>
    <td class=row2 ALIGN="center" >Fecha de CITE</td>
  </tr>
  <tr>
    <td class=row1 colspan="2">
        <html:text property="vcite" size="30" styleId="vcite" /></td>
    <td class=row1 ><html:text property="vfeccite" size="10" styleId="vfeccite" /></td>
  </tr>   
  <tr>
    <td class=row2 colspan="3">Nombre de la Persona Acreditada</td>
  </tr>
  <tr>
    <td colspan="3" ><html:text property="vnombre" size="50" styleId="vnombre"/></td>
  </tr>
  <tr>
    <td class=row2 colspan="3">Cargo de la Persona Acreditada</td>
  </tr>
  <tr>
    <td colspan="3" ><html:text property="vcargo" size="50" styleId="vcargo"/></td>
  </tr>
  <tr>
    <td class=row2 colspan="3" >Categoría</td>
  </tr>
  <tr>
    <td class=row1  colspan="3" > 
   <html:select property="vcategoria" styleId="vcategoria">
        <html:option value="1">Categoria 1</html:option>
        <html:option value="2">Categoria 2</html:option>
        <html:option value="3">Categoria 3</html:option>
        <html:option value="4">Categoria 4</html:option>
        <html:option value="5">Categoria 5</html:option>         
        <html:option value="6">Categoria 6</html:option> 
        <html:option value="Otros">Otros</html:option>
        <html:option value="Ninguna">Ninguna</html:option>
    </html:select>  
    </td>
  </tr>
  <tr>
    <td class=row2 ALIGN="center" >Fecha de llegada al Pais</td>
    <td class=row2 ALIGN="center" colspan="2" >Fecha de cese de funciones</td>
  
  </tr>
  <tr>
    <td class=row1  ALIGN="center" ><html:text property="vfecllegada" size="10" styleId="vfecllegada"/></td>
    <td class=row1  ALIGN="center" colspan="2"  ><html:text property="vfeccese" size="10" styleId="vfeccese"/></td>
    
  </tr>
  <tr>
    <td class=row1  colspan="3">&nbsp;</td>
    
  </tr>
  <tr>
  <td class=row2 ALIGN="center" colspan="3"   >
      <div class="buttonlist">
       <html:submit property="boton" value="Modificar"/>
       <input type="button" name="cancel" value="Cancelar"/>       
      </div></td>
  </tr>
</table>
	</fieldset>

</html:form>
<%}%>