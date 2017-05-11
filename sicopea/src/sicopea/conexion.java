package sicopea;

import java.sql.*;

import java.util.Vector;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import javax.sql.DataSource;

import oracle.jdbc.pool.OracleConnectionPoolDataSource;
import oracle.jdbc.pool.OraclePooledConnection;
import oracle.jdbc.driver.OracleConnection;

public class conexion 
{
    public Connection cn=null;
    public Statement st=null;    
  public conexion(){
  }
  public Connection abrirConexion() throws SQLException, NamingException {

    /*InitialContext ic = new InitialContext();
    OracleConnectionPoolDataSource pd = (OracleConnectionPoolDataSource) ic.
    lookup("jdbc/regpad");
    OraclePooledConnection pc = (OraclePooledConnection) pd.getPooledConnection();

    return pc.getConnection();*/
    InitialContext ic = new InitialContext();
    DataSource ds;
    ds=(DataSource)ic.lookup("jdbc/sicopea");
    cn=ds.getConnection();
    st=cn.createStatement();
    return cn;      
  }

  public ResultSet pQuery(Connection cn, String Consulta) throws SQLException, NamingException {
    PreparedStatement pt = null;
    ResultSet rs = null;

      cn.setAutoCommit(false);

      pt = cn.prepareStatement(Consulta);
      rs = pt.executeQuery();

      //System.out.println("entro al next " + Consulta);
      if (!(rs == null)) {
        return rs;
      }
      else {
        return null;
      }
  }

  public int pGraba(Connection cn, String Consulta) throws SQLException, NamingException {
    java.sql.PreparedStatement pt = null;
    java.sql.ResultSet rs = null;
    int i;

    cn.setAutoCommit(false);

    pt = cn.prepareStatement(Consulta);
    i = pt.executeUpdate( );
    cn.commit();
    return i;
  }

  public void Cierra(Connection cn, ResultSet rs){
    try {
      if (! (rs == null)) {
        rs.close();
      }
      if (! (cn == null)) {
        cn.close();
      }
    }
    catch (SQLException e) {
    }
  }

}