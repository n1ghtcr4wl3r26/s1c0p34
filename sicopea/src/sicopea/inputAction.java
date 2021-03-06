package sicopea;


import cliente.ClaseEnvio;
import cliente.ServiciosUsuario;

import cliente.bean.ClaseOpcion;
import cliente.bean.ClaseUsuario;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessages;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import org.xml.sax.InputSource;


//******


//******

//**modificacion 16112015 edgar arteaga, para recuperar datos de cancilleria
//import bo.gob.aduana.cancilleria.ws.SvcCancilleria;
public class inputAction extends Action {

    private String GetTagXML(Document doc, String tag) {
        try {
            NodeList listaNodosHijos = doc.getElementsByTagName(tag);
            return listaNodosHijos.item(0).getFirstChild().getNodeValue();
        } catch (Exception e) {
            return "";
        }
    }

    private String GetTagXML(Element doc, String tag) {
        try {
            return (doc.getElementsByTagName(tag).item(0).getFirstChild().getNodeValue());
        } catch (Exception e) {
            return "";
        }
    }

    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                 HttpServletResponse response) throws IOException, ServletException {
        request.getSession().removeAttribute("ClaseSession");
        request.getSession().removeAttribute("ClaseUsuario");
        request.getSession().removeAttribute("inputActionForm");
        request.getSession().removeAttribute("user.nick");       
        inputActionForm login = (inputActionForm)form;
        request.getSession().setAttribute("inputActionForm", login);
        ActionMessages mensaje = new ActionMessages();
        try {
            ServiciosUsuario serviciosUsuario = new ServiciosUsuario();
            ClaseEnvio claseEnvio = serviciosUsuario.getServiciosUsuario();
            List<ClaseOpcion> lista = new ArrayList<ClaseOpcion>();

            //****** INI AUTENTICACION CON EL VIRTUAL
            String xmlv = "";
            String vparam = request.getParameter("vsessionid");
            DocumentBuilderFactory factoryv = DocumentBuilderFactory.newInstance();
            DocumentBuilder builderv = factoryv.newDocumentBuilder();
            if (vparam != null) {
                try {
                    xmlv = claseEnvio.fUsuarioVirtual(vparam);
                    Document doc = builderv.parse(new InputSource(new StringReader(xmlv)));
                    doc.getDocumentElement().normalize();
                    login.setUsuario(GetTagXML(doc, "Usuario"));
                    login.setClave(GetTagXML(doc, "Clave"));
                } catch (Exception ex) {
                    ;
                }
            }
            //***** FIN AUTENTICACION CON EL VIRTUAL
            String xml =
                claseEnvio.listaOpcionesXML(login.getUsuario().toUpperCase(), login.getClave(), "SICOPEA"); // (USUARIO,CLAVE, NOMBRE DEL SISTEMA)
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new InputSource(new StringReader(xml)));
            doc.getDocumentElement().normalize();
            String Usuario = GetTagXML(doc, "Usuario");
            String Perfil = GetTagXML(doc, "Perfil");
            ClaseUsuario cs = new ClaseUsuario();
            request.getSession().setAttribute("ClaseUsuario", cs);
            cs.setUsuario(login.getUsuario().toUpperCase());
            
            //***Definir la version de los assets de javascrip***
            Properties prop = new Properties();
            InputStream in = getClass().getResourceAsStream("ApplicationResources.properties");
            prop.load(in);
            String assets = prop.getProperty("system.version.assets");
            request.getSession().setAttribute("VERSION_ASSETS", assets);
            //***
            
            cs.setPerfil(GetTagXML(doc, "Perfil"));
            String prueba = GetTagXML(doc, "Usuario");
            request.getSession().setAttribute("user.nick", login.getUsuario().toUpperCase());
            request.getSession().setAttribute("user", login.getUsuario().toUpperCase());
            request.getSession().setAttribute("nombre", GetTagXML(doc, "Usuario"));
            request.getSession().setAttribute("user.perfil", GetTagXML(doc, "Perfil"));
            request.getSession().setAttribute("user.codent", GetTagXML(doc, "Aduana"));
            request.getSession().setAttribute("ops", "A");
            Integer sw = 0;
            login.getOpciones().clear();
            login.setOpciones(new ArrayList());
            NodeList OpcionesLista =
                ((Element)doc.getElementsByTagName("Opciones").item(0)).getElementsByTagName("Opcion");
            if (OpcionesLista != null) {
                sw = 1;
                for (int i = 0; i < OpcionesLista.getLength(); i++) {
                    Element itemOpcion = (Element)OpcionesLista.item(i);
                    ClaseOpcion bean = new ClaseOpcion();
                    bean.setCodopc(GetTagXML(itemOpcion, "Codigo"));
                    bean.setDesc(GetTagXML(itemOpcion, "Descripcion"));
                    bean.setCodant(GetTagXML(itemOpcion, "NivelSuperior"));
                    bean.setAccion(GetTagXML(itemOpcion, "Accion"));
                    login.getOpciones().add(bean);
                    if (GetTagXML(itemOpcion, "Codigo").equals("23")) {
                        sw = 2;
                    }
                }
            }

            if (sw == 1) {
                ClaseOpcion bean = new ClaseOpcion();
                bean.setCodopc("23");
                bean.setDesc("Cambiar Contrase&ntilde;a");
                bean.setCodant("2");
                bean.setAccion("cam.usu");
                login.getOpciones().add(bean);
            }
            return mapping.findForward("ok");
        } catch (Exception e) {
            login.setFmensaje(util.creamensaje("2", "No es posible autentificar el usuario y clave", "20"));
            request.setAttribute("inputActionForm", login);
        } finally {
            if (!mensaje.isEmpty()) {
                saveErrors(request, mensaje);
            }
        }
        return mapping.findForward("nook");
    }
}