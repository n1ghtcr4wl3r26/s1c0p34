// Decompiled by DJ v3.5.5.77 Copyright 2003 Atanas Neshkov  Date: 18/12/2011 1:24:05
// Home Page : http://members.fortunecity.com/neshkov/dj.html  - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   JsonDB.java

package sicopea;

import java.io.PrintStream;
import java.sql.*;

// Referenced classes of package sicopea:
//            conexion

public class JsonDB
{

    public JsonDB()
        throws Exception
    {
    }

    public String getMarcas(String p_merca)
    {
        conexion dc = new conexion();
        Connection cn = null;
        ResultSet rs = null;
        StringBuffer json = new StringBuffer();
        StringBuffer qbe = new StringBuffer();
        qbe.append("select me3_cod,me3_dsc from davbkp.unme3tab ");
        qbe.append(" where me3_me2=1 and me3_me1 = " + p_merca);
        qbe.append(" order by me3_cod");
        try
        {
            cn = dc.abrirConexion();
            rs = dc.pQuery(cn, qbe.toString());
            if(rs.next())
            {
                json.append("[");
                String coma = "";
                do
                {
                    json.append(coma + "{ value: \"" + rs.getString(1) + "\", label: \"" + rs.getString(2) + "\" }");
                    coma = ",";
                } while(rs.next());
                json.append("]");
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                if(rs != null)
                    rs.close();
                if(cn != null)
                    cn.close();
            }
            catch(SQLException sqlexception) { }
        }
        return json.toString();
    }

    public String getModelos(String p_merca, String p_marca)
    {
        conexion dc = new conexion();
        Connection cn = null;
        ResultSet rs = null;
        StringBuffer json = new StringBuffer();
        StringBuffer qbe = new StringBuffer();
        qbe.append("SELECT me3_cod, me3_dsc from davbkp.unme3tab ");
        qbe.append(" where me3_me1=" + p_merca + " and me3_me2=4 and dep_cod=" + p_marca);
        qbe.append(" order by me3_cod");
        try
        {
            cn = dc.abrirConexion();
            rs = dc.pQuery(cn, qbe.toString());
            if(rs.next())
            {
                json.append("[");
                String coma = "";
                do
                {
                    json.append(coma + "{ value: \"" + rs.getString(1) + "\", label: \"" + rs.getString(2) + "\" }");
                    coma = ",";
                } while(rs.next());
                json.append("]");
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                if(rs != null)
                    rs.close();
                if(cn != null)
                    cn.close();
            }
            catch(SQLException sqlexception) { }
        }
        return json.toString();
    }

    public String getMarcasMO(String p_merca, String p_marca)
    {
        conexion dc = new conexion();
        Connection cn = null;
        ResultSet rs = null;
        StringBuffer json = new StringBuffer();
        StringBuffer qbe = new StringBuffer();
        qbe.append("select me3_cod,me3_dsc from davbkp.unme3tab ");
        qbe.append(" where me3_me2=1 and me3_me1 = " + p_merca);
        qbe.append(" and me3_cod=" + p_marca);
        System.out.println(qbe.toString());
        try
        {
            cn = dc.abrirConexion();
            rs = dc.pQuery(cn, qbe.toString());
            if(rs.next())
            {
                json.append("[");
                String coma = "";
                do
                {
                    json.append(coma + "{ value: \"" + rs.getString(1) + "\", label: \"" + rs.getString(2) + "\" }");
                    coma = ",";
                } while(rs.next());
                json.append("]");
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                if(rs != null)
                    rs.close();
                if(cn != null)
                    cn.close();
            }
            catch(SQLException sqlexception) { }
        }
        return json.toString();
    }

    public String getModelosMO(String p_merca, String p_marca, String p_modelo)
    {
        conexion dc = new conexion();
        Connection cn = null;
        ResultSet rs = null;
        StringBuffer json = new StringBuffer();
        StringBuffer qbe = new StringBuffer();
        qbe.append("SELECT me3_cod, me3_dsc from davbkp.unme3tab ");
        qbe.append(" where me3_me1=" + p_merca + " and me3_me2=4 and dep_cod=" + p_marca);
        qbe.append(" and me3_cod=" + p_modelo);
        try
        {
            cn = dc.abrirConexion();
            rs = dc.pQuery(cn, qbe.toString());
            if(rs.next())
            {
                json.append("[");
                String coma = "";
                do
                {
                    json.append(coma + "{ value: \"" + rs.getString(1) + "\", label: \"" + rs.getString(2) + "\" }");
                    coma = ",";
                } while(rs.next());
                json.append("]");
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                if(rs != null)
                    rs.close();
                if(cn != null)
                    cn.close();
            }
            catch(SQLException sqlexception) { }
        }
        return json.toString();
    }

    public String getRegistra(String prm_entidad, String prm_cite, String prm_feccite, String prm_nombre, String prm_cargo, String prm_categoria, String prm_fecllegada, 
            String prm_feccese)
    {
        conexion dc = new conexion();
        Connection cn = null;
        StringBuffer json = new StringBuffer();
        StringBuffer qbe = new StringBuffer();
        qbe.append("INSERT INTO acreditacion VALUES ('104', 'juan perez', 'cite hghdsgf', ");
        qbe.append(" to_date('01/01/2010','DD/MM/YYYY'), 'consultor','1', ");
        qbe.append(" to_date('01/02/2010','DD/MM/YYYY'),to_date('01/12/2010','DD/MM/YYYY'), ");
        qbe.append(" SYSDATE,0,'U','earteaga',SYSDATE,'" + prm_entidad + "')");
        try
        {
            cn = dc.abrirConexion();
            int res = dc.pGraba(cn, qbe.toString());
            if(res >= 0)
            {
                json.append("[");
                json.append("{ value: \"Registro grabado satisfactoriamente.\", label: \"Registro grabado satisfactoriamente.\" }");
                json.append("]");
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                if(cn != null)
                    cn.close();
            }
            catch(SQLException sqlexception) { }
        }
        return json.toString();
    }
}