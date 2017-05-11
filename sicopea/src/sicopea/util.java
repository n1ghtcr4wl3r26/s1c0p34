package sicopea;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;


public class util
{

    public util()
    {
    }
    
    public static String devuelve_entidades(String ent)
    {
        sicopea.conexion dc = new sicopea.conexion();
        Connection con = null;
        CallableStatement call = null;
        String res = "";
        ResultSet rs;
        StringBuffer qbe = new StringBuffer();
        qbe.append(" select e.cod_ent, e.des_ent from entidad e ");
        qbe.append(" where e.lst_ope = 'U' and e.ver = 0 and e.cod_sector = '104' " );
        qbe.append(" order by e.des_ent");


        try {

            con = dc.abrirConexion();
            rs = dc.pQuery(con, qbe.toString());

            if(rs != null && rs.next())
            {
                res = "<option value='0'>----Seleccione una entidad----</option>";
                
            do
            {
                if(ent.equals(rs.getString(1)))
                {
                    res = res + "<option selected value=" +rs.getString(1) +">"+rs.getString(2)+"</option>";
                }
                else
                {
                res = res + "<option value=" +rs.getString(1) +">"+rs.getString(2)+"</option>";
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
        return res;
    
    }

    public static String devuelve_entidades()
    {
        sicopea.conexion dc = new sicopea.conexion();
        Connection con = null;
        CallableStatement call = null;
        String res = "";

        try {

            con = dc.abrirConexion();
            call = con.prepareCall("{ ? = call pkg_acreditacion.lista_entidad (?) }");
            call.registerOutParameter(1, -10);
            call.setString(2, "vacio");
            call.execute();
            
            ResultSet rs = (ResultSet)call.getObject(1);
            if(rs != null && rs.next())
            {
                res = "<option value='0'>----Seleccione una entidad----</option>";
                
            do
            {
                res = res + "<option value=" +rs.getString(1) +">"+rs.getString(2)+"</option>";
                    
                
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
        return res;
    
    }

    public static String devuelve_entidades2(String ent)
    {
        sicopea.conexion dc = new sicopea.conexion();
        Connection con = null;
        CallableStatement call = null;
        String res = "";
        ResultSet rs;
        StringBuffer qbe = new StringBuffer();
        qbe.append(" select e.cod_ent, e.des_ent from entidad e ");
        qbe.append(" where e.lst_ope = 'U' and e.ver = 0 and e.cod_sector = '104' " );
        qbe.append(" and e.cod_ent in ('259','253') order by e.des_ent");


        try {

            con = dc.abrirConexion();
            rs = dc.pQuery(con, qbe.toString());

            if(rs != null && rs.next())
            {
                res = "<option value='0'>----Seleccione una entidad----</option>";
                
            do
            {
                if(ent.equals(rs.getString(1)))
                {
                    res = res + "<option selected value=" +rs.getString(1) +">"+rs.getString(2)+"</option>";
                }
                else
                {
                res = res + "<option value=" +rs.getString(1) +">"+rs.getString(2)+"</option>";
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
        return res;
    
    }

    public static String devuelve_entidades2()
    {
        sicopea.conexion dc = new sicopea.conexion();
        Connection con = null;
        CallableStatement call = null;
        String res = "";
        ResultSet rs;
        StringBuffer qbe = new StringBuffer();
        qbe.append(" select e.cod_ent, e.des_ent from entidad e ");
        qbe.append(" where e.lst_ope = 'U' and e.ver = 0 and e.cod_sector = '104' " );
        qbe.append(" and e.cod_ent in ('259','253') order by e.des_ent");


        try {

            con = dc.abrirConexion();
            rs = dc.pQuery(con, qbe.toString());
            
            if(rs != null && rs.next())
            {
                res = "<option value='0'>----Seleccione una entidad----</option>";
                
            do
            {
                res = res + "<option value=" +rs.getString(1) +">"+rs.getString(2)+"</option>";
                    
                
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
        return res;
    
    }

    public static String devuelve_entidad(String usuario, String perfil)
    {
        sicopea.conexion dc = new sicopea.conexion();
        Connection con = null;
        CallableStatement call = null;
        String res = "0";
        try
        {
            con = dc.abrirConexion();
            call = con.prepareCall("{ ? = call pkg_acreditacion.devuelve_entidad ( ? ) }");
            call.registerOutParameter(1, 12);
            call.setString(2, usuario);
            call.execute();
            res = (String)call.getObject(1);
        }
        catch(Exception er)
        {
            er.printStackTrace();
        }
        finally {
                    try {
                        if (con != null)
                            con.close();

                    } catch (SQLException er) {
                        ;
                    }
                }
        return res;
    }

    public static String devuelve_nombre_entidad(String usuario, String perfil)
    {
        sicopea.conexion dc = new sicopea.conexion();
        Connection con = null;
        CallableStatement call = null;
        String res = " ";
        try
        {
            con = dc.abrirConexion();
            call = con.prepareCall("{ ? = call pkg_acreditacion.devuelve_nombre_entidad ( ? ) }");
            call.registerOutParameter(1, 12);
            call.setString(2, usuario);
            call.execute();
            res = (String)call.getObject(1);
        }
        catch(Exception er)
        {
            er.printStackTrace();
        }
        finally {
                    try {
                        if (con != null)
                            con.close();

                    } catch (SQLException er) {
                        ;
                    }
                }
        return res;
    }

    public static String devuelve_nombre_entidad2(String codent)
    {
        sicopea.conexion dc = new sicopea.conexion();
        Connection con = null;
        CallableStatement call = null;
        String res = " ";
        try
        {
            con = dc.abrirConexion();
            call = con.prepareCall("{ ? = call pkg_acreditacion.devuelve_nombre_entidad2 ( ? ) }");
            call.registerOutParameter(1, 12);
            call.setString(2, codent);
            call.execute();
            res = (String)call.getObject(1);
        }
        catch(Exception er)
        {
            er.printStackTrace();
        }
        finally {
                    try {
                        if (con != null)
                            con.close();

                    } catch (SQLException er) {
                        ;
                    }
                }
        return res;
    }

    public static String dibujar_tabla(modentForm ment)
    {
        sicopea.conexion dc = new sicopea.conexion();
        Connection con = null;
        CallableStatement call = null;
        String dib = " <table><tr><td class=cat align='center' valign='middle' >Mod/Edit</td><td class=cat align='center' valign='middle' >Codigo</td><td class=cat align='center' valign='middle' >Nombre</td><td class=cat align='center' valign='middle' >Direccion</td><td class=cat align='center' valign='middle' >Telefono</td><td class=cat align='center' valign='middle' >Fax</td><td class=cat align='center' valign='middle' >Email</td><td class=cat align='center' valign='middle' >Tipo</td></tr>";
        try
        {
            con = dc.abrirConexion();
            call = con.prepareCall("{ ? = call pkg_acreditacion.lista_entidades ( ? ) }");
            call.registerOutParameter(1, -10);
            call.setString(2, "nada");
            call.execute();
            ResultSet rs = (ResultSet)call.getObject(1);
            if(rs != null && rs.next())
            {
                dib = dib + " <tr>";
                if(ment == null)
                    do
                    {
                        dib = dib + "<TR ><TD class=row2 ALIGN='center' >";
                        dib = dib + "<input name='botonimg' type='image' src='Edit.jpg' onclick='return pasadatosedit(" + rs.getString(1) + ")' />";
                        dib = dib + "<input name='botonimg' type='image' src='Delete.jpg' onclick='return pasadatosdel(" + rs.getString(1) + ")' /></TD>";
                        dib = dib + "<TD class=row1 ALIGN='center'  ><SPAN class=genmed>" + rs.getString(1) + "</SPAN></TD>";
                        dib = dib + "<TD class=row1 ALIGN='Left'  ><SPAN class=genmed>" + rs.getString(2) + "</SPAN></TD>";
                        dib = dib + "<TD class=row1 ALIGN='Left'  ><SPAN class=genmed>" + rs.getString(3) + "</SPAN></TD>";
                        dib = dib + "<TD class=row1 ALIGN='center'  ><SPAN class=genmed>" + rs.getString(4) + "</SPAN></TD>";
                        dib = dib + "<TD class=row1 ALIGN='center'  ><SPAN class=genmed>" + rs.getString(5) + "</SPAN></TD>";
                        dib = dib + "<TD class=row1 ALIGN='center'  ><SPAN class=genmed>" + rs.getString(6) + "</SPAN></TD>";
                        dib = dib + "<TD class=row1 ALIGN='center'  ><SPAN class=genmed>" + rs.getString(7) + "</SPAN></TD>";
                        dib = dib + "</TR>";
                    } while(rs.next());
                else
                    do
                        if(rs.getString(1).equals(ment.getEdit()))
                        {
                            dib = dib + "<TR ><TD class=row3 ALIGN='center' >";
                            dib = dib + "<input name='botonimg' type='image' src='Update.jpg' onclick='return pasadatosupd(" + rs.getString(1) + ")' />";
                            dib = dib + "<input name='botonimg' type='image' src='Cancel.jpg' onclick='return pasadatoscan(" + rs.getString(1) + ")' /></TD>";
                            dib = dib + "<TD class=row2 ALIGN='center'  ><SPAN class=genmed>" + rs.getString(1) + "</SPAN></TD>";
                            dib = dib + "<TD class=row2 ALIGN='Left'  ><input type='text' name='des_ent' id='des_ent' value='" + rs.getString(2) + "'/></TD>";
                            dib = dib + "<TD class=row2 ALIGN='Left'  ><input type='text' name='dir_ent' id='dir_ent' value='" + rs.getString(3) + "'/></TD>";
                            dib = dib + "<TD class=row2 ALIGN='center'  ><input type='text' name='tel_ent' id='tel_ent' value='" + rs.getString(4) + "'/></TD>";
                            dib = dib + "<TD class=row2 ALIGN='center'  ><input type='text' name='fax_ent' id='fax_ent' value='" + rs.getString(5) + "'/></TD>";
                            dib = dib + "<TD class=row2 ALIGN='center'  ><input type='text' name='email_ent' id='email_ent' value='" + rs.getString(6) + "'/></TD>";
                            dib = dib + "<TD class=row2 ALIGN='center'  ><input type='text' name='tipo' id='tipo' value='" + rs.getString(7) + "'/></TD>";
                            dib = dib + "</TR>";
                        } else
                        {
                            dib = dib + "<TR ><TD class=row2 ALIGN='center' >";
                            dib = dib + "<input name='botonimg' type='image' src='Edit.jpg' onclick='return pasadatosedit(" + rs.getString(1) + ")' />";
                            dib = dib + "<input name='botonimg' type='image' src='Delete.jpg' onclick='return pasadatosdel(" + rs.getString(1) + ")' /></TD>";
                            dib = dib + "<TD class=row1 ALIGN='center'  ><SPAN class=genmed>" + rs.getString(1) + "</SPAN></TD>";
                            dib = dib + "<TD class=row1 ALIGN='Left'  ><SPAN class=genmed>" + rs.getString(2) + "</SPAN></TD>";
                            dib = dib + "<TD class=row1 ALIGN='Left'  ><SPAN class=genmed>" + rs.getString(3) + "</SPAN></TD>";
                            dib = dib + "<TD class=row1 ALIGN='center'  ><SPAN class=genmed>" + rs.getString(4) + "</SPAN></TD>";
                            dib = dib + "<TD class=row1 ALIGN='center'  ><SPAN class=genmed>" + rs.getString(5) + "</SPAN></TD>";
                            dib = dib + "<TD class=row1 ALIGN='center'  ><SPAN class=genmed>" + rs.getString(6) + "</SPAN></TD>";
                            dib = dib + "<TD class=row1 ALIGN='center'  ><SPAN class=genmed>" + rs.getString(7) + "</SPAN></TD>";
                            dib = dib + "</TR>";
                        }
                    while(rs.next());
                dib = dib + " </table>";
            }
        }
        catch(Exception er)
        {
            er.printStackTrace();
        }
        finally {
                    try {
                        if (con != null)
                            con.close();

                    } catch (SQLException er) {
                        ;
                    }
                }
        return dib;
    }
    
    public static String devuelve_tipo_fun(String cod)
    {
        sicopea.conexion dc = new sicopea.conexion();
        Connection con = null;
        CallableStatement call = null;
        String res = "0";
        try
        {
            con = dc.abrirConexion();
            call = con.prepareCall("{ ? = call pkg_acreditacion.devuelve_tipofun ( ? ) }");
            call.registerOutParameter(1, 12);
            call.setString(2, cod);
            call.execute();
            res = (String)call.getObject(1);
        }
        catch(Exception er)
        {
            er.printStackTrace();
        }
        finally {
                    try {
                        if (con != null)
                            con.close();

                    } catch (SQLException er) {
                        ;
                    }
                }
        return res;
    }
    
    public static String devuelve_estado_re(String cod)
    {
        sicopea.conexion dc = new sicopea.conexion();
        Connection con = null;
        CallableStatement call = null;
        String res = "0";
        try
        {
            con = dc.abrirConexion();
            call = con.prepareCall("{ ? = call pkg_acreditacion.devuelve_estado_re ( ? ) }");
            call.registerOutParameter(1, 12);
            call.setString(2, cod);
            call.execute();
            res = (String)call.getObject(1);
        }
        catch(Exception er)
        {
            er.printStackTrace();
        }
        finally {
                    try {
                        if (con != null)
                            con.close();

                    } catch (SQLException er) {
                        ;
                    }
                }
        return res;
    }
    
    public static String creamensaje(String tipo, String Mensaje, String tiempo)
    {
        /*String res="";
        if(tipo.equals("1"))
        {
        res= "<div id='msgalert'>"+Mensaje+"</div><script type='text/javascript'>$(document).ready(function(){$('#msgalert').fadeIn(1000);setTimeout('hide()',"+tiempo+"000);});function hide(){$('#msgalert').fadeOut(3000);}</script>";
        }
        if(tipo.equals("2"))
        {
        res= "<div id='msgerror'>"+Mensaje+"</div><script type='text/javascript'>$(document).ready(function(){$('#msgerror').fadeIn(1000);setTimeout('hide()',"+tiempo+"000);});function hide(){$('#msgerror').fadeOut(3000);}</script>";
        }
        if(tipo.equals("3"))
        {
        res= "<div id='msginfo'>"+Mensaje+"</div><script type='text/javascript'>$(document).ready(function(){$('#msginfo').fadeIn(1000);setTimeout('hide()',"+tiempo+"000);});function hide(){$('#msginfo').fadeOut(3000);}</script>";
        }
        return res;*/

        String res="";
        if(tipo.equals("1"))
        {
        res= "<div id='msgalert'>"+Mensaje+"</div><script type='text/javascript'>$(document).ready(function(){$('#msgalert').fadeIn(1000);setTimeout('hide()',450000);});function hide(){$('#msgalert').fadeOut(3000);}</script>";
        }
        if(tipo.equals("2"))
        {
        res= "<div id='msgerror'>"+Mensaje+"</div><script type='text/javascript'>$(document).ready(function(){$('#msgerror').fadeIn(1000);setTimeout('hide()',450000);});function hide(){$('#msgerror').fadeOut(3000);}</script>";
        }
        if(tipo.equals("3"))
        {
        res= "<div id='msginfo'>"+Mensaje+"</div><script type='text/javascript'>$(document).ready(function(){$('#msginfo').fadeIn(1000);setTimeout('hide()',450000);});function hide(){$('#msginfo').fadeOut(3000);}</script>";
        }
        return res;
    }
    
    
    
}