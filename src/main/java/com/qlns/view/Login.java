/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlns.view;

import com.qlns.dao.AccountDao;
import com.qlns.model.Account;
import com.qlns.view.employee.EmployeeView;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

public class Login extends javax.swing.JPanel {
	private Main main;

	/**
	 * Creates new form Login
	 */
	public Login(Main main) {
		this.main = main;
		main.hideMenuBar();
		initComponents();
	}

	/**
	 * This method is called from within the constructor to initialize the
	 * form. WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                jLabel1 = new javax.swing.JLabel();
                jLabel2 = new javax.swing.JLabel();
                jLabel3 = new javax.swing.JLabel();
                tfUsername = new javax.swing.JTextField();
                btnLogin = new javax.swing.JButton();
                pfPassword = new javax.swing.JPasswordField();

                jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
                jLabel1.setForeground(new java.awt.Color(153, 153, 255));
                jLabel1.setText("Hệ thống quản lý hồ sơ nhân sự");

                jLabel2.setText("Tên đăng nhập");

                jLabel3.setText("Mật khẩu");

                tfUsername.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                tfUsernameActionPerformed(evt);
                        }
                });

                btnLogin.setText("Đăng nhập");
                btnLogin.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnLoginActionPerformed(evt);
                        }
                });

                pfPassword.addKeyListener(new java.awt.event.KeyAdapter() {
                        public void keyPressed(java.awt.event.KeyEvent evt) {
                                pfPasswordKeyPressed(evt);
                        }
                });

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
                this.setLayout(layout);
                layout.setHorizontalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(391, 391, 391)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(88, 88, 88)
                                                .addComponent(btnLogin))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel1)
                                                .addGroup(layout.createSequentialGroup()
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(jLabel2)
                                                                .addComponent(jLabel3))
                                                        .addGap(18, 18, 18)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(tfUsername)
                                                                .addComponent(pfPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addContainerGap(385, Short.MAX_VALUE))
                );
                layout.setVerticalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(87, 87, 87)
                                .addComponent(jLabel1)
                                .addGap(58, 58, 58)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(tfUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(pfPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(42, 42, 42)
                                .addComponent(btnLogin)
                                .addContainerGap(268, Short.MAX_VALUE))
                );
        }// </editor-fold>//GEN-END:initComponents

        private void tfUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfUsernameActionPerformed
                // TODO add your handling code here:
        }//GEN-LAST:event_tfUsernameActionPerformed

        private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
		String username = tfUsername.getText();
		if (username.equals("")) {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập tên tài khoản!");
			return;
		}
		String password = String.valueOf(pfPassword.getPassword());
		if (password.equals("")) {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập mật khẩu!");
			return;
		}

		Account acc = AccountDao.login(username, password);
		if (acc == null) {
			JOptionPane.showMessageDialog(null, "Tên tài khoản hoặc mật khẩu không chính xác!");
			return;
		}
		main.changeLayout(new EmployeeView(main));
        }//GEN-LAST:event_btnLoginActionPerformed

        private void pfPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pfPasswordKeyPressed
		if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
			btnLogin.doClick();
		}
        }//GEN-LAST:event_pfPasswordKeyPressed


        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JButton btnLogin;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JLabel jLabel2;
        private javax.swing.JLabel jLabel3;
        private javax.swing.JPasswordField pfPassword;
        private javax.swing.JTextField tfUsername;
        // End of variables declaration//GEN-END:variables
}
