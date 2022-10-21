package Controllers;

import Models.Empresa;
import Models.EmpresaDAO;
import Views.FrmMenu;

import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;

public class DatosEmpresaController {

    private EmpresaDAO emDAO;
    private FrmMenu frmMenu;

    public DatosEmpresaController(EmpresaDAO emDAO, FrmMenu frmMenu) {
        this.emDAO = emDAO;
        this.frmMenu = frmMenu;
        diseñoInterfaz();
        mostrarDatos();
    }

    //  Metodo para tunnear el panel nosotros
    private void diseñoInterfaz() {
//        frmMenu.txtIdEmpresaUpdate1.setBackground(Color.white);
//        frmMenu.txtIdEmpresaUpdate1.setForeground(Color.white);
//        frmMenu.txtRutaUpdate1.setBackground(Color.white);
//        frmMenu.txtRutaUpdate1.setForeground(Color.white);
//        frmMenu.txtIdEmpresaUpdate1.setBorder(null);
    }

    //  Mostrar datos seteados de la empresa
    private void mostrarDatos() {
//        int id = Integer.parseInt(frmMenu.txtIdEmpresaUpdate1.getText());   //  Id seteado 
//
//        Empresa x = emDAO.mostrarDatos(id);
//        if (x != null) {
//            frmMenu.txtRucUpdate1.setText(x.getRuc());
//            frmMenu.txtRazonSocialUpdate1.setText(x.getRazonSocial());
//            frmMenu.txtCiiuUpdate1.setText(x.getCiiu());
//            frmMenu.txtTelefono.setText(x.getTelefono());
//            frmMenu.txtCelularUpdate1.setText(x.getCelular());
//            frmMenu.txtDireccionUpdate1.setText(x.getDireccionLegal());
//            frmMenu.txtEmailUpdate1.setText(x.getEmail());
//            frmMenu.txtPagWebUpdate1.setText(x.getPaginaWeb());
//            frmMenu.txtRutaUpdate1.setText(x.getPath());
//            //  Seteado del logo de la empresa
//            ImageIcon icon = new ImageIcon(x.getLogo());
//            Image im = icon.getImage();
//            Image miImage = im.getScaledInstance(frmMenu.lblLogoUpdate1.getWidth(), frmMenu.lblLogoUpdate1.getHeight(), Image.SCALE_SMOOTH);
//            ImageIcon newImage = new ImageIcon(miImage);
//            frmMenu.lblLogoUpdate1.setIcon(newImage);
//            frmMenu.lblLogoUpdate1.setText("");
//        }

    }
}
