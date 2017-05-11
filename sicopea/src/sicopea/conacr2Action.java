// Decompiled by DJ v3.5.5.77 Copyright 2003 Atanas Neshkov  Date: 18/12/2011 1:28:19
// Home Page : http://members.fortunecity.com/neshkov/dj.html  - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   conacr2Action.java

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
//            conacr2Form

public class conacr2Action extends Action
{

    public conacr2Action()
    {
    }

    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        conacr2Form mform = (conacr2Form)request.getAttribute("conacr2Form");
        conacr2Form mformset = new conacr2Form();
        String pagina = "menu";
        if(mform.getBoton() == null && mform.getCimprimir().length() != 0 && generarReporte(form, request, response))
        {
            mformset.setCcodigo(mform.getCcodigo());
            mformset.setCencargado(mform.getCencargado());
            mformset.setCentidad(mform.getCentidad());
            mformset.setCimprimir("");
            request.setAttribute("conacr2Form", mformset);
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
        conacr2Form mform = (conacr2Form)form;
        String reportName = null;
        InitialContext ic = null;
        Connection cn = null;
        try
        {
            ic = new InitialContext();
            cn = ((OracleConnectionPoolDataSource)ic.lookup("jdbc/sicopea")).getConnection();
            if(util.devuelve_estado_re(mform.getCimprimir()).equals("cancilleria")){
                reportName = "/jasper/REPACRE2.jasper";
            }
            else{
                reportName = "/jasper/REPACRE2re.jasper";
            }            
            String imagenName = "/jasper/logo_aduana.gif";
            String reportPath = getServlet().getServletContext().getRealPath(reportName);
            String imagenPath = getServlet().getServletContext().getRealPath(imagenName);
            File reportFile = new File(reportPath);
            if(reportFile.exists())
            {
                Map parameters = new HashMap();
                parameters.put("PCODACR", mform.getCimprimir());
                parameters.put("PCODENT", "101");
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