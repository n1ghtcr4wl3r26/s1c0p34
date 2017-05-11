<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>




<DIV class=poster>
<DIV class=escudo><FONT color=#ffffff><font color=#ffffff><img src="escudobo.jpg"  /></font></FONT></DIV>
<div class=titulo2><font color=#ffffff size=+1>SISTEMA DE CONTROL DE PERSONAS 
  ACREDITADAS</font><br>
 <font color=#ffffff size=1>Ministerio de Relaciones Exteriores</font> </div>
</DIV>

<%
String nombre = (String)request.getSession().getAttribute("nombre");
String perfil = (String)request.getSession().getAttribute("user.perfil");

%>


<logic:present name="user.nick" scope="session" >
<div id="userdata">
	<table>
		<col />
		<col align="right" />
		<tr>
			<td>
				[<html:link forward="ser.home">Inicio</html:link>]&nbsp;<span style="color:#F00">[<html:link forward="exit.home"><b>Salir</b></html:link>]</span>&nbsp;&nbsp;
			</td>
			<td>
				<strong>Usuario:</strong> <%=nombre%>
			</td>
                        <td>
				<strong>Rol:</strong> <%=perfil%>
			</td>
                         <td width="60%">
				&nbsp;
			</td>
                        
		</tr>
	</table>
</div>	
</logic:present>
