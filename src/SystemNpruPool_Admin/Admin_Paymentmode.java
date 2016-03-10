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
public class Admin_Paymentmode {
    public int p_id ;
    public int p_money;
    public String p_date;
    public String p_time;
    public String p_type;
    public int u_id ;
    public int st_id;
    
     public void AddPayment(int id ,
                         int money,
                         String date,
                         String time,
                         String type,
                         int uid,
                         int st_id
                         ){
        
		Connection connect = null;
                Statement stmt = null;
		
		try {
                        Class.forName("com.mysql.jdbc.Driver");
                     connect = DriverManager.getConnection ( urlConnection,usernameDB,passwordDB);
			stmt = connect.createStatement();
			String sql = "INSERT INTO payment " +
					"(P_Id,P_Money,P_Date,P_Time,P_Type,U_Id,St_Id) " + 
					"VALUES ('" + id + "','" + money + "','" + date + "'"
                                + "" +
					",'" + time + "','" + type + "','" + uid + "','" + st_id + "') ";
                         stmt.execute(sql);
             
                         System.out.println("Record User Inserted Successfully");
             
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
    public void EditPayment(int id ,
                         int money,
                         String date,
                         String time,
                         String type,
                         int uid,
                         int st_id
                         ){
         Connection connect = null;
                Statement stmt = null;
		
		try {
                        Class.forName("com.mysql.jdbc.Driver");
                        connect = DriverManager.getConnection ( urlConnection,usernameDB,passwordDB);
			stmt = connect.createStatement();
                        String sql = "UPDATE payment " +
                                "SET P_Money = '" + money + "' " +
                                ", P_Date = '" + date + "' " +
                                ", P_Time = '" + time + "' " +
                                ", P_Type = '" + type + "' " +
                                ", U_Id = '" + uid + "' " +
                                ", St_Id = '" + st_id + "' " +
					" WHERE P_Id = '" + id + "' ";
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
    public void DeletePayment(int id){
         Connection connect = null;
                Statement stmt = null;
		
		try {
                        Class.forName("com.mysql.jdbc.Driver");
                        connect = DriverManager.getConnection ( urlConnection,usernameDB,passwordDB);
			stmt = connect.createStatement();
                        String sql = "DELETE FROM payment " +
					" WHERE P_Id ='" + id + "' ";
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
