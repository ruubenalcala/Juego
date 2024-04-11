
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.awt.BorderLayout;
import java.awt.Image;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author ruube
 */
public class Register extends javax.swing.JFrame {

    
    public Register() {
        initComponents();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false); 

        ImageIcon backgroundImageIcon = new ImageIcon(getClass().getResource("./flappybirdbg.png"));
        Image backgroundResized = backgroundImageIcon.getImage().getScaledInstance(560, 840, Image.SCALE_SMOOTH);
        ImageIcon backgroundScaledIcon = new ImageIcon(backgroundResized);
        JLabel background = new JLabel(backgroundScaledIcon);
        getContentPane().add(background); 
        background.setLayout(new BorderLayout()); 
        background.setBounds(0, 0, 560, 840);
        setLocationRelativeTo(null);
        
    }
    
    //FUNCIONES VALIDACIONES
    private boolean requesitoPassword(String password) {
        return password.matches(".*[a-zA-Z]+.*") && password.matches(".*\\d+.*");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        juname = new javax.swing.JTextField();
        jphone = new javax.swing.JTextField();
        jname = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jemail = new javax.swing.JTextField();
        jpass = new javax.swing.JPasswordField();
        jpass1 = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/registertit.png"))); // NOI18N

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/registertext.png"))); // NOI18N

        juname.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        jphone.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        jname.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jnameActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/confirm.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Calibri", 3, 24)); // NOI18N
        jLabel7.setText("YA TENGO UNA CUENTA");
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });

        jemail.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        jpass.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jpass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jpassActionPerformed(evt);
            }
        });

        jpass1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jpass1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jpass1ActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/back.png"))); // NOI18N
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jpass, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jphone, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jemail, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(juname, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jname)
                    .addComponent(jpass1, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(52, 52, 52))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(juname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jphone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(jpass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(jpass1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(16, 16, 16))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // BOTON REGISTRO

        String nam = jname.getText();
        String uNam = juname.getText();
        String email = jemail.getText();
        String phone = jphone.getText();
        String ps = jpass.getText();
        String ps1 = jpass1.getText();  // SEGUNDA CONTRASEÑA

        // VALIDACION CAMPOS OBLIGATORIOS
if (nam.isEmpty() || uNam.isEmpty() || email.isEmpty() || phone.isEmpty() || ps.isEmpty()) {
    StringBuilder errorMessage = new StringBuilder("Los siguientes campos son obligatorios:\n");

    if (nam.isEmpty()) {
        errorMessage.append("Nombre\n");
    }
    if (uNam.isEmpty()) {
        errorMessage.append("Usuario\n");
    }
    if (email.isEmpty()) {
        errorMessage.append("Email\n");
    }
    if (phone.isEmpty()) {
        errorMessage.append("Teléfono\n");
    }
    if (ps.isEmpty()) {
        errorMessage.append("Contraseña\n");
    }

    JOptionPane.showMessageDialog(rootPane, errorMessage.toString(), "Error", JOptionPane.ERROR_MESSAGE);
    return;
}


        
        if (ps.length() < 8 || !requesitoPassword(ps)) {
            JOptionPane.showMessageDialog(rootPane, "La contraseña debe tener al menos 8 caracteres y contener letras y números.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (ps.equals(ps1)) {
            try {

                Statement s = db.mycon().createStatement();
                s.executeUpdate(" INSERT INTO user (Name, UserName, Email, Phone, Password) "
                        + "VALUES ('" + nam + "','" + uNam + "','" + email + "','" + phone + "','" + ps + "')");

                JOptionPane.showMessageDialog(rootPane, "Tu cuenta se ha creado con éxito. Ya puedes iniciar sesión", "Éxito", JOptionPane.INFORMATION_MESSAGE);

                this.setVisible(false);
                new Login().setVisible(true);

                // PARA BORRAR LOS DATOS DE REGISTRO
                jname.setText("");
                juname.setText("");
                jemail.setText("");
                jphone.setText("");
                jpass.setText("");
                jpass1.setText("");

            
            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, "Error al registrar el usuario, puede que este duplicado algún dato como el usuario, email o teléfono: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }

        } else { // SI LAS CONTRASEÑAS NO SON IGUALES 
            JOptionPane.showMessageDialog(rootPane, "Las contraseñas no coinciden. Por favor, inténtelo de nuevo.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        //ENLACE PARA REGISTRARSE
        
        new Login().setVisible(true); //ENLACE A LOGIN
        this.setVisible(false); //HACE QUE CIERRE LA VENTANA Y NO SE ABRA UNA NUEVA
    }//GEN-LAST:event_jLabel7MouseClicked

    private void jpass1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jpass1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jpass1ActionPerformed

    private void jpassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jpassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jpassActionPerformed

    private void jnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jnameActionPerformed

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        new Principal().setVisible(true); 
        this.setVisible(false); 
    }//GEN-LAST:event_jLabel2MouseClicked

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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Register().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField jemail;
    private javax.swing.JTextField jname;
    private javax.swing.JPasswordField jpass;
    private javax.swing.JPasswordField jpass1;
    private javax.swing.JTextField jphone;
    private javax.swing.JTextField juname;
    // End of variables declaration//GEN-END:variables
}
