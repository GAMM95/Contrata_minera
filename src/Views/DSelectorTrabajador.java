package Views;

import Models.Cargo;
import Models.CentrarColumnas;
import Models.Trabajador;
import Models.TrabajadorDAO;
import Models.Validaciones;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class DSelectorTrabajador extends javax.swing.JDialog {

    //  Instancias;
    TrabajadorDAO traDAO = new TrabajadorDAO();
    public Trabajador trabajadorSelected = new Trabajador();
    public Cargo cargoSelected = new Cargo();

    public DSelectorTrabajador() {
        super(FrmMenu.getInstancia(), true);
        initComponents();
        setLocationRelativeTo(null);
        cargarTabla();
        setTitle("Selector de trabajadores");
    }

    private void cargarTabla() {
        DefaultTableModel model = (DefaultTableModel) tblTrabajadores.getModel();
        model.setRowCount(0);
        int[] anchos = {30, 220, 180};
        for (int i = 0; i < tblTrabajadores.getColumnCount(); i++) {
            tblTrabajadores.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
        tblTrabajadores.getTableHeader().setFont(new Font("Roboto", Font.BOLD, 14));
        tblTrabajadores.getTableHeader().setOpaque(false);
        tblTrabajadores.getTableHeader().setBackground(Color.decode("#243b55"));
        tblTrabajadores.getTableHeader().setForeground(Color.decode("#FFFFFF"));
        tblTrabajadores.setDefaultRenderer(Object.class, new CentrarColumnas());
        traDAO.listarTrabajadoresDialog(model);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtBusqueda = new gamm_TextField.TextField();
        btnSeleccionar = new gamm_Button.Button();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTrabajadores = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        txtBusqueda.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtBusqueda.setLabelText("Buscar trabajador");
        txtBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBusquedaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBusquedaKeyTyped(evt);
            }
        });

        btnSeleccionar.setText("SELECCIONAR");
        btnSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarActionPerformed(evt);
            }
        });

        tblTrabajadores.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        tblTrabajadores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "TRABAJADOR", "CARGO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblTrabajadores.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tblTrabajadores.setRowHeight(25);
        tblTrabajadores.setShowVerticalLines(false);
        tblTrabajadores.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblTrabajadores);
        if (tblTrabajadores.getColumnModel().getColumnCount() > 0) {
            tblTrabajadores.getColumnModel().getColumn(0).setResizable(false);
            tblTrabajadores.getColumnModel().getColumn(1).setResizable(false);
            tblTrabajadores.getColumnModel().getColumn(2).setResizable(false);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 502, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(75, 75, 75)
                        .addComponent(btnSeleccionar, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSeleccionar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarActionPerformed
        DefaultTableModel model = (DefaultTableModel) tblTrabajadores.getModel();
        int i = tblTrabajadores.getSelectedRow();
        if (i != -1) {
            trabajadorSelected.setIdTrabajador(Integer.parseInt(model.getValueAt(i, 0).toString()));
            trabajadorSelected.setApePaterno(model.getValueAt(i, 1).toString());
            trabajadorSelected.setApeMaterno(model.getValueAt(i, 1).toString());
            trabajadorSelected.setNombres(model.getValueAt(i, 1).toString());
            cargoSelected.setNombreCargo(model.getValueAt(i, 2).toString());
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(tblTrabajadores, "Debes selccionar un elemento");
        }
    }//GEN-LAST:event_btnSeleccionarActionPerformed

    private void txtBusquedaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBusquedaKeyReleased
        DefaultTableModel model = (DefaultTableModel) tblTrabajadores.getModel();
        String cargo = txtBusqueda.getText();
        traDAO.filtrarBusquedaSelector(cargo, model);
    }//GEN-LAST:event_txtBusquedaKeyReleased

    private void txtBusquedaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBusquedaKeyTyped
        Validaciones.soloLetras(evt);
    }//GEN-LAST:event_txtBusquedaKeyTyped

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DSelectorTrabajador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            DSelectorTrabajador dialog = new DSelectorTrabajador();
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
    public javax.swing.JTable tblTrabajadores;
    public gamm_TextField.TextField txtBusqueda;
    // End of variables declaration//GEN-END:variables
}
