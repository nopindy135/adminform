/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SystemNpruPool_Admin;

import static SystemNpruPool.ConnectDB.passwordDB;
import static SystemNpruPool.ConnectDB.urlConnection;
import static SystemNpruPool.ConnectDB.usernameDB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Godonlyknows
 */
public class Admin_Registermode {
    public int r_id ;
    public int r_type;
    public String r_time;
    public String r_date;
    public int u_id;
    public int c_id;
    
        public void EditRegister(int id ,
          int uid ,int cid){
           Connection connect = null;
                Statement stmt = null;
		
		try {
                        Class.forName("com.mysql.jdbc.Driver");
                        connect = DriverManager.getConnection ( urlConnection,usernameDB,passwordDB);
			stmt = connect.createStatement();
                        String sql = "UPDATE register " +
					
                                "SET R_Type = '" + id + "' " +
                              
                                ", U_ID = '" + uid + "' " +
                                ", C_ID = '" + cid + "'"+
                               
					" WHERE R_ID = '" + id + "' ";
             stmt.execute(sql);
            
             System.out.println("Record Update Successfully");
             
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Close
		try {
			if(connect != null){
				stmt.close();
				connect.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }
    public void DeleteRegister(int rid){
         Connection connect = null;
                Statement stmt = null;
		
		try {
                        Class.forName("com.mysql.jdbc.Driver");
                        connect = DriverManager.getConnection ( urlConnection,usernameDB,passwordDB);
			stmt = connect.createStatement();
                        String sql = "DELETE FROM register " +
					" WHERE R_ID ='" + rid + "' ";
             stmt.execute(sql);
            
             System.out.println("Record Delete Member Successfully");
             
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Close
		try {
			if(connect != null){
				stmt.close();
				connect.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
