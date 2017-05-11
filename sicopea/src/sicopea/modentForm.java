// Decompiled by DJ v3.5.5.77 Copyright 2003 Atanas Neshkov  Date: 18/12/2011 1:22:43
// Home Page : http://members.fortunecity.com/neshkov/dj.html  - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   modentForm.java

package sicopea;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.*;

public class modentForm extends ActionForm
{

    public modentForm()
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

    public String getEdit()
    {
        return edit;
    }

    public void setEdit(String newEdit)
    {
        edit = newEdit;
    }

    public String getUpdate()
    {
        return update;
    }

    public void setUpdate(String newUpdate)
    {
        update = newUpdate;
    }

    public String getCod_ent()
    {
        return cod_ent;
    }

    public void setCod_ent(String newCod_ent)
    {
        cod_ent = newCod_ent;
    }

    public String getDes_ent()
    {
        return des_ent;
    }

    public void setDes_ent(String newDes_ent)
    {
        des_ent = newDes_ent;
    }

    public String getDir_ent()
    {
        return dir_ent;
    }

    public void setDir_ent(String newDir_ent)
    {
        dir_ent = newDir_ent;
    }

    public String getTel_ent()
    {
        return tel_ent;
    }

    public void setTel_ent(String newTel_ent)
    {
        tel_ent = newTel_ent;
    }

    public String getFax_ent()
    {
        return fax_ent;
    }

    public void setFax_ent(String newFax_ent)
    {
        fax_ent = newFax_ent;
    }

    public String getEmail_ent()
    {
        return email_ent;
    }

    public void setEmail_ent(String newEmail_ent)
    {
        email_ent = newEmail_ent;
    }

    public String getCcancel()
    {
        return ccancel;
    }

    public void setCcancel(String newCcancel)
    {
        ccancel = newCcancel;
    }

    public String getCdelete()
    {
        return cdelete;
    }

    public void setCdelete(String newCdelete)
    {
        cdelete = newCdelete;
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

    private String edit;
    private String update;
    private String cod_ent;
    private String des_ent;
    private String dir_ent;
    private String tel_ent;
    private String fax_ent;
    private String email_ent;
    private String ccancel;
    private String cdelete;
    private String msg;
    private String tipo;
}