/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlns.view;

import com.qlns.view.employee.EmployeeView;
import com.qlns.view.employee_log.EmployeeLogView;
import com.qlns.view.salary_log.SalaryLogView;
import com.qlns.view.task.TaskView;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JPanel;

public class Main extends javax.swing.JFrame {

	public void changeLayout(JPanel panel) {
		getContentPane().removeAll();
		getContentPane().add(panel);
		revalidate();
		repaint();
	}

	/**
	 * Creates new form Main
	 */
	public Main() {
		setLayout(new GridBagLayout());
		initComponents();
	}

	@SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                jMenuBar1 = new javax.swing.JMenuBar();
                jMenu1 = new javax.swing.JMenu();
                jMenu2 = new javax.swing.JMenu();
                jMenu3 = new javax.swing.JMenu();
                jMenu4 = new javax.swing.JMenu();

                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
                setTitle("Main");

                jMenu1.setText("Nhân viên");
                jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mouseClicked(java.awt.event.MouseEvent evt) {
                                jMenu1MouseClicked(evt);
                        }
                });
                jMenuBar1.add(jMenu1);

                jMenu2.setText("Công việc");
                jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mouseClicked(java.awt.event.MouseEvent evt) {
                                jMenu2MouseClicked(evt);
                        }
                });
                jMenuBar1.add(jMenu2);

                jMenu3.setText("Lương");
                jMenu3.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mouseClicked(java.awt.event.MouseEvent evt) {
                                jMenu3MouseClicked(evt);
                        }
                });
                jMenuBar1.add(jMenu3);

                jMenu4.setText("Khen thưởng");
                jMenu4.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mouseClicked(java.awt.event.MouseEvent evt) {
                                jMenu4MouseClicked(evt);
                        }
                });
                jMenuBar1.add(jMenu4);

                setJMenuBar(jMenuBar1);

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 1062, Short.MAX_VALUE)
                );
                layout.setVerticalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 585, Short.MAX_VALUE)
                );

                pack();
        }// </editor-fold>//GEN-END:initComponents

        private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseClicked
		changeLayout(new TaskView(this));
        }//GEN-LAST:event_jMenu2MouseClicked

        private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
		changeLayout(new EmployeeView(this));
        }//GEN-LAST:event_jMenu1MouseClicked

        private void jMenu4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu4MouseClicked
		changeLayout(new EmployeeLogView(this));
        }//GEN-LAST:event_jMenu4MouseClicked

        private void jMenu3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu3MouseClicked
		changeLayout(new SalaryLogView(this));
        }//GEN-LAST:event_jMenu3MouseClicked

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
			java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>
		//</editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				Main main = new Main();
				main.setLocationRelativeTo(null);
				main.setVisible(true);
				main.setLayout(new GridLayout(1, 1));
				main.changeLayout(new Login(main));
			}
		});
	}

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JMenu jMenu1;
        private javax.swing.JMenu jMenu2;
        private javax.swing.JMenu jMenu3;
        private javax.swing.JMenu jMenu4;
        private javax.swing.JMenuBar jMenuBar1;
        // End of variables declaration//GEN-END:variables
}
