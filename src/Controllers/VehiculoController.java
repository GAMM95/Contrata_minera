package Controllers;

import Models.CentrarColumnas;
import Models.Validaciones;
import Models.Vehiculo;
import Models.VehiculoDAO;
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

public class VehiculoController implements ActionListener, KeyListener, MouseListener {

    // Array de marcas de vehiculo
    private String[] marcasVehiculos = {"seleccionar", "Caterpillar", "Dongfeng", "Dongfeng", "Doosan", "Forland", "Foton", "Freighliner", "Hino", "Hyundai", "Isuzu", "JAC", "Mack", "Mercedes-Benz", "Mitsubishi", "Nissan", "Scania", "Toyota", "Volskwagen", "Volvo"};

    //  Instancias de clases
    private Vehiculo ve;
    private VehiculoDAO veDAO;
    private FrmMenu frmMenu;

    //  Constructor
    public VehiculoController(Vehiculo ve, VehiculoDAO veDAO, FrmMenu frmMenu) {
        this.ve = ve;
        this.veDAO = veDAO;
        this.frmMenu = frmMenu;
        cargarMarcas(); // Llenado de marcas en combo
        cargarTabla();  //  Cargar tabla al iniciar
        interfaces();
        limpiarInputs();    // Limpiar entradas
        limpiarMensajesError(); // Limpiar mensajes de error
    }

    //  Metodo para llenar combo de marcas
    private void cargarMarcas() {
        for (String marcas : marcasVehiculos) {
            frmMenu.cboMarcaVehiculo.addItem(marcas);
        }
    }

    //  Metodo para implementar eventos 
    private void interfaces() {
        //  Eventos ActionListener
        frmMenu.btnSeleccionarTipoVehiculo.addActionListener(this);
        frmMenu.btnRegistrarVehiculo.addActionListener(this);

        //  Eventos KeyListener
        frmMenu.txtIdVehiculo.addKeyListener(this);
        frmMenu.txtPlaca.addKeyListener(this);
        frmMenu.txtModelo.addKeyListener(this);
        frmMenu.txtAño.addKeyListener(this);

        //  Eventos MouseListener
        frmMenu.txtFechaCompra.addMouseListener(this);
        frmMenu.cboMarcaVehiculo.addMouseListener(this);
        frmMenu.btnSeleccionarTipoVehiculo.addMouseListener(this);
    }

    //  Metodo para listar vehiculos
    private void cargarTabla() {
        int[] anchos = {8, 20, 100, 50, 100, 50, 30};
        DefaultTableModel model = (DefaultTableModel) frmMenu.tblVehiculos.getModel();
        model.setRowCount(0);
        for (int i = 0; i < frmMenu.tblVehiculos.getColumnCount(); i++) {
            frmMenu.tblVehiculos.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
            frmMenu.tblVehiculos.setDefaultRenderer(Object.class, new CentrarColumnas());  //  Centrado de valores de las columnas
        }
        veDAO.listarVehiculos(model);
    }

    //  Metodo para impiar cajas de texto
    private void limpiarInputs() {
        frmMenu.txtIdVehiculo.setText("");
        frmMenu.txtPlaca.setText("");
        frmMenu.cboMarcaVehiculo.setSelectedItem(0);
        frmMenu.txtModelo.setText("");
        frmMenu.txtFechaCompra.setText("");
        frmMenu.txtTipoVehiculoAsignado.setText("");
        frmMenu.txtCodTipoVehiculoAsignado.setText("");
        frmMenu.tblVehiculos.clearSelection();
        frmMenu.txtIdVehiculo.requestFocus();
    }

    //  Metodo para limpiar mensajes de error
    private void limpiarMensajesError() {
        frmMenu.mIdVehiculo.setText("");
        frmMenu.mPlaca.setText("");
        frmMenu.mMarca.setText("");
        frmMenu.mModelo.setText("");
        frmMenu.mFechaCompra.setText("");
        frmMenu.mAño.setText("Opcional");
        frmMenu.mAño.setForeground(new Color(3, 155, 216));
        frmMenu.mTipoVehiculoAsignado.setText("");
    }

