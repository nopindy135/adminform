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
public class Admin {
    int admin_id;
    String admin_username;
    String admin_password;
    String admin_firstname;
    String admin_lastname;
    String admin_cardid;
    String admin_phonenumber;
        public void ShowDetailAdmin(){
    }
    public void AddAdmin(int id ,String username,
                                  String password,
                                  String fname,
                                  String lname,
                                  String cardid,
                                  String phonenumber
                                  ){
        Connection connect = null;
                Statement stmt = null;
		
		try {
                        Class.forName("com.mysql.jdbc.Driver");
                     connect = DriverManager.getConnection ( urlConnection,usernameDB,passwordDB);
			stmt = connect.createStatement();
			String sql = "INSERT INTO admin " +
					"(Admin_ID,Admin_Username,Admin_Password,Admin_FirstName,Admin_LastName,Admin_CardID,Admin_Phonenumber) " + 
					"VALUES ('" + id + "','" + username + "','" + password + "'"
                                + "" +
					",'" + fname + "','" + lname + "','" + cardid + "','" + phonenumber + "') ";
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
    public void EditAdmin(int id ,String username,
                                  String password,
                                  String fname,
                                  String lname,
                                  String cardid,
                                  String phonenumber){
         Connection connect = null;
                Statement stmt = null;
		
		try {
                        Class.forName("com.mysql.jdbc.Driver");
                        connect = DriverManager.getConnection ( urlConnection,usernameDB,passwordDB);
			stmt = connect.createStatement();
                        String sql = "UPDATE Admin " +
					"SET Admin_ID = '" + id + "' " +
                                "SET Admin_Username = '" + username + "' " +
                                "SET Admin_Password = '" + password + "' " +
                                "SET Admin_FirstName = '" + fname + "' " +
                                "SET Admin_LastaName = '" + lname + "' " +
                                "SET Admin_CardID = '" + cardid + "' " +
                                "SET Admin_Phonenumber = '" + phonenumber + "' " +
                                
                               
					" WHERE Admin_ID = '" + id + "' ";
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
    public void DeleteAdmin(String username){
         Connection connect = null;
                Statement stmt = null;
		
		try {
                        Class.forName("com.mysql.jdbc.Driver");
                        connect = DriverManager.getConnection ( urlConnection,usernameDB,passwordDB);
			stmt = connect.createStatement();
                        String sql = "DELETE FROM admin " +
					" WHERE Admin_Username ='" + username + "' ";
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
