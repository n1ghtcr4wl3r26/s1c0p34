// Decompiled by DJ v3.5.5.77 Copyright 2003 Atanas Neshkov  Date: 18/12/2011 1:27:41
// Home Page : http://members.fortunecity.com/neshkov/dj.html  - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   conacrAction.java

package sicopea;

import java.io.File;
import java.io.IOException;

import java.sql.Connection;

import java.util.HashMap;
import java.util.Map;

import javax.naming.InitialContext;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JasperRunManager;

import oracle.jdbc.pool.OracleConnectionPoolDataSource;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

// Referenced classes of package sicopea:
//            conacrForm

public class conacrAction extends Action
{

    public conacrAction()
    {
    }

    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        conacrForm mform = (conacrForm)request.getAttribute("conacrForm");
        conacrForm mformset = new conacrForm();
        String pagina = "menu";
        if(mform.getCimprimir().length() != 0)
        {
            if(generarReporte(form, request, response))
            {
                mformset.setCcodigo(mform.getCcodigo());
                mformset.setCencargado(mform.getCencargado());
                mformset.setCentidad(mform.getCentidad());
                mformset.setCimprimir("");
                request.setAttribute("conacrForm", mformset);
            }
        } else
        {
            String usuario = request.getSession().getAttribute("user.nick").toString();
            String perfil = request.getSession().getAttribute("user.perfil").toString();
            String ssentidad = request.getSession().getAttribute("user.codent").toString();
            if(perfil.equals("OPERADOR"))
            {
                mformset.setCcodigo(mform.getCcodigo());
                mformset.setCencargado(usuario);
                mformset.setCentidad(ssentidad);
                mformset.setCtipolist(mform.getCtipolist());
                request.setAttribute("conacrForm", mformset);
            }
        }
        return mapping.findForward("volver");
    }

    private void toPDF(HttpServletResponse response, File reportFile, Map parameters, Connection cn)
        throws Exception
    {
        byte bytes[] = JasperRunManager.runReportToPdf(reportFile.getPath(), parameters, cn);
        response.setContentType("application/pdf");
        response.setContentLength(bytes.length);
        ServletOutputStream ouputStream = response.getOutputStream();
        ouputStream.write(bytes, 0, bytes.length);
        ouputStream.flush();
        ouputStream.close();
    }

    private boolean generarReporte(ActionForm form, HttpServletRequest request, HttpServletResponse response)
    {
        conacrForm mform = (conacrForm)form;
        String reportName = null;
        String perfil = request.getSession().getAttribute("user.perfil").toString();
        String ssentidad;
        if(perfil.equals("OPERADOR"))
            ssentidad = request.getSession().getAttribute("user.codent").toString();
        else
            ssentidad = mform.getCentidad();
        InitialContext ic = null;
        Connection cn = null;
        try
        {
            ic = new InitialContext();
            cn = ((OracleConnectionPoolDataSource)ic.lookup("jdbc/sicopea")).getConnection();
            if(util.devuelve_estado_re(mform.getCimprimir()).equals("cancilleria")){
                reportName = "/jasper/REPACRE.jasper";
            }
            else{
                reportName = "/jasper/REPACREre.jasper";
            }
            String imagenName = "/jasper/logo_aduana.gif";
            String reportPath = getServlet().getServletContext().getRealPath(reportName);
            String imagenPath = getServlet().getServletContext().getRealPath(imagenName);
            File reportFile = new File(reportPath);
            if(reportFile.exists())
            {
                Map parameters = new HashMap();
                parameters.put("PCODACR", mform.getCimprimir());
                parameters.put("PCODENT", ssentidad);
                toPDF(response, reportFile, parameters, cn);
            }
        }
        catch(Exception exception) { }
        finally
        {
            try
            {
                if(cn != null)
                    cn.close();
                if(ic != null)
                    ic.close();
            }
            catch(Exception exception2) { }
        }
        return true;
    }
}