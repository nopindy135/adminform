/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SystemNpruPool;

/**
 *
 * @author Godonlyknows
 */
public class TestConnect {
     public static  void main(String[] args){
         CheckConnetDB ccdb = new CheckConnetDB();
         ccdb.CheckConnect();
         System.out.println(ccdb.CheckConnect1())
                 ;
     }
}
