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
        deshabilitar();
    }

    //  Metodo para tunnear el panel nosotros
    private void diseñoInterfaz() {
        frmMenu.txtRucDatos.setBackground(Color.white);
        frmMenu.txtRucDatos.setForeground(Color.white);
        frmMenu.txtRutaEmpresaDatos.setBackground(Color.white);
        frmMenu.txtRutaEmpresaDatos.setForeground(Color.white);
        frmMenu.txtRucDatos.setBorder(null);
        frmMenu.txtRucDatos.setForeground(Color.white);
    }
    
    //  Metodo para deshabilitar edicion de entradas
    private void deshabilitar(){
        frmMenu.txtRucDatos.setEditable(false);
        frmMenu.txtRucDatos.setEditable(false);
        frmMenu.txtRazonSocialDatos.setEditable(false);
        frmMenu.txtCiiuDatos.setEditable(false);
        frmMenu.txtTelefonoEmpresaDatos.setEditable(false);
        frmMenu.txtCelularEmpresaDatos.setEditable(false);
        frmMenu.txtEmailEmpresaDatos.setEditable(false);
    }

    //  Mostrar datos seteados de la empresa
    private void mostrarDatos() {
        int id = Integer.parseInt(frmMenu.txtRucDatos.getText());   //  Id seteado 

        Empresa x = emDAO.mostrarDatos(id);
        if (x != null) {
            frmMenu.txtRucDatos.setText(x.getRuc());
            frmMenu.txtRazonSocialDatos.setText(x.getRazonSocial());
            frmMenu.txtCiiuDatos.setText(x.getCiiu());
            frmMenu.txtTelefonoEmpresaDatos.setText(x.getTelefono());
            frmMenu.txtCelularEmpresaDatos.setText(x.getCelular());
            frmMenu.txtDireccionUpdate.setText(x.getDireccionLegal());
            frmMenu.txtEmailEmpresaDatos.setText(x.getEmail());
            frmMenu.txtPaginaWebEmpresaDatos.setText(x.getPaginaWeb());
            frmMenu.txtRutaEmpresaDatos.setText(x.getPath());
            //  Seteado del logo de la empresa
            ImageIcon icon = new ImageIcon(x.getLogo());
            Image im = icon.getImage();
            Image miImage = im.getScaledInstance(frmMenu.lblLogoEmpresaDatos.getWidth(), frmMenu.lblLogoEmpresaDatos.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon newImage = new ImageIcon(miImage);
            frmMenu.lblLogoEmpresaDatos.setIcon(newImage);
            frmMenu.lblLogoEmpresaDatos.setText("");
        }

    }
}