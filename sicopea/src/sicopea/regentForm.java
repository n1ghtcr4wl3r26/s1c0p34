// Decompiled by DJ v3.5.5.77 Copyright 2003 Atanas Neshkov  Date: 18/12/2011 1:22:06
// Home Page : http://members.fortunecity.com/neshkov/dj.html  - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   regentForm.java

package sicopea;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.*;

public class regentForm extends ActionForm
{

    public regentForm()
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

    public String getVcodigo()
    {
        return vcodigo;
    }

    public void setVcodigo(String newVcodigo)
    {
        vcodigo = newVcodigo;
    }

    public String getVnombre()
    {
        return vnombre;
    }

    public void setVnombre(String newVnombre)
    {
        vnombre = newVnombre;
    }

    public String getVdireccion()
    {
        return vdireccion;
    }

    public void setVdireccion(String newVdireccion)
    {
        vdireccion = newVdireccion;
    }

    public String getVtel()
    {
        return vtel;
    }

    public void setVtel(String newVtel)
    {
        vtel = newVtel;
    }

    public String getVfax()
    {
        return vfax;
    }

    public void setVfax(String newVfax)
    {
        vfax = newVfax;
    }

    public String getVmail()
    {
        return vmail;
    }

    public void setVmail(String newVmail)
    {
        vmail = newVmail;
    }

    public String getBoton()
    {
        return boton;
    }

    public void setBoton(String newBoton)
    {
        boton = newBoton;
    }

    public String getResp()
    {
        return resp;
    }

    public void setResp(String newResp)
    {
        resp = newResp;
    }

    private String vcodigo;
    private String vnombre;
    private String vdireccion;
    private String vtel;
    private String vfax;
    private String vmail;
    private String boton;
    private String resp;
}