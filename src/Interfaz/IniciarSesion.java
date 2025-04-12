package Interfaz;

import Interfaz.Medico.Pantalla_PrincipalM;
import Interfaz.Administrador.Pantalla_Principal;
import Interfaz.Paciente.Pantalla_PrincipalP;
import Logica.Paciente;
import Logica.Usuario;
import javax.swing.JOptionPane;

public class IniciarSesion extends javax.swing.JFrame {

    boolean estado = false;

    public IniciarSesion() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Iniciar Sesion");
        btnEstadoContraseña.setText("Mostrar");
        JPContraseña.setEchoChar('•');
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        JTUsuario = new javax.swing.JTextField();
        btnIniciar_Sesion = new javax.swing.JButton();
        JPContraseña = new javax.swing.JPasswordField();
        btnEstadoContraseña = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        JTUsuario.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N
        JTUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTUsuarioActionPerformed(evt);
            }
        });

        btnIniciar_Sesion.setText("Iniciar Sesion");
        btnIniciar_Sesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciar_SesionActionPerformed(evt);
            }
        });

        JPContraseña.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N

        btnEstadoContraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEstadoContraseñaActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N
        jLabel1.setText("Usuario");

        jLabel2.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N
        jLabel2.setText("Contraseña");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(120, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnIniciar_Sesion, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(344, 344, 344))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(37, 37, 37)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JTUsuario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JPContraseña, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEstadoContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(156, 156, 156))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(167, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JTUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEstadoContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(JPContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)))
                .addGap(112, 112, 112)
                .addComponent(btnIniciar_Sesion, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(95, 95, 95))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JTUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTUsuarioActionPerformed

    }//GEN-LAST:event_JTUsuarioActionPerformed

    private void btnEstadoContraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEstadoContraseñaActionPerformed
        estado = !estado;
        if (estado) {
            btnEstadoContraseña.setText("Ocultar");
            JPContraseña.setEchoChar((char) 0);
        } else {
            btnEstadoContraseña.setText("Mostrar");
            JPContraseña.setEchoChar('•');
        }
    }//GEN-LAST:event_btnEstadoContraseñaActionPerformed

    private void btnIniciar_SesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciar_SesionActionPerformed
        Usuario U = new Paciente();
        String contra = new String(JPContraseña.getPassword()).trim();
        if (!JTUsuario.getText().equals("") && !contra.equals("")) {
            String rol = U.verificarDatos(JTUsuario.getText(), contra);
            switch (rol) {
                case "pacientes":
                    JOptionPane.showMessageDialog(null, "Bienvenido " + JTUsuario.getText(), "Usuario Paciente", JOptionPane.INFORMATION_MESSAGE);
                    U.setUsuario(JTUsuario.getText());
                    new Pantalla_PrincipalP().setVisible(true);
                    this.dispose();
                    break;
                case "medicos":
                    JOptionPane.showMessageDialog(null, "Bienvenido " + JTUsuario.getText(), "Usuario Medico", JOptionPane.INFORMATION_MESSAGE);
                    U.setUsuario(JTUsuario.getText());
                    new Pantalla_PrincipalM().setVisible(true);
                    this.dispose();
                    break;
                case "administradores":
                    JOptionPane.showMessageDialog(null, "Bienvenido " + JTUsuario.getText(), "Usuario Administrador", JOptionPane.INFORMATION_MESSAGE);
                    U.setUsuario(JTUsuario.getText());
                    new Pantalla_Principal().setVisible(true);
                    this.dispose();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "El usuario no a sido encontrado", "Error", JOptionPane.ERROR_MESSAGE);
                    break;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Llena todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnIniciar_SesionActionPerformed

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
            java.util.logging.Logger.getLogger(IniciarSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IniciarSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IniciarSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IniciarSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IniciarSesion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField JPContraseña;
    private javax.swing.JTextField JTUsuario;
    private javax.swing.JButton btnEstadoContraseña;
    private javax.swing.JButton btnIniciar_Sesion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
