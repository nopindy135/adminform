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
import javax.swing.JOptionPane;

/**
 *
 * @author Godonlyknows
 */
public class Admin_Usermode {
     public  int u_Id;
   public String u_Firstname;
   public String u_Lastname;
   public String u_Address ; 
   public String u_Birthday ;
   public int u_Age;
   public String u_CardId ;
   public int u_Type ;
   public  String u_Tel;
   //method get
   public static boolean status ;
    public int getU_Id(){
       return u_Id;
   }
    public String getU_Firstname(){
        System.out.print(u_Firstname);
       return u_Firstname;
   }
    public String getU_Lastname(){
       return u_Lastname;
   }
    public String getU_Address(){
       return u_Address;
   }
    public String getU_Birthday(){
       return u_Birthday;
   }
    public int getU_Age(){
        return u_Age;
    }
    public String getU_CardId(){
       return u_CardId;
   }
   public int getU_Type(){
       return u_Type;
   }
   public String getU_Tel(){
       return u_Tel;
   }
   public void setU_Id(int id){
       u_Id = id;
   }
   public void setU_Age(int age){
       u_Age = age;
   }
   
    public void setU_Firstanem(String firstname){
       u_Firstname = firstname;
   }
      public void setU_Lastname(String lastname){
       u_Lastname = lastname;
   }
        public void setU_Address(String address){
       u_Address = address;
   }
          public void setU_Birthday(String birthday){
       u_Birthday = birthday;
   }
            public void setU_CardId(String cardid){
       u_CardId = cardid;
   }
              public void setU_Type(int type){
       u_Type= type;
   }
              public void setU_Tel(String tel){
                  u_Tel = tel;
              }
    
    public void ShowDetailUser(){
    Connection connect = null;
		Statement stmt = null;
		
		try {
                    Class.forName("com.mysql.jdbc.Driver");
                    connect = DriverManager.getConnection ( urlConnection,usernameDB,passwordDB);
                    stmt=connect.createStatement();
			//WHERE U_ID ='" + u_id + "' 
			String sql = "SELECT * FROM  user ";
			
			ResultSet rec = stmt.executeQuery(sql);
			int row = 0;
			while((rec!=null) && (rec.next()))
            {			
		setU_Id(rec.getInt("U_Id"));                                
                setU_Firstanem(rec.getString("U_Firstname"));
                setU_Lastname(rec.getString("U_Lastname"));
                setU_Type(rec.getInt("U_Type"));
                setU_CardId(rec.getString("U_CardId"));
                setU_Tel(rec.getString("U_Tel"));
			//	model.setValueAt(rec.getFloat("Budget"), row, 4);
			//	model.setValueAt(rec.getFloat("Used"), row, 5);
				row++;
            }

			rec.close();
             
		} catch (Exception e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
		}
		
		try {
			if(stmt != null) {
				stmt.close();
				connect.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
    public void AddUser(int id , String name, String lastname, String address, String birthday, String cardId, int type, String tel){
     
       
		Connection connect = null;
                Statement stmt = null;
		
		try {
                        Class.forName("com.mysql.jdbc.Driver");
                     connect = DriverManager.getConnection ( urlConnection,usernameDB,passwordDB);
			stmt = connect.createStatement();
			String sql = "INSERT INTO user " +
					"(U_ID,U_Firstname,U_Lastname,U_Address,U_Birthday,U_Age,U_CardID,U_Type,U_Tel) " + 
					"VALUES ('" + id + "','" + name + "','" + lastname + "'"
                                + "" +
					",'" + address + "','" + birthday + "',YEAR(FROM_DAYS(DATEDIFF(NOW(),U_Birthday ))),'" + cardId + "','" + type + "','" + tel + "') ";
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
    public void EditUser(int u_Id,String name, String lastname, String address, String birthday, String cardId, int type, String tel) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                Connection connect = null;
                Statement stmt = null;
		
		try {
                        Class.forName("com.mysql.jdbc.Driver");
                        connect = DriverManager.getConnection ( urlConnection,usernameDB,passwordDB);
			stmt = connect.createStatement();
                        String sql = "UPDATE User " +
					"SET U_Firstname = '" + name + "' " +
                                ", U_Lastname = '" + lastname + "' " +
                                ", U_Address = '" + address + "' " +
                                ", U_Birthday = '" + birthday + "' " +
                                ", U_CardID = '" + cardId + "' " +
                                ", U_Type = '" + type + "' " +
                                ", U_Tel = '" + tel + "' " +
					" WHERE U_ID = '" + u_Id + "' ";
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
    public void DeleteUser(int U_Id) {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    Connection connect = null;
                Statement stmt = null;
		
		try {
                        Class.forName("com.mysql.jdbc.Driver");
                        connect = DriverManager.getConnection ( urlConnection,usernameDB,passwordDB);
			stmt = connect.createStatement();
                        String sql = "DELETE FROM user " +
					" WHERE U_ID ='" + U_Id + "' ";
             stmt.execute(sql);
            
             System.out.println("Record Delete Successfully");
             
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
        
    
    

