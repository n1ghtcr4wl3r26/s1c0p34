// Decompiled by DJ v3.5.5.77 Copyright 2003 Atanas Neshkov  Date: 18/12/2011 1:20:45
// Home Page : http://members.fortunecity.com/neshkov/dj.html  - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   SalirAction.java

package sicopea;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import org.apache.struts.action.*;

public class SalirAction extends Action
{

    public SalirAction()
    {
    }

    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        request.getSession().setAttribute("user", "");
        request.getSession().setAttribute("user.data", "");
        request.getSession().setAttribute("user.perfil", "");
        request.getSession().setAttribute("user.nick", "");
        request.getSession().setAttribute("user.codent", "");
        request.getSession().setAttribute("ops", "");
        request.setAttribute("reginfForm", null);
        request.setAttribute("modacrForm", null);
        return mapping.findForward("input");
    }
}