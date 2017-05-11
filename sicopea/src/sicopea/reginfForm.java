// Decompiled by DJ v3.5.5.77 Copyright 2003 Atanas Neshkov  Date: 18/12/2011 1:21:31
// Home Page : http://members.fortunecity.com/neshkov/dj.html  - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   reginfForm.java

package sicopea;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;


public class reginfForm extends ActionForm
{
    

    private String ventidad;
    private String vcite;
    private String vfeccite;
    private String vnombre;
    private String vcargo;
    private String vcategoria;
    private String vfecllegada;
    private String vfeccese;
    private String boton;
    private String btn;
    private String vcodigo;
    private String resp;
    private String vobs;
    private String vtipoobs;
    private String vfecobs;
    private String vtipolist;
    private String vtipomodif;
    
    private String vdocidentidad;
    private String vtipodoc;
    private String respuesta;
    private String v_docidentidad;
    private String v_tipodoc;
    private String valores;


    
    public reginfForm()
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

    public String getVentidad()
    {
        return ventidad;
    }

    public void setVentidad(String newVentidad)
    {
        ventidad = newVentidad;
    }

    public String getVcite()
    {
        return vcite;
    }

    public void setVcite(String newVcite)
    {
        vcite = newVcite;
    }

    public String getVfeccite()
    {
        return vfeccite;
    }

    public void setVfeccite(String newVfeccite)
    {
        vfeccite = newVfeccite;
    }

    public String getVnombre()
    {
        return vnombre;
    }

    public void setVnombre(String newVnombre)
    {
        vnombre = newVnombre;
    }

    public String getVcargo()
    {
        return vcargo;
    }

    public void setVcargo(String newVcargo)
    {
        vcargo = newVcargo;
    }

    public String getVcategoria()
    {
        return vcategoria;
    }

    public void setVcategoria(String newVcategoria)
    {
        vcategoria = newVcategoria;
    }

    public String getVfecllegada()
    {
        return vfecllegada;
    }

    public void setVfecllegada(String newVfecllegada)
    {
        vfecllegada = newVfecllegada;
    }

    public String getVfeccese()
    {
        return vfeccese;
    }

    public void setVfeccese(String newVfeccese)
    {
        vfeccese = newVfeccese;
    }

    public String getBoton()
    {
        return boton;
    }

    public void setBoton(String newBoton)
    {
        boton = newBoton;
    }

    public String getBtn()
    {
        return btn;
    }

    public void setBtn(String newBtn)
    {
        btn = newBtn;
    }

    public String getVcodigo()
    {
        return vcodigo;
    }

    public void setVcodigo(String newVcodigo)
    {
        vcodigo = newVcodigo;
    }

    public String getResp()
    {
        return resp;
    }

    public void setResp(String newResp)
    {
        resp = newResp;
    }

    public String getVobs()
    {
        return vobs;
    }

    public void setVobs(String newVobs)
    {
        vobs = newVobs;
    }

    public String getVtipoobs()
    {
        return vtipoobs;
    }

    public void setVtipoobs(String newVtipoobs)
    {
        vtipoobs = newVtipoobs;
    }

    public String getVfecobs()
    {
        return vfecobs;
    }

    public void setVfecobs(String newVfecobs)
    {
        vfecobs = newVfecobs;
    }

    public String getVtipolist()
    {
        return vtipolist;
    }

    public void setVtipolist(String newVtipolist)
    {
        vtipolist = newVtipolist;
    }

    public String getVtipomodif()
    {
        return vtipomodif;
    }

    public void setVtipomodif(String newVtipomodif)
    {
        vtipomodif = newVtipomodif;
    }


    public void setVdocidentidad(String vdocidentidad) {
        this.vdocidentidad = vdocidentidad;
    }

    public String getVdocidentidad() {
        return vdocidentidad;
    }

    public void setVtipodoc(String vtipodoc) {
        this.vtipodoc = vtipodoc;
    }

    public String getVtipodoc() {
        return vtipodoc;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public String getRespuesta() {
        return respuesta;
    }

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

    public void setValores(String valores) {
        this.valores = valores;
    }

    public String getValores() {
        return valores;
    }
}
