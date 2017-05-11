// Decompiled by DJ v3.5.5.77 Copyright 2003 Atanas Neshkov  Date: 18/12/2011 1:22:24
// Home Page : http://members.fortunecity.com/neshkov/dj.html  - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   regentAction.java

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
//            regentForm, util

public class regentAction extends Action
{

    public regentAction()
    {
    }

    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        regentForm rform = (regentForm)request.getAttribute("regentForm");
        String usuario = request.getSession().getAttribute("user.nick").toString();
        String perfil = request.getSession().getAttribute("user.perfil").toString();
        String ssentidad = util.devuelve_entidad(usuario, perfil);
        String responselink = "";
        if(rform.getBoton().equals("Grabar") || rform.getBoton().equals("Modificar"))
        {
            responselink = "volver";
            sicopea.conexion dc = new sicopea.conexion();
                   Connection con = null;
                   CallableStatement call = null;
            String res = null;
            try
            {
                con = dc.abrirConexion();
                if(rform.getBoton().equals("Grabar"))
                {
                    call = con.prepareCall("{ ? = call pkg_acreditacion.registra_entidad ( ?, ?, ?, ?, ?, ?, ?) }");
                    call.registerOutParameter(1, 12);
                    call.setString(2, rform.getVcodigo());
                    call.setString(3, rform.getVnombre());
                    call.setString(4, rform.getVdireccion());
                    call.setString(5, rform.getVtel());
                    call.setString(6, rform.getVfax());
                    call.setString(7, rform.getVmail());
                    call.setString(8, usuario);
                }
                if(!rform.getBoton().equals("Modificar"));
                call.execute();
                res = call.getObject(1).toString();
                con.commit();
                regentForm regenset = new regentForm();
                regenset.setResp(res);
                request.setAttribute("regentForm", regenset);
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
        }
        return mapping.findForward(responselink);
    }
}