package Controllers;

import Models.Vale;
import Models.ValeDAO;
import Views.FrmMenu;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ValeController implements ActionListener {

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

    }

    //  Metodo para cargar datos
    private void cargarTabla() {

    }

    //  Metodo para activar botones
    private void enableButtons() {

    }

    //  Metodo para desactivar botones
    private void disableButtons() {

    }

    //  Metodo para limpiar inputs
    private void limpiarInputs() {

    }

    //  Metodo para limpiar mensajes de error
    private void limpiarMensajesError() {

    }

    //  Metodo para validar campos vacios
    private boolean validarCamposVacios() {
        boolean valor = true;   // Valor inicial verdadero

        return valor;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

}
