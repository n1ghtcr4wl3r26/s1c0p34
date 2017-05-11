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
<script language="JavaScript" type="text/JavaScript" src="jscript/conacr2.js?v=2"></script>
<script language="JavaScript" type="text/javascript">
<!--

function pasadatos(num)
{ 
    f = document.conacr2Form;
    f.ccodigo.value = num;
    f2 = document.impacr2Form;
    f2.botonimp.value = num;
}

function pasadatos2(num)
{ 
    f = document.conacr2Form;
    f.cimprimir.value = num; 
}

-->
  </script>
<%
//  PooledConnection pc = null;
//  Connection cn2 = null;
//  Statement st = null;
//  ResultSet rs = null;
//  conacr2Form consulform =(conacr2Form)request.getAttribute("conacr2Form");
  String entidad = "";
%>
<h2><span class="maintitle">CONSULTAS</span></h2>
<html:form action="/conacr2" styleId="frmreginf" styleClass="form" onsubmit="fEvalua( );">
  <fieldset>
		<legend class="maintitle2">Busqueda por persona acreditada</legend>
		<table width="100%" class=forumline cellSpacing=1 cellPadding=2 border=0  >
 <tr>
    <td class=cat colspan="3">Nombre de la persona</td>
  </tr>
  <tr>
        
<td class=row1 colspan="3"  >   
<html:text property="bacreditado" onblur="this.value = this.value.toUpperCase()" />
<html:submit property="boton" value="Buscar"/>  
        

    </td>
  </tr>
  

<%
  conexion dc = new conexion();
  Connection con = null;
  CallableStatement call = null;

  //String prm_encargado = "EARTEAGA";
 conacr2Form consulform =(conacr2Form)request.getAttribute("conacr2Form");
  try
  {
  if (consulform.getBacreditado() !=null)
  {
  if (!(consulform.getBacreditado().length()==0))
  {
    con = dc.abrirConexion();
    call = con.prepareCall( "{? = call pkg_acreditacion.lista_acreditados_por_busqueda ( ? ) }" );
    call.registerOutParameter( 1, OracleTypes.CURSOR );
    call.setString( 2, consulform.getBacreditado());
//call.setString( 2, "ED");


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
    <td class=cat width="96"  align="center" valign="middle" >Historial</td>
    <td class=cat width="381" align="center" valign="middle" >Entidad</td>    
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
if (rs.getString( 7 ).equals("2"))
{tipofil = "row5";
}
if (rs.getString( 7 ).equals("3"))
{tipofil = "row6";
}
          
%>
<TR >
<TD class=row2 ALIGN="center"  >
<input name="botonimg" type="image" src="Select.jpg" onclick="return pasadatos(<%=rs.getString( 1 ) %>)" /></TD>
<TD class='<%=tipofil%>' ALIGN="Left"  ><SPAN class=genmed><%=rs.getString( 6 ) %></SPAN></TD>
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

}

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



<html:hidden property="ccodigo" styleId="ccodigo" styleClass="ccodigo" />
<html:hidden property="cimprimir" styleId="cimprimir" styleClass="cimprimir" />

</html:form>
<%
conacr2Form consulform =(conacr2Form)request.getAttribute("conacr2Form");

if(consulform.getCcodigo() != null)
{

%>


<%
  conexion dc2 = new conexion();
  Connection con2 = null;
  CallableStatement call2 = null;
 
  try
  {
    con2 = dc2.abrirConexion();
    call2 = con2.prepareCall( "{? = call pkg_acreditacion.lista_log_acreditado2 ( ? ) }" );
    call2.registerOutParameter( 1, OracleTypes.CURSOR );
    call2.setString( 2, consulform.getCcodigo());
    call2.execute();

int c=0;
  ResultSet rs2 = ( ResultSet ) call2.getObject( 1 );
  if( ! ( rs2 == null || !rs2.next() ) )
  {

%>
<html:form action="/impacr2" target="_blank" styleId="frmreginf" styleClass="form">
<input name="botonimgfinal" type="image" src="Print.jpg" onclick="return()" />
<html:hidden property="botonimp" styleId="botonimp" styleClass="botonimp" value="<%=consulform.getCcodigo()%>"/>

</html:form>
  <fieldset>
		<legend class="maintitle2">Historial de Modificaciones</legend>  
<table width="100%" class=forumline cellSpacing=1 cellPadding=2 border=0  >
<tr>
    <td width="6%" align="center" valign="middle" class=cat ><SPAN class=gensmall>Cite</SPAN></td>
    <td width="7%" align="center" valign="middle" class=cat  ><SPAN class=gensmall>Fecha Cite</SPAN></td>
    <td width="8%" align="center" valign="middle" class=cat ><SPAN class=gensmall>Código</SPAN></td>
    <td width="23%" align="center" valign="middle" class=cat  ><SPAN class=gensmall>Nombre</SPAN></td>
    <td width="19%" align="center" valign="middle" class=cat  ><SPAN class=gensmall>Cargo</SPAN></td>
    <td width="6%" align="center" valign="middle" class=cat  ><SPAN class=gensmall>Categoría</SPAN></td>
    <td width="7%" align="center" valign="middle" class=cat ><SPAN class=gensmall>Fecha llegada</SPAN></td>
    <td width="7%" align="center" valign="middle" class=cat  ><SPAN class=gensmall>Fecha cese</SPAN></td>
    <td width="9%" align="center" valign="middle" class=cat  ><SPAN class=gensmall>Fecha Modificación</SPAN></td>    
    <td width="8%" align="center" valign="middle" class=cat  ><SPAN class=gensmall>Usuario</SPAN></td>
    <td width="8%" align="center" valign="middle" class=cat  ><SPAN class=gensmall>Observación</SPAN></td>
  </tr>
  <%

    do
    {
          
%>
<TR>

<TD class=row1 ALIGN="center"><SPAN class=gensmall><%=rs2.getString( 1 ) %></SPAN></TD>
<TD class=row1 ALIGN="center"><SPAN class=gensmall><%=rs2.getString( 2 ) %></SPAN></TD>
<TD class=row1 ALIGN="center"><SPAN class=gensmall><%=rs2.getString( 3 ) %></SPAN></TD>
<TD class=row1 ALIGN="Left"><SPAN class=gensmall><%=rs2.getString( 4 ) %></SPAN></TD>
<TD class=row1 ALIGN="Left"><SPAN class=gensmall><%=rs2.getString( 5 ) %></SPAN></TD>
<TD class=row1 ALIGN="center" ><SPAN class=gensmall><%=rs2.getString( 6 ) %></SPAN></TD>
<TD class=row1 ALIGN="center" ><SPAN class=gensmall><%=rs2.getString( 7 ) %></SPAN></TD>
<TD class=row1 ALIGN="center" ><SPAN class=gensmall><%=rs2.getString( 8 ) %></SPAN></TD>
<TD class=row1 ALIGN="center" ><SPAN class=gensmall><%=rs2.getString( 9 ) %></SPAN></TD>
<TD class=row1 ALIGN="center" ><SPAN class=gensmall><%=rs2.getString( 10 ) %></SPAN></TD>
<TD class=row1 ALIGN="center" ><SPAN class=gensmall><%=rs2.getString( 11 ) %></SPAN></TD>
</TR>

<%
    }while(rs2.next());   
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
      if (con2 != null) con2.close();
          
    }
    catch (SQLException er) 
    {
      ;
    }
  }
  }
%>

<div name="vresult" id="vresult" styleId="vresult">
</div>

