package VIEW;

import MODEL.Estudiante;
import CONTROLER.ProcesarEstudiantes;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FormTestEstudiante extends javax.swing.JFrame {

    DefaultTableModel modelo;
    ArrayList<Estudiante> lstEst = new ArrayList<>();
    ProcesarEstudiantes procesarEstudiantes = new ProcesarEstudiantes(lstEst);

    public FormTestEstudiante() {
        initComponents();
        modelo = (DefaultTableModel) this.jTable1.getModel();
    }

    @SuppressWarnings("unchecked")

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        BTN_Conectar = new javax.swing.JButton();
        BTN_Actualizar = new javax.swing.JButton();
        BTN_Created = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        BTN_Guardar = new javax.swing.JButton();
        BTN_Eliminar = new javax.swing.JButton();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        BTN_Conectar.setText("Conectar");
        BTN_Conectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_ConectarActionPerformed(evt);
            }
        });

        BTN_Actualizar.setText("Actualizar");
        BTN_Actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_ActualizarActionPerformed(evt);
            }
        });

        BTN_Created.setText("Añadir");
        BTN_Created.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_CreatedActionPerformed(evt);
            }
        });

        jButton4.setText("Cerrar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Nota1", "Nota2", "Promedio", "Estado", "ID"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.setToolTipText("");
        jScrollPane1.setViewportView(jTable1);

        BTN_Guardar.setText("Guardar");
        BTN_Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_GuardarActionPerformed(evt);
            }
        });

        BTN_Eliminar.setText("Eliminar");
        BTN_Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_EliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BTN_Conectar)
                        .addGap(18, 18, 18)
                        .addComponent(BTN_Created)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BTN_Eliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BTN_Actualizar))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(BTN_Guardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton4))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 528, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(81, 81, 81)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BTN_Conectar)
                    .addComponent(BTN_Actualizar)
                    .addComponent(BTN_Created)
                    .addComponent(BTN_Eliminar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(BTN_Guardar))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BTN_ConectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_ConectarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BTN_ConectarActionPerformed

    private void BTN_ActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_ActualizarActionPerformed
        // TODO add your handling code here:
        while (modelo.getRowCount() > 0) {
            this.modelo.removeRow(0);
        }
        lstEst = procesarEstudiantes.getLstEstudiantes();
        for (Estudiante est : lstEst)
            this.modelo.addRow(new Object[]{est.nombreEst, est.nota1, est.nota2, est.promedio, est.estado, est.id});
    }//GEN-LAST:event_BTN_ActualizarActionPerformed

    private void BTN_CreatedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_CreatedActionPerformed
        modelo.addRow(new Object[]{"", 0.0, 0.0, 0.0, "", ""});
    }//GEN-LAST:event_BTN_CreatedActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void BTN_GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_GuardarActionPerformed

        int rowCount = modelo.getRowCount();
        for (int i = 0; i < rowCount; i++) {
            String nombre = (String) modelo.getValueAt(i, 0);
            double nota1 = Double.parseDouble(modelo.getValueAt(i, 1).toString());
            double nota2 = Double.parseDouble(modelo.getValueAt(i, 2).toString());
            String id = (String) modelo.getValueAt(i, 5);

            Estudiante estudiante = new Estudiante(nombre, nota1, nota2, id);
            procesarEstudiantes.getLstEstudiantes().add(estudiante);
            procesarEstudiantes.calculoPromedios();
            procesarEstudiantes.calculoEstados();
            procesarEstudiantes.insertarEstudiante(estudiante);
        }

    }//GEN-LAST:event_BTN_GuardarActionPerformed

    private void BTN_EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_EliminarActionPerformed
        int fila = this.jTable1.getSelectedRow();
        String id =  null;
        try {
            if(fila<0){
                JOptionPane.showMessageDialog(null, "Estudiante no seleccionado");
                for (int i = 0; i <= jTable1.getSelectedRow(); i++) {
                    modelo.removeRow(i);
                    i = i-1;
                }
            }else{
                procesarEstudiantes.deletedEstudiante(id);
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_BTN_EliminarActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(FormTestEstudiante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormTestEstudiante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormTestEstudiante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormTestEstudiante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormTestEstudiante().setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTN_Actualizar;
    private javax.swing.JButton BTN_Conectar;
    private javax.swing.JButton BTN_Created;
    private javax.swing.JButton BTN_Eliminar;
    private javax.swing.JButton BTN_Guardar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
