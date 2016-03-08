/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SystemNpruPool;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Godonlyknows
 */
public interface ConnectDB {
    String usernameDB = "nprupooladmin";
    String passwordDB = "1234";
   // Connection connect = null;
    String urlConnection = "jdbc:mysql://192.168.43.242:3306/npru_pool?useUnicode=true&characterEncoding=UTF-8";
    
}
