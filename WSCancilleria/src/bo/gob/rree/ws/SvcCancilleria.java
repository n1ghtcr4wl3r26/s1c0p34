package bo.gob.rree.ws;

import bo.gob.rree.ent.ArrayOfEntidadInfo;
import bo.gob.rree.ent.ArrayOfPersonaInfo;
import bo.gob.rree.ent.EntidadInfo;
import bo.gob.rree.ent.PersonaInfo;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import java.net.MalformedURLException;
import java.net.URL;

import java.util.ArrayList;
import java.util.List;

import java.util.Properties;

import javax.xml.namespace.QName;
import javax.xml.ws.Holder;

public class SvcCancilleria {
    private String URL = "http://www.rree.gob.bo/WsAduana/ConsultaService.svc?wsdl";
    private String usuario = "WsAduana";
    private String passwd = "$Adu4n4*20qu1nc3";
    IPersonas svc = null;
    
    public SvcCancilleria() throws Exception{
        init();
    }
            
    private void init(){
        Properties prop = new Properties();
        InputStream input = null;
        try {
            input = new FileInputStream("/u03/oracle/user_projects/data/webServices/ws.properties");
            prop.load(input);
            URL = prop.getProperty("url_wsCancilleria");
            usuario = prop.getProperty("usuario_wsCancilleria");
            passwd = prop.getProperty("passwd_wsCancilleria");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        
        URL url=null, baseUrl = null;
        baseUrl = Personas.class.getResource(".");
        try {
            url = new URL(baseUrl, URL);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
                
        QName namespace = new QName("http://tempuri.org/", "Personas");
        Personas personas = new Personas(url, namespace);
        //Personas personas = new Personas();
        svc = personas.getBasicHttpBindingIPersonas();
    }
    
    public List<PersonaInfo> getAcreditados(String dni,
                                            String nombreCompleto,
                                            int inicio,
                                            int cantidad,
                                            int total) throws Exception {
        List<PersonaInfo> result = null;
        Holder<Integer> holderTotal = new Holder<Integer>(total);
        Holder<ArrayOfPersonaInfo> holder = new Holder<ArrayOfPersonaInfo>();
        svc.getAcreditados(dni, nombreCompleto, inicio, cantidad, holderTotal, usuario, passwd, holder);
        if(holder.value == null){
            result = new ArrayList<PersonaInfo>();
        } else{
            result = holder.value.getPersonaInfo();    
        }
        return result;
    }
    
    public List<EntidadInfo> getDirectorio(String nombre,
                                           int codigo,
                                           int inicio,
                                           int cantidad,
                                           int total) throws Exception{
        List<EntidadInfo> result = null;
        Holder<Integer> holderTotal = new Holder<Integer>(total);
        Holder<ArrayOfEntidadInfo> holder = new Holder<ArrayOfEntidadInfo>();
        svc.getDirectorio(nombre, codigo, inicio, cantidad, holderTotal, usuario, passwd, holder);
        if(holder.value == null){
            result = new ArrayList<EntidadInfo>();
        }else{
            result = holder.value.getEntidadInfo();    
        }
        return result;
    }
    
}
