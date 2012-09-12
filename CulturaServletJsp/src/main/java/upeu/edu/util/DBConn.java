/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package upeu.edu.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.postgresql.Driver;

public class DBConn {

    public Connection con=null;
    public PreparedStatement ps=null;
    public ResultSet rs=null;
    public int i=0;

    public void getConexionDB() {
        try {
            if (con==null){
            DriverManager.registerDriver(new Driver());
            con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/cultura", "cultura", "123456");
            
            System.out.println("conexion exitosa");
            }
            } catch (Exception e) {
                System.out.println("error de conexion"+e.getMessage());
        }

    }
    public void getCerrarConexion(){
        
        try {
            if(rs!=null){rs.close();}
            if(ps!=null){ps.close();}
            if(con!=null){con.close();}
                        
        } catch (Exception e) {
        }
    }
}
