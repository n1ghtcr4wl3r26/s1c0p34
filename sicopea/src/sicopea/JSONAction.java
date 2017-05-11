// Decompiled by DJ v3.5.5.77 Copyright 2003 Atanas Neshkov  Date: 18/12/2011 1:24:17
// Home Page : http://members.fortunecity.com/neshkov/dj.html  - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   JSONAction.java

package sicopea;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.*;
import org.apache.struts.actions.DispatchAction;

// Referenced classes of package sicopea:
//            JsonDB

public class JSONAction extends DispatchAction
{

    public JSONAction()
    {
    }

    public ActionForward registra(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        JsonDB json = null;
        String entidad = "104";
        String cite = "1";
        String feccite = "01/01/2010";
        String nombre = "1";
        String cargo = "1";
        String categoria = "1";
        String fecllegada = "01/01/2010";
        String feccese = "1";
        try
        {
            json = new JsonDB();
            response.setContentType("text/json");
            response.getWriter().write(json.getRegistra(entidad, cite, feccite, nombre, cargo, categoria, fecllegada, feccese));
        }
        catch(Exception exception) { }
        finally
        {
            if(json == null);
        }
        return null;
    }

    public ActionForward registra2(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        JsonDB json = null;
        String merca = request.getParameter("p_entidad");
        try
        {
            json = new JsonDB();
            response.setContentType("text/json");
            response.getWriter().write(json.getMarcas(merca));
        }
        catch(Exception exception) { }
        finally
        {
            if(json == null);
        }
        return null;
    }

    public ActionForward modelo(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        JsonDB json = null;
        String merca = request.getParameter("p_merca");
        String marca = request.getParameter("p_marca");
        try
        {
            json = new JsonDB();
            response.setContentType("text/json");
            response.getWriter().write(json.getModelos(merca, marca));
        }
        catch(Exception exception) { }
        finally
        {
            if(json == null);
        }
        return null;
    }

    public ActionForward marcasMO(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        JsonDB json = null;
        String merca = request.getParameter("p_merca");
        String marca = request.getParameter("p_marca");
        try
        {
            json = new JsonDB();
            response.setContentType("text/json");
            response.getWriter().write(json.getMarcasMO(merca, marca));
        }
        catch(Exception exception) { }
        finally
        {
            if(json == null);
        }
        return null;
    }

    public ActionForward modeloMO(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        JsonDB json = null;
        String merca = request.getParameter("p_merca");
        String marca = request.getParameter("p_marca");
        String modelo = request.getParameter("p_modelo");
        try
        {
            json = new JsonDB();
            response.setContentType("text/json");
            response.getWriter().write(json.getModelosMO(merca, marca, modelo));
        }
        catch(Exception exception) { }
        finally
        {
            if(json == null);
        }
        return null;
    }
}