// Decompiled by DJ v3.5.5.77 Copyright 2003 Atanas Neshkov  Date: 18/12/2011 1:25:30
// Home Page : http://members.fortunecity.com/neshkov/dj.html  - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   impacrAction.java

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

import javax.sql.DataSource;

import net.sf.jasperreports.engine.JasperRunManager;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;


// Referenced classes of package sicopea:
//            impacrForm

public class impacrAction extends Action
{

    public impacrAction()
    {
    }

    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        String pagina = "success";
       /* if(generarReporte(form, request, response))
            pagina = "success";*/
        return mapping.findForward(pagina);
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
        impacrForm impf = (impacrForm)request.getAttribute("impacrForm");
        String reportName = null;
        String entidad = impf.getBotonimp2();
        InitialContext ic = null;
        Connection cn = null;
        String imagenName = "";
        try
        {
            ic = new InitialContext();
            DataSource ds;
            ds = (DataSource)ic.lookup("jdbc/sicopea");
            cn = (Connection)ds.getConnection();
            
            if(util.devuelve_estado_re(impf.getBotonimp()).equals("cancilleria")){
                if(util.devuelve_tipo_fun(impf.getBotonimp()).equals("acreditado"))
                {
                    reportName = "/jasper/REPACRE.jasper";
                    imagenName = "/jasper/escudo_bolivia2.jpg";
                }
                else
                {
                    reportName = "/jasper/REPATRI.jasper";
                    imagenName = "/jasper/escudo_bolivia2.jpg";
                }
                
            }
            else{
                if(util.devuelve_tipo_fun(impf.getBotonimp()).equals("acreditado"))
                {
                    reportName = "/jasper/REPACREre.jasper";
                    imagenName = "/jasper/escudo_bolivia2.jpg";
                }
                else
                {
                    reportName = "/jasper/REPATRIre.jasper";
                    imagenName = "/jasper/escudo_bolivia2.jpg";
                } 
            }
                    
            String reportPath = getServlet().getServletContext().getRealPath(reportName);
            String imagenPath = getServlet().getServletContext().getRealPath(imagenName);
            File reportFile = new File(reportPath);
            if(reportFile.exists())
            {
                Map parameters = new HashMap();
                parameters.put("PCODACR", impf.getBotonimp());
                parameters.put("PCODENT", entidad);
                parameters.put("p_img", imagenPath);
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