package Controllers;

import Models.CentrarColumnas;
import Models.ColorearLabels;
import Models.ColorearRows;
import Models.Reparto;
import Models.RepartoDAO;
import Views.FrmMenu;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class RepartoController implements ActionListener, KeyListener, MouseListener {

    //  Atributos de clase
    private Reparto re;
    private RepartoDAO reDAO;
    private FrmMenu frmMenu;

    // Constructor
    public RepartoController(Reparto re, RepartoDAO reDAO, FrmMenu frmMenu) {
        this.re = re;
        this.reDAO = reDAO;
        this.frmMenu = frmMenu;
        interfaces();
        limpiarInputs();
        limpiarMensajesError();
        cargarTabla();
    }

    //  Metodo para implementar interfaces
    private void interfaces() {
        // Eventos ActionListener
        frmMenu.btnRegistrarReparto.addActionListener(this);
        //  Evento KeyListener
        frmMenu.txtFiltrarTrabajadorReparto.addKeyListener(this);
        //  Eventos MouseListener
        frmMenu.tblRepartoA.addMouseListener(this);
    }

    // Metodo para listar datos
    private void cargarTabla() {
        // Vista Usuario
        int[] anchos = {10, 50, 200, 40, 10};
        DefaultTableModel modelA = (DefaultTableModel) frmMenu.tblRepartoA.getModel();
        modelA.setRowCount(0);
        for (int i = 0; i < frmMenu.tblRepartoA.getColumnCount(); i++) {
            frmMenu.tblRepartoA.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
        frmMenu.tblRepartoA.setDefaultRenderer(Object.class, new CentrarColumnas());  //  Centrado de valores de las columnas
        frmMenu.tblRepartoA.getColumnModel().getColumn(0).setCellRenderer(new ColorearRows(0));
        frmMenu.tblRepartoA.getColumnModel().getColumn(1).setCellRenderer(new ColorearRows(1));
        frmMenu.tblRepartoA.getColumnModel().getColumn(2).setCellRenderer(new ColorearRows(2));
        frmMenu.tblRepartoA.getColumnModel().getColumn(3).setCellRenderer(new ColorearRows(3));
        frmMenu.tblRepartoA.getColumnModel().getColumn(4).setCellRenderer(new ColorearRows(4));
        reDAO.listarRepartoA(modelA);

        DefaultTableModel modelB = (DefaultTableModel) frmMenu.tblRepartoB.getModel();
        modelB.setRowCount(0);
        for (int i = 0; i < frmMenu.tblRepartoB.getColumnCount(); i++) {
            frmMenu.tblRepartoB.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
        frmMenu.tblRepartoB.setDefaultRenderer(Object.class, new CentrarColumnas());  //  Centrado de valores de las columnas
        frmMenu.tblRepartoB.getColumnModel().getColumn(0).setCellRenderer(new ColorearRows(0));
        frmMenu.tblRepartoB.getColumnModel().getColumn(1).setCellRenderer(new ColorearRows(1));
        frmMenu.tblRepartoB.getColumnModel().getColumn(2).setCellRenderer(new ColorearRows(2));
        frmMenu.tblRepartoB.getColumnModel().getColumn(3).setCellRenderer(new ColorearRows(3));
        frmMenu.tblRepartoB.getColumnModel().getColumn(4).setCellRenderer(new ColorearRows(4));
        reDAO.listarRepartoB(modelB);

        DefaultTableModel modelC = (DefaultTableModel) frmMenu.tblRepartoC.getModel();
        modelC.setRowCount(0);
        for (int i = 0; i < frmMenu.tblRepartoC.getColumnCount(); i++) {
            frmMenu.tblRepartoC.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
        frmMenu.tblRepartoC.setDefaultRenderer(Object.class, new CentrarColumnas());  //  Centrado de valores de las columnas
        frmMenu.tblRepartoC.getColumnModel().getColumn(0).setCellRenderer(new ColorearRows(0));
        frmMenu.tblRepartoC.getColumnModel().getColumn(1).setCellRenderer(new ColorearRows(1));
        frmMenu.tblRepartoC.getColumnModel().getColumn(2).setCellRenderer(new ColorearRows(2));
        frmMenu.tblRepartoC.getColumnModel().getColumn(3).setCellRenderer(new ColorearRows(3));
        frmMenu.tblRepartoC.getColumnModel().getColumn(4).setCellRenderer(new ColorearRows(4));
        reDAO.listarRepartoC(modelC);
    }

    // Metodo para limpiar entradas
    private void limpiarInputs() {
        frmMenu.txtIdTrabajadorReparto.setText("");
        frmMenu.txtTrabajadorAsignadoReparto.setText("");
        frmMenu.txtCargoSeleccionadoReparto.setText("");
        frmMenu.txtCodGuardiaReparto.setText("");
        frmMenu.txtGuardiaSeleccionadaReparto.setText("");
        frmMenu.txtTurnoSeleccionadoReparto.setText("");
        frmMenu.txtCodVehiculoReparto.setText("");
        frmMenu.txtVehiculoSeleccionadoReparto.setText("");
        frmMenu.txtTipoSeleccionadoReparto.setText("");
        frmMenu.Asistencia.clearSelection();
        frmMenu.tblRepartoA.clearSelection();
        frmMenu.tblRepartoB.clearSelection();
        frmMenu.tblRepartoC.clearSelection();
    }

    // Metodo para limpiar mensajes de error
    private void limpiarMensajesError() {
        frmMenu.mTrabajadorAsignadoReparto.setText("");
        frmMenu.mGuardiaSeleccionadaReparto.setText("");
        frmMenu.mVehiculoSeleccionadoReparto.setText("");
    }

    //  Metodo para habilitar botones
    private void enableButtons() {
        frmMenu.btnRegistrarReparto.setEnabled(true);
    }

    //  Metodo para deshabilitar botones
    private void disableButtons() {
        frmMenu.btnRegistrarReparto.setEnabled(false);
    }

    //  Metodo para validar campos vacios
    private boolean validarCamposVacios() {
        boolean valor = true;   // Valor inicial verdadero
        if (frmMenu.txtTrabajadorAsignadoReparto.getText().isEmpty()) {
            frmMenu.mTrabajadorAsignadoReparto.setText("Seleccione un trabajador");
            frmMenu.mTrabajadorAsignadoReparto.setForeground(Color.red);
            valor = false;
        } else if (frmMenu.txtGuardiaSeleccionadaReparto.getText().isEmpty()) {
            frmMenu.mGuardiaSeleccionadaReparto.setText("Seleccione una guardia");
            frmMenu.mGuardiaSeleccionadaReparto.setForeground(Color.red);
            valor = false;
        } else if (frmMenu.txtVehiculoSeleccionadoReparto.getText().equals("")) {
            frmMenu.mVehiculoSeleccionadoReparto.setText("Seleccione un vehiculo");
            frmMenu.mVehiculoSeleccionadoReparto.setForeground(Color.red);
            valor = false;
        }
        return valor;
    }

    //  Metodo para validar registros de repartos diarios
    private boolean validarRepartoDiario() {
        boolean valor = true;
        if (frmMenu.txtIdTrabajadorReparto.getText().isEmpty()) {
            frmMenu.mTrabajadorAsignadoReparto.setText("Seleccione un trabajador");
        } else if (reDAO.existenciaRepartoDiario(Integer.parseInt(frmMenu.txtIdTrabajadorReparto.getText())) != 0) {
            frmMenu.mTrabajadorAsignadoReparto.setText("Reparto para este trabajador ya existe");
            frmMenu.mTrabajadorAsignadoReparto.setForeground(Color.red);
            valor = false;
        }
        return valor;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(frmMenu.btnRegistrarReparto)) {
            boolean validarVacios = validarCamposVacios();
            boolean validarReparto = validarRepartoDiario();

            if (validarVacios == false) { // Si los campos estan vacios
                validarCamposVacios();
            } else {
                if (validarReparto == false) {
                    validarRepartoDiario();
                } else {
                    Date fechaReparto = Date.valueOf(frmMenu.txtFechaReparto.getText());
                    int codGuardia = Integer.parseInt(frmMenu.txtCodGuardiaReparto.getText());
                    int idTrabajador = Integer.parseInt(frmMenu.txtIdTrabajadorReparto.getText());
                    int codVehiculo = Integer.parseInt(frmMenu.txtCodVehiculoReparto.getText());
                    String asistencia;
                    if (frmMenu.opSi.isSelected()) {
                        asistencia = "Si";
                    } else {
                        asistencia = "No";
                    }
                    re = new Reparto(fechaReparto, asistencia, codGuardia, idTrabajador, codVehiculo);
                    if (reDAO.registrarReparto(re)) {
                        cargarTabla();
                        limpiarInputs();
                        JOptionPane.showMessageDialog(null, "Reparto registrado");
                    } else {
                        JOptionPane.showMessageDialog(null, "Reparto no registrado");
                    }
                }
            }

        }
    }

    @Override
    public void keyTyped(KeyEvent ke) {

    }

    @Override
    public void keyPressed(KeyEvent ke) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getSource().equals(frmMenu.txtFiltrarTrabajadorReparto)) {
            DefaultTableModel modelA = (DefaultTableModel) frmMenu.tblRepartoA.getModel();
            DefaultTableModel modelB = (DefaultTableModel) frmMenu.tblRepartoB.getModel();
            DefaultTableModel modelC = (DefaultTableModel) frmMenu.tblRepartoC.getModel();
            String nombreTrabajador = frmMenu.txtFiltrarTrabajadorReparto.getText();
            reDAO.filtrarNombre(nombreTrabajador, modelA, modelB, modelC);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource().equals(frmMenu.tblRepartoA)) {
            disableButtons();
            limpiarMensajesError();
            int fila = frmMenu.tblRepartoA.getSelectedRow();
            int codReparto = Integer.parseInt(frmMenu.tblRepartoA.getValueAt(fila, 0).toString());
            frmMenu.txtCodReparto.setText(String.valueOf(codReparto));

            if (!frmMenu.txtCodReparto.getText().isEmpty()) {
                int cod = Integer.parseInt(frmMenu.txtCodReparto.getText());
                re = reDAO.consultarReparto(cod);
                // seteo de datos
                frmMenu.txtTrabajadorAsignadoReparto.setText(String.valueOf(re.getTrabajador()));
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent me) {

    }

    @Override
    public void mouseReleased(MouseEvent me) {

    }

    @Override
    public void mouseEntered(MouseEvent me) {

    }

    @Override
    public void mouseExited(MouseEvent me) {

    }

}
