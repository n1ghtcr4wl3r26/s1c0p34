// Decompiled by DJ v3.5.5.77 Copyright 2003 Atanas Neshkov  Date: 18/12/2011 1:26:37
// Home Page : http://members.fortunecity.com/neshkov/dj.html  - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   eliacrAction.java

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
//            eliacrForm, util

public class eliacrAction extends Action
{

    public eliacrAction()
    {
    }

    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        eliacrForm mform = (eliacrForm)request.getAttribute("eliacrForm");
        if(mform.getCcodigo() != null)
        {
            String usuario = request.getSession().getAttribute("user.nick").toString();
            String perfil = request.getSession().getAttribute("user.perfil").toString();
            String ssentidad = util.devuelve_entidad(usuario, perfil);
            sicopea.conexion dc = new sicopea.conexion();
            Connection con = null;
            CallableStatement call = null;
            String res = null;
            try
            {
                con = dc.abrirConexion();
                call = con.prepareCall("{ ? = call pkg_acreditacion.elimina_acreditado ( ?, ?, ?) }");
                call.registerOutParameter(1, 12);
                call.setString(2, mform.getCcodigo());
                call.setString(3, mform.getCentidad());
                call.setString(4, usuario);
                call.execute();
                res = call.getObject(1).toString();
                con.commit();
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
        return mapping.findForward("volver");
    }
}