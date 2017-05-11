<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/sqltaglib.tld" prefix="database" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ page import="sicopea.*"%>
<%@ page import="java.sql.*, oracle.jdbc.driver.*, java.util.*, java.text.*"%>
<%@ page import="oracle.jdbc.OracleTypes"%>

<%@ page contentType="text/html;charset=iso-8859-1"%>
<html:errors />
<script language="JavaScript" type="text/JavaScript" src="jscript/valida.js?v=2"></script>
<script language="JavaScript" type="text/JavaScript" src="jscript/vmodifent.js?v=2"></script>
<script language="JavaScript" type="text/javascript">

function pasadatos(num)
{
f = document.modacrForm;
f.ccodigo.value = num;
}

</script>
<%
    SimpleDateFormat fFecha = new SimpleDateFormat("dd/MM/yyyy");
    Calendar fecha = Calendar.getInstance();
    fecha.setTime( fecha.getTime() );
    String fActual = fFecha.format( fecha.getTime() );
    fecha.add(Calendar.DATE,-30);
    String fdesde = fFecha.format( fecha.getTime() );
    String entidad = "";
    String usuario = request.getSession().getAttribute("user.nick").toString();
    String perfil = request.getSession().getAttribute("user.perfil").toString(); 
    String ssentidad = util.devuelve_entidad(usuario,perfil);
    String snentidad = util.devuelve_nombre_entidad(usuario,perfil);
    modacrForm modifform =(modacrForm)request.getAttribute("modacrForm");
    reginfForm rform = (reginfForm) request.getAttribute("reginfForm");
    reginfForm rif = (reginfForm)request.getAttribute("reginfForm");
%>
<h2><span class="maintitle">MODIFICACIÓN DE DATOS</span></h2>
<%
String ver = "";

if(modifform ==  null)
{ ver = "true";
}
else
{
  if(modifform.getCcodigo().length()>0)
  {
    ver = "false"; 
  }
  else
  {
    ver = "true";
  }
}

