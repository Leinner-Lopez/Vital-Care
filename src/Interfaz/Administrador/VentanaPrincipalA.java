package Interfaz.Administrador;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class VentanaPrincipalA extends javax.swing.JFrame {

    JPanel subMenuRegistrar;
    JPanel subMenuVisualizar;

    public VentanaPrincipalA() {
        initComponents();
        this.setLocationRelativeTo(null);
        setTitle("Ventana Principal");
        menuLateral.setLayout(new BoxLayout(menuLateral, BoxLayout.Y_AXIS));
        // Submenú de Citas
        subMenuRegistrar = new JPanel();
        subMenuRegistrar.setLayout(new BoxLayout(subMenuRegistrar, BoxLayout.Y_AXIS));
        subMenuRegistrar.setBackground(new Color(60, 60, 60));
        subMenuRegistrar.setVisible(false);
        // Submenú de Disponibilidad
        subMenuVisualizar = new JPanel();
        subMenuVisualizar.setLayout(new BoxLayout(subMenuVisualizar, BoxLayout.Y_AXIS));
        subMenuVisualizar.setBackground(new Color(60, 60, 60));
        subMenuVisualizar.setVisible(false);
        // Subítems
        String[] registrar = {"Medico", "Paciente", "Administrador"};
        for (String rol : registrar) {
            JButton btn = new JButton("  " + rol);
            configurarBotonSubmenu(btn);
            subMenuRegistrar.add(btn);
        }
        String[] visualizar = {"Medicos", "Pacientes", "Administradores", "Citas"};
        for (String rol : visualizar) {
            JButton btn = new JButton("  " + rol);
            configurarBotonSubmenu(btn);
            subMenuVisualizar.add(btn);
        }
        menuLateral.add(Box.createVerticalStrut(10));
        menuLateral.add(btnRegistrar);
        menuLateral.add(subMenuRegistrar);
        menuLateral.add(Box.createVerticalStrut(10));
        menuLateral.add(btnVisualizar);
        menuLateral.add(subMenuVisualizar);
        menuLateral.add(Box.createVerticalStrut(10));
    }

    private void configurarBotonSubmenu(JButton btn) {
        btn.setAlignmentX(Component.LEFT_ALIGNMENT);
        btn.setFocusPainted(false);

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String opcion = btn.getText().trim();
                switch (opcion) {
                    case "Medico":
                        new CrearCuentaMedico().setVisible(true);
                        break;
                    case "Paciente":
                        new CrearCuentaPaciente().setVisible(true);
                        break;
                    case "Administrador":
                        new CrearCuentaAdministrador().setVisible(true);
                        break;
                    case "Pacientes":
                        new VizualizarPacientes().setVisible(true);
                        break;
                    case "Medicos":
                        new VizualizarMedicos().setVisible(true);
                        break;
                    case "Administradores":
                        new VizualizarAdministradores().setVisible(true);
                        break;
                    case "Citas":
                        new VizualizarCitas().setVisible(true);
                        break;
                    default:
                        break;
                }
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuLateral = new javax.swing.JPanel();
        btnVisualizar = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnVisualizar.setFont(new java.awt.Font("Century", 0, 18)); // NOI18N
        btnVisualizar.setText("Visualizar▼");
        btnVisualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVisualizarActionPerformed(evt);
            }
        });

        btnRegistrar.setFont(new java.awt.Font("Century", 0, 18)); // NOI18N
        btnRegistrar.setText("Registrar▼");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout menuLateralLayout = new javax.swing.GroupLayout(menuLateral);
        menuLateral.setLayout(menuLateralLayout);
        menuLateralLayout.setHorizontalGroup(
            menuLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuLateralLayout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(btnVisualizar)
                .addContainerGap(433, Short.MAX_VALUE))
            .addGroup(menuLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(menuLateralLayout.createSequentialGroup()
                    .addGap(52, 52, 52)
                    .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(436, Short.MAX_VALUE)))
        );
        menuLateralLayout.setVerticalGroup(
            menuLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuLateralLayout.createSequentialGroup()
                .addGap(164, 164, 164)
                .addComponent(btnVisualizar)
                .addContainerGap(327, Short.MAX_VALUE))
            .addGroup(menuLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(menuLateralLayout.createSequentialGroup()
                    .addGap(108, 108, 108)
                    .addComponent(btnRegistrar)
                    .addContainerGap(383, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menuLateral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menuLateral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVisualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVisualizarActionPerformed
        subMenuVisualizar.setVisible(!subMenuVisualizar.isVisible());
        btnVisualizar.setText("Visualizar" + (subMenuVisualizar.isVisible() ? "▲" : "▼"));
        revalidate(); // refresca layout
    }//GEN-LAST:event_btnVisualizarActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        subMenuRegistrar.setVisible(!subMenuRegistrar.isVisible());
        btnRegistrar.setText("Registrar" + (subMenuRegistrar.isVisible() ? "▲" : "▼"));
        revalidate(); // refresca layout
    }//GEN-LAST:event_btnRegistrarActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaPrincipalA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipalA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipalA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipalA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPrincipalA().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnVisualizar;
    private javax.swing.JPanel menuLateral;
    // End of variables declaration//GEN-END:variables
}
