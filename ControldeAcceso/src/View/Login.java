package View;

import java.awt.Toolkit;
import java.awt.Image;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.Icon;
import javax.swing.JOptionPane;
import Controller.ConexionMySQL;
import Controller.ControladorUsuario;
import Model.Usuario;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author 34633
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    ArrayList<Usuario> users;
    ConexionMySQL conexion;
    ControladorUsuario controladorUser;
    MenuMedico menu;

    public Login() throws SQLException {
        initComponents();
        this.setLocationRelativeTo(null);
        setIconImage(getIconImage());
        conexion = new ConexionMySQL("accesoempleado", "root", "");
        controladorUser = new ControladorUsuario(conexion);
        conexion.conectar();
        users = controladorUser.obtenerUsuario();

    }

    @Override
    public Image getIconImage() {

        Image logo = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("View/logo.jpeg"));

        return logo;

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        Logo = new javax.swing.JLabel();
        jTUser = new javax.swing.JTextField();
        jBEnter = new javax.swing.JButton();
        jLForget = new javax.swing.JLabel();
        jTPassword = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(500, 500));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        jPanel2.setMaximumSize(new java.awt.Dimension(400, 400));
        jPanel2.setPreferredSize(new java.awt.Dimension(500, 500));

        Logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/LogoGrande.jpeg"))); // NOI18N

        jTUser.setText("Usuario");

        jBEnter.setText("Entrar");
        jBEnter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEnterActionPerformed(evt);
            }
        });

        jLForget.setText("He olvidado mi contraseña");

        jTPassword.setText("jPasswordField1");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(162, 162, 162)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTUser, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Logo))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jBEnter, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(2, 2, 2)))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jTPassword, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLForget, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(175, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Logo, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(jTUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLForget)
                .addGap(32, 32, 32)
                .addComponent(jBEnter)
                .addContainerGap(98, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 490, 480));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBEnterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEnterActionPerformed

        if (this.users.isEmpty()) {

            JOptionPane.showInputDialog("No existe el usuario con ese nombre, intente registrarse");

        } else {

            for (int i = 0; i < users.size(); i++) {

                if (users.get(i).getNombre().equalsIgnoreCase(jTUser.getText()) && users.get(i).getContraseña().equals(jTPassword.getText())) {

                    JOptionPane.showMessageDialog(rootPane, "bienvenido");

                    try {
                        menu = new MenuMedico(users.get(i));
                        menu.setVisible(true);
                        this.dispose();

                    } catch (SQLException ex) {
                        Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                    }

                } else {

                    JOptionPane.showMessageDialog(rootPane, "Usuario o contraseña incorrecta", "Error", HEIGHT);

                }

            }

        }

    }//GEN-LAST:event_jBEnterActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Login().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Logo;
    private javax.swing.JButton jBEnter;
    private javax.swing.JLabel jLForget;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField jTPassword;
    private javax.swing.JTextField jTUser;
    // End of variables declaration//GEN-END:variables
}