if(ver == "true")
{ %>


<html:form action="/modacr" styleId="frmmodinf" styleClass="form">


  <fieldset>
		<legend class="maintitle2">Institución</legend>
		<table width="100%" class=forumline cellSpacing=1 cellPadding=2 border=0  >
 <tr>
    <td class=cat colspan="3">Nombre de la Institución (misión Diplomática u otro)</td>
  </tr>
  <tr>    <%
if (perfil.equals("ADMINISTRADOR"))
{
  %>
        <td class=cat colspan="2"  >      
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
        else
        {
%>
<td class=row1 colspan="2"  >      
        <%=snentidad%>
<%


        }



        %>
</td>
        <td class=cat  >      
            Tipo de Listado: </br>
            <html:select property="ctipolist" styleId="ctipolist" onchange="this.form.submit()" >
            
            <html:option value="1" >Solo activos</html:option>
            <html:option value="3">Solo cesados</html:option>
      			<html:option value="2">Todos</html:option>
           
        </html:select> 
    </td>
  </tr>
  

<%
  conexion dc = new conexion();
  Connection con = null;
  CallableStatement call = null;

  //String prm_encargado = "EARTEAGA";
  
  try
  {
    
    //depende del perfil direcciona directamente la variable de la entidad

if (perfil.equals("ADMINISTRADOR"))
{
entidad = modifform.getCentidad();
}
else
{
entidad = ssentidad;
}

    con = dc.abrirConexion();
    if(modifform.getCtipolist().equals("1"))
    {
    call = con.prepareCall( "{? = call pkg_acreditacion.lista_acreditados_por_entidad2 ( ? ) }" );
    }
    if(modifform.getCtipolist().equals("2"))
    {
    call = con.prepareCall( "{? = call pkg_acreditacion.lista_acreditados_por_entidad ( ? ) }" );
    }
    if(modifform.getCtipolist().equals("3"))
    {
    call = con.prepareCall( "{? = call pkg_acreditacion.lista_acreditados_por_entidad3 ( ? ) }" );
    }
    call.registerOutParameter( 1, OracleTypes.CURSOR );
    call.setString( 2, entidad);
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
    <td class=cat width="96"  align="center" valign="middle" >Seleccione el código a Modificar</td>
    <td class=cat width="381" align="center" valign="middle" >Nombre</td>
    <td class=cat width="359" align="center" valign="middle">Cargo</td>
    <td class=cat width="146" align="center" valign="middle">Fecha llegada</td>
    <td class=cat width="148" align="center" valign="middle">Fecha cese</td>
  </tr>
  <%
    do
    {

      String tipofil;
tipofil = "row1";
if (rs.getString( 6 ).equals("2"))
{tipofil = "row5";
}
if (rs.getString( 6 ).equals("3"))
{tipofil = "row6";
}
          
%>
<TR >
<TD class=row2 ALIGN="center"  ><SPAN class=genmed>
<input name="botonimg" type="image" src="Select.jpg" onclick="return pasadatos(<%=rs.getString( 1 ) %>);" /></SPAN></TD>
<TD class='<%=tipofil%>' ALIGN="Left"  ><SPAN class=genmed><%=rs.getString( 2 ) %></SPAN></TD>
<TD class='<%=tipofil%>' ALIGN="Left"  ><SPAN class=genmed><%=rs.getString( 3 ) %></SPAN></TD>
<TD class='<%=tipofil%>' ALIGN="center"  ><SPAN class=genmed><%=rs.getString( 4 ) %></SPAN></TD>
<TD class='<%=tipofil%>' ALIGN="center"  ><SPAN class=genmed><%=rs.getString( 5 ) %></SPAN></TD>
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
%>



<html:hidden property="ctipomodif" value="0" />  
<html:hidden property="ccodigo" styleId="ccodigo" styleClass="ccodigo" />
</html:form>

<%}
else
{%>

<%
if (rform!=null)
   {
%>
<%//SimpleDateFormat f=new SimpleDateFormat("dd/MM/yyyy");
try
{

if (!(rif.getResp()==null))
{
%><div style="margin-bottom:4px; background-color: #9DD5EE; border-width:12px; width: 300px; font-family: Verdana, Geneva, sans-serif; color: #003; text-align: center; height: 30px; vertical-align: middle;">
<%=rif.getResp()%>
</div>
<%}}catch(Exception er){}


%>



<html:form action="/reginf" styleId="frmreginf2" styleClass="form"  >
<html:hidden property="ventidad"/>

<%
if (!(rif.getVfeccese()==null))
{
%>
<h2><span class="maintitle">MODIFICAR DATOS</span></h2>
<%
}
else
{
%>
<h2><span class="maintitle">MODIFICAR DATOS REPATRIADOS</span></h2>
<%
} 
%>
<html:hidden property="vcodigo"  />
<html:hidden property="vtipoobs" value="0" />
<html:hidden property="vtipolist"  />
<html:hidden property="vtipomodif" value="0"/>

 <fieldset>
	<legend class="maintitle2">Formulario de Modificaciones</legend>
	<table width="450" class=forumline cellSpacing=1 cellPadding=2 border=0  >
  <tr>
    <td class=row2 colspan="2">CITE Solicitud <% if (!(rif.getVfeccese()==null)) { %> de Acreditación<% } %></td>
    <td class=row2 ALIGN="center" >Fecha de CITE</td>
  </tr>
  <tr>
    <td class=row1 colspan="2">
        <html:text property="vcite" size="30" styleId="vcite" /></td>
    <td class=row1 ><html:text property="vfeccite" size="10" styleId="vfeccite" /></td>
  </tr>
   
  <tr>
    <td class=row2 colspan="3">Nombre de la Persona <% if (!(rif.getVfeccese()==null)) { %>Acreditada<% } %></td>
  </tr>
  <tr>
    <td colspan="3" ><html:text property="vnombre" size="50" styleId="vnombre" onblur="this.value = this.value.toUpperCase()"/></td>
  </tr>
  
  <tr>
    <td class=row2 colspan="3">Documento de Identificaci&oacute;n</td>
  </tr>
  <tr>
    <td colspan="3" >
        Pasaporte&nbsp;<html:text readonly="true" style="text-align:center" property="v_tipodoc" size="16" styleId="v_tipodoc"/>&nbsp; 
        <html:text readonly="true" style="text-align:center" property="v_docidentidad" size="20" styleId="v_docidentidad"/>
    </td>
  </tr>
  
  
  <tr>
    <td class=row2 colspan="3">Cargo de la Persona <% if (!(rif.getVfeccese()==null)) { %>Acreditada<% } %></td>
  </tr>
  <tr>
     <td colspan="3" ><html:textarea property="vcargo" style="width:400px; height:40px; font-family: Arial, Helvetica, sans-serif; font-size: 10px;" styleId="vcargo" onblur="this.value = this.value.toUpperCase()" />
    </td>
  </tr>
  <tr>
    <td class=row2 colspan="3" >Categoría</td>
  </tr>
  <tr>
    <td class=row1  colspan="3" > 
    <html:select property="vcategoria" styleId="vcategoria">
    <%
if (!(rif.getVfeccese()==null))
{
%>
<html:option value="1">Categoría 1</html:option>
        <html:option value="2">Categoría 2</html:option>
        <html:option value="3">Categoría 3</html:option>
        <html:option value="4">Categoría 4</html:option>
        <html:option value="5">Categoría 5</html:option>         
        <html:option value="6">Categoría 6</html:option> 
        <html:option value="Otros">Otros</html:option>
        <html:option value="Ninguna">Ninguna</html:option>
<%
}
else
{
%>
        <html:option value="5">Categoría 5</html:option>         
<%
} 
%>
         
    </html:select> 
    </td>
  </tr>
  <tr>
    <td class=row2 ALIGN="center" >Fecha de llegada al País</td>
    <% if (!(rif.getVfeccese()==null)) { %><td class=row2 ALIGN="center" colspan="2" >Fecha de cese de funciones</td><% } %>
    
  
  </tr>
  <tr>
    <td class=row1  ALIGN="center" ><html:text property="vfecllegada" size="10" styleId="vfecllegada"/></td>
    <% if (!(rif.getVfeccese()==null)) { %><td class=row1  ALIGN="center" colspan="2"  ><html:text property="vfeccese" size="10" styleId="vfeccese"/></td><% } %>
    
    
  </tr>
  <tr>
    <td class=row2 colspan="3"> Fecha de Solicitud de Modificación</td>
  </tr>
  <tr>
    <td class=row1 colspan="3">
        <html:text property="vfecobs" size="10" styleId="vfecobs" value="<%=fActual%>" /></td>
  </tr>
  <tr>
    <td class=row2 colspan="3">Observación</td>
  </tr>
  <tr>
    <td colspan="3" ><html:textarea property="vobs" style="width:400px; height:40px; font-family: Arial, Helvetica, sans-serif; font-size: 10px;" styleId="vobs" onblur="this.value = this.value.toUpperCase()" /></td>
  </tr>
  <tr>
    <td class=row1  colspan="3">&nbsp;</td>
    
  </tr>
  <tr>
    <td class=row2 ALIGN="center" colspan="3"   >
      <div class="buttonlist">
      
<%
if (!(rif.getVfeccese()==null))
{
%>
 <input type="submit" name="boton" value="Modificar" onclick="return fEvaluaModif( );">
<%
}
else
{
%>
<input type="submit" name="boton" value="Modificar" onclick="return fEvaluaModif2( );">
<%
} 
%>
      
       
       
       <input type="submit" name="boton" value="Cancelar">
      </div>
    </td>
  </tr>
</table>
	</fieldset>

</html:form>
<%}}%>