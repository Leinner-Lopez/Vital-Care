package Interfaz.Medico;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class VentanaPrincipalM extends javax.swing.JFrame {

    JPanel subMenuCitas;
    JPanel subMenuDisponibilidad;

    public VentanaPrincipalM() {
        initComponents();
        this.setLocationRelativeTo(null);
        setTitle("Ventana Principal");
        menuLateral.setLayout(new BoxLayout(menuLateral, BoxLayout.Y_AXIS));
        // Submenú de Citas
        subMenuCitas = new JPanel();
        subMenuCitas.setLayout(new BoxLayout(subMenuCitas, BoxLayout.Y_AXIS));
        subMenuCitas.setBackground(new Color(60, 60, 60));
        subMenuCitas.setVisible(false);
        // Submenú de Disponibilidad
        subMenuDisponibilidad = new JPanel();
        subMenuDisponibilidad.setLayout(new BoxLayout(subMenuDisponibilidad, BoxLayout.Y_AXIS));
        subMenuDisponibilidad.setBackground(new Color(60, 60, 60));
        subMenuDisponibilidad.setVisible(false);
        // Subítems
        JButton btn = new JButton("Ver Citas");
        configurarBotonSubmenu(btn);
        subMenuCitas.add(btn);
        JButton btn2 = new JButton("Establecer Disponibilidad");
        configurarBotonSubmenu(btn2);
        subMenuDisponibilidad.add(btn2);
        menuLateral.add(Box.createVerticalStrut(10));
        menuLateral.add(btnCitas);
        menuLateral.add(subMenuCitas);
        menuLateral.add(Box.createVerticalStrut(10));
        menuLateral.add(btnDisponibilidad);
        menuLateral.add(subMenuDisponibilidad);
        menuLateral.add(Box.createVerticalStrut(10));
    }

    private void configurarBotonSubmenu(JButton btn) {
        btn.setAlignmentX(Component.LEFT_ALIGNMENT);
        btn.setFocusPainted(false);

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String opcion = btn.getText().trim();
                if (opcion.equals("Ver Citas")) {
                    new VerCitas().setVisible(true);
                } else if (opcion.equals("Establecer Disponibilidad")) {
                    new Establecer_Disponibilidad().setVisible(true);
                }
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuLateral = new javax.swing.JPanel();
        btnDisponibilidad = new javax.swing.JButton();
        btnCitas = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnDisponibilidad.setFont(new java.awt.Font("Century", 0, 18)); // NOI18N
        btnDisponibilidad.setText("Disponibilidad▼");
        btnDisponibilidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDisponibilidadActionPerformed(evt);
            }
        });

        btnCitas.setFont(new java.awt.Font("Century", 0, 18)); // NOI18N
        btnCitas.setText("Citas▼");
        btnCitas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCitasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout menuLateralLayout = new javax.swing.GroupLayout(menuLateral);
        menuLateral.setLayout(menuLateralLayout);
        menuLateralLayout.setHorizontalGroup(
            menuLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuLateralLayout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(btnDisponibilidad)
                .addContainerGap(398, Short.MAX_VALUE))
            .addGroup(menuLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(menuLateralLayout.createSequentialGroup()
                    .addGap(52, 52, 52)
                    .addComponent(btnCitas, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(436, Short.MAX_VALUE)))
        );
        menuLateralLayout.setVerticalGroup(
            menuLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuLateralLayout.createSequentialGroup()
                .addGap(164, 164, 164)
                .addComponent(btnDisponibilidad)
                .addContainerGap(327, Short.MAX_VALUE))
            .addGroup(menuLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(menuLateralLayout.createSequentialGroup()
                    .addGap(108, 108, 108)
                    .addComponent(btnCitas)
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

    private void btnDisponibilidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDisponibilidadActionPerformed
        subMenuDisponibilidad.setVisible(!subMenuDisponibilidad.isVisible());
        btnDisponibilidad.setText("Disponibilidad" + (subMenuDisponibilidad.isVisible() ? "▲" : "▼"));
        revalidate(); // refresca layout
    }//GEN-LAST:event_btnDisponibilidadActionPerformed

    private void btnCitasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCitasActionPerformed
        subMenuCitas.setVisible(!subMenuCitas.isVisible());
        btnCitas.setText("Citas" + (subMenuCitas.isVisible() ? "▲" : "▼"));
        revalidate(); // refresca layout
    }//GEN-LAST:event_btnCitasActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaPrincipalM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipalM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipalM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipalM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPrincipalM().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCitas;
    private javax.swing.JButton btnDisponibilidad;
    private javax.swing.JPanel menuLateral;
    // End of variables declaration//GEN-END:variables
}
