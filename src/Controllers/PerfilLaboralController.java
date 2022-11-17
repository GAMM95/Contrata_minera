package Controllers;

import Models.CentrarColumnas;
import Models.PerfilLaboral;
import Models.PerfilLaboralDAO;
import Models.Trabajador;
import Models.TrabajadorDAO;
import Models.Validaciones;
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

public class PerfilLaboralController implements ActionListener, KeyListener, MouseListener {

    Trabajador trabajador = null;
    //  Instancias de clases
    private PerfilLaboral plab;
    private PerfilLaboralDAO plabDAO;
    private FrmMenu frmMenu;

    public PerfilLaboralController(PerfilLaboral plab, PerfilLaboralDAO plabDAO, FrmMenu frmMenu) {
        this.plab = plab;
        this.plabDAO = plabDAO;
        this.frmMenu = frmMenu;
        diseñarIntefaz();
        interfaces();
//        llenarCombo();
        cargarTabla();
        limpiarInputs();
        limpiarMensajesError();
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
        frmMenu.btnRegistrarPerfilLaboral.addActionListener(this);

        frmMenu.opOperaciones.addActionListener(this);
        frmMenu.opSeguridad.addActionListener(this);
        frmMenu.opAdministracion.addActionListener(this);
        frmMenu.opMantenimiento.addActionListener(this);
        frmMenu.opTransporte.addActionListener(this);

        //  Eventos MouseListener
        frmMenu.txtFechaIngreso.addMouseListener(this);
        frmMenu.txtFechaCese.addMouseListener(this);
        frmMenu.tblPerfilLaboral.addMouseListener(this);
        frmMenu.btnSeleccionarTrabajadorPerfil.addMouseListener(this);
        frmMenu.opOperaciones.addMouseListener(this);
        frmMenu.opSeguridad.addMouseListener(this);
        frmMenu.opAdministracion.addMouseListener(this);
        frmMenu.opMantenimiento.addMouseListener(this);
        frmMenu.opTransporte.addMouseListener(this);

        //  Eventos KeyListener
        frmMenu.txtSueldo.addKeyListener(this);
        frmMenu.tblPerfilLaboral.addKeyListener(this);
    }

    //  Metodo para activar botones
    private void enableButtons() {
        frmMenu.btnRegistrarPerfilLaboral.setEnabled(true);
    }