    //  Metodo para validar campos vacios
    private boolean validarCamposVacios() {
        boolean valor = true;
        if (frmMenu.txtIdVehiculo.getText().trim().equals("")) {
            frmMenu.mIdVehiculo.setText("Ingrese ID del vehículo");
            frmMenu.mIdVehiculo.setForeground(Color.red);
            frmMenu.txtIdVehiculo.requestFocus();
            valor = false;
        } else if (frmMenu.txtPlaca.getText().trim().equals("")) {
            frmMenu.mPlaca.setText("Ingrese placa");
            frmMenu.mPlaca.setForeground(Color.red);
            frmMenu.txtPlaca.requestFocus();
            valor = false;
        } else if (frmMenu.txtFechaCompra.getText().equals("")) {
            frmMenu.mFechaCompra.setText("Seleccione una fecha");
            frmMenu.mFechaCompra.setForeground(Color.red);
            valor = false;
        } else if (frmMenu.cboMarcaVehiculo.getSelectedItem().equals("seleccionar")) {
            frmMenu.mMarca.setText("Seleccione una marca");
            frmMenu.mMarca.setForeground(Color.red);
            valor = false;
        } else if (frmMenu.txtModelo.getText().trim().equals("")) {
            frmMenu.mModelo.setText("Ingrese modelo");
            frmMenu.mModelo.setForeground(Color.red);
            frmMenu.txtModelo.requestFocus();
            valor = false;
        } else if (frmMenu.txtTipoVehiculoAsignado.getText().equals("")) {
            frmMenu.mTipoVehiculoAsignado.setText("Seleccione un tipo de vehículo");
            frmMenu.mTipoVehiculoAsignado.setForeground(Color.red);
            valor = false;
        }
        return valor;
    }

    //Metodo para validar existencia de ID del vehiculo
    private boolean validarExistenciaID() {
        boolean valor = true; //    valor verdadero
        if (veDAO.existeId(frmMenu.txtIdVehiculo.getText()) != 0) {
            frmMenu.mIdVehiculo.setText("ID ya existe");
            frmMenu.mIdVehiculo.setForeground(Color.red);
            frmMenu.txtIdVehiculo.requestFocus();
            valor = false;
        }
        return valor;
    }

