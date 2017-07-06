<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/sqltaglib.tld" prefix="database" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ page import="sicopea.*"%>
<%@ page import="java.sql.*, oracle.jdbc.driver.*, java.util.*, java.text.*"%>
<%@ page import="oracle.jdbc.OracleTypes"%>

<%@ page contentType="text/html;charset=iso-8859-1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%
        sicopea.conexion dc = new sicopea.conexion();
        impacrForm imp = (impacrForm)request.getAttribute("impacrForm");
        Connection con = null;
        CallableStatement call = null;
        String res = "";
        ResultSet rs;
        StringBuffer qbe = new StringBuffer();
        qbe.append(" select upper(en.des_ent) as des_ent, ac.cite, to_char(ac.fec_cite, 'DD/MM/YYYY') as fec_cite,  " );
        qbe.append(" upper(ac.nombre) as nombre, upper(ac.cargo) as cargo, decode(upper(ac.categoria),'1','PRIMERA','2','SEGUNDA','3','TERCERA','4','CUARTA','5','QUINTA','6','SEXTA','OTROS','OTROS','NINGUNA') as categoria, to_char(ac.fec_llegada, 'DD/MM/YYYY') as fec_llegada,  " );
        qbe.append(" to_char(ac.fec_cese, 'DD/MM/YYYY') as fec_cese, 'VRE/DGCEP-UPI-'||ac.key_nber||'/'||ac.key_year as codigo, to_char(sysdate,'dd/mm/yyyy HH24:mi')  " );
        qbe.append(" ,ac.doc_identificacion, ac.tipo_doc, ac.tipo_diplomatico, ac.proyecto ");
        qbe.append(" from acreditacion ac, entidad en  " );
        qbe.append(" where ac.cod_ent = en.cod_ent " );
        qbe.append(" and ac.cod_acred = "+ imp.getBotonimp() );
        qbe.append(" and ac.cod_ent = "+ imp.getBotonimp2() );
        qbe.append(" and ac.ver = 0  " );
        qbe.append(" and ac.lst_ope = 'U' " );
        qbe.append(" and en.ver = 0 " );
        qbe.append(" and en.lst_ope = 'U' ");
        
        try 
        {

            con = dc.abrirConexion();
            rs = dc.pQuery(con, qbe.toString());

            if(rs != null && rs.next())
            {
               
                
            do
            {
            String prueba;
            prueba = rs.getString(11);
            prueba = rs.getString(12);
            prueba = rs.getString(13);
            prueba = rs.getString(14);
            
                if(rs.getString(13)!=null && rs.getString(13).equals("Ley617") )
                {
                     %> <table border="0" style="font-family:Arial, Sans-Serif;
                                    font-size:10px;
                                    width:650px;
                                    text-align:left" >
                            <tr><td align="center" style="width:200px" rowspan="3">
                            <img src="jasper/escudo_bolivia2.jpg" width="100px" height="84px" /><br/>
                            <label style="font-size:9px;"><strong>ESTADO PLURINACIONAL DE BOLIVIA</strong></label><br/>
                            <label style="font-size:9px;"><strong>MINISTERIO DE RELACIONES EXTERIORES</strong></label></td>
                            <td style="width:200px" >&nbsp;</td>
                            <td style="width:200px"><label style="font-size:15px;"><strong>Nº Correlativo</strong><br/><strong><%=rs.getString(9)%></strong></label></td></tr>
                            <tr><td colspan="2">&nbsp;</td></tr>
                            <tr><td colspan="2">&nbsp;</td></tr>
                            <tr><td colspan="3">&nbsp;</td></tr>
                            <tr><td colspan="3"  align="center"><label style="font-size:18px;"><strong>COOPERANTE ACREDITADO (LEY 617)</strong></label></td></tr>
                            <tr><td colspan="3">&nbsp;</td></tr>
                            <tr><td colspan="3">
                            
                            <table cellspacing="0" border="0" style="font-family:Arial, Sans-Serif;
                                    font-size:13px;
                                    width:100%;
                                    text-align:left;
                                    border: 1px solid  Black;
                                    " >
                            <tr ><td colspan="2" style="font-size:15px;border: 1px solid  Black;padding:6px 6px;"><strong>Nombre de la Institución (misi&oacute;n Diplom&aacute;tica u otro)</strong>
                            </td></tr>
                            <tr><td colspan="2" style="border: 1px solid  Black;padding:6px 6px;"><%=rs.getString(1)%>
                            </td></tr>
                            <tr><td style="font-size:15px;border: 1px solid  Black;padding:6px 6px;"><strong>CITE Solicitud de Acreditación</strong>
                            </td><td style="font-size:15px;border: 1px solid  Black;padding:6px 6px;"><strong>Fecha CITE</strong>
                            </td></tr>
                            <tr><td style="border: 1px solid  Black;padding:6px 6px;"><%=rs.getString(2)%>
                            </td><td style="border: 1px solid  Black;padding:6px 6px;"><%=rs.getString(3)%>
                            </td></tr>
                            
                            <tr><td colspan="2" style="font-size:15px;border: 1px solid  Black;padding:6px 6px;"><strong>Nombre de la Persona Acreditada</strong>
                            </td></tr>
                            <tr><td colspan="2" style="border: 1px solid  Black;padding:6px 6px;"><%=rs.getString(4)%>
                            </td></tr>
                            <tr><td colspan="2" style="font-size:15px;border: 1px solid  Black;padding:6px 6px;"><strong>Cargo de la Persona Acreditada</strong>
                            </td></tr>
                            <tr><td colspan="2" style="border: 1px solid  Black;padding:6px 6px;"><%=rs.getString(5)%>
                            </td></tr>
                            <tr><td colspan="2" style="font-size:15px;border: 1px solid  Black;padding:6px 6px;"><strong>Nombre del Proyecto y/o Programa al que pertenece</strong>
                            </td></tr>
                            <tr><td colspan="2" style="border: 1px solid  Black;padding:6px 6px;"><%=rs.getString(14)%>
                            </td></tr>
                            <tr><td style="font-size:15px;border: 1px solid  Black;padding:6px 6px;"><strong>Fecha llegada al País</strong>
                            </td><td style="font-size:15px;border: 1px solid  Black;padding:6px 6px;"><strong>Fecha cese de funciones</strong>
                            </td></tr>
                            <tr><td style="border: 1px solid  Black;padding:6px 6px;"><%=rs.getString(7)%>
                            </td><td style="border: 1px solid  Black;padding:6px 6px;"><%=rs.getString(8)%>
                            
                            </td></tr>
                            
                            </table></td></tr>
                            <tr><td align="right" colspan="3"><label style="font-size:13px;"><strong>Fecha impresión del reporte: </strong><%=rs.getString(10)%></label>
                            </td></tr>
                                <%
                                if(util.devuelve_estado_re(imp.getBotonimp()).equals("aduana")){
                                %>
                                <tr>
                                    <td align="right" colspan="3">
                                        <label style="font-size:13px;">(Datos recuperados del Ministerio de Relaciones Exteriores)</label>
                                    </td>
                                </tr>
                                <% 
                                }
                                %>
                            
                            </table>  <%
                    
                }
                else
                if(rs.getString(8)!=null)
                {
                 %> <table border="0" style="font-family:Arial, Sans-Serif;
	font-size:10px;
	width:650px;
	text-align:left" >
<tr><td align="center" style="width:200px" rowspan="3">
<img src="jasper/escudo_bolivia2.jpg" width="100px" height="84px" /><br/>
<label style="font-size:9px;"><strong>ESTADO PLURINACIONAL DE BOLIVIA</strong></label><br/>
<label style="font-size:9px;"><strong>MINISTERIO DE RELACIONES EXTERIORES</strong></label></td>
<td style="width:200px" >&nbsp;</td>
<td style="width:200px"><label style="font-size:15px;"><strong>Nº Correlativo</strong><br/><strong><%=rs.getString(9)%></strong></label></td></tr>
<tr><td colspan="2">&nbsp;</td></tr>
<tr><td colspan="2">&nbsp;</td></tr>
<tr><td colspan="3">&nbsp;</td></tr>
<tr><td colspan="3"  align="center"><label style="font-size:18px;"><strong>ACREDITACION DEL FUNCIONARIO</strong></label></td></tr>
<tr><td colspan="3">&nbsp;</td></tr>
<tr><td colspan="3">

<table cellspacing="0" border="0" style="font-family:Arial, Sans-Serif;
	font-size:13px;
	width:100%;
	text-align:left;
        border: 1px solid  Black;
        " >
<tr ><td colspan="2" style="font-size:15px;border: 1px solid  Black;padding:6px 6px;"><strong>Nombre de la Institución (misi&oacute;n Diplom&aacute;tica u otro)</strong>
</td></tr>
<tr><td colspan="2" style="border: 1px solid  Black;padding:6px 6px;"><%=rs.getString(1)%>
</td></tr>
<tr><td style="font-size:15px;border: 1px solid  Black;padding:6px 6px;"><strong>CITE Solicitud de Acreditación</strong>
</td><td style="font-size:15px;border: 1px solid  Black;padding:6px 6px;"><strong>Fecha CITE</strong>
</td></tr>
<tr><td style="border: 1px solid  Black;padding:6px 6px;"><%=rs.getString(2)%>
</td><td style="border: 1px solid  Black;padding:6px 6px;"><%=rs.getString(3)%>
</td></tr>

<tr><td colspan="2" style="font-size:15px;border: 1px solid  Black;padding:6px 6px;"><strong>Nombre de la Persona Acreditada</strong>
</td></tr>
<tr><td colspan="2" style="border: 1px solid  Black;padding:6px 6px;"><%=rs.getString(4)%>
</td></tr>
<tr><td colspan="2" style="font-size:15px;border: 1px solid  Black;padding:6px 6px;"><strong>Cargo de la Persona Acreditada</strong>
</td></tr>
<tr><td colspan="2" style="border: 1px solid  Black;padding:6px 6px;"><%=rs.getString(5)%>
</td></tr>
<tr><td colspan="2" style="font-size:15px;border: 1px solid  Black;padding:6px 6px;"><strong>Categor&iacute;a</strong>
</td></tr>
<tr><td colspan="2" style="border: 1px solid  Black;padding:6px 6px;"><%=rs.getString(6)%>
</td></tr>
<tr><td style="font-size:15px;border: 1px solid  Black;padding:6px 6px;"><strong>Fecha llegada al País</strong>
</td><td style="font-size:15px;border: 1px solid  Black;padding:6px 6px;"><strong>Fecha cese de funciones</strong>
</td></tr>
<tr><td style="border: 1px solid  Black;padding:6px 6px;"><%=rs.getString(7)%>
</td><td style="border: 1px solid  Black;padding:6px 6px;"><%=rs.getString(8)%>

</td></tr>

</table></td></tr>
<tr><td align="right" colspan="3"><label style="font-size:13px;"><strong>Fecha impresión del reporte: </strong><%=rs.getString(10)%></label>
</td></tr>
    <%
    if(util.devuelve_estado_re(imp.getBotonimp()).equals("aduana")){
    %>
    <tr>
        <td align="right" colspan="3">
            <label style="font-size:13px;">(Datos recuperados del Ministerio de Relaciones Exteriores)</label>
        </td>
    </tr>
    <% 
    }
    %>

</table>  <%
                }
                else
                {
                  %> <table border="0" style="font-family:Arial, Sans-Serif;
	font-size:10px;
	width:650px;
	text-align:left" >
<tr><td align="center" style="width:200px" rowspan="3">
<img src="jasper/escudo_bolivia2.jpg" width="100px" height="84px" /><br/>
<label style="font-size:9px;"><strong>ESTADO PLURINACIONAL DE BOLIVIA</strong></label><br/>
<label style="font-size:9px;"><strong>MINISTERIO DE RELACIONES EXTERIORES</strong></label></td>
<td style="width:200px" >&nbsp;</td>
<td style="width:200px"><label style="font-size:15px;"><strong>Nº Correlativo</strong><br/><strong><%=rs.getString(9)%></strong></label></td></tr>
<tr><td colspan="2">&nbsp;</td></tr>
<tr><td colspan="2">&nbsp;</td></tr>
<tr><td colspan="3">&nbsp;</td></tr>
<tr><td colspan="3"  align="center"><label style="font-size:18px;"><strong>FUNCIONARIO REPATRIADO</strong></label></td></tr>
<tr><td colspan="3">&nbsp;</td></tr>
<tr><td colspan="3">

<table cellspacing="0" border="0" style="font-family:Arial, Sans-Serif;
	font-size:13px;
	width:100%;
	text-align:left;
        border: 1px solid  Black;
        " >
<tr ><td colspan="2" style="font-size:15px;border: 1px solid  Black;padding:6px 6px;"><strong>Nombre de la Institución (misi&oacute;n Diplom&aacute;tica u otro)</strong>
</td></tr>
<tr><td colspan="2" style="border: 1px solid  Black;padding:6px 6px;"><%=rs.getString(1)%>
</td></tr>
<tr><td style="font-size:15px;border: 1px solid  Black;padding:6px 6px;"><strong>CITE Solicitud</strong>
</td><td style="font-size:15px;border: 1px solid  Black;padding:6px 6px;"><strong>Fecha CITE</strong>
</td></tr>
<tr><td style="border: 1px solid  Black;padding:6px 6px;"><%=rs.getString(2)%>
</td><td style="border: 1px solid  Black;padding:6px 6px;"><%=rs.getString(3)%>
</td></tr>

<tr><td colspan="2" style="font-size:15px;border: 1px solid  Black;padding:6px 6px;"><strong>Nombre de la Persona</strong>
</td></tr>
<tr><td colspan="2" style="border: 1px solid  Black;padding:6px 6px;"><%=rs.getString(4)%>
</td></tr>
<tr><td colspan="2" style="font-size:15px;border: 1px solid  Black;padding:6px 6px;"><strong>Cargo de la Persona</strong>
</td></tr>
<tr><td colspan="2" style="border: 1px solid  Black;padding:6px 6px;"><%=rs.getString(5)%>
</td></tr>
<tr><td colspan="2" style="font-size:15px;border: 1px solid  Black;padding:6px 6px;"><strong>Categor&iacute;a</strong>
</td></tr>
<tr><td colspan="2" style="border: 1px solid  Black;padding:6px 6px;"><%=rs.getString(6)%>
</td></tr>
<tr><td colspan="2" style="font-size:15px;border: 1px solid  Black;padding:6px 6px;"><strong>Fecha llegada al País</strong>
</td></tr>
<tr><td colspan="2" style="border: 1px solid  Black;padding:6px 6px;"><%=rs.getString(7)%>
</td></tr>

</table></td></tr>
<tr><td align="right" colspan="3"><label style="font-size:13px;"><strong>Fecha impresión del reporte: </strong><%=rs.getString(10)%></label>
</td></tr>
    <%
    if(util.devuelve_estado_re(imp.getBotonimp()).equals("aduana")){
    %>
    <tr>
        <td align="right" colspan="3">
            <label style="font-size:13px;">(Datos recuperados del Ministerio de Relaciones Exteriores)</label>
        </td>
    </tr>
    <% 
    }
    %>

</table>  <%   
                }   
                
            } while(rs.next());
           
            }
                
            
        }    
        catch (Exception er) {
            res = er.toString();
        } finally {
            try {
                if (con != null)
                    con.close();

            } catch (SQLException er) {
                ;
            }
        }
        

%>



