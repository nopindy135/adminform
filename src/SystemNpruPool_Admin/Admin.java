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
import java.sql.ResultSet;
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

    public int getAdmin_id() {
        return admin_id;
    }

    public String getAdmin_username() {
        return admin_username;
    }

    public String getAdmin_password() {
        return admin_password;
    }

    public String getAdmin_firstname() {
        return admin_firstname;
    }

    public String getAdmin_lastname() {
        return admin_lastname;
    }

    public String getAdmin_cardid() {
        return admin_cardid;
    }

    public String getAdmin_phonenumber() {
        return admin_phonenumber;
    }

    public void setAdmin_id(int admin_id) {
        this.admin_id = admin_id;
    }

    public void setAdmin_username(String admin_username) {
        this.admin_username = admin_username;
    }

    public void setAdmin_password(String admin_password) {
        this.admin_password = admin_password;
    }

    public void setAdmin_firstname(String admin_firstname) {
        this.admin_firstname = admin_firstname;
    }

    public void setAdmin_lastname(String admin_lastname) {
        this.admin_lastname = admin_lastname;
    }

    public void setAdmin_cardid(String admin_cardid) {
        this.admin_cardid = admin_cardid;
    }

    public void setAdmin_phonenumber(String admin_phonenumber) {
        this.admin_phonenumber = admin_phonenumber;
    }
    public boolean CheckAdmin(String user , String pass){ 
        Connection connect = null;
    boolean ch =false  ;
                Statement stmt = null;
		
		try {

                    Class.forName("com.mysql.jdbc.Driver");
                    connect = DriverManager.getConnection ( urlConnection,usernameDB,passwordDB);
                    stmt=connect.createStatement();
		
             
			
			
			String sql = "SELECT Admin_Username,Admin_Password FROM admin WHERE Admin_Username ='" + user + "' and Admin_Password ='" + pass + "'   ";
			
			ResultSet rec = stmt.executeQuery(sql);
                        
			while((rec!=null) && (rec.next()))
            {
                String chid = rec.getString("Admin_Username");
                String chpass = rec.getString("Admin_Password");
                        if(chid.equals(user)  && pass.equals(chpass)){
                            ch = true;
                          //  setSt_Id(rec.getInt("St_ID"));
                          //  setSt_Password(rec.getString("St_Password"));
                        }
                        else {
                            ch=false;
                        }
            }
             
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
                return  ch ;
    }
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
					
                               // "SET Admin_Username = '" + username + "' " +
                                "SET Admin_Password = '" + password + "' " +
                                ", Admin_FirstName = '" + fname + "' " +
                                ", Admin_LastName = '" + lname + "' " +
                                ", Admin_CardID = '" + cardid + "' " +
                                ", Admin_Phonenumber = '" + phonenumber + "' " +
                                
                               
					" WHERE Admin_Username = '" + username + "' ";
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