    //  Metodo para desactivar botones
    private void disableButtons() {
        frmMenu.btnRegistrarPerfilLaboral.setEnabled(false);
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
        int anchos[] = {10, 200, 30, 80, 30, 150};  //anchos de las columnas
        //  Diseño de la tabla Perfil Laboral
        DefaultTableModel model = (DefaultTableModel) frmMenu.tblPerfilLaboral.getModel();
        model.setRowCount(0);
        for (int i = 0; i < frmMenu.tblPerfilLaboral.getColumnCount(); i++) {
            frmMenu.tblPerfilLaboral.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
        frmMenu.tblPerfilLaboral.setDefaultRenderer(Object.class, new CentrarColumnas()); //    centrado de datos
        plabDAO.listarPerfilLaboral(model); // llamada del metodo dao listar
    }

    //  Metodo para limpiar inputs
    private void limpiarInputs() {
        frmMenu.txtIdTrabajadorPerfil.setText("");
        frmMenu.txtTrabajadorAsignadoPerfil.setText("");
        frmMenu.txtFechaIngreso.setText("");
        frmMenu.AreaPerfil.clearSelection();
        frmMenu.txtSueldo.setText("");
        frmMenu.txtFechaCese.setText("");
        frmMenu.txtMotivo.setText("");
    }

    //  Metodo para limpiar mensajes de error
    private void limpiarMensajesError() {
        frmMenu.mTrabajadorAsignadoPerfil.setText("");
        frmMenu.mFechaIngreso.setText("");
        frmMenu.mArea.setText("");
        frmMenu.mSueldo.setText("");
        frmMenu.mFechaCese.setText("");
        frmMenu.mMotivoCese.setText("");
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

    private void registrar(PerfilLaboral x) {
        plab.setFechaIngreso(x.getFechaIngreso());
        plab.setArea(x.getArea());
        plab.setSueldo(x.getSueldo());
        plab.setFechaCese(x.getFechaCese());
        plab.setMotivoCese(x.getMotivoCese());
        plab.setIdTrabajador(x.getIdTrabajador());

        plabDAO.registrarPerfil(x);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
//        if (e.getSource().equals(frmMenu.cboTrabajadorPerfil)) {
//            int id = frmMenu.cboTrabajadorPerfil.getSelectedIndex();
//            frmMenu.txtIdTrabajadorPerfil.setText(String.valueOf(id + 1));
//        }
        //  Ocultar mensaje de error de fechas
        if (e.getSource().equals(frmMenu.txtFechaIngreso)) {
            frmMenu.mFechaIngreso.setText("");
        }
        if (e.getSource().equals(frmMenu.txtFechaCese)) {
            frmMenu.mFechaCese.setText("");
        }
        //  Activar panel con check Box 
        if (e.getSource().equals(frmMenu.ckbCesarmientoTrabajador)) {
            if (frmMenu.ckbCesarmientoTrabajador.isSelected()) {
                habilitarPanelCese();
            } else {
                deshabilitarPanelCese();
            }
        }
        //  Evento boton registrarPerfilLaboral
        if (e.getSource().equals(frmMenu.btnRegistrarPerfilLaboral)) {
            boolean validarVacios = validarCamposVacios();
            if (validarVacios == false) {
                validarCamposVacios();
            } else {
                Date fechaIngreso = Date.valueOf(frmMenu.txtFechaIngreso.getText());
                String area;
                if (frmMenu.opOperaciones.isSelected()) {
                    area = "Operaciones";
                } else if (frmMenu.opSeguridad.isSelected()) {
                    area = "Seguridad";
                } else if (frmMenu.opAdministracion.isSelected()) {
                    area = "Administración";
                } else if (frmMenu.opMantenimiento.isSelected()) {
                    area = "Mantenimiento";
                } else {
                    area = "Transporte";
                }
                plab.setArea(area);
                double sueldo = Double.parseDouble(frmMenu.txtSueldo.getText());
                Date fechaCese = Date.valueOf(frmMenu.txtFechaCese.getText());
                String motivoCese = frmMenu.txtMotivo.getText();
                plab.setIdTrabajador(Integer.parseInt(frmMenu.txtIdTrabajadorPerfil.getText()));
//                plab.setFechaIngreso(Date.valueOf(frmMenu.txtFechaIngreso.getText()));
//                String area;
//                if (frmMenu.opOperaciones.isSelected()) {
//                    area = "Operaciones";
//                } else if (frmMenu.opSeguridad.isSelected()) {
//                    area = "Seguridad";
//                } else if (frmMenu.opAdministracion.isSelected()) {
//                    area = "Administración";
//                } else if (frmMenu.opMantenimiento.isSelected()) {
//                    area = "Mantenimiento";
//                } else {
//                    area = "Transporte";
//                }
//                plab.setArea(area);
//                plab.setSueldo(Double.parseDouble(frmMenu.txtSueldo.getText()));
//                plab.setFechaCese(Date.valueOf(frmMenu.txtFechaCese.getText()));
//                plab.setMotivoCese(frmMenu.txtMotivo.getText());
//                plab.setTrabajador(trabajador);
//                trabajador.setIdTrabajador(Integer.parseInt(frmMenu.txtIdTrabajadorPerfil.getText()));
//                if (trabajador != null) {
//                    plab = new PerfilLaboral(fechaIngreso, area, sueldo, fechaCese, motivoCese, trabajador);
                try {
                    registrar(plab);
                    JOptionPane.showMessageDialog(null, "Perfil registrado");
                    cargarTabla();
                    limpiarInputs();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Perfil no registrado" + ex.getMessage());
                }
//                } else {
//                    JOptionPane.showMessageDialog(null, "Asignacion nula");
//                }

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
                switch (plab.getArea()) {
                    case "Operaciones":
                        frmMenu.opOperaciones.setSelected(true);
                        break;
                    case "Seguridad":
                        frmMenu.opSeguridad.setSelected(true);
                        break;
                    case "Administración":
                        frmMenu.opAdministracion.setSelected(true);
                        break;
                    case "Mantenimiento":
                        frmMenu.opMantenimiento.setSelected(true);
                        break;
                    default:
                        frmMenu.opTransporte.setSelected(true);
                        break;
                }
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
                switch (plab.getArea()) {
                    case "Operaciones":
                        frmMenu.opOperaciones.setSelected(true);
                        break;
                    case "Seguridad":
                        frmMenu.opSeguridad.setSelected(true);
                        break;
                    case "Administración":
                        frmMenu.opAdministracion.setSelected(true);
                        break;
                    case "Mantenimiento":
                        frmMenu.opMantenimiento.setSelected(true);
                        break;
                    default:
                        frmMenu.opTransporte.setSelected(true);
                        break;
                }
                frmMenu.txtSueldo.setText(String.valueOf(plab.getSueldo()));
                frmMenu.txtFechaCese.setText(String.valueOf(plab.getFechaCese()));
                frmMenu.txtMotivo.setText(String.valueOf(plab.getMotivoCese()));
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //  Evento para desaparecer mensajes de error al clickear RadioButton
        if (e.getSource().equals(frmMenu.opOperaciones) || e.getSource().equals(frmMenu.opSeguridad) || e.getSource().equals(frmMenu.opAdministracion) || e.getSource().equals(frmMenu.opMantenimiento) || e.getSource().equals(frmMenu.opTransporte)) {
            frmMenu.mArea.setText("");
        }
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
