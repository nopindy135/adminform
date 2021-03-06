/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin_form;

import SystemNpruPool.CheckConnetDB;
import static SystemNpruPool.ConnectDB.passwordDB;
import static SystemNpruPool.ConnectDB.urlConnection;
import static SystemNpruPool.ConnectDB.usernameDB;
import SystemNpruPool_Admin.Admin;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import static java.lang.Thread.sleep;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Boss
 */
public class show_list_admin extends javax.swing.JFrame {
    Admin ad = new Admin();
 Connection connect = null;
		Statement stmt = null;
                String sql;
       
    /**
     * Creates new form show_list_admin
     */
    public show_list_admin() {
        initComponents();
           Admin a = new Admin();
            out_user.setText(a.getAdmin_username());
          DefaultTableModel model = (DefaultTableModel)Table_Admin.getModel();
	
        	//Header Sort
		TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel> (model);
		Table_Admin.setRowSorter(sorter);
    

//String expr = E_Uid.getText();
//sorter.setRowFilter(RowFilter.regexFilter(expr));
sorter.setSortKeys(null);
           
		
		try {
                    Class.forName("com.mysql.jdbc.Driver");
                    connect = DriverManager.getConnection ( urlConnection,usernameDB,passwordDB);
                    stmt=connect.createStatement();
			
			sql = "SELECT * FROM  admin  ";
			
			ResultSet rec = stmt.executeQuery(sql);
			int row = 0;
			while((rec!=null) && (rec.next()))
            {			
				model.addRow(new Object[0]);
			
				model.setValueAt(rec.getString("Admin_Username"), row, 0);
				model.setValueAt(rec.getString("Admin_Password"), row, 1);
				model.setValueAt(rec.getString("Admin_FirstName"), row, 2);
                                model.setValueAt(rec.getString("Admin_LastName"), row, 3);
                                model.setValueAt(rec.getString("Admin_CardID"), row, 4);
                                model.setValueAt(rec.getString("Admin_Phonenumber"), row, 5);
                         
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
       public void close(){
        WindowEvent winclose = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winclose);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        Table_Admin = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_password = new javax.swing.JTextField();
        txt_fname = new javax.swing.JTextField();
        txt_lname = new javax.swing.JTextField();
        btn_Add = new javax.swing.JButton();
        btn_detete = new javax.swing.JButton();
        btn_edit = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txt_cardid = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txt_tel = new javax.swing.JTextField();
        txt_aid = new javax.swing.JTextField();
        btn_menu = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        out_user = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("แสดงรายชื่อผู้จัดการ");
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                formMouseMoved(evt);
            }
        });

