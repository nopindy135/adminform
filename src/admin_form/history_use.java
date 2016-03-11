/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin_form;

import SystemNpruPool.User;
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
public class history_use extends javax.swing.JFrame {
User us = new User();

    /**
     * Creates new form history_use
     */
    public history_use() {
        initComponents();
        
       // us.ShowUser();
        	DefaultTableModel model = (DefaultTableModel)Table_History_Use.getModel();
	
        	//Header Sort
		TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel> (model);
		Table_History_Use.setRowSorter(sorter);
                Connection connect = null;
		Statement stmt = null;
		
		try {
                    Class.forName("com.mysql.jdbc.Driver");
                    String urlConnection = "jdbc:mysql://127.0.0.1/npru_pool?useUnicode=true&characterEncoding=UTF-8";
                    connect = DriverManager.getConnection ( urlConnection, "root", "" );
                    stmt=connect.createStatement();
			
			String sql = "SELECT * FROM  user join payment WHERE user.U_ID = payment.U_Id ORDER BY user.U_ID ASC";
			
			ResultSet rec = stmt.executeQuery(sql);
			int row = 0;
			while((rec!=null) && (rec.next()))
            {			
				model.addRow(new Object[0]);
				model.setValueAt(rec.getString("U_ID"), row, 0);
				model.setValueAt(rec.getString("U_Firstname"), row, 1);
				model.setValueAt(rec.getString("U_Lastname"), row, 2);
				model.setValueAt(rec.getString("U_Type"), row, 3);
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
        Table_History_Use = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btn_menu = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        in_fname = new javax.swing.JTextField();
        in_lname = new javax.swing.JTextField();
        in_type = new javax.swing.JTextField();
        in_id = new javax.swing.JFormattedTextField();
        btn_delete = new javax.swing.JButton();
        btn_edit = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("แสดงประวัติผู้เข้าใช้งานสระว่ายน้ำ");
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                formMouseMoved(evt);
            }
        });

