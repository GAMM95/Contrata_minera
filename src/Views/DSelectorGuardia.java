package Views;

import Models.CentrarColumnas;
import Models.Guardia;
import Models.GuardiaDAO;
import Models.Turno;
import Models.Validaciones;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class DSelectorGuardia extends javax.swing.JDialog {

    //  Instancias
    GuardiaDAO guaDAO = new GuardiaDAO();
    public Guardia guardiaSelected = new Guardia();
    public Turno turnoSelected = new Turno();

    public DSelectorGuardia() {
        super(FrmMenu.getInstancia(), true);
        initComponents();
        setLocationRelativeTo(null);
        cargarTabla();
        setTitle("Selector de guardias");
    }

    //  Metodo para cargar datos en la tabla
    private void cargarTabla() {
        DefaultTableModel model = (DefaultTableModel) tblGuardiaSelector.getModel();
        model.setRowCount(0);
        int[] anchos = {10, 50, 30};
        for (int i = 0; i < tblGuardiaSelector.getColumnCount(); i++) {
            tblGuardiaSelector.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
        tblGuardiaSelector.getTableHeader().setFont(new Font("Roboto", Font.BOLD, 14));
        tblGuardiaSelector.getTableHeader().setOpaque(false);
        tblGuardiaSelector.getTableHeader().setBackground(Color.decode("#243b55"));
        tblGuardiaSelector.getTableHeader().setForeground(Color.decode("#FFFFFF"));
        tblGuardiaSelector.setDefaultRenderer(Object.class, new CentrarColumnas());
        guaDAO.listarGuardiasDialog(model);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtBusqueda = new gamm_TextField.TextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblGuardiaSelector = new javax.swing.JTable();
        btnSeleccionar = new gamm_Button.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        txtBusqueda.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtBusqueda.setLabelText("Buscar guardia");
        txtBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBusquedaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBusquedaKeyTyped(evt);
            }
        });

        tblGuardiaSelector.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        tblGuardiaSelector.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "COD", "GUARDIA", "TURNO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblGuardiaSelector.setRowHeight(25);
        tblGuardiaSelector.setShowVerticalLines(false);
        tblGuardiaSelector.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblGuardiaSelector);
        if (tblGuardiaSelector.getColumnModel().getColumnCount() > 0) {
            tblGuardiaSelector.getColumnModel().getColumn(0).setResizable(false);
            tblGuardiaSelector.getColumnModel().getColumn(1).setResizable(false);
            tblGuardiaSelector.getColumnModel().getColumn(2).setResizable(false);
        }

        btnSeleccionar.setText("SELECCIONAR");
        btnSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(63, 63, 63)
                        .addComponent(btnSeleccionar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(48, 48, 48))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(20, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSeleccionar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
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

    private void btnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarActionPerformed
        DefaultTableModel model = (DefaultTableModel) tblGuardiaSelector.getModel();
        int i = tblGuardiaSelector.getSelectedRow();
        if (i != -1) {
            guardiaSelected.setCodGuardia(Integer.parseInt(model.getValueAt(i, 0).toString()));
            guardiaSelected.setNombreGuardia(model.getValueAt(i, 1).toString());
            turnoSelected.setNombreTurno(model.getValueAt(i, 2).toString());
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(tblGuardiaSelector, "Debes selccionar un elemento");
        }
    }//GEN-LAST:event_btnSeleccionarActionPerformed

    private void txtBusquedaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBusquedaKeyTyped
        Validaciones.soloLetras(evt);
    }//GEN-LAST:event_txtBusquedaKeyTyped

    private void txtBusquedaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBusquedaKeyReleased
        DefaultTableModel model = (DefaultTableModel) tblGuardiaSelector.getModel();
        String nombre = txtBusqueda.getText();
        guaDAO.filtrarBusquedaSelector(nombre, model);
    }//GEN-LAST:event_txtBusquedaKeyReleased

//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Windows".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(DSelectorGuardia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//
//        java.awt.EventQueue.invokeLater(() -> {
//            DSelectorGuardia dialog = new DSelectorGuardia();
//            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
//                @Override
//                public void windowClosing(java.awt.event.WindowEvent e) {
//                    System.exit(0);
//                }
//            });
//            dialog.setVisible(true);
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public gamm_Button.Button btnSeleccionar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable tblGuardiaSelector;
    public gamm_TextField.TextField txtBusqueda;
    // End of variables declaration//GEN-END:variables
}
