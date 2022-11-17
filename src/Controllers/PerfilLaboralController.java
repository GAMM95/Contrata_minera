package Controllers;

import Models.CentrarColumnas;
import Models.PerfilLaboral;
import Models.PerfilLaboralDAO;
import Models.TrabajadorDAO;
import Views.FrmMenu;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.table.DefaultTableModel;

public class PerfilLaboralController implements ActionListener, KeyListener, MouseListener {

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
        cargarTabla();
        deshabilitarPanelCese();
        enableButtons();
    }

    //  Metodo para diseñar el panel de perfil laboral de trabajadores
    private void diseñarIntefaz() {
        frmMenu.txtIdTrabajadorPerfil.setBackground(Color.white);
    }

    //  Metodo para importar las interfaces utilizadas
    private void interfaces() {
        //  Eventos Action listener
//        frmMenu.cboTrabajadorPerfil.addActionListener(this);
        frmMenu.ckbCesarmientoTrabajador.addActionListener(this);
    }

    //  Metodo para activar botones
    private void enableButtons() {

    }

    //  Metodo para desactivar botones
    private void disableButtons() {

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
//        try {
//            traDAO.llenarComboTrabajador(frmMenu.cboTrabajadorPerfil);
//        } catch (Exception ex) {
//            System.out.println("Error llenarCombo");
//        }
    }

    //  Metodo para listar perfiles laborales de los trabajadores
    private void cargarTabla() {
        int anchos[] = {10,200,30,80,30,150};  //anchos de las columnas
        //  Diseño de la tabla Perfil Laboral
        DefaultTableModel model = (DefaultTableModel) frmMenu.tblPerfilLaboral.getModel();
        model.setRowCount(0);
        for (int i = 0; i < frmMenu.tblPerfilLaboral.getColumnCount(); i++) {
            frmMenu.tblPerfilLaboral.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
        frmMenu.tblPerfilLaboral.setDefaultRenderer(Object.class, new CentrarColumnas()); //    centrado de datos
//        plabDAO.listarPerfiles(model); // llamada del metodo dao listar
    }

    //  Metodo para validar campos vacios
    private boolean validarCamposVacios() {
        boolean action = true;
        if (frmMenu.txtTrabajadorAsignadoPerfil.getText().equals("")) {
            frmMenu.mTrabajadorAsignadoPerfil.setText("Seleccione trabajador");
            frmMenu.mTrabajadorAsignadoPerfil.setForeground(Color.red);
            frmMenu.txtTrabajadorAsignadoPerfil.requestFocus();
            action = false;
        } else if (frmMenu.txtFechaIngreso.getText().equals("")) {
            frmMenu.mFechaIngreso.setText("Ingrese o seleccione una fecha");
            frmMenu.mFechaIngreso.setForeground(Color.red);
            frmMenu.txtFechaIngreso.requestFocus();
            action = false;
        } else if (frmMenu.AreaPerfil.isSelected(null)) {
            frmMenu.mArea.setText("Marque una opción");
            frmMenu.mArea.setForeground(Color.red);
            action = false;
        } else if (frmMenu.txtSueldo.getText().isEmpty()) {
            frmMenu.mSueldo.setText("Ingrese sueldo");
            frmMenu.mSueldo.setForeground(Color.red);
            frmMenu.txtSueldo.requestFocus();
            action = false;
        }
        return action;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
//        if (e.getSource().equals(frmMenu.cboTrabajadorPerfil)) {
//            int id = frmMenu.cboTrabajadorPerfil.getSelectedIndex();
//            frmMenu.txtIdTrabajadorPerfil.setText(String.valueOf(id + 1));
//        }
        //  Activar panel con check Box 
        if (e.getSource().equals(frmMenu.ckbCesarmientoTrabajador)) {
            if (frmMenu.ckbCesarmientoTrabajador.isSelected()) {
                habilitarPanelCese();
            } else {
                deshabilitarPanelCese();
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
