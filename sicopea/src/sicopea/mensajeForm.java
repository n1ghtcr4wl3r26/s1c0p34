// Decompiled by DJ v3.5.5.77 Copyright 2003 Atanas Neshkov  Date: 18/12/2011 1:23:49
// Home Page : http://members.fortunecity.com/neshkov/dj.html  - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   mensajeForm.java

package sicopea;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.*;

public class mensajeForm extends ActionForm
{

    public mensajeForm()
    {
    }

    public void reset(ActionMapping mapping, HttpServletRequest request)
    {
        super.reset(mapping, request);
    }

    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request)
    {
        return super.validate(mapping, request);
    }

    public String getMsg()
    {
        return msg;
    }

    public void setMsg(String newMsg)
    {
        msg = newMsg;
    }

    public String getTipo()
    {
        return tipo;
    }

    public void setTipo(String newTipo)
    {
        tipo = newTipo;
    }

    private String msg;
    private String tipo;
}