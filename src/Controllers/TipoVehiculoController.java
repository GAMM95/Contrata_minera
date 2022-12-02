package Controllers;

import Models.CentrarColumnas;
import Models.TipoVehiculo;
import Models.TipoVehiculoDAO;
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

public class TipoVehiculoController implements ActionListener, MouseListener, KeyListener {

    //  Instancias de clases
    private TipoVehiculo tv;
    private TipoVehiculoDAO tvDAO;
    private FrmMenu frmMenu;

    //  Constructor
    public TipoVehiculoController(TipoVehiculo tv, TipoVehiculoDAO tvDAO, FrmMenu frmMenu) {
        this.tv = tv;
        this.tvDAO = tvDAO;
        this.frmMenu = frmMenu;
        interfaces();
        cargarTabla();
        limpiarInputs();
        limpiarMensajesError();
        enableButtons();
    }

    //  Interfaces de la clase controller
    private void interfaces() {
        //  Eventos ActionListener
        frmMenu.btnRegistrarTipoVehiculo.addActionListener(this);

        //  Eventos KeyListener
        frmMenu.txtTipoVehiculo.addKeyListener(this);
        frmMenu.tblTipoVehiculo.addKeyListener(this);

        //  Eventos MouseListener
        frmMenu.tblTipoVehiculo.addMouseListener(this);
    }

    //  Diseño de tabla tipo de vehiculos
    private void cargarTabla() {
        int[] anchos = {8, 250};
        DefaultTableModel model = (DefaultTableModel) frmMenu.tblTipoVehiculo.getModel();
        model.setRowCount(0);
        for (int i = 0; i < frmMenu.tblTipoVehiculo.getColumnCount(); i++) {
            frmMenu.tblTipoVehiculo.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
        frmMenu.tblTipoVehiculo.getTableHeader().setFont(new Font("Roboto", Font.BOLD, 14));
        frmMenu.tblTipoVehiculo.getTableHeader().setOpaque(false);
        frmMenu.tblTipoVehiculo.getTableHeader().setBackground(Color.decode("#243b55"));
        frmMenu.tblTipoVehiculo.getTableHeader().setForeground(Color.decode("#FFFFFF"));
        frmMenu.tblTipoVehiculo.setDefaultRenderer(Object.class, new CentrarColumnas());  //  Centrado de valores de las columnas
        tvDAO.listarTipoVehiculo(model);
    }

    //  Metodo para limpiar cajas de texto
    private void limpiarInputs() {
        frmMenu.txtTipoVehiculo.setText("");
        frmMenu.txtCodTipoVehiculo.setText("");
        frmMenu.tblTipoVehiculo.clearSelection();   // limpiar seleccion de fila en la tabla
        frmMenu.txtTipoVehiculo.requestFocus();
    }

    //  Metodo para limpiar mensajes de error
    private void limpiarMensajesError() {
        frmMenu.mTipoVehiculo.setText("");
    }

    //  Metodo para habilitar botones
    private void enableButtons() {
        frmMenu.btnRegistrarTipoVehiculo.setEnabled(true);
    }

    //  Metodo para deshabilitar botones
    private void disableButtons() {
        frmMenu.btnRegistrarTipoVehiculo.setEnabled(false);
    }

    //  Metodo para validar campos vacios
    private boolean validarCamposVacios() {
        boolean valor = true;
        if (frmMenu.txtTipoVehiculo.getText().trim().equals("")) {
            frmMenu.mTipoVehiculo.setText("Ingrese tipo de vehículo");
            frmMenu.mTipoVehiculo.setForeground(Color.red);
            frmMenu.txtTipoVehiculo.requestFocus();
            valor = false;
        }
        return valor;
    }

    //  Metodo para validar existencia del tipo de vehiculo
    private boolean validarExistenciaTipo() {
        boolean valor = true; // valor inicial verdadero
        if (tvDAO.existeNombre(frmMenu.txtTipoVehiculo.getText()) != 0) {
            frmMenu.mTipoVehiculo.setText("Tipo de vehículo ya existe");
            frmMenu.mTipoVehiculo.setForeground(Color.red);
            frmMenu.txtTipoVehiculo.requestFocus();
            valor = false;
        }
        return valor;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(frmMenu.btnRegistrarTipoVehiculo)) {
            boolean validarVacios = validarCamposVacios();
            boolean validarTipo = validarExistenciaTipo();

            if (validarVacios == false) { // si los campos estan vacios
                validarCamposVacios();
            } else {
                if (validarTipo == false) { // si existe el tipo
                    validarExistenciaTipo();
                } else {
                    tv.setNombreTipo(frmMenu.txtTipoVehiculo.getText());
                    tvDAO.registrarTipoVehiculo(tv);
                    cargarTabla();
                    JOptionPane.showMessageDialog(null, "Tipo de vehículo registrado");
                    limpiarInputs();
                }
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource().equals(frmMenu.tblTipoVehiculo)) {
            disableButtons();//deshabilitar botones
            //  obtener el modelo de la tabla
            DefaultTableModel model = (DefaultTableModel) frmMenu.tblTipoVehiculo.getModel();
            // clickeo de tabla y obtencion de datos
            String codigo = model.getValueAt(frmMenu.tblTipoVehiculo.getSelectedRow(), 0).toString();
            String nombreTipo = model.getValueAt(frmMenu.tblTipoVehiculo.getSelectedRow(), 1).toString();
            // Seteo de datos
            frmMenu.txtCodTipoVehiculo.setText(codigo);
            frmMenu.txtTipoVehiculo.setText(nombreTipo);
        }
    }

    @Override
    public void mousePressed(MouseEvent me) {

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

    @Override
    public void keyTyped(KeyEvent e) {
        //  Validar ingreso de solo letras
        if (e.getSource().equals(frmMenu.txtTipoVehiculo)) {
            Validaciones.soloLetras(e);
        }
    }

    @Override
    public void keyPressed(KeyEvent ke) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        //  Limpiar mensaje de error al ingresar nuevamente tipo de vehiculo
        if (e.getSource().equals(frmMenu.txtTipoVehiculo)) {
            frmMenu.mTipoVehiculo.setText("");
        }

        //  Eventos con teclas
        if (e.getSource().equals(frmMenu.tblTipoVehiculo)) {
            //  seteo de datos con las flechas arriba y abajo sobre la tabla
            if ((e.getKeyCode() == KeyEvent.VK_DOWN) || (e.getKeyCode() == KeyEvent.VK_UP)) {
                //  obtener el modelo de la tabla
                DefaultTableModel model = (DefaultTableModel) frmMenu.tblTipoVehiculo.getModel();
                // clickeo de tabla y obtencion de datos
                String codigo = model.getValueAt(frmMenu.tblTipoVehiculo.getSelectedRow(), 0).toString();
                String nombreTipo = model.getValueAt(frmMenu.tblTipoVehiculo.getSelectedRow(), 1).toString();
                // Seteo de datos
                frmMenu.txtCodTipoVehiculo.setText(codigo); // Seteo de codigo de tipo
                frmMenu.txtTipoVehiculo.setText(nombreTipo);    // Seteo de nombre de tipo de vehiculo

                //  Limpiar textos con Escape despues de clickear tabla
            } else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                limpiarInputs(); // limpiar entradas en cajas de texto
                limpiarMensajesError(); // limpiar mensajes de error
                enableButtons(); // activar botones registrar
            }
        }

    }
}
