package Interfaz.Medico;

import Logica.Medico;
import java.util.Date;
import javax.swing.JOptionPane;

public class Establecer_Disponibilidad extends javax.swing.JFrame {
    Date fechaInicio;
    Date fechaFinal;
    public Establecer_Disponibilidad() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JSInicio = new javax.swing.JSpinner();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        JSFin = new javax.swing.JSpinner();
        jLabel3 = new javax.swing.JLabel();
        BTNEstablecer = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        JSInicio.setFont(new java.awt.Font("Rockwell", 0, 14)); // NOI18N
        JSInicio.setModel(new javax.swing.SpinnerDateModel());
        JSInicio.setEditor(new javax.swing.JSpinner.DateEditor(JSInicio, "yyyy-MM-dd HH:mm:ss"));

        jLabel1.setFont(new java.awt.Font("Rockwell", 0, 36)); // NOI18N
        jLabel1.setText("Disponibilidad");

        jLabel2.setFont(new java.awt.Font("Rockwell", 0, 36)); // NOI18N
        jLabel2.setText("Fin:");

        JSFin.setFont(new java.awt.Font("Rockwell", 0, 14)); // NOI18N
        JSFin.setModel(new javax.swing.SpinnerDateModel());
        JSFin.setEditor(new javax.swing.JSpinner.DateEditor(JSFin, "yyyy-MM-dd HH:mm:ss"));

        jLabel3.setFont(new java.awt.Font("Rockwell", 0, 36)); // NOI18N
        jLabel3.setText("Inicio:");

        BTNEstablecer.setFont(new java.awt.Font("Rockwell", 0, 24)); // NOI18N
        BTNEstablecer.setText("Establecer");
        BTNEstablecer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNEstablecerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(105, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JSInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(95, 95, 95))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(199, 199, 199)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(JSFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(132, 132, 132))
            .addGroup(layout.createSequentialGroup()
                .addGap(320, 320, 320)
                .addComponent(BTNEstablecer)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel1)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(JSInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(JSFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 125, Short.MAX_VALUE)
                .addComponent(BTNEstablecer)
                .addGap(107, 107, 107))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BTNEstablecerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNEstablecerActionPerformed
        fechaInicio = (Date) JSInicio.getValue();
        fechaFinal = (Date) JSFin.getValue();
        if(fechaFinal.after(fechaInicio)){
            Medico M = new Medico();
            M.esteblecerDisponibilidad(fechaInicio, fechaFinal);
            new Pantalla_PrincipalM().setVisible(true);
            this.dispose();
        }else{
            JOptionPane.showMessageDialog(null, "Fechas incorrectas", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_BTNEstablecerActionPerformed

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
            java.util.logging.Logger.getLogger(Establecer_Disponibilidad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Establecer_Disponibilidad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Establecer_Disponibilidad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Establecer_Disponibilidad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Establecer_Disponibilidad().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTNEstablecer;
    private javax.swing.JSpinner JSFin;
    private javax.swing.JSpinner JSInicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
