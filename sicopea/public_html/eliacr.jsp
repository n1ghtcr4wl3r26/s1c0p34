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
<script language="JavaScript" type="text/JavaScript" src="jscript/velimreg.js?v=2"></script>
<script language="JavaScript" type="text/javascript">
<!--
function pasadatos(num)
{ 
f = document.eliacrForm;
f.ccodigo.value = num;
}
-->
</script>
<h2><span class="maintitle">ELIMINACIÓN DE ACREDITADOS</span></h2>

<html:form action="/eliacr" styleId="frmreginf" styleClass="form" onsubmit="return fEvalua( );">

<html:hidden property="ccodigo" styleId="ccodigo" styleClass="ccodigo" />
  <fieldset>
<legend class="maintitle2">Formulario de Eliminación de Acreditados</legend>
		<table width="100%" class=forumline cellSpacing=1 cellPadding=2 border=0  >
 <tr>
    <td class=cat colspan="3">Nombre de la Institución (misión Diplomática u otro)</td>
  </tr>
  <tr>
    
          <%
String usuario = request.getSession().getAttribute("user.nick").toString();
String perfil = request.getSession().getAttribute("user.perfil").toString(); 
String ssentidad = util.devuelve_entidad(usuario,perfil);
String snentidad = util.devuelve_nombre_entidad(usuario,perfil);
String entidad = "";


if (perfil.equals("ADMINISTRADOR"))
{
  %>
        <td class=cat colspan="3"  >      
            Institución: <html:select property="centidad" styleId="centidad" onchange="this.form.submit()" >
           <% 
            eliacrForm con = (eliacrForm)request.getAttribute("eliacrForm");
            
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
<td class=row1 colspan="3"  >      
        <%=snentidad%>
<%


        }



        %>
    </td>
  </tr>
  </table>
  </fieldset>

<%
  conexion dc = new conexion();
  Connection con = null;
  CallableStatement call = null;

  //String prm_encargado = "EARTEAGA";
  
  eliacrForm modifform =(eliacrForm)request.getAttribute("eliacrForm");

  try
  {
    

    if (perfil.equals("ADMINISTRADOR"))
{
entidad = modifform.getCentidad();
}
else
{
entidad = ssentidad;
}

    con = dc.abrirConexion();
    call = con.prepareCall( "{? = call pkg_acreditacion.lista_acreditados_por_entidad ( ? ) }" );
    call.registerOutParameter( 1, OracleTypes.CURSOR );
    call.setString( 2, entidad);
    call.execute();
%>


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
    <td class=cat align="center" valign="middle" width="10%">Seleccione</td>
    <td class=cat align="center" valign="middle" width="201">Nombre</td>
    <td class=cat align="center" valign="middle" width="185">Cargo</td>
    <td class=cat align="center" valign="middle" width="75">Fecha llegada</td>
    <td class=cat align="center" valign="middle" width="75">Fecha cese</td>
  </tr>
  
<% 
    do
    {     
%>
<td class=row2 ALIGN="Left" valign="TOP" >
<input name="botonimg" type="image" src="Delete.jpg" onclick="return pasadatos(<%=rs.getString( 1 ) %>)" />
</td>
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
%>

</html:form>

