package Controllers;

import Models.CentrarColumnas;
import Models.Vale;
import Models.ValeDAO;
import Models.Validaciones;
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

public class ValeController implements ActionListener, MouseListener, KeyListener {

    //  Instancias
    private Vale vale;
    private ValeDAO valeDAO;
    private FrmMenu frmMenu;

    // Constructor 
    public ValeController(Vale vale, ValeDAO valeDAO, FrmMenu frmMenu) {
        this.vale = vale;
        this.valeDAO = valeDAO;
        this.frmMenu = frmMenu;
        interfaces();
        cargarTabla();
        limpiarInputs();
        limpiarMensajesError();
        enableButtons();
    }

    //  Metodo para implementar interfaces
    private void interfaces() {
        //  Eventos ActionListener
        frmMenu.btnRegistrarVale.addActionListener(this);
        frmMenu.btnActualizarVale.addActionListener(this);

        //  Eventos KeyListener
        frmMenu.txtCodVale.addKeyListener(this);
        frmMenu.txtLugar.addKeyListener(this);
        frmMenu.txtHorometroVale.addKeyListener(this);
        frmMenu.txtGalonesVale.addKeyListener(this);

        //  Eventos MouseListener
        frmMenu.btnSeleccionarRepartoVale.addMouseListener(this);
        frmMenu.txtFechaAbastecimiento.addMouseListener(this);
    }

