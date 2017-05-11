// Decompiled by DJ v3.5.5.77 Copyright 2003 Atanas Neshkov  Date: 18/12/2011 1:22:59
// Home Page : http://members.fortunecity.com/neshkov/dj.html  - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   modentAction.java

package sicopea;

import java.io.IOException;
import java.sql.*;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.sql.PooledConnection;
import oracle.jdbc.pool.OracleConnectionPoolDataSource;
import org.apache.struts.action.*;

// Referenced classes of package sicopea:
//            modentForm

public class modentAction extends Action
{

    public modentAction()
    {
    }

    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        modentForm ment = (modentForm)request.getAttribute("modentForm");
        String usuario = request.getSession().getAttribute("user.nick").toString();
        if(ment.getEdit() != null && ment.getCcancel() != null && ment.getCdelete() != null && ment.getUpdate() != null)
        {
            if(ment.getEdit().length() > 0)
            {
                ment.setCdelete("");
                if(ment.getUpdate().length() > 0 && ment.getUpdate().equals(ment.getEdit()))
                {
                    ment.setMsg(modificarentidad(ment.getUpdate(), ment.getDes_ent(), ment.getDir_ent(), ment.getTel_ent(), ment.getFax_ent(), ment.getEmail_ent(), ment.getTipo(), usuario));
                    ment.setEdit("");
                    ment.setUpdate("");
                    ment.setCdelete("");
                } else
                if(ment.getCcancel().length() > 0)
                {
                    ment.setMsg("");
                    ment.setEdit("");
                    ment.setCcancel("");
                    ment.setCdelete("");
                }
            }
            if(ment.getCdelete().length() > 0)
            {
                ment.setMsg(borrarentidad(ment.getCdelete(), usuario));
                ment.setCdelete("");
                ment.setCcancel("");
                ment.setEdit("");
                ment.setUpdate("");
            }
        }
        return mapping.findForward("volver");
    }

    public static String borrarentidad(String entidadID, String usuario)
    {
        sicopea.conexion dc = new sicopea.conexion();
                Connection con = null;
                CallableStatement call = null;
        String res = " ";
        try
        {
            con = dc.abrirConexion();
            call = con.prepareCall("{ ? = call pkg_acreditacion.elimina_entidad ( ?, ? ) }");
            call.registerOutParameter(1, 12);
            call.setString(2, entidadID);
            call.setString(3, usuario);
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

    public static String modificarentidad(String entidadID, String desent, String dirent, String telent, String faxent, String emailent, String tipo, String usuario)
    {
        sicopea.conexion dc = new sicopea.conexion();
                Connection con = null;
                CallableStatement call = null;

        String res = " ";
        try
        {
            con = dc.abrirConexion();
            call = con.prepareCall("{ ? = call pkg_acreditacion.modifica_entidad ( ?, ?, ?, ?, ?, ?, ?, ? ) }");
            call.registerOutParameter(1, 12);
            call.setString(2, entidadID);
            call.setString(3, desent);
            call.setString(4, usuario);
            call.setString(5, dirent);
            call.setString(6, telent);
            call.setString(7, faxent);
            call.setString(8, emailent);
            call.setString(9, tipo);
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
}