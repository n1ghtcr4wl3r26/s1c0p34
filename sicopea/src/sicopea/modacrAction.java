// Decompiled by DJ v3.5.5.77 Copyright 2003 Atanas Neshkov  Date: 18/12/2011 1:23:31
// Home Page : http://members.fortunecity.com/neshkov/dj.html  - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   modacrAction.java

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
//            modacrForm, reginfForm, util

public class modacrAction extends Action
{

    public modacrAction()
    {
    }

    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        modacrForm mform = (modacrForm)request.getAttribute("modacrForm");
        reginfForm rformset = new reginfForm();
        reginfForm rformset2 = (reginfForm)request.getAttribute("reginfForm");
        String link = "";
        if(mform.getCtipomodif().equals("0"))
            link = "volver";
        if(mform.getCtipomodif().equals("1"))
            link = "volver1";
        if(mform.getCtipomodif().equals("2"))
            link = "volver2";
        if(mform.getCcodigo().length() > 0)
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
                call = con.prepareCall("{ ? = call pkg_acreditacion.devuelve_acreditado ( ?, ?) }");
                call.registerOutParameter(1, -10);
                call.setString(2, mform.getCcodigo().toString());
                call.setString(3, mform.getCentidad());
                call.execute();
                ResultSet rs = (ResultSet)call.getObject(1);
                if(rs != null && rs.next())
                {
                    rformset.setVcite(rs.getString(1));
                    rformset.setVfeccite(rs.getString(2));
                    rformset.setVcodigo(rs.getString(3));
                    rformset.setVnombre(rs.getString(4));
                    rformset.setVcargo(rs.getString(5));
                    rformset.setVcategoria(rs.getString(6));
                    rformset.setVfecllegada(rs.getString(7));
                    rformset.setVfeccese(rs.getString(8));
                    rformset.setVentidad(mform.getCentidad());
                    rformset.setVtipolist(mform.getCtipolist());
                    rformset.setVtipomodif(mform.getCtipomodif());
                    
                    rformset.setV_docidentidad(rs.getString(9));
                    rformset.setV_tipodoc(rs.getString(10));
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
            request.setAttribute("reginfForm", rformset);
        }
        return mapping.findForward(link);
    }
}