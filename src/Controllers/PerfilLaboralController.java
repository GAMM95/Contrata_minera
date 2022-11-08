package Controllers;

import Models.TrabajadorDAO;
import Views.FrmMenu;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PerfilLaboralController implements ActionListener {

    private TrabajadorDAO traDAO;
    private PerfilLaboral plab;
    private PerfilLaboralDAO plabDAO;
    private FrmMenu frmMenu;

    public PerfilLaboralController(TrabajadorDAO traDAO, PerfilLaboral plab, PerfilLaboralDAO plabDAO, FrmMenu frmMenu) {
        this.traDAO = traDAO;
        this.plab = plab;
        this.plabDAO = plabDAO;
        this.frmMenu = frmMenu;
        diseñarIntefaz();
        interfaces();
        llenarCombo();
        deshabilitarPanelCese();
    }

    //  Metodo para diseñar el panel de perfil laboral de trabajadores
    private void diseñarIntefaz() {
        frmMenu.txtIdTrabajadorPerfil.setBackground(Color.white);
    }

    //  Metodo para importar las interfaces utilizadas
    private void interfaces() {
        //  Eventos Action listener
        frmMenu.cboTrabajadorPerfil.addActionListener(this);
        frmMenu.ckbCesarmientoTrabajador.addActionListener(this);
    }

    //  Metodo para habilitar panel de cese
    private void habilitarPanelCese() {
        frmMenu.txtFechaCese.setEnabled(true);
        frmMenu.txtMotivo.setEnabled(true);
    }

    //  Metodo para desahibilitar panel de cese
    private void deshabilitarPanelCese() {
        frmMenu.txtFechaCese.setEnabled(false);
        frmMenu.txtMotivo.setEnabled(false);
    }

    //  Metodo para llenar combo
    private void llenarCombo() {
        try {
            traDAO.llenarComboTrabajador(frmMenu.cboTrabajadorPerfil);
        } catch (Exception ex) {
            System.out.println("Error llenarCombo");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(frmMenu.cboTrabajadorPerfil)) {
            int id = frmMenu.cboTrabajadorPerfil.getSelectedIndex();
            frmMenu.txtIdTrabajadorPerfil.setText(String.valueOf(id + 1));
        }
        if (e.getSource().equals(frmMenu.ckbCesarmientoTrabajador)) {
            if (frmMenu.ckbCesarmientoTrabajador.isSelected()) {
                habilitarPanelCese();
            }else{
                deshabilitarPanelCese();
            }
        }
    }
}
