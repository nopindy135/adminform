/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SystemNpruPool;

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
public class Staff {
    public static int St_Id;
    public String St_Password;
    public String St_Name ;
    public String St_Age; 
    public String St_Workday;
    public String St_Startday;
    public String St_Start_Time;
    public String St_End_Time; 
    
    public  int getSt_Id(){
       return  St_Id;
    }
    public String getSt_Password(){
        return St_Password;
    }
    public void setSt_Id(int stid){
        St_Id = stid;
    }
    public void setSt_Password(String Stpassword){
        St_Password = Stpassword;
    }
    public boolean CheckLogin(int id,String passWord){
          Connection connect = null;
    boolean ch =false  ;
                Statement stmt = null;
		
		try {

                    Class.forName("com.mysql.jdbc.Driver");
                    connect = DriverManager.getConnection ( urlConnection,usernameDB,passwordDB);
                    stmt=connect.createStatement();
		
             
			
			
			String sql = "SELECT St_ID,St_Password FROM staff WHERE St_ID ='" + id + "' and St_Password ='" + passWord + "'   ";
			
			ResultSet rec = stmt.executeQuery(sql);
                        
			while((rec!=null) && (rec.next()))
            {
                int chid = rec.getInt("St_ID");
                String chpass = rec.getString("St_Password");
                        if(chid == id && passWord.equals(chpass)){
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
     public boolean CheckStaff(int id){
          Connection connect = null;
    boolean ch =false  ;
                Statement stmt = null;
		
		try {

                    Class.forName("com.mysql.jdbc.Driver");
                    connect = DriverManager.getConnection ( urlConnection,usernameDB,passwordDB);
                    stmt=connect.createStatement();
		
             
			
			
			String sql = "SELECT * FROM staff WHERE St_ID ='" + id + "'";
			
			ResultSet rec = stmt.executeQuery(sql);
                        
			while((rec!=null) && (rec.next()))
            {
                int chid = rec.getInt("St_ID");
               // String chpass = rec.getString("St_Password");
                        if(chid == id ){
                            ch = true;
                            setSt_Id(rec.getInt("St_ID"));
                            System.out.println("st on select id = "+getSt_Id());
                            
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
     public boolean ChackStaff_Id(int id ){
          Connection connect = null;
    boolean ch =false  ;
                Statement stmt = null;
		
		try {

                    Class.forName("com.mysql.jdbc.Driver");
                    connect = DriverManager.getConnection ( urlConnection,usernameDB,passwordDB);
                    stmt=connect.createStatement();
		
             
			
			
			String sql = "SELECT * FROM staff WHERE St_ID ='" + id + "'";
			
			ResultSet rec = stmt.executeQuery(sql);
                        
			while((rec!=null) && (rec.next()))
            {
                int chid = rec.getInt("St_ID");
               // String chpass = rec.getString("St_Password");
                        if(chid == id ){
                            ch = true;
                            //setSt_Id(rec.getInt("St_ID"));
                          //  System.out.println("st on select id = "+getSt_Id());
                            
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
     
}


