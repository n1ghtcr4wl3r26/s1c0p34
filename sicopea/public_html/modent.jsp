<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/sqltaglib.tld" prefix="database" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ page import="sicopea.*"%>
<%@ page import="java.sql.*, oracle.jdbc.driver.*, java.util.*, java.text.*"%>
<%@ page import="oracle.jdbc.OracleTypes"%>

<%@ page contentType="text/html;charset=iso-8859-1"%>

<%@ page import="sicopea.util"%>
<html>
<head>
<title>
Sistema de Control de Personas Acreditadas
</title>

<link href="css/layout.css" rel="stylesheet" type="text/css" />
  <link href="css/content.css" rel="stylesheet" type="text/css" />
  <link href="css/fisubice.css" type=text/css rel=stylesheet />
  
<script language="JavaScript" type="text/JavaScript" src="jscript/veliment.js"></script>
  <script language="JavaScript" type="text/javascript">
function fUpper( texto )
{
  return( texto.toUpperCase() );
}
function Trim ( texto )
{
  if (texto.length) 
  {
    while( '' + texto.charAt(0) == " " )
    {
      texto = texto.substring( 1, texto.length);
    }
  }
  return texto;
}
function fTrim( texto )
{
  aux = Trim( texto );
  if( aux == "" ) 
    return false;
  else
    return true;
}  
function pasadatosedit(num)
{ f = document.modentForm;
  f.cdelete.value = ""; 
  f.edit.value = num;  
}
function pasadatoscan(num)
{ f = document.modentForm;
  f.cdelete.value = ""; 
  f.update.value = ""; 
  f.edit.value = "";
  f.ccancel.value = num;  
}
function pasadatosupd(num)
{ var Mensaje = "";
  f = document.modentForm;
  f.update.value = num;  
  f.cdelete.value = ""; 
  f.ccancel.value = "";
  f.des_ent.value = fUpper( f.des_ent.value );
  f.dir_ent.value = fUpper( f.dir_ent.value );
  if( ! fTrim( f.des_ent.value ) )
    Mensaje = Mensaje + 'Debe introducir un nombre de Entidad\n';
  if( ! (f.tipo.value == "EMB" || f.tipo.value == "INS") )
    Mensaje = Mensaje + 'Debe especificar el tipo de entidad, Embajada (EMB) o Institución (INS)\n';
  if( Mensaje == "" )
  {
  }
  else
  {
    f.update.value = "";
    alert( Mensaje );
    return false;
  }
  
}
function pasadatosdel(num)
{ 
  f = document.modentForm;
  f.update.value = ""; 
  f.ccancel.value = "";
  f.cdelete.value = num;  
  return confirm("Esta seguro de eliminar a esta Entidad.");
}
</script>
</head>
<body>
<html:form action="/modent" >


<html:hidden property="ccancel" />
<html:hidden property="cdelete" />
<html:hidden property="edit" />
<html:hidden property="update" />
<h2>
Formulario de modificación de Entidades: 
</h2>

<%
util fun = new util();
modentForm ment= (modentForm)request.getAttribute("modentForm");
String tbl = fun.dibujar_tabla(ment);
if (ment.getMsg() != null)
{
%>
<div style="margin-bottom:4px; background-color: #9DD5EE; border-width: 12; width: 300px; font-family: Verdana, Geneva, sans-serif; color: #003; text-align: center; height: 30px; vertical-align: middle;">
<%=ment.getMsg()%>
</div>
<%
}
%>

<%=tbl%></html:form>
</body>
</html>
