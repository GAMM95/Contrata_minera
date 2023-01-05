package Views;

import Models.CentrarColumnas;
import Models.Guardia;
import Models.Reparto;
import Models.RepartoDAO;
import Models.Trabajador;
import Models.Turno;
import Models.Vehiculo;
import gamm_DateChooser.SelectedAction;
import gamm_DateChooser.SelectedDate;
import java.awt.Color;
import java.awt.Font;
import java.sql.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class DSelectorReparto extends javax.swing.JDialog {

    //  Instancias;
    RepartoDAO reDAO = new RepartoDAO();

    public Reparto repartoSelected = new Reparto();
    public Trabajador trabajadorSelected = new Trabajador();
    public Guardia guardiaSelected = new Guardia();
    public Turno turnoSelected = new Turno();
    public Vehiculo vehiculoSelected = new Vehiculo();

    public DSelectorReparto() {
        super(FrmMenu.getInstancia(), true);
        initComponents();
        setLocationRelativeTo(null);
        cargarTabla();
        limpiarInputs();
        setTitle("Selector de repartos");
        //  Efecto popup para la fecha de caducidad de licencias
        fechaReparto.addEventDateChooser((SelectedAction action, SelectedDate sd) -> {
            if (action.getAction() == SelectedAction.DAY_SELECTED) {
                fechaReparto.hidePopup();
            }
        });
    }

    //  Metodo para limpiar entradas
    private void limpiarInputs() {
        txtBusqueda.setText("");
        txtFecha.setText("");
    }

    private void cargarTabla() {
        DefaultTableModel model = (DefaultTableModel) tblRepartos.getModel();
        model.setRowCount(0);
        int[] anchos = {10, 60, 250, 100, 50, 80};
        for (int i = 0; i < tblRepartos.getColumnCount(); i++) {
            tblRepartos.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
        tblRepartos.getTableHeader().setFont(new Font("Roboto", Font.BOLD, 14));
        tblRepartos.getTableHeader().setOpaque(false);
        tblRepartos.getTableHeader().setBackground(Color.decode("#10316B"));
        tblRepartos.getTableHeader().setForeground(Color.decode("#FFFFFF"));
        tblRepartos.setDefaultRenderer(Object.class, new CentrarColumnas());
        reDAO.mostrarRepartos(model);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fechaReparto = new gamm_DateChooser.DateChooser();
        jPanel1 = new javax.swing.JPanel();
        txtBusqueda = new gamm_TextField.TextField();
        btnSeleccionar = new gamm_Button.Button();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblRepartos = new javax.swing.JTable();
        txtFecha = new gamm_TextField.TextField();
        btnCancelar = new gamm_Button.Button();

        fechaReparto.setDateFormat("yyyy-MM-dd");
        fechaReparto.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        fechaReparto.setTextRefernce(txtFecha);

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

        tblRepartos.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        tblRepartos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "N°", "FECHA", "TRABAJADOR", "GUARDIA", "TURNO", "VEHÍCULO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblRepartos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tblRepartos.setRowHeight(25);
        tblRepartos.setShowVerticalLines(false);
        tblRepartos.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tblRepartos);
        if (tblRepartos.getColumnModel().getColumnCount() > 0) {
            tblRepartos.getColumnModel().getColumn(0).setResizable(false);
            tblRepartos.getColumnModel().getColumn(1).setResizable(false);
            tblRepartos.getColumnModel().getColumn(2).setResizable(false);
            tblRepartos.getColumnModel().getColumn(3).setResizable(false);
            tblRepartos.getColumnModel().getColumn(4).setResizable(false);
            tblRepartos.getColumnModel().getColumn(5).setResizable(false);
        }

        txtFecha.setEditable(true);
        txtFecha.setBackground(new java.awt.Color(223, 246, 240));
        txtFecha.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtFecha.setLabelText("Fecha ");

        btnCancelar.setBackground(new java.awt.Color(16, 49, 107));
        btnCancelar.setForeground(new java.awt.Color(223, 246, 240));
        btnCancelar.setText("CANCELAR");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(btnSeleccionar, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSeleccionar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
                .addGap(21, 21, 21))
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
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarActionPerformed
        DefaultTableModel model = (DefaultTableModel) tblRepartos.getModel();
        int i = tblRepartos.getSelectedRow();
        if (i != -1) {
            repartoSelected.setCodReparto(Integer.parseInt(model.getValueAt(i, 0).toString()));
            trabajadorSelected.setApePaterno(model.getValueAt(i, 2).toString());
            trabajadorSelected.setApeMaterno(model.getValueAt(i, 2).toString());
            trabajadorSelected.setNombres(model.getValueAt(i, 2).toString());
            guardiaSelected.setNombreGuardia(model.getValueAt(i, 3).toString());
            turnoSelected.setNombreTurno(model.getValueAt(i, 4).toString());
            vehiculoSelected.setIdVehiculo(model.getValueAt(i, 5).toString());
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Debes seleccionar un elemento");
        }
    }//GEN-LAST:event_btnSeleccionarActionPerformed

    private void txtBusquedaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBusquedaKeyReleased
        DefaultTableModel model = (DefaultTableModel) tblRepartos.getModel();
        String cargo = txtBusqueda.getText();
        Date fecha = Date.valueOf(txtFecha.getText());
        reDAO.filtrarRepartos(cargo, fecha, model);

    }//GEN-LAST:event_txtBusquedaKeyReleased

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        limpiarInputs();
        cargarTabla();
    }//GEN-LAST:event_btnCancelarActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DSelectorReparto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            DSelectorReparto dialog = new DSelectorReparto();
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
    public gamm_Button.Button btnCancelar;
    public gamm_Button.Button btnSeleccionar;
    private gamm_DateChooser.DateChooser fechaReparto;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblRepartos;
    public gamm_TextField.TextField txtBusqueda;
    private gamm_TextField.TextField txtFecha;
    // End of variables declaration//GEN-END:variables
}
