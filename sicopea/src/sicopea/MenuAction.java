package sicopea;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;


public class MenuAction extends Action 
{
  public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
  {
    
    MenuForm bMenu = (MenuForm) form;
    ClaseSession cs = new ClaseSession();
    request.getSession().setAttribute("ClaseSession",cs);        
   String direc="0";
   if(bMenu.getOpcion().equals("reg.inf")){
      direc="reg.inf";
   }else if(bMenu.getOpcion().equals("reg.inf2")){
      direc="reg.inf2";
   }else if(bMenu.getOpcion().equals("reg.inf617")){
      direc="reg.inf617"; 
   }else if(bMenu.getOpcion().equals("mod.acr")){
      direc="mod.acr";
   }else if(bMenu.getOpcion().equals("eli.acr")){
      direc="eli.acr";
   }else if(bMenu.getOpcion().equals("reg.ent")){
      direc="reg.ent";
   }else if(bMenu.getOpcion().equals("mod.ent")){
      direc="mod.ent";
   }else if(bMenu.getOpcion().equals("mod.acra")){
      direc="mod.acra";
   }else if(bMenu.getOpcion().equals("mod.acrc")){
      direc="mod.acrc";
   }else if(bMenu.getOpcion().equals("con.acr")){
      direc="con.acr";
   }else if(bMenu.getOpcion().equals("con.acr2")){
      direc="con.acr2";
   }else if(bMenu.getOpcion().equals("cam.usu")){
      direc="cam.usu";
       
   }else if(bMenu.getOpcion().equals("exit.ser")){   
      request.getSession().removeAttribute("ClaseUsuario");
      request.getSession().removeAttribute("inputActionForm");          
      request.getSession().removeAttribute("user.nick"); 
      request.getSession().removeAttribute("ClaseSession");
      direc="exit";
   }else{
      request.getSession().removeAttribute("ClaseUsuario");
      request.getSession().removeAttribute("inputActionForm");          
      request.getSession().removeAttribute("user.nick"); 
      request.getSession().removeAttribute("ClaseSession");
      direc="exit";
   }
   return mapping.findForward(direc);   
  }
}