    //  Metodo para validar existencia de placa del vehiculo
    private boolean validarExistenciaPlaca() {
        boolean valor = true;   // Valor inicial verdadero
        if (veDAO.existePlaca(frmMenu.txtPlaca.getText()) != 0) {
            frmMenu.mPlaca.setText("Placa de vehículo ya existe");
            frmMenu.mPlaca.setForeground(Color.red);
            frmMenu.txtPlaca.requestFocus();
            valor = false;
        }
        return valor;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //  Evento para el boton de seleccion de tipo de vehiculo
        if (e.getSource().equals(frmMenu.btnSeleccionarTipoVehiculo)) {
            int fila = frmMenu.tblTipoVehiculo.getSelectedRow(); // Seleccion de fila de tabla
            if (!frmMenu.txtCodTipoVehiculo.getText().isEmpty()) {
                //  limpiar cajas de texto del tipo de vehiculo
                frmMenu.txtTipoVehiculo.setText("");
                int codTipo = Integer.parseInt(frmMenu.tblTipoVehiculo.getValueAt(fila, 0).toString());
                String nombreTipo = frmMenu.tblTipoVehiculo.getValueAt(fila, 1).toString();

                // Seteo de datos en cajas de texto para asignar
                frmMenu.txtCodTipoVehiculoAsignado.setText(String.valueOf(codTipo));
                frmMenu.txtTipoVehiculoAsignado.setText(nombreTipo);
            } else {
                JOptionPane.showMessageDialog(frmMenu.tblTipoVehiculo, "Seleccione una fila");
            }

        }
        //  Evento para el boton registrar vehiculo
        if (e.getSource().equals(frmMenu.btnRegistrarVehiculo)) {
            //  Validaciones de existencia
            boolean validarVacios = validarCamposVacios();
            boolean validarID = validarExistenciaID();
            boolean validarPlaca = validarExistenciaPlaca();

            if (validarVacios == false) { // Si los campos estan vacios
                validarCamposVacios();
            } else {
                if (validarID == false) { // Si ya existe el id del vehiculo
                    validarExistenciaID();
                } else {
                    if (validarPlaca == false) { // Si ya existe placa
                        validarExistenciaPlaca();
                    } else {
//                        DateFormat format = new SimpleDateFormat("yyyy-MM-dd"); // formato de fecha
                        String idVehiculo = frmMenu.txtIdVehiculo.getText();
                        String placa = frmMenu.txtPlaca.getText();
                        String marca = frmMenu.cboMarcaVehiculo.getSelectedItem().toString();
                        String modelo = frmMenu.txtModelo.getText();
                        Date fechaCompra = Date.valueOf(frmMenu.txtFechaCompra.getText());
                        String año = frmMenu.txtAño.getText();
                        int codTipo = Integer.parseInt(frmMenu.txtCodTipoVehiculoAsignado.getText());
                        ve = new Vehiculo(idVehiculo, placa, modelo, marca, fechaCompra, año, codTipo);
                        if (veDAO.registrarVehiculo(ve) == true) {
                            cargarTabla();
                            JOptionPane.showMessageDialog(frmMenu.tblVehiculos, "Vehículo registrado");
                            limpiarInputs();
                        } else {
                            JOptionPane.showMessageDialog(frmMenu.tblVehiculos, "No se registró vehículo");
                            limpiarInputs();
                        }
                    }
                }
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //  validar tipo de texto
        if (e.getSource().equals(frmMenu.txtAño)) {
            Validaciones.soloDigitos(e);
            int limite = 4; // limite de digitos
            if (frmMenu.txtAño.getText().length() == limite) { // si es igual al limite
                e.consume(); // limitar
            }
        }
        if (e.getSource().equals(frmMenu.txtIdVehiculo)) {
            int limite = 6; // limite de digitos
            if (frmMenu.txtIdVehiculo.getText().length() == limite) { // si es igual al limite
                e.consume(); // limitar
            }
        }
        if (e.getSource().equals(frmMenu.txtPlaca)) {
            int limite = 7; // limite de digitos
            if (frmMenu.txtPlaca.getText().length() == limite) { // si es igual al limite
                e.consume(); // limitar
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent ke) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        //  Eventos que al escribir contenido en cajas de texto, los mensajes de error se ocultan
        if (e.getSource().equals(frmMenu.txtIdVehiculo)) {
            frmMenu.mIdVehiculo.setText("");
        } else if (e.getSource().equals(frmMenu.txtPlaca)) {
            frmMenu.mPlaca.setText("");
        } else if (e.getSource().equals(frmMenu.txtModelo)) {
            frmMenu.mModelo.setText("");
        } else if (e.getSource().equals(frmMenu.txtAño)) {
            frmMenu.mAño.setText("Opcional");
            frmMenu.mAño.setForeground(new Color(3, 155, 216));
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // Evento d clickeo
        if (e.getSource().equals(frmMenu.txtFechaCompra)) {
            frmMenu.mFechaCompra.setText("");
        } else if (e.getSource().equals(frmMenu.cboMarcaVehiculo)) {
            frmMenu.mMarca.setText("");
        } else if (e.getSource().equals(frmMenu.btnSeleccionarTipoVehiculo)) {
            frmMenu.mTipoVehiculoAsignado.setText("");
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

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
