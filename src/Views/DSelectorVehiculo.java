package Views;

import Models.CentrarColumnas;
import Models.TipoVehiculo;
import Models.Vehiculo;
import Models.VehiculoDAO;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class DSelectorVehiculo extends javax.swing.JDialog {

    //  Instancias
    public Vehiculo vehiculoSelected = new Vehiculo();
    public TipoVehiculo tipoSelected = new TipoVehiculo();
    VehiculoDAO veDAO = new VehiculoDAO();

    public DSelectorVehiculo() {
        super(FrmMenu.getInstancia(), true);
        initComponents();
        setLocationRelativeTo(null);
        cargarTabla();
        setTitle("Selector de vehículos");
    }

    private void cargarTabla() {
        DefaultTableModel model = (DefaultTableModel) tblVehiculosSelector.getModel();
        model.setRowCount(0);
        int[] anchos = {10, 50, 30};
        for (int i = 0; i < tblVehiculosSelector.getColumnCount(); i++) {
            tblVehiculosSelector.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
        tblVehiculosSelector.getTableHeader().setFont(new Font("Roboto", Font.BOLD, 14));
        tblVehiculosSelector.getTableHeader().setOpaque(false);
        tblVehiculosSelector.getTableHeader().setBackground(Color.decode("#243b55"));
        tblVehiculosSelector.getTableHeader().setForeground(Color.decode("#FFFFFF"));
        tblVehiculosSelector.setDefaultRenderer(Object.class, new CentrarColumnas());
        veDAO.listarVehiculosDialog(model);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtBusqueda = new gamm_TextField.TextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblVehiculosSelector = new javax.swing.JTable();
        btnSeleccionar = new gamm_Button.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        txtBusqueda.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtBusqueda.setLabelText("Buscar vehículo");
        txtBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBusquedaKeyReleased(evt);
            }
        });

        tblVehiculosSelector.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        tblVehiculosSelector.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "COD", "VEHÍCULO", "TIPO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblVehiculosSelector.setRowHeight(25);
        tblVehiculosSelector.setShowVerticalLines(false);
        tblVehiculosSelector.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblVehiculosSelector);
        if (tblVehiculosSelector.getColumnModel().getColumnCount() > 0) {
            tblVehiculosSelector.getColumnModel().getColumn(0).setResizable(false);
            tblVehiculosSelector.getColumnModel().getColumn(1).setResizable(false);
            tblVehiculosSelector.getColumnModel().getColumn(2).setResizable(false);
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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57)
                        .addComponent(btnSeleccionar, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSeleccionar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarActionPerformed
        DefaultTableModel model = (DefaultTableModel) tblVehiculosSelector.getModel();
        int i = tblVehiculosSelector.getSelectedRow();
        if (i != -1) {
            vehiculoSelected.setCodVehiculo(Integer.parseInt(model.getValueAt(i, 0).toString()));
            vehiculoSelected.setIdVehiculo(model.getValueAt(i, 1).toString());
            tipoSelected.setNombreTipo(model.getValueAt(i, 2).toString());
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(tblVehiculosSelector, "Debes selccionar un elemento");
        }
    }//GEN-LAST:event_btnSeleccionarActionPerformed

    private void txtBusquedaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBusquedaKeyReleased
        DefaultTableModel model = (DefaultTableModel) tblVehiculosSelector.getModel();
        String id = txtBusqueda.getText();
        veDAO.filtrarBusquedaSelector(id, model);
    }//GEN-LAST:event_txtBusquedaKeyReleased

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DSelectorVehiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(() -> {
            DSelectorVehiculo dialog = new DSelectorVehiculo();
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public gamm_Button.Button btnSeleccionar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable tblVehiculosSelector;
    public gamm_TextField.TextField txtBusqueda;
    // End of variables declaration//GEN-END:variables
}
