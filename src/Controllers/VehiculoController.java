package Controllers;

import Models.Vehiculo;
import Models.VehiculoDAO;
import Views.FrmMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;

public class VehiculoController implements ActionListener {

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
        interfaces();;
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

    @Override
    public void actionPerformed(ActionEvent e) {

    }

}
