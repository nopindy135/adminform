/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin_form;

import static SystemNpruPool.ConnectDB.passwordDB;
import static SystemNpruPool.ConnectDB.urlConnection;
import static SystemNpruPool.ConnectDB.usernameDB;
import SystemNpruPool_Admin.Admin_Usermode;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Boss
 */
public class show_list_user extends javax.swing.JFrame {
 Admin_Usermode aum = new Admin_Usermode();
  Connection connect = null;
		Statement stmt = null;
                String sql;
    /**
     * Creates new form show_list_user
     */
    public show_list_user() {
        initComponents();
          DefaultTableModel model = (DefaultTableModel)Table_user.getModel();
	
        	//Header Sort
		TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel> (model);
		Table_user.setRowSorter(sorter);
    

//String expr = E_Uid.getText();
//sorter.setRowFilter(RowFilter.regexFilter(expr));
sorter.setSortKeys(null);
           
		
		try {
                    Class.forName("com.mysql.jdbc.Driver");
                    connect = DriverManager.getConnection ( urlConnection,usernameDB,passwordDB);
                    stmt=connect.createStatement();
			
			sql = "SELECT * FROM  user  ORDER BY U_ID ASC";
			
			ResultSet rec = stmt.executeQuery(sql);
			int row = 0;
			while((rec!=null) && (rec.next()))
            {			
				model.addRow(new Object[0]);
				model.setValueAt(rec.getString("U_ID"), row, 0);
				model.setValueAt(rec.getString("U_Firstname"), row, 1);
				model.setValueAt(rec.getString("U_Lastname"), row, 2);
				model.setValueAt(rec.getString("U_Address"), row, 3);
                                model.setValueAt(rec.getString("U_Birthday"), row, 4);
                                model.setValueAt(rec.getString("U_Age"), row, 5);
                                model.setValueAt(rec.getString("U_CardID"), row, 6);
                                model.setValueAt(rec.getString("U_Type"), row, 7);
                                model.setValueAt(rec.getString("U_Tel"), row, 8);
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table_user = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        in_id = new javax.swing.JTextField();
        in_cardid = new javax.swing.JTextField();
        in_fname = new javax.swing.JTextField();
        in_lname = new javax.swing.JTextField();
        in_address = new javax.swing.JTextField();
        in_birthday = new javax.swing.JTextField();
        in_age = new javax.swing.JTextField();
        in_tel = new javax.swing.JTextField();
        in_type = new javax.swing.JTextField();
        btn_add = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        btn_edit = new javax.swing.JButton();
        btn_menu = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("แสดงรายชื่อสมาชิก");
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                formMouseMoved(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("TH Sarabun New", 0, 24)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Places-user-identity-icon (1).png"))); // NOI18N
        jLabel1.setText("แสดงรายชื่อสมาชิก ( Member )");

        Table_user.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "รหัสสมาชิก", "เลขบัตรประชาชน", "ชื่อ", "นามสกุล", "ที่อยู่", "วัน/เดือน/ปี เกิด", "อายุ", "เบอร์โทรศัพท์", "ประเภทสมาชิก"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Table_user.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                Table_userMouseMoved(evt);
            }
        });
        jScrollPane1.setViewportView(Table_user);

        jLabel2.setFont(new java.awt.Font("TH Sarabun New", 0, 18)); // NOI18N
        jLabel2.setText("แก้ไขข้อมูลสมาชิก");

        jLabel3.setFont(new java.awt.Font("TH Sarabun New", 0, 18)); // NOI18N
        jLabel3.setText("รหัสสมาชิก");

        jLabel4.setFont(new java.awt.Font("TH Sarabun New", 0, 18)); // NOI18N
        jLabel4.setText("เลขบัตรประชาชน");

        jLabel5.setFont(new java.awt.Font("TH Sarabun New", 0, 18)); // NOI18N
        jLabel5.setText("ชื่อ");

        jLabel6.setFont(new java.awt.Font("TH Sarabun New", 0, 18)); // NOI18N
        jLabel6.setText("นามสกุล");

        jLabel7.setFont(new java.awt.Font("TH Sarabun New", 0, 18)); // NOI18N
        jLabel7.setText("ที่อยู่");

        jLabel8.setFont(new java.awt.Font("TH Sarabun New", 0, 18)); // NOI18N
        jLabel8.setText("วัน/เดือน/ปี เกิด");

        jLabel9.setFont(new java.awt.Font("TH Sarabun New", 0, 18)); // NOI18N
        jLabel9.setText("อายุ");

        jLabel10.setFont(new java.awt.Font("TH Sarabun New", 0, 18)); // NOI18N
        jLabel10.setText("เบอร์โทรศัพท์");

        jLabel11.setFont(new java.awt.Font("TH Sarabun New", 0, 18)); // NOI18N
        jLabel11.setText("ประเภทสมาชิก");

        in_id.setFont(new java.awt.Font("TH Sarabun New", 0, 18)); // NOI18N

        in_cardid.setFont(new java.awt.Font("TH Sarabun New", 0, 18)); // NOI18N

        in_fname.setFont(new java.awt.Font("TH Sarabun New", 0, 18)); // NOI18N

        in_lname.setFont(new java.awt.Font("TH Sarabun New", 0, 18)); // NOI18N

        in_address.setFont(new java.awt.Font("TH Sarabun New", 0, 18)); // NOI18N

        in_birthday.setFont(new java.awt.Font("TH Sarabun New", 0, 18)); // NOI18N

        in_age.setFont(new java.awt.Font("TH Sarabun New", 0, 18)); // NOI18N

        in_tel.setFont(new java.awt.Font("TH Sarabun New", 0, 18)); // NOI18N

        in_type.setFont(new java.awt.Font("TH Sarabun New", 0, 18)); // NOI18N

        btn_add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/add-contact-icon.png"))); // NOI18N
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });

        btn_delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Button-Close-icon.png"))); // NOI18N
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });

        btn_edit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Pencil-icon.png"))); // NOI18N
        btn_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(79, 79, 79))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(btn_add, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(in_id)
                    .addComponent(in_cardid)
                    .addComponent(in_fname)
                    .addComponent(in_lname)
                    .addComponent(in_address)
                    .addComponent(in_birthday)
                    .addComponent(in_age)
                    .addComponent(in_tel)
                    .addComponent(in_type)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 14, Short.MAX_VALUE)
                        .addComponent(btn_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(btn_edit, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(in_id, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(in_cardid, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(in_fname, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(in_lname, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(in_address, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(in_birthday, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(in_age, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(in_tel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(in_type, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_add, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_delete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_edit, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        btn_menu.setFont(new java.awt.Font("TH Sarabun New", 0, 18)); // NOI18N
        btn_menu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/home-icon.png"))); // NOI18N
        btn_menu.setText("กลับหน้าหลัก");
        btn_menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_menuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 987, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(404, 404, 404)
                                .addComponent(jLabel1)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btn_menu, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(383, 383, 383)))
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_menu, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_menuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_menuActionPerformed
        // TODO add your handling code here:
           user u = new user();
        u.setVisible(true);
        close();
    }//GEN-LAST:event_btn_menuActionPerformed

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        // TODO add your handling code here:
        aum.AddUser(Integer.valueOf(in_id.getText()),in_fname.getText(),in_lname.getText(),in_address.getText(),in_birthday.getText(),in_cardid.getText()
                ,Integer.valueOf(in_type.getText()),in_tel.getText());
        
    }//GEN-LAST:event_btn_addActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        // TODO add your handling code here:
        aum.DeleteUser(Integer.valueOf(in_id.getText()));
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void btn_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editActionPerformed
        // TODO add your handling code here:
        aum.EditUser(Integer.valueOf(in_id.getText()),in_fname.getText(),in_lname.getText(),in_address.getText(),in_birthday.getText(),in_cardid.getText()
                ,Integer.valueOf(in_type.getText()),in_tel.getText());
    }//GEN-LAST:event_btn_editActionPerformed

    private void Table_userMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Table_userMouseMoved
        // TODO add your handling code here:
          DefaultTableModel model = (DefaultTableModel) Table_user.getModel();
 // U_id=(model.getValueAt(Table_Admin.getSelectedRow(),0).toString());
      in_id.setText(model.getValueAt(Table_user.getSelectedRow(),0).toString());
     in_fname.setText(model.getValueAt(Table_user.getSelectedRow(),1).toString());
      in_lname.setText(model.getValueAt(Table_user.getSelectedRow(),2).toString());
  //  E_name.setText(model.getValueAt(showcourse.getSelectedRow(),1).toString());
   // E_lastname.setText(model.getValueAt(showcourse.getSelectedRow(),2).toString());
    in_address.setText(model.getValueAt(Table_user.getSelectedRow(),3).toString());
    in_birthday.setText(model.getValueAt(Table_user.getSelectedRow(),4).toString());
    in_age.setText(model.getValueAt(Table_user.getSelectedRow(),5).toString());
        in_cardid.setText(model.getValueAt(Table_user.getSelectedRow(),6).toString());
        in_type.setText(model.getValueAt(Table_user.getSelectedRow(),7).toString());
        in_tel.setText(model.getValueAt(Table_user.getSelectedRow(),8).toString());
        
        
        
    }//GEN-LAST:event_Table_userMouseMoved

    private void formMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseMoved
        // TODO add your handling code here:
         DefaultTableModel model = (DefaultTableModel)Table_user.getModel();
	
        	//Header Sort
		TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel> (model);
		Table_user.setRowSorter(sorter);
    

//String expr = E_Uid.getText();
//sorter.setRowFilter(RowFilter.regexFilter(expr));
sorter.setSortKeys(null);
           
		
		try {
                    Class.forName("com.mysql.jdbc.Driver");
                    connect = DriverManager.getConnection ( urlConnection,usernameDB,passwordDB);
                    stmt=connect.createStatement();
			
			sql = "SELECT * FROM  user  ORDER BY U_ID ASC";
			
			ResultSet rec = stmt.executeQuery(sql);
			int row = 0;
			while((rec!=null) && (rec.next()))
            {			
				//model.addRow(new Object[0]);
				model.setValueAt(rec.getString("U_ID"), row, 0);
				model.setValueAt(rec.getString("U_Firstname"), row, 1);
				model.setValueAt(rec.getString("U_Lastname"), row, 2);
				model.setValueAt(rec.getString("U_Address"), row, 3);
                                model.setValueAt(rec.getString("U_Birthday"), row, 4);
                                model.setValueAt(rec.getString("U_Age"), row, 5);
                                model.setValueAt(rec.getString("U_CardID"), row, 6);
                                model.setValueAt(rec.getString("U_Type"), row, 7);
                                model.setValueAt(rec.getString("U_Tel"), row, 8);
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
            java.util.logging.Logger.getLogger(show_list_user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(show_list_user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(show_list_user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(show_list_user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new show_list_user().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Table_user;
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_edit;
    private javax.swing.JButton btn_menu;
    private javax.swing.JTextField in_address;
    private javax.swing.JTextField in_age;
    private javax.swing.JTextField in_birthday;
    private javax.swing.JTextField in_cardid;
    private javax.swing.JTextField in_fname;
    private javax.swing.JTextField in_id;
    private javax.swing.JTextField in_lname;
    private javax.swing.JTextField in_tel;
    private javax.swing.JTextField in_type;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
