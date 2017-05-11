// Decompiled by DJ v3.5.5.77 Copyright 2003 Atanas Neshkov  Date: 18/12/2011 1:28:38
// Home Page : http://members.fortunecity.com/neshkov/dj.html  - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   ClaseSql.java

package sicopea;

import java.io.PrintStream;
import java.sql.*;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.sql.PooledConnection;
import oracle.jdbc.pool.OracleConnectionPoolDataSource;

public class ClaseSql
{

    public ClaseSql()
    {
        pc = null;
        cn = null;
        st = null;
    }

    public void getConexion()
        throws NamingException, SQLException
    {
        InitialContext ic = new InitialContext();
        OracleConnectionPoolDataSource pd = (OracleConnectionPoolDataSource)ic.lookup("jdbc/sicopea");
        pc = pd.getPooledConnection();
        cn = pc.getConnection();
        st = cn.createStatement();
    }

    private void getClose()
    {
        try
        {
            if(st != null)
                st.close();
            if(cn != null)
                cn.close();
            if(pc != null)
                pc.close();
            pc = null;
            cn = null;
            st = null;
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }

    public void pAccesoDatos(HttpServletRequest request, int opcion)
        throws Exception
    {
        try
        {
            getConexion();
            int _tmp = opcion;
        }
        catch(Exception e)
        {
            throw new Exception(e.getMessage());
        }
        finally
        {
            getClose();
        }
    }

    private PooledConnection pc;
    private Connection cn;
    private Statement st;
}