package Interfaz.Administrador;
import Logica.Usuario;

public class Pantalla_Principal extends javax.swing.JFrame {

    Usuario u = new Usuario();

    public Pantalla_Principal() {
        initComponents();
        this.setLocationRelativeTo(null);
        u.recuperarNombreyCorreo();
        JLNombre.setText(u.getNombre1() + " " + u.getApellido1());
        JLCorreo.setText(u.getCorreo());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        JLus = new javax.swing.JLabel();
        JLco = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        JLCorreo = new javax.swing.JLabel();
        JLNombre = new javax.swing.JLabel();
        JMenu = new javax.swing.JMenuBar();
        JMRegistrar = new javax.swing.JMenu();
        subRegistrarMedico = new javax.swing.JMenuItem();
        subRegistrarPaciente = new javax.swing.JMenuItem();
        subRegistrarAdministrador = new javax.swing.JMenuItem();
        JMVisualizar = new javax.swing.JMenu();
        subPacientes = new javax.swing.JMenuItem();
        subMedicos = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        JLus.setFont(new java.awt.Font("Rockwell", 0, 24)); // NOI18N
        JLus.setText("BIENVENID@");

        JLco.setFont(new java.awt.Font("Rockwell", 0, 24)); // NOI18N
        JLco.setText("Correo:");

        jLabel3.setFont(new java.awt.Font("Rockwell", 0, 24)); // NOI18N
        jLabel3.setText("Nombre:");

        JLCorreo.setFont(new java.awt.Font("Rockwell", 0, 24)); // NOI18N

        JLNombre.setFont(new java.awt.Font("Rockwell", 0, 24)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(226, 226, 226)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(JLco))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                        .addComponent(JLus)
                        .addGap(362, 362, 362))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(JLNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE)
                            .addComponent(JLCorreo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addComponent(JLus)
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3)
                    .addComponent(JLNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLco)
                    .addComponent(JLCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(275, Short.MAX_VALUE))
        );

        JMRegistrar.setText("Registrar");

        subRegistrarMedico.setText("Medico");
        subRegistrarMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subRegistrarMedicoActionPerformed(evt);
            }
        });
        JMRegistrar.add(subRegistrarMedico);

        subRegistrarPaciente.setText("Paciente");
        subRegistrarPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subRegistrarPacienteActionPerformed(evt);
            }
        });
        JMRegistrar.add(subRegistrarPaciente);

        subRegistrarAdministrador.setText("Administrador");
        subRegistrarAdministrador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subRegistrarAdministradorActionPerformed(evt);
            }
        });
        JMRegistrar.add(subRegistrarAdministrador);

        JMenu.add(JMRegistrar);

        JMVisualizar.setText("Visualizar");

        subPacientes.setText("Pacientes");
        subPacientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subPacientesActionPerformed(evt);
            }
        });
        JMVisualizar.add(subPacientes);

        subMedicos.setText("Medicos");
        subMedicos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subMedicosActionPerformed(evt);
            }
        });
        JMVisualizar.add(subMedicos);

        JMenu.add(JMVisualizar);

        jMenu3.setText("jMenu3");
        JMenu.add(jMenu3);

        setJMenuBar(JMenu);

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

    private void subRegistrarPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subRegistrarPacienteActionPerformed
        new CrearCuentaPaciente().setVisible(true);
    }//GEN-LAST:event_subRegistrarPacienteActionPerformed

    private void subRegistrarMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subRegistrarMedicoActionPerformed
        new CrearCuentaMedico().setVisible(true);
    }//GEN-LAST:event_subRegistrarMedicoActionPerformed

    private void subRegistrarAdministradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subRegistrarAdministradorActionPerformed
        new CrearCuentaAdministrador().setVisible(true);
    }//GEN-LAST:event_subRegistrarAdministradorActionPerformed

    private void subPacientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subPacientesActionPerformed
        new VizualizarPacientes().setVisible(true);
    }//GEN-LAST:event_subPacientesActionPerformed

    private void subMedicosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subMedicosActionPerformed
        new VizualizarMedicos().setVisible(true);
    }//GEN-LAST:event_subMedicosActionPerformed

    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(Pantalla_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pantalla_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pantalla_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pantalla_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pantalla_Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JLCorreo;
    private javax.swing.JLabel JLNombre;
    private javax.swing.JLabel JLco;
    private javax.swing.JLabel JLus;
    private javax.swing.JMenu JMRegistrar;
    private javax.swing.JMenu JMVisualizar;
    private javax.swing.JMenuBar JMenu;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenuItem subMedicos;
    private javax.swing.JMenuItem subPacientes;
    private javax.swing.JMenuItem subRegistrarAdministrador;
    private javax.swing.JMenuItem subRegistrarMedico;
    private javax.swing.JMenuItem subRegistrarPaciente;
    // End of variables declaration//GEN-END:variables
}
