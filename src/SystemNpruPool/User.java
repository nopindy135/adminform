/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SystemNpruPool;
import static SystemNpruPool.ConnectDB.passwordDB;
import static SystemNpruPool.ConnectDB.urlConnection;
import static SystemNpruPool.ConnectDB.usernameDB;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Date;
/**
 *
 * @author Godonlyknows
 */
public class User extends U_System{
   public static int u_Id;
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
    public void ShowUser(){
		Connection connect = null;
                Statement stmt = null;
		
		try {
Class.forName("com.mysql.jdbc.Driver");

connect = DriverManager.getConnection ( urlConnection,usernameDB,passwordDB);
stmt=connect.createStatement();
		
             
			
			
			String sql = "SELECT *FROM user JOIN payment WHERE user.U_Id = payment.U_Id ; ";
			
			ResultSet rec = stmt.executeQuery(sql);
			
			while((rec!=null) && (rec.next()))
            {
             
               u_Id= rec.getInt("U_Id");
               u_Firstname =rec.getString("U_Firstname");
               u_Lastname = rec.getString("U_Lastname");
               u_Type = rec.getInt("U_Type");
               u_CardId = rec.getString("U_CardId");
               u_Tel = rec.getString("U_Tel");
                       
             //pay_Id = rec.getInt("P_Id");
            // pay_Type = rec.getString("P_Type");
           //  pay_Money  = rec.getInt("P_Money");
                 System.out.print(rec.getString("U_Id"));   
                System.out.print(" - ");
                System.out.print(rec.getString("U_Firstname"));
                System.out.print(" - ");
                System.out.print(rec.getString("U_Lastname"));
                System.out.print(" - ");
                System.out.print(rec.getString("P_Money"));
                System.out.print(" - ");
                System.out.print(rec.getString("U_Address"));
                System.out.print(" - ");
                System.out.print(rec.getDate("U_Birthday"));
                System.out.print(" - ");
                System.out.print(rec.getString("U_CardId"));
                System.out.print(" - ");
                System.out.print(rec.getInt("U_Type"));
                System.out.print(" - ");
                System.out.print(rec.getString("U_Tel"));
                System.out.print(" - ");
                System.out.print(rec.getInt("P_Id"));
                System.out.print(" - ");
                System.out.print(rec.getInt("P_Money"));
                System.out.print(" - ");
                System.out.print(rec.getString("P_Type"));
                System.out.println("");
            }
           
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			stmt.close();
			connect.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

}
    

public boolean  CheckUser(int u_id){
    Connection connect = null;
    boolean ch =false  ;
                Statement stmt = null;
		
		try {

Class.forName("com.mysql.jdbc.Driver");
connect = DriverManager.getConnection ( urlConnection,usernameDB,passwordDB);
stmt=connect.createStatement();
		
             
			
			
			String sql = "SELECT * FROM user WHERE U_ID ='" + u_id + "'  ";
			
			ResultSet rec = stmt.executeQuery(sql);
                    
			
		
          
             
    
                       
			while((rec!=null) && (rec.next()))
            {
                        if(rec.getInt("U_ID") == u_id ){
                            ch = true;
                          //  u_Firstname = rec.getString("U_Firstname");
                             //   System.out.println(u_Firstname);
                          //   System.out.print("befor"+u_Firstname);
                            setU_Firstanem(rec.getString("U_Firstname"));
                            setU_Lastname(rec.getString("U_Lastname"));
                            setU_Address(rec.getString("U_Address"));
                            setU_Birthday(rec.getString("U_Birthday"));
                            setU_CardId(rec.getString("U_CardId"));
                            setU_Type(rec.getInt("U_Type"));
                            setU_Tel(rec.getString("U_Tel"));
                            setU_Age(rec.getInt("U_Age"));
                           //     System.out.print("after"+u_Firstname);
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
public boolean CheckU_Id(int u_id){
     Connection connect = null;
    boolean ch =false  ;
                Statement stmt = null;
		
		try {

Class.forName("com.mysql.jdbc.Driver");
connect = DriverManager.getConnection ( urlConnection,usernameDB,passwordDB);
stmt=connect.createStatement();
		
             
			
			
			String sql = "SELECT * FROM user WHERE U_ID ='" + u_id + "'  ";
			
			ResultSet rec = stmt.executeQuery(sql);
                    
			
		
          
             
    
                       
			while((rec!=null) && (rec.next()))
            {
                if(rec.getInt("U_ID") !=u_id){
                    ch= false;
                }
                else{
                    ch= true;
                }
            }
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
                return ch;
}

    public void InsertUser(int id , String name, String lastname, String address, String birthday, String cardId, int type, String tel) {
       
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

    @Override
    public void UpdateUser(String u_Id,String name, String lastname, String address, String birthday, String cardId, int type, String tel) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   	Connection connect = null;
                Statement stmt = null;
		
		try {
                        Class.forName("com.mysql.jdbc.Driver");
                        connect = DriverManager.getConnection ( urlConnection,usernameDB,passwordDB);
			stmt = connect.createStatement();
                        String sql = "UPDATE User " +
					"SET U_Firstname = '" + name + "' " +
                                "SET U_Lirstname = '" + lastname + "' " +
                                "SET U_Address = '" + address + "' " +
                                "SET U_Birthday = '" + birthday + "' " +
                                "SET U_CardID = '" + cardId + "' " +
                                "SET U_Type = '" + type + "' " +
                                "SET U_Tel = '" + tel + "' " +
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
      public void InsertMember( String u_Id, String MType, String MStart, String MEnd) {
       
		Connection connect = null;
                Statement stmt = null;
		
		try {
                        Class.forName("com.mysql.jdbc.Driver");
                     connect = DriverManager.getConnection ( urlConnection,usernameDB,passwordDB);
			stmt = connect.createStatement();
			String sql = "INSERT INTO Member " +
					"(U_ID,M_Type,M_Start,M_End) " + 
					"VALUES ('" + u_Id + "','" + MType + "'"
                                + "" +
					",'" + MStart + "','" + MEnd + "') ";
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

    @Override
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
    
 
    

