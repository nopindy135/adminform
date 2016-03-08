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
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Godonlyknows
 */
public class CheckConnetDB {

    public void CC(){
       
 
                    

                
    }
    	public  void CheckConnect(){
		Connection connect = null;
                Statement stmt = null;
		
		try {

Class.forName("com.mysql.jdbc.Driver");
connect = DriverManager.getConnection ( urlConnection,usernameDB,passwordDB);
stmt=connect.createStatement();

			if(connect != null){
				System.out.println("Database Connect ");
			} else {
				System.out.println("Database Connect Failed.");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Close
		try {
			if(connect != null){
				connect.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
           	public  boolean CheckConnect1(){
		Connection connect = null;
                Statement stmt = null;
		boolean ch = false ;
		try {

Class.forName("com.mysql.jdbc.Driver");
connect = DriverManager.getConnection ( urlConnection,usernameDB,passwordDB);
stmt=connect.createStatement();

			if(connect != null){
				System.out.println("Database Connect ");
                                ch =true;
			} else {
				System.out.println("Database Connect Failed.");
                                ch=false;
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Close
		try {
			if(connect != null){
				connect.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ch;
	}

}