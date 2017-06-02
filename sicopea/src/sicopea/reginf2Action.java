// Decompiled by DJ v3.5.5.77 Copyright 2003 Atanas Neshkov  Date: 18/12/2011 1:21:48
// Home Page : http://members.fortunecity.com/neshkov/dj.html  - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   reginfAction.java

package sicopea;

import java.io.IOException;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;


// Referenced classes of package sicopea:
//            reginf2Form, modacrForm, util

public class reginf2Action extends Action
{

    public reginf2Action()
    {
    }

    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        reginf2Form rform = (reginf2Form)request.getAttribute("reginf2Form");
        modacrForm mform = (modacrForm)request.getAttribute("modacrForm");
        String usuario = request.getSession().getAttribute("user.nick").toString();
        String perfil = request.getSession().getAttribute("user.perfil").toString();
        String responselink = "";
        if(rform.getBoton().equals("Cancelar"))
        {
            if(rform.getVtipomodif().equals("0"))
                responselink = "modif";
            if(rform.getVtipomodif().equals("1"))
                responselink = "modif1";
            if(rform.getVtipomodif().equals("2"))
                responselink = "modif2";
            modacrForm modifset = new modacrForm();
            reginf2Form regifset = new reginf2Form();
            modifset.setCentidad(rform.getVentidad());
            modifset.setCtipolist(rform.getVtipolist());
            modifset.setCcodigo("");
            request.setAttribute("modacrForm", modifset);
            request.setAttribute("reginf2Form", regifset);
        } else
        {
            String ssentidad = util.devuelve_entidad(usuario, perfil);
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
                        call = con.prepareCall("{ ? = call pkg_acreditacion.registra_acreditado ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?  ,?,? ,?,?) }");
                        call.registerOutParameter(1, 12);
                        call.setString(2, rform.getVcodigo());
                        call.setString(3, rform.getVnombre());
                        call.setString(4, rform.getVcite());
                        call.setString(5, rform.getVfeccite());
                        call.setString(6, rform.getVcargo());
                        call.setString(7, rform.getVcategoria());
                        call.setString(8, rform.getVfecllegada());
                        call.setString(9, null);
                        call.setString(10, usuario);
                        call.setString(11, rform.getVentidad());
                        call.setString(12, null);
                        call.setString(13, null);
                        call.setString(14, "Repatriado");
                        call.setString(15, null);
                    }
                    if(rform.getBoton().equals("Modificar"))
                    {
                        if(rform.getVtipomodif().equals("0"))
                            responselink = "modif";
                        if(rform.getVtipomodif().equals("1"))
                            responselink = "modif1";
                        if(rform.getVtipomodif().equals("2"))
                            responselink = "modif2";
                        call = con.prepareCall("{ ? = call pkg_acreditacion.modifica_acreditado ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?  ,?,? ,?,?) }");
                        call.registerOutParameter(1, 12);
                        call.setString(2, rform.getVcodigo());
                        call.setString(3, rform.getVnombre());
                        call.setString(4, rform.getVcite());
                        call.setString(5, rform.getVfeccite());
                        call.setString(6, rform.getVcargo());
                        call.setString(7, rform.getVcategoria());
                        call.setString(8, rform.getVfecllegada());
                        call.setString(9, null);
                        call.setString(10, usuario);
                        call.setString(11, rform.getVentidad());
                        call.setString(12, rform.getVobs());
                        call.setString(13, rform.getVtipoobs());
                        call.setString(14, rform.getVfecobs());
                        
                        call.setString(15, null);
                        call.setString(16, null);
                        
                        call.setString(17, rform.getVtipodiplomatico());
                        call.setString(18, rform.getVproyecto());
                    }
                    call.execute();
                    res = call.getObject(1).toString();
                    con.commit();
                    modacrForm modifset = new modacrForm();
                    reginf2Form regifset = new reginf2Form();
                    regifset.setResp(res);
                    modifset.setCentidad(rform.getVentidad());
                    modifset.setCtipolist(rform.getVtipolist());
                    modifset.setCcodigo("");
                    request.setAttribute("modacrForm", modifset);
                    request.setAttribute("reginf2Form", regifset);
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
        }
        return mapping.findForward(responselink);
    }
}