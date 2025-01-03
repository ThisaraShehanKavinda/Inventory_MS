/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interface;

import inventoryms.DBConnection;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author USER
 */
public class Register extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    
    
    PreparedStatement pst=null;
    ResultSet rs=null;
    Connection con;
    
    public Register() {
        initComponents();
        con = DBConnection.getConnection();
        lblUnhide.setVisible(false);
        lblUnhide1.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kGradientPanel1 = new keeptoo.KGradientPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtname = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        rSMaterialButtonRectangle1 = new rojerusan.RSMaterialButtonRectangle();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtReenterpassword = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtname1 = new javax.swing.JTextField();
        lblHide = new javax.swing.JLabel();
        lblUnhide = new javax.swing.JLabel();
        lblUnhide1 = new javax.swing.JLabel();
        lblHide1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        kGradientPanel1.setkEndColor(new java.awt.Color(0, 0, 0));
        kGradientPanel1.setkStartColor(new java.awt.Color(0, 0, 204));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/close.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                .addContainerGap(360, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(14, 14, 14))
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(kGradientPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 390, 40));

        jPanel1.setBackground(new java.awt.Color(0, 0, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel4.setBackground(new java.awt.Color(0, 51, 255));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("WELCOME BACK !");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("UPDATE HERE.....");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel3))
                    .addComponent(jLabel2))
                .addContainerGap(78, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 80));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("ID");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, 20));

        txtname.setBackground(new java.awt.Color(0, 0, 0));
        txtname.setForeground(new java.awt.Color(255, 255, 255));
        txtname.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtname.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        jPanel2.add(txtname, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 220, 30));

        txtPassword.setBackground(new java.awt.Color(0, 0, 0));
        txtPassword.setForeground(new java.awt.Color(255, 255, 255));
        txtPassword.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPassword.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        jPanel2.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, 220, 30));

        rSMaterialButtonRectangle1.setBackground(new java.awt.Color(0, 51, 255));
        rSMaterialButtonRectangle1.setText("UPDATE");
        rSMaterialButtonRectangle1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonRectangle1ActionPerformed(evt);
            }
        });
        jPanel2.add(rSMaterialButtonRectangle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 450, 160, 40));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Email");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, 20));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Password");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, -1, 20));

        txtEmail.setBackground(new java.awt.Color(0, 0, 0));
        txtEmail.setForeground(new java.awt.Color(255, 255, 255));
        txtEmail.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtEmail.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        jPanel2.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 220, 30));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Re-enter Password");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, -1, 20));

        txtReenterpassword.setBackground(new java.awt.Color(0, 0, 0));
        txtReenterpassword.setForeground(new java.awt.Color(255, 255, 255));
        txtReenterpassword.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtReenterpassword.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        jPanel2.add(txtReenterpassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 410, 220, 30));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Login Here");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(228, 470, 70, 30));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("User Name");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, 20));

        txtname1.setBackground(new java.awt.Color(0, 0, 0));
        txtname1.setForeground(new java.awt.Color(255, 255, 255));
        txtname1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtname1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txtname1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtname1ActionPerformed(evt);
            }
        });
        jPanel2.add(txtname1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 220, 30));

        lblHide.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8-hide-17.png"))); // NOI18N
        lblHide.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblHideMouseClicked(evt);
            }
        });
        jPanel2.add(lblHide, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 340, -1, -1));

        lblUnhide.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8-unhide-with-eye-symbol-for-layering-application-control-15.png"))); // NOI18N
        lblUnhide.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblUnhideMouseClicked(evt);
            }
        });
        jPanel2.add(lblUnhide, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 340, -1, -1));

        lblUnhide1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8-unhide-with-eye-symbol-for-layering-application-control-15.png"))); // NOI18N
        lblUnhide1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblUnhide1MouseClicked(evt);
            }
        });
        jPanel2.add(lblUnhide1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 420, -1, -1));

        lblHide1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8-hide-17.png"))); // NOI18N
        lblHide1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblHide1MouseClicked(evt);
            }
        });
        jPanel2.add(lblHide1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 420, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 300, 500));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 390, 530));

        setSize(new java.awt.Dimension(384, 565));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel1MouseClicked

    private void rSMaterialButtonRectangle1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle1ActionPerformed
      String uname = txtname.getText();
    String email = txtEmail.getText();
    String password = txtPassword.getText();
    String repassword = txtReenterpassword.getText();

    if (password.equals(repassword)) {
        try {
            String sql = "UPDATE `register` SET `user_name`=?, `email`=?, `password`=?, `re_password`=? WHERE id=?";
            Connection con = DBConnection.getConnection();
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1, uname);
            pst.setString(2, email);
            pst.setString(3, password);
            pst.setString(4, repassword);
            pst.setString(5, txtname1.getText());

            pst.executeUpdate();

            JOptionPane.showMessageDialog(this, "Successfully Updated!");

            pst.close();
         
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error occurred while updating data: " + e.getMessage());
        }
    } else {
        JOptionPane.showMessageDialog(this, "Passwords do not match. Please re-enter the password correctly.");
    }
     
    }//GEN-LAST:event_rSMaterialButtonRectangle1ActionPerformed

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        Login login = new Login();
        login.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel4MouseClicked

    private void txtname1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtname1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtname1ActionPerformed

    private void lblHideMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHideMouseClicked
        txtPassword.setEchoChar((char)0);
        lblHide.setVisible(false);
        lblUnhide.setVisible(true);
    }//GEN-LAST:event_lblHideMouseClicked

    private void lblUnhideMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblUnhideMouseClicked
        txtPassword.setEchoChar('*');
        lblUnhide.setVisible(false);
        lblHide.setVisible(true);
    }//GEN-LAST:event_lblUnhideMouseClicked

    private void lblUnhide1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblUnhide1MouseClicked
        txtReenterpassword.setEchoChar('*');
        lblUnhide1.setVisible(false);
        lblHide1.setVisible(true);
    }//GEN-LAST:event_lblUnhide1MouseClicked

    private void lblHide1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHide1MouseClicked
        txtReenterpassword.setEchoChar((char)0);
        lblHide1.setVisible(false);
        lblUnhide1.setVisible(true);
    }//GEN-LAST:event_lblHide1MouseClicked

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
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Register().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private keeptoo.KGradientPanel kGradientPanel1;
    private javax.swing.JLabel lblHide;
    private javax.swing.JLabel lblHide1;
    private javax.swing.JLabel lblUnhide;
    private javax.swing.JLabel lblUnhide1;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle1;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JPasswordField txtReenterpassword;
    private javax.swing.JTextField txtname;
    private javax.swing.JTextField txtname1;
    // End of variables declaration//GEN-END:variables
}
