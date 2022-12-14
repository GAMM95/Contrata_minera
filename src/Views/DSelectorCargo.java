package Views;

import Models.Cargo;
import Models.CargoDAO;
import Models.CentrarColumnas;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class DSelectorCargo extends javax.swing.JDialog {

    //  Instancias;
    CargoDAO caDAO = new CargoDAO();

    public Cargo cargoSelected = new Cargo();

    public DSelectorCargo() {
        super(FrmMenu.getInstancia(), true);
        initComponents();
        setLocationRelativeTo(null);
        cargarTabla();
        setTitle("Selector de cargos");
    }

    private void cargarTabla() {
        DefaultTableModel model = (DefaultTableModel) tblCargos.getModel();
        model.setRowCount(0);
        int[] anchos = {50, 300};
        for (int i = 0; i < tblCargos.getColumnCount(); i++) {
            tblCargos.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
        tblCargos.getTableHeader().setFont(new Font("Roboto", Font.BOLD, 14));
        tblCargos.getTableHeader().setOpaque(false);
        tblCargos.getTableHeader().setBackground(Color.decode("#10316B"));
        tblCargos.getTableHeader().setForeground(Color.decode("#FFFFFF"));
        tblCargos.setDefaultRenderer(Object.class, new CentrarColumnas());
        caDAO.listarCargosDialog(model);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtBusqueda = new gamm_TextField.TextField();
        btnSeleccionar = new gamm_Button.Button();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblCargos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(223, 246, 240));

        txtBusqueda.setBackground(new java.awt.Color(223, 246, 240));
        txtBusqueda.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtBusqueda.setLabelText("Burcar cargo");
        txtBusqueda.setLineColor(new java.awt.Color(70, 179, 230));
        txtBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBusquedaKeyReleased(evt);
            }
        });

        btnSeleccionar.setBackground(new java.awt.Color(16, 49, 107));
        btnSeleccionar.setForeground(new java.awt.Color(223, 246, 240));
        btnSeleccionar.setText("SELECCIONAR");
        btnSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarActionPerformed(evt);
            }
        });

        tblCargos.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        tblCargos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "COD", "CARGO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblCargos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tblCargos.setRowHeight(25);
        tblCargos.setShowVerticalLines(false);
        tblCargos.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tblCargos);
        if (tblCargos.getColumnModel().getColumnCount() > 0) {
            tblCargos.getColumnModel().getColumn(0).setResizable(false);
            tblCargos.getColumnModel().getColumn(1).setResizable(false);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(btnSeleccionar, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSeleccionar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarActionPerformed
        DefaultTableModel model = (DefaultTableModel) tblCargos.getModel();
        int i = tblCargos.getSelectedRow();
        if (i != -1) {
            cargoSelected.setCodigo(Integer.parseInt(model.getValueAt(i, 0).toString()));
            cargoSelected.setNombreCargo(model.getValueAt(i, 1).toString());
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Debes seleccionar un elemento");
        }
    }//GEN-LAST:event_btnSeleccionarActionPerformed

    private void txtBusquedaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBusquedaKeyReleased
        DefaultTableModel model = (DefaultTableModel) tblCargos.getModel();
        String cargo = txtBusqueda.getText();
        caDAO.filtrarBusqueda(cargo, model);

    }//GEN-LAST:event_txtBusquedaKeyReleased

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DSelectorCargo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            DSelectorCargo dialog = new DSelectorCargo();
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
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblCargos;
    public gamm_TextField.TextField txtBusqueda;
    // End of variables declaration//GEN-END:variables
}
