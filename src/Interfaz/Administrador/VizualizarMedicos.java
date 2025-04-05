package Interfaz.Administrador;

import Logica.Administrador;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class VizualizarMedicos extends javax.swing.JFrame {

    Administrador A = new Administrador();

    public VizualizarMedicos() {
        initComponents();
        this.setLocationRelativeTo(null);
        DefaultTableModel tabla = new DefaultTableModel(A.visualizarMedicos(), new String[]{"NOMBRE", "APELLIDO", "TIPO DOCUMENTO","NUMERO DOCUMENTO","ESPECIALIDAD", "TELEFONO"});
        JTMedicos.setModel(tabla);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        JTMedicos = new javax.swing.JTable();
        BTNEliminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        JTMedicos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(JTMedicos);

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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 835, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(132, 132, 132)
                .addComponent(BTNEliminar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(117, Short.MAX_VALUE)
                .addComponent(BTNEliminar)
                .addGap(47, 47, 47)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BTNEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNEliminarActionPerformed
        int fila = JTMedicos.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione un paciente para eliminar");
        } else {
            int numeroDocumento = Integer.parseInt(JTMedicos.getValueAt(fila, 2).toString());
            int confirmacion = JOptionPane.showConfirmDialog(null, "¿Está seguro de que desea eliminar al medico?", "Confirmar Eliminación", JOptionPane.YES_NO_OPTION);
            if (confirmacion == JOptionPane.YES_OPTION) {
                A.eliminarMedico(numeroDocumento);
                DefaultTableModel tabla = new DefaultTableModel(A.visualizarMedicos(), new String[]{"NOMBRE", "APELLIDO", "TIPO DOCUMENTO","NUMERO DOCUMENTO","ESPECIALIDAD", "TELEFONO"});
                JTMedicos.setModel(tabla);
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
            java.util.logging.Logger.getLogger(VizualizarMedicos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VizualizarMedicos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VizualizarMedicos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VizualizarMedicos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VizualizarMedicos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTNEliminar;
    private javax.swing.JTable JTMedicos;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
