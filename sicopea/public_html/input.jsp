<%@ page contentType="text/html;charset=iso-8859-1" %>
<%@ page import="sicopea.*"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>


<link href="css/layout.css" rel="stylesheet" type="text/css" />
<link href="css/content.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="jscript/valida.js?v=2"></script>
<body OnLoad="NoAtras();">

<div class="CentraLL">
<h2>Sistema de control de Personas Acreditadas</h2>
	<html:form action="/ingreso" focus="usuario">
		<fieldset>
			<legend>Ingrese el usuario y clave</legend>
			<label>Usuario : </label><html:text property="usuario" maxlength="15" size="20" /><br/>
			<label>&nbsp;&nbsp;&nbsp;Clave : </label><html:password property="clave" maxlength="15" size="20" redisplay="false" /><br/>
			<div class="buttonlist">
				<html:submit property="" value="Ingresar" />
			</div>
		</fieldset>
	</html:form>
	<%
inputActionForm me = (inputActionForm)request.getAttribute("inputActionForm");
try
{
    if(!(me.getFmensaje()== null))
    {
        if(!(me.getFmensaje()==""))
        {
        %><center><%=me.getFmensaje()%></center><%
        }
    }
}
catch(Exception ex)
{
}
%>
</div>

 
</body>
