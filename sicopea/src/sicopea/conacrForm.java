// Decompiled by DJ v3.5.5.77 Copyright 2003 Atanas Neshkov  Date: 18/12/2011 1:27:20
// Home Page : http://members.fortunecity.com/neshkov/dj.html  - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   conacrForm.java

package sicopea;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.*;

public class conacrForm extends ActionForm
{

    public conacrForm()
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

    public String getCentidad()
    {
        return centidad;
    }

    public void setCentidad(String newCentidad)
    {
        centidad = newCentidad;
    }

    public String getCencargado()
    {
        return cencargado;
    }

    public void setCencargado(String newCencargado)
    {
        cencargado = newCencargado;
    }

    public String getCcodigo()
    {
        return ccodigo;
    }

    public void setCcodigo(String newCcodigo)
    {
        ccodigo = newCcodigo;
    }

    public String getCimprimir()
    {
        return cimprimir;
    }

    public void setCimprimir(String newCimprimir)
    {
        cimprimir = newCimprimir;
    }

    public String getCtipolist()
    {
        return ctipolist;
    }

    public void setCtipolist(String newCtipolist)
    {
        ctipolist = newCtipolist;
    }

    private String centidad;
    private String cencargado;
    private String ccodigo;
    private String cimprimir;
    private String ctipolist;
}