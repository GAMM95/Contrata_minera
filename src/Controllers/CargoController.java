package Controllers;

import Models.Cargo;
import Models.CargoDAO;
import Models.CentrarColumnas;
import Models.Validaciones;
import Views.FrmMenu;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class CargoController implements ActionListener, KeyListener, MouseListener {

    // Instancias de las clases
    private final Cargo ca;
    private final CargoDAO caDAO;
    private FrmMenu frmMenu;

//    private String[] categoriaCargos = {"Empleado", "Obrero"};  //  Array de categorias de cargos
    public CargoController(Cargo ca, CargoDAO caDAO, FrmMenu frmMenu) {
        this.ca = ca;
        this.caDAO = caDAO;
        this.frmMenu = frmMenu;
//        cargarCategorias();
        interfaces();
        limpiarInputs();
        limpiarMensajesError();
        cargarTabla();
        enableButtons();
    }

    //  Metodo para implementar las interfaces
    private void interfaces() {
        //  Eventos ActionListener
        frmMenu.btnRegistrarCargo.addActionListener(this);
        frmMenu.btnActualizarCargo.addActionListener(this);
        frmMenu.btnCancelarCargo.addActionListener(this);
        frmMenu.opEmpleado.addActionListener(this);
        frmMenu.opObrero.addActionListener(this);
        //  Eventos KeyListener
        frmMenu.txtNombreCargo.addKeyListener(this);
        frmMenu.tblCargos.addKeyListener(this);
        //  Eventos MouseListener
        frmMenu.opEmpleado.addMouseListener(this);
        frmMenu.opObrero.addMouseListener(this);
        frmMenu.tblCargos.addMouseListener(this);
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
    //  Diseño tabla cargos
    private void cargarTabla() {
        int[] anchos = {8, 150, 100};   //  anchos de columnas

        //  Diseño tablaCargos
        DefaultTableModel model = (DefaultTableModel) frmMenu.tblCargos.getModel();
        model.setRowCount(0);
        for (int i = 0; i < frmMenu.tblCargos.getColumnCount(); i++) {
            frmMenu.tblCargos.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
        frmMenu.tblCargos.getTableHeader().setFont(new Font("Roboto", Font.BOLD, 14));
        frmMenu.tblCargos.getTableHeader().setOpaque(false);
        frmMenu.tblCargos.getTableHeader().setBackground(Color.decode("#243b55"));
        frmMenu.tblCargos.getTableHeader().setForeground(Color.decode("#FFFFFF"));
        frmMenu.tblCargos.setDefaultRenderer(Object.class, new CentrarColumnas());  //  Centrado de valores de las columnas
        caDAO.listarCargos(model);

        //  Diseño tabla ListaCargos
        DefaultTableModel model1 = (DefaultTableModel) frmMenu.tblListaCargos.getModel();
        model1.setRowCount(0);
        for (int i = 0; i < frmMenu.tblListaCargos.getColumnCount(); i++) {
            frmMenu.tblListaCargos.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
        frmMenu.tblListaCargos.getTableHeader().setFont(new Font("Roboto", Font.BOLD, 14));
        frmMenu.tblListaCargos.getTableHeader().setOpaque(false);
        frmMenu.tblListaCargos.getTableHeader().setBackground(Color.decode("#243b55"));
        frmMenu.tblListaCargos.getTableHeader().setForeground(Color.decode("#FFFFFF"));
        frmMenu.tblListaCargos.setDefaultRenderer(Object.class, new CentrarColumnas()); //  Centrado de valores de las columnas
        caDAO.listarCargos(model1);
    }

    //   Metodo para validar campos vacios
    private boolean validarCamposVacios() {
        boolean action = true;
        if (frmMenu.txtNombreCargo.getText().trim().equals("")) {
            frmMenu.mNombreCargo.setText("Por favor, ingrese el nombre del cargo");
            frmMenu.mNombreCargo.setForeground(Color.decode("#E94560"));
            frmMenu.txtNombreCargo.requestFocus();
            action = false;
        } else if (frmMenu.CategoriaCargo.isSelected(null)) {
            frmMenu.mCategoriaCargo.setText("Por favor, marque una opción");
            frmMenu.mCategoriaCargo.setForeground(Color.decode("#E94560"));
            action = false;
        }
        return action;
    }

    //  Metodo para validar existencia de nombre del cargo
    private boolean validarExistenciaCargo() {
        boolean valor = true;   //  valor unicial verdadero
        if (caDAO.existeCargo(frmMenu.txtNombreCargo.getText()) != 0) {
            frmMenu.mNombreCargo.setText("Cargo ya existe");
            frmMenu.mNombreCargo.setForeground(Color.decode("#E94560"));
            frmMenu.txtNombreCargo.requestFocus();
            valor = false;
        }
        return valor;
    }

    //  Metodo para limpiar cajas de texto
    private void limpiarInputs() {
        frmMenu.txtCodCargo.setText("");
        frmMenu.txtNombreCargo.setText("");
        frmMenu.CategoriaCargo.clearSelection();    // Limpiar los radiobuton
        frmMenu.tblCargos.clearSelection(); //  limpiar seleccion de fila
        frmMenu.txtNombreCargo.requestFocus();
    }

    //  Metodo para limpiar mensajes de error
    private void limpiarMensajesError() {
        frmMenu.mNombreCargo.setText("");
        frmMenu.mCategoriaCargo.setText("");
    }

    //  Metodo para habilitar botones
    private void enableButtons() {
        frmMenu.btnRegistrarCargo.setEnabled(true);
        frmMenu.btnActualizarCargo.setEnabled(false);
        frmMenu.btnCancelarCargo.setEnabled(false);
    }

    private void disableButtons() {
        frmMenu.btnRegistrarCargo.setEnabled(false);
        frmMenu.btnActualizarCargo.setEnabled(true);
        frmMenu.btnCancelarCargo.setEnabled(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //  Evento del boton registrarCargo
        if (e.getSource().equals(frmMenu.btnRegistrarCargo)) {
            boolean validarVacios = validarCamposVacios(); // boolean: TRUE
            boolean validarCargo = validarExistenciaCargo(); // boolean: true

            if (validarVacios == false) {   //  Si validar campos vacios es falso
                validarCamposVacios();  //  mostrar el mensaje del metodo
            } else {
                if (validarCargo == false) {
                    validarExistenciaCargo();
                } else {
                    ca.setNombreCargo(frmMenu.txtNombreCargo.getText());
                    String categoria;
                    if (frmMenu.opEmpleado.isSelected()) {
                        categoria = "Empleado";
                    } else {
                        categoria = "Obrero";
                    }
                    ca.setCategoria(categoria);

                    caDAO.registrarCargo(ca);
                    cargarTabla();
                    JOptionPane.showMessageDialog(null, "Cargo registrado");
                    limpiarInputs();
                }
            }
        }
        //  Evento del boton ActualizarCargo
        if (e.getSource().equals(frmMenu.btnActualizarCargo)) {
            ca.setCodigo(Integer.parseInt(frmMenu.txtCodCargo.getText()));
            ca.setNombreCargo(frmMenu.txtNombreCargo.getText());
            String categoria;
            if (frmMenu.opEmpleado.isSelected()) {
                categoria = "Empleado";
            } else {
                categoria = "Obrero";
            }
            ca.setCategoria(categoria);

            if (caDAO.modificarCargos(ca) == true) {
                limpiarInputs();
                cargarTabla();
                JOptionPane.showMessageDialog(null, "Cargo actualizado");
                enableButtons();
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo actualizar cargo");
            }
        }
        //  Evento del boton CancelarCargo
        if (e.getSource().equals(frmMenu.btnCancelarCargo)) {
            limpiarInputs();
            enableButtons();
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

        if (e.getSource().equals(frmMenu.tblCargos)) {
            //  seteo de datos con las flechas arriba y abajo sobre la tabla
            if ((e.getKeyCode() == KeyEvent.VK_DOWN) || (e.getKeyCode() == KeyEvent.VK_UP)) {
                limpiarMensajesError();
                disableButtons();  // set enabled false to btnRegistrarCargo
                DefaultTableModel modelo = (DefaultTableModel) frmMenu.tblCargos.getModel();

                String codigo = modelo.getValueAt(frmMenu.tblCargos.getSelectedRow(), 0).toString();
                String nombreCargo = modelo.getValueAt(frmMenu.tblCargos.getSelectedRow(), 1).toString();
                String categoria = modelo.getValueAt(frmMenu.tblCargos.getSelectedRow(), 2).toString();

                //  Set to inputs
                frmMenu.txtCodCargo.setText(codigo);
                frmMenu.txtNombreCargo.setText(nombreCargo);
                if (categoria.equals("Empleado")) {
                    frmMenu.opEmpleado.setSelected(true);
                } else {
                    frmMenu.opObrero.setSelected(true);
                }

                //  Limpiar textos con Escape despues de clickear tabla
            } else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                limpiarInputs();
                limpiarMensajesError();
                enableButtons();
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // Set data to textfield whe raw is selected

        if (e.getSource().equals(frmMenu.tblCargos)) {
            limpiarMensajesError();
            disableButtons();  // set enabled false to btnRegistrarCargo
            DefaultTableModel modelo = (DefaultTableModel) frmMenu.tblCargos.getModel();

            String codigo = modelo.getValueAt(frmMenu.tblCargos.getSelectedRow(), 0).toString();
            String nombreCargo = modelo.getValueAt(frmMenu.tblCargos.getSelectedRow(), 1).toString();
            String categoria = modelo.getValueAt(frmMenu.tblCargos.getSelectedRow(), 2).toString();

            //  Set to inputs
            frmMenu.txtCodCargo.setText(codigo);
            frmMenu.txtNombreCargo.setText(nombreCargo);
            if (categoria.equals("Empleado")) {
                frmMenu.opEmpleado.setSelected(true);
            } else {
                frmMenu.opObrero.setSelected(true);
            }
        }
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
