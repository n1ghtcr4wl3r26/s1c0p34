// Decompiled by DJ v3.5.5.77 Copyright 2003 Atanas Neshkov  Date: 18/12/2011 1:21:48
// Home Page : http://members.fortunecity.com/neshkov/dj.html  - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   reginfAction.java

package sicopea;


import bo.gob.rree.ent.EntidadInfo;
import bo.gob.rree.ent.PersonaInfo;
import bo.gob.rree.ws.SvcCancilleria;

import java.io.IOException;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;


// Referenced classes of package sicopea:
//            reginfForm, modacrForm, util

public class reginfAction extends Action
{
    public reginfAction()
    {
    }

    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        reginfForm rform = (reginfForm)request.getAttribute("reginfForm");
        modacrForm mform = (modacrForm)request.getAttribute("modacrForm");
        String usuario = request.getSession().getAttribute("user.nick").toString();
        String perfil = request.getSession().getAttribute("user.perfil").toString();
        String responselink = "";
        
        if(rform.getBoton().equals("Recuperar"))
        {   
            responselink = "volver";
            rform.setV_docidentidad(null);
            rform.setV_tipodoc(null);
            
            String resultado = "";
            try
            {
                SvcCancilleria svc = new SvcCancilleria();
                
                List<PersonaInfo> entidades = svc.getAcreditados(rform.getVdocidentidad(), rform.getVtipodoc(),"", 0, 1, 10);
                /*PersonaInfo per = new PersonaInfo();
                per.setCodcategoria(8);
                rform.setVnombre("Edgar");*/
                
                
                if(entidades.size() == 0)
                {
                    rform.setResp("NO SE ENCONTRO INFORMACION");
                }
                else
                {
                    PersonaInfo persona = new PersonaInfo(); // (PersonaInfo)entidades;
                    persona = entidades.get(0); 
                    /*persona = per;*/
                    resultado = persona.getNombreCompleto().getValue();
                    resultado = "Entidades: " + entidades.size();
                    
                    rform.setVnombre(persona.getNombreCompleto().getValue().toUpperCase()); 
                    rform.setVcargo(persona.getCargoPersona().getValue().toUpperCase());
                    int categoria = 0;
                    categoria = persona.getCodcategoria().intValue();
                    switch (categoria){
                    case 1:
                        rform.setVcategoria("1");
                        break;
                    case 2:
                        rform.setVcategoria("2");
                        break;
                    case 3:
                        rform.setVcategoria("3");
                        break;
                    case 4:
                        rform.setVcategoria("4");
                        break;
                    case 5:
                        rform.setVcategoria("5");
                        break;
                    case 6:
                        rform.setVcategoria("6");
                        break;
                    case 7:
                        rform.setVcategoria("7");
                        break;
                    case 8:
                        rform.setVcategoria("8");
                        break;
                    default:
                        rform.setVcategoria("");
                        break;
                    }
                    
                    rform.setValores("Datos: "+categoria + " - " + rform.getVcategoria());
                    
                    rform.setVcategoria(String.valueOf(persona.getCodcategoria().intValue()));
                    
                    rform.setVfecllegada(String.valueOf((persona.getFechaLlegadaAlPais().getDay()<10)?"0"+String.valueOf(persona.getFechaLlegadaAlPais().getDay()):String.valueOf(persona.getFechaLlegadaAlPais().getDay()))+"/"+ String.valueOf((persona.getFechaLlegadaAlPais().getMonth()<10)?"0"+String.valueOf(persona.getFechaLlegadaAlPais().getMonth()):String.valueOf(persona.getFechaLlegadaAlPais().getMonth()))+"/"+String.valueOf(persona.getFechaLlegadaAlPais().getYear()));
                    rform.setVfeccese(String.valueOf((persona.getFechacese().getDay()<10)?"0"+String.valueOf(persona.getFechacese().getDay()):String.valueOf(persona.getFechacese().getDay()))+"/"+ String.valueOf((persona.getFechacese().getMonth()<10)?"0"+String.valueOf(persona.getFechacese().getMonth()):String.valueOf(persona.getFechacese().getMonth()))+"/"+String.valueOf(persona.getFechacese().getYear()));
                    rform.setVfeccite(String.valueOf((persona.getFechaCiteSol().getYear()==1)?"":((persona.getFechaCiteSol().getDay()<10)?"0"+String.valueOf(persona.getFechaCiteSol().getDay()):String.valueOf(persona.getFechaCiteSol().getDay()))+"/"+ String.valueOf((persona.getFechaCiteSol().getMonth()<10)?"0"+String.valueOf(persona.getFechaCiteSol().getMonth()):String.valueOf(persona.getFechaCiteSol().getMonth()))+"/"+String.valueOf(persona.getFechaCiteSol().getYear())));
                    rform.setVcite(persona.getCiteSolAcreditacion().getValue().toUpperCase());
                    
                    rform.setV_docidentidad(rform.getVdocidentidad());
                    rform.setV_tipodoc(rform.getVtipodoc());
                    
                    List<EntidadInfo> entidad = (List<EntidadInfo>)svc.getDirectorio("",persona.getCodEntidad().intValue(), 0, 1, 10);
                    if(entidad.size() == 0)
                    {
                        if(rform.getVcategoria().equals("")){
                            rform.setResp("Se recuperaron los datos correctamente, pero no tiene asociada una entidad valida.<br>La categoria devuelta no corresponde a ninguna parametrizada: "+categoria);
                        }else{
                            rform.setResp("Se recuperaron los datos correctamente, pero no tiene asociada una entidad valida");
                        }
                            
                    }
                    else
                    {
                        EntidadInfo ent = new EntidadInfo();
                        ent = entidad.get(0);
                        if(rform.getVcategoria().equals("")){
                            rform.setResp("Se recuperaron los datos correctamente<br>Instituci&oacute;n: "+ent.getCONTACTO().getValue() +"<br>La categoria devuelta no corresponde a ninguna parametrizada: "+categoria);
                        }else{
                            rform.setResp("Se recuperaron los datos correctamente<br>Instituci&oacute;n: "+ent.getCONTACTO().getValue());
                        }    
                    }
                }
            }
            catch (Exception e){
                e.printStackTrace();
                resultado = e.getMessage();
                //rform.setResp("Error: "+e.getMessage());
                rform.setResp("ERROR DE CONEXION");
            }  
            request.setAttribute("reginfForm", rform);
        }    
        else
        if(rform.getBoton().equals("Cancelar"))
        {
            if(rform.getVtipomodif().equals("0"))
                responselink = "modif";
            if(rform.getVtipomodif().equals("1"))
                responselink = "modif1";
            if(rform.getVtipomodif().equals("2"))
                responselink = "modif2";
            modacrForm modifset = new modacrForm();
            reginfForm regifset = new reginfForm();
            modifset.setCentidad(rform.getVentidad());
            modifset.setCtipolist(rform.getVtipolist());
            modifset.setCcodigo("");
            request.setAttribute("modacrForm", modifset);
            request.setAttribute("reginfForm", regifset);
        } else
        {
            String ssentidad = util.devuelve_entidad(usuario, perfil);
            if(rform.getBoton().equals("Grabar") || rform.getBoton().equals("Modificar"))
            {
                responselink = "volver";
                sicopea.conexion dc = new sicopea.conexion();
                        Connection con = null;
                        CallableStatement call = null;
                String res = null;
                try
                {   
                    String categoria;
                    categoria = rform.getVcategoria();
                    if(rform.getVcategoria().equals("7")){
                        categoria = "Ninguna";
                    }
                    if(rform.getVcategoria().equals("8")){
                        categoria = "Otros";
                    }
                    
                    con = dc.abrirConexion();
                    if(rform.getBoton().equals("Grabar"))
                    {
                        call = con.prepareCall("{ ? = call pkg_acreditacion.registra_acreditado ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,  ?,? ,?,?) }");
                        call.registerOutParameter(1, 12);
                        call.setString(2, rform.getVcodigo());
                        call.setString(3, rform.getVnombre());
                        call.setString(4, rform.getVcite());
                        call.setString(5, rform.getVfeccite());
                        call.setString(6, rform.getVcargo());
                        call.setString(7, categoria);
                        call.setString(8, rform.getVfecllegada());
                        call.setString(9, rform.getVfeccese());
                        call.setString(10, usuario);
                        call.setString(11, rform.getVentidad());
                        call.setString(12, rform.getV_docidentidad());
                        call.setString(13, rform.getV_tipodoc());
                        call.setString(14, "Normal");
                        call.setString(15, null);
                    } 
                    if(rform.getBoton().equals("Modificar"))
                    {
                        if(rform.getVtipomodif().equals("0"))
                            responselink = "modif";
                        if(rform.getVtipomodif().equals("1"))
                            responselink = "modif1";
                        if(rform.getVtipomodif().equals("2"))
                            responselink = "modif2";
                        call = con.prepareCall("{ ? = call pkg_acreditacion.modifica_acreditado ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?  ,?,? ,?,?) }");
                        call.registerOutParameter(1, 12);
                        call.setString(2, rform.getVcodigo());
                        call.setString(3, rform.getVnombre());
                        call.setString(4, rform.getVcite());
                        call.setString(5, rform.getVfeccite());
                        call.setString(6, rform.getVcargo());
                        call.setString(7, rform.getVcategoria());
                        call.setString(8, rform.getVfecllegada());
                        call.setString(9, rform.getVfeccese());
                        call.setString(10, usuario);
                        call.setString(11, rform.getVentidad());
                        call.setString(12, rform.getVobs());
                        call.setString(13, rform.getVtipoobs());
                        call.setString(14, rform.getVfecobs());
                        
                        call.setString(15, rform.getV_docidentidad());
                        call.setString(16, rform.getV_tipodoc());
                    }
                    call.execute();
                    res = call.getObject(1).toString();
                    con.commit();
                    modacrForm modifset = new modacrForm();
                    reginfForm regifset = new reginfForm();
                    regifset.setResp(res);
                    modifset.setCentidad(rform.getVentidad());
                    modifset.setCtipolist(rform.getVtipolist());
                    modifset.setCcodigo("");
                    request.setAttribute("modacrForm", modifset);
                    request.setAttribute("reginfForm", regifset);
                }
                catch(Exception er)
                {
                    er.printStackTrace();
                }
                finally {
                           try {
                               if (con != null)
                                   con.close();

                           } catch (SQLException er) {
                               ;
                           }
                       }
            }
        }
        return mapping.findForward(responselink);
    }
}