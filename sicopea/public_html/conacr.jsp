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
    f = document.conacrForm;
    f2 = document.impacrForm;
    f.ccodigo.value = num;
    f2.botonimp.value = num;
}
function pasadatos2(num)
{ 
    f = document.conacrForm;
    f.cimprimir.value = num; 
}

-->

  </script>


<%

  String entidad = "";
%>
<h2><span class="maintitle">CONSULTAS</span></h2>
<html:form action="/conacr" styleId="frmreginf" styleClass="form">
  <fieldset>
		<legend class="maintitle2">Institución</legend>
		<table width="100%" class=forumline cellSpacing=1 cellPadding=2 border=0  >
 <tr>
    <td class=cat colspan="3">Nombre de la Institución (misión Diplomática u otro)</td>
  </tr>
  <tr>
        
          <%
String usuario = request.getSession().getAttribute("user.nick").toString();
String perfil = request.getSession().getAttribute("user.perfil").toString(); 
 
String ssentidad = request.getSession().getAttribute("user.codent").toString();
if(ssentidad == null)
{
ssentidad  = "-";
}

String snentidad = util.devuelve_nombre_entidad2(ssentidad);


if (perfil.equals("ADMINISTRADOR") || perfil.equals("ADUANA"))
{
  %>
        <td class=cat colspan="2"  >      
            Institución:<html:select property="centidad" styleId="centidad" onchange="this.form.submit()" >
            <% 
            conacrForm con = (conacrForm)request.getAttribute("conacrForm");
            
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
 conacrForm consulform =(conacrForm)request.getAttribute("conacrForm");
  try
  {
    con = dc.abrirConexion();
    
 
    //depende del perfil direcciona directamente la variable de la entidad

if (perfil.equals("ADMINISTRADOR") || perfil.equals("ADUANA"))
{
entidad = consulform.getCentidad();
}
else
{
entidad = ssentidad;
}

    if(consulform.getCtipolist() == null)
    {
     call = con.prepareCall( "{? = call pkg_acreditacion.lista_acreditados_por_entidad2 ( ? ) }" );
    
    }
    else
    {
        if(consulform.getCtipolist().equals("1"))
        {
        call = con.prepareCall( "{? = call pkg_acreditacion.lista_acreditados_por_entidad2 ( ? ) }" );
        }
        if(consulform.getCtipolist().equals("2"))
        {
        call = con.prepareCall( "{? = call pkg_acreditacion.lista_acreditados_por_entidad ( ? ) }" );
        }
        if(consulform.getCtipolist().equals("3"))
        {
        call = con.prepareCall( "{? = call pkg_acreditacion.lista_acreditados_por_entidad3 ( ? ) }" );
        }
    }
    
    call.registerOutParameter( 1, OracleTypes.CURSOR );
    call.setString( 2, entidad);
    call.execute();
%>
</table>
 </fieldset>

 
  <%
int c=0;
  ResultSet rs=(ResultSet) call.getObject(1);
  if( ! ( rs == null || !rs.next() ) )
  {

  %>
<fieldset>
		<legend class="maintitle2">Listado de personas Acreditadas</legend>
<table width="100%" class=forumline cellSpacing=1 cellPadding=2 border=0  >
<tr>
    <td class=cat width="96"  align="center" valign="middle" >Historial</td>
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
<TD class=row2 ALIGN="center"  >
<input name="botonimg" type="image" src="Select.jpg" onclick="return pasadatos(<%=rs.getString( 1 ) %>)" /></TD>
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
  catch(Exception er) 
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
conacrForm consulform =(conacrForm)request.getAttribute("conacrForm");

%>



<%
  conexion dc2 = new conexion();
  Connection con2 = null;
  CallableStatement call2 = null;
 
  try
  {
    con2 = dc2.abrirConexion();
    call2=con2.prepareCall("{ ? = call pkg_acreditacion.lista_log_acreditado ( ?, ? ) }");
    call2.registerOutParameter( 1, OracleTypes.CURSOR );
    call2.setString( 2, consulform.getCcodigo());
    call2.setString( 3, entidad);
    call2.execute(); 
    
    ResultSet rs2=(ResultSet) call2.getObject(1);
  
  int c=0;
 
  if( ! ( rs2 == null || !rs2.next() ) )
  {

%>
<html:form action="/impacr" target="_blank" styleId="frmreginf" styleClass="form">
<input name="botonimgfinal" type="image" src="Print.jpg" onclick="return()" />
<html:hidden property="botonimp" value="<%=consulform.getCcodigo()%>"/>
<html:hidden property="botonimp2" value="<%=entidad%>" />
</html:form>
  <fieldset>
		<legend class="maintitle2">Historial de Modificaciones</legend>  
<table width="100%" class=forumline cellSpacing=1 cellPadding=2 border=0  >
<tr>
    <td width="6%" align="center" valign="middle" class=cat ><SPAN class=gensmall>Cite</SPAN></td>
    <td width="7%" align="center" valign="middle" class=cat  ><SPAN class=gensmall>Fecha Cite</SPAN></td>
    <td width="8%" align="center" valign="middle" class=cat ><SPAN class=gensmall>Código</SPAN></td>
    <td width="19%" align="center" valign="middle" class=cat  ><SPAN class=gensmall>Nombre</SPAN></td>
    <td width="15%" align="center" valign="middle" class=cat  ><SPAN class=gensmall>Cargo</SPAN></td>
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
%>

<div name="vresult" id="vresult" styleId="vresult">
</div>

