// Decompiled by DJ v3.5.5.77 Copyright 2003 Atanas Neshkov  Date: 18/12/2011 1:25:50
// Home Page : http://members.fortunecity.com/neshkov/dj.html  - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   impacr2Form.java

package sicopea;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.*;

public class impacr2Form extends ActionForm
{

    public impacr2Form()
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

    public String getBotonimp()
    {
        return botonimp;
    }

    public void setBotonimp(String newBotonimp)
    {
        botonimp = newBotonimp;
    }

    public String getBotonimp2()
    {
        return botonimp2;
    }

    public void setBotonimp2(String newBotonimp2)
    {
        botonimp2 = newBotonimp2;
    }

    private String botonimp;
    private String botonimp2;
}