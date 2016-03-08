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
public class Admin_Trainermode {
    int t_id ;
    String t_name;
    int t_age ;
    String t_code;
    String t_tel;
    String t_work_date;
    String t_work_time ;
    public  int gett_id(){
        return t_id;
    }
    public void sett_id(int id){
        t_id=id;
    }
     public  String gett_name(){
        return t_name;
    }
    public void sett_name(String name){
        t_name=name;
    }
     public  int gett_age(){
        return t_age;
    }
    public void sett_age(int a){
        t_age=a;
    }
     public  String gett_code(){
        return t_code;
    }
    public void sett_code(String code){
         t_code=code;
    }
     public  String gett_tel(){
        return t_tel;
    }
    public void sett_tel(String tel){
        t_tel=tel;
    }
     public  String gett_work_date(){
        return t_work_date;
    }
    public void sett_work_date(String work_date){
        t_work_date = work_date;
    }
       public  String gett_work_time(){
        return t_work_time;
    }
    public void sett_work_time(String work_time){
        t_work_date = work_time;
    }

    public void ShowDetailTrainer(){
    
    }
    public void AddTrainer(int id ,String name,
                                    int age,
                                    String code,
                                    String tel,
                                    String work_date,
                                    String work_time){
        Connection connect = null;
                Statement stmt = null;
		
		try {
                        Class.forName("com.mysql.jdbc.Driver");
                     connect = DriverManager.getConnection ( urlConnection,usernameDB,passwordDB);
			stmt = connect.createStatement();
			String sql = "INSERT INTO trainer " +
                                     "(T_ID,T_Name,T_Age,T_Code,T_Tel,T_Work_Date,T_Work_Time) " + 
                                     "VALUES ('" + id + "','" + name + "','" + age + "'"
                                     + "" +
                                     ",'" + code + "','" + tel + "','" + work_date + "','" + work_time + "') ";
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
    public void EditTrainer(int id ,String name,
                                    int age,
                                    String code,
                                    String tel,
                                    String work_date,
                                    String work_time){
        Connection connect = null;
                Statement stmt = null;
		
		try {
                        Class.forName("com.mysql.jdbc.Driver");
                        connect = DriverManager.getConnection ( urlConnection,usernameDB,passwordDB);
			stmt = connect.createStatement();
                        String sql = "UPDATE trainer " +
					"SET T_ID = '" + id + "' " +
                                "SET T_Name = '" + name + "' " +
                                "SET T_Age = '" + age + "' " +
                                "SET T_Code = '" + code + "' " +
                                "SET T_Tel = '" + tel + "' " +
                                   "SET T_Work_Date = '" + work_date + "' " +
                                   "SET T_Work_Time = '" + work_time + "' " +
					" WHERE T_ID = '" + id + "' ";
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
    public void DeleteTrainer(int id){
         Connection connect = null;
                Statement stmt = null;
		
		try {
                        Class.forName("com.mysql.jdbc.Driver");
                        connect = DriverManager.getConnection ( urlConnection,usernameDB,passwordDB);
			stmt = connect.createStatement();
                        String sql = "DELETE FROM trainer " +
					" WHERE T_ID ='" + id + "' ";
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