    //  Metodo para cargar datos
    private void cargarTabla() {
        DefaultTableModel model = (DefaultTableModel) frmMenu.tblVale.getModel();
        int[] anchos = {8, 20, 50, 50, 30, 100, 30, 50, 30};
        model.setRowCount(0);
        for (int i = 0; i < frmMenu.tblVale.getColumnCount(); i++) {
            frmMenu.tblVale.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
        frmMenu.tblVale.setDefaultRenderer(Object.class, new CentrarColumnas());  //  Centrado de valores de las columnas
        valeDAO.listarVales(model);
    }

    //  Metodo para activar botones
    private void enableButtons() {
        frmMenu.btnRegistrarCargo.setEnabled(true);
        frmMenu.btnActualizarVale.setEnabled(false);
    }

    //  Metodo para desactivar botones
    private void disableButtons() {
        frmMenu.btnRegistrarCargo.setEnabled(false);
        frmMenu.btnActualizarVale.setEnabled(true);
    }

    //  Metodo para limpiar inputs
    private void limpiarInputs() {
        frmMenu.txtIdVale.setText("");
        frmMenu.txtCodVale.setText("");
        frmMenu.txtFechaAbastecimiento.setText("");
        frmMenu.txtHoraAbastecimiento.setText("");
        frmMenu.txtLugar.setText("");
        frmMenu.txtHorometroVale.setText("");
        frmMenu.txtGalonesVale.setText("");
        frmMenu.txtCodRepartoVale.setText("");
        frmMenu.txtTrabajadorAsignadoVale.setText("");
        frmMenu.txtGuardiaAsignadoVale.setText("");
        frmMenu.txtTurnoAsignadoVale.setText("");
        frmMenu.txtVehiculoAsignadoVale.setText("");
    }

    //  Metodo para limpiar mensajes de error
    private void limpiarMensajesError() {
        frmMenu.mCodVale.setText("");
        frmMenu.mFechaAbastecimiento.setText("");
        frmMenu.mHoraAbastecimiento.setText("");
        frmMenu.mLugar.setText("");
        frmMenu.mHorometroVale.setText("");
        frmMenu.mGalones.setText("");
        frmMenu.mRepartoAsignado.setText("");

    }

    //  Metodo para validar campos vacios
    private boolean validarCamposVacios() {
        boolean valor = true;   // Valor inicial verdadero
        if (frmMenu.txtCodVale.getText().equals("")) {
            frmMenu.mCodVale.setText("Ingrese código");
            frmMenu.mCodVale.setForeground(Color.red);
            frmMenu.txtCodVale.requestFocus();
            valor = false;
        } else if (frmMenu.txtFechaAbastecimiento.getText().equals("")) {
            frmMenu.mFechaAbastecimiento.setText("Seleccione una fecha");
            frmMenu.mFechaAbastecimiento.setForeground(Color.red);
            valor = false;
        } else if (frmMenu.txtLugar.getText().trim().equals("")) {
            frmMenu.mLugar.setText("Ingrese lugar de abastecimiento");
            frmMenu.mLugar.setForeground(Color.red);
            frmMenu.txtLugar.requestFocus();
            valor = false;
        } else if (frmMenu.txtHorometroVale.getText().trim().equals("")) {
            frmMenu.mHorometroVale.setText("Ingrese horómetro");
            frmMenu.mHorometroVale.setForeground(Color.red);
            frmMenu.txtHorometroVale.requestFocus();
            valor = false;
        } else if (frmMenu.txtGalonesVale.getText().trim().equals("")) {
            frmMenu.mGalones.setText("Ingrese galones");
            frmMenu.mGalones.setForeground(Color.red);
            frmMenu.txtGalonesVale.requestFocus();
            valor = false;
        } else if (frmMenu.txtCodRepartoVale.getText().equals("")) {
            frmMenu.mRepartoAsignado.setText("Asigne reparto de guardia");
            frmMenu.mRepartoAsignado.setForeground(Color.red);
            valor = false;
        }
        return valor;
    }

    //  Validar existencia de codigo de vale de combustible
    private boolean validarExistenciaVale() {
        boolean valor = true;
        if (valeDAO.existenciaCodVale(frmMenu.txtCodVale.getText()) != 0) {
            frmMenu.mCodVale.setText("Codigo de boucher ya existe");
            frmMenu.mCodVale.setForeground(Color.red);
            frmMenu.txtCodVale.requestFocus();
            valor = false;
        }
        return valor;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //  Evento ActionListener del boton registrar
        if (e.getSource().equals(frmMenu.btnRegistrarVale)) {
            boolean validarVacios = validarCamposVacios();
            boolean validarVale = validarExistenciaVale();

            if (validarVacios == false) { // Si los campos estan vacios
                validarCamposVacios();
            } else {
                if (validarVale == false) {
                    validarExistenciaVale();
                } else {
                    String codVale = frmMenu.txtCodVale.getText();
                    Date fechaAbastecimiento = Date.valueOf(frmMenu.txtFechaAbastecimiento.getText());
                    String hora = frmMenu.txtHoraAbastecimiento.getText();
                    String lugar = frmMenu.txtLugar.getText();
                    double horometro = Double.parseDouble(frmMenu.txtHorometroVale.getText());
                    double galones = Double.parseDouble(frmMenu.txtGalonesVale.getText());
                    int codReparto = Integer.parseInt(frmMenu.txtCodRepartoVale.getText());

                    vale = new Vale(codVale, fechaAbastecimiento, hora, lugar, horometro, galones, codReparto);
                    if (valeDAO.registrarVale(vale)) {
                        cargarTabla();
                        limpiarInputs();
                        JOptionPane.showMessageDialog(frmMenu.tblVale, "Vale de combustible registrado");
                    } else {
                        JOptionPane.showMessageDialog(frmMenu.tblVale, "No se registró vale de combustible");
                    }
                }
            }
        }
        //  Evento ActionListener del boton actualizar
        if (e.getSource().equals(frmMenu.btnActualizarVale)) {

        }

    }

    @Override
    public void mouseClicked(MouseEvent me) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        // Evento MousePressed para el boton seleccionar Reparto
        if (e.getSource().equals(frmMenu.btnSeleccionarRepartoVale)) {
            frmMenu.mRepartoAsignado.setText("");
        }
        //  Eventi MousePressed para la fecha de abastecimiento
        if (e.getSource().equals(frmMenu.txtFechaAbastecimiento)) {
            frmMenu.mFechaAbastecimiento.setText("");
        }
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

    @Override
    public void keyTyped(KeyEvent e) {
        //  Evento KeyTyped para validar la cantidad de caracteres
        if (e.getSource().equals(frmMenu.txtCodVale)) {
            Validaciones.soloDigitos(e);
            int limite = 6;
            if (frmMenu.txtCodVale.getText().length() == limite) {
                e.consume();
            }
        } else if (e.getSource().equals(frmMenu.txtHorometroVale)) {
            Validaciones.soloDigitos(e);
            int limite = 8;
            if (frmMenu.txtHorometroVale.getText().length() == limite) {
                e.consume();
            }
        } else if (e.getSource().equals(frmMenu.txtGalonesVale)) {
            Validaciones.soloDigitos(e);
            int limite = 8;
            if (frmMenu.txtGalonesVale.getText().length() == limite) {
                e.consume();
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent ke) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Eventos KeyReleased para ocultar mensajes al escribir caracteres
        if (e.getSource().equals(frmMenu.txtCodVale)) {
            frmMenu.mCodVale.setText("");
        } else if (e.getSource().equals(frmMenu.txtLugar)) {
            frmMenu.mLugar.setText("");
        } else if (e.getSource().equals(frmMenu.txtHorometroVale)) {
            frmMenu.mHorometroVale.setText("");
        } else if (e.getSource().equals(frmMenu.txtGalonesVale)) {
            frmMenu.mGalones.setText("");
        }
    }
}
