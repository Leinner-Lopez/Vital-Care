package Interfaz.Paciente;

import Logica.Citas;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class DeterminarFechaCita extends javax.swing.JFrame {

    Citas c = new Citas();
    int numeroDocumento;

    public DeterminarFechaCita(ArrayList<String> citasDisponibles, String nombre_1, String apellido_1, String especialidad, int numeroDocumento) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.numeroDocumento = numeroDocumento;
        JLnombre.setText(nombre_1);
        JLApellido.setText(apellido_1);
        JLEspecialidad.setText(especialidad);
        JCBHorasDisponibles.removeAllItems();
        for (String i : citasDisponibles) {
            JCBHorasDisponibles.addItem(i);
        }
    }

    public DeterminarFechaCita() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JLnombre = new javax.swing.JLabel();
        JLApellido = new javax.swing.JLabel();
        JLEspecialidad = new javax.swing.JLabel();
        JCBHorasDisponibles = new javax.swing.JComboBox<>();
        BTNAgendar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        JLnombre.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N
        JLnombre.setText("jLabel1");

        JLApellido.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N
        JLApellido.setText("jLabel2");

        JLEspecialidad.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N
        JLEspecialidad.setText("jLabel3");

        JCBHorasDisponibles.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        BTNAgendar.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N
        BTNAgendar.setText("Agendar");
        BTNAgendar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNAgendarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(147, 147, 147)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JCBHorasDisponibles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JLEspecialidad)
                    .addComponent(JLApellido)
                    .addComponent(JLnombre))
                .addContainerGap(637, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BTNAgendar)
                .addGap(372, 372, 372))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(JLnombre)
                .addGap(18, 18, 18)
                .addComponent(JLApellido)
                .addGap(18, 18, 18)
                .addComponent(JLEspecialidad)
                .addGap(18, 18, 18)
                .addComponent(JCBHorasDisponibles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 184, Short.MAX_VALUE)
                .addComponent(BTNAgendar)
                .addGap(91, 91, 91))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BTNAgendarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNAgendarActionPerformed
        String Hora_cita = JCBHorasDisponibles.getSelectedItem().toString();
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date fecha = null;
        try {
            fecha = formato.parse(Hora_cita);
        } catch (ParseException e) {
            System.out.println("Error: " + e.getMessage());
        }
        c.agendarCita(numeroDocumento, fecha);
        this.dispose();

    }//GEN-LAST:event_BTNAgendarActionPerformed

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
            java.util.logging.Logger.getLogger(DeterminarFechaCita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DeterminarFechaCita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DeterminarFechaCita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DeterminarFechaCita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DeterminarFechaCita().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTNAgendar;
    private javax.swing.JComboBox<String> JCBHorasDisponibles;
    private javax.swing.JLabel JLApellido;
    private javax.swing.JLabel JLEspecialidad;
    private javax.swing.JLabel JLnombre;
    // End of variables declaration//GEN-END:variables
}
