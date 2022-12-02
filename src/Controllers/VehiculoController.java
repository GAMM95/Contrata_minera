package Controllers;

import Models.TipoVehiculo;
import Models.Vehiculo;
import Models.VehiculoDAO;
import Views.FrmMenu;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class VehiculoController implements ActionListener {

    // Array de marcas de vehiculo
    private String[] marcasVehiculos = {"seleccionar", "Caterpillar", "Dongfeng", "Dongfeng", "Doosan", "Forland", "Foton", "Freighliner", "Hino", "Hyundai", "Isuzu", "JAC", "Mack", "Mercedes-Benz", "Mitsubishi", "Nissan", "Scania", "Toyota", "Volskwagen", "Volvo"};

    //  Instancias de clases
    private Vehiculo ve;
    private VehiculoDAO veDAO;
    private FrmMenu frmMenu;

    TipoVehiculo tipoVehiculo = null;

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
    }

    //  Metodo para listar vehiculos
    private void cargarTabla() {
        int[] anchos = {8, 20, 100, 50, 100, 50, 30};
        DefaultTableModel model = (DefaultTableModel) frmMenu.tblVehiculos.getModel();
        model.setRowCount(0);
        for (int i = 0; i < frmMenu.tblVehiculos.getColumnCount(); i++) {
            frmMenu.tblVehiculos.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
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
            frmMenu.mFechaCompra.setText("Seleecione una fecha");
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
            //  limpiar cajas de texto del tipo de vehiculo
            frmMenu.txtTipoVehiculo.setText("");
            int codTipo = Integer.parseInt(frmMenu.tblTipoVehiculo.getValueAt(fila, 0).toString());
            String nombreTipo = frmMenu.tblTipoVehiculo.getValueAt(fila, 1).toString();

            // Seteo de datos en cajas de texto para asignar
            frmMenu.txtCodTipoVehiculoAsignado.setText(String.valueOf(codTipo));
            frmMenu.txtTipoVehiculoAsignado.setText(nombreTipo);

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
                        if (tipoVehiculo != null) {
                            ve = new Vehiculo(idVehiculo, placa, modelo, marca, fechaCompra, año, tipoVehiculo);
                            if (veDAO.registrarVehiculo(ve)) {
                                cargarTabla();
                                JOptionPane.showMessageDialog(null, "Vehículo registrado");
                                limpiarInputs();
                            } else {
                                JOptionPane.showMessageDialog(null, "No se registró vehículo");
                                limpiarInputs();
                            }
                        }
                    }
                }
            }
        }
    }

}
