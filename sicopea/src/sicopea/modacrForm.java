// Decompiled by DJ v3.5.5.77 Copyright 2003 Atanas Neshkov  Date: 18/12/2011 1:23:16
// Home Page : http://members.fortunecity.com/neshkov/dj.html  - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   modacrForm.java

package sicopea;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.*;

public class modacrForm extends ActionForm
{

    public modacrForm()
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

    public String getCtipomodif()
    {
        return ctipomodif;
    }

    public void setCtipomodif(String newCtipomodif)
    {
        ctipomodif = newCtipomodif;
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
    private String ctipomodif;
    private String ctipolist;
    
    private String v_docidentidad;
    private String v_tipodoc;

    public void setV_docidentidad(String v_docidentidad) {
        this.v_docidentidad = v_docidentidad;
    }

    public String getV_docidentidad() {
        return v_docidentidad;
    }

    public void setV_tipodoc(String v_tipodoc) {
        this.v_tipodoc = v_tipodoc;
    }

    public String getV_tipodoc() {
        return v_tipodoc;
    }
}
