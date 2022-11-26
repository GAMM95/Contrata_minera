package Controllers;

import Models.CentrarColumnas;
import Models.Licencia;
import Models.LicenciaDAO;
import Models.Trabajador;
import Models.Validaciones;

import Views.FrmMenu;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.sql.Date;
import java.text.SimpleDateFormat;
//import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class LicenciaController implements ActionListener, KeyListener, MouseListener {

    Trabajador trabajador = null;

    //  Instancias de clases
    private Licencia lic;
    private LicenciaDAO licDAO;
    private FrmMenu frmMenu;

    private String[] categoriaLicencias = {"seleccionar", "AI", "AIIB", "AIIIB", "AIIIC"};  //  Array de areas

    public LicenciaController(Licencia lic, LicenciaDAO licDAO, FrmMenu frmMenu) {
        this.lic = lic;
        this.licDAO = licDAO;
        this.frmMenu = frmMenu;
        diseñarIntefaz();
        interfaces();
        cargarTabla();
        limpiarInputs();
        limpiarMensajesError();
        enableButtons();
        cargarAreas();
    }

    //  Metodo para diseñar el panel de perfil laboral de trabajadores
    private void diseñarIntefaz() {
        frmMenu.txtIdTrabajadorLicencia.setBackground(Color.white);
    }

    //  Metodo para importar las interfaces utilizadas
    private void interfaces() {
        //  Eventos Action listener
        frmMenu.btnRegistrarLicencia.addActionListener(this);
        frmMenu.cboCategoriaLicencia.addActionListener(this);

        //  Eventos MouseListener
        frmMenu.txtFechaIngreso.addMouseListener(this);
        frmMenu.txtFechaCese.addMouseListener(this);
        frmMenu.tblPerfilLaboral.addMouseListener(this);
//        frmMenu.btnSeleccionarTrabajadorPerfil.addMouseListener(this);

        //  Eventos KeyListener
        frmMenu.txtSueldo.addKeyListener(this);
        frmMenu.tblPerfilLaboral.addKeyListener(this);
    }

    //  Metodo para llenar comboBox de areas
    private void cargarAreas() {
        for (String categoriaLicencias : categoriaLicencias) {
            frmMenu.cboCategoriaLicencia.addItem(categoriaLicencias);
        }
    }

    //  Metodo para listar perfiles laborales de los trabajadores
    private void cargarTabla() {
        int anchos[] = {10, 200, 30, 10, 80, 80};  //anchos de las columnas
        //  Diseño de la tabla Perfil Laboral
        DefaultTableModel model = (DefaultTableModel) frmMenu.tblLicencias.getModel();
        model.setRowCount(0);
        for (int i = 0; i < frmMenu.tblLicencias.getColumnCount(); i++) {
            frmMenu.tblLicencias.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
        frmMenu.tblPerfilLaboral.setDefaultRenderer(Object.class, new CentrarColumnas()); //    centrado de datos
        licDAO.listarLicencias(model); // llamada del metodo dao listar
    }

    //  Metodo para activar botones
    private void enableButtons() {
        frmMenu.btnRegistrarLicencia.setEnabled(true);
    }

    //  Metodo para desactivar botones
    private void disableButtons() {
        frmMenu.btnRegistrarLicencia.setEnabled(false);
    }

    //  Metodo para limpiar inputs
    private void limpiarInputs() {
        frmMenu.txtIdTrabajadorLicencia.setText("");
        frmMenu.txtTrabajadorAsignadoLicencia.setText("");
        frmMenu.txtNumLicencia.setText("");
        frmMenu.cboCategoriaLicencia.setSelectedItem(0);
        frmMenu.txtFechaEmsion.setText("");
        frmMenu.txtFechaCaducidad.setText("");
    }

    //  Metodo para limpiar mensajes de error
    private void limpiarMensajesError() {
        frmMenu.mTrabajadorAsignadoLicencia.setText("");
        frmMenu.mNumLicencia.setText("");
        frmMenu.mCategoriaLicencia.setText("");
        frmMenu.mFechaEmision.setText("");
        frmMenu.mFechaCaducidad.setText("");
    }

    //  Metodo para validar campos vacios
    private boolean validarCamposVacios() {
        boolean action = true;
        if (frmMenu.txtTrabajadorAsignadoLicencia.getText().equals("")) {
            frmMenu.mTrabajadorAsignadoLicencia.setText("Seleccione un trabajador");
            frmMenu.mTrabajadorAsignadoLicencia.setForeground(Color.red);
            frmMenu.txtTrabajadorAsignadoLicencia.requestFocus();
            action = false;
        } else if (frmMenu.txtNumLicencia.getText().equals("")) {
            frmMenu.mNumLicencia.setText("Ingrese número de licencia");
            frmMenu.mNumLicencia.setForeground(Color.red);
            frmMenu.txtNumLicencia.requestFocus();
            action = false;
        } else if (frmMenu.cboCategoriaLicencia.getSelectedItem().equals("seleccionar")) {
            frmMenu.mCategoriaLicencia.setText("Seleecione una categoría");
            frmMenu.mCategoriaLicencia.setForeground(Color.red);
            action = false;
        } else if (frmMenu.txtFechaEmsion.getText().equals("")) {
            frmMenu.mFechaEmision.setText("Ingrese o seleccione una fecha");
            frmMenu.mFechaEmision.setForeground(Color.red);
            frmMenu.txtFechaEmsion.requestFocus();
            action = false;
        } else if (frmMenu.txtFechaCaducidad.getText().isEmpty()) {
            frmMenu.mFechaCaducidad.setText("Ingrese o seleccione una fecha");
            frmMenu.mFechaCaducidad.setForeground(Color.red);
            frmMenu.txtFechaCaducidad.requestFocus();
            action = false;
        }
        return action;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //  Evento boton registrarPerfilLaboral
        if (e.getSource().equals(frmMenu.btnRegistrarLicencia)) {
            boolean validarVacios = validarCamposVacios();
            if (validarVacios == false) {
                validarCamposVacios();
            } else {
//                DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                String numLicencia = frmMenu.txtNumLicencia.getText();
                String categoria = frmMenu.cboCategoriaLicencia.getSelectedItem().toString();
                Date fechaEmision = Date.valueOf(frmMenu.txtFechaEmsion.getText());//primero
                Date fechaCaducidad = Date.valueOf(frmMenu.txtFechaCaducidad.getText());
//                Date fechaIngreso = null;
//                try {
//                    fechaIngreso = format.parse(frmMenu.txtFechaIngreso.getText());
//                } catch (ParseException ex) {
//                }
//                Date fechaCese = (Date) frmMenu.txtFechaCese.getDate(); // date chooser jcalendar
//                Date fechaCese = null;
//                try {
//                    fechaCese = format.parse(frmMenu.txtFechaCese.getText());
//                } catch (ParseException ex) {
//                }
//                Date fechaCese = Date.valueOf(frmMenu.txtFechaCese1.getText());   // dateChooser custom      
                int idTrabajador = Integer.parseInt(frmMenu.txtIdTrabajadorLicencia.getText());
                lic = new Licencia(numLicencia, categoria, fechaEmision, fechaCaducidad, idTrabajador);
                if (licDAO.registrarLicencia(lic)) {
                    cargarTabla();
                    limpiarInputs();
                    JOptionPane.showMessageDialog(null, "Licencia registrada");
                }
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //  Eventos limitados por validaciones de tipeo
        if (e.getSource().equals(frmMenu.txtSueldo)) {
            Validaciones.soloDigitos(e);
        }
    }

    @Override
    public void keyPressed(KeyEvent ke) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        //  Eventos que al escribir contenido en cajas de texto, los mensajes de error se ocultan
        if (e.getSource().equals(frmMenu.txtSueldo)) {
            frmMenu.mSueldo.setText("");
        }
        //  Evento de seteo de datos con teclas arriba y abajo
        if (e.getSource().equals(frmMenu.tblPerfilLaboral)) {
            disableButtons();
            limpiarMensajesError();
            int fila = frmMenu.tblPerfilLaboral.getSelectedRow();
            int codPerfil = Integer.parseInt(frmMenu.tblPerfilLaboral.getValueAt(fila, 0).toString());
            frmMenu.txtCodPerfilLaboral.setText(String.valueOf(codPerfil));

            if (!frmMenu.txtCodPerfilLaboral.getText().isEmpty()) {
                int cod = Integer.parseInt(frmMenu.txtCodPerfilLaboral.getText());
                plab = plabDAO.consultarPerfil(cod);
                frmMenu.txtFechaIngreso.setText(String.valueOf(plab.getFechaIngreso()));
                frmMenu.cboArea.setSelectedItem(String.valueOf(plab.getArea()));
                frmMenu.txtSueldo.setText(String.valueOf(plab.getSueldo()));
                frmMenu.txtFechaCese.setText(String.valueOf(plab.getFechaCese()));
                frmMenu.txtMotivo.setText(String.valueOf(plab.getMotivoCese()));
                frmMenu.txtTrabajadorAsignadoPerfil.setText(String.valueOf(plab.getTrabajador()));
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //  Evento de clickeo en la caja de fechas
        if (e.getSource().equals(frmMenu.txtFechaIngreso)) {
            frmMenu.mFechaIngreso.setText("");
        }
        if (e.getSource().equals(frmMenu.txtFechaCese)) {
            frmMenu.mFechaCese.setText("");
        }
        //  Evento de clickeo para la tabla de perfilLaboral
        if (e.getSource().equals(frmMenu.tblPerfilLaboral)) {
            disableButtons();
            limpiarMensajesError();
            int fila = frmMenu.tblPerfilLaboral.getSelectedRow();
            int codPerfil = Integer.parseInt(frmMenu.tblPerfilLaboral.getValueAt(fila, 0).toString());
            frmMenu.txtCodPerfilLaboral.setText(String.valueOf(codPerfil));

            if (!frmMenu.txtCodPerfilLaboral.getText().isEmpty()) {
                int cod = Integer.parseInt(frmMenu.txtCodPerfilLaboral.getText());
                plab = plabDAO.consultarPerfil(cod);
                frmMenu.txtFechaIngreso.setText(String.valueOf(plab.getFechaIngreso()));
                frmMenu.cboArea.setSelectedItem(String.valueOf(plab.getArea()));
                frmMenu.txtSueldo.setText(String.valueOf(plab.getSueldo()));
                frmMenu.txtFechaCese.setText(String.valueOf(plab.getFechaCese()));
                frmMenu.txtMotivo.setText(String.valueOf(plab.getMotivoCese()));
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

        if (e.getSource().equals(frmMenu.btnSeleccionarTrabajadorPerfil)) {
            frmMenu.mTrabajadorAsignadoPerfil.setText("");
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
