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
public class Admin_Membermode {
    int m_id;
    int u_id;
    String m_type;
    String m_start;
    String m_end;
       public void ShowDetailMember(){
    
    }
    public void AddMember(int mid ,int uid,
                                    String type,
                                    String start,
                                    String end){
        Connection connect = null;
                Statement stmt = null;
		
		try {
                        Class.forName("com.mysql.jdbc.Driver");
                     connect = DriverManager.getConnection ( urlConnection,usernameDB,passwordDB);
			stmt = connect.createStatement();
			String sql = "INSERT INTO member " +
					"(M_Id,U_ID,M_Type,M_Start,M_End) " + 
					"VALUES ('" + mid + "','" + uid + "','" + type + "'"
                                + "" +
					",'" + start + "','" + end + "') ";
                         stmt.execute(sql);
             
                         System.out.println("Record Member Inserted Successfully");
             
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
    public void EditMember(int mid ,int uid,
                                    String type,
                                    String start,
                                    String end){
        	Connection connect = null;
                Statement stmt = null;
		
		try {
                        Class.forName("com.mysql.jdbc.Driver");
                        connect = DriverManager.getConnection ( urlConnection,usernameDB,passwordDB);
			stmt = connect.createStatement();
                        String sql = "UPDATE member " +
					
                                "SET , = '" + uid + "' " +
                                "SET , = '" + type + "' " +
                                "SET , = '" + start + "' " +
                                "SET , = '" + end + "' " +
					" WHERE U_ID = '" + uid + "' ";
             stmt.execute(sql);
            
             System.out.println("Record Update Member Successfully");
             
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
    public void DeleteMember(int mid){
          Connection connect = null;
                Statement stmt = null;
		
		try {
                        Class.forName("com.mysql.jdbc.Driver");
                        connect = DriverManager.getConnection ( urlConnection,usernameDB,passwordDB);
			stmt = connect.createStatement();
                        String sql = "DELETE FROM member " +
					" WHERE M_Id ='" + mid + "' ";
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

