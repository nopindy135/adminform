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
public class Admin_Staffmode {
        public  int St_Id;
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
     public void ShowDetailStaff(){
    
    }
    public void AddStaff(int id ,
                         String password,
                         String name,
                         String age,
                         String workday,
                         String start_date,
                         String start_time,
                         String end_time){
        
		Connection connect = null;
                Statement stmt = null;
		
		try {
                        Class.forName("com.mysql.jdbc.Driver");
                     connect = DriverManager.getConnection ( urlConnection,usernameDB,passwordDB);
			stmt = connect.createStatement();
			String sql = "INSERT INTO staff " +
					"(St_ID,St_Password,St_Name,St_Age,St_WorkDay,St_Startdate,St_Start_Time,St_End_Time) " + 
					"VALUES ('" + id + "','" + password + "','" + name + "'"
                                + "" +
					",'" + age + "','" + workday + "','" + start_date + "','" + start_time + "','" + end_time + "') ";
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
    public void EditStaff(int id ,
                         String password,
                         String name,
                         String age,
                         String workday,
                         String start_date,
                         String start_time,
                         String end_time){
         Connection connect = null;
                Statement stmt = null;
		
		try {
                        Class.forName("com.mysql.jdbc.Driver");
                        connect = DriverManager.getConnection ( urlConnection,usernameDB,passwordDB);
			stmt = connect.createStatement();
                        String sql = "UPDATE staff " +
					"SET St_ID = '" + id + "' " +
                                "SET St_Password = '" + password + "' " +
                                "SET St_Name = '" + name + "' " +
                                "SET St_Age = '" + age + "' " +
                                "SET St_Workday = '" + workday + "' " +
                                "SET St_Startdate = '" + start_date + "' " +
                                "SET St_Start_Time = '" + start_time + "' " +
                                "SET St_End_Time = '" + end_time + "' " +
					" WHERE St_ID = '" + id + "' ";
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
    public void DeleteStaff(int id){
         Connection connect = null;
                Statement stmt = null;
		
		try {
                        Class.forName("com.mysql.jdbc.Driver");
                        connect = DriverManager.getConnection ( urlConnection,usernameDB,passwordDB);
			stmt = connect.createStatement();
                        String sql = "DELETE FROM staff " +
					" WHERE St_ID ='" + id + "' ";
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
