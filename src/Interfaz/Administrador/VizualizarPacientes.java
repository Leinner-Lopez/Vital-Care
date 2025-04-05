package Interfaz.Administrador;

import Logica.Administrador;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class VizualizarPacientes extends javax.swing.JFrame {

    Administrador A = new Administrador();

    public VizualizarPacientes() {
        initComponents();
        this.setLocationRelativeTo(null);
        DefaultTableModel tabla = new DefaultTableModel(A.visualizarPacientes(), new String[]{"NOMBRE", "APELLIDO", "TIPO DOCUMENTO", "NUMERO DE DOCUMENTO", "SEGURO MEDICO", "NUMERO DE TELEFONO"});
        JTPacientes.setModel(tabla);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        JTPacientes = new javax.swing.JTable();
        BTNEliminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        JTPacientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(JTPacientes);

        BTNEliminar.setText("Eliminar");
        BTNEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 847, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(BTNEliminar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(157, Short.MAX_VALUE)
                .addComponent(BTNEliminar)
                .addGap(34, 34, 34)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BTNEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNEliminarActionPerformed
        int fila = JTPacientes.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione un paciente para eliminar");
        } else {
            int numeroDocumento = Integer.parseInt(JTPacientes.getValueAt(fila, 3).toString());
            int confirmacion = JOptionPane.showConfirmDialog(null, "¿Está seguro de que desea eliminar al paciente?", "Confirmar Eliminación", JOptionPane.YES_NO_OPTION);
            if (confirmacion == JOptionPane.YES_OPTION) {
                A.eliminarPaciente(numeroDocumento);
                DefaultTableModel tabla = new DefaultTableModel(A.visualizarPacientes(), new String[]{"NOMBRE", "APELLIDO", "TIPO DOCUMENTO", "NUMERO DE DOCUMENTO", "SEGURO MEDICO", "NUMERO DE TELEFONO"});
                JTPacientes.setModel(tabla);
            }
        }
    }//GEN-LAST:event_BTNEliminarActionPerformed

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
            java.util.logging.Logger.getLogger(VizualizarPacientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VizualizarPacientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VizualizarPacientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VizualizarPacientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VizualizarPacientes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTNEliminar;
    private javax.swing.JTable JTPacientes;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
