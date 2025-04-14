package Interfaz.Paciente;
import Logica.Citas;
import Logica.Paciente;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.Timestamp;
import java.util.ArrayList;

public class AgendarCita extends javax.swing.JFrame {
    Paciente P = new Paciente();
    Citas c =  new Citas();
    public AgendarCita() {
        initComponents();
        this.setLocationRelativeTo(null);
        DefaultTableModel tabla = new DefaultTableModel(P.verMedicos(),new String[] {"NOMBRE","APELLIDO","Especialidad","Inicio Disponibilidad","Fin Disponibilidad"});
        JTMedicos.setModel(tabla);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTMedicos = new javax.swing.JTable();
        CBEspecialidad = new javax.swing.JComboBox<>();
        BTNBuscar = new javax.swing.JToggleButton();
        BTNAgendar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        JTMedicos.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
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

        CBEspecialidad.setFont(new java.awt.Font("Rockwell", 0, 14)); // NOI18N
        CBEspecialidad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Medicina Interna", "Pediatría", "Ginecología y Obstetricia", "Cirugía General", "Anestesiología", "Cardiología", "Neurología", "Traumatología y Ortopedia", "Dermatología", "Oftalmología", "Otorrinolaringología", "Neumología", "Urología", "Endocrinología", "Gastroenterología", "Nefrología", "Psiquiatría", "Oncología", "Reumatología", "Radiología" }));

        BTNBuscar.setText("Buscar");
        BTNBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNBuscarActionPerformed(evt);
            }
        });

        BTNAgendar.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N
        BTNAgendar.setText("Agendar");
        BTNAgendar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNAgendarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 747, Short.MAX_VALUE)
                .addGap(56, 56, 56))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BTNAgendar)
                .addGap(148, 148, 148)
                .addComponent(CBEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BTNBuscar)
                .addGap(212, 212, 212))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(95, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CBEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BTNBuscar)
                    .addComponent(BTNAgendar))
                .addGap(65, 65, 65)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
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

    private void BTNBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNBuscarActionPerformed
        DefaultTableModel tabla = new DefaultTableModel(P.buscarMedicos(CBEspecialidad.getSelectedItem().toString()),new String[] {"NOMBRE","APELLIDO","Especialidad","Inicio Disponibilidad","Fin Disponibilidad"});
        JTMedicos.setModel(tabla);
    }//GEN-LAST:event_BTNBuscarActionPerformed

    private void BTNAgendarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNAgendarActionPerformed
        int Fila = JTMedicos.getSelectedRow();
        if(Fila == -1){
            JOptionPane.showMessageDialog(null, "Seleccione un medico para agendar la cita medica");
        }else{
            String FechaFin = JTMedicos.getValueAt(Fila,4).toString();
            String FechaInicio = JTMedicos.getValueAt(Fila, 3).toString();
            Timestamp disponibilidadFinal = Timestamp.valueOf(FechaFin);
            Timestamp disponibilidadInicial = Timestamp.valueOf(FechaInicio);
            Timestamp ahora = new Timestamp(System.currentTimeMillis());
            if(disponibilidadFinal.after(ahora) ){
                ArrayList<String> citasDisponibles;
                int numeroDocumento = c.determinarNumeroDocumentoMedico(JTMedicos.getValueAt(Fila, 0).toString(),JTMedicos.getValueAt(Fila, 1).toString(), JTMedicos.getValueAt(Fila, 2).toString());
                citasDisponibles = c.obtenerCitasTomadas(disponibilidadInicial, disponibilidadFinal, numeroDocumento);
                new DeterminarFechaCita(citasDisponibles, JTMedicos.getValueAt(Fila, 0).toString(),JTMedicos.getValueAt(Fila, 1).toString(), JTMedicos.getValueAt(Fila, 2).toString(),numeroDocumento).setVisible(true);
                this.dispose();
            }else{
                JOptionPane.showMessageDialog(null, "La disponibilidad del Medico a vencido", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_BTNAgendarActionPerformed

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
            java.util.logging.Logger.getLogger(AgendarCita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AgendarCita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AgendarCita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AgendarCita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AgendarCita().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTNAgendar;
    private javax.swing.JToggleButton BTNBuscar;
    private javax.swing.JComboBox<String> CBEspecialidad;
    private javax.swing.JTable JTMedicos;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
