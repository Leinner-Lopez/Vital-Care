package Interfaz.Paciente;

import Logica.Paciente;
import Logica.Usuario;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Pantalla_PrincipalP extends javax.swing.JFrame {

    Usuario u = new Paciente();

    public Pantalla_PrincipalP() {
        initComponents();
        this.setLocationRelativeTo(null);
        u.recuperarNombreyCorreo();
        JLNombre.setText(u.getNombre1() + " " + u.getApellido1());
        JLCorreo.setText(u.getCorreo());
    }

    private void configurarBotonSubmenu(JButton btn) {
        btn.setAlignmentX(Component.LEFT_ALIGNMENT);
        btn.setMaximumSize(new Dimension(150, 35));
        btn.setFocusPainted(false);
        btn.setBackground(new Color(90, 90, 90));
        btn.setForeground(Color.LIGHT_GRAY);

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String opcion = btn.getText().trim();

                // Aquí puedes abrir tu ventana específica
            }
        });
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
        subVerCitas = new javax.swing.JMenuItem();
        subAgendarCita = new javax.swing.JMenuItem();

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
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(258, 258, 258)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(JLco))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(JLNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JLCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JLus))
                        .addGap(9, 9, 9)))
                .addGap(277, 277, 277))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(JLus)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JLNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JLco)
                    .addComponent(JLCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(264, Short.MAX_VALUE))
        );

        JMRegistrar.setText("Citas");

        subVerCitas.setText("VerCitas");
        subVerCitas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subVerCitasActionPerformed(evt);
            }
        });
        JMRegistrar.add(subVerCitas);

        subAgendarCita.setText("AgendarCita");
        subAgendarCita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subAgendarCitaActionPerformed(evt);
            }
        });
        JMRegistrar.add(subAgendarCita);

        JMenu.add(JMRegistrar);

        setJMenuBar(JMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void subAgendarCitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subAgendarCitaActionPerformed
        new AgendarCita().setVisible(true);
    }//GEN-LAST:event_subAgendarCitaActionPerformed

    private void subVerCitasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subVerCitasActionPerformed
        new VerCitas().setVisible(true);
    }//GEN-LAST:event_subVerCitasActionPerformed

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
            java.util.logging.Logger.getLogger(Pantalla_PrincipalP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pantalla_PrincipalP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pantalla_PrincipalP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pantalla_PrincipalP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pantalla_PrincipalP().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JLCorreo;
    private javax.swing.JLabel JLNombre;
    private javax.swing.JLabel JLco;
    private javax.swing.JLabel JLus;
    private javax.swing.JMenu JMRegistrar;
    private javax.swing.JMenuBar JMenu;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenuItem subAgendarCita;
    private javax.swing.JMenuItem subVerCitas;
    // End of variables declaration//GEN-END:variables
}
