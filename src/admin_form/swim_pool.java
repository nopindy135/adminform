/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin_form;

import SystemNpruPool.Payment;
import SystemNpruPool.Staff;
import SystemNpruPool.User;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author Boss
 */
public class swim_pool extends javax.swing.JFrame {
        User u =new User();
        Staff st =new Staff();
    /**
     * Creates new form swim_pool
     */
    public swim_pool() {
        initComponents();
           u.CheckUser(u.getU_Id());
             System.out.println("u id on  swim_pool= "+u.getU_Id());
                System.out.println("st id on befor swim_pool= "+st.getSt_Id());
           st.CheckStaff(st.getSt_Id());
           System.out.println("st id on after swim_pool= "+st.getSt_Id());
           st.CheckLogin(st.getSt_Id(),st.getSt_Password());
            out_uid.setText(String.valueOf(u.getU_Id()));
            out_ucardid.setText(u.getU_CardId());
          
            out_ufirstname.setText(u.getU_Firstname());
            out_ulastname.setText(u.getU_Lastname());
            out_ubirthday.setText(u.getU_Birthday());
            out_utype.setText(String.valueOf(u.getU_Type()));
     
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
        jLabel2 = new javax.swing.JLabel();
        out_uid = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        out_ucardid = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        out_ufirstname = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        out_ulastname = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        out_ubirthday = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        out_utype = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        btn_history_use = new javax.swing.JButton();
        btn_user = new javax.swing.JButton();
        in_pmoney = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("TH Sarabun New", 0, 18)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Swimming Pool-64.png"))); // NOI18N
        jLabel1.setText("ชำระค่าบริการสระว่ายน้ำ");

        jLabel2.setFont(new java.awt.Font("TH Sarabun New", 0, 18)); // NOI18N
        jLabel2.setText("รหัสสมาชิก");

        out_uid.setFont(new java.awt.Font("TH Sarabun New", 0, 18)); // NOI18N
        out_uid.setText("..............................");

        jLabel4.setFont(new java.awt.Font("TH Sarabun New", 0, 18)); // NOI18N
        jLabel4.setText("รหัสบัตรประชาชน");

        out_ucardid.setFont(new java.awt.Font("TH Sarabun New", 0, 18)); // NOI18N
        out_ucardid.setText("..............................");

        jLabel6.setFont(new java.awt.Font("TH Sarabun New", 0, 18)); // NOI18N
        jLabel6.setText("ชื่อ");

        out_ufirstname.setFont(new java.awt.Font("TH Sarabun New", 0, 18)); // NOI18N
        out_ufirstname.setText("......................................");

        jLabel8.setFont(new java.awt.Font("TH Sarabun New", 0, 18)); // NOI18N
        jLabel8.setText("นามสกุล");

        out_ulastname.setFont(new java.awt.Font("TH Sarabun New", 0, 18)); // NOI18N
        out_ulastname.setText(".....................................");

        jLabel10.setFont(new java.awt.Font("TH Sarabun New", 0, 18)); // NOI18N
        jLabel10.setText("ัวัน/เดือน/ปี เกิด");

        out_ubirthday.setFont(new java.awt.Font("TH Sarabun New", 0, 18)); // NOI18N
        out_ubirthday.setText("..............................................");

        jLabel12.setFont(new java.awt.Font("TH Sarabun New", 0, 18)); // NOI18N
        jLabel12.setText("สถานะผู้ใช้งาน");

        out_utype.setFont(new java.awt.Font("TH Sarabun New", 0, 18)); // NOI18N
        out_utype.setText(".....บุคคลทั่วไป....หรือ ........สมาชิก........................");

        jLabel15.setFont(new java.awt.Font("TH Sarabun New", 0, 18)); // NOI18N
        jLabel15.setText("ค่าบริการ");

        btn_history_use.setFont(new java.awt.Font("TH Sarabun New", 0, 18)); // NOI18N
        btn_history_use.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/File-complete-icon.png"))); // NOI18N
        btn_history_use.setText("เสร็จสิ้น");
        btn_history_use.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_history_useActionPerformed(evt);
            }
        });

        btn_user.setFont(new java.awt.Font("TH Sarabun New", 0, 18)); // NOI18N
        btn_user.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/home-icon.png"))); // NOI18N
        btn_user.setText("กลับหน้าหลัก");
        btn_user.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_userActionPerformed(evt);
            }
        });

        in_pmoney.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "30 บาท", "50 บาท" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn_history_use, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn_user))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(out_ufirstname)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(90, 90, 90)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(out_ucardid)
                                            .addComponent(out_uid)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel8)
                                        .addGap(18, 18, 18)
                                        .addComponent(out_ulastname))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel15))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(out_utype)
                                    .addComponent(out_ubirthday)
                                    .addComponent(in_pmoney, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(out_uid))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(out_ucardid))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(out_ufirstname)
                    .addComponent(jLabel8)
                    .addComponent(out_ulastname))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(out_ubirthday))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(out_utype))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(in_pmoney, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_user, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_history_use, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_history_useActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_history_useActionPerformed
        // TODO add your handling code here:
          Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                SimpleDateFormat df1 = new SimpleDateFormat("HH:mm:ss");
        String currentDate = df.format(c.getTime());//ปีเดือนวัน
        String currentDate1= df1.format(c.getTime());//ปีเดือนวัน+เวลาล
        Payment pm =new Payment();

        history_use hu =new history_use();
        hu.setVisible(true);
        //int money;
        
        if(in_pmoney.getSelectedItem().equals("30 บาท")){
    pm.InsertPaymet(30, currentDate, currentDate1,"เงินสด",Integer.valueOf(out_uid.getText()),st.getSt_Id());
        }
        else if(in_pmoney.getSelectedItem().equals("50 บาท")){
         pm.InsertPaymet(50, currentDate, currentDate1,"เงินสด",Integer.valueOf(out_uid.getText()),st.getSt_Id());
        }
            close();
    }//GEN-LAST:event_btn_history_useActionPerformed

    private void btn_userActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_userActionPerformed
        // TODO add your handling code here:
        user u =new user();
        u.setVisible(true);
        close();
    }//GEN-LAST:event_btn_userActionPerformed

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
            java.util.logging.Logger.getLogger(swim_pool.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(swim_pool.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(swim_pool.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(swim_pool.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new swim_pool().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_history_use;
    private javax.swing.JButton btn_user;
    private javax.swing.JComboBox in_pmoney;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel out_ubirthday;
    private javax.swing.JLabel out_ucardid;
    private javax.swing.JLabel out_ufirstname;
    private javax.swing.JLabel out_uid;
    private javax.swing.JLabel out_ulastname;
    private javax.swing.JLabel out_utype;
    // End of variables declaration//GEN-END:variables
}