        Table_History_Use.setFont(new java.awt.Font("TH Sarabun New", 0, 18)); // NOI18N
        Table_History_Use.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "รหัสสมาชิก", "ชื่อ", "นามสกุล", "ประเภทผู้ใช้งาน"
            }
        ));
        Table_History_Use.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Table_History_Use.setName(""); // NOI18N
        Table_History_Use.setSurrendersFocusOnKeystroke(true);
        Table_History_Use.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                Table_History_UseMouseMoved(evt);
            }
        });
        jScrollPane1.setViewportView(Table_History_Use);

        jLabel1.setFont(new java.awt.Font("TH Sarabun New", 0, 24)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Swimming Pool-64.png"))); // NOI18N
        jLabel1.setText("แสดงประวัติผู้เข้าใช้งานสระว่ายน้ำ");

        btn_menu.setFont(new java.awt.Font("TH Sarabun New", 0, 18)); // NOI18N
        btn_menu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/home-icon.png"))); // NOI18N
        btn_menu.setText("กลับหน้าหลัก");
        btn_menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_menuActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("TH Sarabun New", 0, 22)); // NOI18N
        jLabel2.setText("แก้ไขข้อมูล");

        jLabel3.setFont(new java.awt.Font("TH Sarabun New", 0, 18)); // NOI18N
        jLabel3.setText("รหัสสมาชิก");

        jLabel4.setFont(new java.awt.Font("TH Sarabun New", 0, 18)); // NOI18N
        jLabel4.setText("ชื่อ");

        jLabel5.setFont(new java.awt.Font("TH Sarabun New", 0, 18)); // NOI18N
        jLabel5.setText("นามสกุล");

        jLabel6.setFont(new java.awt.Font("TH Sarabun New", 0, 18)); // NOI18N
        jLabel6.setText("ประเภทผู้ใช้งาน");
        jLabel6.setToolTipText("");

        in_fname.setFont(new java.awt.Font("TH Sarabun New", 0, 18)); // NOI18N

        in_lname.setFont(new java.awt.Font("TH Sarabun New", 0, 18)); // NOI18N

        in_type.setFont(new java.awt.Font("TH Sarabun New", 0, 18)); // NOI18N

        in_id.setFont(new java.awt.Font("TH Sarabun New", 0, 18)); // NOI18N

        btn_delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Button-Close-icon.png"))); // NOI18N

        btn_edit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Pencil-icon.png"))); // NOI18N

        jLabel7.setFont(new java.awt.Font("TH Sarabun New", 0, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 0, 0));
        jLabel7.setText("*ห้ามแก้ไขรหัสสมาชิก");

        jLabel8.setText("สวัสดี : ");

        jLabel9.setFont(new java.awt.Font("TH Sarabun New", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 204));
        jLabel9.setText("..............");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9)
                        .addGap(32, 32, 32)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(178, 178, 178)
                                .addComponent(btn_menu)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel7)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addGap(25, 25, 25)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(in_id, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                                    .addComponent(in_fname)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(in_lname))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(in_type, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(76, 76, 76)
                                .addComponent(btn_delete)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn_edit)))))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(jLabel9)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(in_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(in_fname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(in_lname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(in_type, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_menu)
                    .addComponent(btn_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_edit, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        getAccessibleContext().setAccessibleName("แสดงประวัติผู้เข้าใช้สระว่ายน้ำ");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_menuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_menuActionPerformed
        // TODO add your handling code here:
          user u = new user();
        u.setVisible(true);
        close();
    }//GEN-LAST:event_btn_menuActionPerformed

    private void Table_History_UseMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Table_History_UseMouseMoved
        // TODO add your handling code here:
            DefaultTableModel model = (DefaultTableModel) Table_History_Use.getModel();
      in_id.setText(model.getValueAt(Table_History_Use.getSelectedRow(),0).toString());
      in_fname.setText(model.getValueAt(Table_History_Use.getSelectedRow(),1).toString());
      in_lname.setText(model.getValueAt(Table_History_Use.getSelectedRow(),2).toString());
      in_type.setText(model.getValueAt(Table_History_Use.getSelectedRow(),3).toString());
   
    }//GEN-LAST:event_Table_History_UseMouseMoved

    private void formMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseMoved
        // TODO add your handling code here:
        	DefaultTableModel model = (DefaultTableModel)Table_History_Use.getModel();
	
        	//Header Sort
		TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel> (model);
		Table_History_Use.setRowSorter(sorter);
                Connection connect = null;
		Statement stmt = null;
		
		try {
                    Class.forName("com.mysql.jdbc.Driver");
                    String urlConnection = "jdbc:mysql://127.0.0.1/npru_pool?useUnicode=true&characterEncoding=UTF-8";
                    connect = DriverManager.getConnection ( urlConnection, "root", "" );
                    stmt=connect.createStatement();
			
			String sql = "SELECT * FROM  user join payment WHERE user.U_ID = payment.U_Id ORDER BY user.U_ID ASC";
			
			ResultSet rec = stmt.executeQuery(sql);
			int row = 0;
			while((rec!=null) && (rec.next()))
            {			
				//model.addRow(new Object[0]);
				model.setValueAt(rec.getString("U_ID"), row, 0);
				model.setValueAt(rec.getString("U_Firstname"), row, 1);
				model.setValueAt(rec.getString("U_Lastname"), row, 2);
				model.setValueAt(rec.getString("U_Type"), row, 3);
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
            java.util.logging.Logger.getLogger(history_use.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(history_use.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(history_use.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(history_use.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new history_use().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Table_History_Use;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_edit;
    private javax.swing.JButton btn_menu;
    private javax.swing.JTextField in_fname;
    private javax.swing.JFormattedTextField in_id;
    private javax.swing.JTextField in_lname;
    private javax.swing.JTextField in_type;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
