package Controllers;

import Models.Cargo;
import Models.CargoDAO;
import Models.Validaciones;
import Views.FrmMenu;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class CargoController implements ActionListener, KeyListener, MouseListener {

    // Instancias de las clases
    private final Cargo ca;
    private final CargoDAO caDAO;
    private FrmMenu frmMenu;
    
    

    private String[] categoriaCargos = {"Empleado", "Obrero"};  //  Array de categorias de cargos

    public CargoController(Cargo ca, CargoDAO caDAO, FrmMenu frmMenu) {
        this.ca = ca;
        this.caDAO = caDAO;
        this.frmMenu = frmMenu;
//        cargarCategorias();
        interfaces();
        limpiarInputs();
        limpiarMensajesError();
//        try {
//            llenarCargos();
//        } catch (SQLException ex) {
//            Logger.getLogger(CargoController.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

    //  Metodo para implementar las interfaces
    private void interfaces() {
        //  Eventos ActionListener
        frmMenu.btnRegistrarCargo.addActionListener(this);
        frmMenu.opEmpleado.addActionListener(this);
        frmMenu.opObrero.addActionListener(this);
        //  Eventos KeyListener
        frmMenu.txtNombreCargo.addKeyListener(this);
        //  Eventos MouseListener
        frmMenu.opEmpleado.addMouseListener(this);
        frmMenu.opObrero.addMouseListener(this);

    }

//    //  Metodo para llenar comboBox de categorias
//    private void cargarCategorias() {
//        for (int i = 0; i < categoriaCargos.length; i++) {
//            frmMenu.cboCategoria.addItem(categoriaCargos[i]);
//        }
////        frmMenu.cboCategoria.setModel(new DefaultComboBoxModel(categoriaCargos));
//    }
//
//        //  Metodo para llenar cargos en el comboBox 
//    public void llenarCargos() throws SQLException {
//        HashMap<String, Integer> map = caDAO.populateCombo();
//        for (String s : map.keySet()) {
//            frmMenu.cboCargo.addItem(s);
//        }
//    }
    //   Metodo para validar campos vacios
    private boolean validarCamposVacios() {
        boolean action = true;
        if (frmMenu.txtNombreCargo.getText().trim().equals("")) {
            frmMenu.mNombreCargo.setText("Por favor, ingrese el nombre del cargo");
            frmMenu.mNombreCargo.setForeground(Color.red);
            frmMenu.txtNombreCargo.requestFocus();
            action = false;
        } else if (frmMenu.CategoriaCargo.isSelected(null)) {
            frmMenu.mCategoriaCargo.setText("Por favor, marque una opción");
            frmMenu.mCategoriaCargo.setForeground(Color.red);
            action = false;
        }
        return action;
    }

    //  Metodo para limpiar cajas de texto
    private void limpiarInputs() {
        frmMenu.txtNombreCargo.setText("");
//        frmMenu.txtCodCargo.setText("");
//        frmMenu.cboCategoria.setSelectedIndex(0);
        frmMenu.CategoriaCargo.clearSelection();    // Limpiar los radiobuton
        frmMenu.txtNombreCargo.requestFocus();
    }

    //  Metodo para limpiar mensajes de error
    private void limpiarMensajesError() {
        frmMenu.mNombreCargo.setText("");
        frmMenu.mCategoriaCargo.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(frmMenu.btnRegistrarCargo)) {  //  Evento del boton registrarCargo
            boolean validarVacios = validarCamposVacios(); // boolean: TRUE

            if (validarVacios == false) {   //  Si validar campos vacios es falso
                validarCamposVacios();  //  mostrar el mensaje del metodo
            } else {
                ca.setNombreCargo(frmMenu.txtNombreCargo.getText());
                String categoria;
                if (frmMenu.opEmpleado.isSelected()) {
                    categoria = "Empleado";
                } else {
                    categoria = "Obrero";
                }
                ca.setCategoria(categoria);
                try {
                    caDAO.registrarCargo(ca);
                    JOptionPane.showMessageDialog(null, "Cargo registrado");
//                    caDAO.listarCargos(modelo);
                    limpiarInputs();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.toString());
                }
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getSource().equals(frmMenu.txtNombreCargo)) {
            Validaciones.soloLetras(e);
        }
    }

    @Override
    public void keyPressed(KeyEvent ke) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getSource().equals(frmMenu.txtNombreCargo)) {
            frmMenu.mNombreCargo.setText("");
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource().equals(frmMenu.opEmpleado) || e.getSource().equals(frmMenu.opObrero)) {
            frmMenu.mCategoriaCargo.setText("");
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

}