        Table_Admin.setFont(new java.awt.Font("TH Sarabun New", 0, 18)); // NOI18N
        Table_Admin.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "รหัสผู้จัดการ", "รหัสผ่าน", "ชื่อ", "นามสกุล", "รหัสบัตรประชาชน", "เบอร์โทรศัพท์"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Table_Admin.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                Table_AdminMouseMoved(evt);
            }
        });
        jScrollPane1.setViewportView(Table_Admin);

        jLabel1.setFont(new java.awt.Font("TH Sarabun New", 0, 24)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/administrator-icon.png"))); // NOI18N
        jLabel1.setText("แสดงรายชื่อผู้จัดการ ( Admin )");

        jLabel2.setFont(new java.awt.Font("TH Sarabun New", 0, 18)); // NOI18N
        jLabel2.setText("แก้ไขข้อมูลผู้จัดการ ( Admin )");

        jLabel3.setFont(new java.awt.Font("TH Sarabun New", 0, 18)); // NOI18N
        jLabel3.setText("รหัสผู้จัดการ");

        jLabel5.setFont(new java.awt.Font("TH Sarabun New", 0, 18)); // NOI18N
        jLabel5.setText("รหัสผ่าน");

        jLabel6.setFont(new java.awt.Font("TH Sarabun New", 0, 18)); // NOI18N
        jLabel6.setText("ชื่อ");

        jLabel7.setFont(new java.awt.Font("TH Sarabun New", 0, 18)); // NOI18N
        jLabel7.setText("นามสกุล");

        txt_password.setFont(new java.awt.Font("TH Sarabun New", 0, 18)); // NOI18N

        txt_fname.setFont(new java.awt.Font("TH Sarabun New", 0, 18)); // NOI18N

        txt_lname.setFont(new java.awt.Font("TH Sarabun New", 0, 18)); // NOI18N
        txt_lname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_lnameActionPerformed(evt);
            }
        });

        btn_Add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/add-contact-icon.png"))); // NOI18N
        btn_Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AddActionPerformed(evt);
            }
        });

        btn_detete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Button-Close-icon.png"))); // NOI18N
        btn_detete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deteteActionPerformed(evt);
            }
        });

        btn_edit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Pencil-icon.png"))); // NOI18N
        btn_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("TH Sarabun New", 0, 18)); // NOI18N
        jLabel8.setText("รหัสบัตรประชาชน");

        txt_cardid.setFont(new java.awt.Font("TH Sarabun New", 0, 18)); // NOI18N

        jLabel9.setFont(new java.awt.Font("TH Sarabun New", 0, 18)); // NOI18N
        jLabel9.setText("เบอร์โทรศัพท์");

        txt_tel.setFont(new java.awt.Font("TH Sarabun New", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(40, 40, 40)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel7)))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(jLabel8))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_password, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                            .addComponent(txt_fname)
                            .addComponent(txt_lname)
                            .addComponent(txt_cardid)
                            .addComponent(txt_tel)
                            .addComponent(txt_aid))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(btn_Add, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_detete, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(btn_edit, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_aid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_password, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txt_fname, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(txt_lname, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_cardid, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_tel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_Add, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_detete, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_edit, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(74, 74, 74))
        );

        btn_menu.setFont(new java.awt.Font("TH Sarabun New", 0, 18)); // NOI18N
        btn_menu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/home-icon.png"))); // NOI18N
        btn_menu.setText("กลับหน้าหลัก");
        btn_menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_menuActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("TH Sarabun New", 0, 18)); // NOI18N
        jLabel10.setText("สวัสดี : ");

        out_user.setFont(new java.awt.Font("TH Sarabun New", 0, 18)); // NOI18N
        out_user.setForeground(new java.awt.Color(0, 0, 204));
        out_user.setText("...................");

        jLabel12.setFont(new java.awt.Font("TH Sarabun New", 0, 16)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 0, 0));
        jLabel12.setText("*ห้ามแก้ไขรหัสผู้จัดการ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(341, Short.MAX_VALUE)
                .addComponent(btn_menu)
                .addGap(213, 213, 213)
                .addComponent(jLabel12)
                .addGap(298, 298, 298))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 787, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(out_user)
                        .addGap(163, 163, 163)
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel10)
                                .addComponent(out_user)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_menu, javax.swing.GroupLayout.PREFERRED_SIZE, 66, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_lnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_lnameActionPerformed
        // TODO add your handling code here:
    
    }//GEN-LAST:event_txt_lnameActionPerformed

    private void Table_AdminMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Table_AdminMouseMoved
        // TODO add your handling code here:
            DefaultTableModel model = (DefaultTableModel) Table_Admin.getModel();
 // U_id=(model.getValueAt(Table_Admin.getSelectedRow(),0).toString());
      txt_aid.setText(model.getValueAt(Table_Admin.getSelectedRow(),0).toString());
     txt_password.setText(model.getValueAt(Table_Admin.getSelectedRow(),1).toString());
      txt_fname.setText(model.getValueAt(Table_Admin.getSelectedRow(),2).toString());
  //  E_name.setText(model.getValueAt(showcourse.getSelectedRow(),1).toString());
   // E_lastname.setText(model.getValueAt(showcourse.getSelectedRow(),2).toString());
    txt_lname.setText(model.getValueAt(Table_Admin.getSelectedRow(),3).toString());
    txt_cardid.setText(model.getValueAt(Table_Admin.getSelectedRow(),4).toString());
    txt_tel.setText(model.getValueAt(Table_Admin.getSelectedRow(),5).toString());

    }//GEN-LAST:event_Table_AdminMouseMoved

    private void btn_menuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_menuActionPerformed
        // TODO add your handling code here:
             user u = new user();
        u.setVisible(true);
        close();
    }//GEN-LAST:event_btn_menuActionPerformed

    private void btn_AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AddActionPerformed
        // TODO add your handling code here:
        ad.AddAdmin(txt_aid.getText(),txt_password.getText(),txt_fname.getText(),txt_lname.getText()
                ,txt_cardid.getText(),txt_tel.getText());
        
    }//GEN-LAST:event_btn_AddActionPerformed

    private void btn_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editActionPerformed
        // TODO add your handling code here:
                ad.EditAdmin(txt_aid.getText(),txt_password.getText(),txt_fname.getText(),txt_lname.getText()
                ,txt_cardid.getText(),txt_tel.getText());
    }//GEN-LAST:event_btn_editActionPerformed

    private void btn_deteteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deteteActionPerformed
        // TODO add your handling code here:
        ad.DeleteAdmin(txt_aid.getText());
    }//GEN-LAST:event_btn_deteteActionPerformed

    private void formMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseMoved
        // TODO add your handling code here:
          DefaultTableModel model = (DefaultTableModel)Table_Admin.getModel();
	
        	//Header Sort
		TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel> (model);
		Table_Admin.setRowSorter(sorter);
    

//String expr = E_Uid.getText();
//sorter.setRowFilter(RowFilter.regexFilter(expr));
sorter.setSortKeys(null);
           
		
		try {
                    Class.forName("com.mysql.jdbc.Driver");
                    connect = DriverManager.getConnection ( urlConnection,usernameDB,passwordDB);
                    stmt=connect.createStatement();
			
			sql = "SELECT * FROM  admin ";
			
			ResultSet rec = stmt.executeQuery(sql);
			int row = 0;
			while((rec!=null) && (rec.next()))
            {			
				//model.addRow(new Object[0]);
				
				model.setValueAt(rec.getString("Admin_Username"), row, 0);
				model.setValueAt(rec.getString("Admin_Password"), row, 1);
				model.setValueAt(rec.getString("Admin_FirstName"), row, 2);
                                model.setValueAt(rec.getString("Admin_LastName"), row, 3);
                                model.setValueAt(rec.getString("Admin_CardID"), row, 4);
                                model.setValueAt(rec.getString("Admin_Phonenumber"), row, 5);
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
    }//GEN-LAST:event_formMouseMoved
               
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(show_list_admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(show_list_admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(show_list_admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(show_list_admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new show_list_admin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Table_Admin;
    private javax.swing.JButton btn_Add;
    private javax.swing.JButton btn_detete;
    private javax.swing.JButton btn_edit;
    private javax.swing.JButton btn_menu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel out_user;
    private javax.swing.JTextField txt_aid;
    private javax.swing.JTextField txt_cardid;
    private javax.swing.JTextField txt_fname;
    private javax.swing.JTextField txt_lname;
    private javax.swing.JTextField txt_password;
    private javax.swing.JTextField txt_tel;
    // End of variables declaration//GEN-END:variables
}
