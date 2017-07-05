<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/sqltaglib.tld" prefix="database" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ page import="sicopea.*"%>
<%@ page import="java.sql.*, oracle.jdbc.driver.*, java.util.*, java.text.*"%>
<%@ page import="oracle.jdbc.OracleTypes"%>
<%@ page contentType="text/html;charset=iso-8859-1"%>
<script language="JavaScript" type="text/JavaScript" src="jscript/valida.js?v=2"></script>
<script language="JavaScript" type="text/JavaScript" src="jscript/vregistroent2.js?v=2"></script>
<link href="fisubice.css" type=text/css rel=stylesheet />
<%
    reginf2Form rinf = (reginf2Form)request.getAttribute("reginf2Form");
    String usuario = request.getSession().getAttribute("user.nick").toString();
    String perfil = request.getSession().getAttribute("user.perfil").toString(); 
    String ssentidad = util.devuelve_entidad(usuario,perfil);
    String snentidad = util.devuelve_nombre_entidad(usuario,perfil);
%>
<html:errors />    
<html:form action="/reginf2" styleId="frmreginf" styleClass="form" onsubmit="return fEvalua( );">
    <h2>
        <span class="maintitle">REGISTRO REPATRIADOS</span>
    </h2>
    <html:hidden property="vcodigo" value="100" />
    <html:hidden property="vtipodiplomatico" styleId="vtipodiplomatico"/>
    <html:hidden property="vproyecto" styleId="vproyecto"/>
    <fieldset>
	<legend class="maintitle2">Formulario de Registro de Repatriados</legend>
            <%
            reginf2Form rif = (reginf2Form)request.getAttribute("reginf2Form");
            try
            {
                if (!(rif.getResp()==null))
                {   %>
                    <div style="margin-bottom:4px; background-color: #9DD5EE; border-width: 12px; width: 300px; font-family: Verdana, Geneva, sans-serif; color: #003; text-align: center; height: 30px; vertical-align: middle;">
                        <%=rif.getResp()%>
                    </div>
                    <%
                }
            }catch(Exception er){
            }%>
	<table width="450" class=forumline cellSpacing=1 cellPadding=2 border=0  >
            <tr>
                <td class=row2 colspan="3">Nombre de la Institución (misión Diplomática u otro)</td>
            </tr>
            <tr>
                <%
                if (perfil.equals("ADMINISTRADOR")){
                    %>
                    <td class=cat colspan="3"  >      
                    Institución: 
                    <html:select property="ventidad" styleId="centidad" >
                    <% 
                    reginf2Form con = (reginf2Form)request.getAttribute("reginf2Form");
                    if(con.getVentidad() == null)
                    {
                        %>
                        <%=util.devuelve_entidades2("0")%>
                        <%
                    }
                    else
                    {
                        %>
                        <%=util.devuelve_entidades2(con.getVentidad())%>
                        <%
                    }
                    %>
                    </html:select> 
                <%
                }       
                %>
                    </td>
            </tr>
            <tr>
                <td class=row2 colspan="2">CITE Solicitud</td>
                <td class=row2 ALIGN="center" >Fecha de CITE</td>
            </tr>
            <tr>
                <td class=row1 colspan="2">
                    <html:text property="vcite" size="30" styleId="vcite" />
                </td>
                <td class=row1 >
                    <html:text property="vfeccite" size="10" styleId="vfeccite" />
                </td>
            </tr>
            <tr>
                <td class=row2 colspan="3">Nombre de la Persona</td>
            </tr>
            <tr>
                <td colspan="3" >
                    <html:text property="vnombre" size="50" styleId="vnombre" onblur="this.value = this.value.toUpperCase()"/>
                </td>
            </tr>
            <tr>
                <td class=row2 colspan="3">Cargo de la Persona</td>
            </tr>
            <tr>
                <td colspan="3" >
                    <html:textarea property="vcargo" style="width:400px; height:40px; font-family: Arial, Helvetica, sans-serif; font-size: 10px;" styleId="vcargo" onblur="this.value = this.value.toUpperCase()" />
                </td>
            </tr>          
            <tr>
                <td class=row2 colspan="3" >Categoría</td>
            </tr>
            <tr>
                <td class=row1  colspan="3" > 
                    <html:select property="vcategoria" styleId="vcategoria">
                        <html:option value="5">Categoría 5</html:option>         
                    </html:select> 
                </td>
            </tr>
            <tr>
                <td class=row2 ALIGN="center" >Fecha de llegada al País</td>
                <td class=row2 ALIGN="center" colspan="2" ></td>
          
            </tr>
            <tr>
                <td class=row1  ALIGN="center" >
                    <html:text property="vfecllegada" size="10" styleId="vfecllegada"/>
                </td>
                <td class=row1  ALIGN="center" colspan="2"  ></td>
            </tr>
            <tr>
                <td class=row1  colspan="3">&nbsp;</td>
            </tr>
            <tr>
                <td class=row2 ALIGN="center" colspan="3"   >
                    <div class="buttonlist">
                        <html:submit property="boton" value="Grabar"/>
                    </div>
                </td>
            </tr>
        </table>
    </fieldset>
</html:form>
<script>
    $(document).ready(function () {
        $('#centidad').change(function () {
            if ($('#centidad').val()=="253") {
                $("#vcategoria").find("option[value='5']").remove();
                $('#vcategoria').append('<option value="" selected="selected">-- Seleccione una Categoría --</option>'); 
                $('#vcategoria').append('<option value="1">Categoría 1</option>');
                $('#vcategoria').append('<option value="2">Categoría 2</option>');
                $('#vcategoria').append('<option value="3">Categoría 3</option>');
                $('#vcategoria').append('<option value="4">Categoría 4</option>');
                $('#vcategoria').append('<option value="5">Categoría 5</option>');
                $('#vcategoria').append('<option value="6">Categoría 6</option>');
                $('#vcategoria').append('<option value="Otros">Otros</option>');
                $('#vcategoria').append('<option value="Ninguna">Ninguna</option>');
            } else {
                $("#vcategoria").find("option[value='']").remove();
                $("#vcategoria").find("option[value='1']").remove();
                $("#vcategoria").find("option[value='2']").remove();
                $("#vcategoria").find("option[value='3']").remove();
                $("#vcategoria").find("option[value='4']").remove();
                $("#vcategoria").find("option[value='5']").remove();
                $("#vcategoria").find("option[value='6']").remove();
                $("#vcategoria").find("option[value='Otros']").remove();
                $("#vcategoria").find("option[value='Ninguna']").remove();
                $('#vcategoria').append('<option value="5" selected="selected">Categoría 5</option>');
            }
        });
    });
</script>
    